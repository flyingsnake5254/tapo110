package com.tplink.libtpnetwork.cameranetwork.business.model;

import com.tplink.libtpnetwork.cameranetwork.model.DetectionList;
import com.tplink.libtpnetwork.cameranetwork.model.SnapshotPlaybackItem;
import java.util.ArrayList;
import java.util.List;

public class n
{
  private DetectionList a;
  private boolean b;
  private int c;
  private long d;
  
  public n()
  {
    this.a = new DetectionList(Boolean.FALSE, new ArrayList());
    this.b = false;
  }
  
  public n(List<SnapshotPlaybackItem> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong)
  {
    this.a = new DetectionList(Boolean.valueOf(paramBoolean1), paramList);
    this.b = paramBoolean2;
    this.c = paramInt;
    this.d = paramLong;
  }
  
  public DetectionList a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */