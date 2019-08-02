package com.pq.client2.controller;


import com.pq.client2.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pq.client2.service.OrderService;

import java.util.List;

@RestController
public class OrderController {



    @Value("${server.port}")
    String port;

    @Autowired
    OrderService orderService;

    @RequestMapping("/save")
    public String save(@RequestParam Integer id,@RequestParam String name, @RequestParam String dec) {
         Order order =new Order(id,name,dec);
         orderService.saveOrUpdate(order);
        return " port: " +port +" "+ order.toString() ;
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
        return  orderService.deleteOrder(id);
    }
}
