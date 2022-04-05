package com.nepenthe.pojo;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author LengAo
 * @since 2022-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Dynamic对象", description = "")
public class Dynamic extends Model<Dynamic> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "Id")
    private Integer id;

    @ApiModelProperty(value = "发动态用户id")
    private Integer userId;

    @ApiModelProperty(value = "动态文本")
    @TableField("dynamic_text")
    private String dynamicText;

    @ApiModelProperty(value = "动态时间")
    @TableField(value = "dynamic_time")
    private LocalDateTime dynamicTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
