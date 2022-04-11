package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.auth.params.AuthParams;
import com.tplink.iot.cloud.bean.auth.result.AuthResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.k;
import retrofit2.x.o;
import retrofit2.x.s;

public abstract interface b
{
  @k({"Authorization-Required:false"})
  @o("{url}/v1/auth/app")
  public abstract q<AuthResult> g1(@s(encoded=true, value="url") String paramString, @a AuthParams paramAuthParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */