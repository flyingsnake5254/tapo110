package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class g
{
  private int a;
  private String b;
  
  @NonNull
  public static a b()
  {
    return new a(null);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public static class a
  {
    private int a;
    private String b;
    
    @NonNull
    public g a()
    {
      g localg = new g();
      g.c(localg, this.a);
      g.d(localg, this.b);
      return localg;
    }
    
    @NonNull
    public a b(@NonNull String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    @NonNull
    public a c(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */