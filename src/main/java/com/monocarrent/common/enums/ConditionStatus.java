package com.monocarrent.common.enums;

public enum ConditionStatus {
    DISPONIBLE('D'),
    ARRENDADO,
    EN_MANTENCION;

    ConditionStatus(String codeStatus){
        this.codeStatus=codeStatus;
    }

    
}