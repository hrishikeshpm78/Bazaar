package com.example.user.controller;
import com.example.user.entity.AddressInfo;
import com.example.user.entity.Session;
import com.example.user.entity.UserInfo;
import com.example.user.model.AuthForm;
import com.example.user.model.SignupForm;
import com.example.user.service.AddressService;
import com.example.user.service.SessionService;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    SessionService sessionService;
    @Autowired
    AddressService addressService;

    @PostMapping(path="/user/login")
    public String login(@RequestBody AuthForm loginForm, HttpSession session){
        UserInfo result = userService.userLogin(loginForm);
        if(result == null)
            return "failure";
        else{
            Session newsession = new Session();
            newsession.setSession_id(session.getId());
            newsession.setUid(result.getUid());
            sessionService.setSession(newsession);
            return "success";
        }
    }

    @PostMapping(path="/user/signup")
    public String signup(@RequestBody SignupForm signupForm, HttpSession session){
        UserInfo result = userService.userSignup(signupForm);

        if(result == null)
            return "failure";
        else{
            Session newsession = new Session();
            newsession.setSession_id(session.getId());
            newsession.setUid(result.getUid());
            sessionService.setSession(newsession);
            return "success";
        }
    }

    @GetMapping(path="/user/getuser/{session_id}")
    public Integer getuser(@PathVariable String session_id){
        return sessionService.readSession(session_id).getUid();
    }

    @GetMapping(path="/user/getalladdress")
    public String getalladdresss(HttpSession session){
        Integer uid = getuser(session.getId());
        System.out.println(uid);
        List<String> addresses = addressService.readAddressAll(uid);
        System.out.println(addresses.get(0));
        return addresses.get(0);
    }

    @PostMapping(path="/user/address/add")
    public AddressInfo addadddress(@RequestParam String address, HttpSession session){
        Integer uid = sessionService.readSession(session.getId()).getUid();
        AddressInfo newadd = new AddressInfo();
        newadd.setAddress(address);
        newadd.setUid(uid);
        return addressService.addAddress(newadd);
    }

    @DeleteMapping(path="/user/address/delete")
    public String deleteaddress(@RequestParam String address, HttpSession session){
        Integer uid = sessionService.readSession(session.getId()).getUid();
        AddressInfo deladd = new AddressInfo();
        deladd.setAddress(address);
        deladd.setUid(uid);
        addressService.deleteAddress(deladd);
        return "done";
    }

}
