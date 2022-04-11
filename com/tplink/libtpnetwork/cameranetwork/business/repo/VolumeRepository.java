package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SpeakerInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.q;
import java.util.Objects;

public class VolumeRepository
  extends c
{
  private final MutableLiveData<AudioInfo> d = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<CameraException>> e = new MutableLiveData();
  private AudioInfo f;
  
  public VolumeRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private void y(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CameraException)) {
      this.e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a((CameraException)paramThrowable));
    }
  }
  
  private void z(AudioInfo paramAudioInfo)
  {
    this.f = paramAudioInfo;
    this.d.postValue(paramAudioInfo);
  }
  
  public boolean A(int paramInt)
  {
    MicroPhoneInfo localMicroPhoneInfo = this.f.getMicroPhoneInfo();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localMicroPhoneInfo != null)
    {
      bool2 = bool1;
      if (paramInt != Integer.parseInt(localMicroPhoneInfo.getVolume())) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean B(int paramInt)
  {
    SpeakerInfo localSpeakerInfo = this.f.getSpeakerInfo();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localSpeakerInfo != null)
    {
      bool2 = bool1;
      if (paramInt != Integer.parseInt(this.f.getSpeakerInfo().getVolume())) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public q<Boolean> J()
  {
    return l().z().i(m.a()).L0(io.reactivex.l0.a.c()).E(new a7(this)).g0(z6.c).C(new x6(this));
  }
  
  public q<Boolean> K(int paramInt)
  {
    MicroPhoneInfo localMicroPhoneInfo = this.f.getMicroPhoneInfo();
    if (localMicroPhoneInfo == null) {
      return q.f0(Boolean.FALSE);
    }
    localMicroPhoneInfo = localMicroPhoneInfo.copy(Integer.toString(paramInt), localMicroPhoneInfo.component2(), localMicroPhoneInfo.component3(), localMicroPhoneInfo.component4(), localMicroPhoneInfo.component5());
    return l().K2(localMicroPhoneInfo).L0(io.reactivex.l0.a.c()).E(new b7(this, localMicroPhoneInfo)).g0(a.c);
  }
  
  public q<Boolean> L(int paramInt)
  {
    SpeakerInfo localSpeakerInfo = new SpeakerInfo(Integer.toString(paramInt));
    return l().V2(localSpeakerInfo).L0(io.reactivex.l0.a.c()).E(new y6(this, localSpeakerInfo)).g0(a.c);
  }
  
  public AudioInfo s()
  {
    return this.f;
  }
  
  public LiveData<AudioInfo> t()
  {
    return this.d;
  }
  
  public int u()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((AudioInfo)localObject).getMicroPhoneInfo();
      Objects.requireNonNull(localObject);
      return Integer.parseInt(((MicroPhoneInfo)localObject).getVolume());
    }
    return 0;
  }
  
  public int v()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((AudioInfo)localObject).getSpeakerInfo();
      Objects.requireNonNull(localObject);
      return Integer.parseInt(((SpeakerInfo)localObject).getVolume());
    }
    return 0;
  }
  
  public int w()
  {
    if (this.f.getMicroPhoneInfo() != null) {}
    try
    {
      int i = Integer.parseInt(this.f.getMicroPhoneInfo().getVolume());
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    return -1;
  }
  
  public int x()
  {
    if (this.f.getSpeakerInfo() != null) {}
    try
    {
      int i = Integer.parseInt(this.f.getSpeakerInfo().getVolume());
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\VolumeRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */