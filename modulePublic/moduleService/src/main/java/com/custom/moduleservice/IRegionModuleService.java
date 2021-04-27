package com.custom.moduleservice;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IRegionModuleService extends IProvider {
    String getCurrentAddress();
}
