package tests.toys_shop.model.fileManage.interfaces;

public interface Loadable {
    /**
     * Загружает объект из файла
     *
     * @return загруженный объект
     */
    Object loadFile();

    void setFilePath(String filePath);
}
