package com.decard.springcloud.service.impl;

import com.decard.springcloud.dao.DeptDao;
import com.decard.springcloud.entities.Dept;
import com.decard.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/12/6.
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    public List<Dept> list() {
        return deptDao.findAll();
    }
}
