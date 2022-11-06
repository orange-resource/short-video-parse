package com.ongsat.video.web.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ongsat.video.web.common.constant.RedisConstant;
import com.ongsat.video.web.common.response.Response;
import com.ongsat.video.web.common.response.ResultBuilder;
import com.ongsat.video.web.common.response.RspCode;
import com.ongsat.video.web.common.tool.VideoParseUtil;
import com.ongsat.video.web.entity.dataobject.VideoParseDO;
import com.ongsat.video.web.entity.po.VideoParsePO;
import com.ongsat.video.web.mapper.VideoParseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VideoParseService extends ServiceImpl<VideoParseMapper, VideoParsePO> {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public Response parseVideo(String url, String ip) {
        Long limit = redisTemplate.opsForValue().increment(RedisConstant.IP_LIMIT + ip, 0);
        if (null != limit) {
            if (limit >= 30) return Response.build(RspCode.URL_PARSE_TOO_LARGE);
        }

        VideoParsePO videoParsePO = super.baseMapper.getByOriginalUrl(url);
        if (null == videoParsePO) {
            VideoParseDO videoParseDO = null;
            if (url.contains("douyin.com")) { // 抖音
                videoParseDO = VideoParseUtil.parse(url, VideoParseUtil.DY);
            } else if (url.contains("chenzhongtech.com")) { // 快手
                videoParseDO = VideoParseUtil.parse(url, VideoParseUtil.KS);
            } else if (url.contains("h5.weishi.qq.com")) { // 微视
                videoParseDO = VideoParseUtil.parse(url, VideoParseUtil.WS);
            } else if (url.contains("xiaokaxiu.com")) { // 小咖秀
                videoParseDO = VideoParseUtil.parse(url, VideoParseUtil.XKS);
            } else if (url.contains("miaopai.com")) { // 秒拍
                videoParseDO = VideoParseUtil.parse(url, VideoParseUtil.MIAO_PAI);
            } else {
                return Response.build(RspCode.URL_NOT_FOUND);
            }
            if (null == videoParseDO) return Response.build(RspCode.PARSE_ERROR);

            videoParsePO = new VideoParsePO();
            videoParsePO.setOriginalUrl(url);
            videoParsePO.setPlayUrl(videoParseDO.getVideoUrl());
            videoParsePO.setImgUrl(videoParseDO.getVideoImageUrl());
            videoParsePO.setTitle(videoParseDO.getVideoTitle());

            try {
                super.baseMapper.insert(videoParsePO);
            } catch (Exception e) {}
        }

        Long increment = redisTemplate.opsForValue().increment(RedisConstant.IP_LIMIT + ip, 1);

        Map<String, Object> build = new ResultBuilder()
                .set("title", videoParsePO.getTitle())
                .set("playUrl", videoParsePO.getPlayUrl())
                .set("imgUrl", videoParsePO.getImgUrl())
                .set("useTotal", increment == null ? 0 : increment)
                .build();
        return Response.build(RspCode.QUERY_SUCCESS, build);
    }

    public int getUseTotal() {
        int count = super.count();
        return count;
    }

}
