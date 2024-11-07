package com.whitemap.whitespringboot3.pojo;

public class TestPOJO {
    private Integer id;
    private String name;


    public TestPOJO(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
