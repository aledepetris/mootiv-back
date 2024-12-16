package com.mootiv.domain.plan;

public enum TrainingWeekStatus {

    BORRADOR,
    PENDIENTE,
    EN_PROGRESO,
    POSPUESTA,
    CANCELEDA,
    COMPLETEDA;

    public static boolean isValidValue(String value) {
        try {
            TrainingWeekStatus.valueOf(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
