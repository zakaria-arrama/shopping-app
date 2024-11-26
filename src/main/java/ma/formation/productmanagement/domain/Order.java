package ma.formation.productmanagement.domain;

import java.time.LocalDate;

public class Order {

    private Long id;
    private LocalDate orderDate;
    private Double totalPrice;

    // Relation avec Customer (clé étrangère)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getCustomer() {
        return customer;
    }

    public void setCustomer(Order customer) {
        this.customer = customer;
    }



}
