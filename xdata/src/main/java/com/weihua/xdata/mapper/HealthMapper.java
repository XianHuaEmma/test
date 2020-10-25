package com.weihua.xdata.mapper;

import com.weihua.xdata.model.TempEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
@Mapper
@Repository
public interface HealthMapper {
    int save(TempEntity user);
}
