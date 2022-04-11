package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QuickDiscoveryRepository
  extends AbstractIoTCloudRepository
{
  private final Map<String, TDPIoTDevice> h = new ConcurrentHashMap();
  private final Set<String> i = new HashSet();
  private final Set<String> j = new HashSet();
  private final MutableLiveData<List<TDPIoTDevice>> k = new MutableLiveData();
  private final MutableLiveData<List<TDPIoTDevice>> l = new MutableLiveData();
  
  public QuickDiscoveryRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
  }
  
  private boolean A(@NonNull TDPIoTDevice paramTDPIoTDevice)
  {
    return this.j.contains(paramTDPIoTDevice.getDeviceIdMd5());
  }
  
  private static void B(String paramString)
  {
    b.d.w.c.a.n("QuickDiscovery", paramString);
  }
  
  private void E()
  {
    if (!this.h.isEmpty())
    {
      HashMap localHashMap = new HashMap();
      Object localObject1 = this.h.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!A((TDPIoTDevice)((Map.Entry)localObject2).getValue())) {
          localHashMap.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
      }
      this.i.clear();
      this.i.addAll(localHashMap.keySet());
      Object localObject2 = new ArrayList(this.h.values());
      localObject1 = new ArrayList(localHashMap.values());
      this.k.postValue(localObject2);
      this.l.postValue(localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendDiscoveryDevicesData consumed: ");
      ((StringBuilder)localObject1).append(i.j(this.j));
      B(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendDiscoveryDevicesData new: ");
      ((StringBuilder)localObject1).append(i.j(localHashMap));
      B(((StringBuilder)localObject1).toString());
    }
    else
    {
      this.k.postValue(new ArrayList());
      this.l.postValue(new ArrayList());
      B("sendDiscoveryDevicesData empty data");
    }
  }
  
  private void G(TDPIoTDevice paramTDPIoTDevice)
  {
    boolean bool1 = "apple".equals(paramTDPIoTDevice.getObdSrc());
    boolean bool2 = TextUtils.isEmpty(paramTDPIoTDevice.getDeviceIdMd5());
    boolean bool3 = TextUtils.isEmpty(paramTDPIoTDevice.getOwner());
    boolean bool4 = paramTDPIoTDevice.isFactoryDefault();
    if ((bool1) && ((bool2 ^ true)) && (bool3) && ((bool4 ^ true))) {
      this.h.put(paramTDPIoTDevice.getDeviceIdMd5(), paramTDPIoTDevice);
    }
  }
  
  public void C()
  {
    B("markConsumedDevices");
    this.j.addAll(this.i);
    this.i.clear();
  }
  
  public void D(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeDiscoveryDevice deviceIdMD5: ");
    localStringBuilder.append(paramString);
    B(localStringBuilder.toString());
    if ((TDPIoTDevice)this.h.remove(paramString) != null)
    {
      this.j.remove(paramString);
      E();
    }
  }
  
  public void F()
  {
    B("startDiscovery");
  }
  
  public void H(Map<String, ? extends TDPIoTDevice> paramMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("storeThirdPartyOnboardingDevices ");
    ((StringBuilder)localObject).append(i.f(paramMap));
    B(((StringBuilder)localObject).toString());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject = (TDPIoTDevice)((Map.Entry)paramMap.next()).getValue();
      if (!TextUtils.isEmpty(((TDPIoTDevice)localObject).getObdSrc())) {
        G((TDPIoTDevice)localObject);
      }
    }
  }
  
  public void w()
  {
    B("completeDiscovery");
    E();
  }
  
  public boolean x()
  {
    return this.h.isEmpty() ^ true;
  }
  
  public LiveData<List<TDPIoTDevice>> y()
  {
    return this.k;
  }
  
  public LiveData<List<TDPIoTDevice>> z()
  {
    return this.l;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\QuickDiscoveryRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */