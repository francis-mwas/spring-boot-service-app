package com.fram.Springbootdemo.controller;


import com.fram.Springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "hello mwas";
    }

    @GetMapping("/users")
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("Francis Mwangi");
        user.setEmail("mwas@gmail.com");
        return user;
    }
    @GetMapping("/users/{id}/{id2}")
    public String pathVariable(@PathVariable String id, @PathVariable("id2") String name){
        return "The passed path variable is: "+id + " and "+ name;
    }

    @GetMapping("/requestParams")
    public String requestParam(@RequestParam String name, @RequestParam(name="emailId", required = false, defaultValue = "") String email){
        return "The passed request parameter is: "+name +" and the email is: "+email;
    }
}
