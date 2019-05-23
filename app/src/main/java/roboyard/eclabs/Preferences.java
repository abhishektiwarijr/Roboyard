package roboyard.eclabs;

import android.app.Activity;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;


public class Preferences {
    public SharedPreferences preferences;

    public void setPreferences(Activity activity, String key, String value){
        preferences = activity.getApplicationContext().getSharedPreferences("preferencestorage", MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = preferences.edit();

        preferencesEditor.putString(key,value);
        preferencesEditor.apply();
    }

    public String getPreferenceValue(Activity activity, String key){
        SharedPreferences preferences = activity.getApplicationContext().getSharedPreferences("preferencestorage", MODE_PRIVATE);
        return preferences.getString(key,"");
    }
}
