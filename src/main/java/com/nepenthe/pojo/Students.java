package com.nepenthe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author goodsir
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    private Integer id;
    private Integer studentId;
    private String name;
    private String idCard;
    private String className;
}
