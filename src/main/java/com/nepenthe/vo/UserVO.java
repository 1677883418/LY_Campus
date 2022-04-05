package com.nepenthe.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GoodSir
 */
@Data
@ApiModel("回传User对象")
public class UserVO {
    @ApiModelProperty(value = "用户Id")
    private Integer userId;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像地址")
    private String avatarUrl;

}
