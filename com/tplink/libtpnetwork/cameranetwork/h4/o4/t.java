package com.tplink.libtpnetwork.cameranetwork.h4.o4;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.h4.g4;
import com.tplink.libtpnetwork.cameranetwork.h4.l4;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.LoginResult;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import okhttp3.ResponseBody;

public class t
  extends g4
{
  @NonNull
  private final r c;
  
  public t(@NonNull String paramString, @NonNull r paramr)
  {
    super(paramString);
    this.c = paramr;
  }
  
  io.reactivex.q<ResponseBody> a(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public io.reactivex.q<Response<LoginResult>> c(Account paramAccount)
  {
    return this.c.b(this.a.N0(paramAccount)).i(m.d());
  }
  
  protected io.reactivex.q<Response<Wrappers>> d(String paramString, Request<MultipleRequest> paramRequest)
  {
    return this.c.a(paramString, paramRequest).i(m.b(paramRequest)).O0(q.c);
  }
  
  protected io.reactivex.q<Response<MultipleResponse>> e(String paramString, Request<MultipleRequest> paramRequest)
  {
    return this.c.a(paramString, paramRequest).i(m.c(paramRequest));
  }
  
  protected io.reactivex.q<Response<Wrappers>> f(Request paramRequest)
  {
    return this.c.d(paramRequest);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\o4\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */