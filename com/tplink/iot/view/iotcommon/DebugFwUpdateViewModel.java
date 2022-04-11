package com.tplink.iot.view.iotcommon;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.DeviceTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.a;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class DebugFwUpdateViewModel
  extends AndroidViewModel
{
  public static final List<String> a = l.g(new String[] { "uat", "uat2", "uat3", "dev", "dist" });
  public static final a b = new a(null);
  private final DebugFwUpdateRepository c;
  private c d;
  private final MutableLiveData<FwDownloadStatus> e;
  private final LiveData<FwDownloadStatus> f;
  private final LiveData<DeviceTimeInfo> g;
  private final boolean h;
  private final ObservableInt i;
  
  public DebugFwUpdateViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = e.a(paramThingContext, DebugFwUpdateRepository.class);
    j.d(paramApplication, "IoTDeviceRepositoryProvi…teRepository::class.java)");
    paramApplication = (DebugFwUpdateRepository)paramApplication;
    this.c = paramApplication;
    paramThingContext = new MutableLiveData();
    this.e = paramThingContext;
    this.f = paramThingContext;
    paramThingContext = paramApplication.r1();
    j.d(paramThingContext, "mDebugFwUpdateRepository.deviceTimeInfoLiveData");
    this.g = paramThingContext;
    this.h = paramApplication.D();
    this.i = new ObservableInt(0);
  }
  
  @SuppressLint({"CheckResult"})
  private final void o(final FwDownloadStatus paramFwDownloadStatus)
  {
    this.e.postValue(paramFwDownloadStatus);
    if (paramFwDownloadStatus.getErrorCode() == 5) {
      if (paramFwDownloadStatus.getInstallTime() > 0)
      {
        q.W0(paramFwDownloadStatus.getInstallTime(), TimeUnit.SECONDS).G0(new b(this, paramFwDownloadStatus));
      }
      else
      {
        paramFwDownloadStatus.setErrorCode(6);
        this.e.postValue(paramFwDownloadStatus);
      }
    }
  }
  
  public final String h()
  {
    return (String)a.get(this.i.get());
  }
  
  public final ObservableInt i()
  {
    return this.i;
  }
  
  public final void j()
  {
    this.c.q1().F0();
  }
  
  public final LiveData<DeviceTimeInfo> k()
  {
    return this.g;
  }
  
  public final LiveData<FwDownloadStatus> l()
  {
    return this.f;
  }
  
  public final ThingModel m()
  {
    return this.c.g5();
  }
  
  public final boolean n()
  {
    return this.h;
  }
  
  public final a p(String paramString)
  {
    j.e(paramString, "url");
    return this.c.h5(paramString);
  }
  
  public final a r(String paramString)
  {
    j.e(paramString, "serverType");
    return this.c.i5(paramString);
  }
  
  public final a s(String paramString1, String paramString2, String paramString3)
  {
    j.e(paramString1, "name");
    j.e(paramString2, "psd");
    j.e(paramString3, "keyType");
    return this.c.j5(paramString1, paramString2, paramString3);
  }
  
  public final void t(final boolean paramBoolean)
  {
    this.d = this.c.k5().E(new c(this)).C(new d(this, paramBoolean)).F0();
  }
  
  public final void u()
  {
    c localc = this.d;
    if ((localc != null) && (!localc.isDisposed()))
    {
      localc = this.d;
      if (localc != null) {
        localc.dispose();
      }
    }
  }
  
  public static final class a {}
  
  static final class b<T>
    implements g<Long>
  {
    b(DebugFwUpdateViewModel paramDebugFwUpdateViewModel, FwDownloadStatus paramFwDownloadStatus) {}
    
    public final void a(Long paramLong)
    {
      paramFwDownloadStatus.setErrorCode(6);
      DebugFwUpdateViewModel.f(this.c).postValue(paramFwDownloadStatus);
    }
  }
  
  static final class c<T>
    implements g<FwDownloadStatus>
  {
    c(DebugFwUpdateViewModel paramDebugFwUpdateViewModel) {}
    
    public final void a(FwDownloadStatus paramFwDownloadStatus)
    {
      DebugFwUpdateViewModel localDebugFwUpdateViewModel = this.c;
      j.d(paramFwDownloadStatus, "it");
      DebugFwUpdateViewModel.g(localDebugFwUpdateViewModel, paramFwDownloadStatus);
    }
  }
  
  static final class d<T>
    implements g<Throwable>
  {
    d(DebugFwUpdateViewModel paramDebugFwUpdateViewModel, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = DebugFwUpdateViewModel.f(this.c);
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 3;
      }
      paramThrowable.postValue(new FwDownloadStatus(i));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\DebugFwUpdateViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */