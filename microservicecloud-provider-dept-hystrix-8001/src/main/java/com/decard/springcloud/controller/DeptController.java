package com.decard.springcloud.controller;

import com.decard.springcloud.entities.Dept;
import com.decard.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/12/6.
 */

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable Long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("没有找到id=" + id + "的对象");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable Long id) {
        Dept dept = new Dept();

        return dept;
    }

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("instance = " + instance);
                System.out.println("instance.getHost() = " + instance.getHost());
                System.out.println("instance.getScheme() = " + instance.getScheme());
                System.out.println("instance.getServiceId() = " + instance.getServiceId());
                System.out.println("instance.getPort() = " + instance.getPort());
                System.out.println("instance.getUri() = " + instance.getUri());
            }
            System.out.println("******************");
        }
        return services;
    }
}
