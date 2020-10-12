/*
 * Copyright 2017 陈志鹏
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.custom.modulesherlockadapter;

import java.util.List;

/**
 * 文 件 名: OnItemCheckedChangeListener
 * 创 建 人: 陈志鹏
 * 创建日期: 2017/01/22 09:38
 * 邮   箱: ch_zh_p@qq.com
 * 修改时间:
 * 修改备注:
 * item 选中状态监听
 */

public interface MultiSelect {

    /**
     * 清除所选
     */
    void clearSelectAll();

    /**
     * 全选
     */
    void selectAll();

    /**
     * 设置监听
     * @param onCheckedChangeListener 监听器，可以为空
     */
    void setOnItemCheckedChangeListener(OnItemCheckedChangeListener onCheckedChangeListener);

    /**
     * 返回全部选择
     * @return 返回全部已经勾选的子项
     */
    List<IMultiSelectItem> getSelectedItems();
}
