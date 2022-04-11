package com.tplink.iot.dailysummary.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.network.DailySummaryRepository;
import com.tplink.iot.dailysummary.network.bean.common.SummaryConfig;
import com.tplink.iot.dailysummary.network.bean.result.SummarySupportResult;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.p;

public final class DailySummaryViewModel
  extends BaseSummaryListViewModel
{
  public static final a n = new a(null);
  private final LiveData<String> A;
  private final LiveData<ArrayList<b>> B;
  private final LiveData<Boolean> C;
  private final LiveData<Boolean> D;
  private final LiveData<Boolean> E;
  private Calendar o;
  private Calendar p;
  private String q = "";
  private CommonCameraRepository r;
  private b.d.w.g.a s;
  private final MutableLiveData<com.tplink.iot.dailysummary.model.d> t;
  private final MutableLiveData<com.tplink.iot.dailysummary.model.d> u;
  private final MutableLiveData<Boolean> v;
  private final MutableLiveData<Boolean> w;
  private final MutableLiveData<Boolean> x;
  private final MutableLiveData<Boolean> y;
  private final LiveData<b> z;
  
  public DailySummaryViewModel(final Application paramApplication)
  {
    super(paramApplication);
    Object localObject1 = new MutableLiveData();
    this.t = ((MutableLiveData)localObject1);
    this.u = new MutableLiveData();
    this.v = new MutableLiveData();
    this.w = new MutableLiveData();
    this.x = new MutableLiveData();
    this.y = new MutableLiveData();
    Object localObject2 = Transformations.map(x(), o.a);
    kotlin.jvm.internal.j.d(localObject2, "Transformations.map(mSum…    it[0]\n        }\n    }");
    this.z = ((LiveData)localObject2);
    localObject2 = Transformations.map(x(), new p(this, paramApplication));
    kotlin.jvm.internal.j.d(localObject2, "Transformations.map(mSum…        }\n        }\n    }");
    this.A = ((LiveData)localObject2);
    localObject2 = Transformations.map(x(), n.a);
    kotlin.jvm.internal.j.d(localObject2, "Transformations.map(mSum…     }\n        list\n    }");
    this.B = ((LiveData)localObject2);
    localObject2 = Transformations.map((LiveData)localObject2, i.a);
    kotlin.jvm.internal.j.d(localObject2, "Transformations.map(summ…        it.size > 0\n    }");
    this.C = ((LiveData)localObject2);
    localObject2 = Transformations.map(x(), k.a);
    kotlin.jvm.internal.j.d(localObject2, "Transformations.map(mSum…        it.size > 0\n    }");
    this.D = ((LiveData)localObject2);
    localObject2 = Transformations.map(x(), j.a);
    kotlin.jvm.internal.j.d(localObject2, "Transformations.map(mSum…        it.size > 2\n    }");
    this.E = ((LiveData)localObject2);
    ((MutableLiveData)localObject1).setValue(com.tplink.iot.e.a.c.k.j());
    localObject1 = Calendar.getInstance();
    localObject2 = TimeZone.getDefault();
    kotlin.jvm.internal.j.d(localObject2, "TimeZone.getDefault()");
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone(((TimeZone)localObject2).getID()));
    ((Calendar)localObject1).setTimeInMillis(System.currentTimeMillis());
    ((Calendar)localObject1).add(5, -1);
    localObject2 = p.a;
    kotlin.jvm.internal.j.d(localObject1, "Calendar.getInstance().a…Y_OF_MONTH, -1)\n        }");
    this.o = ((Calendar)localObject1);
    localObject1 = Calendar.getInstance();
    localObject2 = TimeZone.getDefault();
    kotlin.jvm.internal.j.d(localObject2, "TimeZone.getDefault()");
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone(((TimeZone)localObject2).getID()));
    ((Calendar)localObject1).setTimeInMillis(System.currentTimeMillis());
    ((Calendar)localObject1).add(5, -3);
    kotlin.jvm.internal.j.d(localObject1, "Calendar.getInstance().a…Y_OF_MONTH, -3)\n        }");
    this.p = ((Calendar)localObject1);
    this.s = new b.d.w.g.a(paramApplication.getApplicationContext(), "DailySummary");
  }
  
  private final boolean S()
  {
    com.tplink.iot.dailysummary.model.d locald1 = (com.tplink.iot.dailysummary.model.d)this.u.getValue();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (locald1 != null)
    {
      com.tplink.iot.dailysummary.model.d locald2 = (com.tplink.iot.dailysummary.model.d)this.t.getValue();
      bool2 = bool1;
      if (locald2 != null) {
        if ((locald1.e() == locald2.e()) && (locald1.b() == locald2.b()))
        {
          bool2 = bool1;
          if (locald1.f() == locald2.f()) {}
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private final void T(ALCameraDevice paramALCameraDevice)
  {
    final Object localObject1 = (CameraSettingRepository)e.c(b.d.w.h.a.g(s()), CameraSettingRepository.class);
    paramALCameraDevice = paramALCameraDevice.getDeviceType();
    if (paramALCameraDevice != null)
    {
      b.d.w.g.a locala = this.s;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("timeZoneId");
      ((StringBuilder)localObject2).append(s());
      localObject2 = locala.f(((StringBuilder)localObject2).toString(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = s();
        kotlin.jvm.internal.j.d(localObject2, "timeZoneLocal");
        g0((String)localObject1, (String)localObject2, paramALCameraDevice, false);
        return;
      }
      localObject2 = ((CameraSettingRepository)localObject1).x();
      if (localObject2 != null)
      {
        localObject2 = ((SettingsData)localObject2).getZoneId();
        if (localObject2 != null)
        {
          g0(s(), (String)localObject2, paramALCameraDevice, true);
          return;
        }
      }
      localObject2 = this.r;
      kotlin.jvm.internal.j.c(localObject2);
      ((CommonCameraRepository)localObject2).K0().T0(5L, TimeUnit.SECONDS).N(new b(this, (CameraSettingRepository)localObject1)).E(new c(paramALCameraDevice, this, (CameraSettingRepository)localObject1)).C(new d(this, (CameraSettingRepository)localObject1)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F0();
    }
  }
  
  private final boolean U(String paramString)
  {
    paramString = com.tplink.iot.e.a.a.a(paramString);
    int i = paramString.e();
    Calendar localCalendar = this.o;
    boolean bool = true;
    if ((i != localCalendar.get(1)) || (paramString.d() != this.o.get(2) + 1) || (paramString.c() != this.o.get(5))) {
      bool = false;
    }
    return bool;
  }
  
  private final void d0(final String paramString)
  {
    DailySummaryRepository localDailySummaryRepository = t();
    if (localDailySummaryRepository != null) {
      localDailySummaryRepository.K(paramString).a(new e(this, paramString));
    }
  }
  
  private final void g0(final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      DailySummaryRepository localDailySummaryRepository = t();
      if (localDailySummaryRepository != null) {
        localDailySummaryRepository.M(paramString1, paramString2, paramString3).F(new f(this, paramString1, paramString2, paramString3, paramBoolean)).E(new g(this, paramString1, paramString2, paramString3, paramBoolean)).C(h.c).F0();
      }
    }
  }
  
  private final void o0(final SummaryConfig paramSummaryConfig)
  {
    DailySummaryRepository localDailySummaryRepository = t();
    if (localDailySummaryRepository != null) {
      localDailySummaryRepository.N(paramSummaryConfig).i(new l(this, paramSummaryConfig)).j(new m(this, paramSummaryConfig)).y();
    }
  }
  
  public final void P(boolean paramBoolean)
  {
    Object localObject = (com.tplink.iot.dailysummary.model.d)this.u.getValue();
    if (localObject != null)
    {
      ((com.tplink.iot.dailysummary.model.d)localObject).h(paramBoolean);
      this.x.setValue(Boolean.valueOf(S()));
      localObject = this.u;
      ((MutableLiveData)localObject).setValue(((LiveData)localObject).getValue());
    }
  }
  
  public final void Q(boolean paramBoolean)
  {
    Object localObject = (com.tplink.iot.dailysummary.model.d)this.u.getValue();
    if (localObject != null)
    {
      ((com.tplink.iot.dailysummary.model.d)localObject).i(paramBoolean);
      this.x.setValue(Boolean.valueOf(S()));
      localObject = this.u;
      ((MutableLiveData)localObject).setValue(((LiveData)localObject).getValue());
    }
  }
  
  public final void R(boolean paramBoolean)
  {
    Object localObject = (com.tplink.iot.dailysummary.model.d)this.u.getValue();
    if (localObject != null)
    {
      ((com.tplink.iot.dailysummary.model.d)localObject).j(paramBoolean);
      this.x.setValue(Boolean.valueOf(S()));
      localObject = this.u;
      ((MutableLiveData)localObject).setValue(((LiveData)localObject).getValue());
    }
  }
  
  public final MutableLiveData<Boolean> V()
  {
    return this.w;
  }
  
  public final LiveData<Boolean> W()
  {
    return this.C;
  }
  
  public final LiveData<Boolean> X()
  {
    return this.E;
  }
  
  public final LiveData<Boolean> Y()
  {
    return this.D;
  }
  
  public final MutableLiveData<com.tplink.iot.dailysummary.model.d> Z()
  {
    return this.t;
  }
  
  public final MutableLiveData<Boolean> a0()
  {
    return this.y;
  }
  
  public final MutableLiveData<Boolean> b0()
  {
    return this.v;
  }
  
  public final LiveData<ArrayList<b>> c0()
  {
    return this.B;
  }
  
  public final MutableLiveData<com.tplink.iot.dailysummary.model.d> e0()
  {
    return this.u;
  }
  
  public final MutableLiveData<Boolean> f0()
  {
    return this.x;
  }
  
  public final LiveData<b> h0()
  {
    return this.z;
  }
  
  public final LiveData<String> i0()
  {
    return this.A;
  }
  
  public final void j0(boolean paramBoolean)
  {
    m0(paramBoolean);
    l0();
    com.tplink.iot.e.a.c.k.o(false);
  }
  
  public final void k0()
  {
    Object localObject1 = com.tplink.iot.e.a.c.k;
    F(((com.tplink.iot.e.a.c)localObject1).b());
    localObject1 = ((com.tplink.iot.e.a.c)localObject1).e();
    Object localObject2 = (Boolean)((HashMap)localObject1).get(s());
    if (localObject2 != null)
    {
      r().setValue(localObject2);
    }
    else
    {
      localObject2 = (CommonCameraRepository)e.c(b.d.w.h.a.g(s()), CommonCameraRepository.class);
      this.r = ((CommonCameraRepository)localObject2);
      if (localObject2 != null)
      {
        localObject2 = (TPCameraDeviceContext)((com.tplink.libtpnetwork.IoTNetwork.repository.kb.c)localObject2).b();
        if (localObject2 != null)
        {
          localObject2 = (ALCameraDevice)((TPBaseDeviceContext)localObject2).getCameraDevice();
          if (localObject2 != null)
          {
            kotlin.jvm.internal.j.d(localObject2, "device");
            T((ALCameraDevice)localObject2);
            return;
          }
        }
      }
      localObject2 = r();
      Boolean localBoolean = Boolean.FALSE;
      ((MutableLiveData)localObject2).setValue(localBoolean);
      localObject1 = (Boolean)((HashMap)localObject1).put(s(), localBoolean);
    }
  }
  
  public final void l0()
  {
    d0(s());
  }
  
  protected void m0(boolean paramBoolean)
  {
    if (kotlin.jvm.internal.j.a((Boolean)r().getValue(), Boolean.TRUE)) {
      D(s(), 0, 3, paramBoolean);
    } else {
      A(s(), 3, paramBoolean);
    }
  }
  
  public final void n0()
  {
    com.tplink.iot.dailysummary.model.d locald = (com.tplink.iot.dailysummary.model.d)this.u.getValue();
    if (locald != null)
    {
      SummaryConfig localSummaryConfig = new SummaryConfig();
      localSummaryConfig.setDeviceId(s());
      localSummaryConfig.setAuto(locald.b());
      String str;
      if (locald.f()) {
        str = "basic";
      } else {
        str = "smart";
      }
      localSummaryConfig.setStrategy(str);
      localSummaryConfig.setTimezone(this.q);
      localSummaryConfig.setNotify(locald.e());
      o0(localSummaryConfig);
    }
  }
  
  public final void p0(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      MutableLiveData localMutableLiveData = this.u;
      com.tplink.iot.dailysummary.model.d locald = (com.tplink.iot.dailysummary.model.d)this.t.getValue();
      if (locald != null) {
        locald = locald.a();
      } else {
        locald = null;
      }
      localMutableLiveData.setValue(locald);
      this.x.setValue(Boolean.FALSE);
    }
    this.v.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public static final class a {}
  
  static final class b<T, R>
    implements io.reactivex.g0.j<CameraComponent, t<? extends Boolean>>
  {
    b(DailySummaryViewModel paramDailySummaryViewModel, CameraSettingRepository paramCameraSettingRepository) {}
    
    public final t<? extends Boolean> a(CameraComponent paramCameraComponent)
    {
      kotlin.jvm.internal.j.e(paramCameraComponent, "cameraComponent");
      return localObject1.K(paramCameraComponent).L0(io.reactivex.l0.a.c());
    }
  }
  
  static final class c<T>
    implements g<Boolean>
  {
    c(String paramString, DailySummaryViewModel paramDailySummaryViewModel, CameraSettingRepository paramCameraSettingRepository) {}
    
    public final void a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.d(paramBoolean, "aBoolean");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = localObject1.x();
        if (paramBoolean != null)
        {
          paramBoolean = paramBoolean.getZoneId();
          if (paramBoolean != null)
          {
            DailySummaryViewModel localDailySummaryViewModel = jdField_this;
            DailySummaryViewModel.N(localDailySummaryViewModel, localDailySummaryViewModel.s(), paramBoolean, this.c, true);
            return;
          }
        }
      }
      throw new Exception("getSupportDailySummaryByTimezone failed");
    }
  }
  
  static final class d<T>
    implements g<Throwable>
  {
    d(DailySummaryViewModel paramDailySummaryViewModel, CameraSettingRepository paramCameraSettingRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      Object localObject = this.c.r();
      Boolean localBoolean = Boolean.FALSE;
      ((MutableLiveData)localObject).setValue(localBoolean);
      com.tplink.iot.e.a.c.k.e().put(this.c.s(), localBoolean);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDeviceSetting failed: ");
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      b.d.w.c.a.d(((StringBuilder)localObject).toString());
    }
  }
  
  public static final class e
    implements v<SummaryConfig>
  {
    e(DailySummaryViewModel paramDailySummaryViewModel, String paramString) {}
    
    public void a(SummaryConfig paramSummaryConfig)
    {
      kotlin.jvm.internal.j.e(paramSummaryConfig, "result");
      boolean bool1 = paramSummaryConfig.isAuto();
      boolean bool2 = "basic".equals(paramSummaryConfig.getStrategy());
      boolean bool3 = paramSummaryConfig.isNotify();
      DailySummaryViewModel localDailySummaryViewModel = this.c;
      paramSummaryConfig = paramSummaryConfig.getTimezone();
      kotlin.jvm.internal.j.d(paramSummaryConfig, "result.timezone");
      DailySummaryViewModel.O(localDailySummaryViewModel, paramSummaryConfig);
      paramSummaryConfig = new com.tplink.iot.dailysummary.model.d(bool1, bool2, bool3);
      com.tplink.iot.e.a.c.k.s(paramSummaryConfig);
      DailySummaryViewModel.K(this.c).setValue(paramSummaryConfig);
      DailySummaryViewModel.J(this.c).setValue(Boolean.TRUE);
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "e");
      b.d.w.c.a.c("tylerTest", "getSummaryConfig Request failed!");
      DailySummaryViewModel.J(this.c).setValue(Boolean.FALSE);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      kotlin.jvm.internal.j.e(paramc, "d");
    }
  }
  
  static final class f<T>
    implements g<io.reactivex.e0.c>
  {
    f(DailySummaryViewModel paramDailySummaryViewModel, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      if (paramBoolean)
      {
        paramc = DailySummaryViewModel.I(this.c);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("timeZoneId");
        localStringBuilder.append(paramString1);
        paramc.k(localStringBuilder.toString(), paramString2);
      }
    }
  }
  
  static final class g<T>
    implements g<SummarySupportResult>
  {
    g(DailySummaryViewModel paramDailySummaryViewModel, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
    
    public final void a(SummarySupportResult paramSummarySupportResult)
    {
      MutableLiveData localMutableLiveData = this.c.r();
      kotlin.jvm.internal.j.d(paramSummarySupportResult, "supportResult");
      localMutableLiveData.setValue(paramSummarySupportResult.getSupport());
      com.tplink.iot.e.a.c.k.e().put(this.c.s(), paramSummarySupportResult.getSupport());
    }
  }
  
  static final class h<T>
    implements g<Throwable>
  {
    public static final h c = new h();
    
    public final void a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSupportDailySummaryByTimezone failed:");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.d(localStringBuilder.toString());
    }
  }
  
  static final class i<I, O>
    implements Function<ArrayList<b>, Boolean>
  {
    public static final i a = new i();
    
    public final Boolean a(ArrayList<b> paramArrayList)
    {
      boolean bool;
      if (paramArrayList.size() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class j<I, O>
    implements Function<ArrayList<b>, Boolean>
  {
    public static final j a = new j();
    
    public final Boolean a(ArrayList<b> paramArrayList)
    {
      boolean bool;
      if (paramArrayList.size() > 2) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class k<I, O>
    implements Function<ArrayList<b>, Boolean>
  {
    public static final k a = new k();
    
    public final Boolean a(ArrayList<b> paramArrayList)
    {
      boolean bool;
      if (paramArrayList.size() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class l
    implements io.reactivex.g0.a
  {
    l(DailySummaryViewModel paramDailySummaryViewModel, SummaryConfig paramSummaryConfig) {}
    
    public final void run()
    {
      com.tplink.iot.dailysummary.model.d locald = (com.tplink.iot.dailysummary.model.d)DailySummaryViewModel.M(this.a).getValue();
      if (locald != null)
      {
        locald = new com.tplink.iot.dailysummary.model.d(locald.b(), locald.f(), locald.e());
        com.tplink.iot.e.a.c.k.s(locald);
        DailySummaryViewModel.K(this.a).setValue(locald);
      }
      this.a.j0(true);
      DailySummaryViewModel.L(this.a).setValue(Boolean.TRUE);
      this.a.p0(false);
    }
  }
  
  static final class m<T>
    implements g<Throwable>
  {
    m(DailySummaryViewModel paramDailySummaryViewModel, SummaryConfig paramSummaryConfig) {}
    
    public final void a(Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeSummaryConfig failed: ");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.c("tylerTest", localStringBuilder.toString());
      DailySummaryViewModel.L(this.c).setValue(Boolean.FALSE);
    }
  }
  
  static final class n<I, O>
    implements Function<ArrayList<b>, ArrayList<b>>
  {
    public static final n a = new n();
    
    public final ArrayList<b> a(ArrayList<b> paramArrayList)
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramArrayList.size();
      int j = 1;
      i--;
      if (1 <= i) {
        for (;;)
        {
          if (localArrayList.size() < 2) {
            localArrayList.add(paramArrayList.get(j));
          }
          if (j == i) {
            break;
          }
          j++;
        }
      }
      return localArrayList;
    }
  }
  
  static final class o<I, O>
    implements Function<ArrayList<b>, b>
  {
    public static final o a = new o();
    
    public final b a(ArrayList<b> paramArrayList)
    {
      if (paramArrayList.size() == 0) {
        return null;
      }
      return (b)paramArrayList.get(0);
    }
  }
  
  static final class p<I, O>
    implements Function<ArrayList<b>, String>
  {
    p(DailySummaryViewModel paramDailySummaryViewModel, Application paramApplication) {}
    
    public final String a(ArrayList<b> paramArrayList)
    {
      if ((paramArrayList.size() != 0) && (!TextUtils.isEmpty(((b)paramArrayList.get(0)).c())))
      {
        if (DailySummaryViewModel.H(this.a, ((b)paramArrayList.get(0)).c())) {
          paramArrayList = paramApplication.getApplicationContext().getString(2131954524);
        } else {
          paramArrayList = ((b)paramArrayList.get(0)).c();
        }
        return paramArrayList;
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\viewmodel\DailySummaryViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */