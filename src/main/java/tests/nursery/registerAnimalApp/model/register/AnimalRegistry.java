package tests.nursery.registerAnimalApp.model.register;


import tests.nursery.registerAnimalApp.model.register.animal.Animal;
import tests.nursery.registerAnimalApp.model.register.packAnimal.PackAnimal;
import tests.nursery.registerAnimalApp.model.register.pet.Pet;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimalRegistry implements Iterable<Animal>{

    private List<Animal> animalList;
    private int countPets = 0;
    private int countPackAnimals = 0;
    private int totalNumberOfAnimals = 0;
    private List<String> permissibleTypeOfAnimalsList = new ArrayList<>() {
        {
            {
                add("Cat");
                add("Hamster");
                add("Dog");
                add("Horse");
                add("Donkey");
                add("Camel");
            }
        }
    };

    public AnimalRegistry() {
        this.animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        this.animalList.add(animal);
        counterAnimal(animal);
    }


    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<String> getPermissibleTypeOfAnimalsList() {
        return permissibleTypeOfAnimalsList;
    }

    @Override
    public String toString() {
        return "AnimalRegistry{" +
                "animalList=" + animalList +
                '}';
    }

    @Override
    public Iterator<Animal> iterator() {
        return animalList.iterator();
    }

    private void counterAnimal(Animal animal) {
        if (animal instanceof Pet) {
            this.countPets++;
        }
        if (animal instanceof PackAnimal) {
            this.countPackAnimals++;
        }
        this.totalNumberOfAnimals = this.countPackAnimals + this.countPets;
    }

    public int getCountPets() {
        return countPets;
    }

    public int getCountPackAnimals() {
        return countPackAnimals;
    }

    public int getTotalNumberOfAnimals() {
        return totalNumberOfAnimals;
    }
}
