package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repo.ProdRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProdManagerTest {
    private ProdRepo repo = new ProdRepo();
    private ProdManager manager = new ProdManager(repo);
    private Product first = new Book(1, "IPhone", 157.20, "Войнич");
    private Product second = new Book(2, "Алиса", 102.30, "Неизвестный");
    private Product third = new Book(3, "Оливия Летам", 758.70, "Войнич");
    private Product fourth = new Smartphone(4, "IPhone 13", 157000.50, "Apple");
    private Product fifth = new Smartphone(5, "IPhone 13 Pro", 20000.05, "Apple");
    private Product sixth = new Smartphone(5, "Mate 40 Pro", 45000.10, "Huawei");

    @BeforeEach
    void data() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void shouldSearchByName() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Алиса");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = new Product[]{first, third};
        Product[] actual = manager.searchBy("Войнич");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = new Product[]{fourth, fifth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameModel() {
        Product[] expected = new Product[]{first, fourth, fifth};
        Product[] actual = manager.searchBy("IPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchEmpty() {
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        Product[] actual = manager.searchBy("");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchEmptySearch() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Май");
        assertArrayEquals(expected, actual);
    }

}


