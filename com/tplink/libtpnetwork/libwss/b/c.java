package com.tplink.libtpnetwork.libwss.b;

import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import retrofit2.x.b;
import retrofit2.x.o;
import retrofit2.x.s;

public abstract interface c
{
  @o("v1/public/skill-activation/{skillCode}")
  public abstract io.reactivex.a a(@s("skillCode") String paramString, @retrofit2.x.a SkillActiveParams paramSkillActiveParams);
  
  @b("/v1/public/skill-activation/{skillCode}")
  public abstract io.reactivex.a b(@s("skillCode") String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */