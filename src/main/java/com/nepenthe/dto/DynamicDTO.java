package com.nepenthe.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author GoodSir
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class DynamicDTO {
    @ApiModelProperty("用户Id")
    Integer userId;
    @ApiModelProperty("用户openId")
    String openId;
    @ApiModelProperty("动态内容")
    String dynamicText;
}
