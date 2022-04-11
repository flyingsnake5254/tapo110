package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@DynamiteApi
public class FlagProviderImpl
  extends com.google.android.gms.flags.zzd
{
  private boolean zzu = false;
  private SharedPreferences zzv;
  
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!this.zzu) {
      return paramBoolean;
    }
    return zzb.zza(this.zzv, paramString, Boolean.valueOf(paramBoolean)).booleanValue();
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.zzu) {
      return paramInt1;
    }
    return zzd.zza(this.zzv, paramString, Integer.valueOf(paramInt1)).intValue();
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    if (!this.zzu) {
      return paramLong;
    }
    return zzf.zza(this.zzv, paramString, Long.valueOf(paramLong)).longValue();
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    if (!this.zzu) {
      return paramString2;
    }
    return zzh.zza(this.zzv, paramString1, paramString2);
  }
  
  public void init(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    if (this.zzu) {
      return;
    }
    try
    {
      this.zzv = zzj.zza(paramIObjectWrapper.createPackageContext("com.google.android.gms", 0));
      this.zzu = true;
      return;
    }
    catch (Exception paramIObjectWrapper)
    {
      paramIObjectWrapper = String.valueOf(paramIObjectWrapper.getMessage());
      if (paramIObjectWrapper.length() != 0) {
        paramIObjectWrapper = "Could not retrieve sdk flags, continuing with defaults: ".concat(paramIObjectWrapper);
      } else {
        paramIObjectWrapper = new String("Could not retrieve sdk flags, continuing with defaults: ");
      }
      Log.w("FlagProviderImpl", paramIObjectWrapper);
      return;
    }
    catch (PackageManager.NameNotFoundException paramIObjectWrapper)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\impl\FlagProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */