package com.pq.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired Producer producer;


    @RequestMapping("send")
    public  String  test(@RequestParam String msg){
        System.out.println("send ： "+ msg);
         producer.sendMsg(msg);
        System.out.println();

        return  "SEND!";

    }

    @RequestMapping("sendAlL")
    public  String  test2(@RequestParam String msg){
        System.out.println("sendALL ： "+ msg);
        producer.sendAll(msg);


        return  "SEND!";

    }
}
