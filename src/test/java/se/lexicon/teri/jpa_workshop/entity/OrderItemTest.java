package se.lexicon.teri.jpa_workshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderItemTest {

    AppUser testUser;
    Product testProduct1;
    Product testProduct2;
    OrderItem testOrderItem;
    ProductOrder testProductOrder;

    @BeforeEach
    void setUp() {
        testProduct1 = new Product(1, "Notebook", 100d);
        testProduct2 = new Product(2, "Exercise book", 115d);

        testUser = new AppUser(1, "Teri", "Sandstedt", "test@test.com");

        testProductOrder = new ProductOrder();
        testProductOrder.setId(1);

        testOrderItem = new OrderItem(1, 15, testProduct1, testProductOrder);
    }

    @Test
    void getQuantity() {
        double expected = 15;
        double actual = testOrderItem.getQuantity();
        assertEquals(expected, actual);
    }

    @Test
    void setQuantity() {
        testOrderItem.setQuantity(30);
        double expected = 30;
        double actual = testOrderItem.getQuantity();
        assertEquals(expected, actual);
    }

    @Test
    void getProduct() {
        Product expected = testProduct1;
        Product actual = testOrderItem.getProduct();
        assertEquals(expected, actual);
    }

    @Test
    void setProduct() {
        testOrderItem.setProduct(testProduct2);
        Product expected = testProduct2;
        Product actual = testOrderItem.getProduct();
        assertEquals(expected, actual);
    }

    @Test
    void getProductOrder() {
        int expected = 1;
        int actual = testOrderItem.getProductOrder().getId();
        assertEquals(expected, actual);
    }

    @Test
    void setProductOrder() {
        ProductOrder productOrder2 = new ProductOrder();
        productOrder2.setId(1);
        testOrderItem.setProductOrder(productOrder2);
        int expected = 1;
        int actual = testOrderItem.getProductOrder().getId();
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        OrderItem testOrderItem2 = new OrderItem(1, 15, testProduct1, testProductOrder);
        assertEquals(testOrderItem2, testOrderItem);
    }

    @Test
    void calculateItemPrice() {
        double expected = 1500d;
        double actual = testOrderItem.calculateItemPrice();
        assertEquals(expected, actual);
    }
}