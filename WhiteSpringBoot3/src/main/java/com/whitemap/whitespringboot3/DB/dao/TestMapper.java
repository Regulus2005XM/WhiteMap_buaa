package com.whitemap.whitespringboot3.DB.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //在运行时，会自动生成该接口的实现类对象(代理对象)，
// 并且将该对象交给IOC容器管理
public interface TestMapper {

    @Select("select * from tb01")
    public List<TestPOJO> list();
}
