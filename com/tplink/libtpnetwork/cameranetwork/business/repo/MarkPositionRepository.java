package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerracePoint;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkPositionConfirmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionListInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.p;

public final class MarkPositionRepository
  extends c
{
  private final MutableLiveData<ArrayList<MarkedPositionInfo>> d;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<CameraException>> e;
  private final TPCameraDeviceContext f;
  
  public MarkPositionRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    this.f = paramTPCameraDeviceContext;
    this.d = new MutableLiveData();
    this.e = new MutableLiveData();
  }
  
  private final void w(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CameraException)) {
      this.e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramThrowable));
    }
  }
  
  public final q<ArrayList<MarkedPositionInfo>> t(l<? super MarkedPositionListInfo, ? extends ArrayList<MarkedPositionInfo>> paraml)
  {
    kotlin.jvm.internal.j.e(paraml, "parseData");
    f4 localf4 = this.c;
    kotlin.jvm.internal.j.d(localf4, "cameraClient");
    paraml = localf4.D().i(m.a()).L0(io.reactivex.l0.a.c()).g0(new k7(paraml)).E(new a(this)).C(new j7(new b(this)));
    kotlin.jvm.internal.j.d(paraml, "cameraClient.cloudTerrac…nError(this::handleError)");
    return paraml;
  }
  
  public final MutableLiveData<ArrayList<MarkedPositionInfo>> u()
  {
    return this.d;
  }
  
  public final q<Boolean> v(int paramInt)
  {
    q localq = this.c.B0(paramInt).i(m.g()).L0(io.reactivex.l0.a.c()).C(new j7(new c(this))).g0(d.c);
    kotlin.jvm.internal.j.d(localq, "cameraClient.gotoCloudTe…            .map { true }");
    return localq;
  }
  
  public final q<MarkPositionConfirmInfo> x(CloudTerracePoint paramCloudTerracePoint)
  {
    kotlin.jvm.internal.j.e(paramCloudTerracePoint, "info");
    paramCloudTerracePoint = this.c.b(paramCloudTerracePoint).i(m.a()).L0(io.reactivex.l0.a.c()).C(new j7(new e(this)));
    kotlin.jvm.internal.j.d(paramCloudTerracePoint, "cameraClient.addCloudTer…nError(this::handleError)");
    return paramCloudTerracePoint;
  }
  
  public final q<Boolean> y(CloudTerraceResetInfo paramCloudTerraceResetInfo)
  {
    kotlin.jvm.internal.j.e(paramCloudTerraceResetInfo, "info");
    paramCloudTerraceResetInfo = this.c.g2(paramCloudTerraceResetInfo).i(m.g()).L0(io.reactivex.l0.a.c()).C(new j7(new f(this))).g0(g.c);
    kotlin.jvm.internal.j.d(paramCloudTerraceResetInfo, "cameraClient.removeTerra…            .map { true }");
    return paramCloudTerraceResetInfo;
  }
  
  static final class a<T>
    implements g<ArrayList<MarkedPositionInfo>>
  {
    a(MarkPositionRepository paramMarkPositionRepository) {}
    
    public final void a(ArrayList<MarkedPositionInfo> paramArrayList)
    {
      this.c.u().postValue(paramArrayList);
    }
  }
  
  static final class d<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final d c = new d();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final g c = new g();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\MarkPositionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */