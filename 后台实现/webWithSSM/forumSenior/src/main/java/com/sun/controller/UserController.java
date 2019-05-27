package com.sun.controller;

// slf4j.Logger

import com.sun.model.User;
import com.sun.model.UserExample;
import com.sun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;


@Controller
@RequestMapping("")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 增加用户，传入参数为id(String),username(String),type(String),orgName(String),Boolean(gender),avatarUrl(String)。
     * id为微信生成id，username为昵称，type为用户类型，orgName所属组织，gender，false为女性，true为男性。
     * 方法类型为POST，在content中传入json组装成的实体User
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User user) {
        user.setTs(new Timestamp(System.currentTimeMillis()));
        user.setCreatedate(new Timestamp(System.currentTimeMillis()));
        userService.postUser(user);
        return "add user success";
    }

    /**
     * 分页获取全部用户
     * 方法类型为Get，/user/{pageNum}/{pageSize}
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/user/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> selectAllUser(@PathVariable int pageNum, @PathVariable int pageSize) {
        UserExample userExample = new UserExample();
        List<User> userList = userService.getUsersByCondition(userExample,pageNum,pageSize);
        return userList;

        /*JSONObject json = new JSONObject();
        json.put("user", JSONObject.toJSON(user));
        return json.toJSONString();*/
    }

    /**
     * 获取单个用户，通过主键id进行查询
     * 方法类型为GET，参数为/user/{id}
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User selectUser(@PathVariable String id) {
        User user = userService.getUserById(id);
        return user;

        /*JSONObject json = new JSONObject();
        json.put("user", JSONObject.toJSON(user));
        return json.toJSONString();*/
    }

    /**
     * 更新单个用户，通过主键id进行更新
     * 方法类型为PUT，content中传入json封装User实体。通过主键id定位，非主属性进行更新操作
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User user) {
        user.setTs(new Timestamp(System.currentTimeMillis()));
        userService.putUser(user);
        return "update user success";
    }

    /**
     * 删除单个用户，通过主键id进行删除
     * 方法类型为DELETE，/user/{id}，content中传入id。
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "delete user success";
    }
}
