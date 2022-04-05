package com.nepenthe.controller;

import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.Dynamic;
import com.nepenthe.service.DynamicService;
import com.nepenthe.utils.Result;
import com.nepenthe.vo.DynamicVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author goodsir
 */
@RestController
@RequestMapping("/Dynamic")
@Api(tags = "动态")
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;

    @PostMapping("/addDynamic")
    @ApiOperation(value = "添加新动态", httpMethod = "POST", notes = "添加新动态")
    public Result<Object> addDynamic(@RequestBody DynamicDTO dynamicDTO) {
        Dynamic dynamic = new Dynamic();
        BeanUtils.copyProperties(dynamicDTO, dynamic);
        dynamic.setDynamicTime(LocalDateTime.now());
        dynamicService.addDynamic(dynamic);
        return Result.ofSuccess(dynamic);
    }

    @GetMapping("/deleteDynamic")
    @ApiOperation(value = "删除动态", httpMethod = "GET", notes = "根据动态ID删除动态")
    public Result<Integer> deleteDynamic(Integer dynamicId) {
        return Result.ofSuccess(dynamicService.deleteDynamic(dynamicId));
    }

    @PostMapping("/updateDynamic")
    @ApiOperation(value = "修改动态", httpMethod = "POST", notes = "根据动态ID修改动态")
    public Result<Integer> updateDynamic(DynamicDTO dynamicDTO) {
        return Result.ofSuccess(dynamicService.updateDynamic(dynamicDTO));
    }

    @GetMapping("/queryAllDynamicByUserId/{userId}")
    @ApiOperation(value = "查询全部动态", httpMethod = "GET", notes = "根据用户ID查询全部动态")
    public Result<List<DynamicVO>> queryAllDynamicByUserId(@PathVariable Integer userId) {
        return Result.ofSuccess(dynamicService.queryAllDynamicByUserId(userId));
    }

    @GetMapping("/queryAllDynamic")
    @ApiOperation(value = "查询全部动态", httpMethod = "GET", notes = "根据用户ID查询全部动态")
    public Result<List<DynamicVO>> queryAllDynamic() {
        return Result.ofSuccess(dynamicService.queryAllDynamic());
    }
}
