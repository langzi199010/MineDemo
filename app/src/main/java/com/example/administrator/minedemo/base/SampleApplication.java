package com.example.administrator.minedemo.base;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by Administrator on 2018/5/8.
 */

public class SampleApplication extends TinkerApplication {
    public SampleApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.example.administrator.minedemo.base.MyApplication",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}