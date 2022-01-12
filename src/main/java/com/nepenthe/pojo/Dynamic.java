package com.nepenthe.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author goodsir
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Dynamic {
    @ApiModelProperty("动态id")
    Integer id;
    @ApiModelProperty("用户id")
    Integer userId;
    @ApiModelProperty("动态内容")
    String dynamicText;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("动态时间")
    private LocalDateTime dynamicTime;
}
