package com.tplink.iot.viewmodel.iotsensor;

import android.app.Application;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;
import kotlin.jvm.internal.j;

public final class SensorSetSensitivityViewModel
  extends AndroidViewModel
{
  private final ObservableInt a = new ObservableInt(1);
  private int b = 1;
  private final SingleLiveEvent<Boolean> c = new SingleLiveEvent();
  private final SingleLiveEvent<Integer> d = new SingleLiveEvent();
  private final SensorRepository e;
  private final MediatorLiveData<String> f;
  private final LiveData<String> g;
  
  public SensorSetSensitivityViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = e.a(paramThingContext, SensorRepository.class);
    j.d(paramApplication, "IoTDeviceRepositoryProvi…orRepository::class.java)");
    paramThingContext = (SensorRepository)paramApplication;
    this.e = paramThingContext;
    paramApplication = new MediatorLiveData();
    this.f = paramApplication;
    this.g = paramApplication;
    paramApplication.addSource(paramThingContext.n4(), new a(this));
  }
  
  public final SingleLiveEvent<Boolean> i()
  {
    return this.c;
  }
  
  public final LiveData<String> j()
  {
    return this.g;
  }
  
  public final ObservableInt k()
  {
    return this.a;
  }
  
  public final SingleLiveEvent<Integer> l()
  {
    return this.d;
  }
  
  public final void m()
  {
    if (this.a.get() != this.b) {
      this.c.setValue(Boolean.TRUE);
    }
  }
  
  public final void n(String paramString)
  {
    j.e(paramString, "sensitivity");
    ObservableInt localObservableInt = this.a;
    int i = paramString.hashCode();
    int j = 1;
    if (i != -1039745817)
    {
      if (i != 107348)
      {
        if ((i == 3202466) && (paramString.equals("high"))) {
          j = 2;
        }
      }
      else if (paramString.equals("low")) {
        j = 0;
      }
    }
    else {
      paramString.equals("normal");
    }
    localObservableInt.set(j);
    this.b = this.a.get();
  }
  
  public final void o()
  {
    int i = this.a.get();
    String str;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        str = "high";
      }
      else
      {
        str = "normal";
      }
    }
    else {
      str = "low";
    }
    this.e.q4(str).r(io.reactivex.d0.b.a.a()).i(new b(this)).j(new c(this)).y();
  }
  
  static final class a<T>
    implements Observer<String>
  {
    a(SensorSetSensitivityViewModel paramSensorSetSensitivityViewModel) {}
    
    public final void a(String paramString)
    {
      SensorSetSensitivityViewModel.g(this.a).postValue(paramString);
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(SensorSetSensitivityViewModel paramSensorSetSensitivityViewModel) {}
    
    public final void run()
    {
      this.a.l().setValue(Integer.valueOf(0));
      SensorSetSensitivityViewModel localSensorSetSensitivityViewModel = this.a;
      SensorSetSensitivityViewModel.h(localSensorSetSensitivityViewModel, localSensorSetSensitivityViewModel.k().get());
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(SensorSetSensitivityViewModel paramSensorSetSensitivityViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.k().set(SensorSetSensitivityViewModel.f(this.c));
      this.c.l().setValue(Integer.valueOf(-1));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotsensor\SensorSetSensitivityViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */