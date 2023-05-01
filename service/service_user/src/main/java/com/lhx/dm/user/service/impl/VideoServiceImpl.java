package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Friend;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.entity.Video;
import com.lhx.dm.user.query.VideoQuery;
import com.lhx.dm.user.service.*;
import com.lhx.dm.user.utils.JwtUtils;
import com.lhx.dm.user.vo.VideoBaseVo;
import com.lhx.dm.user.vo.video.ResourceVo;
import com.lhx.dm.user.mapper.VideoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.vo.video.VideoInfoAutherVo;
import com.lhx.dm.user.vo.video.VideoInfoVo;
import com.lhx.dm.user.vo.video.VideoInteractive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-01
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private UserService userService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private VideosCollectionService videosCollectionService;
    @Autowired
    private LikeService likeService;

    @Override
    public R videoGetList() {
        List<Video> list = list();
        return R.ok().data("list", list);
    }

    @Override
    public R videoGetListPage(Long pageNo, Long pageSize, VideoQuery videoQuery) {
        Page<Video> page = new Page<>(pageNo, pageSize);
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();

        baseMapper.selectPage(page, queryWrapper);
        List<Video> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("list", records);

    }

    @Override
    public R videoLittle() {
        List<Video> list = list();
        List<VideoBaseVo> vos = new ArrayList<>();
        for (Video video : list) {
            VideoBaseVo vo = new VideoBaseVo();
            vo.setId(video.getId());
            vo.setTitle(video.getName());
            vo.setCover(video.getImage());
            vos.add(vo);
        }
        return R.ok().data("videos", vos);
    }

    @Override
    public R videoFrontGetById(Integer id) {
        ResourceVo vo = new ResourceVo();
        Video video = getById(id);
        vo.setId(video.getId().toString());
        vo.setOriginal(video.getVideoSourceId());
        return R.ok().data("optResource", vo);
    }

    @Override
    public R getVideoInfo(Integer id, HttpServletRequest request) {
        //详细信息
        Video video = getById(id);
        Long uid = video.getCreateBy();
        User user = userService.getById(uid);
        VideoInfoVo info = new VideoInfoVo();
        info.setVid(video.getId().toString());
        info.setCover(video.getImage());
        info.setCreated_at(video.getCreateTime());
        info.setTitle(video.getName());
        info.setDesc(video.getIntro());
        info.setCopyright(true);

        VideoInfoAutherVo auther = new VideoInfoAutherVo();
        auther.setUid(uid.toString());
        auther.setEmail("111@qq.com");
        auther.setSign(user.getIntro());
        auther.setName(user.getUserName());
        auther.setGender(user.getGrade());
        auther.setBirthday(user.getCreateTime().toString());
        auther.setAvatar(user.getFaceImg());
        auther.setRole(0);
        info.setAuthor(auther);

        ArrayList<ResourceVo> resourceVos = new ArrayList<>();
        ResourceVo vo = new ResourceVo();
        vo.setId(video.getId().toString());
        vo.setOriginal(video.getVideoSourceId());
        resourceVos.add(vo);
        info.setResource(resourceVos);
        String userId = JwtUtils.getMemberIdByJwtToken(request);
        //获取关注状态
        QueryWrapper<Friend> friendWrapper = new QueryWrapper<>();
        friendWrapper.eq("uid",userId);
        friendWrapper.eq("fid",uid);
        VideoInteractive interactive = new VideoInteractive();
        Friend friend = friendService.getOne(friendWrapper);
        if (friend !=null) {
         interactive.setFollow(true);
        }
        else{
            interactive.setFollow(false);
        }
        //获取收藏状态
        Boolean collect = videosCollectionService.getVideoStatus(id.toString(),userId);
        interactive.setCollect(collect);
        //获取点赞
        Boolean likestatus = likeService.getStatus(id, userId, "video");
        interactive.setLike(likestatus);
        info.setInteractive(interactive);
        return R.ok().data("video",info);
    }

}
