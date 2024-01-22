package tests.nursery.registerAnimalApp.model.register.animal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Animal {
    private String name;
    private Date birthDate;
    private List<String> commands;
    private String type = "Неизвестный вид";


    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Date getBirthDate() {
        return birthDate;
    }

}
