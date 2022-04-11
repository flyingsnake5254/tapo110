package com.tplink.iot.viewmodel.ipcamera.setting.video;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.ResolutionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.m;

public final class VideoQualityViewModel
  extends AndroidViewModel
{
  private final String a;
  private final MutableLiveData<Boolean> b;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> c;
  private final MutableLiveData<Drawable> d;
  private final MutableLiveData<Boolean> e;
  private final MutableLiveData<List<ResolutionType>> f;
  private final MutableLiveData<ResolutionType> g;
  private final String h;
  private final ResolutionRepository i;
  private final CameraSettingRepository j;
  private final b k;
  private final List<ResolutionType> l;
  private final ResolutionType m;
  private final TPCameraDeviceContext n;
  
  public VideoQualityViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.n = paramTPCameraDeviceContext;
    paramApplication = VideoQualityViewModel.class.getSimpleName();
    j.d(paramApplication, "VideoQualityViewModel::class.java.simpleName");
    this.a = paramApplication;
    this.b = new MutableLiveData();
    this.c = new MutableLiveData();
    this.d = new MutableLiveData();
    this.e = new MutableLiveData();
    MutableLiveData localMutableLiveData1 = new MutableLiveData();
    this.f = localMutableLiveData1;
    MutableLiveData localMutableLiveData2 = new MutableLiveData();
    this.g = localMutableLiveData2;
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.h = paramApplication;
    this.i = ((ResolutionRepository)e.c(paramApplication, ResolutionRepository.class));
    Object localObject = (CameraSettingRepository)e.c(paramApplication, CameraSettingRepository.class);
    this.j = ((CameraSettingRepository)localObject);
    this.k = new b();
    j.d(localObject, "mCameraSettingRepository");
    paramApplication = ((CameraSettingRepository)localObject).x();
    paramTPCameraDeviceContext = null;
    if (paramApplication != null)
    {
      paramApplication = paramApplication.getResolutionTypes();
      if (paramApplication != null)
      {
        l.o(paramApplication, a.c);
        p localp = p.a;
        break label207;
      }
    }
    paramApplication = null;
    label207:
    this.l = paramApplication;
    j.d(localObject, "mCameraSettingRepository");
    localObject = ((CameraSettingRepository)localObject).x();
    if (localObject != null) {
      paramTPCameraDeviceContext = ((SettingsData)localObject).getResolutionType();
    }
    this.m = paramTPCameraDeviceContext;
    if (paramApplication != null) {
      localMutableLiveData1.postValue(paramApplication);
    }
    if (paramTPCameraDeviceContext != null) {
      localMutableLiveData2.postValue(paramTPCameraDeviceContext);
    }
  }
  
  public final MutableLiveData<Boolean> g()
  {
    return this.e;
  }
  
  public final MutableLiveData<Drawable> h()
  {
    return this.d;
  }
  
  public final Drawable i(@DrawableRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getApplication();
      j.d(localObject, "getApplication<Application>()");
      Resources localResources = ((Application)localObject).getResources();
      localObject = getApplication();
      j.d(localObject, "getApplication<Application>()");
      localObject = localResources.getDrawable(paramInt, ((Application)localObject).getTheme());
      j.d(localObject, "getApplication<Applicati…ion<Application>().theme)");
      return (Drawable)localObject;
    }
    Object localObject = getApplication();
    j.d(localObject, "getApplication<Application>()");
    localObject = ((Application)localObject).getResources().getDrawable(paramInt);
    j.d(localObject, "getApplication<Applicati….getDrawable(drawableRes)");
    return (Drawable)localObject;
  }
  
  public final MutableLiveData<ResolutionType> j()
  {
    return this.g;
  }
  
  public final MutableLiveData<List<ResolutionType>> k()
  {
    return this.f;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> l()
  {
    return this.c;
  }
  
  public final String m()
  {
    return this.a;
  }
  
  public final MutableLiveData<Boolean> n()
  {
    return this.b;
  }
  
  public final void o(final ResolutionType paramResolutionType)
  {
    j.e(paramResolutionType, "targetResolutionType");
    Boolean localBoolean1 = (Boolean)this.e.getValue();
    Boolean localBoolean2 = Boolean.TRUE;
    if ((j.a(localBoolean1, localBoolean2) ^ true))
    {
      this.c.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localBoolean2));
      return;
    }
    paramResolutionType = this.i.t(paramResolutionType).F(new b(this, paramResolutionType)).y(new c(this, paramResolutionType)).H0(new d(this, paramResolutionType), new e(this, paramResolutionType));
    this.k.b(paramResolutionType);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.k.d();
  }
  
  public final void p(ResolutionType paramResolutionType)
  {
    j.e(paramResolutionType, "resolutionType");
    if (this.l != null)
    {
      int i1 = a.a[paramResolutionType.ordinal()];
      boolean bool = false;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 != 5)
              {
                MutableLiveData localMutableLiveData = this.d;
                if ((this.l.size() >= 1) && ((ResolutionType)this.l.get(0) == ResolutionType.HD_3M)) {
                  localObject = i(2131231659);
                } else {
                  localObject = i(2131231658);
                }
                localMutableLiveData.setValue(localObject);
              }
              else
              {
                this.d.setValue(i(2131690445));
              }
            }
            else {
              this.d.setValue(i(2131231661));
            }
          }
          else {
            this.d.setValue(i(2131231658));
          }
        }
        else {
          this.d.setValue(i(2131231659));
        }
      }
      else {
        this.d.setValue(i(2131231660));
      }
      Object localObject = this.e;
      if (paramResolutionType != this.m) {
        bool = true;
      }
      ((MutableLiveData)localObject).setValue(Boolean.valueOf(bool));
    }
  }
  
  static final class a<T>
    implements Comparator<ResolutionType>
  {
    public static final a c = new a();
    
    public final int a(ResolutionType paramResolutionType1, ResolutionType paramResolutionType2)
    {
      List localList = m.f0(paramResolutionType1.getValue(), new String[] { "*" }, false, 0, 6, null);
      int i = 0;
      if (Integer.parseInt((String)localList.get(0)) < Integer.parseInt((String)m.f0(paramResolutionType2.getValue(), new String[] { "*" }, false, 0, 6, null).get(0))) {
        i = 1;
      } else if (Integer.parseInt((String)m.f0(paramResolutionType1.getValue(), new String[] { "*" }, false, 0, 6, null).get(0)) > Integer.parseInt((String)m.f0(paramResolutionType2.getValue(), new String[] { "*" }, false, 0, 6, null).get(0))) {
        i = -1;
      }
      return i;
    }
  }
  
  static final class b<T>
    implements g<c>
  {
    b(VideoQualityViewModel paramVideoQualityViewModel, ResolutionType paramResolutionType) {}
    
    public final void a(c paramc)
    {
      this.c.n().postValue(Boolean.TRUE);
    }
  }
  
  static final class c
    implements io.reactivex.g0.a
  {
    c(VideoQualityViewModel paramVideoQualityViewModel, ResolutionType paramResolutionType) {}
    
    public final void run()
    {
      this.a.n().postValue(Boolean.FALSE);
    }
  }
  
  static final class d<T>
    implements g<Boolean>
  {
    d(VideoQualityViewModel paramVideoQualityViewModel, ResolutionType paramResolutionType) {}
    
    public final void a(Boolean paramBoolean)
    {
      paramBoolean = VideoQualityViewModel.f(this.c);
      j.d(paramBoolean, "mCameraSettingRepository");
      paramBoolean = paramBoolean.x();
      j.d(paramBoolean, "mCameraSettingRepository.cache");
      paramBoolean.setResolutionType(paramResolutionType);
      this.c.l().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(VideoQualityViewModel paramVideoQualityViewModel, ResolutionType paramResolutionType) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.l().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
      b.d.w.c.a.e(this.c.m(), Log.getStackTraceString(paramThrowable));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\video\VideoQualityViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */