package com.tplink.iot.viewmodel.quicksetup.subg;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SubGQuickSetupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

public final class SwitchQuickSetupViewModel
  extends AndroidViewModel
{
  public static final b a = new b(null);
  private final HashMap<SwitchButton, ALIoTDevice> b = new HashMap();
  private final HashMap<SwitchButton, a> c = new HashMap();
  private String d;
  private String e = "";
  private String f = "";
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> g;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> h;
  private int i;
  private final MutableLiveData<Integer> j;
  private final LiveData<Integer> k;
  private io.reactivex.m0.e<Integer> l;
  private c m;
  private c n;
  private boolean o;
  private boolean p;
  private final ThingCloudRepository q;
  private final f r;
  
  public SwitchQuickSetupViewModel(Application paramApplication)
  {
    super(paramApplication);
    paramApplication = new MutableLiveData();
    this.g = paramApplication;
    this.h = paramApplication;
    paramApplication = new MutableLiveData(Integer.valueOf(this.i));
    this.j = paramApplication;
    this.k = paramApplication;
    paramApplication = b.a(b.d.s.a.a.f(), ThingCloudRepository.class);
    kotlin.jvm.internal.j.d(paramApplication, "CloudRepositoryProviders…udRepository::class.java)");
    this.q = ((ThingCloudRepository)paramApplication);
    this.r = h.b(new i(this));
  }
  
  private final void C()
  {
    this.m = E().Y0().E(new g(this)).C(new h(this)).F0();
  }
  
  private final SubGQuickSetupRepository E()
  {
    return (SubGQuickSetupRepository)this.r.getValue();
  }
  
  private final void H()
  {
    this.o = true;
    I(548);
  }
  
  private final void I(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("noFindDeviceResult errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    b.d.w.c.a.e("SwitchQuickSetupViewModel", ((StringBuilder)localObject).toString());
    if ((this.p) && (this.o))
    {
      localObject = this.l;
      if (localObject != null)
      {
        if (!(((io.reactivex.m0.e)localObject).j1() ^ true)) {
          localObject = null;
        }
        if (localObject != null)
        {
          ((io.reactivex.m0.e)localObject).onNext(Integer.valueOf(0));
          ((io.reactivex.m0.e)localObject).onComplete();
        }
      }
    }
  }
  
  private final void J()
  {
    b.d.w.c.a.e("SwitchQuickSetupViewModel", "noTDPFindDeviceResult error");
    this.p = true;
    I(543);
  }
  
  private final q<Boolean> L()
  {
    q localq = this.q.S().g0(new j(this));
    kotlin.jvm.internal.j.d(localq, "mThingCloudRepository.al… count >= 2\n            }");
    return localq;
  }
  
  private final void R(int paramInt)
  {
    r();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setQuickSetupInfo findType: ");
    localStringBuilder.append(paramInt);
    b.d.w.c.a.e("SwitchQuickSetupViewModel", localStringBuilder.toString());
    if (paramInt == 1) {
      T();
    } else {
      S();
    }
  }
  
  private final void S()
  {
    SwitchButton[] arrayOfSwitchButton = SwitchButton.values();
    ArrayList localArrayList = new ArrayList(arrayOfSwitchButton.length);
    int i1 = arrayOfSwitchButton.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      localObject = arrayOfSwitchButton[i2];
      localArrayList.add(E().g5(A((SwitchButton)localObject), B((SwitchButton)localObject), z((SwitchButton)localObject)));
    }
    Object localObject = new SubThingQuickSetupInfoListParams();
    ((SubThingQuickSetupInfoListParams)localObject).setDataList(localArrayList);
    E().o5((SubThingQuickSetupInfoListParams)localObject).i(new k(this)).j(new l(this)).y();
  }
  
  private final void T()
  {
    SwitchButton[] arrayOfSwitchButton = SwitchButton.values();
    ArrayList localArrayList = new ArrayList(arrayOfSwitchButton.length);
    int i1 = arrayOfSwitchButton.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      SwitchButton localSwitchButton = arrayOfSwitchButton[i2];
      DeviceInfoParams localDeviceInfoParams = new DeviceInfoParams(B(localSwitchButton), z(localSwitchButton));
      localArrayList.add(E().p5(localDeviceInfoParams, A(localSwitchButton)));
    }
    io.reactivex.a.p(localArrayList).i(new m(this)).j(new n(this)).y();
  }
  
  private final a V(SwitchButton paramSwitchButton)
  {
    a locala = (a)this.c.get(paramSwitchButton);
    if (locala != null)
    {
      paramSwitchButton = locala;
    }
    else
    {
      locala = new a(null, null, null, 7, null);
      this.c.put(paramSwitchButton, locala);
      paramSwitchButton = locala;
    }
    return paramSwitchButton;
  }
  
  private final void W()
  {
    b.d.w.c.a.e("SwitchQuickSetupViewModel", "tdpFindDeviceResult success");
    this.p = true;
    y(1);
  }
  
  private final void X(SwitchButton paramSwitchButton, IoTSubDevice paramIoTSubDevice, ThingDevice paramThingDevice)
  {
    HashMap localHashMap = this.b;
    Object localObject1 = localHashMap.get(paramSwitchButton);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ALIoTDevice(paramIoTSubDevice);
      localHashMap.put(paramSwitchButton, localObject2);
    }
    paramSwitchButton = (ALIoTDevice)localObject2;
    if (paramIoTSubDevice != null) {
      paramSwitchButton.setLocalIoTDevice(paramIoTSubDevice);
    }
    if (paramThingDevice != null) {
      paramSwitchButton.setThingDevice(paramThingDevice);
    }
  }
  
  private final void s()
  {
    c localc = this.n;
    if ((localc != null) && (!localc.isDisposed())) {
      localc.dispose();
    }
  }
  
  private final void t()
  {
    c localc = this.m;
    if ((localc != null) && (!localc.isDisposed())) {
      localc.dispose();
    }
  }
  
  private final void u()
  {
    this.o = true;
    y(2);
  }
  
  private final void v()
  {
    this.i += 1;
    this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    this.j.postValue(Integer.valueOf(this.i));
  }
  
  private final void w()
  {
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    this.n = q.W0(3L, localTimeUnit).N(new c(this)).T0(20L, localTimeUnit).E(new d(this)).C(new e(this)).F0();
  }
  
  private final void y(int paramInt)
  {
    io.reactivex.m0.e locale = this.l;
    if (locale != null)
    {
      if (!(locale.j1() ^ true)) {
        locale = null;
      }
      if (locale != null)
      {
        locale.onNext(Integer.valueOf(paramInt));
        locale.onComplete();
        if (!this.p) {
          t();
        }
        if (!this.o) {
          s();
        }
      }
    }
  }
  
  public final String A(SwitchButton paramSwitchButton)
  {
    kotlin.jvm.internal.j.e(paramSwitchButton, "button");
    Object localObject = (ALIoTDevice)this.b.get(paramSwitchButton);
    if (localObject != null) {
      localObject = ((ALIoTDevice)localObject).getDeviceId();
    } else {
      localObject = null;
    }
    int i1;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0)
    {
      b.d.w.c.a.e("SwitchQuickSetupViewModel", "getButtonDeviceId concat");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('0');
      ((StringBuilder)localObject).append(paramSwitchButton.getPos() - 1);
      localObject = ((StringBuilder)localObject).toString();
      paramSwitchButton = new StringBuilder();
      paramSwitchButton.append(this.e);
      paramSwitchButton.append((String)localObject);
      return paramSwitchButton.toString();
    }
    b.d.w.c.a.e("SwitchQuickSetupViewModel", "getButtonDeviceId direct");
    return (String)localObject;
  }
  
  public final String B(SwitchButton paramSwitchButton)
  {
    kotlin.jvm.internal.j.e(paramSwitchButton, "button");
    return V(paramSwitchButton).b();
  }
  
  public final String D()
  {
    String str = this.d;
    if (str == null) {
      str = "";
    }
    return str;
  }
  
  public final LiveData<Integer> F()
  {
    return this.k;
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> G()
  {
    return this.h;
  }
  
  public final void K()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Switch QuickSetup Info: ");
    localStringBuilder.append(this.c);
    b.d.w.c.a.e("SwitchQuickSetupViewModel", localStringBuilder.toString());
  }
  
  public final void M(SwitchButton paramSwitchButton, String paramString)
  {
    kotlin.jvm.internal.j.e(paramSwitchButton, "button");
    kotlin.jvm.internal.j.e(paramString, "avatar");
    V(paramSwitchButton).c(paramString);
  }
  
  public final void N(SwitchButton paramSwitchButton, String paramString)
  {
    kotlin.jvm.internal.j.e(paramSwitchButton, "button");
    kotlin.jvm.internal.j.e(paramString, "name");
    V(paramSwitchButton).e(paramString);
  }
  
  public final void O(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHubDeviceIdMD5: ");
    localStringBuilder.append(paramString);
    b.d.w.c.a.e("SwitchQuickSetupViewModel", localStringBuilder.toString());
    if (paramString == null) {
      paramString = "";
    }
    this.f = paramString;
  }
  
  public final void P(SwitchButton paramSwitchButton, String paramString)
  {
    kotlin.jvm.internal.j.e(paramSwitchButton, "button");
    kotlin.jvm.internal.j.e(paramString, "location");
    V(paramSwitchButton).d(paramString);
  }
  
  public final void Q(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "location");
    this.d = paramString;
    SwitchButton[] arrayOfSwitchButton = SwitchButton.values();
    int i1 = arrayOfSwitchButton.length;
    for (int i2 = 0; i2 < i1; i2++) {
      P(arrayOfSwitchButton[i2], paramString);
    }
  }
  
  public final void U(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSwitchDeviceId deviceId: ");
    localStringBuilder.append(paramString);
    b.d.w.c.a.e("SwitchQuickSetupViewModel", localStringBuilder.toString());
    if (paramString == null) {
      paramString = "";
    }
    this.e = paramString;
  }
  
  public final void r()
  {
    t();
    s();
  }
  
  public final void x()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("findDeviceByTDPAndCloud setupInfo: ");
    ((StringBuilder)localObject).append(this.c);
    b.d.w.c.a.e("SwitchQuickSetupViewModel", ((StringBuilder)localObject).toString());
    int i1;
    if (this.e.length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      b.d.w.c.a.e("SwitchQuickSetupViewModel", "findDeviceByTDPAndCloud false");
      this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
      return;
    }
    this.o = false;
    this.p = false;
    localObject = io.reactivex.m0.e.n1();
    ((q)localObject).T0(30L, TimeUnit.SECONDS).q0(Integer.valueOf(0)).E(new f(this)).F0();
    p localp = p.a;
    this.l = ((io.reactivex.m0.e)localObject);
    w();
    C();
  }
  
  public final String z(SwitchButton paramSwitchButton)
  {
    kotlin.jvm.internal.j.e(paramSwitchButton, "button");
    return V(paramSwitchButton).a();
  }
  
  private static final class a
  {
    private String a;
    private String b;
    private String c;
    
    public a()
    {
      this(null, null, null, 7, null);
    }
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }
    
    public final String a()
    {
      return this.b;
    }
    
    public final String b()
    {
      return this.a;
    }
    
    public final void c(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "<set-?>");
      this.b = paramString;
    }
    
    public final void d(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "<set-?>");
      this.c = paramString;
    }
    
    public final void e(String paramString)
    {
      kotlin.jvm.internal.j.e(paramString, "<set-?>");
      this.a = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((kotlin.jvm.internal.j.a(this.a, ((a)paramObject).a)) && (kotlin.jvm.internal.j.a(this.b, ((a)paramObject).b)) && (kotlin.jvm.internal.j.a(this.c, ((a)paramObject).c))) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      String str = this.a;
      int i = 0;
      int j;
      if (str != null) {
        j = str.hashCode();
      } else {
        j = 0;
      }
      str = this.b;
      int k;
      if (str != null) {
        k = str.hashCode();
      } else {
        k = 0;
      }
      str = this.c;
      if (str != null) {
        i = str.hashCode();
      }
      return (j * 31 + k) * 31 + i;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ButtonSetupInfo(name=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", avatar=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", location=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  public static final class b {}
  
  static final class c<T, R>
    implements io.reactivex.g0.j<Long, t<? extends Boolean>>
  {
    c(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final t<? extends Boolean> a(Long paramLong)
    {
      kotlin.jvm.internal.j.e(paramLong, "it");
      return SwitchQuickSetupViewModel.m(this.c);
    }
  }
  
  static final class d<T>
    implements g<Boolean>
  {
    d(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void a(Boolean paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("findDeviceByCloud doNext find: ");
      localStringBuilder.append(paramBoolean);
      b.d.w.c.a.e("SwitchQuickSetupViewModel", localStringBuilder.toString());
      kotlin.jvm.internal.j.d(paramBoolean, "isFind");
      if (paramBoolean.booleanValue()) {
        SwitchQuickSetupViewModel.f(this.c);
      } else {
        SwitchQuickSetupViewModel.k(this.c);
      }
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("findDeviceByCloud doOnError throwable: ");
      localStringBuilder.append(paramThrowable);
      b.d.w.c.a.e("SwitchQuickSetupViewModel", localStringBuilder.toString());
      SwitchQuickSetupViewModel.k(this.c);
    }
  }
  
  static final class f<T>
    implements g<Integer>
  {
    f(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void a(Integer paramInteger)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findDeviceByTDPAndCloud doOnNext findType: ");
      ((StringBuilder)localObject).append(paramInteger);
      b.d.w.c.a.e("SwitchQuickSetupViewModel", ((StringBuilder)localObject).toString());
      this.c.r();
      localObject = this.c;
      kotlin.jvm.internal.j.d(paramInteger, "findType");
      SwitchQuickSetupViewModel.n((SwitchQuickSetupViewModel)localObject, paramInteger.intValue());
    }
  }
  
  static final class g<T>
    implements g<List<IoTSubDevice>>
  {
    g(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void a(List<IoTSubDevice> paramList)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getChildDeviceList list ");
      ((StringBuilder)localObject).append(paramList.size());
      b.d.w.c.a.e("SwitchQuickSetupViewModel", ((StringBuilder)localObject).toString());
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        IoTSubDevice localIoTSubDevice = (IoTSubDevice)paramList.next();
        kotlin.jvm.internal.j.d(localIoTSubDevice, "it");
        if (kotlin.jvm.internal.j.a(localIoTSubDevice.getOriginalDeviceId(), SwitchQuickSetupViewModel.j(this.c)))
        {
          int j = i + 1;
          localObject = SwitchButton.Companion.a(localIoTSubDevice.getPosition());
          i = j;
          if (localObject != null)
          {
            SwitchQuickSetupViewModel.p(this.c, (SwitchButton)localObject, localIoTSubDevice, null);
            i = j;
          }
        }
      }
      if (i >= 2) {
        SwitchQuickSetupViewModel.o(this.c);
      } else {
        SwitchQuickSetupViewModel.l(this.c);
      }
    }
  }
  
  static final class h<T>
    implements g<Throwable>
  {
    h(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChildDeviceList error ");
      localStringBuilder.append(paramThrowable);
      b.d.w.c.a.e("SwitchQuickSetupViewModel", localStringBuilder.toString());
      SwitchQuickSetupViewModel.l(this.c);
    }
  }
  
  static final class i
    extends Lambda
    implements kotlin.jvm.b.a<SubGQuickSetupRepository>
  {
    i(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel)
    {
      super();
    }
    
    public final SubGQuickSetupRepository a()
    {
      return (SubGQuickSetupRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(SwitchQuickSetupViewModel.h(this.c), SubGQuickSetupRepository.class);
    }
  }
  
  static final class j<T, R>
    implements io.reactivex.g0.j<List<ThingInfo>, Boolean>
  {
    j(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final Boolean a(List<ThingInfo> paramList)
    {
      kotlin.jvm.internal.j.e(paramList, "thingInfoList");
      Iterator localIterator = paramList.iterator();
      boolean bool = false;
      int i = 0;
      while (localIterator.hasNext())
      {
        paramList = (ThingInfo)localIterator.next();
        kotlin.jvm.internal.j.d(paramList, "info");
        if (kotlin.jvm.internal.j.a(paramList.getOriginalThingName(), SwitchQuickSetupViewModel.j(this.c)))
        {
          int j = i + 1;
          SwitchButton localSwitchButton = SwitchButton.Companion.a(paramList.getPosition());
          i = j;
          if (localSwitchButton != null)
          {
            SwitchQuickSetupViewModel.p(this.c, localSwitchButton, null, new ThingDevice(paramList));
            i = j;
          }
        }
      }
      if (i >= 2) {
        bool = true;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class k
    implements io.reactivex.g0.a
  {
    k(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void run()
    {
      b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoCloud onComplete");
      SwitchQuickSetupViewModel.i(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class l<T>
    implements g<Throwable>
  {
    l(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoCloud onError");
      SwitchQuickSetupViewModel.g(this.c);
    }
  }
  
  static final class m
    implements io.reactivex.g0.a
  {
    m(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void run()
    {
      b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoLocal onComplete");
      SwitchQuickSetupViewModel.i(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class n<T>
    implements g<Throwable>
  {
    n(SwitchQuickSetupViewModel paramSwitchQuickSetupViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.e("SwitchQuickSetupViewModel", "setQuickSetupInfoLocal onError");
      SwitchQuickSetupViewModel.g(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\subg\SwitchQuickSetupViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */