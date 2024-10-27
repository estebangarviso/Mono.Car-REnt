package com.mono_car_rent.vehicle.use_case;

import com.mono_car_rent.vehicle.VehicleConditionStatus;

public interface ChangeConditionUseCase {
    public void changeCondition(VehicleConditionStatus newConditionStatus);
}
