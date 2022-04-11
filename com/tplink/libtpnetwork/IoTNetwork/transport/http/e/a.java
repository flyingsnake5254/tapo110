package com.tplink.libtpnetwork.IoTNetwork.transport.http.e;

import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.handshake.HandShakeResponse;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure.SecurePassThroughRequest;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure.SecurePassThroughResponse;
import io.reactivex.q;
import retrofit2.x.o;
import retrofit2.x.t;

public abstract interface a
{
  @o("app")
  public abstract q<HandShakeResponse> a(@retrofit2.x.a TPIoTRequest paramTPIoTRequest);
  
  @o("app")
  public abstract q<SecurePassThroughResponse> b(@t("token") String paramString, @retrofit2.x.a SecurePassThroughRequest paramSecurePassThroughRequest);
  
  @o("app")
  public abstract q<SecurePassThroughResponse> c(@retrofit2.x.a SecurePassThroughRequest paramSecurePassThroughRequest);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */