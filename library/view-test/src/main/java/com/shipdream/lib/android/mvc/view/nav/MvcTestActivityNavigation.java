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

package com.shipdream.lib.android.mvc.view.nav;

import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.shipdream.lib.android.mvc.controller.NavigationController;
import com.shipdream.lib.android.mvc.view.MvcActivity;
import com.shipdream.lib.android.mvc.view.MvcFragment;

import javax.inject.Inject;

public class MvcTestActivityNavigation extends MvcActivity {
    public static class Loc {
        public static final String A = "TestNavigationFragmentA";
        public static final String B = "TestNavigationFragmentB";
        public static final String C = "TestNavigationFragmentC";
        public static final String D = "TestNavigationFragmentD";
    }

    @Override
    protected Class<? extends MvcFragment> mapNavigationFragment(String locationId) {
        switch(locationId) {
            case Loc.A :
                return NavFragmentA.class;
            case Loc.B :
                return NavFragmentB.class;
            case Loc.C :
                return NavFragmentC.class;
            case Loc.D :
                return NavFragmentD.class;
            default:
                return null;
        }
    }

    @Override
    protected Class<? extends DelegateFragment> getDelegateFragmentClass() {
        return HomeFragment.class;
    }

    FragmentManager getRootFragmentManager() {
        return getSupportFragmentManager().getFragments().get(0).getChildFragmentManager();
    }

    public static class HomeFragment extends DelegateFragment {
        @Inject
        private NavigationController navigationController;

        @Override
        protected void onStartUp() {
            Log.d("MvcTesting", "navigate");
            navigationController.navigateTo(this, Loc.A);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }
    }

}
