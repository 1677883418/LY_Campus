package com.nepenthe.controller;

import com.nepenthe.pojo.Dynamic;
import com.nepenthe.service.DynamicService;
import com.nepenthe.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author goodsir
 */
@RestController
@RequestMapping("/Dynamic")
@Api(tags = "动态")
public class DynamicController {

    @Autowired
    @Qualifier("dynamicServiceImpl")
    private DynamicService dynamicService;

    @PostMapping("/addDynamic")
    @ApiOperation(value = "添加新动态", httpMethod = "POST", notes = "添加新动态")
    public Result<Dynamic> addDynamic(Dynamic dynamic) {
        return Result.ofSuccess(dynamicService.addDynamic(dynamic));
    }

    @GetMapping("/deleteDynamic")
    @ApiOperation(value = "删除动态", httpMethod = "GET", notes = "根据动态ID删除动态")
    public Result<Integer> deleteDynamic(Integer dynamicId) {
        return Result.ofSuccess(dynamicService.deleteDynamic(dynamicId));
    }

    @PostMapping("/updateDynamic")
    @ApiOperation(value = "修改动态", httpMethod = "POST", notes = "根据动态ID修改动态")
    public Result<Integer> updateDynamic(Integer dynamicId) {
        return Result.ofSuccess(dynamicService.updateDynamic(dynamicId));
    }

    @GetMapping("/queryAllDynamic/{userId}")
    @ApiOperation(value = "查询全部动态", httpMethod = "GET", notes = "根据用户ID查询全部动态")
    public Result<List<Dynamic>> queryAllDynamicByUserId(@PathVariable Integer userId) {
        return Result.ofSuccess(dynamicService.queryAllDynamicByUserId(userId));
    }
}
