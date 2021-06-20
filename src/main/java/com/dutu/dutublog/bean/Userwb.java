package com.dutu.dutublog.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dutu
 * @date 2021-05-28 14:30
 */
@Data
public class Userwb {
    @TableId(value = "idstr")
    private String idstr;
    private String screenname;
    private Timestamp logintime;
    private String client;
}
