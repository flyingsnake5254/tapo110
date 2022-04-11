package com.tplink.iot.h.h;

import androidx.annotation.NonNull;

public class b
  implements Comparable<b>
{
  private String c;
  private float d;
  private long f;
  
  public b(String paramString, float paramFloat, long paramLong)
  {
    this.c = paramString;
    this.d = paramFloat;
    this.f = paramLong;
  }
  
  public int a(@NonNull b paramb)
  {
    return this.c.compareTo(paramb.c);
  }
  
  public long b()
  {
    return this.f;
  }
  
  public float c()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(" (");
    localStringBuilder.append(this.d);
    localStringBuilder.append("sec)");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\h\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */