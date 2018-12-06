package com.decard.springcloud.service;

import com.decard.springcloud.entities.Dept;

import java.util.List;

/**
 * Created by Administrator on 2018/12/6.
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
