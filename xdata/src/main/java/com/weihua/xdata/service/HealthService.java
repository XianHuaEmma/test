package com.weihua.xdata.service;

import com.weihua.xdata.mapper.HealthMapper;
import com.weihua.xdata.model.TempEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
@Service
public class HealthService {

    @Autowired
    HealthMapper healthMapper;

    public void save(TempEntity user){
        healthMapper.save(user);
    }
}
