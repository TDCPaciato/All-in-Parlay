package allin.if5b.landindo.Service;

import android.content.Context;
import android.content.SharedPreferences;

public class Utilities {
    private static final String PREFERENCE_FILE_KEY = Utilities.class.getPackage().getName();

    public static void clearData(Context context){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("xUsername", null);
        editor.apply();

    }
    public static void setValue(Context context, String xPref, String xValue){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(xPref, xValue);
        editor.commit();
    }

    public static String getValue(Context context, String xPref){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        String xValue = sp.getString(xPref, null);
        return xValue;
    }

    public static Boolean cekValue(Context context, String xPref){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        String xValue = sp.getString(xPref, null);

        return xValue != null;
    }
}
