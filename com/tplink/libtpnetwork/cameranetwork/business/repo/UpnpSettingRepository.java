package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import io.reactivex.g0.g;
import io.reactivex.q;

public class UpnpSettingRepository
  extends CameraSettingRepository
{
  private MutableLiveData<Boolean> h = new MutableLiveData();
  CommonCameraRepository i;
  
  public UpnpSettingRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    if (paramTPCameraDeviceContext != null) {
      this.i = ((CommonCameraRepository)e.c(paramTPCameraDeviceContext.getDeviceIdMD5(), CommonCameraRepository.class));
    }
  }
  
  public MutableLiveData<Boolean> M1()
  {
    return this.h;
  }
  
  public q<Boolean> T1()
  {
    return this.c.w0().i(m.a()).L0(io.reactivex.l0.a.c()).g0(v6.c).E(new t6(this)).C(f7.c);
  }
  
  public q<Boolean> U1(final boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = "on";
    } else {
      localObject = "off";
    }
    Object localObject = new UpnpInfo((String)localObject, "auto");
    return this.c.a3((UpnpInfo)localObject).C(f7.c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new a(paramBoolean)).C(new u6(this, paramBoolean)).g0(w6.c);
  }
  
  class a
    implements g<Boolean>
  {
    a(boolean paramBoolean) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      UpnpSettingRepository.L1(UpnpSettingRepository.this).postValue(Boolean.valueOf(paramBoolean));
      paramBoolean = UpnpSettingRepository.this.i;
      if (paramBoolean != null) {
        paramBoolean.g().F0();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\UpnpSettingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */