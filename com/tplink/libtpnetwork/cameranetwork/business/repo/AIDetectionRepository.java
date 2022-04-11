package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch.Companion;
import io.reactivex.g0.g;
import io.reactivex.q;

public final class AIDetectionRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  private final MutableLiveData<Boolean> d = new MutableLiveData();
  private final MutableLiveData<Boolean> e = new MutableLiveData();
  private final MutableLiveData<Integer> f = new MutableLiveData();
  
  public AIDetectionRepository(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private final String B(int paramInt)
  {
    String str1 = "low";
    String str2 = str1;
    if (paramInt != 0) {
      if (paramInt != 50)
      {
        if (paramInt != 100) {
          str2 = str1;
        } else {
          str2 = "high";
        }
      }
      else {
        str2 = "medium";
      }
    }
    return str2;
  }
  
  private final int C(String paramString)
  {
    int i = paramString.hashCode();
    int j = 0;
    if (i != -1078030475)
    {
      if (i != 107348)
      {
        if ((i == 3202466) && (paramString.equals("high"))) {
          j = 100;
        }
      }
      else {
        paramString.equals("low");
      }
    }
    else if (paramString.equals("medium")) {
      j = 50;
    }
    return j;
  }
  
  private final void w(boolean paramBoolean)
  {
    if (b() != null)
    {
      TPCameraDeviceContext localTPCameraDeviceContext = (TPCameraDeviceContext)b();
      kotlin.jvm.internal.j.d(localTPCameraDeviceContext, "ioTDeviceContext");
      if (localTPCameraDeviceContext.getDeviceIdMD5() != null)
      {
        localTPCameraDeviceContext = (TPCameraDeviceContext)b();
        kotlin.jvm.internal.j.d(localTPCameraDeviceContext, "ioTDeviceContext");
        if ((!u.a(localTPCameraDeviceContext.getDeviceIdMD5()).booleanValue()) && (paramBoolean))
        {
          localTPCameraDeviceContext = (TPCameraDeviceContext)b();
          kotlin.jvm.internal.j.d(localTPCameraDeviceContext, "ioTDeviceContext");
          u.h(localTPCameraDeviceContext.getDeviceIdMD5(), true);
        }
      }
    }
  }
  
  public final void A(HumanRecognitionInfo paramHumanRecognitionInfo)
  {
    kotlin.jvm.internal.j.e(paramHumanRecognitionInfo, "humanRecognitionInfo");
    this.d.postValue(Boolean.valueOf(OptionSwitch.Companion.isOn(paramHumanRecognitionInfo.getEnabled())));
  }
  
  public final MutableLiveData<Boolean> t()
  {
    return this.e;
  }
  
  public final MutableLiveData<Integer> u()
  {
    return this.f;
  }
  
  public final MutableLiveData<Boolean> v()
  {
    return this.d;
  }
  
  public final q<Boolean> x(final boolean paramBoolean, final int paramInt)
  {
    q localq = this.c.p2(paramBoolean, B(paramInt)).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new a(this, paramBoolean, paramInt)).C(new b(this)).g0(c.c);
    kotlin.jvm.internal.j.d(localq, "cameraClient.setBabyCryi…            .map { true }");
    return localq;
  }
  
  public final q<Boolean> y(final boolean paramBoolean)
  {
    q localq = this.c.x2(paramBoolean).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new d(this, paramBoolean)).C(new e(this)).g0(f.c);
    kotlin.jvm.internal.j.d(localq, "cameraClient.setHumanRec…            .map { true }");
    return localq;
  }
  
  public final void z(BabyCryingDetectionInfo paramBabyCryingDetectionInfo)
  {
    kotlin.jvm.internal.j.e(paramBabyCryingDetectionInfo, "babyCryingDetectionInfo");
    this.e.postValue(Boolean.valueOf(OptionSwitch.Companion.isOn(paramBabyCryingDetectionInfo.getEnabled())));
    this.f.postValue(Integer.valueOf(C(paramBabyCryingDetectionInfo.getSensitivity())));
  }
  
  static final class a<T>
    implements g<Boolean>
  {
    a(AIDetectionRepository paramAIDetectionRepository, boolean paramBoolean, int paramInt) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.t().setValue(Boolean.valueOf(paramBoolean));
      this.c.u().setValue(Integer.valueOf(paramInt));
      AIDetectionRepository.s(this.c, paramBoolean);
    }
  }
  
  static final class b<T>
    implements g<Throwable>
  {
    b(AIDetectionRepository paramAIDetectionRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.t().setValue(this.c.t().getValue());
      this.c.u().setValue(this.c.u().getValue());
    }
  }
  
  static final class c<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final c c = new c();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class d<T>
    implements g<Boolean>
  {
    d(AIDetectionRepository paramAIDetectionRepository, boolean paramBoolean) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.v().setValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(AIDetectionRepository paramAIDetectionRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.v().setValue(this.c.v().getValue());
    }
  }
  
  static final class f<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final f c = new f();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\AIDetectionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */