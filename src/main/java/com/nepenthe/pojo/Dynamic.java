package com.nepenthe.pojo;

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
public class Dynamic {
    private Integer id;
    private Integer userid;
    private String dynamicText;
    private LocalDateTime dynamicTime;

}
