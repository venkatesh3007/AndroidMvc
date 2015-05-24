/*
 * Copyright 2015 Kejun Xia
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

package com.shipdream.lib.android.mvc.view.injection.controller.internal;

import com.shipdream.lib.android.mvc.controller.internal.BaseControllerImpl;
import com.shipdream.lib.android.mvc.view.injection.controller.ControllerB;

import java.util.ArrayList;
import java.util.List;

public class ControllerBImpl extends BaseControllerImpl<ControllerB.Model>
        implements ControllerB{
    @Override
    public Class<Model> getModelClassType() {
        return Model.class;
    }

    @Override
    protected void onInitialized() {
        super.onInitialized();
        getModel().setTags(new ArrayList<String>());
    }

    @Override
    public void addTag(String tag) {
        getModel().getTags().add(tag);
    }

    @Override
    public List<String> getTags() {
        return getModel().getTags();
    }
}
