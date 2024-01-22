package tests.nursery.registerAnimalApp.presenter;



import tests.nursery.registerAnimalApp.model.ServiceAnimalRegistry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Presenter {

    private ServiceAnimalRegistry serviceAnimalRegistry;

    public Presenter() {
        this.serviceAnimalRegistry = new ServiceAnimalRegistry();
    }

    public List<String> getListServiceAnimalRegistry() {
        return serviceAnimalRegistry.getAnimalRegistryList();
    }
    public List<String> getNamesAnimalsByType(String typeAnimal) {
        return serviceAnimalRegistry.getNamesAnimalsByType(typeAnimal);
    }

    public ServiceAnimalRegistry getServiceAnimalRegistry() {
        return serviceAnimalRegistry;
    }


    public boolean addAnimal(String type, String name, String dateOfBirth) {
        return serviceAnimalRegistry.addAnimal(type, name, checkDate(dateOfBirth));
    }

    public List<String> getPermissibleTypeOfAnimalsList() {
        return serviceAnimalRegistry.getPermissibleTypeOfAnimalsList();
    }

    private Date checkDate(String dateStr) {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.err.println("Неправильный формат даты,");

        }
        return date;
    }

    public List<String> extractUniqueTypesAsList() {
        return serviceAnimalRegistry.extractUniqueTypesAsList();
    }

    public List<String> getListAnimalCommand(String typeAnimal, String nameAnimal) {
        return serviceAnimalRegistry.getListAnimalCommand(typeAnimal, nameAnimal);
    }

    public boolean learnCommand(String typeAnimal, String nameAnimal, String command) {
        return serviceAnimalRegistry.learnCommand(typeAnimal, nameAnimal, command);
    }

    public Map<String, Integer> getNumberOfAnimals() {
        return serviceAnimalRegistry.getNumberOfAnimals();
    }
}
