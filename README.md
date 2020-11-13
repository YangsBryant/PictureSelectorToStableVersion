# PictureSelectorToStableVersion
PictureSelector图片选择库的support版本

## 引入module
将项目里的picture_library 和 ucrop 两个module拷贝进自己项目

## 注意
Android targetSdkVersion 29以上有沙盒模式，解除此限制，加上android:requestLegacyExternalStorage="true"

## 工具类
```java
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

public class PictureSelectorUtil {

    public static void startPictureSelect(Fragment fragment, int maxSelectNum, List<LocalMedia> selectionMedia, int requestCode) {

        PictureSelector.create(fragment)
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
```

## 图片地址回调
```java
@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0x01 && resultCode == RESULT_OK) {
            //返回的数据
            List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
        }
    }
```

## 自定义主题
```java
<!--注意每一项都不能少-->
    <style name="picture.white.style" parent="Theme.MaterialComponents.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <!--标题栏背景色-->
        <item name="colorPrimary">@color/white</item>
        <!--状态栏背景色-->
        <item name="colorPrimaryDark">#80000000</item>
        <!--是否改变图片列表界面状态栏字体颜色为黑色-->
        <item name="picture.statusFontColor">true</item>
        <!--返回键图标-->
        <item name="picture.leftBack.icon">@drawable/ic_back</item>
        <!--标题下拉箭头-->
        <item name="picture.arrow_down.icon">@drawable/orange_arrow_down</item>
        <!--标题上拉箭头-->
        <item name="picture.arrow_up.icon">@drawable/orange_arrow_up</item>
        <!--标题文字颜色-->
        <item name="picture.title.textColor">@color/colorAccent</item>
        <!--标题栏右边文字-->
        <item name="picture.right.textColor">@color/colorAccent</item>
        <!--图片列表勾选样式-->
        <item name="picture.checked.style">@drawable/picture_checkbox_selector</item>
        <!--开启图片列表勾选数字模式,开启的话勾选样式要换-->
        <item name="picture.style.checkNumMode">false</item>
        <!--选择图片样式0/9-->
        <item name="picture.style.numComplete">true</item>
        <!--图片列表底部背景色-->
        <item name="picture.bottom.bg">@color/color_fa</item>
        <!--图片列表预览文字颜色-->
        <item name="picture.preview.textColor">@color/colorAccent</item>
        <!--图片列表已完成文字颜色-->
        <item name="picture.complete.textColor">@color/colorAccent</item>
        <!--图片已选数量圆点背景色-->
        <item name="picture.num.style">@drawable/num_oval</item>
        <!--预览界面标题栏背景色-->
        <item name="picture.ac_preview.title.bg">@color/white</item>
        <!--预览界面标题文字颜色-->
        <item name="picture.ac_preview.title.textColor">@color/colorAccent</item>
        <!--预览界面已完成文字颜色-->
        <item name="picture.ac_preview.complete.textColor">@color/colorAccent</item>
        <!--预览界面底部背景色-->
        <item name="picture.ac_preview.bottom.bg">@color/color_fa</item>
        <!--预览界面返回箭头-->
        <item name="picture.preview.leftBack.icon">@drawable/ic_back</item>
        <!--裁剪页面标题背景色-->
        <item name="picture.crop.toolbar.bg">@color/bar_grey</item>
        <!--裁剪页面状态栏颜色-->
        <item name="picture.crop.status.color">@color/bar_grey</item>
        <!--裁剪页面标题文字颜色-->
        <item name="picture.crop.title.color">@color/white</item>
        <!--相册文件夹列表选中图标-->
        <item name="picture.folder_checked_dot">@drawable/orange_oval</item>
    </style>
```

## 联系QQ：961606042
