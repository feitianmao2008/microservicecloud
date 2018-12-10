package com.decard.springcloud.service;

import com.decard.springcloud.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author dcb 284850653@qq.com
 * @version 1.0
 * @description 类作用描述
 * @createDate 2018/12/10 17:15
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean add(Dept dept);

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable(value = "id") Long id);

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    List<Dept> list();
}
