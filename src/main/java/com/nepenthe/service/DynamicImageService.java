package com.nepenthe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.DynamicImage;
import com.nepenthe.vo.DynamicVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LengAo
 * @since 2022-01-12
 */
public interface DynamicImageService extends IService<DynamicImage> {
    int addDynamicImage(DynamicImage dynamicImage);

    Integer deleteDynamic(@Param("dynamicId") Integer dynamicId);

    /**
     * @return 更新是否成功
     */
    Integer updateDynamic(@Param("dynamicId") DynamicDTO dynamicDTO);

    /**
     * @param userId 用户Id
     * @return 查询到的动态集合
     */
    List<DynamicVO> queryAllDynamicByUserId(@Param("userId") Integer userId);
}
