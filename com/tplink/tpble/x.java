package com.tplink.tpble;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint({"CommitPrefEdits"})
class x
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public static x a()
  {
    return a.a();
  }
  
  public int b(String paramString, int paramInt)
  {
    return this.a.getInt(paramString, paramInt);
  }
  
  void c(Application paramApplication)
  {
    paramApplication = paramApplication.getSharedPreferences("sp_file", 0);
    this.a = paramApplication;
    this.b = paramApplication.edit();
  }
  
  public void d(String paramString, int paramInt)
  {
    this.b.putInt(paramString, paramInt);
    this.b.commit();
  }
  
  private static class a
  {
    private static final x a = new x();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */