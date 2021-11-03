package com.nepenthe.pojo;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author goodsir
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicImage {
    private Integer id;
    private Integer dynamicId;
    private String dynamicImageUrl;
    private LocalDateTime dynamicTime;
}
