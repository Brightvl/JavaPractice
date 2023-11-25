package final_test_nursery.registerAnimalApp.model.register.pet;

import model.register.animal.Educable;


import java.util.Date;

public class Cat extends Pet implements Educable {
    public Cat(String name, Date birthDate) {
        super(name, birthDate);
        super.setType("Cat");
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
