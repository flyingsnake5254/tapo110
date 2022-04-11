package com.tplink.libtpnetwork.IoTNetwork.util;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.g0.g;
import kotlin.jvm.internal.j;

public final class a
{
  public static final a a = new a(null);
  private int b;
  private final MutableLiveData<Integer> c;
  private final LiveData<Integer> d;
  
  public a()
  {
    MutableLiveData localMutableLiveData = new MutableLiveData();
    this.c = localMutableLiveData;
    this.d = localMutableLiveData;
  }
  
  private final boolean f(Throwable paramThrowable)
  {
    return (!(paramThrowable instanceof IoTTransportException)) || (((IoTTransportException)paramThrowable).getErrCode() != 1001);
  }
  
  private final void g()
  {
    this.c.postValue(Integer.valueOf(this.b));
  }
  
  public final f b()
  {
    return new b(this);
  }
  
  public final LiveData<Integer> c()
  {
    return this.d;
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final void e()
  {
    this.b += 1;
    g();
  }
  
  public final void h()
  {
    this.b = 0;
    g();
  }
  
  public static final class a {}
  
  static final class b
    implements f
  {
    b(a parama) {}
    
    public final e a(io.reactivex.a parama)
    {
      j.e(parama, "it");
      return parama.i(new a(this)).j(new b(this));
    }
    
    static final class a
      implements io.reactivex.g0.a
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        this.a.a.h();
      }
    }
    
    static final class b<T>
      implements g<Throwable>
    {
      b(a.b paramb) {}
      
      public final void a(Throwable paramThrowable)
      {
        a locala = this.c.a;
        j.d(paramThrowable, "throwable");
        if (a.a(locala, paramThrowable)) {
          this.c.a.e();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */