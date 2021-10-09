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
public class User {
    private Integer id;
    private String avatarUrl;
    private String openId;
    private Integer studentId;
    private String nikeName;


}
