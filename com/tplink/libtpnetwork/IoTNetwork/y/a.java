package com.tplink.libtpnetwork.IoTNetwork.y;

import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.q;

public abstract class a
{
  protected boolean a;
  
  public boolean d()
  {
    return this.a;
  }
  
  public void e() {}
  
  public abstract <T> q<TPIoTResponse> f(TPIoTRequest<T> paramTPIoTRequest)
    throws IoTTransportException;
  
  public void g(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\y\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */