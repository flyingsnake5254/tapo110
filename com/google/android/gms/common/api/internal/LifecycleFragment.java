package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface LifecycleFragment
{
  @KeepForSdk
  public abstract void addCallback(String paramString, @NonNull LifecycleCallback paramLifecycleCallback);
  
  @KeepForSdk
  public abstract <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass);
  
  @KeepForSdk
  public abstract Activity getLifecycleActivity();
  
  @KeepForSdk
  public abstract boolean isCreated();
  
  @KeepForSdk
  public abstract boolean isStarted();
  
  @KeepForSdk
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\LifecycleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */