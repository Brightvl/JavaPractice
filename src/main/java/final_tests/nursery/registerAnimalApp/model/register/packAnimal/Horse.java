package final_tests.nursery.registerAnimalApp.model.register.packAnimal;

import final_tests.nursery.registerAnimalApp.model.register.animal.Educable;

import java.util.Date;

public class Horse extends PackAnimal implements Educable {
    public Horse(String name, Date birthDate) {
        super(name, birthDate);
        super.setType("Horse");
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
