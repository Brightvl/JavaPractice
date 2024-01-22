package tests.nursery.registerAnimalApp.model.register.pet;

import tests.nursery.registerAnimalApp.model.register.animal.Educable;

import java.util.Date;

public class Dog extends Pet implements Educable {
    public Dog(String name, Date birthDate) {
        super(name, birthDate);
        super.setType("Dog");
    }

    @Override
    public void teachCommand(String command) {
        super.addCommand(command);
    }

    @Override
    public void showCommand() {
        System.out.println(super.getCommands());
    }
}
