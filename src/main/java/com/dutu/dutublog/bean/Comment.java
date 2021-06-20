package com.dutu.dutublog.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author dutu
 * @date 2021-05-28 16:32
 */
@Data
public class Comment {
    @TableId(value = "comment_id",type = IdType.AUTO)
    private int commentId;
    private String content;
    private String userId;
    private String parentId;
    private Timestamp date;
    List<Comment> child;
}
