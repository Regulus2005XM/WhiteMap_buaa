package com.whitemap.whitespringboot3.mapper;

import com.whitemap.whitespringboot3.pojo.TestPOJO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.whitemap.whitespringboot3.pojo.RegisterPOJO;
import java.util.List;
@Mapper //在运行时，会自动生成该接口的实现类对象(代理对象)，
// 并且将该对象交给IOC容器管理
public interface InsertRegisterMapper {
    @Insert("insert into tb01(username, password) values(#{username},#{password)")
    public default void reinsert(RegisterPOJO registerpojo){
    }
}
