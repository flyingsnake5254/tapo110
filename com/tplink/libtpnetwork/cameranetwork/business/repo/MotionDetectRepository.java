package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;

@Deprecated
public class MotionDetectRepository
  extends c
{
  private ALCameraDevice d;
  private TCMessagePushRepository e;
  
  public MotionDetectRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    this.d = ((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice());
    this.e = ((TCMessagePushRepository)b.d.b.f.b.c(paramTPCameraDeviceContext.getAccountContext()).a(TCMessagePushRepository.class));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\MotionDetectRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */