package com.tplink.libtpstreamclientmanager;

import androidx.annotation.NonNull;
import b.d.d.b.e;
import b.d.o.a.f;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TPStreamConnectionManager
  extends b.d.d.b.a
{
  private final Map<String, TPMediaDevice> a = new ConcurrentHashMap();
  private final Map<String, TPMediaDeviceContext> b = new ConcurrentHashMap();
  private final Map<String, ?> c = new ConcurrentHashMap();
  
  public TPStreamConnectionManager(b.d.d.b.c paramc)
  {
    super(paramc);
  }
  
  public static TPMediaDevice a(@NonNull String paramString)
  {
    return ((TPStreamConnectionManager)e.a(b.d.d.c.a.b(), TPStreamConnectionManager.class)).c(paramString);
  }
  
  public static TPMediaDeviceContext b(@NonNull String paramString)
  {
    return ((TPStreamConnectionManager)e.a(b.d.d.c.a.b(), TPStreamConnectionManager.class)).d(paramString);
  }
  
  private TPMediaDeviceContext d(String paramString)
  {
    TPMediaDeviceContext localTPMediaDeviceContext1 = (TPMediaDeviceContext)this.b.get(paramString);
    TPMediaDevice localTPMediaDevice = (TPMediaDevice)this.a.get(paramString);
    TPMediaDeviceContext localTPMediaDeviceContext2;
    if (localTPMediaDeviceContext1 != null)
    {
      localTPMediaDeviceContext2 = localTPMediaDeviceContext1;
      if (localTPMediaDevice != null)
      {
        localTPMediaDeviceContext1.setDevice(localTPMediaDevice);
        localTPMediaDeviceContext2 = localTPMediaDeviceContext1;
      }
    }
    else
    {
      if (localTPMediaDevice != null) {
        localTPMediaDeviceContext2 = new TPMediaDeviceContext(localTPMediaDevice, this.mAccountContext);
      } else {
        localTPMediaDeviceContext2 = new TPMediaDeviceContext(paramString, this.mAccountContext);
      }
      this.b.put(paramString, localTPMediaDeviceContext2);
    }
    return localTPMediaDeviceContext2;
  }
  
  public TPMediaDevice c(@NonNull String paramString)
  {
    return (TPMediaDevice)this.a.get(paramString);
  }
  
  public q<List<TPMediaDeviceContext>> refreshDeviceList(List<TPMediaDevice> paramList)
  {
    f.m().q(paramList);
    Object localObject1 = new HashSet(this.a.keySet());
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramList = (TPMediaDevice)((Iterator)localObject2).next();
        localObject3 = b.d.p.c.b(paramList.getDeviceId());
        this.a.put(localObject3, paramList);
        ((Set)localObject1).remove(localObject3);
      }
    }
    paramList = new ArrayList();
    Object localObject3 = ((Set)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (String)((Iterator)localObject3).next();
      this.a.remove(localObject2);
      localObject1 = (TPMediaDeviceContext)this.b.remove(localObject2);
      this.c.remove(localObject2);
      paramList.add(localObject1);
    }
    return q.f0(paramList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreamclientmanager\TPStreamConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */