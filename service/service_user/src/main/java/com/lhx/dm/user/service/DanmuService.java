package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Danmu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.query.DanMuQuery;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-04-29
 */
public interface DanmuService extends IService<Danmu> {

    R getdanmu(Integer vid, HttpServletRequest request);

    R danmuAadd(HttpServletRequest request, DanMuQuery danMuQuery);
}
