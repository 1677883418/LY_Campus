package com.nepenthe.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GoodSir
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class DynamicImageDTO {
    @ApiModelProperty("动态图片id")
    Integer id;
    @ApiModelProperty("动态id")
    Integer dynamicId;
    @ApiModelProperty(value = "图片地址")
    private String imageUrl;
    @ApiModelProperty("图片排序")
    Integer sort;
}
