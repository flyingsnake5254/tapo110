package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import b.d.d.m.f;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MarkPositionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerracePoint;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.MarkPositionConfirmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionListInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.p;
import kotlin.text.m;

public final class CloudTerracePresetViewModel
  extends AndroidViewModel
  implements LifecycleObserver
{
  private static final String c;
  public static final a d = new a(null);
  private final MutableLiveData<String> H3 = new MutableLiveData();
  private final io.reactivex.e0.b I3 = new io.reactivex.e0.b();
  private MarkPositionRepository J3;
  private MutableLiveData<Boolean> K3 = new MutableLiveData();
  private final MutableLiveData<Boolean> L3 = new MutableLiveData();
  private final MutableLiveData<Boolean> M3 = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> N3 = new MutableLiveData();
  private final MutableLiveData<f<Pair<Bitmap, String>>> O3 = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> P3 = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> Q3 = new MutableLiveData();
  private DataBindingListAdapter R3;
  private String f;
  private final ArrayList<String> p0 = new ArrayList();
  private final ArrayList<Integer> p1 = new ArrayList();
  private final ArrayList<Object> p2 = new ArrayList();
  private final MediatorLiveData<ArrayList<MarkedPositionInfo>> p3 = new MediatorLiveData();
  private TPCameraDeviceContext q;
  private CloudTerraceControlViewModel x;
  private boolean y;
  private Bitmap z;
  
  static
  {
    String str = CloudTerracePresetViewModel.class.getSimpleName();
    kotlin.jvm.internal.j.d(str, "CloudTerracePresetViewModel::class.java.simpleName");
    c = str;
  }
  
  public CloudTerracePresetViewModel(Application paramApplication)
  {
    super(paramApplication);
    this.K3.setValue(Boolean.TRUE);
  }
  
  private final File J(String paramString)
  {
    return new File(b.d.q.b.p.b.f(), paramString);
  }
  
  private final File K(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".PNG");
    return J(localStringBuilder.toString());
  }
  
  private final String N(@StringRes int paramInt)
  {
    String str = getApplication().getString(paramInt);
    kotlin.jvm.internal.j.d(str, "getApplication<Application>().getString(id)");
    return str;
  }
  
  private final boolean Q()
  {
    if (V())
    {
      this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(N(2131952356)));
      return true;
    }
    return false;
  }
  
  private final boolean R()
  {
    if (W())
    {
      this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(N(2131952358)));
      return true;
    }
    return false;
  }
  
  private final void S(Throwable paramThrowable, String paramString)
  {
    b.d.w.c.a.e(c, Log.getStackTraceString(paramThrowable));
    if ((paramThrowable instanceof CameraException)) {
      switch (((CameraException)paramThrowable).getErrorCode())
      {
      default: 
        break;
      case -64304: 
        this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(N(2131954405)));
        return;
      case -64305: 
      case -64303: 
        this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(N(2131952364)));
        return;
      case -64306: 
        this.N3.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        return;
      }
    }
    if (paramString != null) {
      this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
    }
  }
  
  private final void U(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    MarkPositionRepository localMarkPositionRepository = this.J3;
    if (localMarkPositionRepository != null) {
      this.p3.removeSource(localMarkPositionRepository.u());
    }
    paramTPCameraDeviceContext = (MarkPositionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, MarkPositionRepository.class);
    this.J3 = paramTPCameraDeviceContext;
    if (paramTPCameraDeviceContext != null) {
      this.p3.removeSource(paramTPCameraDeviceContext.u());
    }
    paramTPCameraDeviceContext = this.p3;
    localMarkPositionRepository = this.J3;
    kotlin.jvm.internal.j.c(localMarkPositionRepository);
    paramTPCameraDeviceContext.addSource(localMarkPositionRepository.u(), new b3(new k(this.p3)));
    G(this.y);
  }
  
  private final boolean V()
  {
    CloudTerraceControlViewModel localCloudTerraceControlViewModel = this.x;
    if (localCloudTerraceControlViewModel == null) {
      kotlin.jvm.internal.j.t("cloudTerraceControlViewModel");
    }
    return localCloudTerraceControlViewModel.y();
  }
  
  private final boolean W()
  {
    CloudTerraceControlViewModel localCloudTerraceControlViewModel = this.x;
    if (localCloudTerraceControlViewModel == null) {
      kotlin.jvm.internal.j.t("cloudTerraceControlViewModel");
    }
    return localCloudTerraceControlViewModel.z();
  }
  
  private final ArrayList<MarkedPositionInfo> a0(MarkedPositionListInfo paramMarkedPositionListInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramMarkedPositionListInfo.getIdList().length;
    for (int j = 0; j < i; j++)
    {
      int k = paramMarkedPositionListInfo.getIdList()[j].intValue();
      String str = paramMarkedPositionListInfo.getNameList()[j];
      double d1 = paramMarkedPositionListInfo.getPositionPanList()[j];
      double d2 = paramMarkedPositionListInfo.getPositionTiltList()[j];
      Object localObject = this.f;
      kotlin.jvm.internal.j.c(localObject);
      localObject = K((String)localObject, k, str);
      localArrayList.add(new MarkedPositionInfo(k, str, Integer.valueOf(paramMarkedPositionListInfo.getReadOnlyList()[j]), Double.valueOf(d1), Double.valueOf(d2), localObject));
    }
    return localArrayList;
  }
  
  private final void i0()
  {
    if (com.tplink.libtpnetwork.Utils.j.g(this.M3)) {
      this.M3.postValue(Boolean.TRUE);
    }
  }
  
  private final void j0(String paramString1, int paramInt, String paramString2, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".PNG");
    k0(localStringBuilder.toString(), paramBitmap);
  }
  
  private final void k0(String paramString, Bitmap paramBitmap)
  {
    if (paramString != null)
    {
      int i;
      if (paramString.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) && (paramBitmap != null))
      {
        File localFile = new File(b.d.q.b.p.b.f(), paramString);
        try
        {
          paramString = new java/io/FileOutputStream;
          paramString.<init>(localFile);
          paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
          paramString.flush();
          paramString.close();
          paramBitmap.recycle();
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  private final void w()
  {
    if (this.f == null) {
      return;
    }
    if (this.p1.size() == 0) {
      return;
    }
    String[] arrayOfString = new File(b.d.q.b.p.b.f()).list();
    if (arrayOfString != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = this.p1.size();
      Object localObject;
      for (int j = 0; j < i; j++)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(String.valueOf(((Number)this.p1.get(j)).intValue()));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append((String)this.p0.get(j));
        ((StringBuilder)localObject).append(".PNG");
        localArrayList.add(((StringBuilder)localObject).toString());
      }
      i = arrayOfString.length;
      for (j = 0; j < i; j++)
      {
        localObject = arrayOfString[j];
        String str = this.f;
        kotlin.jvm.internal.j.c(str);
        if ((m.A((String)localObject, str, false, 2, null)) && (m.p((String)localObject, ".PNG", false, 2, null)) && (!localArrayList.contains(localObject)))
        {
          getApplication().deleteFile((String)localObject);
          str = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delete redundant picture:");
          localStringBuilder.append((String)localObject);
          b.d.w.c.a.i(str, localStringBuilder.toString());
        }
      }
    }
  }
  
  private final void y(String paramString1, int paramInt, String paramString2)
  {
    Application localApplication = getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".PNG");
    localApplication.deleteFile(localStringBuilder.toString());
  }
  
  public final MutableLiveData<f<Pair<Bitmap, String>>> A()
  {
    return this.O3;
  }
  
  public final MutableLiveData<Boolean> B()
  {
    return this.M3;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> C()
  {
    return this.Q3;
  }
  
  public final ArrayList<Integer> D()
  {
    return this.p1;
  }
  
  public final ArrayList<String> E()
  {
    return this.p0;
  }
  
  public final ArrayList<Object> F()
  {
    return this.p2;
  }
  
  public final void G(final boolean paramBoolean)
  {
    Object localObject = this.J3;
    if (localObject != null)
    {
      kotlin.jvm.internal.j.c(localObject);
      localObject = ((MarkPositionRepository)localObject).t(new b(this)).F(new c(this, paramBoolean)).y(new d3(new d(this))).H0(e.c, new f(this, paramBoolean));
      this.I3.b((c)localObject);
    }
  }
  
  public final DataBindingListAdapter H()
  {
    return this.R3;
  }
  
  public final MutableLiveData<Boolean> I()
  {
    return this.K3;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> L()
  {
    return this.N3;
  }
  
  public final Bitmap M()
  {
    return this.z;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> O()
  {
    return this.P3;
  }
  
  public final void P(int paramInt)
  {
    if ((!Q()) && (!R()))
    {
      Object localObject = this.J3;
      kotlin.jvm.internal.j.c(localObject);
      localObject = ((MarkPositionRepository)localObject).v(paramInt).F(new g(this)).y(new d3(new h(this))).H0(i.c, new j(this));
      this.I3.b((c)localObject);
    }
  }
  
  public final MutableLiveData<Boolean> X()
  {
    return this.L3;
  }
  
  public final boolean Y()
  {
    boolean bool;
    if (this.p1.size() >= 8) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void Z()
  {
    if ((!Q()) && (!R()))
    {
      i0();
      Object localObject = this.f;
      kotlin.jvm.internal.j.c(localObject);
      LiveMediaAPI.snapshot((String)localObject, this.O3);
      localObject = "";
      for (int i = 1; i <= 8; i++)
      {
        localObject = getApplication();
        kotlin.jvm.internal.j.d(localObject, "getApplication<Application>()");
        localObject = ((Application)localObject).getResources();
        int j = 0;
        localObject = ((Resources)localObject).getString(2131952362, new Object[] { String.valueOf(i) });
        kotlin.jvm.internal.j.d(localObject, "getApplication<Applicati…me_default, i.toString())");
        Iterator localIterator = this.p0.iterator();
        do
        {
          k = j;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!kotlin.jvm.internal.j.a(localObject, (String)localIterator.next()));
        int k = 1;
        if (k == 0) {
          break;
        }
      }
      this.H3.setValue(localObject);
    }
  }
  
  public final void b0(final String paramString, final int paramInt)
  {
    kotlin.jvm.internal.j.e(paramString, "name");
    if ((!Q()) && (!R()))
    {
      MarkPositionRepository localMarkPositionRepository = this.J3;
      kotlin.jvm.internal.j.c(localMarkPositionRepository);
      paramString = localMarkPositionRepository.y(new CloudTerraceResetInfo(new String[] { String.valueOf(paramInt) })).l0(io.reactivex.d0.b.a.a()).F(new l(this)).y(new d3(new m(this))).H0(new n(this, paramInt, paramString), new o(this));
      this.I3.b(paramString);
    }
  }
  
  public final void c0()
  {
    final Object localObject = com.tplink.libtpnetwork.Utils.j.e(this.H3, "");
    kotlin.jvm.internal.j.d(localObject, "LiveDataUtils.getValue(c…PositionNameLiveData, \"\")");
    localObject = (String)localObject;
    MarkPositionRepository localMarkPositionRepository = this.J3;
    if (localMarkPositionRepository != null)
    {
      localObject = localMarkPositionRepository.x(new CloudTerracePoint((String)localObject, "1")).l0(io.reactivex.d0.b.a.a()).F(new p(this, (String)localObject)).y(new c3(new s(this))).H0(new q(this, (String)localObject), new r(this, (String)localObject));
      this.I3.b((c)localObject);
    }
  }
  
  public final void d0(String paramString)
  {
    if (d0.a(this.f, paramString)) {
      return;
    }
    this.f = paramString;
    this.q = null;
    this.J3 = null;
    if (paramString != null)
    {
      kotlin.jvm.internal.j.c(paramString);
      paramString = TPIoTClientManager.K1(paramString);
      this.q = paramString;
      kotlin.jvm.internal.j.c(paramString);
      paramString = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramString, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new t(this), u.c);
      this.I3.b(paramString);
    }
  }
  
  public final void e0(LifecycleOwner paramLifecycleOwner)
  {
    kotlin.jvm.internal.j.e(paramLifecycleOwner, "lifeCycleOwner");
    paramLifecycleOwner.getLifecycle().addObserver(this);
    this.p3.observe(paramLifecycleOwner, new v(this));
    this.K3.observe(paramLifecycleOwner, new w(this));
  }
  
  public final void f0(DataBindingListAdapter paramDataBindingListAdapter)
  {
    this.R3 = paramDataBindingListAdapter;
  }
  
  public final void g0(Bitmap paramBitmap)
  {
    this.z = paramBitmap;
  }
  
  public final void h0(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onActivityDestroyed()
  {
    this.I3.d();
    w();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public final void onActivityStarted()
  {
    boolean bool;
    if ((this.p1.size() == 0) && (this.y)) {
      bool = true;
    } else {
      bool = false;
    }
    G(bool);
  }
  
  public final void v(CloudTerraceControlViewModel paramCloudTerraceControlViewModel)
  {
    kotlin.jvm.internal.j.e(paramCloudTerraceControlViewModel, "viewModel");
    this.x = paramCloudTerraceControlViewModel;
  }
  
  public final void x()
  {
    if (com.tplink.libtpnetwork.Utils.j.h(this.M3)) {
      this.M3.postValue(Boolean.FALSE);
    }
  }
  
  public final MutableLiveData<String> z()
  {
    return this.H3;
  }
  
  public static final class a {}
  
  static final class c<T>
    implements g<c>
  {
    c(CloudTerracePresetViewModel paramCloudTerracePresetViewModel, boolean paramBoolean) {}
    
    public final void a(c paramc)
    {
      if (paramBoolean) {
        CloudTerracePresetViewModel.t(this.c);
      }
    }
  }
  
  static final class e<T>
    implements g<ArrayList<MarkedPositionInfo>>
  {
    public static final e c = new e();
    
    public final void a(ArrayList<MarkedPositionInfo> paramArrayList) {}
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(CloudTerracePresetViewModel paramCloudTerracePresetViewModel, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      CloudTerracePresetViewModel localCloudTerracePresetViewModel;
      if (paramBoolean)
      {
        localCloudTerracePresetViewModel = this.c;
        kotlin.jvm.internal.j.d(paramThrowable, "it");
        CloudTerracePresetViewModel.T(localCloudTerracePresetViewModel, paramThrowable, null, 2, null);
      }
      else
      {
        localCloudTerracePresetViewModel = this.c;
        kotlin.jvm.internal.j.d(paramThrowable, "it");
        CloudTerracePresetViewModel.p(localCloudTerracePresetViewModel, paramThrowable, null);
      }
      CloudTerracePresetViewModel.i(this.c).postValue(new ArrayList());
    }
  }
  
  static final class g<T>
    implements g<c>
  {
    g(CloudTerracePresetViewModel paramCloudTerracePresetViewModel) {}
    
    public final void a(c paramc)
    {
      CloudTerracePresetViewModel.t(this.c);
    }
  }
  
  static final class i<T>
    implements g<Boolean>
  {
    public static final i c = new i();
    
    public final void a(Boolean paramBoolean) {}
  }
  
  static final class j<T>
    implements g<Throwable>
  {
    j(CloudTerracePresetViewModel paramCloudTerracePresetViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.c;
      kotlin.jvm.internal.j.d(paramThrowable, "it");
      CloudTerracePresetViewModel.T(localCloudTerracePresetViewModel, paramThrowable, null, 2, null);
    }
  }
  
  static final class l<T>
    implements g<c>
  {
    l(CloudTerracePresetViewModel paramCloudTerracePresetViewModel) {}
    
    public final void a(c paramc)
    {
      CloudTerracePresetViewModel.t(this.c);
    }
  }
  
  static final class n<T>
    implements g<Boolean>
  {
    n(CloudTerracePresetViewModel paramCloudTerracePresetViewModel, int paramInt, String paramString) {}
    
    public final void a(Boolean paramBoolean)
    {
      paramBoolean = this.c;
      String str = CloudTerracePresetViewModel.h(paramBoolean);
      kotlin.jvm.internal.j.c(str);
      CloudTerracePresetViewModel.f(paramBoolean, str, paramInt, paramString);
      int i = CloudTerracePresetViewModel.j(this.c).size();
      for (int j = 0; j < i; j++)
      {
        paramBoolean = (Integer)CloudTerracePresetViewModel.j(this.c).get(j);
        if ((paramBoolean != null) && (paramBoolean.intValue() == paramInt))
        {
          CloudTerracePresetViewModel.m(this.c).remove(j);
          CloudTerracePresetViewModel.l(this.c).remove(j);
          CloudTerracePresetViewModel.j(this.c).remove(j);
          break;
        }
      }
      paramBoolean = this.c.H();
      if (paramBoolean != null) {
        paramBoolean.s();
      }
      if ((CloudTerracePresetViewModel.j(this.c).size() == 0) && (!((Boolean)com.tplink.libtpnetwork.Utils.j.e(this.c.I(), Boolean.FALSE)).booleanValue())) {
        this.c.I().setValue(Boolean.TRUE);
      }
    }
  }
  
  static final class o<T>
    implements g<Throwable>
  {
    o(CloudTerracePresetViewModel paramCloudTerracePresetViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.c;
      kotlin.jvm.internal.j.d(paramThrowable, "it");
      CloudTerracePresetViewModel.T(localCloudTerracePresetViewModel, paramThrowable, null, 2, null);
    }
  }
  
  static final class p<T>
    implements g<c>
  {
    p(CloudTerracePresetViewModel paramCloudTerracePresetViewModel, String paramString) {}
    
    public final void a(c paramc)
    {
      CloudTerracePresetViewModel.t(this.c);
    }
  }
  
  static final class q<T>
    implements g<MarkPositionConfirmInfo>
  {
    q(CloudTerracePresetViewModel paramCloudTerracePresetViewModel, String paramString) {}
    
    public final void a(MarkPositionConfirmInfo paramMarkPositionConfirmInfo)
    {
      Object localObject1 = this.c;
      Object localObject2 = CloudTerracePresetViewModel.h((CloudTerracePresetViewModel)localObject1);
      kotlin.jvm.internal.j.c(localObject2);
      CloudTerracePresetViewModel.u((CloudTerracePresetViewModel)localObject1, (String)localObject2, paramMarkPositionConfirmInfo.getId(), paramMarkPositionConfirmInfo.getName(), this.c.M());
      localObject2 = this.c.I();
      localObject1 = Boolean.FALSE;
      localObject2 = com.tplink.libtpnetwork.Utils.j.e((MutableLiveData)localObject2, localObject1);
      kotlin.jvm.internal.j.d(localObject2, "LiveDataUtils.getValue(o…owMarkPositionBtn, false)");
      if (((Boolean)localObject2).booleanValue()) {
        this.c.I().setValue(localObject1);
      }
      CloudTerracePresetViewModel.j(this.c).add(0, Integer.valueOf(paramMarkPositionConfirmInfo.getId()));
      ArrayList localArrayList = CloudTerracePresetViewModel.l(this.c);
      localObject2 = this.c;
      localObject1 = CloudTerracePresetViewModel.h((CloudTerracePresetViewModel)localObject2);
      kotlin.jvm.internal.j.c(localObject1);
      localArrayList.add(0, CloudTerracePresetViewModel.k((CloudTerracePresetViewModel)localObject2, (String)localObject1, paramMarkPositionConfirmInfo.getId(), paramMarkPositionConfirmInfo.getName()));
      CloudTerracePresetViewModel.m(this.c).add(0, paramMarkPositionConfirmInfo.getName());
      paramMarkPositionConfirmInfo = this.c.H();
      if (paramMarkPositionConfirmInfo != null) {
        paramMarkPositionConfirmInfo.s();
      }
      this.c.O().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(CloudTerracePresetViewModel.n(this.c, 2131954521)));
      com.tplink.iot.Utils.x0.e.o(CloudTerracePresetViewModel.h(this.c));
    }
  }
  
  static final class r<T>
    implements g<Throwable>
  {
    r(CloudTerracePresetViewModel paramCloudTerracePresetViewModel, String paramString) {}
    
    public final void a(Throwable paramThrowable)
    {
      CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.c;
      kotlin.jvm.internal.j.d(paramThrowable, "it");
      CloudTerracePresetViewModel.T(localCloudTerracePresetViewModel, paramThrowable, null, 2, null);
    }
  }
  
  static final class t<T>
    implements g<CameraComponent>
  {
    t(CloudTerracePresetViewModel paramCloudTerracePresetViewModel) {}
    
    public final void a(CameraComponent paramCameraComponent)
    {
      if (paramCameraComponent.hasComponent(ComponentType.PTZ))
      {
        paramCameraComponent = this.c;
        TPCameraDeviceContext localTPCameraDeviceContext = CloudTerracePresetViewModel.g(paramCameraComponent);
        kotlin.jvm.internal.j.c(localTPCameraDeviceContext);
        CloudTerracePresetViewModel.r(paramCameraComponent, localTPCameraDeviceContext);
      }
    }
  }
  
  static final class u<T>
    implements g<Throwable>
  {
    public static final u c = new u();
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.e(CloudTerracePresetViewModel.o(), Log.getStackTraceString(paramThrowable));
    }
  }
  
  static final class v<T>
    implements Observer<ArrayList<MarkedPositionInfo>>
  {
    v(CloudTerracePresetViewModel paramCloudTerracePresetViewModel) {}
    
    public final void a(ArrayList<MarkedPositionInfo> paramArrayList)
    {
      CloudTerracePresetViewModel.j(this.a).clear();
      CloudTerracePresetViewModel.l(this.a).clear();
      CloudTerracePresetViewModel.m(this.a).clear();
      if (paramArrayList == null) {
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      boolean bool2;
      for (;;)
      {
        boolean bool1 = localIterator.hasNext();
        bool2 = false;
        if (!bool1) {
          break;
        }
        localObject = (MarkedPositionInfo)localIterator.next();
        CloudTerracePresetViewModel.j(this.a).add(0, Integer.valueOf(((MarkedPositionInfo)localObject).getId()));
        CloudTerracePresetViewModel.l(this.a).add(0, ((MarkedPositionInfo)localObject).getFileOrBitmap());
        CloudTerracePresetViewModel.m(this.a).add(0, ((MarkedPositionInfo)localObject).getName());
      }
      Object localObject = this.a.H();
      if (localObject != null) {
        ((DataBindingListAdapter)localObject).s();
      }
      if (paramArrayList.size() == 0) {
        bool2 = true;
      }
      if (!com.tplink.libtpnetwork.Utils.j.b(this.a.I(), Boolean.valueOf(bool2))) {
        this.a.I().postValue(Boolean.valueOf(bool2));
      }
    }
  }
  
  static final class w<T>
    implements Observer<Boolean>
  {
    w(CloudTerracePresetViewModel paramCloudTerracePresetViewModel) {}
    
    public final void a(Boolean paramBoolean)
    {
      if ((com.tplink.libtpnetwork.Utils.j.h(this.a.X())) && (kotlin.jvm.internal.j.a(paramBoolean, Boolean.TRUE))) {
        this.a.X().postValue(Boolean.FALSE);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\CloudTerracePresetViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */