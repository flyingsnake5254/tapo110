package com.tplink.iot.model.home;

import com.tplink.iot.cloud.bean.cloudvideo.common.DowngradeHandled;
import com.tplink.iot.cloud.bean.cloudvideo.common.DowngradeToHandle;
import com.tplink.iot.cloud.bean.cloudvideo.common.RemovedDevice;
import com.tplink.iot.cloud.bean.cloudvideo.result.DowngradeInfoResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  private boolean a;
  private String b;
  private int c;
  private long d;
  private List<String> e;
  
  public static d a(DowngradeInfoResult paramDowngradeInfoResult)
  {
    if (paramDowngradeInfoResult != null)
    {
      d locald;
      if (paramDowngradeInfoResult.getDowngradeHandled() != null)
      {
        locald = new d();
        locald.h(true);
        locald.k(paramDowngradeInfoResult.getDowngradeHandled().getSubscriptionId());
        locald.i(paramDowngradeInfoResult.getDowngradeHandled().getNewDeviceNum());
        locald.g(paramDowngradeInfoResult.getDowngradeHandled().getDeviceRemovalTime());
        ArrayList localArrayList = new ArrayList();
        if (paramDowngradeInfoResult.getDowngradeHandled().getRemovedDeviceList() != null)
        {
          paramDowngradeInfoResult = paramDowngradeInfoResult.getDowngradeHandled().getRemovedDeviceList().iterator();
          while (paramDowngradeInfoResult.hasNext()) {
            localArrayList.add(((RemovedDevice)paramDowngradeInfoResult.next()).getDeviceId());
          }
        }
        locald.j(localArrayList);
        return locald;
      }
      if (paramDowngradeInfoResult.getDowngradeToHandle() != null)
      {
        locald = new d();
        locald.h(false);
        locald.k(paramDowngradeInfoResult.getDowngradeToHandle().getSubscriptionId());
        locald.i(paramDowngradeInfoResult.getDowngradeToHandle().getNewDeviceNum());
        return locald;
      }
    }
    return null;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public List<String> d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.a;
  }
  
  public void g(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void h(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void i(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void j(List<String> paramList)
  {
    this.e = paramList;
  }
  
  public void k(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\home\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */