package com.mootiv.domain.plan;

public enum CycleStatus {

    BORRADOR,
    PENDIENTE,
    EN_PROGRESO,
    CANCELADO,
    COMPLETADO;

    public static boolean isValidValue(String value) {
        try {
            CycleStatus.valueOf(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
