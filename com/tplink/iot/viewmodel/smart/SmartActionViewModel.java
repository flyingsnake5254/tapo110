package com.tplink.iot.viewmodel.smart;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.model.smart.f;
import com.tplink.iot.view.smart.a.c.a;
import com.tplink.iot.view.smart.a.g;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmartActionViewModel
  extends AndroidViewModel
{
  private SmartRepository a;
  private TPIoTClientManager b;
  private LightingEffectRepository c;
  private CloudVideoRepository d;
  private SingleLiveEvent<List<com.tplink.iot.model.smart.b>> e = new SingleLiveEvent();
  private SingleLiveEvent<RunShortCutResultBean> f = new SingleLiveEvent();
  private List<com.tplink.iot.model.smart.b> g = new ArrayList();
  private List<SmartInfo> h = new ArrayList();
  private List<SmartInfo> i = new ArrayList();
  private boolean j = false;
  private boolean k = false;
  
  public SmartActionViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((SmartRepository)b.d.b.f.b.a(paramApplication, SmartRepository.class));
    this.b = ((TPIoTClientManager)b.d.b.f.b.a(paramApplication, TPIoTClientManager.class));
    this.c = ((LightingEffectRepository)b.d.b.f.b.a(paramApplication, LightingEffectRepository.class));
    this.d = ((CloudVideoRepository)b.d.b.f.b.a(paramApplication, CloudVideoRepository.class));
    this.e.addSource(this.a.P(), new k(this));
  }
  
  private String M(@NonNull SmartThingAction paramSmartThingAction)
  {
    Object localObject = paramSmartThingAction.getNickname();
    ThingInfo localThingInfo = n(paramSmartThingAction.getThingName());
    paramSmartThingAction = (SmartThingAction)localObject;
    if (localThingInfo != null) {
      paramSmartThingAction = localThingInfo.getNickname();
    }
    if (localThingInfo != null) {
      return l.d(getApplication(), localThingInfo.getDeviceType(), paramSmartThingAction);
    }
    localObject = paramSmartThingAction;
    if (b.d.w.h.b.d(paramSmartThingAction)) {
      localObject = getApplication().getString(2131952465);
    }
    return (String)localObject;
  }
  
  private void N(AsyncResult paramAsyncResult, String paramString)
  {
    paramAsyncResult = g.d(paramAsyncResult, paramString);
    this.f.postValue(paramAsyncResult);
  }
  
  private void O(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof IoTCloudException))
    {
      paramThrowable = (IoTCloudException)paramThrowable;
      this.f.postValue(new RunShortCutResultBean(paramString, paramThrowable.getCode()));
    }
    else
    {
      this.f.postValue(new RunShortCutResultBean(paramString, -1));
    }
  }
  
  private boolean P(@Nullable Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.get("lighting_effect") != null))
    {
      paramMap = paramMap.get("lighting_effect");
      if (paramMap != null) {
        return f(LightingEffectData.resolveObject(paramMap));
      }
    }
    return false;
  }
  
  private void Y(List<SmartInfo> paramList)
  {
    this.g.clear();
    this.h.clear();
    this.i.clear();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (SmartInfo)localIterator.next();
        if (paramList.getTriggerSetting() != null) {
          if (paramList.getTriggerSetting().isManual())
          {
            this.h.add(paramList);
            localArrayList1.add(new com.tplink.iot.model.smart.c(paramList));
          }
          else
          {
            this.i.add(paramList);
            localArrayList2.add(new com.tplink.iot.model.smart.c(paramList));
          }
        }
      }
    }
    boolean bool1 = localArrayList1.isEmpty();
    boolean bool2 = false;
    if (!bool1) {
      localArrayList1.add(0, new f(getApplication().getString(2131954059).toUpperCase()));
    }
    if (!localArrayList2.isEmpty()) {
      localArrayList2.add(0, new f(getApplication().getString(2131954028).toUpperCase()));
    }
    bool1 = bool2;
    if (localArrayList1.isEmpty())
    {
      bool1 = bool2;
      if (localArrayList2.isEmpty()) {
        bool1 = true;
      }
    }
    this.k = bool1;
    this.g.addAll(localArrayList1);
    this.g.addAll(localArrayList2);
    if (this.j) {
      this.g.add(new com.tplink.iot.model.smart.d());
    }
    this.e.postValue(this.g);
  }
  
  private boolean f(@Nullable LightingEffectData paramLightingEffectData)
  {
    if (paramLightingEffectData == null) {
      return false;
    }
    Object localObject = paramLightingEffectData.custom;
    int m;
    if ((localObject != null) && (((Integer)localObject).intValue() == 1)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0) {
      return false;
    }
    if (this.c.X().getValue() == null) {
      return false;
    }
    localObject = this.c.V(paramLightingEffectData.id);
    if (localObject != null) {
      return com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B((CustomizedEffect)localObject).equals(paramLightingEffectData) ^ true;
    }
    return true;
  }
  
  private String g(String paramString, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(TextUtils.join(", ", paramVarArgs));
    return localStringBuilder.toString();
  }
  
  private String h(@NonNull List<String> paramList)
  {
    if (paramList.size() == 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder((String)paramList.get(0));
    for (int m = 1; m < paramList.size(); m++)
    {
      localStringBuilder.append(" | ");
      localStringBuilder.append((String)paramList.get(m));
    }
    return localStringBuilder.toString();
  }
  
  private ThingInfo n(String paramString)
  {
    return this.a.N(paramString);
  }
  
  private String p(@NonNull SmartReferAction paramSmartReferAction)
  {
    Object localObject = paramSmartReferAction.getName();
    SmartInfo localSmartInfo = m(paramSmartReferAction.getId());
    paramSmartReferAction = (SmartReferAction)localObject;
    if (localSmartInfo != null) {
      paramSmartReferAction = localSmartInfo.getName();
    }
    localObject = paramSmartReferAction;
    if (b.d.w.h.b.d(paramSmartReferAction)) {
      localObject = getApplication().getString(2131952464);
    }
    return (String)localObject;
  }
  
  public LiveData<List<DeviceCloudProduct>> A()
  {
    return this.d.V();
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> B()
  {
    return this.a.a0();
  }
  
  public SingleLiveEvent<Boolean> C()
  {
    return this.a.b0();
  }
  
  public SingleLiveEvent<RunShortCutResultBean> D()
  {
    return this.f;
  }
  
  public String E(@NonNull SmartReferAction paramSmartReferAction)
  {
    Object localObject = m(paramSmartReferAction.getId());
    String str = p(paramSmartReferAction);
    int m;
    if ((localObject != null) && (((SmartInfo)localObject).getTriggerSetting() != null) && (!((SmartInfo)localObject).getTriggerSetting().isManual())) {
      m = 1;
    } else {
      m = 0;
    }
    localObject = getApplication();
    if ((m != 0) && (paramSmartReferAction.getAction() == 0)) {
      m = 2131953969;
    } else if ((m != 0) && (paramSmartReferAction.getAction() != 0)) {
      m = 2131953977;
    } else {
      m = 2131953994;
    }
    return ((Application)localObject).getString(m, new Object[] { str });
  }
  
  public List<SmartInfo> F()
  {
    return this.h;
  }
  
  public String G(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    return paramString1;
  }
  
  public SingleLiveEvent<List<com.tplink.iot.model.smart.b>> H()
  {
    return this.e;
  }
  
  public String I(@NonNull SmartReferAction paramSmartReferAction)
  {
    SmartInfo localSmartInfo = m(paramSmartReferAction.getId());
    if ((localSmartInfo != null) && (localSmartInfo.getTriggerSetting() != null))
    {
      if (localSmartInfo.getTriggerSetting().isManual()) {
        paramSmartReferAction = getApplication().getString(2131953993);
      } else if (paramSmartReferAction.getAction() == 0) {
        paramSmartReferAction = getApplication().getString(2131953968);
      } else {
        paramSmartReferAction = getApplication().getString(2131953975);
      }
      return paramSmartReferAction;
    }
    return getApplication().getString(2131953982);
  }
  
  public String J(@Nullable SmartThingAction paramSmartThingAction, BaseALIoTDevice paramBaseALIoTDevice)
  {
    String str = com.tplink.iot.view.smart.a.c.c(paramSmartThingAction, paramBaseALIoTDevice, new c.a().g(true).h(true));
    paramBaseALIoTDevice = str;
    if (paramSmartThingAction != null)
    {
      paramBaseALIoTDevice = str;
      if (P(paramSmartThingAction.getStateDesired())) {
        paramBaseALIoTDevice = getApplication().getString(2131953987);
      }
    }
    return paramBaseALIoTDevice;
  }
  
  public String K(SmartThingAction paramSmartThingAction, boolean paramBoolean)
  {
    return com.tplink.iot.view.smart.a.c.c(paramSmartThingAction, null, new c.a().h(false).g(paramBoolean).f(true));
  }
  
  public String L(@NonNull SmartThingAction paramSmartThingAction, c.a parama)
  {
    Object localObject = com.tplink.iot.view.smart.a.c.c(paramSmartThingAction, null, parama);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    String str = g(M(paramSmartThingAction), new String[] { localObject });
    localObject = str;
    if (!parama.a())
    {
      localObject = str;
      if (P(paramSmartThingAction.getStateDesired())) {
        localObject = getApplication().getString(2131953987);
      }
    }
    return (String)localObject;
  }
  
  public boolean Q()
  {
    return this.k;
  }
  
  public boolean R(String paramString)
  {
    return this.a.q0(paramString);
  }
  
  public void Z(boolean paramBoolean)
  {
    this.j = paramBoolean;
    int m = this.g.size();
    if (m > 0)
    {
      List localList = this.g;
      m--;
      if ((localList.get(m) instanceof com.tplink.iot.model.smart.d)) {
        this.g.remove(m);
      }
    }
    if (this.j) {
      this.g.add(new com.tplink.iot.model.smart.d());
    }
    this.e.postValue(this.g);
  }
  
  public void i(String paramString)
  {
    this.a.H(paramString).y();
  }
  
  public void j(SmartInfo paramSmartInfo)
  {
    this.a.I(paramSmartInfo).y();
  }
  
  @SuppressLint({"CheckResult"})
  public void k(String paramString)
  {
    this.a.J(paramString).I0(new i(this, paramString), new h(this, paramString), j.a);
  }
  
  @Nullable
  public BaseALIoTDevice l(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = t();
    Object localObject3 = localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      do
      {
        localObject3 = localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (BaseALIoTDevice)((Iterator)localObject2).next();
      } while (!paramString.equals(((BaseALIoTDevice)localObject3).getDeviceId()));
    }
    return (BaseALIoTDevice)localObject3;
  }
  
  public SmartInfo m(String paramString)
  {
    return this.a.M(paramString);
  }
  
  public String o(SmartInfo paramSmartInfo)
  {
    if ((paramSmartInfo != null) && (R(paramSmartInfo.getId())))
    {
      List localList = paramSmartInfo.getActionSetting().getThings();
      ArrayList localArrayList = new ArrayList();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SmartThingAction)((Iterator)localObject1).next();
          if (n(((SmartThingAction)localObject2).getThingName()) != null) {
            localArrayList.add(L((SmartThingAction)localObject2, new c.a()));
          }
        }
      }
      Object localObject2 = paramSmartInfo.getActionSetting().getSmarts();
      Object localObject1 = new ArrayList();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        paramSmartInfo = ((List)localObject2).iterator();
        while (paramSmartInfo.hasNext())
        {
          SmartReferAction localSmartReferAction = (SmartReferAction)paramSmartInfo.next();
          if (m(localSmartReferAction.getId()) != null) {
            ((List)localObject1).add(E(localSmartReferAction));
          }
        }
      }
      int m;
      if (((localList != null) && (!localList.isEmpty()) && (localArrayList.size() < localList.size())) || ((localObject2 != null) && (!((List)localObject2).isEmpty()) && (((List)localObject1).size() < ((List)localObject2).size()))) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        return getApplication().getString(2131953999);
      }
      localArrayList.addAll((Collection)localObject1);
      if (!localArrayList.isEmpty()) {
        paramSmartInfo = h(localArrayList);
      } else {
        paramSmartInfo = getApplication().getString(2131953988);
      }
      return paramSmartInfo;
    }
    return getApplication().getString(2131953988);
  }
  
  public void r()
  {
    this.a.R(true).F0();
  }
  
  public void s()
  {
    if (com.tplink.iot.Utils.v0.d.d())
    {
      this.d.I().F0();
      this.d.d0().F0();
    }
  }
  
  public List<BaseALIoTDevice> t()
  {
    return (List)this.b.C1().getValue();
  }
  
  public void u()
  {
    this.a.S().F0();
  }
  
  public List<SmartInfo> v()
  {
    return this.i;
  }
  
  public MutableLiveData<List<ThingInfo>> w()
  {
    return this.a.W();
  }
  
  public LiveData<List<CustomizedEffect>> x()
  {
    return this.c.X();
  }
  
  public void y()
  {
    this.c.W().F0();
  }
  
  public SingleLiveEvent<Boolean> z()
  {
    return this.a.Z();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\SmartActionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */