package se.lexicon.teri.jpa_workshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate orderDateTime;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "productOrder",
            orphanRemoval = true
    )
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "app_user_id")
    private AppUser customer;

    public ProductOrder() {
    }

    public ProductOrder(int id, LocalDate orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this.id = id;
        this.orderDateTime = orderDateTime;
        this.orderItems = orderItems;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDate orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDateTime, orderItems, customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOrder appUser = (ProductOrder) o;
        return id == appUser.id && Objects.equals(orderDateTime, appUser.orderDateTime) && Objects.equals(orderItems, appUser.orderItems) && Objects.equals(customer, appUser.customer);
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", orderDateTime='" + orderDateTime + '\'' +
                ", orderItems='" + orderItems + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }

    /**
     * Convenience method
     * Add in a bidirectional manner
     * Adds orderItem to ProductOrder and productOrder to OrderItem
     *
     * @param orderItem
     */
    public void addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }

        orderItems.add(orderItem);
        orderItem.setProductOrder(this);
    }

    /**
     * Convenience method
     * Remove in a bidirectional manner
     * Removes orderItem to ProductOrder and productOrder to OrderItem
     *
     * @param orderItem
     */
    public void removeOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }

        if (orderItem == null) {
            throw new IllegalArgumentException("orderItem is null");
        }
        orderItem.setProductOrder(null);
        orderItems.remove(orderItem);
    }

    public double calculateOrderPrice() {
        double orderPrice = 0.0d;
        for (OrderItem orderItem : orderItems) {
            orderPrice += orderItem.calculateItemPrice();
        }
        return orderPrice;
    }
}
