package com.nepenthe.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.nepenthe.pojo.ResultInfo;
import com.nepenthe.pojo.User;
import com.nepenthe.service.UserService;
import com.nepenthe.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author goodsir
 */
@RestController
@RequestMapping(value = "/User")
@Api(tags = "用户接口")
public class UserController {
    /**
     * controller 调 service层
     */
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 添加新用户
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "添加新用户", httpMethod = "POST", notes = "添加新用户")
    public Result<Object> addUser(@RequestBody User user) {
        userService.addUser(user);

        /* 直接返回成功即可，有问题直接在实现曾的方法里面抛异常或者返回失败消息
         * 例：在实现层返回 return Result.ofFail("注册失败,请检查信息后重试");
         */
        return Result.ofSuccess();
//        //判断添加是否成功
//        if (userService.addUser(user)) {
//            return new ResultInfo(1, "注册成功");
//        } else {
//            return new ResultInfo(0, "注册失败,请检查信息后重试");
//        }
    }

    /**
     * 根据openId查询用户信息
     */
    @GetMapping("/queryUserByopenId/{openId}")
    @ApiOperation(value = "查询用户", notes = "根据openId查询用户信息")
    public Result<User> queryUserByopenId(@PathVariable("openId") String openId) {
        /*同理也是直接返回*/
        return Result.ofSuccess(userService.queryUserByopenId(openId));
/*

        if (user != null) {
            return new ResultInfo(1, JSONUtil.toJsonStr(user));
        } else {
            return new ResultInfo(0, "未查询到该用户信息");
        }*/
    }

    /**
     * 根据jsCode获取登陆状态
     */
    @PostMapping("/login")
    @ApiOperation(value = "登陆",  notes = "获取登陆状态")
    public ResultInfo login(@ApiParam(name = "jsCode", value = "登录时获取的code") @RequestBody String jsCode) {
        //小程序appId和secret
        String appId = "wx3912bc23bde5849f";
        String secret = "f9d04bd4a21553bf55acd58b23855621";
        //获取用户token和openid
        String res = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code");
        JSONObject jsonObject = JSONUtil.parseObj(res);
        String openId = jsonObject.getStr("openid");
        //是否获取到openId
        if (openId != null) {
            return new ResultInfo(1, res);

        } else {
            return new ResultInfo(0, "登陆失败,请稍后重试");
        }
    }
}
