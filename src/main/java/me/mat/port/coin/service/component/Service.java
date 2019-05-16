package me.mat.port.coin.service.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mat
 *
 * Base Service class, performs services needed to be executed
 * during startup and after
 */
public abstract class Service implements IService {

    private static List<Service> allServices = new ArrayList<>();
    public static List<Service> getAllServices() { return allServices; }

    public Service()
    {
        getAllServices().add(this);
    }

    public void initService()
    {}
    public void closeService()
    {}

    public static void cleanServices()
    {
        getAllServices().forEach(service -> {
            if(service != null) service.closeService();
        });
    }




}
