package com.mootiv;

import lombok.extern.log4j.Log4j2;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Log4j2
@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT1H")
@EnableJpaRepositories(basePackages = "com.mootiv.repository")
public class MootivApplication {

	public static void main(String[] args) {
		SpringApplication.run(MootivApplication.class, args);
		log.info("=====================================================================================");
		log.info("=========================  FUNCIONANDO  =============================================");
		log.info("=====================================================================================");
	}

}
