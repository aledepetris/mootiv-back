package com.mootiv.job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Clase que representa la entidad para la tabla "shedlock" con motivo de control/auditoria de tareas del Scheduler
 */
@Getter @Setter
@Entity @Table(name = "shedlock")
public class Shedlock {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "lock_until")
    private Timestamp lockUntil;

    @Column(name = "locked_at")
    private Timestamp lockedAt;

    @Column(name = "locked_by")
    private String lockedBy;

}
