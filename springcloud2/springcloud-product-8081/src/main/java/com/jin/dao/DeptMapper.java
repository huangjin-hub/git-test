package com.jin.dao;

import com.jin.entity.Dept;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface DeptMapper extends Mapper<Dept> {
    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();

}