package com.tplink.iot.Utils;

import android.content.Context;
import androidx.lifecycle.LiveData;
import b.d.b.f.b;
import com.google.gson.Gson;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.j;

public final class h
{
  private final String a;
  private final boolean b;
  private final Gson c;
  private final b.d.w.g.a d;
  private final List<ALCameraDevice> e;
  private final g f;
  private final ArrayList<String> g;
  private final boolean h;
  private final Context i;
  private final String j;
  
  public h(Context paramContext, String paramString)
  {
    this.i = paramContext;
    this.j = paramString;
    this.a = "CameraLiveConfigManager";
    this.b = true;
    this.c = new Gson();
    this.d = new b.d.w.g.a(paramContext, "CameraLiveConfig");
    this.g = new ArrayList();
    this.f = d();
    this.h = true;
    paramContext = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
    j.d(paramContext, "tpCameraClientManager");
    paramContext = paramContext.M1();
    if (paramContext != null)
    {
      paramContext = (List)paramContext.getValue();
      if (paramContext != null) {}
    }
    else
    {
      paramContext = new ArrayList();
    }
    this.e = paramContext;
  }
  
  private final g d()
  {
    String str = this.d.f(this.j, "");
    if (this.b)
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read:");
      localStringBuilder.append(str);
      b.d.w.c.a.c((String)localObject, localStringBuilder.toString());
    }
    Object localObject = new a().getType();
    return (g)this.c.m(str, (Type)localObject);
  }
  
  private final void e(g paramg)
  {
    String str1 = this.c.u(paramg);
    if (this.b)
    {
      String str2 = this.a;
      paramg = new StringBuilder();
      paramg.append("write:");
      paramg.append(str1);
      b.d.w.c.a.c(str2, paramg.toString());
    }
    this.d.k(this.j, str1);
  }
  
  public final ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    for (int k = 0; k < 32; k++) {
      localArrayList.add(null);
    }
    if (this.f == null)
    {
      if (this.b) {
        b.d.w.c.a.c(this.a, "get():无配置信息,直接返回");
      }
      localArrayList.set(0, this.j);
      return localArrayList;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      String str1 = ((ALCameraDevice)localIterator.next()).getDeviceIdMD5();
      this.g.add(str1);
      Integer localInteger = (Integer)this.f.a().get(str1);
      if (localInteger != null)
      {
        if (this.b)
        {
          String str2 = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get():位置");
          localStringBuilder.append(localInteger);
          localStringBuilder.append(" -> 播放设备");
          localStringBuilder.append(str1);
          b.d.w.c.a.c(str2, localStringBuilder.toString());
        }
        localArrayList.set(localInteger.intValue(), str1);
      }
    }
    return localArrayList;
  }
  
  public final boolean b()
  {
    return this.h;
  }
  
  public final void c(boolean paramBoolean, List<String> paramList)
  {
    j.e(paramList, "deviceIDMD5List");
    if (!paramList.contains(this.j)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    int k = 0;
    int m = paramList.size();
    Object localObject1;
    while (k < m)
    {
      localObject1 = (String)paramList.get(k);
      if (localObject1 != null) {
        localHashMap.put(localObject1, Integer.valueOf(k));
      }
      k++;
    }
    paramList = this.f;
    if (paramList != null)
    {
      paramList = paramList.a();
      localObject1 = new ArrayList();
      Object localObject2 = paramList.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (!this.g.contains(localObject3)) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      if (this.b)
      {
        localObject3 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("put(),unfoundedDeviceIDMD5List: ");
        ((StringBuilder)localObject2).append(i.a((ArrayList)localObject1));
        b.d.w.c.a.c((String)localObject3, ((StringBuilder)localObject2).toString());
      }
      Object localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (String)((Iterator)localObject3).next();
        localObject2 = (Integer)paramList.get(localObject1);
        if (localObject2 != null)
        {
          j.d(localObject2, "preMapping[deviceIDMD5] ?: return");
          k = ((Integer)localObject2).intValue();
          if (!localHashMap.values().contains(Integer.valueOf(k)))
          {
            j.d(localObject1, "deviceIDMD5");
            localHashMap.put(localObject1, Integer.valueOf(k));
            if (this.b)
            {
              localObject2 = this.a;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("put():未扫描到的设备");
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(" -> 位置");
              localStringBuilder.append(k);
              b.d.w.c.a.c((String)localObject2, localStringBuilder.toString());
            }
          }
        }
        else
        {
          return;
        }
      }
    }
    e(new g(paramBoolean, localHashMap));
  }
  
  public static final class a
    extends com.google.gson.r.a<g>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */