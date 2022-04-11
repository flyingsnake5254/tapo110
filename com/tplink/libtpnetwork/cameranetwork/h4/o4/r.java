package com.tplink.libtpnetwork.cameranetwork.h4.o4;

import com.tplink.libtpnetwork.cameranetwork.model.LoginResult;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.q;
import okhttp3.ResponseBody;
import retrofit2.x.a;
import retrofit2.x.o;
import retrofit2.x.s;

public abstract interface r
{
  @o("/stok={token}/ds")
  public abstract q<Response<MultipleResponse>> a(@s("token") String paramString, @a Request paramRequest);
  
  @o("/")
  public abstract q<Response<LoginResult>> b(@a Request paramRequest);
  
  @o("/stok={token}/admin/system/diagnose_logs")
  public abstract q<ResponseBody> c(@s("token") String paramString);
  
  @o("/")
  public abstract q<Response<Wrappers>> d(@a Request paramRequest);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\o4\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */