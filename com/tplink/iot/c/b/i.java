package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.result.SmartExecResult;
import io.reactivex.q;
import retrofit2.x.b;
import retrofit2.x.f;
import retrofit2.x.o;
import retrofit2.x.p;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface i
{
  @f("{url}/v1/smarts/templates")
  public abstract q<PageListResult<SmartTemplate>> I0(@s(encoded=true, value="url") String paramString1, @t("lang") String paramString2, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("dynamicAdaptive") boolean paramBoolean);
  
  @o("{url}/v1/smarts/{smartId}/exec")
  public abstract q<SmartExecResult> U(@s(encoded=true, value="url") String paramString1, @s("smartId") String paramString2);
  
  @b("{url}/v1/smarts/{smartId}")
  public abstract io.reactivex.a c0(@s(encoded=true, value="url") String paramString1, @s("smartId") String paramString2);
  
  @f("{url}/v1/smarts")
  public abstract q<PageListResult<SmartInfo>> h0(@s(encoded=true, value="url") String paramString, @t("page") int paramInt1, @t("pageSize") int paramInt2);
  
  @p("{url}/v1/smarts")
  public abstract io.reactivex.a k1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a SmartInfo paramSmartInfo);
  
  @f("{url}/v1/smarts/logs")
  public abstract q<PageListResult<SmartLog>> o(@s(encoded=true, value="url") String paramString, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("afterTime") Integer paramInteger1, @t("beforeTime") Integer paramInteger2);
  
  @b("{url}/v1/smarts/logs")
  public abstract io.reactivex.a w1(@s(encoded=true, value="url") String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */