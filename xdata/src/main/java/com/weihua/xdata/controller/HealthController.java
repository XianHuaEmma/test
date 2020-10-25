package com.weihua.xdata.controller;

import com.alibaba.fastjson.JSONObject;
import com.weihua.xdata.model.TempEntity;
import com.weihua.xdata.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
@RestController
@RequestMapping("/rest/xdata/healthcheck")
public class HealthController {

    @Autowired
    HealthService service;

    @RequestMapping("/check")
    public String check(){
        return "hello";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public void add(@RequestBody String data) {
        TempEntity user = JSONObject.parseObject(data, TempEntity.class);
        service.save(user);
    }

}
