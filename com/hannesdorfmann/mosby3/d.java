package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.hannesdorfmann.mosby3.k.b;

public abstract interface d<V extends b, P extends com.hannesdorfmann.mosby3.mvi.d<V, ?>>
{
  public abstract void a(Activity paramActivity);
  
  public abstract void b(Context paramContext);
  
  public abstract void c(Fragment paramFragment);
  
  public abstract void d();
  
  public abstract void e(View paramView, @Nullable Bundle paramBundle);
  
  public abstract void f(Bundle paramBundle);
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onDestroyView();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */