package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionSetting;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.l0.a;
import io.reactivex.q;

public final class DetectionSettingRepository
  extends CameraSettingRepository
{
  public DetectionSettingRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  public final q<DetectionSetting> L1(CameraComponent paramCameraComponent)
  {
    kotlin.jvm.internal.j.e(paramCameraComponent, "component");
    paramCameraComponent = l().J(paramCameraComponent).L0(a.c()).g0(a.c);
    kotlin.jvm.internal.j.d(paramCameraComponent, "getCameraClient().getDet…       .map { it.result }");
    return paramCameraComponent;
  }
  
  static final class a<T, R>
    implements io.reactivex.g0.j<Response<DetectionSetting>, DetectionSetting>
  {
    public static final a c = new a();
    
    public final DetectionSetting a(Response<DetectionSetting> paramResponse)
    {
      kotlin.jvm.internal.j.e(paramResponse, "it");
      return (DetectionSetting)paramResponse.getResult();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\DetectionSettingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */