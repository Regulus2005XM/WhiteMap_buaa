package com.whitemap.whitespringboot3;

import com.whitemap.whitespringboot3.dao.TestMapper;
import com.whitemap.whitespringboot3.web.dto.TestPOJO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisQuickTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test() {
        List<TestPOJO> userlist = testMapper.list();
        userlist.stream().forEach(user->{
            System.out.println(user);
        });
    }
}
