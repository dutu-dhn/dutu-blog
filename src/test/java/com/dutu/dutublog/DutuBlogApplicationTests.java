package com.dutu.dutublog;

import com.dutu.dutublog.bean.Admin;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
@Slf4j
@SpringBootTest
class DutuBlogApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        String aLong = jdbcTemplate.queryForObject("select uname from admin where uid=9999", String.class);

        log.info("记录总数：{}",aLong);
    }

}
