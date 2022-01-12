package com.nepenthe.controller;

import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.Dynamic;
import com.nepenthe.service.DynamicService;
import com.nepenthe.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
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
//    public Result<String> addDynamic(@RequestParam("imgBase64") JSONArray imgBase64, @RequestParam("dynamicText") String dynamicText, @RequestParam("openId") String openId, @RequestParam("userId") String userId) {
    //这个int其实不用反，前端也用不到
    public Result<Integer> addDynamic(@RequestBody DynamicDTO dynamicDTO) throws UnsupportedEncodingException {
        return Result.ofSuccess(dynamicService.addDynamic(dynamicDTO));
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
