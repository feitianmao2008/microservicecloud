package com.decard.springcloud.controller;

import com.decard.springcloud.entities.Dept;
import com.decard.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2018/12/6.
 */
@RestController
public class DeptController_Consumer  {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable Long id) {
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptClientService.list();
    }

}
