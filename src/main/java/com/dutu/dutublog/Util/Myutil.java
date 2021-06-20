package com.dutu.dutublog.Util;

import java.sql.Timestamp;

/**
 * @author dutu
 * @date 2021-05-28 20:58
 */
public class Myutil {
    public static Timestamp getDate(){
        return new Timestamp(System.currentTimeMillis());
    }
}
