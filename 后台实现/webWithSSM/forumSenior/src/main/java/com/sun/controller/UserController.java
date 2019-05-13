package com.sun.controller;

// slf4j.Logger

import com.alibaba.fastjson.JSONObject;
import com.sun.model.User;
import com.sun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User user) {
        userService.postUser(user);
        return "add";
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User selectUser(@PathVariable String id) {
        User user = userService.getUserById(id);
        return user;

        /*JSONObject json = new JSONObject();
        json.put("user", JSONObject.toJSON(user));
        return json.toJSONString();*/
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User user) {
        userService.putUser(user);
        return "update";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "delete";
    }
}
