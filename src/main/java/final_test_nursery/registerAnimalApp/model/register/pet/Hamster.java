package final_test_nursery.registerAnimalApp.model.register.pet;

import java.util.Date;

public class Hamster extends Pet{
    public Hamster(String name, Date birthDate) {
        super(name, birthDate);
        super.setType("Hamster");
    }
}
