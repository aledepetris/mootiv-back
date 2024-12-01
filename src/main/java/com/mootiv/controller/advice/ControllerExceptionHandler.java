package com.mootiv.controller.advice;


import com.mootiv.error.ApiError;
import com.mootiv.error.ApiErrorResponse;
import com.mootiv.error.exception.BaseException;
import com.mootiv.error.exception.NotFoundException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Log4j2
@RestControllerAdvice
public class ControllerExceptionHandler {

	private static final String CAMPO = "Campo ";

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = INTERNAL_SERVER_ERROR)
	public ApiErrorResponse globalExceptionHandler(Exception ex, ServletWebRequest request) {
		return new ApiErrorResponse(request.getRequest().getRequestURI(), LocalDateTime.now(), List.of(TECHNICAL_ERROR));
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiErrorResponse runtimeExceptionHandler(RuntimeException ex, ServletWebRequest request) {
		var apiError = new ApiError(CODE_ERROR_TECNICO, getGenericErrorMessageAndCause(ex), ex.getMessage());
		return new ApiErrorResponse(request.getRequest().getRequestURI(), LocalDateTime.now(), List.of(apiError));
	}

	@ExceptionHandler(HandlerMethodValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiErrorResponse handlerMethodValidationExceptionHandler(HandlerMethodValidationException ex, ServletWebRequest request) {
		var errors = ex.getAllErrors().stream()
				.map(error -> {
					if (error instanceof DefaultMessageSourceResolvable resolvable) {
							final String field = ((DefaultMessageSourceResolvable) resolvable.getArguments()[0]).getDefaultMessage();
							return new ApiError(field + "_invalido",
									MessageFormat.format(CAMPO_CON_VALOR_INVALIDO_CUSTOM, field, error.getDefaultMessage()));
					} else {
						return new ApiError("ErrorTecnico", error.getDefaultMessage());
					}
				}).toList();

		return new ApiErrorResponse(request.getRequest().getRequestURI(), LocalDateTime.now(), errors);

	}


	/**
	 * Errores de Validaciones de los request con la anotacion ´@Valid´
	 * @param ex
	 * @param request
	 * @return ErrorMessage
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiErrorResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex, ServletWebRequest request) {

		final String requestURI = request.getRequest().getRequestURI();
		log.error("|* - [REQUEST INVALIDO] Se interrumpe el procesamiento de la petición: " + request.getRequest().getMethod() + " " + requestURI);
		List<ApiError> errors = ex.getBindingResult().getAllErrors().stream()
				.map(error -> {
					if (error instanceof FieldError fieldError) {
						if (NotNull.class.getSimpleName().equals(error.getCode())) {
							// @NotNull
							final String field = fieldError.getField();
							log.error("El campo {} es requerido, pero su valor es null", field);
							return new ApiError(field + "_requerido",
									MessageFormat.format(REQUIRED_FIELD, field));
						} else if (NotBlank.class.getSimpleName().equals(error.getCode())) {
							// @NotBlank
							final String field = fieldError.getField();
							log.error("El campo {} tiene un valor invalido: {}", field, fieldError.getRejectedValue());
							return new ApiError(field + "_requerido",
									MessageFormat.format(REQUIRED_FIELD, field));
						} else {
							// Custom annotation (example: @Canal)
							final String field = fieldError.getField();
							return new ApiError(field + "_invalido",
									MessageFormat.format(CAMPO_CON_VALOR_INVALIDO_CUSTOM, field, error.getDefaultMessage()));
						}
					} else {
						// ViolationObjectError para la validacion de @IdentificadorRequerido
						return new ApiError(error.getCode(), error.getDefaultMessage());
					}
				})
				.toList();

		return new ApiErrorResponse(request.getRequest().getRequestURI(), LocalDateTime.now(), errors);
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiErrorResponse bindExceptionHandler(BindException ex, ServletWebRequest request) {

		List<ApiError> errorList = new ArrayList<>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();

			if (Objects.requireNonNull(msg).contains("NumberFormatException"))
				msg = "Error al convertir el tipo de dato, revise el valor ingresado";

			ApiError apiError = new ApiError(fieldName, msg, CAMPO + fieldName + ": " + msg);
			errorList.add(apiError);
		}

		return new ApiErrorResponse(request.getRequest().getRequestURI(), LocalDateTime.now(), errorList);

	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiErrorResponse handleNotFoundException(NotFoundException ex, ServletWebRequest request) {
		return getApiErrorResponse(ex, request);
	}

	// Utilities
	private static ApiErrorResponse getApiErrorResponse(BaseException ex, ServletWebRequest request) {
		if (nonNull(ex.getApiError().getLogMessage())) {
			log.error("Ocurrio un error al procesar la solicitud:");
			log.error(ex.getApiError().getLogMessage());
		}
		List<ApiError> error = new ArrayList<>();
		error.add(ex.getApiError());
		return new ApiErrorResponse(request.getRequest().getRequestURI(), LocalDateTime.now(), error);
	}

	private String getGenericErrorMessageAndCause(Exception ex) {
		if (ex.getCause() != null) {
			return ex.getCause().toString() + ex.getMessage();
		}
		log.error("Ocurrio un error:  " + ex.getClass().toString());
		return "Exception: " + ex.getMessage();
	}

}
