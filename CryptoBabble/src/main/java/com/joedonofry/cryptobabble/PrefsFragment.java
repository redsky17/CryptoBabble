package com.joedonofry.cryptobabble;

/**
 * Created by Joseph on 8/1/13.
 */
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;


public class PrefsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        Preference preferences=findPreference("user_image_preference");
        preferences.setOnPreferenceClickListener (new Preference.OnPreferenceClickListener(){
            public boolean onPreferenceClick(Preference preference){
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                int PICK_IMAGE = 1;
                getActivity().startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                return true;
            }
        });
    }




}