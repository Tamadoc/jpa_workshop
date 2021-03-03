package se.lexicon.teri.jpa_workshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product(1, "Notebook", 98d);
    }

    @Test
    void getName() {
        String expected = "Notebook";
        String actual = testProduct.getName();
        assertEquals(expected,actual);
    }

    @Test
    void setName() {
        testProduct.setName("Exercise book");
        String expected = "Exercise book";
        String actual = testProduct.getName();
        assertEquals(expected,actual);
    }

    @Test
    void getPrice() {
        double expected = 98;
        double actual = testProduct.getPrice();
        assertEquals(expected,actual);
    }

    @Test
    void setPrice() {
        testProduct.setPrice(125);
        double expected = 125;
        double actual = testProduct.getPrice();
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        Product testProduct2 = new Product(1, "Notebook", 98d);
        assertEquals(testProduct, testProduct2);
    }
}