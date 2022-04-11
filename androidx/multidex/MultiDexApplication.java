package androidx.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication
  extends Application
{
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    MultiDex.install(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\multidex\MultiDexApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */