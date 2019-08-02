package com.pq.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    HiService hiService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        System.out.println("name : "  +  name);
        return hiService.hiService(name);
    }
}
