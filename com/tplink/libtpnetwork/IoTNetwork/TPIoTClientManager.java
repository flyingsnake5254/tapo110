package com.tplink.libtpnetwork.IoTNetwork;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.bean.firmware.params.FirmwareInfoParams;
import com.tplink.cloud.bean.firmware.result.FirmwareListResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleParams;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libmediaapi.device.MediaDeviceAPI;
import com.tplink.libmediaapi.device.apibean.MediaDevice;
import com.tplink.libmediaapi.device.apicallback.MediaDeviceListCallBack;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDeviceCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.DeviceShareRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickDiscoveryRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.CloudAndTDPBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.LoginAndTDPBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.e0;
import com.tplink.libtpnetwork.Utils.z;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraDeviceCache;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHomeState;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.enumerate.EnumLoginResult;
import io.reactivex.g0.j;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TPIoTClientManager
  extends AbstractIoTCloudRepository
{
  private MediatorLiveData<List<BaseALIoTDevice>> A = new MediatorLiveData();
  private MediatorLiveData<List<ALCameraDevice>> B = new MediatorLiveData();
  private MediatorLiveData<Map<String, List<BaseALIoTDevice>>> C = new MediatorLiveData();
  private Map<String, ThingFirmware> D = new HashMap();
  private MutableLiveData<Boolean> E = new MutableLiveData();
  private MutableLiveData<EnumHomeState> F = new MutableLiveData();
  private MutableLiveData<Boolean> G = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<BaseALIoTDevice>> H = new MutableLiveData();
  private io.reactivex.m0.g<Map<String, ? extends TDPIoTDevice>> I;
  private io.reactivex.m0.g<Boolean> J;
  private String K = null;
  private boolean L = false;
  private List<String> M = new ArrayList();
  private List<String> N = new ArrayList();
  private io.reactivex.e0.c O;
  private String h = TPIoTClientManager.class.getSimpleName();
  private EnumLoginResult i;
  private final Map<String, TPBaseDeviceContext> j = new ConcurrentHashMap();
  private final Map<String, BaseALIoTDevice> k = new ConcurrentHashMap();
  private final Map<String, x> l = new ConcurrentHashMap();
  private final Map<String, f4> m = new ConcurrentHashMap();
  private TCAccountRepository n;
  private TCDeviceRepository o;
  private DeviceShareRepository p;
  private ThingCloudRepository q;
  private SmartRepository r;
  private FamilyManagerRepository s;
  private GroupRepository t;
  private TCMessagePushRepository u;
  private CloudVideoRepository v;
  private com.tplink.libtpnetwork.Utils.o w = com.tplink.libtpnetwork.Utils.o.h0();
  private com.tplink.libtpnetwork.TDPNetwork.a x = com.tplink.libtpnetwork.TDPNetwork.a.q();
  private com.tplink.tpble.w y = com.tplink.tpble.w.a();
  private QuickDiscoveryRepository z;
  
  public TPIoTClientManager(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    parama = b.d.b.f.b.c(parama);
    this.n = ((TCAccountRepository)parama.a(TCAccountRepository.class));
    this.o = ((TCDeviceRepository)parama.a(TCDeviceRepository.class));
    this.q = ((ThingCloudRepository)parama.a(ThingCloudRepository.class));
    this.r = ((SmartRepository)parama.a(SmartRepository.class));
    this.s = ((FamilyManagerRepository)parama.a(FamilyManagerRepository.class));
    this.t = ((GroupRepository)parama.a(GroupRepository.class));
    this.u = ((TCMessagePushRepository)parama.a(TCMessagePushRepository.class));
    this.v = ((CloudVideoRepository)parama.a(CloudVideoRepository.class));
    this.p = ((DeviceShareRepository)parama.a(DeviceShareRepository.class));
    this.z = ((QuickDiscoveryRepository)parama.a(QuickDiscoveryRepository.class));
    this.A.addSource(this.o.E(), new k());
    this.A.addSource(this.q.g0(), new v());
  }
  
  private io.reactivex.q<List<TCDeviceBean>> A1()
  {
    return this.o.t().L0(io.reactivex.l0.a.c());
  }
  
  private io.reactivex.q<List<TCDeviceBean>> B1()
  {
    return this.o.t().L0(io.reactivex.l0.a.c());
  }
  
  private void B3(String paramString)
  {
    this.k.remove(paramString);
    TPBaseDeviceContext localTPBaseDeviceContext = (TPBaseDeviceContext)this.j.remove(paramString);
    if (localTPBaseDeviceContext != null) {
      com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.e(localTPBaseDeviceContext);
    }
    this.l.remove(paramString);
    this.m.remove(paramString);
    C3(paramString);
  }
  
  private void C3(String paramString)
  {
    this.D.remove(paramString);
    K3();
  }
  
  private void D3(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      B3(b.d.w.h.a.g((String)paramList.next()));
    }
    I3();
    L3();
  }
  
  private io.reactivex.q<IoTResult<List<ThingDevice>>> E1()
  {
    return this.q.U().v0(1L, new p0()).L0(io.reactivex.l0.a.c()).N(new o0()).q0(new IoTResult(1));
  }
  
  private void E3(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = new ArrayList(this.k.values());
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (BaseALIoTDevice)localIterator.next();
        if ((((BaseALIoTDevice)localObject).isSubDevice()) && (paramList.contains(((BaseALIoTDevice)localObject).getParentDeviceIDMD5())))
        {
          localArrayList1.add(((BaseALIoTDevice)localObject).getDeviceIdMD5());
          localArrayList2.add(((BaseALIoTDevice)localObject).getDeviceId());
        }
      }
      paramList = localArrayList1.iterator();
      while (paramList.hasNext()) {
        B3((String)paramList.next());
      }
      L3();
      this.s.Q0(localArrayList2, null);
    }
  }
  
  private io.reactivex.q<List<ThingDevice>> F1()
  {
    return this.q.U().L0(io.reactivex.l0.a.c()).q0(new ArrayList());
  }
  
  private void F3(List<String> paramList)
  {
    io.reactivex.q.f0(paramList).T(new e2()).E(new d2()).z(new c2()).F0();
  }
  
  private io.reactivex.q<List<ThingDevice>> G1()
  {
    return this.q.U().L0(io.reactivex.l0.a.c());
  }
  
  private void G3()
  {
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Object localObject3;
    try
    {
      List localList = b.d.w.d.a.c((String)localObject1, "iot_device_list_not_camera", "iot_device_list_not_camera", IoTDeviceCache.class);
    }
    catch (Exception localException2)
    {
      localObject3 = new ArrayList();
    }
    Object localObject2;
    try
    {
      localObject1 = b.d.w.d.a.c((String)localObject1, "only_camera_device_list", "only_camera_device_list", CameraDeviceCache.class);
    }
    catch (Exception localException1)
    {
      localObject2 = new ArrayList();
    }
    this.k.clear();
    Object localObject4;
    if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (IoTDeviceCache)((Iterator)localObject3).next();
        if (!EnumDeviceType.CAMERA.getDeviceType().equals(((IoTDeviceCache)localObject4).getDeviceType()))
        {
          localObject4 = new ALIoTDevice((IoTDeviceCache)localObject4);
          String str = ((BaseALIoTDevice)localObject4).getDeviceIdMD5();
          if (!TextUtils.isEmpty(str)) {
            this.k.put(str, localObject4);
          }
        }
      }
    }
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject3 = ((List)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = new ALCameraDevice((CameraDeviceCache)((Iterator)localObject3).next());
        localObject4 = ((BaseALIoTDevice)localObject2).getDeviceIdMD5();
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          this.k.put(localObject4, localObject2);
        }
      }
    }
    L3();
  }
  
  private BaseALIoTDevice H1(TDPIoTDevice paramTDPIoTDevice)
  {
    if ((paramTDPIoTDevice instanceof TDPCameraDevice)) {
      return new ALCameraDevice((TDPCameraDevice)paramTDPIoTDevice);
    }
    return new ALIoTDevice(paramTDPIoTDevice);
  }
  
  public static BaseALIoTDevice I1(@NonNull String paramString)
  {
    return ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).Z1(paramString);
  }
  
  private void I3()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.k.values().iterator();
    while (localIterator.hasNext())
    {
      localObject = (BaseALIoTDevice)localIterator.next();
      if ((localObject instanceof ALCameraDevice)) {
        localArrayList2.add(new CameraDeviceCache((ALCameraDevice)localObject));
      } else if ((localObject instanceof ALIoTDevice)) {
        localArrayList1.add(new IoTDeviceCache((ALIoTDevice)localObject));
      }
    }
    Object localObject = b.d.w.h.a.g(this.b.c().getCloudUserName());
    b.d.w.d.a.l((String)localObject, localArrayList1, "iot_device_list_not_camera", "iot_device_list_not_camera");
    b.d.w.d.a.l((String)localObject, localArrayList2, "only_camera_device_list", "only_camera_device_list");
  }
  
  public static TPCameraDeviceContext K1(@NonNull String paramString)
  {
    return ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).X3(paramString);
  }
  
  private void K3()
  {
    this.E.postValue(Boolean.valueOf(d1()));
  }
  
  private List<ALCameraDevice> L1(Collection<BaseALIoTDevice> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramCollection.next();
      if ((localBaseALIoTDevice instanceof ALCameraDevice)) {
        localArrayList.add((ALCameraDevice)localBaseALIoTDevice);
      }
    }
    return localArrayList;
  }
  
  private io.reactivex.q<u> M3(Application paramApplication, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return w.f(paramApplication, paramString1, paramInt, paramString2, paramString3).g0(new v0()).n(new u());
  }
  
  private void N1(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice.isSwitch()) {
      paramBaseALIoTDevice = (AbstractSubThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class);
    } else if (paramBaseALIoTDevice.isSensor()) {
      paramBaseALIoTDevice = (AbstractSubThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SensorRepository.class);
    } else {
      paramBaseALIoTDevice = null;
    }
    if (paramBaseALIoTDevice != null)
    {
      paramBaseALIoTDevice.j1();
      paramBaseALIoTDevice.T0();
    }
  }
  
  private io.reactivex.q<IoTResult<Map<String, BaseALIoTDevice>>> O1(final b.d.s.a.b.a parama)
  {
    return io.reactivex.q.f1(A1(), F1(), new p(parama)).q0(new IoTResult(1)).E0(new IoTResult(0, new HashMap()));
  }
  
  private io.reactivex.q<Boolean> Q3(final String paramString1, final String paramString2)
  {
    final Object localObject = (BaseALIoTDevice)this.k.get(paramString1);
    if (!(localObject instanceof ALCameraDevice)) {
      return io.reactivex.q.f0(Boolean.FALSE);
    }
    localObject = (ALCameraDevice)localObject;
    return io.reactivex.q.f0(V3((BaseALIoTDevice)localObject)).g0(new w1()).N(new v1(paramString2)).z(new u1((ALCameraDevice)localObject, paramString2, paramString1));
  }
  
  private List<BaseALIoTDevice> R1(List<BaseALIoTDevice> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      if ((paramList != null) && (v2(paramList.isUserRoleTypeDevice(), paramList.isSupportIoTCloud(), paramList.getFamilyId()))) {
        localArrayList.add(paramList);
      }
    }
    return localArrayList;
  }
  
  private void S3(b.d.s.a.b.a parama, List<TCDeviceBean> paramList, List<ThingDevice> paramList1)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TCDeviceBean localTCDeviceBean = (TCDeviceBean)paramList.next();
      if ((localTCDeviceBean != null) && (localTCDeviceBean.getDeviceId() != null))
      {
        localArrayList1.add(localTCDeviceBean.getDeviceId());
        if (localTCDeviceBean.isCamera()) {
          localArrayList2.add(localTCDeviceBean.getDeviceId());
        }
      }
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList = (ThingDevice)paramList1.next();
      if ((paramList != null) && (paramList.getThingName() != null) && (!localArrayList1.contains(paramList.getThingName()))) {
        localArrayList1.add(paramList.getThingName());
      }
    }
    paramList = parama;
    if (parama == null) {
      paramList = new b.d.s.a.b.a();
    }
    this.L = false;
    io.reactivex.q.f0(paramList).R(new q0()).c(x2(localArrayList1, localArrayList2)).C(io.reactivex.l0.a.c()).y();
  }
  
  private io.reactivex.q<Boolean> U0(List<String> paramList)
  {
    final Map localMap = n2(paramList);
    F3(paramList);
    if (!localMap.isEmpty()) {
      io.reactivex.q.Y(localMap.keySet()).N(new b2(localMap)).z(new l(this, paramList)).F0();
    }
    l1(paramList);
    return io.reactivex.q.f0(Boolean.TRUE);
  }
  
  private TPBaseDeviceContext U3(BaseALIoTDevice paramBaseALIoTDevice)
  {
    TPBaseDeviceContext localTPBaseDeviceContext = (TPBaseDeviceContext)this.j.get(paramBaseALIoTDevice.getDeviceIdMD5());
    if (localTPBaseDeviceContext == null)
    {
      if ((paramBaseALIoTDevice instanceof ALCameraDevice)) {
        paramBaseALIoTDevice = new TPCameraDeviceContext(this.b, paramBaseALIoTDevice);
      } else if ((paramBaseALIoTDevice instanceof ALIoTDevice)) {
        paramBaseALIoTDevice = new ThingContext(this.b, paramBaseALIoTDevice);
      } else {
        paramBaseALIoTDevice = new ThingContext(paramBaseALIoTDevice.getDeviceIdMD5(), this.b);
      }
      this.j.put(paramBaseALIoTDevice.getDeviceIdMD5(), paramBaseALIoTDevice);
    }
    else
    {
      localTPBaseDeviceContext = c1(paramBaseALIoTDevice, localTPBaseDeviceContext);
      localTPBaseDeviceContext.setIoTDevice(paramBaseALIoTDevice);
      paramBaseALIoTDevice = localTPBaseDeviceContext;
    }
    if ((paramBaseALIoTDevice instanceof TPCameraDeviceContext)) {
      o4((TPCameraDeviceContext)paramBaseALIoTDevice);
    } else {
      r4((ThingContext)paramBaseALIoTDevice);
    }
    return paramBaseALIoTDevice;
  }
  
  private io.reactivex.q<Boolean> V0(List<String> paramList)
  {
    F3(paramList);
    l1(paramList);
    return this.o.Q(paramList).z(new i(this, paramList)).q0(Boolean.FALSE);
  }
  
  private TPCameraDeviceContext V3(BaseALIoTDevice paramBaseALIoTDevice)
  {
    return W3(paramBaseALIoTDevice, this.b);
  }
  
  private io.reactivex.q<Boolean> W0(List<String> paramList)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      localObject = (BaseALIoTDevice)this.k.get(localObject);
      if ((localObject != null) && (((BaseALIoTDevice)localObject).isSwitch()))
      {
        localHashSet1.add(((BaseALIoTDevice)localObject).getDeviceId());
        if (!TextUtils.isEmpty(((BaseALIoTDevice)localObject).getOriginalDeviceId())) {
          localHashSet2.add(((BaseALIoTDevice)localObject).getOriginalDeviceId());
        }
      }
    }
    Object localObject = new ArrayList(this.k.values()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (BaseALIoTDevice)((Iterator)localObject).next();
      if ((paramList.isSwitch()) && (!TextUtils.isEmpty(paramList.getOriginalDeviceId())) && (localHashSet2.contains(paramList.getOriginalDeviceId()))) {
        localHashSet1.add(paramList.getDeviceId());
      }
    }
    paramList = new StringBuilder();
    paramList.append("switchIdSet: ");
    paramList.append(com.tplink.libtpnetwork.Utils.i.j(localHashSet1));
    b.d.w.c.a.n("deleteSwitch", paramList.toString());
    paramList = new StringBuilder();
    paramList.append("originDeviceIdSet: ");
    paramList.append(com.tplink.libtpnetwork.Utils.i.j(localHashSet2));
    b.d.w.c.a.n("deleteSwitch", paramList.toString());
    return U0(new ArrayList(localHashSet1));
  }
  
  private TPCameraDeviceContext W3(BaseALIoTDevice paramBaseALIoTDevice, com.tplink.cloud.context.b paramb)
  {
    TPBaseDeviceContext localTPBaseDeviceContext = (TPBaseDeviceContext)this.j.get(paramBaseALIoTDevice.getDeviceIdMD5());
    if ((localTPBaseDeviceContext instanceof TPCameraDeviceContext))
    {
      localTPBaseDeviceContext.setIoTDevice(paramBaseALIoTDevice);
      paramBaseALIoTDevice = localTPBaseDeviceContext;
    }
    else
    {
      paramBaseALIoTDevice = new TPCameraDeviceContext(paramb, paramBaseALIoTDevice);
      this.j.put(paramBaseALIoTDevice.getDeviceIdMD5(), paramBaseALIoTDevice);
    }
    paramBaseALIoTDevice = (TPCameraDeviceContext)paramBaseALIoTDevice;
    o4(paramBaseALIoTDevice);
    return paramBaseALIoTDevice;
  }
  
  private io.reactivex.a X0(List<DeviceUserRoleParams> paramList)
  {
    final ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((DeviceUserRoleParams)localIterator.next()).getThingName());
    }
    D3(localArrayList);
    return this.p.w(paramList).C(io.reactivex.l0.a.c()).i(new f2(localArrayList));
  }
  
  private TPCameraDeviceContext X3(String paramString)
  {
    TPBaseDeviceContext localTPBaseDeviceContext = (TPBaseDeviceContext)this.j.get(paramString);
    Object localObject;
    if ((localTPBaseDeviceContext instanceof TPCameraDeviceContext))
    {
      paramString = (BaseALIoTDevice)this.k.get(paramString);
      localObject = localTPBaseDeviceContext;
      if ((paramString instanceof ALCameraDevice))
      {
        ((TPCameraDeviceContext)localTPBaseDeviceContext).setIoTDevice((ALCameraDevice)paramString);
        localObject = localTPBaseDeviceContext;
      }
    }
    else
    {
      localObject = (BaseALIoTDevice)this.k.get(paramString);
      if ((localObject instanceof ALCameraDevice)) {
        localObject = new TPCameraDeviceContext(this.b, (BaseALIoTDevice)localObject);
      } else {
        localObject = new TPCameraDeviceContext(paramString, this.b);
      }
      this.j.put(paramString, localObject);
    }
    return (TPCameraDeviceContext)localObject;
  }
  
  private io.reactivex.q<Boolean> Z0(final b.d.s.a.b.a parama)
  {
    return b1().N(new y0(parama)).L0(io.reactivex.l0.a.c());
  }
  
  private ThingContext a2(String paramString)
  {
    this.l.remove(paramString);
    this.j.remove(paramString);
    x localx = new x();
    localx.q(new com.tplink.libtpnetwork.IoTNetwork.y.c.c(paramString));
    this.l.put(paramString, localx);
    return d4(paramString);
  }
  
  private ThingContext a4(BaseALIoTDevice paramBaseALIoTDevice)
  {
    return b4(paramBaseALIoTDevice, this.b);
  }
  
  private io.reactivex.q<Boolean> b1()
  {
    return io.reactivex.q.X(new z0());
  }
  
  private ThingContext b4(BaseALIoTDevice paramBaseALIoTDevice, com.tplink.cloud.context.b paramb)
  {
    TPBaseDeviceContext localTPBaseDeviceContext = (TPBaseDeviceContext)this.j.get(paramBaseALIoTDevice.getDeviceIdMD5());
    if ((localTPBaseDeviceContext instanceof ThingContext))
    {
      localTPBaseDeviceContext.setIoTDevice(paramBaseALIoTDevice);
      paramBaseALIoTDevice = localTPBaseDeviceContext;
    }
    else
    {
      paramBaseALIoTDevice = new ThingContext(paramb, paramBaseALIoTDevice);
      this.j.put(paramBaseALIoTDevice.getDeviceIdMD5(), paramBaseALIoTDevice);
    }
    paramBaseALIoTDevice = (ThingContext)paramBaseALIoTDevice;
    r4(paramBaseALIoTDevice);
    return paramBaseALIoTDevice;
  }
  
  private TPBaseDeviceContext c1(BaseALIoTDevice paramBaseALIoTDevice, TPBaseDeviceContext paramTPBaseDeviceContext)
  {
    boolean bool1 = paramBaseALIoTDevice instanceof ALCameraDevice;
    boolean bool2 = paramTPBaseDeviceContext instanceof TPCameraDeviceContext;
    if ((bool1) && (!bool2))
    {
      paramTPBaseDeviceContext = new TPCameraDeviceContext(this.b, paramBaseALIoTDevice);
      this.j.put(paramBaseALIoTDevice.getDeviceIdMD5(), paramTPBaseDeviceContext);
      return paramTPBaseDeviceContext;
    }
    bool1 = paramBaseALIoTDevice instanceof ALIoTDevice;
    bool2 = paramTPBaseDeviceContext instanceof ThingContext;
    Object localObject = paramTPBaseDeviceContext;
    if (bool1)
    {
      localObject = paramTPBaseDeviceContext;
      if (!bool2)
      {
        localObject = new ThingContext(this.b, paramBaseALIoTDevice);
        this.j.put(paramBaseALIoTDevice.getDeviceIdMD5(), localObject);
      }
    }
    return (TPBaseDeviceContext)localObject;
  }
  
  private ThingContext c4(String paramString)
  {
    TPBaseDeviceContext localTPBaseDeviceContext = (TPBaseDeviceContext)this.j.get(paramString);
    Object localObject;
    if ((localTPBaseDeviceContext instanceof ThingContext))
    {
      paramString = (BaseALIoTDevice)this.k.get(paramString);
      localObject = localTPBaseDeviceContext;
      if ((paramString instanceof ALIoTDevice))
      {
        ((ThingContext)localTPBaseDeviceContext).setIoTDevice((ALIoTDevice)paramString);
        localObject = localTPBaseDeviceContext;
      }
    }
    else
    {
      localObject = (BaseALIoTDevice)this.k.get(paramString);
      if ((localObject instanceof ALIoTDevice)) {
        localObject = new ThingContext(this.b, (BaseALIoTDevice)localObject);
      } else {
        localObject = new ThingContext(paramString, this.b);
      }
      this.j.put(paramString, localObject);
    }
    return (ThingContext)localObject;
  }
  
  private boolean d1()
  {
    Object localObject1 = this.D;
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      localObject1 = this.D.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)this.k.get(localObject2);
        if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceState() != EnumIoTDeviceState.OFFLINE))
        {
          localObject2 = (ThingFirmware)this.D.get(localObject2);
          if ((localObject2 != null) && (((ThingFirmware)localObject2).isNeedToUpgrade())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private t<Boolean> d2(ALIoTDevice paramALIoTDevice)
  {
    paramALIoTDevice = a4(m2(paramALIoTDevice, true));
    String str1 = paramALIoTDevice.getThingUrl();
    String str2 = paramALIoTDevice.getThingName();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return this.q.p0(paramALIoTDevice.getThingUrl(), paramALIoTDevice.getThingName()).g0(a.c).E(new r2()).C(new q2()).q0(Boolean.FALSE);
    }
    return io.reactivex.q.f0(Boolean.FALSE);
  }
  
  private ThingContext d4(String paramString)
  {
    TPBaseDeviceContext localTPBaseDeviceContext = (TPBaseDeviceContext)this.j.get(paramString);
    Object localObject = localTPBaseDeviceContext;
    if (!(localTPBaseDeviceContext instanceof ThingContext))
    {
      localObject = new ThingContext(paramString, this.b);
      this.j.put(((TPBaseDeviceContext)localObject).getDeviceIdMD5(), localObject);
    }
    return (ThingContext)localObject;
  }
  
  private void e1()
  {
    if (this.I == null)
    {
      io.reactivex.m0.g localg = io.reactivex.m0.e.n1().l1();
      this.I = localg;
      localg.onNext(new HashMap());
      this.I.onComplete();
    }
  }
  
  private io.reactivex.q<Boolean> f1(b.d.s.a.b.a parama)
  {
    return this.n.C(x1(), parama.b(), parama.g(), parama.f(), parama.c(), false);
  }
  
  private List<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> f2(List<BaseALIoTDevice> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      if ((paramList instanceof ALCameraDevice))
      {
        localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(V3(paramList), CommonCameraRepository.class));
      }
      else
      {
        ThingContext localThingContext = a4(paramList);
        if (paramList.isBulb())
        {
          if (paramList.isLightStrip()) {
            localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(localThingContext, LightStripRepository.class));
          } else {
            localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(localThingContext, BulbRepository.class));
          }
        }
        else if (paramList.isHub()) {
          localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(localThingContext, HubRepository.class));
        } else if (paramList.isSensor()) {
          localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(localThingContext, SensorRepository.class));
        } else if (paramList.isSwitch()) {
          localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(localThingContext, SwitchRepository.class));
        } else if (paramList.isEnergy()) {
          localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(localThingContext, TRVRepository.class));
        } else {
          localArrayList.add(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(localThingContext, PlugRepository.class));
        }
      }
    }
    return localArrayList;
  }
  
  private void f3()
  {
    Iterator localIterator = this.k.values().iterator();
    while (localIterator.hasNext()) {
      ((BaseALIoTDevice)localIterator.next()).setDeviceState(EnumIoTDeviceState.OFFLINE);
    }
    L3();
  }
  
  private List<BaseALIoTDevice> g1(List<TCDeviceBean> paramList, Map<String, ? extends TDPIoTDevice> paramMap)
  {
    Object localObject = new HashSet();
    Iterator localIterator = this.k.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((BaseALIoTDevice)localEntry.getValue() instanceof ALCameraDevice)) {
        ((Set)localObject).add(localEntry.getKey());
      }
    }
    p2(paramList, paramMap, new HashMap(), (Set)localObject);
    localObject = new ArrayList();
    paramList = this.k.values().iterator();
    while (paramList.hasNext())
    {
      paramMap = (BaseALIoTDevice)paramList.next();
      if ((paramMap instanceof ALCameraDevice)) {
        ((List)localObject).add(paramMap);
      }
    }
    return (List<BaseALIoTDevice>)localObject;
  }
  
  private io.reactivex.q<Boolean> g2(List<BaseALIoTDevice> paramList)
  {
    return io.reactivex.q.f0(Integer.valueOf(paramList.size())).N(new q(this, paramList)).N(new o());
  }
  
  private t<Map<String, ? extends TDPIoTDevice>> g3()
  {
    return this.x.w(2, 500, 1200).g0(new m1());
  }
  
  private io.reactivex.q<Boolean> g4(boolean paramBoolean)
  {
    return io.reactivex.q.f0(Boolean.valueOf(paramBoolean)).N(new g1()).E(new f1()).y(new e1());
  }
  
  private Map<String, BaseALIoTDevice> h1(List<TCDeviceBean> paramList, List<ThingDevice> paramList1)
  {
    HashMap localHashMap = new HashMap();
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (TCDeviceBean)((Iterator)localObject).next();
        if (paramList.isCamera()) {
          paramList = new ALCameraDevice(paramList);
        } else {
          paramList = new ALIoTDevice(paramList);
        }
        localHashMap.put(paramList.getDeviceIdMD5(), paramList);
      }
    }
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList = (ThingDevice)paramList1.next();
        localObject = b.d.w.h.a.g(paramList.getThingName());
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localHashMap.get(localObject);
        if (localBaseALIoTDevice != null)
        {
          localBaseALIoTDevice.setThingDevice(paramList);
        }
        else
        {
          if (paramList.isCamera()) {
            paramList = new ALCameraDevice(paramList);
          } else {
            paramList = new ALIoTDevice(paramList);
          }
          localHashMap.put(localObject, paramList);
        }
      }
    }
    return localHashMap;
  }
  
  private io.reactivex.q<Map<String, ? extends TDPIoTDevice>> h3()
  {
    return this.x.t(8, 300, 1800).F(new r(this)).g0(new l1()).y(new b(this));
  }
  
  private List<BaseALIoTDevice> h4(Map<String, ? extends TDPIoTDevice> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      localArrayList.add(m2(H1((TDPIoTDevice)paramMap.next()), false));
    }
    L3();
    return localArrayList;
  }
  
  private List<BaseALIoTDevice> i1(List<TCDeviceBean> paramList, Map<String, ? extends TDPIoTDevice> paramMap, Map<String, ThingDevice> paramMap1)
  {
    p2(paramList, paramMap, paramMap1, new HashSet(this.k.keySet()));
    return new ArrayList(this.k.values());
  }
  
  @SuppressLint({"CheckResult"})
  private io.reactivex.q<Map<String, ? extends TDPIoTDevice>> i2()
  {
    final ArrayList localArrayList = new ArrayList();
    return this.x.u().F(new c(this)).g0(new d1(localArrayList)).E(new b1()).z(new a1()).y(new h(this));
  }
  
  private io.reactivex.q<Boolean> i3()
  {
    io.reactivex.m0.g localg = this.I;
    if ((localg == null) || (localg.j1()))
    {
      this.I = io.reactivex.m0.e.n1().l1();
      i2().L0(io.reactivex.l0.a.c()).F0();
    }
    return this.I.g0(new j1()).N(new i1()).N(new h1());
  }
  
  private List<BaseALIoTDevice> i4(Map<String, BaseALIoTDevice> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = m2((BaseALIoTDevice)localIterator.next(), true);
      if ((!localBaseALIoTDevice.isSubDevice()) || (paramMap.get(localBaseALIoTDevice.getParentDeviceIDMD5()) == null)) {
        localArrayList.add(localBaseALIoTDevice);
      }
    }
    return localArrayList;
  }
  
  private List<BaseALIoTDevice> j1(Map<String, BaseALIoTDevice> paramMap1, Map<String, BaseALIoTDevice> paramMap2, Map<String, ? extends TDPIoTDevice> paramMap, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (TDPIoTDevice)localIterator.next();
      if (z2((TDPIoTDevice)localObject2, (String)localObject1))
      {
        paramMap = ((TDPIoTDevice)localObject2).getDeviceIdMd5();
        if ((paramList.contains(paramMap) ^ true))
        {
          localObject2 = m2(H1((TDPIoTDevice)localObject2), true);
          BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramMap1.remove(paramMap);
          paramMap2.remove(paramMap);
          if (localBaseALIoTDevice != null)
          {
            ((BaseALIoTDevice)localObject2).setCloudIoTDevice(localBaseALIoTDevice.getCloudIoTDevice());
            ((BaseALIoTDevice)localObject2).setThingDevice(localBaseALIoTDevice.getThingDevice());
          }
          paramList.add(paramMap);
          localArrayList.add(localObject2);
        }
        else
        {
          localObject2 = (BaseALIoTDevice)paramMap1.remove(paramMap);
          paramMap2.remove(paramMap);
          if (localObject2 != null) {
            m2((BaseALIoTDevice)localObject2, false);
          }
        }
      }
    }
    paramMap = paramMap1.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject1 = (Map.Entry)paramMap.next();
      paramMap1 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (BaseALIoTDevice)((Map.Entry)localObject1).getValue();
      if ((!TextUtils.isEmpty(paramMap1)) && (localObject1 != null) && (!TextUtils.isEmpty(paramMap1)) && (paramList.contains(paramMap1)))
      {
        m2((BaseALIoTDevice)localObject1, false);
        paramMap.remove();
        paramMap2.remove(paramMap1);
      }
    }
    if (!localArrayList.isEmpty()) {
      L3();
    }
    return localArrayList;
  }
  
  private io.reactivex.q<Boolean> j2()
  {
    io.reactivex.m0.g localg = this.J;
    if ((localg != null) && (!localg.k1())) {
      return this.J.n(Boolean.FALSE).E(new j2());
    }
    this.i = EnumLoginResult.FAIL;
    return io.reactivex.q.f0(Boolean.FALSE);
  }
  
  private io.reactivex.q<Boolean> j3(List<BaseALIoTDevice> paramList)
  {
    return io.reactivex.q.f0(Integer.valueOf(paramList.size())).N(new f(this, paramList)).N(new i0());
  }
  
  private List<BaseALIoTDevice> j4(Map<String, ? extends TDPIoTDevice> paramMap, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    String str = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      TDPIoTDevice localTDPIoTDevice = (TDPIoTDevice)localIterator.next();
      if (z2(localTDPIoTDevice, str))
      {
        boolean bool = paramList.contains(localTDPIoTDevice.getDeviceIdMd5()) ^ true;
        paramMap = m2(H1(localTDPIoTDevice), bool);
        if (bool)
        {
          paramList.add(localTDPIoTDevice.getDeviceIdMd5());
          localArrayList.add(paramMap);
        }
      }
    }
    L3();
    return localArrayList;
  }
  
  private List<BaseALIoTDevice> k1(Map<String, ? extends TDPIoTDevice> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = new HashSet(this.k.keySet()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)this.k.get(localObject);
      if ((localBaseALIoTDevice instanceof ALIoTDevice))
      {
        ALIoTDevice localALIoTDevice = (ALIoTDevice)localBaseALIoTDevice;
        if (localALIoTDevice.getTDPIoTDevice() != null)
        {
          localObject = (TDPIoTDevice)paramMap.get(localObject);
          if (!(localObject instanceof TDPCameraDevice))
          {
            localALIoTDevice.setTDPIoTDevice((TDPIoTDevice)localObject);
            localALIoTDevice.setBackupFromCache(false);
          }
          if (localObject == null) {
            localArrayList.add(localBaseALIoTDevice);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static ThingContext k2(@NonNull String paramString)
  {
    return ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).c4(paramString);
  }
  
  private Map<String, ThingDevice> k4(List<ThingDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ThingDevice localThingDevice = (ThingDevice)paramList.next();
        if (!TextUtils.isEmpty(localThingDevice.getThingName())) {
          localHashMap.put(b.d.w.h.a.g(localThingDevice.getThingName()), localThingDevice);
        }
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  private void l1(List<String> paramList)
  {
    this.v.G(paramList).y();
  }
  
  private io.reactivex.q<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> l2(List<BaseALIoTDevice> paramList)
  {
    return io.reactivex.q.Y(f2(paramList));
  }
  
  private io.reactivex.q<Boolean> l3(boolean paramBoolean)
  {
    return s3(paramBoolean).g0(new e0()).N(new d0()).z(new c0());
  }
  
  private BaseALIoTDevice m2(BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean)
  {
    BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)this.k.get(paramBaseALIoTDevice.getDeviceIdMD5());
    if (localBaseALIoTDevice == null)
    {
      this.k.put(paramBaseALIoTDevice.getDeviceIdMD5(), paramBaseALIoTDevice);
    }
    else
    {
      if (paramBaseALIoTDevice.getLocalIoTDevice() != null) {
        localBaseALIoTDevice.setLocalIoTDevice(paramBaseALIoTDevice.getLocalIoTDevice());
      }
      if (paramBaseALIoTDevice.getTDPIoTDevice() != null) {
        localBaseALIoTDevice.setTDPIoTDevice(paramBaseALIoTDevice.getTDPIoTDevice());
      }
      if (paramBaseALIoTDevice.getCloudIoTDevice() != null) {
        localBaseALIoTDevice.setCloudIoTDevice(paramBaseALIoTDevice.getCloudIoTDevice());
      }
      if (paramBaseALIoTDevice.getThingDevice() != null) {
        localBaseALIoTDevice.setThingDevice(paramBaseALIoTDevice.getThingDevice());
      }
      if (paramBoolean)
      {
        localBaseALIoTDevice.setDeviceState(paramBaseALIoTDevice.getDeviceState());
        localBaseALIoTDevice.setDataFromThing(paramBaseALIoTDevice.isDataFromThing());
      }
      localBaseALIoTDevice.setBackupFromCache(paramBaseALIoTDevice.isBackupFromCache());
      paramBaseALIoTDevice = localBaseALIoTDevice;
    }
    return paramBaseALIoTDevice;
  }
  
  private io.reactivex.q<Boolean> m3(boolean paramBoolean)
  {
    return io.reactivex.q.f1(y1(), s3(paramBoolean), new b0()).N(new a0()).z(new z());
  }
  
  private io.reactivex.q<Boolean> m4(final TCAccountBean paramTCAccountBean, b.d.s.a.b.a parama, final boolean paramBoolean)
  {
    return Z0(parama).F(new y1(paramTCAccountBean)).g0(new n1()).o0(new c1(paramBoolean)).z(new r0(paramBoolean));
  }
  
  private Map<String, List<String>> n2(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = b.d.w.h.a.g(str);
      paramList = (TPBaseDeviceContext)this.j.get(paramList);
      if (paramList != null) {
        paramList = paramList.getThingUrl();
      } else {
        paramList = null;
      }
      if (!TextUtils.isEmpty(paramList))
      {
        Object localObject = (List)localHashMap.get(paramList);
        if (localObject != null)
        {
          ((List)localObject).add(str);
        }
        else
        {
          localObject = new ArrayList();
          ((List)localObject).add(str);
          localHashMap.put(paramList, localObject);
        }
      }
    }
    return localHashMap;
  }
  
  private io.reactivex.q<Boolean> n3(List<BaseALIoTDevice> paramList)
  {
    return l2(paramList).N(new j0());
  }
  
  private io.reactivex.q<Boolean> n4(TCAccountBean paramTCAccountBean, b.d.s.a.b.a parama)
  {
    return m4(paramTCAccountBean, parama, false).T0(5L, TimeUnit.SECONDS).o0(new g0());
  }
  
  private io.reactivex.q<Boolean> o1(String paramString)
  {
    Object localObject = b.d.w.h.a.g(paramString);
    localObject = (TPBaseDeviceContext)this.j.get(localObject);
    if ((localObject instanceof ThingContext)) {
      localObject = ((ThingContext)localObject).getThingUrl();
    } else {
      localObject = null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    F3(localArrayList);
    l1(localArrayList);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return this.q.K((String)localObject, localArrayList).z(new o(this, paramString)).q0(Boolean.FALSE);
    }
    return io.reactivex.q.f0(Boolean.TRUE);
  }
  
  private void o4(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    f4 localf4 = (f4)this.m.get(paramTPCameraDeviceContext.getDeviceIdMD5());
    if (localf4 == null)
    {
      localf4 = new f4(paramTPCameraDeviceContext);
      this.m.put(paramTPCameraDeviceContext.getDeviceIdMD5(), localf4);
    }
    else
    {
      localf4.i3(paramTPCameraDeviceContext);
    }
  }
  
  private io.reactivex.q<Boolean> p1(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return V0(localArrayList);
  }
  
  private void p2(List<TCDeviceBean> paramList, Map<String, ? extends TDPIoTDevice> paramMap, Map<String, ThingDevice> paramMap1, Set<String> paramSet)
  {
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Object localObject2;
    Object localObject4;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (TCDeviceBean)((Iterator)localObject2).next();
        localObject4 = b.d.w.h.a.g(((TCDeviceBean)localObject3).getDeviceId());
        paramList = (BaseALIoTDevice)this.k.get(localObject4);
        if (paramList != null)
        {
          paramList.setCloudIoTDevice((TCDeviceBean)localObject3);
          paramList.setBackupFromCache(false);
        }
        else
        {
          if (((TCDeviceBean)localObject3).isCamera()) {
            paramList = new ALCameraDevice((TCDeviceBean)localObject3);
          } else {
            paramList = new ALIoTDevice((TCDeviceBean)localObject3);
          }
          this.k.put(localObject4, paramList);
        }
        localObject3 = (ThingDevice)paramMap1.remove(localObject4);
        if (localObject3 != null) {
          paramList.setThingDevice((ThingDevice)localObject3);
        } else {
          paramList.setThingDevice(null);
        }
        localObject3 = (TDPIoTDevice)paramMap.remove(localObject4);
        if (z2((TDPIoTDevice)localObject3, (String)localObject1)) {
          paramList.setTDPIoTDevice((TDPIoTDevice)localObject3);
        } else {
          paramList.setTDPIoTDevice(null);
        }
        paramSet.remove(localObject4);
      }
    }
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        localObject4 = (TDPIoTDevice)paramMap.next();
        if (z2((TDPIoTDevice)localObject4, (String)localObject1))
        {
          paramList = ((TDPIoTDevice)localObject4).getDeviceIdMd5();
          localObject2 = (BaseALIoTDevice)this.k.get(paramList);
          if (localObject2 != null)
          {
            ((BaseALIoTDevice)localObject2).setTDPIoTDevice((TDPIoTDevice)localObject4);
            ((BaseALIoTDevice)localObject2).setBackupFromCache(false);
          }
          else
          {
            localObject4 = H1((TDPIoTDevice)localObject4);
            this.k.put(paramList, localObject4);
          }
          paramSet.remove(paramList);
        }
      }
    }
    paramMap = paramMap1.values().iterator();
    while (paramMap.hasNext())
    {
      localObject1 = (ThingDevice)paramMap.next();
      if (((ThingDevice)localObject1).isSubThing())
      {
        paramList = b.d.w.h.a.g(((ThingDevice)localObject1).getThingName());
        paramMap1 = (BaseALIoTDevice)this.k.get(paramList);
        if (paramMap1 == null)
        {
          paramMap1 = new ALIoTDevice((ThingDevice)localObject1);
          this.k.put(paramList, paramMap1);
        }
        else
        {
          paramMap1.setThingDevice((ThingDevice)localObject1);
        }
        paramSet.remove(paramList);
      }
    }
    paramMap1 = paramSet.iterator();
    while (paramMap1.hasNext())
    {
      paramList = (String)paramMap1.next();
      paramMap = (BaseALIoTDevice)this.k.get(paramList);
      if ((paramMap == null) || (!paramMap.isSubDevice()) || (paramMap.getThingDevice() != null) || (this.k.get(paramMap.getParentDeviceIDMD5()) == null)) {
        B3(paramList);
      }
    }
    L3();
  }
  
  private void q2(List<BaseALIoTDevice> paramList)
  {
    this.G.postValue(Boolean.TRUE);
    j3(paramList).z(new u()).F0();
  }
  
  private void q4(List<TCDeviceBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        TCDeviceBean localTCDeviceBean = (TCDeviceBean)localIterator.next();
        String str = b.d.w.h.a.g(localTCDeviceBean.getDeviceId());
        paramList = (BaseALIoTDevice)this.k.get(str);
        if (paramList != null)
        {
          paramList.setCloudIoTDevice(localTCDeviceBean);
          paramList.setBackupFromCache(false);
        }
        else
        {
          if (localTCDeviceBean.isCamera()) {
            paramList = new ALCameraDevice(localTCDeviceBean);
          } else {
            paramList = new ALIoTDevice(localTCDeviceBean);
          }
          this.k.put(str, paramList);
        }
        U3(paramList);
      }
      L3();
      I3();
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void r2(String paramString)
  {
    ((QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, QuickSetupRepository.class)).F1().y();
  }
  
  private io.reactivex.q<Boolean> r3(List<BaseALIoTDevice> paramList)
  {
    return l2(paramList).N(new k0());
  }
  
  private void r4(ThingContext paramThingContext)
  {
    x localx = (x)this.l.get(paramThingContext.getDeviceIdMD5());
    if (localx == null)
    {
      localx = new x(paramThingContext);
      this.l.put(paramThingContext.getDeviceIdMD5(), localx);
    }
    else
    {
      localx.E(paramThingContext);
    }
  }
  
  private Map<String, ? extends TDPIoTDevice> s1(Map<String, ? extends TDPIoTDevice> paramMap)
  {
    String str = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (!z2((TDPIoTDevice)((Map.Entry)localIterator.next()).getValue(), str)) {
        localIterator.remove();
      }
    }
    return paramMap;
  }
  
  private io.reactivex.q<Map<String, ? extends TDPIoTDevice>> s3(boolean paramBoolean)
  {
    return io.reactivex.q.f0(Boolean.valueOf(paramBoolean)).N(new p(this, paramBoolean));
  }
  
  private Map<String, ? extends TDPIoTDevice> t1(Map<String, ? extends TDPIoTDevice> paramMap, List<String> paramList)
  {
    String str = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TDPIoTDevice localTDPIoTDevice = (TDPIoTDevice)((Map.Entry)localIterator.next()).getValue();
      if ((z2(localTDPIoTDevice, str)) && (!paramList.contains(localTDPIoTDevice.getDeviceIdMd5()))) {
        paramList.add(localTDPIoTDevice.getDeviceIdMd5());
      } else {
        localIterator.remove();
      }
    }
    return paramMap;
  }
  
  private boolean t2(List<String> paramList)
  {
    if (paramList == null) {
      return false;
    }
    if (paramList.size() != this.N.size()) {
      return true;
    }
    return (!paramList.containsAll(this.N)) || (!this.N.containsAll(paramList));
  }
  
  private void t4(List<ThingDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ThingDevice localThingDevice = (ThingDevice)localIterator.next();
        String str = b.d.w.h.a.g(localThingDevice.getThingName());
        if (!TextUtils.isEmpty(str))
        {
          paramList = (BaseALIoTDevice)this.k.get(str);
          if (paramList != null)
          {
            paramList.setThingDevice(localThingDevice);
            paramList.setBackupFromCache(false);
          }
          else
          {
            if (localThingDevice.isCamera()) {
              paramList = new ALCameraDevice(localThingDevice);
            } else {
              paramList = new ALIoTDevice(localThingDevice);
            }
            this.k.put(str, paramList);
          }
          U3(paramList);
        }
      }
      L3();
      I3();
    }
  }
  
  private io.reactivex.q<Map<String, ? extends TDPIoTDevice>> u3(boolean paramBoolean)
  {
    return io.reactivex.q.f0(Boolean.valueOf(paramBoolean)).N(new k1());
  }
  
  private boolean v2(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    return this.s.j0(paramBoolean1, paramBoolean2, paramString);
  }
  
  private io.reactivex.q<Boolean> v3(List<BaseALIoTDevice> paramList)
  {
    return l2(paramList).N(new l0());
  }
  
  private TCAccountBean x1()
  {
    return this.n.u();
  }
  
  private io.reactivex.a x2(final List<String> paramList1, final List<String> paramList2)
  {
    return io.reactivex.q.f0(Boolean.TRUE).R(new s0(paramList2, paramList1));
  }
  
  private void x3(String paramString)
  {
    if ((BaseALIoTDevice)this.k.get(paramString) != null) {
      h2(paramString).h().L0(io.reactivex.l0.a.c()).F0();
    }
    B3(paramString);
  }
  
  private io.reactivex.q<IoTResult<List<TCDeviceBean>>> y1()
  {
    return this.o.y().v0(1L, new h0()).L0(io.reactivex.l0.a.c()).N(new f0()).q0(new IoTResult(1));
  }
  
  private boolean y2(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() != this.M.size()) {
        return true;
      }
      return (!paramList.containsAll(this.M)) || (!this.M.containsAll(paramList));
    }
    return false;
  }
  
  private void y3()
  {
    Iterator localIterator = this.k.entrySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Map.Entry)localIterator.next()).getValue();
      if (localBaseALIoTDevice.isBackupFromCache())
      {
        i1 = 1;
        C3(localBaseALIoTDevice.getDeviceIdMD5());
        localIterator.remove();
      }
    }
    if (i1 != 0) {
      L3();
    }
  }
  
  private io.reactivex.q<IoTResult<List<TCDeviceBean>>> z1()
  {
    return this.o.t().v0(1L, new n0()).L0(io.reactivex.l0.a.c()).N(new m0()).q0(new IoTResult(1));
  }
  
  private boolean z2(TDPIoTDevice paramTDPIoTDevice, String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramTDPIoTDevice != null) && (!paramTDPIoTDevice.isFactoryDefault()) && (paramString.equalsIgnoreCase(paramTDPIoTDevice.getOwner()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void A3()
  {
    Iterator localIterator = this.k.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Map.Entry)localObject).getValue();
      localObject = (String)((Map.Entry)localObject).getKey();
      if ((localBaseALIoTDevice instanceof ALCameraDevice)) {
        localBaseALIoTDevice.setTDPIoTDevice(null);
      }
    }
    L3();
  }
  
  public MutableLiveData<List<BaseALIoTDevice>> C1()
  {
    return this.A;
  }
  
  public void D1()
  {
    Object localObject;
    try
    {
      ArrayList localArrayList1 = new java/util/ArrayList;
      localArrayList1.<init>(this.k.values());
    }
    catch (Exception localException)
    {
      localObject = new ArrayList();
    }
    if (((List)localObject).isEmpty()) {
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (BaseALIoTDevice)localIterator.next();
      if ((((BaseALIoTDevice)localObject).getDeviceState() == EnumIoTDeviceState.ONLINE) && ((localObject instanceof ALIoTDevice))) {
        localArrayList2.add(localObject);
      }
    }
    if (localArrayList2.isEmpty()) {
      return;
    }
    l2(localArrayList2).E(new m2()).F0();
  }
  
  public io.reactivex.a H3(String paramString)
  {
    return io.reactivex.q.f0(paramString).L0(io.reactivex.l0.a.c()).R(new z1()).i(new x1());
  }
  
  public f4 J1(String paramString)
  {
    if (paramString == null) {
      return new f4();
    }
    f4 localf41 = (f4)this.m.get(paramString);
    f4 localf42 = localf41;
    if (localf41 == null)
    {
      localf42 = localf41;
      if (!TextUtils.isEmpty(paramString))
      {
        localf42 = new f4();
        this.m.put(paramString, localf42);
      }
    }
    return localf42;
  }
  
  public void J3(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    this.H.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramBaseALIoTDevice));
  }
  
  public void L3()
  {
    ArrayList localArrayList1 = new ArrayList(this.k.values());
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
      if ((localBaseALIoTDevice instanceof ALCameraDevice))
      {
        localArrayList2.add((ALCameraDevice)localBaseALIoTDevice);
        MediaDevice localMediaDevice = new MediaDevice();
        localMediaDevice.setDeviceId(localBaseALIoTDevice.getDeviceId());
        localMediaDevice.setDeviceLocal(com.tplink.libtpnetwork.Utils.f.d(localBaseALIoTDevice));
        localMediaDevice.setDeviceRemoteOnline(com.tplink.libtpnetwork.Utils.f.i(localBaseALIoTDevice));
        localMediaDevice.setLocalIp(com.tplink.libtpnetwork.Utils.f.a(localBaseALIoTDevice));
        localMediaDevice.setDeviceMac(localBaseALIoTDevice.getDeviceMac());
        localMediaDevice.setUserSharePassword(com.tplink.libtpnetwork.Utils.f.b(localBaseALIoTDevice));
        localMediaDevice.setUserShareUsername(com.tplink.libtpnetwork.Utils.f.c(localBaseALIoTDevice));
        localMediaDevice.setP2PAvailable(com.tplink.libtpnetwork.Utils.f.k(localBaseALIoTDevice));
        localMediaDevice.setModel(localBaseALIoTDevice.getDeviceModel());
        localMediaDevice.setUserRoleTypeDevice(localBaseALIoTDevice.isUserRoleTypeDevice());
        ALCameraDevice localALCameraDevice = (ALCameraDevice)localBaseALIoTDevice;
        if (localALCameraDevice.getCameraComponent() != null)
        {
          CameraComponent localCameraComponent = localALCameraDevice.getCameraComponent();
          ComponentType localComponentType = ComponentType.VIDEO;
          boolean bool;
          if ((localCameraComponent.hasComponent(localComponentType)) && (localALCameraDevice.getCameraComponent().getComponent(localComponentType) >= 2)) {
            bool = true;
          } else {
            bool = false;
          }
          localMediaDevice.setForceMainStream(bool);
        }
        localMediaDevice.setAppServerUrl(localBaseALIoTDevice.getAppServerUrl());
        localMediaDevice.setSupportIoTCloud(localBaseALIoTDevice.isSupportIoTCloud());
        localMediaDevice.setIotThingUrl(localALCameraDevice.getThingUrl());
        localArrayList3.add(localMediaDevice);
      }
    }
    this.B.postValue(localArrayList2);
    this.A.postValue(localArrayList1);
    MediaDeviceAPI.refreshDeviceList(localArrayList3, new x0());
  }
  
  public MediatorLiveData<List<ALCameraDevice>> M1()
  {
    return this.B;
  }
  
  public io.reactivex.q<u> N3(final Application paramApplication, int paramInt, String paramString)
  {
    return M3(paramApplication, null, paramInt, null, paramString).E(new u0(paramApplication));
  }
  
  public io.reactivex.q<u> O3(final Application paramApplication, String paramString1, int paramInt, String paramString2)
  {
    return M3(paramApplication, paramString1, paramInt, null, paramString2).E(new t0(paramApplication));
  }
  
  public io.reactivex.q<FirmwareListResult> P1(FirmwareInfoParams paramFirmwareInfoParams)
  {
    return this.o.D(paramFirmwareInfoParams);
  }
  
  public io.reactivex.q<u> P3(Application paramApplication, int paramInt, String paramString)
  {
    return M3(paramApplication, null, paramInt, paramString, null);
  }
  
  public FamilyInfo Q1()
  {
    return this.s.X();
  }
  
  public io.reactivex.q<Boolean> R3(String paramString1, final String paramString2)
  {
    return io.reactivex.q.f0(paramString1).N(new t1(paramString2)).N(new s1(paramString2));
  }
  
  public String S1(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    BaseALIoTDevice localBaseALIoTDevice = Z1(paramString);
    paramString = str;
    if (localBaseALIoTDevice != null) {
      paramString = localBaseALIoTDevice.getDeviceLocation();
    }
    return paramString;
  }
  
  public void T0(String paramString, ThingFirmware paramThingFirmware)
  {
    this.D.put(paramString, paramThingFirmware);
    K3();
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<BaseALIoTDevice>> T1()
  {
    return this.H;
  }
  
  public void T3()
  {
    io.reactivex.e0.c localc = this.O;
    if ((localc != null) && (!localc.isDisposed())) {
      this.O.dispose();
    }
  }
  
  public String U1(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    BaseALIoTDevice localBaseALIoTDevice = Z1(paramString);
    paramString = str;
    if (localBaseALIoTDevice != null) {
      paramString = localBaseALIoTDevice.getDeviceModel();
    }
    return paramString;
  }
  
  public String V1(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    BaseALIoTDevice localBaseALIoTDevice = Z1(paramString);
    paramString = str;
    if (localBaseALIoTDevice != null) {
      paramString = localBaseALIoTDevice.getDeviceType();
    }
    return paramString;
  }
  
  public EnumLoginResult W1()
  {
    return this.i;
  }
  
  public MutableLiveData<EnumHomeState> X1()
  {
    return this.F;
  }
  
  public io.reactivex.q<u> Y0(Application paramApplication, com.tplink.tpble.v paramv, final b.d.d0.h2.a.b paramb)
  {
    return this.y.e(paramApplication, paramv).l0(io.reactivex.d0.b.a.a()).N(new w0(paramb));
  }
  
  public x Y1(String paramString)
  {
    x localx1 = (x)this.l.get(paramString);
    x localx2 = localx1;
    if (localx1 == null)
    {
      localx2 = localx1;
      if (!b.d.w.h.b.d(paramString))
      {
        localx2 = new x();
        this.l.put(paramString, localx2);
      }
    }
    return localx2;
  }
  
  public void Y3(ALCameraDevice paramALCameraDevice)
  {
    this.k.put(paramALCameraDevice.getDeviceIdMD5(), paramALCameraDevice);
    V3(paramALCameraDevice);
    L3();
  }
  
  public BaseALIoTDevice Z1(String paramString)
  {
    return (BaseALIoTDevice)this.k.get(paramString);
  }
  
  public void Z3(TDPIoTDevice paramTDPIoTDevice)
  {
    a4(m2(new ALIoTDevice(paramTDPIoTDevice), true));
    Object localObject = (TPBaseDeviceContext)this.j.get(paramTDPIoTDevice.getDeviceIdMd5());
    if (localObject != null) {
      localObject = ((TPBaseDeviceContext)localObject).getIoTDevice();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((BaseALIoTDevice)localObject).getTDPIoTDevice() != null))
    {
      paramTDPIoTDevice = Y1(paramTDPIoTDevice.getDeviceIdMd5());
      localObject = ((BaseALIoTDevice)localObject).getTDPIoTDevice();
      paramTDPIoTDevice.q(z.a(b.d.s.a.a.g().c(), (TDPIoTDevice)localObject));
    }
  }
  
  public void a1()
  {
    this.H.postValue(null);
  }
  
  public io.reactivex.q<Boolean> b2()
  {
    this.F.postValue(EnumHomeState.LOCAL_OFFLINE);
    final ArrayList localArrayList = new ArrayList();
    this.D.clear();
    e1();
    return this.I.g0(new n(localArrayList)).z(new m()).C(new l()).N(new j()).E(new i()).z(new h());
  }
  
  public io.reactivex.q<Boolean> c2(b.d.s.a.b.a parama)
  {
    this.s.U().z(new k(this)).F0();
    this.v.f0().F0();
    this.t.P().F0();
    this.r.S().F0();
    this.o.r().y();
    this.v.I().F0();
    this.v.d0().F0();
    this.v.e0().F0();
    this.v.W().F0();
    final HashMap localHashMap = new HashMap();
    final ArrayList localArrayList = new ArrayList();
    this.D.clear();
    e1();
    return io.reactivex.q.f(O1(parama), this.I, new f(localHashMap, localArrayList)).l(this.I.R0(1).g0(new g(localHashMap))).z(new e()).N(new d()).E(new c()).z(new b());
  }
  
  public io.reactivex.a d3()
  {
    return this.n.J().l(new a()).i(new t2());
  }
  
  public MutableLiveData<Boolean> e2()
  {
    return this.G;
  }
  
  public io.reactivex.a e3(String paramString)
  {
    return io.reactivex.q.f0(paramString).R(new a2());
  }
  
  public void e4()
  {
    l2(new ArrayList(this.k.values())).E(new l2()).F0();
  }
  
  public void f4(String paramString)
  {
    Iterator localIterator = new ArrayList(this.k.values()).iterator();
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
      if ((localBaseALIoTDevice.isSubDevice()) && (TextUtils.equals(localBaseALIoTDevice.getParentDeviceIDMD5(), paramString))) {
        localBaseALIoTDevice.setDeviceState(EnumIoTDeviceState.OFFLINE);
      }
    }
  }
  
  public com.tplink.libtpnetwork.IoTNetwork.repository.kb.c h2(String paramString)
  {
    BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)this.k.get(paramString);
    if ((localBaseALIoTDevice instanceof ALCameraDevice)) {
      return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CommonCameraRepository.class);
    }
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isBulb()))
    {
      if (localBaseALIoTDevice.isLightStrip()) {
        return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, LightStripRepository.class);
      }
      return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, BulbRepository.class);
    }
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isHub())) {
      return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, HubRepository.class);
    }
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isSensor())) {
      return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, SensorRepository.class);
    }
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isSwitch())) {
      return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, SwitchRepository.class);
    }
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isEnergy())) {
      return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, TRVRepository.class);
    }
    return com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, PlugRepository.class);
  }
  
  public io.reactivex.q<Boolean> k3(boolean paramBoolean)
  {
    if (w2()) {
      return m3(paramBoolean);
    }
    return l3(paramBoolean);
  }
  
  public io.reactivex.q<Boolean> l4(TCAccountBean paramTCAccountBean, b.d.s.a.b.a parama, boolean paramBoolean)
  {
    io.reactivex.m0.g localg = this.J;
    if ((localg == null) || (localg.j1()))
    {
      this.J = io.reactivex.m0.e.n1().l1();
      g4(paramBoolean).L0(io.reactivex.l0.a.c()).F0();
    }
    return m4(paramTCAccountBean, parama, true);
  }
  
  public void m1(List<BaseALIoTDevice> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
      if (localBaseALIoTDevice.isUserRoleTypeDevice())
      {
        localArrayList3.add(new DeviceUserRoleParams(localBaseALIoTDevice.getDeviceId(), localBaseALIoTDevice.isSubDevice()));
      }
      else
      {
        if (localBaseALIoTDevice.isSupportIoTCloud())
        {
          if (localBaseALIoTDevice.isSwitch()) {
            localArrayList5.add(localBaseALIoTDevice.getDeviceIdMD5());
          } else {
            localArrayList2.add(localBaseALIoTDevice.getDeviceId());
          }
        }
        else {
          localArrayList1.add(localBaseALIoTDevice.getDeviceId());
        }
        if (localBaseALIoTDevice.isHub()) {
          localArrayList4.add(localBaseALIoTDevice.getDeviceIdMD5());
        }
      }
    }
    if (!localArrayList1.isEmpty()) {
      V0(localArrayList1).F0();
    }
    if (!localArrayList2.isEmpty()) {
      U0(localArrayList2).F0();
    }
    if (!localArrayList3.isEmpty()) {
      X0(localArrayList3).y();
    }
    if (!localArrayList4.isEmpty()) {
      E3(localArrayList4);
    }
    if (!localArrayList5.isEmpty()) {
      W0(localArrayList5);
    }
  }
  
  public io.reactivex.q<Boolean> n1(String paramString)
  {
    paramString = (BaseALIoTDevice)this.k.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.getDeviceId())))
    {
      String str = paramString.getDeviceId();
      ArrayList localArrayList;
      if (paramString.isHub())
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramString.getDeviceIdMD5());
        E3(localArrayList);
      }
      if ((paramString.isSwitch()) && (!TextUtils.isEmpty(paramString.getOriginalDeviceId())))
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramString.getDeviceIdMD5());
        return W0(localArrayList);
      }
      if (paramString.isSupportIoTCloud()) {
        return o1(str);
      }
      return p1(str);
    }
    return io.reactivex.q.f0(Boolean.FALSE);
  }
  
  public MutableLiveData<Boolean> o2()
  {
    return this.E;
  }
  
  public io.reactivex.q<Boolean> o3(final b.d.s.a.b.a parama, boolean paramBoolean)
  {
    return io.reactivex.q.f1(n4(this.n.u(), parama), u3(paramBoolean), new x()).N(new w(parama));
  }
  
  public io.reactivex.q<Boolean> p3(final b.d.s.a.b.a parama, boolean paramBoolean)
  {
    return io.reactivex.q.e1(z1(), E1(), u3(paramBoolean), new t()).g0(new s(parama)).E(new r()).N(new q());
  }
  
  public void p4(String paramString, List<BaseALIoTDevice> paramList, boolean paramBoolean)
  {
    BaseALIoTDevice localBaseALIoTDevice1 = (BaseALIoTDevice)this.k.get(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = new ArrayList(this.k.values()).iterator();
    BaseALIoTDevice localBaseALIoTDevice2;
    while (localIterator.hasNext())
    {
      localBaseALIoTDevice2 = (BaseALIoTDevice)localIterator.next();
      if ((localBaseALIoTDevice2.isSubDevice()) && (TextUtils.equals(paramString, localBaseALIoTDevice2.getParentDeviceIDMD5()))) {
        localHashMap.put(localBaseALIoTDevice2.getDeviceIdMD5(), localBaseALIoTDevice2);
      }
    }
    if (paramBoolean)
    {
      if ((localBaseALIoTDevice1 != null) && (paramList != null))
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          paramList = (BaseALIoTDevice)localIterator.next();
          paramString = (BaseALIoTDevice)localHashMap.get(paramList.getDeviceIdMD5());
          if ((paramString == null) || (paramList.getBindCount() >= paramString.getBindCount()))
          {
            if ((paramString == null) && (this.k.containsKey(paramList.getDeviceIdMD5())))
            {
              b.d.w.c.a.e("ChildDevice", "updateChildDevice removeDeviceClientContext");
              B3(paramList.getDeviceIdMD5());
            }
            localBaseALIoTDevice2 = m2(paramList, true);
            c4(paramList.getDeviceIdMD5());
            N1(paramList);
            if ((localBaseALIoTDevice2.getLocalIoTDevice() instanceof IoTSubDevice))
            {
              paramString = (IoTSubDevice)localBaseALIoTDevice2.getLocalIoTDevice();
              if (paramString.getComponents() == null)
              {
                localBaseALIoTDevice2.setDeviceState(EnumIoTDeviceState.OFFLINE);
              }
              else
              {
                if ("online".equals(paramString.getStatus())) {
                  paramString = EnumIoTDeviceState.ONLINE;
                } else {
                  paramString = EnumIoTDeviceState.OFFLINE;
                }
                localBaseALIoTDevice2.setDeviceState(paramString);
              }
            }
            else
            {
              localBaseALIoTDevice2.setDeviceState(localBaseALIoTDevice1.getDeviceState());
            }
          }
          localHashMap.remove(paramList.getDeviceIdMD5());
        }
      }
      paramString = localHashMap.keySet().iterator();
      while (paramString.hasNext()) {
        B3((String)paramString.next());
      }
      L3();
      I3();
      this.G.postValue(Boolean.TRUE);
    }
    else
    {
      g2(new ArrayList(localHashMap.values())).E(new m(this)).z(new g(this)).F0();
    }
  }
  
  public void q1(String paramString)
  {
    Object localObject = (TPBaseDeviceContext)this.j.get(paramString);
    if (localObject != null) {
      localObject = ((TPBaseDeviceContext)localObject).getIoTDevice();
    } else {
      localObject = null;
    }
    String str = b.d.w.h.a.g(this.b.c().getCloudUserName());
    if ((localObject != null) && (((BaseALIoTDevice)localObject).getTDPIoTDevice() != null) && (!((BaseALIoTDevice)localObject).getTDPIoTDevice().isFactoryDefault()))
    {
      paramString = Y1(paramString);
      localObject = ((BaseALIoTDevice)localObject).getTDPIoTDevice();
      if (str.equalsIgnoreCase(((TDPIoTDevice)localObject).getOwner())) {
        paramString.q(z.a(this.b.c(), (TDPIoTDevice)localObject));
      }
    }
  }
  
  public io.reactivex.q<Boolean> q3()
  {
    Object localObject = new ArrayList(this.k.values());
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject).next();
      if ((localBaseALIoTDevice instanceof ALIoTDevice)) {
        localArrayList.add(localBaseALIoTDevice);
      }
    }
    localObject = localArrayList;
    if (w2()) {
      localObject = R1(localArrayList);
    }
    if (((List)localObject).isEmpty()) {
      return io.reactivex.q.f0(Boolean.FALSE);
    }
    return r3((List)localObject);
  }
  
  public void r1(String paramString)
  {
    Object localObject = (TPBaseDeviceContext)this.j.get(paramString);
    if (localObject != null) {
      localObject = ((TPBaseDeviceContext)localObject).getIoTDevice();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((BaseALIoTDevice)localObject).getTDPIoTDevice() != null) && (((BaseALIoTDevice)localObject).getTDPIoTDevice().isFactoryDefault()))
    {
      paramString = Y1(paramString);
      localObject = ((BaseALIoTDevice)localObject).getTDPIoTDevice();
      paramString.q(z.a(b.d.s.a.a.g().c(), (TDPIoTDevice)localObject));
    }
  }
  
  @SuppressLint({"CheckResult"})
  public void s2(final String paramString)
  {
    T3();
    this.O = io.reactivex.q.a0(3L, 20L, TimeUnit.SECONDS).G0(new s2(paramString));
  }
  
  public io.reactivex.q<Boolean> s4(ALCameraDevice paramALCameraDevice)
  {
    return io.reactivex.q.f0(paramALCameraDevice).g0(new r1()).N(new q1()).g0(new p1()).L0(io.reactivex.l0.a.c()).z(new o1());
  }
  
  public io.reactivex.q<Boolean> t3(boolean paramBoolean)
  {
    return u3(paramBoolean).N(new y());
  }
  
  public io.reactivex.q<Boolean> u1(final String paramString)
  {
    return B1().N(new o2(paramString));
  }
  
  public boolean u2(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CloudAccountV1Exception))
    {
      paramThrowable = (CloudAccountV1Exception)paramThrowable;
      if (paramThrowable.getLoginV1Result() != null)
      {
        int i1 = paramThrowable.getLoginV1Result().getErrorCode();
        if ((i1 != 42533) && (i1 != 44875) && (i1 != 44921) && (i1 != 45334) && (i1 != 45336)) {}
        switch (i1)
        {
        default: 
          break;
        case -20602: 
        case -20601: 
        case -20600: 
          return true;
        }
      }
    }
    return false;
  }
  
  public io.reactivex.q<Boolean> v1(final String paramString)
  {
    return B1().g0(new n2(paramString));
  }
  
  public io.reactivex.a w(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = (BaseALIoTDevice)this.k.get(localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((BaseALIoTDevice)localObject).getDeviceId()))) {
        localArrayList.add(((BaseALIoTDevice)localObject).getDeviceId());
      }
    }
    if (localArrayList.isEmpty()) {
      return io.reactivex.a.e();
    }
    return x(localArrayList);
  }
  
  public io.reactivex.q<Boolean> w1(final String paramString, final TCDeviceBean paramTCDeviceBean)
  {
    return G1().N(new p2(paramString, paramTCDeviceBean));
  }
  
  public boolean w2()
  {
    boolean bool;
    if (this.F.getValue() == EnumHomeState.ONLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void w3(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.u.H())
    {
      this.K = paramString2;
      this.u.M("ANDROID", paramInt, paramString1, paramString2, paramString3, Locale.getDefault().toString(), paramString4);
    }
  }
  
  public io.reactivex.a x(final List<String> paramList)
  {
    DeviceUserRoleListParams localDeviceUserRoleListParams = new DeviceUserRoleListParams();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = b.d.w.h.a.g(str);
      localObject = (BaseALIoTDevice)this.k.get(localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((BaseALIoTDevice)localObject).getDeviceId()))) {
        localArrayList.add(new DeviceUserRoleParams(str, ((BaseALIoTDevice)localObject).isSubDevice()));
      }
    }
    localDeviceUserRoleListParams.setThings(localArrayList);
    localDeviceUserRoleListParams.setUserAccount(this.b.c().getEmail());
    return this.p.B(localDeviceUserRoleListParams).C(io.reactivex.l0.a.c()).i(new g2(paramList));
  }
  
  public io.reactivex.q<Boolean> z3(final String paramString)
  {
    return io.reactivex.q.f0(paramString).N(new k2()).E(new i2(paramString)).z(new h2()).L0(io.reactivex.l0.a.c());
  }
  
  class a
    implements io.reactivex.g0.g<io.reactivex.e0.c>
  {
    a() {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      paramc = TPIoTClientManager.D(TPIoTClientManager.this).values().iterator();
      while (paramc.hasNext()) {
        com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.e((TPBaseDeviceContext)paramc.next());
      }
      TPIoTClientManager.E(TPIoTClientManager.this).clear();
      TPIoTClientManager.F(TPIoTClientManager.this).clear();
      TPIoTClientManager.D(TPIoTClientManager.this).clear();
      TPIoTClientManager.G(TPIoTClientManager.this).clear();
    }
  }
  
  class a0
    implements j<List<BaseALIoTDevice>, t<Boolean>>
  {
    a0() {}
    
    public t<Boolean> a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      return TPIoTClientManager.e0(TPIoTClientManager.this, paramList);
    }
  }
  
  class a1
    implements io.reactivex.g0.a
  {
    a1() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.a0(TPIoTClientManager.this).onComplete();
    }
  }
  
  class a2
    implements j<String, io.reactivex.e>
  {
    a2() {}
    
    public io.reactivex.e a(String paramString)
      throws Exception
    {
      paramString = (BaseALIoTDevice)TPIoTClientManager.G(TPIoTClientManager.this).get(paramString);
      if ((paramString instanceof ALCameraDevice)) {
        ((ALCameraDevice)paramString).setDeviceRemoteOffline();
      }
      MediatorLiveData localMediatorLiveData = TPIoTClientManager.J0(TPIoTClientManager.this);
      paramString = TPIoTClientManager.this;
      localMediatorLiveData.postValue(TPIoTClientManager.I0(paramString, TPIoTClientManager.G(paramString).values()));
      return io.reactivex.a.e();
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.H(TPIoTClientManager.this);
      TPIoTClientManager.I(TPIoTClientManager.this).C().F0();
    }
  }
  
  class b0
    implements io.reactivex.g0.c<IoTResult<List<TCDeviceBean>>, Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>>
  {
    b0() {}
    
    public List<BaseALIoTDevice> a(IoTResult<List<TCDeviceBean>> paramIoTResult, Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      if (paramIoTResult.getErrCode() == 0)
      {
        TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.ONLINE);
        paramIoTResult = (List)paramIoTResult.getResult();
      }
      else
      {
        TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.LOCAL_OFFLINE);
        paramIoTResult = new ArrayList();
      }
      return TPIoTClientManager.f0(TPIoTClientManager.this, paramIoTResult, paramMap);
    }
  }
  
  class b1
    implements io.reactivex.g0.g<Map<String, ? extends TDPIoTDevice>>
  {
    b1() {}
    
    public void a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      TPIoTClientManager.a0(TPIoTClientManager.this).onNext(paramMap);
    }
  }
  
  class b2
    implements j<String, t<?>>
  {
    b2(Map paramMap) {}
    
    public t<?> a(String paramString)
      throws Exception
    {
      return TPIoTClientManager.u0(TPIoTClientManager.this).K(paramString, (List)localMap.get(paramString)).q0(Boolean.FALSE);
    }
  }
  
  class c
    implements io.reactivex.g0.g<Boolean>
  {
    c() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      TPIoTClientManager.this.L3();
    }
  }
  
  class c0
    implements io.reactivex.g0.a
  {
    c0() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.H(TPIoTClientManager.this);
    }
  }
  
  class c1
    implements j<Throwable, t<Boolean>>
  {
    c1(boolean paramBoolean) {}
    
    public t<Boolean> a(Throwable paramThrowable)
      throws Exception
    {
      if (TPIoTClientManager.this.u2(paramThrowable))
      {
        TPIoTClientManager.Q0(TPIoTClientManager.this, EnumLoginResult.FAIL);
        return io.reactivex.q.J(paramThrowable);
      }
      if (paramBoolean) {
        paramThrowable = TPIoTClientManager.R0(TPIoTClientManager.this);
      } else {
        paramThrowable = io.reactivex.q.f0(Boolean.FALSE);
      }
      return paramThrowable;
    }
  }
  
  class c2
    implements io.reactivex.g0.a
  {
    c2() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.H(TPIoTClientManager.this);
      TPIoTClientManager.this.L3();
    }
  }
  
  class d
    implements j<List<BaseALIoTDevice>, t<Boolean>>
  {
    d() {}
    
    public t<Boolean> a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      return TPIoTClientManager.J(TPIoTClientManager.this, paramList);
    }
  }
  
  class d0
    implements j<List<BaseALIoTDevice>, t<Boolean>>
  {
    d0() {}
    
    public t<Boolean> a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      return TPIoTClientManager.e0(TPIoTClientManager.this, paramList);
    }
  }
  
  class d1
    implements j<Map<String, ? extends TDPIoTDevice>, Map<String, ? extends TDPIoTDevice>>
  {
    d1(List paramList) {}
    
    public Map<String, ? extends TDPIoTDevice> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      TPIoTClientManager.v0(TPIoTClientManager.this).H(paramMap);
      return TPIoTClientManager.w0(TPIoTClientManager.this, paramMap, localArrayList);
    }
  }
  
  class d2
    implements io.reactivex.g0.g<String>
  {
    d2() {}
    
    public void a(String paramString)
      throws Exception
    {
      paramString = b.d.w.h.a.g(paramString);
      TPIoTClientManager.K0(TPIoTClientManager.this, paramString);
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.L(TPIoTClientManager.this);
      TPIoTClientManager.M(TPIoTClientManager.this).postValue(Boolean.TRUE);
    }
  }
  
  class e0
    implements j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>>
  {
    e0() {}
    
    public List<BaseALIoTDevice> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      return TPIoTClientManager.f0(TPIoTClientManager.this, new ArrayList(), paramMap);
    }
  }
  
  class e1
    implements io.reactivex.g0.a
  {
    e1() {}
    
    public void run()
      throws Exception
    {
      if ((TPIoTClientManager.x0(TPIoTClientManager.this) != null) && (!TPIoTClientManager.x0(TPIoTClientManager.this).j1()))
      {
        TPIoTClientManager.x0(TPIoTClientManager.this).onNext(Boolean.FALSE);
        TPIoTClientManager.x0(TPIoTClientManager.this).onComplete();
      }
    }
  }
  
  class e2
    implements j<List<String>, List<String>>
  {
    e2() {}
    
    public List<String> a(List<String> paramList)
      throws Exception
    {
      return paramList;
    }
  }
  
  class f
    implements io.reactivex.g0.c<IoTResult<Map<String, BaseALIoTDevice>>, Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>>
  {
    f(Map paramMap, List paramList) {}
    
    public List<BaseALIoTDevice> a(IoTResult<Map<String, BaseALIoTDevice>> paramIoTResult, Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      if (paramIoTResult.getErrCode() == 0)
      {
        TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.ONLINE);
        paramIoTResult = (Map)paramIoTResult.getResult();
      }
      else
      {
        TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.LOCAL_OFFLINE);
        paramIoTResult = new HashMap();
      }
      if (!paramIoTResult.isEmpty()) {
        localHashMap.putAll(paramIoTResult);
      }
      return TPIoTClientManager.P(TPIoTClientManager.this, localHashMap, paramIoTResult, paramMap, localArrayList);
    }
  }
  
  class f0
    implements j<List<TCDeviceBean>, t<IoTResult<List<TCDeviceBean>>>>
  {
    f0() {}
    
    public t<IoTResult<List<TCDeviceBean>>> a(List<TCDeviceBean> paramList)
      throws Exception
    {
      return io.reactivex.q.f0(new IoTResult(0, paramList));
    }
  }
  
  class f1
    implements io.reactivex.g0.g<Boolean>
  {
    f1() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if ((paramBoolean.booleanValue()) && (TPIoTClientManager.x0(TPIoTClientManager.this) != null) && (!TPIoTClientManager.x0(TPIoTClientManager.this).j1()))
      {
        TPIoTClientManager.x0(TPIoTClientManager.this).onNext(Boolean.TRUE);
        TPIoTClientManager.x0(TPIoTClientManager.this).onComplete();
      }
    }
  }
  
  class f2
    implements io.reactivex.g0.a
  {
    f2(List paramList) {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.F0(TPIoTClientManager.this).M(localArrayList);
      TPIoTClientManager.V(TPIoTClientManager.this).Q0(localArrayList, null);
    }
  }
  
  class g
    implements j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>>
  {
    g(Map paramMap) {}
    
    public List<BaseALIoTDevice> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      return TPIoTClientManager.N(TPIoTClientManager.this, localHashMap);
    }
  }
  
  class g0
    implements j<Throwable, t<Boolean>>
  {
    g0() {}
    
    public t<Boolean> a(Throwable paramThrowable)
      throws Exception
    {
      if (TPIoTClientManager.this.u2(paramThrowable)) {
        return io.reactivex.q.J(paramThrowable);
      }
      return io.reactivex.q.f0(Boolean.FALSE);
    }
  }
  
  class g1
    implements j<Boolean, t<Boolean>>
  {
    g1() {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return TPIoTClientManager.y0(TPIoTClientManager.this);
      }
      return io.reactivex.q.f0(Boolean.FALSE);
    }
  }
  
  class g2
    implements io.reactivex.g0.a
  {
    g2(List paramList) {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.L0(TPIoTClientManager.this, paramList);
      TPIoTClientManager.F0(TPIoTClientManager.this).M(paramList);
      TPIoTClientManager.V(TPIoTClientManager.this).Q0(paramList, null);
    }
  }
  
  class h
    implements io.reactivex.g0.a
  {
    h() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.H(TPIoTClientManager.this);
    }
  }
  
  class h0
    implements io.reactivex.g0.l<Throwable>
  {
    h0() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return paramThrowable instanceof CloudException;
    }
  }
  
  class h1
    implements j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, t<Boolean>>
  {
    h1() {}
    
    public t<Boolean> a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      return paramc.d().T0(30L, TimeUnit.SECONDS).q0(Boolean.FALSE);
    }
  }
  
  class h2
    implements io.reactivex.g0.a
  {
    h2() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.this.L3();
      TPIoTClientManager.Z(TPIoTClientManager.this);
    }
  }
  
  class i
    implements io.reactivex.g0.g<Boolean>
  {
    i() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      TPIoTClientManager.this.L3();
    }
  }
  
  class i0
    implements j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, t<Boolean>>
  {
    i0() {}
    
    public t<Boolean> a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      return paramc.f();
    }
  }
  
  class i1
    implements j<List<BaseALIoTDevice>, t<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c>>
  {
    i1() {}
    
    public t<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c> a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      return TPIoTClientManager.z0(TPIoTClientManager.this, paramList);
    }
  }
  
  class i2
    implements io.reactivex.g0.g<Boolean>
  {
    i2(String paramString) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      TPIoTClientManager.M0(TPIoTClientManager.this, paramString);
    }
  }
  
  class j
    implements j<List<BaseALIoTDevice>, t<Boolean>>
  {
    j() {}
    
    public t<Boolean> a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      return TPIoTClientManager.J(TPIoTClientManager.this, paramList);
    }
  }
  
  class j0
    implements j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, t<Boolean>>
  {
    j0() {}
    
    public t<Boolean> a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      return paramc.f();
    }
  }
  
  class j1
    implements j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>>
  {
    j1() {}
    
    public List<BaseALIoTDevice> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      return TPIoTClientManager.A0(TPIoTClientManager.this, paramMap);
    }
  }
  
  class j2
    implements io.reactivex.g0.g<Boolean>
  {
    j2() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      TPIoTClientManager localTPIoTClientManager = TPIoTClientManager.this;
      if (paramBoolean.booleanValue()) {
        paramBoolean = EnumLoginResult.LOCAL_SUCCESS;
      } else {
        paramBoolean = EnumLoginResult.FAIL;
      }
      TPIoTClientManager.Q0(localTPIoTClientManager, paramBoolean);
    }
  }
  
  class k
    implements Observer<List<TCDeviceBean>>
  {
    k() {}
    
    public void a(@Nullable List<TCDeviceBean> paramList)
    {
      TPIoTClientManager.y(TPIoTClientManager.this, paramList);
    }
  }
  
  class k0
    implements j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, t<Boolean>>
  {
    k0() {}
    
    public t<Boolean> a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      return paramc.g();
    }
  }
  
  class k1
    implements j<Boolean, t<Map<String, ? extends TDPIoTDevice>>>
  {
    k1() {}
    
    public t<Map<String, ? extends TDPIoTDevice>> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return TPIoTClientManager.B0(TPIoTClientManager.this);
      }
      return io.reactivex.q.f0(new HashMap());
    }
  }
  
  class k2
    implements j<String, t<Boolean>>
  {
    k2() {}
    
    @SuppressLint({"CheckResult"})
    public t<Boolean> a(String paramString)
      throws Exception
    {
      paramString = (BaseALIoTDevice)TPIoTClientManager.G(TPIoTClientManager.this).get(paramString);
      if (paramString != null)
      {
        final Object localObject = (CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.E0(TPIoTClientManager.this, paramString), CameraSettingRepository.class);
        if ((paramString.getThingDevice() == null) && (paramString.getCloudIoTDevice() == null)) {
          return ((CameraSettingRepository)localObject).h().F(new b((CameraSettingRepository)localObject));
        }
        if (paramString.getThingDevice() != null)
        {
          localObject = paramString.getThingDevice();
          if ((!TextUtils.isEmpty(((ThingDevice)localObject).getThingUrl())) && (!TextUtils.isEmpty(((ThingDevice)localObject).getThingName()))) {
            return io.reactivex.q.m(new e(this, (ThingDevice)localObject, paramString));
          }
          return io.reactivex.q.f0(Boolean.FALSE);
        }
        ((CameraSettingRepository)localObject).h().F0();
        if (paramString.isFirmwareSupportIoTCloud()) {
          ((CameraSettingRepository)localObject).I1().F0();
        }
        return TPIoTClientManager.H0(TPIoTClientManager.this).R(paramString.getAppServerUrl(), paramString.getDeviceId(), TPIoTClientManager.N0(TPIoTClientManager.this).c().getCloudUserName()).g0(new a());
      }
      throw new Exception("AlCameraDevice is not Exist");
    }
    
    class a
      implements j<String, Boolean>
    {
      a() {}
      
      public Boolean a(String paramString)
        throws Exception
      {
        return Boolean.TRUE;
      }
    }
    
    class b
      implements io.reactivex.g0.g<io.reactivex.e0.c>
    {
      b(CameraSettingRepository paramCameraSettingRepository) {}
      
      public void a(io.reactivex.e0.c paramc)
        throws Exception
      {
        localObject.I1().F0();
      }
    }
  }
  
  class l
    implements io.reactivex.g0.g<Throwable>
  {
    l() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      TPIoTClientManager.Q(TPIoTClientManager.this);
      TPIoTClientManager.M(TPIoTClientManager.this).postValue(Boolean.TRUE);
    }
  }
  
  class l0
    implements j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, t<Boolean>>
  {
    l0() {}
    
    public t<Boolean> a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      return paramc.f();
    }
  }
  
  class l1
    implements j<Map<String, ? extends TDPIoTDevice>, Map<String, ? extends TDPIoTDevice>>
  {
    l1() {}
    
    public Map<String, ? extends TDPIoTDevice> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      TPIoTClientManager.v0(TPIoTClientManager.this).H(paramMap);
      return TPIoTClientManager.C0(TPIoTClientManager.this, paramMap);
    }
  }
  
  class l2
    implements io.reactivex.g0.g<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c>
  {
    l2() {}
    
    public void a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      paramc.k().C(io.reactivex.l0.a.c()).y();
    }
  }
  
  class m
    implements io.reactivex.g0.a
  {
    m() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.L(TPIoTClientManager.this);
      TPIoTClientManager.M(TPIoTClientManager.this).postValue(Boolean.TRUE);
    }
  }
  
  class m0
    implements j<List<TCDeviceBean>, t<IoTResult<List<TCDeviceBean>>>>
  {
    m0() {}
    
    public t<IoTResult<List<TCDeviceBean>>> a(List<TCDeviceBean> paramList)
      throws Exception
    {
      return io.reactivex.q.f0(new IoTResult(0, paramList));
    }
  }
  
  class m1
    implements j<Map<String, ? extends TDPIoTDevice>, Map<String, ? extends TDPIoTDevice>>
  {
    m1() {}
    
    public Map<String, ? extends TDPIoTDevice> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      return TPIoTClientManager.C0(TPIoTClientManager.this, paramMap);
    }
  }
  
  class m2
    implements io.reactivex.g0.g<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c>
  {
    m2() {}
    
    public void a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      if ((paramc instanceof AbstractThingRepository)) {
        ((AbstractThingRepository)paramc).v1().Z().C(io.reactivex.l0.a.c()).y();
      }
    }
  }
  
  class n
    implements j<Map<String, ? extends TDPIoTDevice>, List<BaseALIoTDevice>>
  {
    n(List paramList) {}
    
    public List<BaseALIoTDevice> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      return TPIoTClientManager.R(TPIoTClientManager.this, paramMap, localArrayList);
    }
  }
  
  class n0
    implements io.reactivex.g0.l<Throwable>
  {
    n0() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return paramThrowable instanceof CloudException;
    }
  }
  
  class n1
    implements j<Boolean, Boolean>
  {
    n1() {}
    
    public Boolean a(Boolean paramBoolean)
      throws Exception
    {
      TPIoTClientManager localTPIoTClientManager = TPIoTClientManager.this;
      EnumLoginResult localEnumLoginResult;
      if (paramBoolean.booleanValue()) {
        localEnumLoginResult = EnumLoginResult.CLOUD_SUCCESS;
      } else {
        localEnumLoginResult = EnumLoginResult.FAIL;
      }
      TPIoTClientManager.Q0(localTPIoTClientManager, localEnumLoginResult);
      return paramBoolean;
    }
  }
  
  class n2
    implements j<List<TCDeviceBean>, Boolean>
  {
    n2(String paramString) {}
    
    public Boolean a(List<TCDeviceBean> paramList)
      throws Exception
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (TCDeviceBean)localIterator.next();
        Object localObject = b.d.w.h.a.g(paramList.getDeviceId());
        if (paramString.equals(localObject))
        {
          localObject = TPIoTClientManager.this;
          TPIoTClientManager.q0((TPIoTClientManager)localObject, TPIoTClientManager.p0((TPIoTClientManager)localObject, new ALIoTDevice(paramList), true));
          return Boolean.TRUE;
        }
      }
      return Boolean.FALSE;
    }
  }
  
  class o
    implements j<com.tplink.libtpnetwork.IoTNetwork.repository.kb.c, t<Boolean>>
  {
    o() {}
    
    public t<Boolean> a(com.tplink.libtpnetwork.IoTNetwork.repository.kb.c paramc)
      throws Exception
    {
      return paramc.j();
    }
  }
  
  class o0
    implements j<List<ThingDevice>, t<IoTResult<List<ThingDevice>>>>
  {
    o0() {}
    
    public t<IoTResult<List<ThingDevice>>> a(List<ThingDevice> paramList)
      throws Exception
    {
      return io.reactivex.q.f0(new IoTResult(0, paramList));
    }
  }
  
  class o1
    implements io.reactivex.g0.a
  {
    o1() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.this.L3();
      TPIoTClientManager.H(TPIoTClientManager.this);
    }
  }
  
  class o2
    implements j<List<TCDeviceBean>, t<Boolean>>
  {
    o2(String paramString) {}
    
    public t<Boolean> a(List<TCDeviceBean> paramList)
      throws Exception
    {
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        TCDeviceBean localTCDeviceBean = (TCDeviceBean)localIterator.next();
        String str = b.d.w.h.a.g(localTCDeviceBean.getDeviceId());
        if (paramString.equals(str)) {
          paramList = localTCDeviceBean;
        }
      }
      if (paramList != null) {
        return TPIoTClientManager.this.w1(paramString, paramList);
      }
      return io.reactivex.q.f0(Boolean.FALSE);
    }
  }
  
  class p
    implements io.reactivex.g0.c<List<TCDeviceBean>, List<ThingDevice>, IoTResult<Map<String, BaseALIoTDevice>>>
  {
    p(b.d.s.a.b.a parama) {}
    
    public IoTResult<Map<String, BaseALIoTDevice>> a(List<TCDeviceBean> paramList, List<ThingDevice> paramList1)
      throws Exception
    {
      TPIoTClientManager.S(TPIoTClientManager.this, parama, paramList, paramList1);
      return new IoTResult(0, TPIoTClientManager.T(TPIoTClientManager.this, paramList, paramList1));
    }
  }
  
  class p0
    implements io.reactivex.g0.l<Throwable>
  {
    p0() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return paramThrowable instanceof IoTCloudException;
    }
  }
  
  class p1
    implements j<Boolean, Boolean>
  {
    p1() {}
    
    public Boolean a(Boolean paramBoolean)
      throws Exception
    {
      return Boolean.TRUE;
    }
  }
  
  class p2
    implements j<List<ThingDevice>, t<Boolean>>
  {
    p2(String paramString, TCDeviceBean paramTCDeviceBean) {}
    
    public t<Boolean> a(List<ThingDevice> paramList)
      throws Exception
    {
      Iterator localIterator = paramList.iterator();
      paramList = null;
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (ThingDevice)localIterator.next();
        String str = b.d.w.h.a.g(((ThingDevice)localObject).getThingName());
        if (paramString.equals(str)) {
          paramList = (List<ThingDevice>)localObject;
        }
      }
      if (paramList != null)
      {
        localObject = new ALIoTDevice(paramTCDeviceBean);
        ((ALIoTDevice)localObject).setThingDevice(paramList);
        return TPIoTClientManager.O0(TPIoTClientManager.this, (ALIoTDevice)localObject);
      }
      return io.reactivex.q.f0(Boolean.FALSE);
    }
  }
  
  class q
    implements j<List<BaseALIoTDevice>, t<Boolean>>
  {
    q() {}
    
    public t<Boolean> a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      return io.reactivex.q.f0(Boolean.TRUE);
    }
  }
  
  class q0
    implements j<b.d.s.a.b.a, io.reactivex.e>
  {
    q0() {}
    
    public io.reactivex.e a(b.d.s.a.b.a parama)
      throws Exception
    {
      String str = parama.e();
      if ((str != null) && (!str.isEmpty()) && (!str.equals(TPIoTClientManager.g0(TPIoTClientManager.this))))
      {
        TPIoTClientManager.h0(TPIoTClientManager.this, str);
        TPIoTClientManager.k0(TPIoTClientManager.this, true);
        return TPIoTClientManager.B(TPIoTClientManager.this).N("ANDROID", parama.d(), parama.a(), str, parama.b(), Locale.getDefault().toString(), parama.g());
      }
      return io.reactivex.a.e();
    }
  }
  
  class q1
    implements j<CommonCameraRepository, t<Boolean>>
  {
    q1() {}
    
    public t<Boolean> a(CommonCameraRepository paramCommonCameraRepository)
      throws Exception
    {
      return paramCommonCameraRepository.j();
    }
  }
  
  class q2
    implements io.reactivex.g0.g<Throwable>
  {
    q2() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {}
  }
  
  class r
    implements io.reactivex.g0.g<List<BaseALIoTDevice>>
  {
    r() {}
    
    public void a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      TPIoTClientManager.U(TPIoTClientManager.this, paramList);
    }
  }
  
  class r0
    implements io.reactivex.g0.a
  {
    r0(boolean paramBoolean) {}
    
    public void run()
      throws Exception
    {
      if (paramBoolean)
      {
        TPIoTClientManager.K(TPIoTClientManager.this);
        TPIoTClientManager.V(TPIoTClientManager.this).T0();
        TPIoTClientManager.V(TPIoTClientManager.this).S0();
        TPIoTClientManager.V(TPIoTClientManager.this).R0();
        TPIoTClientManager.i0(TPIoTClientManager.this).z1();
        TPIoTClientManager.u0(TPIoTClientManager.this).d1();
        TPIoTClientManager.F0(TPIoTClientManager.this).l0();
      }
    }
  }
  
  class r1
    implements j<ALCameraDevice, CommonCameraRepository>
  {
    r1() {}
    
    public CommonCameraRepository a(ALCameraDevice paramALCameraDevice)
      throws Exception
    {
      TDPCameraDevice localTDPCameraDevice = paramALCameraDevice.getTdpCameraDevice();
      CameraAvatarInfo localCameraAvatarInfo = paramALCameraDevice.getCameraAvatarInfo();
      paramALCameraDevice = b.d.w.h.a.g(TPIoTClientManager.D0(TPIoTClientManager.this).c().getCloudUserName());
      if ((localTDPCameraDevice != null) && (!TextUtils.isEmpty(localTDPCameraDevice.getOwner())) && (paramALCameraDevice.equalsIgnoreCase(localTDPCameraDevice.getOwner())))
      {
        Object localObject = b.d.w.h.a.g(localTDPCameraDevice.getDeviceId());
        paramALCameraDevice = (BaseALIoTDevice)TPIoTClientManager.G(TPIoTClientManager.this).get(localObject);
        if (paramALCameraDevice != null)
        {
          localObject = (ALCameraDevice)paramALCameraDevice;
          ((ALCameraDevice)localObject).setTDPIoTDevice(localTDPCameraDevice);
          ((ALCameraDevice)localObject).setCameraAvatarInfo(localCameraAvatarInfo);
        }
        else
        {
          paramALCameraDevice = new ALCameraDevice(localTDPCameraDevice);
          paramALCameraDevice.setCameraAvatarInfo(localCameraAvatarInfo);
          TPIoTClientManager.G(TPIoTClientManager.this).put(localObject, paramALCameraDevice);
        }
        return (CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.E0(TPIoTClientManager.this, paramALCameraDevice), CommonCameraRepository.class);
      }
      throw new Exception("tdpCameraDevice Owner is invalid");
    }
  }
  
  class r2
    implements io.reactivex.g0.g<Boolean>
  {
    r2() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {}
  }
  
  class s
    implements j<CloudAndTDPBean, List<BaseALIoTDevice>>
  {
    s(b.d.s.a.b.a parama) {}
    
    public List<BaseALIoTDevice> a(CloudAndTDPBean paramCloudAndTDPBean)
      throws Exception
    {
      IoTResult localIoTResult1 = paramCloudAndTDPBean.getTCDeviceListResult();
      IoTResult localIoTResult2 = paramCloudAndTDPBean.getThingDeviceListResult();
      paramCloudAndTDPBean = paramCloudAndTDPBean.getTDPIoTDeviceMap();
      if (localIoTResult1.getErrCode() == 0)
      {
        TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.ONLINE);
        TPIoTClientManager.S(TPIoTClientManager.this, parama, (List)localIoTResult1.getResult(), (List)localIoTResult2.getResult());
        TPIoTClientManager localTPIoTClientManager = TPIoTClientManager.this;
        return TPIoTClientManager.Y(localTPIoTClientManager, TPIoTClientManager.X(localTPIoTClientManager, (List)localIoTResult1.getResult(), paramCloudAndTDPBean, TPIoTClientManager.W(TPIoTClientManager.this, (List)localIoTResult2.getResult())));
      }
      if (paramCloudAndTDPBean.isEmpty())
      {
        TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.LOCAL_OFFLINE);
        return TPIoTClientManager.X(TPIoTClientManager.this, new ArrayList(), new HashMap(), new HashMap());
      }
      TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.LOCAL_OFFLINE);
      return TPIoTClientManager.X(TPIoTClientManager.this, new ArrayList(), paramCloudAndTDPBean, new HashMap());
    }
  }
  
  class s0
    implements j<Boolean, io.reactivex.e>
  {
    s0(List paramList1, List paramList2) {}
    
    public io.reactivex.e a(Boolean paramBoolean)
      throws Exception
    {
      if (TPIoTClientManager.l0(TPIoTClientManager.this, paramList2))
      {
        TPIoTClientManager.m0(TPIoTClientManager.this).clear();
        TPIoTClientManager.m0(TPIoTClientManager.this).addAll(paramList2);
        TPIoTClientManager.i0(TPIoTClientManager.this).e0().F0();
      }
      if ((!TextUtils.isEmpty(TPIoTClientManager.g0(TPIoTClientManager.this))) && (!TPIoTClientManager.j0(TPIoTClientManager.this)) && (!TPIoTClientManager.n0(TPIoTClientManager.this, paramList1))) {
        return io.reactivex.a.e();
      }
      TPIoTClientManager.o0(TPIoTClientManager.this).clear();
      TPIoTClientManager.o0(TPIoTClientManager.this).addAll(paramList1);
      return TPIoTClientManager.B(TPIoTClientManager.this).Q(paramList1);
    }
  }
  
  class s1
    implements j<String, t<Boolean>>
  {
    s1(String paramString) {}
    
    public t<Boolean> a(String paramString)
      throws Exception
    {
      return TPIoTClientManager.G0(TPIoTClientManager.this, paramString, paramString2);
    }
  }
  
  class s2
    implements io.reactivex.g0.g<Long>
  {
    s2(String paramString) {}
    
    public void a(Long paramLong)
      throws Exception
    {
      TPIoTClientManager.P0(TPIoTClientManager.this, paramString);
    }
  }
  
  class t
    implements io.reactivex.g0.h<IoTResult<List<TCDeviceBean>>, IoTResult<List<ThingDevice>>, Map<String, ? extends TDPIoTDevice>, CloudAndTDPBean>
  {
    t() {}
    
    public CloudAndTDPBean b(IoTResult<List<TCDeviceBean>> paramIoTResult, IoTResult<List<ThingDevice>> paramIoTResult1, Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      return new CloudAndTDPBean(paramIoTResult, paramIoTResult1, paramMap);
    }
  }
  
  class t0
    implements io.reactivex.g0.g<u>
  {
    t0(Application paramApplication) {}
    
    public void a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null))
      {
        TPIoTClientManager.this.r1(paramu.a());
        e0.b(paramApplication, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
      }
    }
  }
  
  class t1
    implements j<String, t<String>>
  {
    t1(String paramString) {}
    
    public t<String> a(String paramString)
      throws Exception
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)TPIoTClientManager.G(TPIoTClientManager.this).get(paramString);
      if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getCloudIoTDevice() != null)) {
        return TPIoTClientManager.H0(TPIoTClientManager.this).P(localBaseALIoTDevice.getAppServerUrl(), localBaseALIoTDevice.getDeviceId(), paramString2).q0(paramString);
      }
      return io.reactivex.q.f0(paramString);
    }
  }
  
  class t2
    implements io.reactivex.g0.a
  {
    t2() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.A(TPIoTClientManager.this).q();
      if (TPIoTClientManager.C(TPIoTClientManager.this) != null) {
        TPIoTClientManager.C(TPIoTClientManager.this).clear();
      }
    }
  }
  
  class u
    implements io.reactivex.g0.a
  {
    u() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.H(TPIoTClientManager.this);
      TPIoTClientManager.Z(TPIoTClientManager.this);
    }
  }
  
  class u0
    implements io.reactivex.g0.g<u>
  {
    u0(Application paramApplication) {}
    
    public void a(u paramu)
      throws Exception
    {
      if ((paramu.d()) && (paramu.c() != null))
      {
        TPIoTClientManager.this.r1(paramu.a());
        e0.b(paramApplication, com.tplink.libtpnetwork.TDPNetwork.a.q().r());
      }
    }
  }
  
  class u1
    implements io.reactivex.g0.a
  {
    u1(ALCameraDevice paramALCameraDevice, String paramString1, String paramString2) {}
    
    public void run()
      throws Exception
    {
      localObject.setDeviceAlias(paramString2);
      TPIoTClientManager.E0(TPIoTClientManager.this, localObject);
      TPIoTClientManager.G(TPIoTClientManager.this).put(paramString1, localObject);
      TPIoTClientManager.this.L3();
      TPIoTClientManager.H(TPIoTClientManager.this);
    }
  }
  
  class v
    implements Observer<List<ThingDevice>>
  {
    v() {}
    
    public void a(@Nullable List<ThingDevice> paramList)
    {
      TPIoTClientManager.z(TPIoTClientManager.this, paramList);
    }
  }
  
  class v0
    implements j<TDPIoTDevice, u>
  {
    v0() {}
    
    public u a(TDPIoTDevice paramTDPIoTDevice)
      throws Exception
    {
      TPIoTClientManager localTPIoTClientManager = TPIoTClientManager.this;
      return new u(true, TPIoTClientManager.q0(localTPIoTClientManager, TPIoTClientManager.p0(localTPIoTClientManager, new ALIoTDevice(paramTDPIoTDevice), true)));
    }
  }
  
  class v1
    implements j<CameraSettingRepository, t<Boolean>>
  {
    v1(String paramString) {}
    
    public t<Boolean> a(CameraSettingRepository paramCameraSettingRepository)
      throws Exception
    {
      return paramCameraSettingRepository.y1(paramString2);
    }
  }
  
  class w
    implements j<LoginAndTDPBean, t<Boolean>>
  {
    w(b.d.s.a.b.a parama) {}
    
    public t<Boolean> a(LoginAndTDPBean paramLoginAndTDPBean)
      throws Exception
    {
      Object localObject = paramLoginAndTDPBean.getLoginResult();
      paramLoginAndTDPBean = paramLoginAndTDPBean.getTDPIoTDeviceMap();
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        if ((TPIoTClientManager.a0(TPIoTClientManager.this) == null) || (TPIoTClientManager.a0(TPIoTClientManager.this).j1())) {
          TPIoTClientManager.b0(TPIoTClientManager.this, io.reactivex.m0.e.n1().l1());
        }
        TPIoTClientManager.a0(TPIoTClientManager.this).onNext(paramLoginAndTDPBean);
        TPIoTClientManager.a0(TPIoTClientManager.this).onComplete();
        return TPIoTClientManager.this.c2(parama);
      }
      if (paramLoginAndTDPBean.isEmpty())
      {
        TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.LOCAL_OFFLINE);
        paramLoginAndTDPBean = TPIoTClientManager.this;
        TPIoTClientManager.U(paramLoginAndTDPBean, TPIoTClientManager.X(paramLoginAndTDPBean, new ArrayList(), new HashMap(), new HashMap()));
        return io.reactivex.q.f0(Boolean.TRUE);
      }
      TPIoTClientManager.O(TPIoTClientManager.this).postValue(EnumHomeState.LOCAL_OFFLINE);
      localObject = TPIoTClientManager.this;
      TPIoTClientManager.U((TPIoTClientManager)localObject, TPIoTClientManager.X((TPIoTClientManager)localObject, new ArrayList(), paramLoginAndTDPBean, new HashMap()));
      return io.reactivex.q.f0(Boolean.TRUE);
    }
  }
  
  class w0
    implements j<String, t<u>>
  {
    w0(b.d.d0.h2.a.b paramb) {}
    
    public t<u> a(final String paramString)
      throws Exception
    {
      if (b.d.w.h.b.d(paramString)) {
        return io.reactivex.q.f0(new u(64036, null));
      }
      TPIoTClientManager.r0(TPIoTClientManager.this).g();
      paramb.q(paramString);
      paramString = TPIoTClientManager.s0(TPIoTClientManager.this, paramString);
      return ((QuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramString, QuickSetupRepository.class)).w5(paramb).g0(new a(paramString));
    }
    
    class a
      implements j<Boolean, u>
    {
      a(ThingContext paramThingContext) {}
      
      public u a(Boolean paramBoolean)
        throws Exception
      {
        boolean bool = paramBoolean.booleanValue();
        if (paramBoolean.booleanValue()) {
          paramBoolean = paramString;
        } else {
          paramBoolean = null;
        }
        return new u(bool, paramBoolean);
      }
    }
  }
  
  class w1
    implements j<TPCameraDeviceContext, CameraSettingRepository>
  {
    w1() {}
    
    public CameraSettingRepository a(TPCameraDeviceContext paramTPCameraDeviceContext)
      throws Exception
    {
      return (CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, CameraSettingRepository.class);
    }
  }
  
  class x
    implements io.reactivex.g0.c<Boolean, Map<String, ? extends TDPIoTDevice>, LoginAndTDPBean>
  {
    x() {}
    
    public LoginAndTDPBean a(Boolean paramBoolean, Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      return new LoginAndTDPBean(paramBoolean, paramMap);
    }
  }
  
  class x0
    implements MediaDeviceListCallBack
  {
    x0() {}
    
    public void onError(Exception paramException) {}
    
    public void onResult(Boolean paramBoolean) {}
  }
  
  class x1
    implements io.reactivex.g0.a
  {
    x1() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.this.L3();
      TPIoTClientManager.H(TPIoTClientManager.this);
    }
  }
  
  class y
    implements j<Map<String, ? extends TDPIoTDevice>, t<Boolean>>
  {
    y() {}
    
    public t<Boolean> a(Map<String, ? extends TDPIoTDevice> paramMap)
      throws Exception
    {
      if (paramMap.isEmpty())
      {
        paramMap = TPIoTClientManager.this;
        return TPIoTClientManager.d0(paramMap, TPIoTClientManager.c0(paramMap, new HashMap()));
      }
      TPIoTClientManager localTPIoTClientManager = TPIoTClientManager.this;
      return TPIoTClientManager.d0(localTPIoTClientManager, TPIoTClientManager.c0(localTPIoTClientManager, paramMap));
    }
  }
  
  class y0
    implements j<Boolean, t<Boolean>>
  {
    y0(b.d.s.a.b.a parama) {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      return TPIoTClientManager.t0(TPIoTClientManager.this, parama);
    }
  }
  
  class y1
    implements io.reactivex.g0.g<io.reactivex.e0.c>
  {
    y1(TCAccountBean paramTCAccountBean) {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      TPIoTClientManager.S0(TPIoTClientManager.this).O(paramTCAccountBean);
      TPIoTClientManager.A(TPIoTClientManager.this).t0(paramTCAccountBean);
      TPIoTClientManager.S0(TPIoTClientManager.this).Z();
      TPIoTClientManager.B(TPIoTClientManager.this).L();
    }
  }
  
  class z
    implements io.reactivex.g0.a
  {
    z() {}
    
    public void run()
      throws Exception
    {
      TPIoTClientManager.H(TPIoTClientManager.this);
    }
  }
  
  class z0
    implements Callable<Boolean>
  {
    z0() {}
    
    public Boolean a()
      throws Exception
    {
      if (TPIoTClientManager.S0(TPIoTClientManager.this).A()) {
        return Boolean.TRUE;
      }
      throw new CloudException(45334, "");
    }
  }
  
  class z1
    implements j<String, io.reactivex.e>
  {
    z1() {}
    
    public io.reactivex.e a(String paramString)
      throws Exception
    {
      return io.reactivex.a.e();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\TPIoTClientManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */