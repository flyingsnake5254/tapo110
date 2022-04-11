package com.tplink.libtpanalytics.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint({"CommitPrefEdits"})
public class k
{
  private SharedPreferences a = null;
  private SharedPreferences.Editor b = null;
  
  public k(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(paramString, 0);
    this.a = paramContext;
    this.b = paramContext.edit();
  }
  
  public long a(String paramString, long paramLong)
  {
    return this.a.getLong(paramString, paramLong);
  }
  
  public String b(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
  
  public void c(String paramString, long paramLong)
  {
    this.b.putLong(paramString, paramLong);
    this.b.commit();
  }
  
  public void d(String paramString1, String paramString2)
  {
    this.b.putString(paramString1, paramString2);
    this.b.commit();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */