package com.tplink.iot.view.home.f0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.home.f0.c.b;
import com.tplink.iot.view.home.f0.c.c;
import com.tplink.iot.view.home.f0.c.e;
import com.tplink.iot.view.home.f0.c.f;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import java.util.List;

public class a
  extends com.tplink.iot.view.home.f0.b.a
{
  private static volatile a f;
  private MutableLiveData<Boolean> g = new MutableLiveData();
  private MutableLiveData<Boolean> h = new MutableLiveData();
  private MutableLiveData<Boolean> i = new MutableLiveData();
  private MutableLiveData<Integer> j = new MutableLiveData();
  private MediatorLiveData<com.tplink.iot.model.home.d> k = new MediatorLiveData();
  private MediatorLiveData<List<TDPIoTDevice>> l = new MediatorLiveData();
  
  public static a h()
  {
    if (f == null) {
      try
      {
        if (f == null)
        {
          a locala = new com/tplink/iot/view/home/f0/a;
          locala.<init>();
          f = locala;
        }
      }
      finally {}
    }
    return f;
  }
  
  public LiveData<Boolean> g()
  {
    return this.h;
  }
  
  public MediatorLiveData<com.tplink.iot.model.home.d> i()
  {
    this.k.setValue(null);
    return this.k;
  }
  
  public MutableLiveData<Boolean> j()
  {
    return this.i;
  }
  
  public MediatorLiveData<List<TDPIoTDevice>> k()
  {
    return this.l;
  }
  
  public LiveData<Boolean> l()
  {
    return this.g;
  }
  
  public MutableLiveData<Integer> m()
  {
    return this.j;
  }
  
  public void n(com.tplink.iot.model.home.d paramd)
  {
    e(new com.tplink.iot.view.home.f0.c.d(this.k, paramd));
  }
  
  public void o()
  {
    e(new com.tplink.iot.view.home.f0.c.a(this.h));
  }
  
  public void p()
  {
    e(new c(this.i));
  }
  
  public void q(List<TDPIoTDevice> paramList)
  {
    e(new b(this.l, paramList));
  }
  
  public void r()
  {
    e(new e(this.g));
  }
  
  public void s(int paramInt)
  {
    e(new f(this.j, paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\f0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */