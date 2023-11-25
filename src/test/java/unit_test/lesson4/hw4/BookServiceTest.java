package unit_test.lesson4.hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BookServiceTest {

    // Чтобы не объявлять моки в каждом тесте
    @Mock
    private BookRepository mockBookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        // Инициализация моков перед каждым тестом
        MockitoAnnotations.initMocks(this);
        // Создание объекта BookService с использованием мок-объекта BookRepository
        bookService = new BookService(mockBookRepository);
    }

    @Test
    void testFindBookById() {
        String bookId = "1";
        Book expectedBook = new Book("1", "Book1", "Author1");
        // Установка поведения мок-объекта при вызове метода findById
        when(mockBookRepository.findById(bookId)).thenReturn(expectedBook);

        Book actualBook = bookService.findBookById(bookId);


        assertNotNull(actualBook);
        assertEquals(expectedBook, actualBook);
        // Проверка, был ли вызван метод findById с ожидаемыми параметрами
        verify(mockBookRepository).findById(bookId);
    }

    @Test
    void testFindAllBooks() {
        List<Book> expectedBooks = Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")
        );

        when(mockBookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findAllBooks();

        assertNotNull(actualBooks);
        assertEquals(expectedBooks.size(), actualBooks.size());  // Проверка, что количество элементов соответствует ожиданиям
        assertEquals(expectedBooks, actualBooks);  // Проверка, что результат соответствует ожиданиям
        verify(mockBookRepository).findAll();  // Проверка, был ли вызван метод findAll
    }
}
