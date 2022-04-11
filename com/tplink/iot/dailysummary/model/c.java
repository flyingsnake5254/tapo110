package com.tplink.iot.dailysummary.model;

import android.graphics.Bitmap;

public final class c
{
  private final Bitmap a;
  private final long b;
  
  public c(Bitmap paramBitmap, long paramLong)
  {
    this.a = paramBitmap;
    this.b = paramLong;
  }
  
  public final Bitmap a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryPlayerThumbnail(bitmap=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", timePosition=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */