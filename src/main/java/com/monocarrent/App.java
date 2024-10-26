package com.monocarrent;

import com.monocarrent.arriendo.Arriendo;
import com.monocarrent.vehiculo.Vehicle;
import com.monocarrent.common.enums.ConditionStatus;

public class App
{
    public static void main( String[] args )
    {
        Arriendo arriendo = new Arriendo();
        arriendo.arrendar();
        Vehicle vehicle = new Vehiculo('JCZL21','PEUGEOT','301',2017,'D');
        vehicle.changeCondition(ConditionStatus.ARRENDADO);
    }
}
