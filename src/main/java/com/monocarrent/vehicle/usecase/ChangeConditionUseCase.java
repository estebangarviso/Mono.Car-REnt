package com.monocarrent.vehicle.usecase;

import com.monocarrent.vehicle.VehicleConditionStatus;

public interface ChangeConditionUseCase {
    public void changeCondition(VehicleConditionStatus newConditionStatus);
}
