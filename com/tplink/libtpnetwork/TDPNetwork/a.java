package com.tplink.libtpnetwork.TDPNetwork;

import android.app.Application;
import android.net.Network;
import android.util.Base64;
import b.d.c0.k;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.camera.TDPCameraDiscoverRequest;
import com.tplink.libtpnetwork.TDPNetwork.bean.camera.TDPCameraEncryptResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.camera.TDPCameraResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.camera.TDPCameraResult.EncryptedInfo;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.BaseTDPJsonResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.CommonTDPResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.CommonTDPResult.EncryptedInfo;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.TDPIoTResult;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.cameranetwork.util.f;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.tdp.bean.BaseTDPDevice;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class a
{
  private Application a;
  private io.reactivex.e0.b b = new io.reactivex.e0.b();
  private com.tplink.libtpnetwork.cameranetwork.util.b c = new com.tplink.libtpnetwork.cameranetwork.util.b();
  private k d;
  
  private <T extends BaseTDPDevice> q<List<T>> g(com.tplink.tdp.common.c<T> paramc)
  {
    k localk = new k(this.a, true);
    this.d = localk;
    return localk.D(paramc).n(new ArrayList()).q0(new ArrayList()).F(new j());
  }
  
  private TDPIoTDevice h(CommonTDPResult paramCommonTDPResult)
  {
    if (EnumDeviceType.fromType(paramCommonTDPResult.getDeviceType()) == EnumDeviceType.CAMERA) {
      return j(paramCommonTDPResult);
    }
    return new TDPIoTDevice(paramCommonTDPResult);
  }
  
  private TDPCameraDevice i(TDPCameraResult paramTDPCameraResult)
  {
    TDPCameraDevice localTDPCameraDevice = new TDPCameraDevice();
    localTDPCameraDevice.setDeviceName(paramTDPCameraResult.getDeviceName());
    localTDPCameraDevice.setFirmwareVer(paramTDPCameraResult.getFirmwareVer());
    localTDPCameraDevice.setHardwareVer(paramTDPCameraResult.getHardwareVer());
    localTDPCameraDevice.setIp(paramTDPCameraResult.getIp());
    localTDPCameraDevice.setMac(f.a(paramTDPCameraResult.getMac()));
    localTDPCameraDevice.setDeviceModel(paramTDPCameraResult.getDeviceModel());
    localTDPCameraDevice.setResetWiFi(paramTDPCameraResult.isResetWiFi());
    localTDPCameraDevice.setSupportIoTCloud(paramTDPCameraResult.isSupportIoTCloud());
    k(localTDPCameraDevice, paramTDPCameraResult.getEncryptedInfo().getKey(), paramTDPCameraResult.getEncryptedInfo().getData());
    return localTDPCameraDevice;
  }
  
  private TDPCameraDevice j(CommonTDPResult paramCommonTDPResult)
  {
    TDPCameraDevice localTDPCameraDevice = new TDPCameraDevice();
    localTDPCameraDevice.setDeviceName(paramCommonTDPResult.getDeviceName());
    localTDPCameraDevice.setFirmwareVer(paramCommonTDPResult.getFirmwareVer());
    localTDPCameraDevice.setHardwareVer(paramCommonTDPResult.getHardwareVer());
    localTDPCameraDevice.setIp(paramCommonTDPResult.getIp());
    localTDPCameraDevice.setMac(f.a(paramCommonTDPResult.getMac()));
    localTDPCameraDevice.setDeviceModel(paramCommonTDPResult.getDeviceModel());
    localTDPCameraDevice.setResetWiFi(paramCommonTDPResult.isResetWiFi());
    localTDPCameraDevice.setSupportIoTCloud(paramCommonTDPResult.isSupportIoTCloud());
    k(localTDPCameraDevice, paramCommonTDPResult.getEncryptedInfo().getKey(), paramCommonTDPResult.getEncryptedInfo().getData());
    return localTDPCameraDevice;
  }
  
  private void k(TDPCameraDevice paramTDPCameraDevice, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Base64.decode(paramString1, 2);
      byte[] arrayOfByte = com.tplink.libtpnetwork.cameranetwork.util.g.b().a(paramString1);
      paramString1 = Base64.decode(paramString2, 2);
      paramString2 = Arrays.copyOfRange(arrayOfByte, 0, 16);
      arrayOfByte = Arrays.copyOfRange(arrayOfByte, 16, 32);
      this.c.c(paramString2, arrayOfByte);
      paramString2 = new byte['က'];
      int i = this.c.a(paramString1, paramString2, paramString1.length);
      paramString1 = new java/lang/String;
      paramString1.<init>(paramString2, 0, i);
      paramString1 = (TDPCameraEncryptResult)i.b(paramString1, TDPCameraEncryptResult.class);
      paramTDPCameraDevice.setConnectSsid(paramString1.getConnectSsid());
      paramTDPCameraDevice.setConnectType(paramString1.getConnectType());
      paramTDPCameraDevice.setDeviceId(paramString1.getDeviceId());
      paramTDPCameraDevice.setDeviceIdMd5(b.d.w.h.a.g(paramString1.getDeviceId()));
      paramTDPCameraDevice.setHttpPort(paramString1.getHttpPort());
      paramTDPCameraDevice.setLastAlarmTime(paramString1.getLastAlarmTime());
      paramTDPCameraDevice.setLastAlarmType(paramString1.getLastAlarmType());
      paramTDPCameraDevice.setOwner(paramString1.getOwner());
      paramTDPCameraDevice.setSdStatus(paramString1.getSdStatus());
    }
    catch (Exception paramTDPCameraDevice)
    {
      paramTDPCameraDevice.printStackTrace();
    }
    catch (InvalidAlgorithmParameterException paramTDPCameraDevice)
    {
      paramTDPCameraDevice.printStackTrace();
    }
    catch (InvalidKeyException paramTDPCameraDevice)
    {
      paramTDPCameraDevice.printStackTrace();
    }
    catch (IllegalBlockSizeException paramTDPCameraDevice)
    {
      paramTDPCameraDevice.printStackTrace();
    }
    catch (BadPaddingException paramTDPCameraDevice)
    {
      paramTDPCameraDevice.printStackTrace();
    }
  }
  
  private List<CommonTDPResult> l(List<CommonTDPResult> paramList, List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommonTDPResult localCommonTDPResult = (CommonTDPResult)paramList.next();
      if (paramList1.contains(localCommonTDPResult.getDeviceType())) {
        localArrayList.add(localCommonTDPResult);
      }
    }
    return localArrayList;
  }
  
  private List<TDPCameraResult> m(List<TDPCameraResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (TDPCameraResult)localIterator.next();
      if (EnumDeviceType.CAMERA.getDeviceType().equals(paramList.getDeviceType())) {
        localArrayList.add(paramList);
      }
    }
    return localArrayList;
  }
  
  private Map<String, TDPIoTDevice> n(List<TDPIoTResult> paramList, List<String> paramList1)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TDPIoTResult localTDPIoTResult = (TDPIoTResult)paramList.next();
      String str = localTDPIoTResult.getDeviceIdMd5();
      if ((str != null) && (!str.isEmpty()) && (paramList1.contains(localTDPIoTResult.getDeviceType()))) {
        localHashMap.put(str, new TDPIoTDevice(localTDPIoTResult));
      }
    }
    return localHashMap;
  }
  
  private com.tplink.tdp.common.c<TDPCameraResult> o(int paramInt1, int paramInt2, int paramInt3)
  {
    com.tplink.tdp.common.c localc = new com.tplink.tdp.common.c((byte)2, TDPCameraResult.class, "255.255.255.255", paramInt1, paramInt2, paramInt3);
    try
    {
      TDPCameraDiscoverRequest localTDPCameraDiscoverRequest = new com/tplink/libtpnetwork/TDPNetwork/bean/camera/TDPCameraDiscoverRequest;
      localTDPCameraDiscoverRequest.<init>(com.tplink.libtpnetwork.cameranetwork.util.g.b().c());
      localc.j(i.f(localTDPCameraDiscoverRequest));
    }
    catch (IOException localIOException)
    {
      b.d.w.c.a.e(a.class.toString(), localIOException.toString());
    }
    return localc;
  }
  
  private com.tplink.tdp.common.c<CommonTDPResult> p(int paramInt1, int paramInt2, int paramInt3)
  {
    com.tplink.tdp.common.c localc = new com.tplink.tdp.common.c((byte)2, CommonTDPResult.class, "255.255.255.255", paramInt1, paramInt2, paramInt3);
    try
    {
      TDPCameraDiscoverRequest localTDPCameraDiscoverRequest = new com/tplink/libtpnetwork/TDPNetwork/bean/camera/TDPCameraDiscoverRequest;
      localTDPCameraDiscoverRequest.<init>(com.tplink.libtpnetwork.cameranetwork.util.g.b().c());
      localc.j(i.f(localTDPCameraDiscoverRequest));
    }
    catch (IOException localIOException)
    {
      b.d.w.c.a.e(a.class.toString(), localIOException.toString());
    }
    return localc;
  }
  
  public static a q()
  {
    return k.a();
  }
  
  public void A()
  {
    this.b.d();
  }
  
  public Network r()
  {
    k localk = this.d;
    if (localk == null) {
      return null;
    }
    return localk.d();
  }
  
  public void s(Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  public q<Map<String, ? extends TDPIoTDevice>> t(int paramInt1, int paramInt2, int paramInt3)
  {
    return g(p(paramInt1, paramInt2, paramInt3)).R0(1).g0(new f()).g0(new e());
  }
  
  public q<Map<String, ? extends TDPIoTDevice>> u()
  {
    return v(8, 300, 900);
  }
  
  public q<Map<String, ? extends TDPIoTDevice>> v(int paramInt1, int paramInt2, int paramInt3)
  {
    return g(p(paramInt1, paramInt2, paramInt3)).g0(new h()).g0(new g());
  }
  
  public q<Map<String, TDPCameraDevice>> w(int paramInt1, int paramInt2, int paramInt3)
  {
    return g(o(paramInt1, paramInt2, paramInt3)).R0(1).g0(new b()).g0(new a());
  }
  
  public q<Map<String, TDPCameraDevice>> x(int paramInt1, int paramInt2, int paramInt3)
  {
    return g(o(paramInt1, paramInt2, paramInt3)).g0(new d()).g0(new c());
  }
  
  public q<Map<String, TDPIoTDevice>> y(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return z(paramString, paramInt1, paramInt2, paramInt3, b.d.s.c.a.e());
  }
  
  public q<Map<String, TDPIoTDevice>> z(String paramString, int paramInt1, int paramInt2, int paramInt3, final List<String> paramList)
  {
    return g(new com.tplink.tdp.common.c((byte)2, TDPIoTResult.class, paramString, paramInt1, paramInt2, paramInt3)).g0(new i(paramList));
  }
  
  class a
    implements j<List<TDPCameraResult>, Map<String, TDPCameraDevice>>
  {
    a() {}
    
    public Map<String, TDPCameraDevice> a(List<TDPCameraResult> paramList)
      throws Exception
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TDPCameraResult)paramList.next();
        localObject = a.e(a.this, (TDPCameraResult)localObject);
        localHashMap.put(((TDPIoTDevice)localObject).getDeviceIdMd5(), localObject);
      }
      return localHashMap;
    }
  }
  
  class b
    implements j<List<TDPCameraResult>, List<TDPCameraResult>>
  {
    b() {}
    
    public List<TDPCameraResult> a(List<TDPCameraResult> paramList)
      throws Exception
    {
      return a.f(a.this, paramList);
    }
  }
  
  class c
    implements j<List<TDPCameraResult>, Map<String, TDPCameraDevice>>
  {
    c() {}
    
    public Map<String, TDPCameraDevice> a(List<TDPCameraResult> paramList)
      throws Exception
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TDPCameraResult)paramList.next();
        localObject = a.e(a.this, (TDPCameraResult)localObject);
        localHashMap.put(((TDPIoTDevice)localObject).getDeviceIdMd5(), localObject);
      }
      return localHashMap;
    }
  }
  
  class d
    implements j<List<TDPCameraResult>, List<TDPCameraResult>>
  {
    d() {}
    
    public List<TDPCameraResult> a(List<TDPCameraResult> paramList)
      throws Exception
    {
      return a.f(a.this, paramList);
    }
  }
  
  class e
    implements j<List<CommonTDPResult>, Map<String, ? extends TDPIoTDevice>>
  {
    e() {}
    
    public Map<String, ? extends TDPIoTDevice> a(List<CommonTDPResult> paramList)
      throws Exception
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (CommonTDPResult)paramList.next();
        localObject = a.a(a.this, (CommonTDPResult)localObject);
        localHashMap.put(((TDPIoTDevice)localObject).getDeviceIdMd5(), localObject);
      }
      return localHashMap;
    }
  }
  
  class f
    implements j<List<CommonTDPResult>, List<CommonTDPResult>>
  {
    f() {}
    
    public List<CommonTDPResult> a(List<CommonTDPResult> paramList)
      throws Exception
    {
      return a.b(a.this, paramList, b.d.s.c.a.d());
    }
  }
  
  class g
    implements j<List<CommonTDPResult>, Map<String, ? extends TDPIoTDevice>>
  {
    g() {}
    
    public Map<String, ? extends TDPIoTDevice> a(List<CommonTDPResult> paramList)
      throws Exception
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (CommonTDPResult)paramList.next();
        localObject = a.a(a.this, (CommonTDPResult)localObject);
        localHashMap.put(((TDPIoTDevice)localObject).getDeviceIdMd5(), localObject);
      }
      return localHashMap;
    }
  }
  
  class h
    implements j<List<CommonTDPResult>, List<CommonTDPResult>>
  {
    h() {}
    
    public List<CommonTDPResult> a(List<CommonTDPResult> paramList)
      throws Exception
    {
      return a.b(a.this, paramList, b.d.s.c.a.d());
    }
  }
  
  class i
    implements j<List<TDPIoTResult>, Map<String, TDPIoTDevice>>
  {
    i(List paramList) {}
    
    public Map<String, TDPIoTDevice> a(List<TDPIoTResult> paramList)
      throws Exception
    {
      return a.c(a.this, paramList, paramList);
    }
  }
  
  class j
    implements io.reactivex.g0.g<io.reactivex.e0.c>
  {
    j() {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      a.d(a.this).b(paramc);
    }
  }
  
  private static class k
  {
    private static final a a = new a(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */