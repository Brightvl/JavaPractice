package final_test_nursery.registerAnimalApp.model.register.packAnimal;

import model.register.animal.Educable;

import java.util.Date;

public class Donkey extends PackAnimal {
    public Donkey(String name, Date birthDate) {
        super(name, birthDate);
        super.setType("Donkey");
    }

}
