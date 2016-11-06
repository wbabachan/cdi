package cdi.inject.car;

public class BMWCarService implements CarService {
    
    @Override
    public String getServiceStatus() {
        return "You chose BMW auto service.";
    }
}
