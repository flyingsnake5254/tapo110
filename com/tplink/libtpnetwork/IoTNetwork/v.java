package com.tplink.libtpnetwork.IoTNetwork;

import android.app.Application;
import android.text.TextUtils;
import com.tplink.libtpnetwork.TDPNetwork.a;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.tdp.bean.BaseTDPDevice;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class v
{
  private static final a a = ;
  
  private static boolean d(String paramString, long paramLong)
  {
    boolean bool;
    if ((com.tplink.libtpwifi.b.k().r()) && (System.currentTimeMillis() - paramLong <= 5000L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static q<TDPCameraDevice> e(Application paramApplication, String paramString1, int paramInt, String paramString2, final boolean paramBoolean)
  {
    return f(paramApplication, paramString1, paramInt).S0(new c(paramString2, paramBoolean)).L(new b(paramString2, paramBoolean)).E(new a());
  }
  
  private static q<TDPCameraDevice> f(Application paramApplication, String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    return h(paramApplication, paramInt).N0(g(paramApplication, paramString, paramInt, l)).n0(q.I());
  }
  
  private static q<TDPCameraDevice> g(Application paramApplication, final String paramString, final int paramInt, final long paramLong)
  {
    return q.f0(Boolean.valueOf(d(paramString, paramLong))).N(new e()).N(new d(paramApplication, paramInt, paramString, paramLong));
  }
  
  private static q<TDPCameraDevice> h(Application paramApplication, int paramInt)
  {
    return a.x(paramInt, 500, 500).T(new g()).u(new f());
  }
  
  static final class a
    implements g<TDPCameraDevice>
  {
    public void a(TDPCameraDevice paramTDPCameraDevice)
      throws Exception
    {
      v.a().A();
    }
  }
  
  static final class b
    implements l<TDPCameraDevice>
  {
    b(String paramString, boolean paramBoolean) {}
    
    public boolean a(TDPCameraDevice paramTDPCameraDevice)
      throws Exception
    {
      boolean bool1 = b.d.w.h.b.d(this.c);
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        if (!b.d.w.h.b.d(paramTDPCameraDevice.getDeviceIdMd5()))
        {
          bool2 = bool3;
          if (TextUtils.isEmpty(paramTDPCameraDevice.getOwner())) {
            break label87;
          }
          if (!TextUtils.isEmpty(paramTDPCameraDevice.getOwner()))
          {
            bool2 = bool3;
            if (TextUtils.equals("192.168.191.1", paramTDPCameraDevice.getIp())) {
              break label87;
            }
          }
          if ((paramBoolean) && (paramTDPCameraDevice.isResetWiFi()))
          {
            bool2 = bool3;
            break label87;
          }
        }
        bool2 = false;
        label87:
        return bool2;
      }
      if ((!this.c.equalsIgnoreCase(paramTDPCameraDevice.getDeviceIdMd5())) || (TextUtils.isEmpty(paramTDPCameraDevice.getOwner()))) {
        bool2 = false;
      }
      return bool2;
    }
  }
  
  static final class c
    implements l<TDPCameraDevice>
  {
    c(String paramString, boolean paramBoolean) {}
    
    public boolean a(TDPCameraDevice paramTDPCameraDevice)
      throws Exception
    {
      boolean bool1 = b.d.w.h.b.d(this.c);
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        if (!b.d.w.h.b.d(paramTDPCameraDevice.getDeviceIdMd5()))
        {
          bool2 = bool3;
          if (TextUtils.isEmpty(paramTDPCameraDevice.getOwner())) {
            break label87;
          }
          if (!TextUtils.isEmpty(paramTDPCameraDevice.getOwner()))
          {
            bool2 = bool3;
            if (TextUtils.equals("192.168.191.1", paramTDPCameraDevice.getIp())) {
              break label87;
            }
          }
          if ((paramBoolean) && (paramTDPCameraDevice.isResetWiFi()))
          {
            bool2 = bool3;
            break label87;
          }
        }
        bool2 = false;
        label87:
        return bool2;
      }
      if ((!this.c.equalsIgnoreCase(paramTDPCameraDevice.getDeviceIdMd5())) || (TextUtils.isEmpty(paramTDPCameraDevice.getOwner()))) {
        bool2 = false;
      }
      return bool2;
    }
  }
  
  static final class d
    implements j<Long, t<TDPCameraDevice>>
  {
    d(Application paramApplication, int paramInt, String paramString, long paramLong) {}
    
    public t<TDPCameraDevice> a(Long paramLong)
      throws Exception
    {
      return v.c(this.c, paramInt).N0(v.b(this.c, paramString, paramInt, paramLong));
    }
  }
  
  static final class e
    implements j<Boolean, t<Long>>
  {
    public t<Long> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return q.J(new Exception());
      }
      return q.W0(500L, TimeUnit.MILLISECONDS);
    }
  }
  
  static final class f
    implements j<TDPCameraDevice, String>
  {
    public String a(TDPCameraDevice paramTDPCameraDevice)
      throws Exception
    {
      return paramTDPCameraDevice.getDeviceIdMd5();
    }
  }
  
  static final class g
    implements j<Map<String, TDPCameraDevice>, Iterable<TDPCameraDevice>>
  {
    public Iterable<TDPCameraDevice> a(Map<String, TDPCameraDevice> paramMap)
      throws Exception
    {
      return paramMap.values();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */