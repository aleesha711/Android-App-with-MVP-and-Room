package app.android.pattern.ui;

import android.app.Application;
import android.content.Context;

/**
 * Created by Aleesha Kanwal on 13/05/2018.
 */

public class App extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }
}
