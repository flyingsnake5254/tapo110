package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class h
{
  private String a;
  
  @NonNull
  public static a b()
  {
    return new a(null);
  }
  
  @NonNull
  public String a()
  {
    return this.a;
  }
  
  public static final class a
  {
    private String a;
    
    @NonNull
    public h a()
    {
      if (this.a != null)
      {
        h localh = new h(null);
        h.c(localh, this.a);
        return localh;
      }
      throw new IllegalArgumentException("Purchase token must be set");
    }
    
    @NonNull
    public a b(@NonNull String paramString)
    {
      this.a = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */