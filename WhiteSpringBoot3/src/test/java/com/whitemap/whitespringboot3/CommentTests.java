package com.whitemap.whitespringboot3;

import com.whitemap.whitespringboot3.mapper.CommentMapper;
import com.whitemap.whitespringboot3.pojo.comments.CommentIndexPOJO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CommentTests {

    @Autowired
    private CommentMapper mapper;

    @Test
    public void test() {
        List<CommentIndexPOJO> list = mapper.getRoots(1, 0, Arrays.asList(0,1), 0, 2);
        for (CommentIndexPOJO comment : list) {
            System.out.println(comment);
        }
    }
}
