package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.DB.pojo.SitePOJO;
import com.whitemap.whitespringboot3.web.dto.Site.SiteDTO;
import java.util.List;

public interface ISiteService {
    SitePOJO add(SiteDTO dto);

    void remove(Integer id);

    List<SitePOJO> query(Double x, Double y, Double range);

    SitePOJO get(Integer id);
}
