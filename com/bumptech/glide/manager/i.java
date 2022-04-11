package com.bumptech.glide.manager;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
final class i
  implements k, ComponentCallbacks2
{
  public void a(Activity paramActivity) {}
  
  public void onConfigurationChanged(@NonNull Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    onTrimMemory(20);
  }
  
  public void onTrimMemory(int paramInt) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */