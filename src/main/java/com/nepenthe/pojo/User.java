package com.nepenthe.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author goodsir
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("微信用户")
public class User {
    @ApiModelProperty("用户id")
    Integer id;
    @ApiModelProperty("昵称")
    String nickName;
    @ApiModelProperty("头像链接")
    private String avatarUrl;
    @ApiModelProperty("登录唯一凭证")
    private String openId;
}
