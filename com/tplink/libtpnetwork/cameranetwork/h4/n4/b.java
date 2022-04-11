package com.tplink.libtpnetwork.cameranetwork.h4.n4;

import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.q;

public class b
  extends h4
{
  private c c;
  private d d;
  
  public b(d paramd)
  {
    this.d = paramd;
    this.c = new c(paramd.b(), paramd.a());
  }
  
  protected q<Response<Wrappers>> c3(Request<MultipleRequest> paramRequest)
  {
    return this.c.c(this.d.b(), paramRequest);
  }
  
  protected q<Response<MultipleResponse>> d3(Request<MultipleRequest> paramRequest)
  {
    return this.c.d(this.d.b(), paramRequest);
  }
  
  protected q<Response<Wrappers>> e3(Request paramRequest)
  {
    return this.c.e(paramRequest);
  }
  
  public void h4(d paramd)
  {
    this.d = paramd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\n4\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */