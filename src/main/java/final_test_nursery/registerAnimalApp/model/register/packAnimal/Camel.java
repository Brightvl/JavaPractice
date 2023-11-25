package final_test_nursery.registerAnimalApp.model.register.packAnimal;

import model.register.animal.Educable;

import java.util.Date;

public class Camel extends PackAnimal implements Educable {
    public Camel(String name, Date birthDate) {
        super(name, birthDate);
        super.setType("Camel");
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
