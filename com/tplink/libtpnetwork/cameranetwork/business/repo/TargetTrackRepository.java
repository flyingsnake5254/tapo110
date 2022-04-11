package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import io.reactivex.q;

public class TargetTrackRepository
  extends c
{
  public final MutableLiveData<Boolean> d = new MutableLiveData();
  
  public TargetTrackRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  public q<Boolean> B(boolean paramBoolean)
  {
    return l().X2(paramBoolean).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(q6.c).E(new o6(this, paramBoolean)).g0(n6.c);
  }
  
  public void C(TargetTrackInfo paramTargetTrackInfo)
  {
    if (paramTargetTrackInfo != null) {
      this.d.postValue(Boolean.valueOf(OptionSwitch.isOn(paramTargetTrackInfo.getEnabled())));
    }
  }
  
  public q<Boolean> s()
  {
    return l().s0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(p6.c).E(new r6(this)).g0(s6.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\TargetTrackRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */