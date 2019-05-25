package com.sun.controller;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  生成token
 *
 */

@RequestMapping("/token")
@Controller
public class TokenController {
    @ResponseBody
    @RequestMapping(value="/qiniu/{accessKey}/{secretKey}/{bucket}",method = RequestMethod.GET)
    public String qiniuToken(@PathVariable String accessKey,@PathVariable String secretKey,@PathVariable String bucket){
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        return upToken;

    }
}
