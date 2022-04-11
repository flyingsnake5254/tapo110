package com.tplink.libtpnetwork.libwss.b;

import com.tplink.libtpnetwork.libwss.bean.result.GoogleAssistantLinkInfoResult;
import io.reactivex.a;
import io.reactivex.q;
import retrofit2.x.o;
import retrofit2.x.s;

public abstract interface b
{
  @o("v1/public/auth/islinked/{actionType}")
  public abstract q<GoogleAssistantLinkInfoResult> a(@s("actionType") String paramString);
  
  @retrofit2.x.b("v1/public/auth/unlink/{actionType}")
  public abstract a b(@s("actionType") String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */