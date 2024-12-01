package com.mootiv;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class MootivApplication {

	public static void main(String[] args) {
		SpringApplication.run(MootivApplication.class, args);
		log.info("=====================================================================================");
		log.info("=========================  FUNCIONANDO  =============================================");
		log.info("=====================================================================================");
	}

}
