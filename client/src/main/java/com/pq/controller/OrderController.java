package com.pq.controller;

import com.pq.domain.Order;
import com.pq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {



    @Value("${server.port}")
    String port;

    @Autowired
    OrderService orderService;

    @RequestMapping("/save")
    public String save(@RequestBody Order order) {
         orderService.saveOrUpdate(order);
        return order.toString() ;
    }
    @RequestMapping("/query")
    public Order query(@RequestParam Integer id) {

        return orderService.findOrderById(id);
    }
    @RequestMapping("/queryAll")
    public List<Order> queryAll() {

        return orderService.findAll();
    }
    @RequestMapping("/delete")
    public boolean delete(@RequestParam Integer id) {

        return orderService.deleteOrder(id);
    }
}
