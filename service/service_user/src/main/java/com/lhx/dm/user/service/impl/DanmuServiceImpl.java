package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Danmu;
import com.lhx.dm.user.mapper.DanmuMapper;
import com.lhx.dm.user.query.DanMuQuery;
import com.lhx.dm.user.service.DanmuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.utils.JwtUtils;
import com.lhx.dm.user.vo.DanMuVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-29
 */
@Service
public class DanmuServiceImpl extends ServiceImpl<DanmuMapper, Danmu> implements DanmuService {

    @Override
    public R getdanmu(Integer vid, HttpServletRequest request) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Danmu> wrapper = new QueryWrapper<>();
        wrapper.eq("vid",vid);
        // wrapper.ne("status","0");
        List<Danmu> list = list(wrapper);
        List<DanMuVo> danmaku = new ArrayList<>();
        for (Danmu danmu : list) {
            DanMuVo vo = new DanMuVo();
            vo.setColor(danmu.getColor());
            vo.setText(danmu.getText());
            vo.setTime(danmu.getTime());
            vo.setType(danmu.getType());
            danmaku.add(vo);
        }

        return R.ok().data("danmaku", danmaku);
    }

    @Override
    public R danmuAadd(HttpServletRequest request, DanMuQuery data) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        String vid = data.getVid();
        Integer type = data.getType();
        String time = data.getTime();
        String text = data.getText();
        String color = data.getColor();

        Danmu danmu = new Danmu();
        danmu.setColor(color);
        danmu.setUid(Integer.valueOf(uid));
        danmu.setText(text);
        danmu.setVid(Integer.valueOf(vid));
        danmu.setType(type);
        danmu.setTime(time);
        boolean save = save(danmu);
        return save ? R.ok():R.error();
    }
}
