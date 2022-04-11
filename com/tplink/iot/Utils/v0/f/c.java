package com.tplink.iot.Utils.v0.f;

import java.util.ArrayList;
import java.util.TimeZone;
import kotlin.jvm.internal.j;

public final class c
{
  @com.google.gson.q.c("dataList")
  private final ArrayList<Long> a = new ArrayList();
  @com.google.gson.q.c("searchTimeStamp")
  private long b;
  @com.google.gson.q.c("updateTimeStamp")
  private long c;
  @com.google.gson.q.c("deviceTimeZone")
  private String d;
  
  public c()
  {
    Object localObject = TimeZone.getDefault();
    j.d(localObject, "TimeZone.getDefault()");
    localObject = ((TimeZone)localObject).getID();
    j.d(localObject, "TimeZone.getDefault().id");
    this.d = ((String)localObject);
  }
  
  public final ArrayList<Long> a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final long c()
  {
    return this.b;
  }
  
  public final long d()
  {
    return this.c;
  }
  
  public final void e(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.d = paramString;
  }
  
  public final void f(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void g(long paramLong)
  {
    this.c = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v0\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */