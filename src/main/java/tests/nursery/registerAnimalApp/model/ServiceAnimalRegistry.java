package tests.nursery.registerAnimalApp.model;


import tests.nursery.registerAnimalApp.model.register.AnimalRegistry;
import tests.nursery.registerAnimalApp.model.register.animal.Animal;
import tests.nursery.registerAnimalApp.model.register.packAnimal.Camel;
import tests.nursery.registerAnimalApp.model.register.packAnimal.Donkey;
import tests.nursery.registerAnimalApp.model.register.packAnimal.Horse;
import tests.nursery.registerAnimalApp.model.register.pet.Cat;
import tests.nursery.registerAnimalApp.model.register.pet.Dog;
import tests.nursery.registerAnimalApp.model.register.pet.Hamster;
import tests.nursery.registerAnimalApp.model.register.animal.Educable;

import java.util.*;

/**
 *
 */
public class ServiceAnimalRegistry {


    private AnimalRegistry animalRegistry;

    /**
     *
     */
    public ServiceAnimalRegistry() {
        this.animalRegistry = new AnimalRegistry();
    }

    public boolean addAnimal(String type, String name, Date dateOfBirth) {
        type.toLowerCase();
        switch (type) {
            case "cat" -> {
                this.animalRegistry.addAnimal(new Cat(name, dateOfBirth));
                return true;
            }
            case "dog" -> {
                this.animalRegistry.addAnimal(new Dog(name, dateOfBirth));
                return true;
            }
            case "hamster" -> {
                this.animalRegistry.addAnimal(new Hamster(name, dateOfBirth));
                return true;
            }
            case "horse" -> {
                this.animalRegistry.addAnimal(new Horse(name, dateOfBirth));
                return true;
            }
            case "camel" -> {
                this.animalRegistry.addAnimal(new Camel(name, dateOfBirth));
                return true;
            }
            case "donkey" -> {
                this.animalRegistry.addAnimal(new Donkey(name, dateOfBirth));
                return true;
            }
            default -> {
                return false;
            }
        }
    }


    public List<String> getAnimalRegistryList() {
        List<String> list = new ArrayList<>();
        for (Animal animal : animalRegistry) {
            list.add("Вид:" + animal.getType() + " Кличка:" + animal.getName() + " Дата рождения:" + animal.getBirthDate());
        }
        return list;
    }


    public List<String> getPermissibleTypeOfAnimalsList() {
        return animalRegistry.getPermissibleTypeOfAnimalsList();
    }

    public List<String> getNamesAnimalsByType(String typeAnimal) {

        List<String> animalNameList = new ArrayList<>();
        for (Animal animal : animalRegistry) {
            if (animal.getType().equalsIgnoreCase(typeAnimal)) {
                animalNameList.add(animal.getName());
            }
        }
        return animalNameList;
    }

    public List<String> extractUniqueTypesAsList() {
        Set<String> uniqueTypes = new HashSet<>();
        for (Animal animal : animalRegistry.getAnimalList()) {
            uniqueTypes.add(animal.getType());
        }
        return new ArrayList<>(uniqueTypes);
    }

    public List<String> getListAnimalCommand(String typeAnimal, String nameAnimal) {
        List<String> commandList = new ArrayList<>();
        for (Animal animal : animalRegistry.getAnimalList()
        ) {
            if (animal.getType().equalsIgnoreCase(typeAnimal) && animal.getName().equalsIgnoreCase(nameAnimal)) {
                commandList.addAll(animal.getCommands());
            }
        }
        return commandList;
    }

    public boolean learnCommand(String typeAnimal, String nameAnimal, String command) {

        Animal animal = findAnimal(typeAnimal, nameAnimal);
        if (animal instanceof Educable trainer && !animal.getCommands().stream()
                .anyMatch(s -> s.equalsIgnoreCase(command))) {

            trainer.teachCommand(command.substring(0, 1).toUpperCase() + command.substring(1));
            return true;
        }
        return false;
    }


    private Animal findAnimal(String typeAnimal, String nameAnimal) {
        for (Animal animal : animalRegistry.getAnimalList()
        ) {
            if (typeAnimal.equalsIgnoreCase(animal.getType()) && nameAnimal.equalsIgnoreCase(animal.getName())) {
                return animal;
            }
        }
        return null;
    }

    public Map<String, Integer> getNumberOfAnimals() {
        Map<String, Integer> count = new HashMap<>(){{
            put("total", animalRegistry.getTotalNumberOfAnimals());
            put("pets", animalRegistry.getCountPets());
            put("packAnimals", animalRegistry.getCountPackAnimals());
        }};
        return count;
    }
}



