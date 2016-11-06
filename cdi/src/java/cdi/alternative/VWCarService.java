package cdi.alternative;

import cdi.inject.car.CarService;

import javax.enterprise.inject.Alternative;

@Alternative
public class VWCarService implements CarService {
    @Override
    public String getServiceStatus() {
        return "You chose VW auto service.";
    }
}
