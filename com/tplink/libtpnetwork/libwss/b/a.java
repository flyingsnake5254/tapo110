package com.tplink.libtpnetwork.libwss.b;

import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import com.tplink.libtpnetwork.libwss.bean.result.AppToAppLinkStatusResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.o;
import retrofit2.x.s;

public abstract interface a
{
  @o("v1/public/auth/{skillCode}")
  public abstract io.reactivex.a a(@s("skillCode") String paramString, @retrofit2.x.a SkillActiveParams paramSkillActiveParams);
  
  @f("v1/public/auth/{skillCode}")
  public abstract q<AppToAppLinkStatusResult> b(@s("skillCode") String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */