package com.tplink.libtpnetwork.cameranetwork.h4.p4;

import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.PassThroughRequestData;
import com.tplink.libtpnetwork.cameranetwork.model.PassThroughResponseData;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.o;
import retrofit2.x.t;

public abstract interface d
{
  @o(".")
  public abstract q<Response<PassThroughResponseData<Response<MultipleResponse>>>> a(@t("token") String paramString, @a Request<PassThroughRequestData> paramRequest);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\p4\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */