package tests.nursery.registerAnimalApp.model.fileManage.interfaces;

public interface Loadable {
    /**
     * Загружает объект из файла
     *
     * @return загруженный объект
     */
    Object loadFile();

    void setFilePath(String filePath);
}
