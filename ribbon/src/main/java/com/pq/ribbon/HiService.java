package com.pq.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;



    //注解指定发生错误时的回调方法
   // @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        System.out.println("name  ----- "  + name  +" --- " +restTemplate );
     // return restTemplate.getForObject("http://localhost:8762/hi?name="+name,String.class);
       return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);

    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
