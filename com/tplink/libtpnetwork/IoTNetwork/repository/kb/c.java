package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.a;
import io.reactivex.q;

public abstract class c<T extends TPBaseDeviceContext>
{
  protected T a;
  protected TPIoTClientManager b;
  
  public c(T paramT)
  {
    this.a = paramT;
    this.b = ((TPIoTClientManager)b.a(paramT.getAccountContext(), TPIoTClientManager.class));
  }
  
  public T b()
  {
    return this.a;
  }
  
  protected abstract void c();
  
  public abstract q<Boolean> d();
  
  protected abstract void e();
  
  public abstract q<Boolean> f();
  
  public abstract q<Boolean> g();
  
  public abstract q<Boolean> h();
  
  public abstract a i(boolean paramBoolean);
  
  public abstract q<Boolean> j();
  
  public abstract a k();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\kb\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */