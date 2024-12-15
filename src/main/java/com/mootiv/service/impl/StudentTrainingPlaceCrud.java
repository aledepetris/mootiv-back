package com.mootiv.service.impl;

import com.mootiv.domain.Equipment;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.EquipmentRepository;
import com.mootiv.repository.StudentRepository;
import com.mootiv.service.StudentTrainingPlaceService;
import com.mootiv.shared.TrainingPlaceRequest;
import com.mootiv.shared.TrainingPlaceResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.STUDENT_NOT_FOUND;

@Service
public class StudentTrainingPlaceCrud implements StudentTrainingPlaceService {

    private final StudentRepository studentRepository;
    private final EquipmentRepository equipmentRepository;

    public StudentTrainingPlaceCrud(StudentRepository studentRepository, EquipmentRepository equipmentRepository) {
        this.studentRepository = studentRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<TrainingPlaceResponse> getTrainingPlaces(Integer idStudent) {
        return studentRepository.findById(idStudent)
                .map(student -> student.getTrainingPlaces().stream()
                        .map(TrainingPlaceResponse::mapFrom)
                        .toList())
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));
    }

    @Override
    public void createTrainingPlace(Integer idStudent, TrainingPlaceRequest request) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        Set<Equipment> equipments = null;
        if (!request.getIdsEquipment().isEmpty())
            equipments = equipmentRepository.findListByIds(request.getIdsEquipment());

        student.addTrainingPlace(request.getName(), equipments);
        studentRepository.save(student);

    }

    @Override
    public void updateTrainingPlace(Integer idStudent, Integer idTrainingPlace, TrainingPlaceRequest request) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        Set<Equipment> equipments = null;
        if (!request.getIdsEquipment().isEmpty())
            equipments = equipmentRepository.findListByIds(request.getIdsEquipment());

        student.updateTrainingPlace(idTrainingPlace, request.getName(), equipments);
        studentRepository.save(student);
    }

    @Override
    public TrainingPlaceResponse getTrainingPlace(Integer idStudent, Integer idTrainingPlace) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        return TrainingPlaceResponse.mapFrom(student.getTrainingPlace(idTrainingPlace));
    }

    @Override
    public void deleteTrainingPlace(Integer idStudent, Integer idTrainingPlace) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        student.deleteTrainingPlace(idTrainingPlace);
        studentRepository.save(student);

    }

}
