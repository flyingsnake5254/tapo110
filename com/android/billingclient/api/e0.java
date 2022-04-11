package com.android.billingclient.api;

import android.text.TextUtils;

public final class e0
{
  private String a;
  
  public final e0 a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public final f0 b()
  {
    if (!TextUtils.isEmpty(this.a)) {
      return new f0(this.a, null, null);
    }
    throw new IllegalArgumentException("SKU must be set.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */