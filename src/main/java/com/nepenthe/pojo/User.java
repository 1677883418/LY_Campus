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
    private String nickName;
    private String avatarUrl;
    private String openId;
    private boolean isCard;
    private String cardId;
    private boolean isStudent;
    private Integer studentId;


}
