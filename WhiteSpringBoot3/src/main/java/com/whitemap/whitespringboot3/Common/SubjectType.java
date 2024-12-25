package com.whitemap.whitespringboot3.Common;

public enum SubjectType {
    Site(0),
    Other(100);

    Integer value;

    SubjectType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
