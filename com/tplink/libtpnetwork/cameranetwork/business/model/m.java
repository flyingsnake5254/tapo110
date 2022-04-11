package com.tplink.libtpnetwork.cameranetwork.business.model;

import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackItem;
import java.util.ArrayList;
import java.util.List;

public class m
{
  private List<DailyPlaybackItem> a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private long f;
  
  public m()
  {
    this.a = new ArrayList();
    this.b = false;
    this.c = 0;
    this.d = 0;
  }
  
  public m(List<DailyPlaybackItem> paramList, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.a = paramList;
    this.b = paramBoolean;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramLong;
  }
  
  public long a()
  {
    return this.f;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public List<DailyPlaybackItem> e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */