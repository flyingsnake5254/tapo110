package com.tplink.libtpnetwork.cameranetwork.h4.p4;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.h4.g4;
import com.tplink.libtpnetwork.cameranetwork.model.Method;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.PassThroughRequestData;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.q;

public class f
  extends g4
{
  @NonNull
  private final d c;
  
  public f(@NonNull String paramString, @NonNull d paramd)
  {
    super(paramString);
    this.c = paramd;
  }
  
  protected q<Response<Wrappers>> a(String paramString, Request<MultipleRequest> paramRequest)
  {
    Object localObject = new PassThroughRequestData(paramRequest, this.b);
    localObject = new Request(Method.PASS_THROUGH, localObject);
    return this.c.a(paramString, (Request)localObject).i(m.b((Request)localObject)).g0(b.c).i(m.b(paramRequest)).g0(c.c).O0(a.c);
  }
  
  protected q<Response<MultipleResponse>> b(String paramString, Request<MultipleRequest> paramRequest)
  {
    Object localObject = new PassThroughRequestData(paramRequest, this.b);
    localObject = new Request(Method.PASS_THROUGH, localObject);
    return this.c.a(paramString, (Request)localObject).i(m.b((Request)localObject)).g0(b.c).i(m.c(paramRequest));
  }
  
  protected q<Response<Wrappers>> c(Request paramRequest)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\p4\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */