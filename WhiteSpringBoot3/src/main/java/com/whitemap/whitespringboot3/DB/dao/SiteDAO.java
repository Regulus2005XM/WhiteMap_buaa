package com.whitemap.whitespringboot3.DB.dao;

import com.whitemap.whitespringboot3.DB.pojo.SitePOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteDAO extends CrudRepository<SitePOJO, Integer> {
}
