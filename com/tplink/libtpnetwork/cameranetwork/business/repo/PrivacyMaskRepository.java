package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.model.e;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfig;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigRegion;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrivacyMaskRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  public final MutableLiveData<e> d = new MutableLiveData();
  
  public PrivacyMaskRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private void E(boolean paramBoolean)
  {
    if ((b() != null) && (((TPCameraDeviceContext)b()).getDeviceIdMD5() != null) && (!u.f(((TPCameraDeviceContext)b()).getDeviceIdMD5())) && (paramBoolean)) {
      u.n(((TPCameraDeviceContext)b()).getDeviceIdMD5(), true);
    }
  }
  
  public static e F(CoverConfigInfo paramCoverConfigInfo)
  {
    Object localObject1 = paramCoverConfigInfo.getConfig();
    Object localObject2 = paramCoverConfigInfo.getRegions();
    paramCoverConfigInfo = new e();
    if (localObject1 != null) {
      paramCoverConfigInfo.c("on".equals(((CoverConfig)localObject1).getEnabled()));
    }
    if (localObject2 != null)
    {
      localObject1 = new ArrayList(((List)localObject2).size());
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (CoverConfigRegion)localIterator.next();
        d locald = new d();
        locald.g(j.e(((CoverConfigRegion)localObject2).getX(), 0));
        locald.h(j.e(((CoverConfigRegion)localObject2).getY(), 0));
        locald.f(j.e(((CoverConfigRegion)localObject2).getWidth(), 0));
        locald.e(j.e(((CoverConfigRegion)localObject2).getHeight(), 0));
        ((List)localObject1).add(locald);
      }
      paramCoverConfigInfo.d((List)localObject1);
    }
    return paramCoverConfigInfo;
  }
  
  private CoverConfigRegion s(d paramd)
  {
    return new CoverConfigRegion(paramd.c(), paramd.d(), paramd.b(), paramd.a());
  }
  
  public q<Boolean> G(boolean paramBoolean)
  {
    return l().r2(paramBoolean).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(z5.c).E(new y5(this, paramBoolean)).g0(x5.c);
  }
  
  public q<Boolean> H(List<d> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(s((d)localIterator.next()));
    }
    return l().c(localArrayList).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(s5.c).E(new w5(this, paramList)).g0(u5.c);
  }
  
  public q<Boolean> t()
  {
    q localq = l().G().i(m.a()).L0(io.reactivex.l0.a.c()).g0(d7.c).l0(io.reactivex.d0.b.a.a());
    MutableLiveData localMutableLiveData = this.d;
    localMutableLiveData.getClass();
    return localq.E(new k2(localMutableLiveData)).C(v5.c).g0(t5.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\PrivacyMaskRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */