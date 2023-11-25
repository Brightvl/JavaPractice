package final_tests.nursery.registerAnimalApp.model.register.packAnimal;

import java.util.Date;

public class Donkey extends PackAnimal {
    public Donkey(String name, Date birthDate) {
        super(name, birthDate);
        super.setType("Donkey");
    }

}
