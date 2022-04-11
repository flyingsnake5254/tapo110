package com.tplink.libtpnetwork.IoTNetwork;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import com.tplink.libtpnetwork.TDPNetwork.a;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class w
{
  private static final a a = ;
  
  @SuppressLint({"MissingPermission"})
  private static String d(Application paramApplication)
  {
    paramApplication = (WifiManager)paramApplication.getSystemService("wifi");
    if ((paramApplication != null) && (paramApplication.getDhcpInfo() != null))
    {
      paramApplication = paramApplication.getDhcpInfo();
      int i = paramApplication.ipAddress;
      int j = paramApplication.netmask;
      paramApplication = Formatter.formatIpAddress(j ^ 0xFFFFFFFF | i & j);
    }
    else
    {
      paramApplication = "255.255.255.255";
    }
    return paramApplication;
  }
  
  private static boolean e(String paramString, long paramLong)
  {
    boolean bool1 = com.tplink.libtpwifi.b.k().r();
    boolean bool2 = true;
    int i;
    if ((bool1) && (com.tplink.libtpwifi.b.k().q(paramString))) {
      i = 1;
    } else {
      i = 0;
    }
    bool1 = bool2;
    if (i != 0) {
      if (System.currentTimeMillis() - paramLong > 5000L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static q<TDPIoTDevice> f(Application paramApplication, String paramString1, int paramInt, String paramString2, final String paramString3)
  {
    return g(paramApplication, paramString1, paramInt).S0(new c(paramString2, paramString3)).L(new b(paramString2, paramString3)).E(new a());
  }
  
  private static q<TDPIoTDevice> g(Application paramApplication, String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    return i(paramApplication, paramInt).N0(h(paramApplication, paramString, paramInt, l)).n0(q.I());
  }
  
  private static q<TDPIoTDevice> h(Application paramApplication, final String paramString, final int paramInt, final long paramLong)
  {
    return q.f0(Boolean.valueOf(e(paramString, paramLong))).N(new e()).N(new d(paramApplication, paramInt, paramString, paramLong));
  }
  
  private static q<TDPIoTDevice> i(Application paramApplication, int paramInt)
  {
    return a.y(d(paramApplication), paramInt, 500, 500).T(new g()).u(new f());
  }
  
  static final class a
    implements g<TDPIoTDevice>
  {
    public void a(TDPIoTDevice paramTDPIoTDevice)
      throws Exception
    {
      w.a().A();
    }
  }
  
  static final class b
    implements l<TDPIoTDevice>
  {
    b(String paramString1, String paramString2) {}
    
    public boolean a(TDPIoTDevice paramTDPIoTDevice)
      throws Exception
    {
      boolean bool1 = b.d.w.h.b.d(this.c);
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        if ((!b.d.w.h.b.d(paramTDPIoTDevice.getDeviceIdMd5())) && (paramTDPIoTDevice.isFactoryDefault()))
        {
          bool2 = bool3;
          if (b.d.w.h.b.d(paramString3)) {
            break label69;
          }
          if (paramString3.equals(paramTDPIoTDevice.getDeviceType()))
          {
            bool2 = bool3;
            break label69;
          }
        }
        bool2 = false;
        label69:
        return bool2;
      }
      if ((!this.c.equalsIgnoreCase(paramTDPIoTDevice.getDeviceIdMd5())) || (paramTDPIoTDevice.isFactoryDefault())) {
        bool2 = false;
      }
      return bool2;
    }
  }
  
  static final class c
    implements l<TDPIoTDevice>
  {
    c(String paramString1, String paramString2) {}
    
    public boolean a(TDPIoTDevice paramTDPIoTDevice)
      throws Exception
    {
      boolean bool1 = b.d.w.h.b.d(this.c);
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        if ((!b.d.w.h.b.d(paramTDPIoTDevice.getDeviceIdMd5())) && (paramTDPIoTDevice.isFactoryDefault()))
        {
          bool2 = bool3;
          if (b.d.w.h.b.d(paramString3)) {
            break label69;
          }
          if (paramString3.equals(paramTDPIoTDevice.getDeviceType()))
          {
            bool2 = bool3;
            break label69;
          }
        }
        bool2 = false;
        label69:
        return bool2;
      }
      if ((!this.c.equalsIgnoreCase(paramTDPIoTDevice.getDeviceIdMd5())) || (paramTDPIoTDevice.isFactoryDefault())) {
        bool2 = false;
      }
      return bool2;
    }
  }
  
  static final class d
    implements j<Long, t<TDPIoTDevice>>
  {
    d(Application paramApplication, int paramInt, String paramString, long paramLong) {}
    
    public t<TDPIoTDevice> a(Long paramLong)
      throws Exception
    {
      return w.c(this.c, paramInt).N0(w.b(this.c, paramString, paramInt, paramLong));
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
    implements j<TDPIoTDevice, String>
  {
    public String a(TDPIoTDevice paramTDPIoTDevice)
      throws Exception
    {
      return paramTDPIoTDevice.getDeviceIdMd5();
    }
  }
  
  static final class g
    implements j<Map<String, TDPIoTDevice>, Iterable<TDPIoTDevice>>
  {
    public Iterable<TDPIoTDevice> a(Map<String, TDPIoTDevice> paramMap)
      throws Exception
    {
      return paramMap.values();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */