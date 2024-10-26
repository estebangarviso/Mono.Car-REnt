package com.monocarrent.common.enums;

public enum ConditionStatus {
    DISPONIBLE('D', "Disponible"),
    ARRENDADO('A', "Arrendado"),
    EN_MANTENCION('M', "En Mantención");

    private char codeStatus;
    private String description;

    ConditionStatus(char codeStatus, String description){
        this.codeStatus = codeStatus;
        this.description = description;
    }

    char getCodeStatus(){
        return codeStatus;
    }

    String getDescription(){
        return description;
    }
}