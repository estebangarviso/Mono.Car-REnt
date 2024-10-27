package com.mono_car_rent.vehicle;

public enum VehicleConditionStatus {
    DISPONIBLE('D', "Disponible"),
    ARRENDADO('A', "Arrendado"),
    EN_MANTENCION('M', "En Mantención");

    private final char codeStatus;
    private final String description;

    VehicleConditionStatus(char codeStatus, String description){
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