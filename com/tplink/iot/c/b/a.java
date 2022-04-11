package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.common.AsyncResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.s;

public abstract interface a
{
  @f("{url}/v1/requests/{requestId}")
  public abstract q<AsyncResult> G1(@s(encoded=true, value="url") String paramString1, @s("requestId") String paramString2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */