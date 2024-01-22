package tests.nursery.registerAnimalApp.model.register.packAnimal;


import tests.nursery.registerAnimalApp.model.register.animal.Animal;

import java.util.Date;

public abstract class PackAnimal extends Animal {


    public PackAnimal(String name, Date birthDate) {
        super(name, birthDate);
    }

}
