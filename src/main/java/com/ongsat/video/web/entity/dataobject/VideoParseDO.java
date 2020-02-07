package com.ongsat.video.web.entity.dataobject;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VideoParseDO {

    private Boolean isSuccess;

    private String videoUrl;

    private String videoImageUrl;

    private String videoTitle;

}
