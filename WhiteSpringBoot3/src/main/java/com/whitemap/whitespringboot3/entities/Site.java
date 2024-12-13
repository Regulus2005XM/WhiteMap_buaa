package com.whitemap.whitespringboot3.entities;

import com.whitemap.whitespringboot3.DB.pojo.SitePOJO;
import javax.security.auth.Subject;

public class Site {
    SitePOJO site;
    Subject subject;

    public Site(SitePOJO site, Subject subject) {
        this.site = site;
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public SitePOJO getSite() {
        return site;
    }
}
