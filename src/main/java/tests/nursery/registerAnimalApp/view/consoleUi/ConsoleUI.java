package tests.nursery.registerAnimalApp.view.consoleUi;


import tests.nursery.registerAnimalApp.presenter.Presenter;
import tests.nursery.registerAnimalApp.view.View;
import tests.nursery.registerAnimalApp.view.consoleUi.interactionConsole.ConsoleReader;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.typesMenu.AnimalMenu;
import tests.nursery.registerAnimalApp.view.consoleUi.menu.typesMenu.MainMenu;

import java.util.List;
import java.util.Map;

/**
 * ConsoleUI представляет консольный пользовательский интерфейс для приложения игрушечного магазина.
 * Он реализует интерфейс View и предоставляет методы для взаимодействия с пользователем через консоль.
 */
public class ConsoleUI implements View {


    private ConsoleReader consoleReader;
    private MainMenu mainMenu;
    private AnimalMenu animalMenu;
    private Presenter presenter;

    public ConsoleUI() {
        this.consoleReader = new ConsoleReader();
        this.mainMenu = new MainMenu(this);
        this.presenter = new Presenter();
    }


    /**
     * Метод runMainMenu() запускает главное меню.
     * Пользователю выводится список пунктов меню, и программа ожидает ввода выбранного пункта.
     * После выбора пункта меню происходит выполнение соответствующей команды.
     */
    @Override
    public void runProgram() {
        runMainMenu();
    }

    private void runMainMenu() {
        while (mainMenu.isRunning()) {
            showCountAnimals();
            consoleReader.println(mainMenu.printMenu());
            String choice = consoleReader.input("Выберите пункт меню: ");
            if (mainMenu.checkInputLineMenu(choice) == -1) {
                consoleReader.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(Integer.parseInt(choice));
        }
    }

    public void runAnimalMenu() {
        List<String> animalTypes = presenter.extractUniqueTypesAsList();

        if (animalTypes.isEmpty()) {
            consoleReader.println("В реестр еще не добавлены животные\n");
        } else {
            String animalType = consoleReader.input("Виды животных в реестре:\n" +
                    animalTypes + "\n Введите нужный вид -> ").trim();
            if (checkTypeAnimal(animalTypes, animalType)) {
                List<String> animalsNames = getNamesAnimalsByType(animalType);
                consoleReader.print(animalsNames);
                String animalName = consoleReader.input("\nВведите имя животного -> ").trim();
                if (checkNameAnimal(animalsNames, animalName)) {
                    this.animalMenu = new AnimalMenu(this, animalType, animalName);
                    while (animalMenu.isRunning()) {
                        consoleReader.println("Вид:" + animalType + " Кличка:" + animalName);
                        consoleReader.println(animalMenu.printMenu());
                        String choice = consoleReader.input("Выберите пункт меню: ");
                        if (animalMenu.checkInputLineMenu(choice) == -1) {
                            consoleReader.println("Ошибка ввода");
                            continue;
                        }
                        animalMenu.execute(Integer.parseInt(choice));
                    }
                } else {
                    consoleReader.println("Животное с именем '" + animalName + "' не найдено");
                }
            } else {
                consoleReader.println("Животное вида '" + animalType + "' не найдено");
            }
        }
    }


    public void ShowRegister() {
        List<String> animalRegistry = presenter.getListServiceAnimalRegistry();
        if (!animalRegistry.isEmpty()) {
            for (String string : animalRegistry) {
                consoleReader.println(string);
            }
        } else {
            consoleReader.println("Реестр животных пока пуст\n");
        }
    }

    public void addAnimal() {
        String typeOfAnimal = consoleReader.input(
                """
                        Виды животных которые можно добавить в реестр:
                        Домашние: Cat, Dog, Hamster
                        Вьючные: Horse, Donkey, Camel
                                        
                        Введите вид животного ->""" + " ").trim();
        ;
        if (checkTypeAnimal(presenter.getPermissibleTypeOfAnimalsList(), typeOfAnimal)) {

            String name = consoleReader.input("Введите кличку -> ").trim();
            String dateOfBirth = consoleReader.input("Введите дату рождения вида дд.мм.гггг").trim();
            boolean isTrue = presenter.addAnimal(typeOfAnimal, name, dateOfBirth);
            if (isTrue) {
                consoleReader.println("Животное добавлено в реестр");
            } else {
                consoleReader.println("Животное не добавлено в реестр");
            }
        } else {
            System.out.println("Вид животного не найден");
        }

    }

    private boolean checkTypeAnimal(List<String> typeOfAnimalRegister, String typeAnimal) {
        for (String _type : typeOfAnimalRegister) {
            if (typeAnimal.equalsIgnoreCase(_type)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkNameAnimal(List<String> namesOfAnimalRegister, String nameAnimal) {
        for (String name : namesOfAnimalRegister) {
            if (nameAnimal.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }


    public void ShowAnimalCommand() {
        List<String> animalCommand = presenter.getListAnimalCommand(animalMenu.getTypeAnimal(),
                animalMenu.getNameAnimal());
        if (animalCommand.isEmpty()) {
            consoleReader.println(animalMenu.getNameAnimal() + " пока вам не подчиняется");
        } else {
            System.out.println("Список команд:\n" + animalCommand + "\n");
        }
    }


    public void closeProgram() {
        mainMenu.setRunning(false);
    }


    public Presenter getPresenter() {
        return presenter;
    }

    public void learnCommand() {
        String command = consoleReader.input("Введите команду для изучения -> ").trim();

        if (presenter.learnCommand(animalMenu.getTypeAnimal(), animalMenu.getNameAnimal(), command)) {
            consoleReader.println("Ура '" + animalMenu.getNameAnimal() + "' выучил команду '" + command + "'");
        } else {
            consoleReader.println(animalMenu.getNameAnimal() + " не смог выучить команду");
        }
    }


    private List<String> getNamesAnimalsByType(String typeAnimal) {

        return presenter.getNamesAnimalsByType(typeAnimal);
    }

    private void showCountAnimals() {
        Map<String, Integer> count = presenter.getNumberOfAnimals();
        consoleReader.println("Всего животных в реестре:" + count.get("total") +
                ((count.get("pets") == 0) ? "" : " Домашних:" + count.get("pets")) +
                ((count.get("packAnimals") == 0) ? "" : " Вьючных:" + count.get("packAnimals")));
    }

}
