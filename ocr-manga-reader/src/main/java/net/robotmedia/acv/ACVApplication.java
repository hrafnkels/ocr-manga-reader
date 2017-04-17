/*******************************************************************************
 * Copyright 2009 Robot Media SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.robotmedia.acv;

import android.app.Application;

import net.robotmedia.acv.logic.PreferencesController;
import net.robotmedia.acv.utils.AnkiUtils;

public class ACVApplication extends Application
{

  @Override
  public void onCreate()
  {
    super.onCreate();
    final PreferencesController preferences = new PreferencesController(this);
    preferences.legacy();
    preferences.setMaxImageResolution();

    boolean firstAppLaunch = preferences.isFirstAppLaunch();

    // Is first time app has ever been launched
    if (firstAppLaunch)
    {     
      // Set buttons for rtl or ltr reading direction.
      preferences.restoreControlDefaults();
      preferences.setDefaultOrientation();
    }

    AnkiUtils.initCachedInfo(getApplicationContext());
  }

}
