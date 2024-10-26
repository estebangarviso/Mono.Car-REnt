package com.monocarrent;

import com.monocarrent.rent.Rent;
import com.monocarrent.vehicle.Vehicle;
import com.monocarrent.common.enums.ConditionStatus;

public class App
{
    public static void main( String[] args )
    {
        Rent rent = new Rent();
        rent.doRent();
        Vehicle vehicle = new Vehicle('JCZL21','PEUGEOT','301',2017,'D');
        vehicle.changeCondition(ConditionStatus.ARRENDADO);
    }
}
