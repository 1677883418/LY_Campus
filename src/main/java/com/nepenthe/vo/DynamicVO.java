package com.nepenthe.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nepenthe.pojo.DynamicImage;
import com.nepenthe.pojo.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author GoodSir
 */
@Data
@ApiModel("回传动态对象")
public class DynamicVO {
    @ApiModelProperty("动态id")
    private Integer id;

    @ApiModelProperty(value = "发动态用户")
    private UserVO user;

    @ApiModelProperty(value = "动态文本")
    private String dynamicText;

    @ApiModelProperty(value = "动态时间")
    private LocalDateTime dynamicTime;

    @ApiModelProperty(value = "动态图片集合")
    private List<DynamicImageVO> dynamicImages;

}
