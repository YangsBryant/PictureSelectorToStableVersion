package com.bryant.pictureselectortostableversion;


import android.support.v4.app.Fragment;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

public class PictureSelectorUtil {

    public static void startPictureSelect(Fragment fragment, int maxSelectNum, List<LocalMedia> selectionMedia, int requestCode) {

        // 进入相册 以下是例子：不需要的api可以不写
        com.luck.picture.lib.PictureSelector.create(fragment)
                //基础设置-----------------------------------------------------------
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                //.theme(R.style.picture_white_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .maxSelectNum(1)// 最大图片选择数量
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(3)// 每行显示个数
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选
                .previewImage(false)// 是否可预览图片
                .previewVideo(false)// 是否可预览视频
                .enablePreviewAudio(false) // 是否可播放音频
                .isCamera(true)// 是否显示拍照按钮
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .isGif(false)// 是否显示gif图片
                .openClickSound(false)// 是否开启点击声音
                .selectionMedia(selectionMedia)// 是否传入已选图片
                .glideOverride(160, 160)// 列表图片宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                //.imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                //裁剪设置-----------------------------------------------------------
                .enableCrop(true)// 是否裁剪
                .rotateEnabled(false) // 裁剪是否可旋转图片
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(true)//是否裁剪圆形图片
                .showCropFrame(false)//是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .scaleEnabled(false)//裁剪是否可放大缩小图片 true or false
                //.withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                //压缩设置-----------------------------------------------------------
                .compress(true)// 是否压缩
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(false)//同步true或异步false 压缩 默认同步
                .cropCompressQuality(50)// 裁剪压缩质量 默认100
                //特殊设置-----------------------------------------------------------
                //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                //.videoQuality()// 视频录制质量 0 or 1
                //.recordVideoSecond()//录制视频秒数 默认60s
                //.videoMaxSecond(15)//显示最大多少秒以内的视频
                //.videoMinSecond(10)//显示最小多少秒以内的视频
                .forResult(requestCode);//结果回调onActivityResult code
    }


}
