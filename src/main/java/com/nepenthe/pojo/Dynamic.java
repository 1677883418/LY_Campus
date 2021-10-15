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
public class Dynamic {
    private Integer id;
    private Integer userId;
    private String dynamicText;
    private String dynamicTime;
}
