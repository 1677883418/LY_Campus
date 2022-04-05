package com.nepenthe.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author GoodSir
 */
@Data
@ApiModel("回传动态图片对象")
public class DynamicImageVO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "动态Id")
    private Integer dynamicId;

    @ApiModelProperty(value = "图片地址")
    @TableField("image_url")
    private String imageUrl;

    @ApiModelProperty(value = "上传时间")
    private LocalDateTime imageTime;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
