package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product item1 = new Book(155, "Книга1", 500, "Иванов П.С.");
    Product item2 = new Smartphone(359, "Смартфон2", 15_000, "Sony");
    Product item3 = new Book(6, "Книга3", 780, "Петров И.И.");
    Product item4 = new Smartphone(47, "Смартфон4", 47_200, "GTS");


    @Test

    public void shouldFindAllProduct() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void removeOneProductById() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.removeById(6);

        Product[] expected = {item1, item2, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void removeSomeProductById() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.removeById(155);
        repo.removeById(6);

        Product[] expected = {item2, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void removeEveryoneProductById() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.removeById(155);
        repo.removeById(359);
        repo.removeById(6);
        repo.removeById(47);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
