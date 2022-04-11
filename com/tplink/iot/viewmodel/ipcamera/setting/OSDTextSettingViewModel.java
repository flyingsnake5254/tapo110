package com.tplink.iot.viewmodel.ipcamera.setting;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.OsdInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class OSDTextSettingViewModel
  extends ViewModel
{
  private CameraSettingRepository a;
  private CommonCameraRepository b;
  private String c;
  private OsdInfoCache d;
  private b e = new b();
  private final MutableLiveData<String> f = new MutableLiveData();
  private final MutableLiveData<Boolean> g = new MutableLiveData();
  private final MutableLiveData<Boolean> h = new MutableLiveData();
  private final MutableLiveData<Boolean> i = new MutableLiveData();
  private ObservableBoolean j = new ObservableBoolean(false);
  
  public final boolean g(String paramString)
  {
    j.e(paramString, "text");
    int k = paramString.length();
    int n;
    for (int m = 0; m < k; m = n)
    {
      n = m + 1;
      String str = paramString.substring(m, n);
      j.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (!m.D("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ- ", str, false, 2, null)) {
        return false;
      }
    }
    return true;
  }
  
  public final MutableLiveData<Boolean> h()
  {
    return this.h;
  }
  
  public final MutableLiveData<Boolean> i()
  {
    return this.g;
  }
  
  public final MutableLiveData<Boolean> j()
  {
    return this.i;
  }
  
  public final MutableLiveData<String> k()
  {
    return this.f;
  }
  
  public final void l(String paramString)
  {
    this.c = paramString;
    if (paramString != null)
    {
      Object localObject = (CameraSettingRepository)e.c(paramString, CameraSettingRepository.class);
      this.a = ((CameraSettingRepository)localObject);
      String str = null;
      if (localObject != null)
      {
        localObject = ((CameraSettingRepository)localObject).x();
        if (localObject != null)
        {
          localObject = ((SettingsData)localObject).getOsdConfig();
          break label49;
        }
      }
      localObject = null;
      label49:
      this.d = ((OsdInfoCache)localObject);
      MutableLiveData localMutableLiveData = this.f;
      if (localObject != null) {
        str = ((OsdInfoCache)localObject).getName();
      }
      localMutableLiveData.postValue(str);
      paramString = (CommonCameraRepository)e.c(paramString, CommonCameraRepository.class);
      this.b = paramString;
      if (paramString != null) {
        new a(paramString, this);
      }
    }
  }
  
  public final void m(final String paramString)
  {
    j.e(paramString, "text");
    OsdInfoCache localOsdInfoCache = this.d;
    if (localOsdInfoCache != null)
    {
      CameraSettingRepository localCameraSettingRepository = this.a;
      if (localCameraSettingRepository != null)
      {
        this.i.postValue(Boolean.TRUE);
        b localb = this.e;
        OptionSwitch localOptionSwitch1 = localOsdInfoCache.getEnable();
        OptionSwitch localOptionSwitch2 = OptionSwitch.ON;
        boolean bool1 = true;
        boolean bool2;
        if (localOptionSwitch1 == localOptionSwitch2) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (localOsdInfoCache.getTextEnable() != localOptionSwitch2) {
          bool1 = false;
        }
        localb.b(localCameraSettingRepository.D1(bool2, bool1, paramString, this.j.get()).H0(new b(localOsdInfoCache, this, paramString), new c(localOsdInfoCache, this, paramString)));
      }
    }
  }
  
  static final class a
    extends Lambda
    implements a<c>
  {
    a(CommonCameraRepository paramCommonCameraRepository, OSDTextSettingViewModel paramOSDTextSettingViewModel)
    {
      super();
    }
    
    public final c a()
    {
      return this.c.K0().H0(new a(this), k9.c);
    }
    
    static final class a<T>
      implements g<CameraComponent>
    {
      a(OSDTextSettingViewModel.a parama) {}
      
      public final void a(CameraComponent paramCameraComponent)
      {
        OSDTextSettingViewModel.f(this.c.d).set(paramCameraComponent.isSupportOsdLogo());
      }
    }
  }
  
  static final class b<T>
    implements g<Boolean>
  {
    b(OsdInfoCache paramOsdInfoCache, OSDTextSettingViewModel paramOSDTextSettingViewModel, String paramString) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.setName(paramString);
      jdField_this.j().postValue(Boolean.FALSE);
      jdField_this.i().postValue(Boolean.TRUE);
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(OsdInfoCache paramOsdInfoCache, OSDTextSettingViewModel paramOSDTextSettingViewModel, String paramString) {}
    
    public final void a(Throwable paramThrowable)
    {
      jdField_this.j().postValue(Boolean.FALSE);
      jdField_this.h().postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\OSDTextSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */