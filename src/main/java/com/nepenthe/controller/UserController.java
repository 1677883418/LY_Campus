package com.nepenthe.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.nepenthe.pojo.User;
import com.nepenthe.service.UserService;
import com.nepenthe.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author goodsir
 */
@RestController
@RequestMapping(value = "/User")
@Api(tags = "用户接口")
public class UserController {

    @Value("${wx.appId}")
    String appId;
    @Value("${wx.secret}")
    String secret;
    /**
     * controller 调 service层
     */
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    /**
     * 添加新用户
     *
     * @return
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "添加新用户", httpMethod = "POST", notes = "添加新用户")
    public Result<Integer> addUser(@RequestBody User user) {
        System.out.println(user);
        /*
        User user = JSONUtil.toBean(res, User.class);
        直接返回成功即可，有问题直接在实现层的方法里面抛异常或者返回失败消息
        例：在实现层返回 return Result.ofFail("注册失败,请检查信息后重试");
        */
        return Result.ofSuccess(userService.addUser(user));
    }

    /**
     * 根据openId查询用户信息
     */

    @GetMapping("/queryUserByOpenId/{openId}")
    @ApiOperation(value = "查询用户", notes = "根据openId查询用户信息")
    public Result<User> queryUserByOpenId(@PathVariable("openId") String openId) {

        /*同理也是直接返回*/
        return Result.ofSuccess(userService.queryUserByOpenId(openId));
    }

    /**
     * 根据jsCode获取登陆状态
     */
    @PostMapping("/login")
    @ApiOperation(value = "登陆", notes = "获取登陆状态")
    public Result<JSONObject> login(@ApiParam(name = "jsCode", value = "登录时获取的code") @RequestBody JSONObject jsCode) {
        //获取用户token和openid
        String res = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + jsCode.getStr("jsCode") + "&grant_type=authorization_code");
        //返回获取到的openId和token
        return Result.ofSuccess(JSONUtil.parseObj(res));
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    public Result<Integer> updateUser(@ApiParam(name = "user", value = "要修改的对象") @RequestBody User user) {
        System.out.println(user);
        return Result.ofSuccess(userService.updateUser(user));
    }
}
