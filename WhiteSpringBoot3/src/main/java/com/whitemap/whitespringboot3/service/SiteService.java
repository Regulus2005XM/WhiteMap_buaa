package com.whitemap.whitespringboot3.service;

import com.whitemap.whitespringboot3.DB.dao.SiteDAO;
import com.whitemap.whitespringboot3.DB.dao.SiteMapper;
import com.whitemap.whitespringboot3.DB.pojo.SitePOJO;
import com.whitemap.whitespringboot3.web.dto.SiteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService implements ISiteService {
    @Autowired
    SiteDAO siteDAO;
    @Autowired
    SiteMapper siteMapper;

    @Override
    public SitePOJO add(SiteDTO dto) {
        SitePOJO pojo = new SitePOJO();
        BeanUtils.copyProperties(dto, pojo);
        siteDAO.save(pojo);
        return pojo;
    }

    @Override
    public void remove(Integer id) {
        siteDAO.deleteById(id);
    }

    @Override
    public List<SitePOJO> query(Double x, Double y, Double range) {
        return siteMapper.findByRange(x-range,x+range,y-range,y+range);
    }
}
