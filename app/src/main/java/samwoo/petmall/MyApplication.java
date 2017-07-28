package samwoo.petmall;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.ArrayList;
import java.util.List;

import samwoo.petmall.model.news.GeekEntity;
import samwoo.petmall.utils.RequsetDataUtil;

/**
 * Created by Administrator on 2017/7/19.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImagePipelineConfig config=ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();

        Fresco.initialize(this,config);
        AutoLayoutConifg.getInstance().useDeviceSize();

    }

}
