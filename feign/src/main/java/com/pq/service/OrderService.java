package com.pq.service;

import com.pq.domain.Order;
import com.pq.fallback.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-hi",fallback = OrderServiceFallback.class)
public interface OrderService {

    @RequestMapping("/query")
    public Order findOrderById(@RequestParam(value = "id")Integer id);

    @RequestMapping(value = "/save")
    public void saveOrUpdate(@RequestBody Order order);

    @RequestMapping("/delete")
    public boolean deleteOrder(@RequestParam(value = "id") Integer id);

    @RequestMapping("/queryAll")
    public List<Order> findAll();
}
