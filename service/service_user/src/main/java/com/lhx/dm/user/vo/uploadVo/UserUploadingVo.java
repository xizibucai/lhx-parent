package com.lhx.dm.user.vo.uploadVo;

import com.lhx.dm.user.entity.Gallery;
import com.lhx.dm.user.entity.Image;
import com.lhx.dm.user.entity.VideosSet;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UserUploadingVo {
    private List<VideosSet> videosSets = new ArrayList<>();
    private List<UPImageListVo> images = new ArrayList<>();
    private List<UPGalleryVo> galleries = new ArrayList<>();
}
