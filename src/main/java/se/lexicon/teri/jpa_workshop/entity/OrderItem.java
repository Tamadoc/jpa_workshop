package se.lexicon.teri.jpa_workshop.entity;

import java.util.Objects;

public class OrderItem {
    private int id;
    private double quantity;
    private Product product;
    private ProductOrder productOrder;

    public OrderItem() {
    }

    public OrderItem(double quantity, Product product, ProductOrder productOrder) {
        this.quantity = quantity;
        this.product = product;
        this.productOrder = productOrder;
    }

    public OrderItem(int id, double quantity, Product product, ProductOrder productOrder) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.productOrder = productOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem appUser = (OrderItem) o;
        return id == appUser.id && Objects.equals(quantity, appUser.quantity) && Objects.equals(product, appUser.product) && Objects.equals(productOrder, appUser.productOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, product, productOrder);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity='" + quantity + '\'' +
                ", product='" + product + '\'' +
                ", productOrder='" + productOrder + '\'' +
                '}';
    }

    public double calculateItemPrice() {
        return product.getPrice() * quantity;
    }
}
