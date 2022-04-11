package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class l
{
  private String a;
  private List<String> b;
  
  @NonNull
  public static a c()
  {
    return new a(null);
  }
  
  @NonNull
  public String a()
  {
    return this.a;
  }
  
  @NonNull
  public List<String> b()
  {
    return this.b;
  }
  
  public static class a
  {
    private String a;
    private List<String> b;
    
    @NonNull
    public l a()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          l locall = new l();
          l.d(locall, this.a);
          l.e(locall, this.b);
          return locall;
        }
        throw new IllegalArgumentException("SKU list or SkuWithOffer list must be set");
      }
      throw new IllegalArgumentException("SKU type must be set");
    }
    
    @NonNull
    public a b(@NonNull List<String> paramList)
    {
      this.b = new ArrayList(paramList);
      return this;
    }
    
    @NonNull
    public a c(@NonNull String paramString)
    {
      this.a = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */