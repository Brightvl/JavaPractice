package tests.nursery.registerAnimalApp.model.register.pet;



import tests.nursery.registerAnimalApp.model.register.animal.Animal;

import java.util.Date;

public abstract class Pet extends Animal {


    public Pet(String name, Date birthDate) {
        super(name, birthDate);

    }

}
