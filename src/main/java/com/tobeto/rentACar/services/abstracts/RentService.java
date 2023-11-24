package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.rent.abstracts.AddRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.DeleteRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.UpdateRentRequest;

public interface RentService {
    void add(AddRentRequest request);
    void update(UpdateRentRequest request);
    void delete(DeleteRentRequest request);
}
