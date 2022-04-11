package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.k;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordPlanRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.HardDiskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.concurrent.TimeUnit;

public class m9
{
  private boolean a = false;
  private k b;
  private String c;
  private g<String> d = d.n1();
  private CameraSettingRepository e;
  private int f;
  private boolean g = false;
  c h = null;
  private MutableLiveData<String> i = new MutableLiveData();
  
  public m9(String paramString)
  {
    this.c = paramString;
    this.b = k.a();
  }
  
  @SuppressLint({"CheckResult"})
  private void W()
  {
    b.d.w.c.a.e("SDCardManager", "updateFormatSdCardStatusOnlyOnce----");
    m().G().L0(io.reactivex.l0.a.c()).G0(new f8(this));
  }
  
  private String g()
  {
    BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1(this.c);
    String str1 = null;
    String str2;
    if (localBaseALIoTDevice != null) {
      str2 = localBaseALIoTDevice.getDeviceName();
    } else {
      str2 = null;
    }
    if (localBaseALIoTDevice != null) {
      str1 = localBaseALIoTDevice.getDeviceModel();
    }
    return l.e(AppContext.c, EnumDeviceType.CAMERA.toString(), str2, str1);
  }
  
  @SuppressLint({"CheckResult"})
  private void h(CameraSettingRepository paramCameraSettingRepository, int paramInt)
  {
    d();
    this.g = false;
    if (paramInt > 0) {
      this.i.postValue(l(paramInt));
    }
    this.h = paramCameraSettingRepository.G().L0(io.reactivex.l0.a.c()).o(2L, TimeUnit.SECONDS).s0(new y7(this)).H0(new r7(this, paramInt), new a8(this));
  }
  
  private q<RecordPlanRepository> j()
  {
    return q.f0(e.c(this.c, RecordPlanRepository.class));
  }
  
  private String l(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g());
    localStringBuilder.append(": ");
    localStringBuilder.append(AppContext.c.getString(2131953363));
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%)");
    return localStringBuilder.toString();
  }
  
  private CameraSettingRepository m()
  {
    return (CameraSettingRepository)e.c(this.c, CameraSettingRepository.class);
  }
  
  private q<CameraSettingRepository> n()
  {
    return q.f0(e.c(this.c, CameraSettingRepository.class));
  }
  
  @SuppressLint({"CheckResult"})
  private q<Boolean> o(String paramString, boolean paramBoolean)
  {
    return q.f0(paramString).L(e8.c).L(new d8(this, paramBoolean)).N(new t7(this)).E(new q7(this));
  }
  
  public static boolean p(String paramString)
  {
    return "formatting".equals(paramString);
  }
  
  public static boolean q(String paramString)
  {
    return "normal".equals(paramString);
  }
  
  public static boolean r(String paramString)
  {
    return "unformatted".equals(paramString);
  }
  
  public void U()
  {
    k localk = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("edit");
    localk.h(localStringBuilder.toString(), true);
  }
  
  public void V()
  {
    this.a = false;
    this.b.g(this.c);
    k localk = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("edit");
    localk.g(localStringBuilder.toString());
    localk = this.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("edit_cid_illegal");
    localk.g(localStringBuilder.toString());
    localk = this.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("edit_dilatant_suspect");
    localk.g(localStringBuilder.toString());
  }
  
  @SuppressLint({"CheckResult"})
  public void c()
  {
    if (this.a)
    {
      W();
      return;
    }
    this.a = true;
    n().N(z7.c).E(new b8(this)).L(new w7(this)).g0(new b()).N(new a()).H0(x7.c, c8.c);
  }
  
  public void d()
  {
    this.i.postValue("");
    c localc = this.h;
    if (localc != null)
    {
      localc.dispose();
      this.h = null;
    }
  }
  
  @SuppressLint({"CheckResult"})
  public void e()
  {
    b.d.w.c.a.e("SDCardManager", "format click");
    n().G0(new s7(this));
  }
  
  public q<Boolean> f()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return q.f0(Boolean.FALSE);
    }
    CommonCameraRepository localCommonCameraRepository = (CommonCameraRepository)e.c((String)localObject, CommonCameraRepository.class);
    localObject = (CameraSettingRepository)e.c(this.c, CameraSettingRepository.class);
    this.e = ((CameraSettingRepository)localObject);
    if (((CameraSettingRepository)localObject).R()) {
      return q.f0(Boolean.TRUE);
    }
    return localCommonCameraRepository.K0().N(new c());
  }
  
  public g<String> i()
  {
    return this.d;
  }
  
  public MutableLiveData<String> k()
  {
    return this.i;
  }
  
  class a
    implements j<String, t<?>>
  {
    a() {}
    
    public t<Boolean> a(String paramString)
      throws Exception
    {
      return m9.a(m9.this, paramString, false);
    }
  }
  
  class b
    implements j<HardDiskInfo, String>
  {
    b() {}
    
    public String a(HardDiskInfo paramHardDiskInfo)
      throws Exception
    {
      return paramHardDiskInfo.getStatus();
    }
  }
  
  class c
    implements j<CameraComponent, t<Boolean>>
  {
    c() {}
    
    public t<Boolean> a(@NonNull CameraComponent paramCameraComponent)
      throws Exception
    {
      return m9.b(m9.this).L(paramCameraComponent).g0(new a());
    }
    
    class a
      implements j<SettingCompositeV2, Boolean>
    {
      a() {}
      
      public Boolean a(@NonNull SettingCompositeV2 paramSettingCompositeV2)
        throws Exception
      {
        return Boolean.valueOf(m9.b(m9.this).R());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\m9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */