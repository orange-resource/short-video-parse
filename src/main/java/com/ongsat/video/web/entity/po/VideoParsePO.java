package com.ongsat.video.web.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@TableName("t_video_parse")
@KeySequence("SEQ_TEST")
public class VideoParsePO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(value = "create_at",fill = FieldFill.INSERT)
    private Date createAt;

    @TableField(value = "update_at",fill = FieldFill.UPDATE)
    private Date updateAt;

    private String title;

    private String ImgUrl;

    private String playUrl;

    private String OriginalUrl;

}
