package tw.org.iii.leo.leo08;

import android.app.Application;

public class MainApp extends Application {
    public int a ;
    public String b ;
    public static int c;


    @Override
    public void onCreate() {
        super.onCreate();
        a=10;
        b="Leo";
    }
}
