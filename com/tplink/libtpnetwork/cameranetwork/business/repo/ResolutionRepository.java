package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import io.reactivex.q;

public class ResolutionRepository
  extends c
{
  public ResolutionRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  public q<Boolean> t(ResolutionType paramResolutionType)
  {
    return l().U2(paramResolutionType).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(m6.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\ResolutionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */