package com.pq.fallback;

import com.pq.domain.Order;
import com.pq.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceFallback implements OrderService {


    @Override
    public Order findOrderById(Integer id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Order order) {
        System.out.println("saveOrUpdate error!");
    }

    @Override
    public boolean deleteOrder(Integer id) {

        System.out.println("deleteOrder error!");

        return false;
    }

    @Override
    public List<Order> findAll() {

        System.out.println("findAll error!");

        return null;
    }
}
