package com.decard.springcloud.controller;

import com.decard.springcloud.entities.Dept;
import com.decard.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/12/6.
 */

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    @ResponseBody
    public List<Dept> list() {
        return deptService.list();
    }
}
