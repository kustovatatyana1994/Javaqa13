package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(155, "Книга1", 500, "Иванов П.С.");
    Product item2 = new Smartphone(359, "Смартфон2", 15_000, "Sony");
    Product item3 = new Book(6, "Книга3", 780, "Петров И.И.");
    Product item4 = new Smartphone(47, "Смартфон4", 47_200, "GTS");


    @Test

    public void shouldFindSearchByNameSomeProducts() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item1, item3};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindSearchByNameOneProduct() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotFindSearchByNameProduct() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Телефон");

        Assertions.assertArrayEquals(expected, actual);
    }

}
