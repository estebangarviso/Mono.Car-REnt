package com.monocarrent.common.enums;

public enum ConditionStatus {
    DISPONIBLE('D'),
    ARRENDADO('A'),
    EN_MANTENCION('M');

    ConditionStatus(char codeStatus){  //contructores codition
        this.codeStatus=codeStatus; //atributo
    }

    char getCodeStatus(){  // este metodo es un getter
        return codeStatus;
    }

    private char codeStatus;// declarar el atributo privado
}