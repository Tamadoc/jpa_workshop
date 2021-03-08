package se.lexicon.teri.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
class ProductOrderTest {

    ProductOrder testProductOrder;
    OrderItem orderItem1, orderItem2;

    @BeforeEach
    void setUp() {
        orderItem1 = orderItem2 = new OrderItem();
        LocalDate date = LocalDate.of(2021, 3, 3);
        List<OrderItem> orderItemsList = Arrays.asList(orderItem1, orderItem2);
        AppUser customer = new AppUser();

        testProductOrder = new ProductOrder(1, date, orderItemsList, customer);
    }

    @Test
    void getOrderItems() {
        List<OrderItem> expected = Arrays.asList(new OrderItem(), new OrderItem());
        List<OrderItem> actual = testProductOrder.getOrderItems();
        System.out.println(testProductOrder.getOrderItems());
        assertEquals(expected, actual);
    }

    @Test
    void setOrderItems() {
        testProductOrder.setOrderItems(Arrays.asList(new OrderItem(), new OrderItem(), new OrderItem()));
        List<OrderItem> expected = Arrays.asList(new OrderItem(), new OrderItem(), new OrderItem());
        List<OrderItem> actual = testProductOrder.getOrderItems();
        assertEquals(expected, actual);
    }

    @Test
    void getOrderDateTime() {
        LocalDate expected = LocalDate.of(2021, 3, 3);
        LocalDate actual = testProductOrder.getOrderDateTime();
        assertEquals(expected, actual);
    }

    @Test
    void setOrderDateTime() {
        testProductOrder.setOrderDateTime(LocalDate.of(2021, 1, 1));
        LocalDate expected = LocalDate.of(2021, 1, 1);
        LocalDate actual = testProductOrder.getOrderDateTime();
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        LocalDate date = LocalDate.of(2021, 3, 3);
        List<OrderItem> list = Arrays.asList(new OrderItem(), new OrderItem());
        AppUser customer = new AppUser();
        ProductOrder testProductOrder2 = new ProductOrder(1, date, list, customer);
        assertEquals(testProductOrder2, testProductOrder);
    }

    @Test
    @DisplayName("Adding order item")
    void test_addOrderItem() {
        Product product= new Product(1,"Test",100);
        OrderItem orderItem3= new OrderItem(30,30,product,testProductOrder);
        List<OrderItem> orderItems= new ArrayList<>();
        orderItems.add(orderItem3);

        testProductOrder.setOrderItems(orderItems);

        Assertions.assertTrue(testProductOrder.getOrderItems().contains(orderItem3));
    }

    @Test
    void test_removeOrderItem() {
        Product product= new Product(1,"Test",100);
        OrderItem orderItem3= new OrderItem(30,30,product,testProductOrder);
        List<OrderItem> orderItems= new ArrayList<>();
        orderItems.add(orderItem3);

        testProductOrder.setOrderItems(orderItems);

        testProductOrder.removeOrderItem(orderItem3);
        Assertions.assertFalse(testProductOrder.getOrderItems().contains(orderItem3));
    }

    @Test
    void test_calculateOrderPrice() {
        Product product1 = new Product(1, "Notebook", 100d);
        orderItem1.setProduct(product1);
        orderItem1.setQuantity(20);

        Product product2 = new Product(2, "Exercise book", 200d);
        orderItem2.setProduct(product2);
        orderItem2.setQuantity(10);

        double expected = 2000 + 2000;
        double actual = testProductOrder.calculateOrderPrice();
        assertEquals(expected, actual);
    }
}