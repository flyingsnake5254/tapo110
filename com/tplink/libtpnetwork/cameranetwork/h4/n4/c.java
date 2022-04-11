package com.tplink.libtpnetwork.cameranetwork.h4.n4;

import androidx.annotation.NonNull;
import b.d.b.f.b;
import com.google.gson.Gson;
import com.google.gson.d;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudASyncRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.h4.g4;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.PassThroughRequestData;
import com.tplink.libtpnetwork.cameranetwork.model.PassThroughResponseData;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.TypeAdapter;
import com.tplink.libtpnetwork.cameranetwork.model.Wrapper;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;

public class c
  extends g4
{
  private static final Gson c = new d().d(Wrapper.class, TypeAdapter.getWrapperSerializer()).d(Wrapper.class, TypeAdapter.getWrapperDeserializer()).d(Wrappers.class, TypeAdapter.getWrapperListSerializer()).d(Wrappers.class, TypeAdapter.getWrapperListDeserializer()).b();
  @NonNull
  private final ThingCloudASyncRepository d;
  private String e;
  
  public c(@NonNull String paramString, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramString);
    this.d = ((ThingCloudASyncRepository)b.a(paramTPCameraDeviceContext.getTcAccountContext(), ThingCloudASyncRepository.class));
    this.e = paramTPCameraDeviceContext.getThingUrl();
  }
  
  protected q<Response<Wrappers>> c(String paramString, Request<MultipleRequest> paramRequest)
  {
    paramString = new ThingServiceParams();
    paramString.setServiceId("passthrough");
    PassThroughRequestData localPassThroughRequestData = new PassThroughRequestData(paramRequest, null);
    paramString.setInputParams(c.A(localPassThroughRequestData));
    b.d.w.c.a.e("testcamera", com.tplink.libtpnetwork.Utils.i.h(paramString));
    return this.d.w(this.e, this.b, paramString).g0(new b()).i(m.b(paramRequest)).O0(a.c).C(new a());
  }
  
  protected q<Response<MultipleResponse>> d(String paramString, Request<MultipleRequest> paramRequest)
  {
    ThingServiceParams localThingServiceParams = new ThingServiceParams();
    localThingServiceParams.setServiceId("passthrough");
    paramString = new PassThroughRequestData(paramRequest, null);
    localThingServiceParams.setInputParams(c.A(paramString));
    b.d.w.c.a.e("testcamera", com.tplink.libtpnetwork.Utils.i.h(localThingServiceParams));
    return this.d.w(this.e, this.b, localThingServiceParams).g0(new d()).i(m.c(paramRequest)).C(new c());
  }
  
  protected q<Response<Wrappers>> e(Request paramRequest)
  {
    throw new UnsupportedOperationException();
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable.printStackTrace();
    }
  }
  
  class b
    implements j<com.google.gson.i, Response<MultipleResponse>>
  {
    b() {}
    
    public Response<MultipleResponse> a(com.google.gson.i parami)
      throws Exception
    {
      if (parami != null) {
        return (Response)((PassThroughResponseData)c.a().h(parami, new a().getType())).getResponseData();
      }
      throw new IoTCloudException(-11, "service result error");
    }
    
    class a
      extends com.google.gson.r.a<PassThroughResponseData<Response<MultipleResponse>>>
    {
      a() {}
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable.printStackTrace();
    }
  }
  
  class d
    implements j<com.google.gson.i, Response<MultipleResponse>>
  {
    d() {}
    
    public Response<MultipleResponse> a(com.google.gson.i parami)
      throws Exception
    {
      if (parami != null) {
        return (Response)((PassThroughResponseData)c.a().h(parami, new a().getType())).getResponseData();
      }
      throw new IoTCloudException(-11, "service result error");
    }
    
    class a
      extends com.google.gson.r.a<PassThroughResponseData<Response<MultipleResponse>>>
    {
      a() {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\n4\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */