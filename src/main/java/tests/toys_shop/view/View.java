package tests.toys_shop.view;


import tests.toys_shop.presenter.Presenter;

/**
 * Интерфейс View представляет компонент представления в архитектуре MVP.
 * Он определяет методы для вывода текста и запуска представления.
 */
public interface View {

    void setPresenter(Presenter presenter);

    /**
     * Запускает представление.
     */
    void runProgram();
}
