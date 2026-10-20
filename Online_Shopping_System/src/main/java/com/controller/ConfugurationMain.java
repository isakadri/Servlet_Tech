
package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Customer;
import com.entity.CustomerProfile;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;

public class ConfugurationMain {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Customer.class);
        cfg.addAnnotatedClass(CustomerProfile.class);
        cfg.addAnnotatedClass(Order.class);
        cfg.addAnnotatedClass(OrderItem.class);
        cfg.addAnnotatedClass(Product.class);

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession()) {

            Transaction tx = session.beginTransaction();

            try {
                // Create customer
                Customer customer = new Customer();
                customer.setUsrname("isa");
                customer.setPassword("123@123");

                // Create customer profile
                CustomerProfile profile = new CustomerProfile();
                profile.setName("Isa");
                profile.setAddress("Pune");

                // Connect profile and customer
                profile.setCustomer(customer);
                customer.setProfile(profile);

                // Create product
                Product product = new Product();
                product.setProductName("Laptop");
                product.setPrice(60000);

                // Create order
                Order order = new Order();
                order.setOrderName("Laptop Order");
                order.setOrderDate("2026-10-19");
                customer.addOrder(order);

                // Create order item
                OrderItem item = new OrderItem();
                item.setQuantity(1);
                item.setPrice(60000);
                item.setOrder(order);
                item.setProduct(product);

                order.addOrderItem(item);
                product.getOrderItems().add(item);

                // Save the complete object graph
                session.persist(customer);
                session.persist(product);

                tx.commit();

                System.out.println("Customer, profile, order, product, and order item saved successfully.");

            } catch (Exception e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }
    }
}
