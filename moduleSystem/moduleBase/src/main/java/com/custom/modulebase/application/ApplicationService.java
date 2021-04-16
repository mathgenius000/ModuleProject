package com.custom.modulebase.application;

import android.app.Application;

public interface ApplicationService {

    /**
     * 初始化一些第三方SDK服务
     */
    void loadModuleApplicationService();

    /**
     * 获取主APP的Application或者module在debug时自己的application
     *
     * @return
     */
    Application getApplication();

}
