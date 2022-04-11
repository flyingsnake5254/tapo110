package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import io.reactivex.q;

public class RecordAudioRepository
  extends CameraSettingRepository
{
  private MutableLiveData<Boolean> h = new MutableLiveData();
  
  public RecordAudioRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  public MutableLiveData<Boolean> L1()
  {
    return this.h;
  }
  
  public q<Boolean> U1()
  {
    return this.c.i0().i(m.a()).L0(io.reactivex.l0.a.c()).g0(c6.c).E(new b6(this)).C(f7.c);
  }
  
  public q<Boolean> V1(boolean paramBoolean)
  {
    return this.c.S2(paramBoolean).C(f7.c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new d6(this, paramBoolean)).C(new a6(this, paramBoolean)).g0(e6.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\RecordAudioRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */