package com.whitemap.whitespringboot3.dao;

import com.whitemap.whitespringboot3.pojo.SitePOJO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteDAO extends CrudRepository<SitePOJO, Integer> {
}
