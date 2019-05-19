package com.sun.controller;



import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@RequestMapping("")
@Controller
public class LoginController {


    //根据小程序传过来的code来获取用户信息
    //https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code

    /**
     *
     * @param appid 小程序appid
     *
     * @param secret 小程序secret
     *
     * @param code 用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，
     *             使用code 换取 session_key api，将 code 换成 openid 和 session_key
     *
     * @return
     */
    @RequestMapping(value = "/login/{appid}/{secret}/{code}",method = RequestMethod.GET)
    @ResponseBody
    public String login(@PathVariable String appid,@PathVariable String secret,@PathVariable String code){

        if(code ==null){
            return "fail";
        }
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";


        String result = "";
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod(url);
        // 设置post请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        getMethod.addRequestHeader("Content-Type", "application/json");

        try {
            httpClient.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        getMethod.releaseConnection();
        // {"session_key":"XXXX","openid":"XXXX"}
        //return result;

        return result;
    }

}
