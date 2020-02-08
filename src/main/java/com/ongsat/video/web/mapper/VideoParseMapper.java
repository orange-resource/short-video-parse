package com.ongsat.video.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ongsat.video.web.entity.po.VideoParsePO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface VideoParseMapper extends BaseMapper<VideoParsePO> {

    String TABLE = " t_video_parse ";

    @Select("select * from" + TABLE + "where original_url = #{originalUrl}")
    VideoParsePO getByOriginalUrl(@Param("originalUrl") String originalUrl);

}
