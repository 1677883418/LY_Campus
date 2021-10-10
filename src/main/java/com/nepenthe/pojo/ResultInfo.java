package com.nepenthe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author goodsir
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    /**
     * 状态码
     * 信息
     * 返回的json对象实体类
     */
    private int code;
    private String msg;
}
