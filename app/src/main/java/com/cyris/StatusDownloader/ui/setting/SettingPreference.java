package com.cyris.StatusDownloader.ui.setting;
import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.cyris.StatusDownloader.R;

public class SettingPreference extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference_setting);

    }
}
