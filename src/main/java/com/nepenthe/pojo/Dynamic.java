package com.nepenthe.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dynamicTime;
}
