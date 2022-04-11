package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import android.text.TextUtils;

public class u
{
  private String a;
  private String b;
  private boolean c = true;
  private boolean d;
  private FirmwareUpdateLevel e;
  
  private int c(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return 0;
    }
    int j;
    try
    {
      j = Integer.parseInt(paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      j = i;
    }
    return j;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public FirmwareUpdateLevel b()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    boolean bool;
    if ((this.a != null) && (this.b != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean f()
  {
    return this.c;
  }
  
  public void g(String paramString)
  {
    this.b = paramString;
  }
  
  public void h(String paramString)
  {
    this.e = FirmwareUpdateLevel.makeFirmwareUpdateLevel(c(paramString));
  }
  
  public void i(String paramString)
  {
    this.a = paramString;
  }
  
  public void j(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void k(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\firmware\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */