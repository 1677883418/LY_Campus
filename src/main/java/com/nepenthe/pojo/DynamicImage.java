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
public class DynamicImage {
    private Integer id;
    private Integer dynamicId;
    private String dynamicImageUrl;
    private String uploadTime;
}
