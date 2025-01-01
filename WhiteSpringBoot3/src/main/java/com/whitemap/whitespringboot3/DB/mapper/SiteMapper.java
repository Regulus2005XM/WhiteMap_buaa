package com.whitemap.whitespringboot3.DB.mapper;

import com.whitemap.whitespringboot3.DB.pojo.SitePOJO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SiteMapper {
    @Select("select * from db001.tb_site where x between #{x1} and #{x2} and y between #{y1} and #{y2}")
    List<SitePOJO> findByRange(Double x1, Double x2, Double y1, Double y2);
}
