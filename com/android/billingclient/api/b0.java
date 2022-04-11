package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.util.List;

final class b0
{
  @Nullable
  private final List<SkuDetails> a;
  private final int b;
  private final String c;
  
  public b0(int paramInt, String paramString, @Nullable List<SkuDetails> paramList)
  {
    this.b = paramInt;
    this.c = paramString;
    this.a = paramList;
  }
  
  @Nullable
  public final List<SkuDetails> a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */