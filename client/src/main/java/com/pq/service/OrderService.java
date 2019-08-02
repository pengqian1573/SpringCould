package com.pq.service;

import com.pq.domain.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

   static  Map<Integer , Order> orderMap = new HashMap<>();

    static {

        Order order1= new Order(1,"A","钻石");
        Order order2= new Order(2,"B","元宝");
        Order order3= new Order(3,"C","金币");
        Order order4= new Order(4,"D","符石");
        orderMap.put(order1.getId(),order1);
        orderMap.put(order2.getId(),order2);
        orderMap.put(order3.getId(),order3);
        orderMap.put(order4.getId(),order4);

    }


    public Order findOrderById(Integer id){
        System.out.println( " findOrder : " + id);
       return  orderMap.get(id);

    };
    public void saveOrUpdate(Order order){
        System.out.println( " saveOrder : " + order.toString());
        orderMap.put(order.getId(),order);
    };

    public boolean deleteOrder(Integer id){
        System.out.println( " deleteOrder : " + id);
        try {
            orderMap.remove(id);
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        return  true;
    };

    public List<Order> findAll(){
        List<Order> list =  new ArrayList<>(orderMap.values());
        return list;
    }

}
