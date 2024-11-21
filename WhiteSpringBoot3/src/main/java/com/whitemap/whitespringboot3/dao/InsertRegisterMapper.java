package com.whitemap.whitespringboot3.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.whitemap.whitespringboot3.web.dto.RegisterPOJO;

@Mapper //在运行时，会自动生成该接口的实现类对象(代理对象)，
// 并且将该对象交给IOC容器管理
public interface InsertRegisterMapper {
    @Insert("insert into tb01(username, password) values(#{username},#{password)")
    public default void reinsert(RegisterPOJO registerpojo){
    }
}
