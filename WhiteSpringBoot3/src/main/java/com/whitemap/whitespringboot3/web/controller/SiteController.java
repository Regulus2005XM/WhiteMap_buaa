package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.Common.SubjectType;
import com.whitemap.whitespringboot3.service.ICommentService;
import com.whitemap.whitespringboot3.service.ISiteService;
import com.whitemap.whitespringboot3.DB.pojo.ResponseMessage;
import com.whitemap.whitespringboot3.DB.pojo.SitePOJO;
import com.whitemap.whitespringboot3.service.ISubjectService;
import com.whitemap.whitespringboot3.web.dto.Site.SiteDTO;
import com.whitemap.whitespringboot3.web.dto.Site.SiteQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/site")
@RestController
public class SiteController {
    @Autowired
    ISiteService siteService;
    @Autowired
    ISubjectService subjectService;
    @Autowired
    ICommentService commentService;

    @PostMapping
    public ResponseMessage<SitePOJO> createSite(@RequestBody SiteDTO dto) {
        //System.out.println(dto);
        subjectService.add(dto.getUserId(), SubjectType.Site);
        SitePOJO site = siteService.add(dto);
        return ResponseMessage.success(site);
    }

    @DeleteMapping
    public ResponseMessage<Void> deleteSite(@RequestBody Integer id) {
        SitePOJO pojo = siteService.get(id);
        commentService.deleteSubject(pojo.getSubjectId(),SubjectType.Site);
        subjectService.delete(pojo.getSubjectId());
        siteService.remove(id);
        return ResponseMessage.success(null);
    }

    @GetMapping
    public ResponseMessage<List<SitePOJO>> getSite(@RequestBody SiteQueryDTO queryDTO) {
        List<SitePOJO> res = siteService.query(queryDTO.getX(),queryDTO.getY(),queryDTO.getRange());
        return ResponseMessage.success(res);
    }
}
