package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.group.params.GroupThingGroupListParams;
import com.tplink.iot.cloud.bean.group.params.GroupThingListParams;
import io.reactivex.q;
import java.util.List;
import retrofit2.x.b;
import retrofit2.x.h;
import retrofit2.x.n;
import retrofit2.x.o;
import retrofit2.x.p;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface f
{
  @b("{url}/v1/groups")
  public abstract io.reactivex.a B0(@s(encoded=true, value="url") String paramString, @t("groupIds") String... paramVarArgs);
  
  @h(hasBody=true, method="DELETE", path="{url}/v1/groups/{groupId}/things")
  public abstract io.reactivex.a H(@s(encoded=true, value="url") String paramString1, @s("groupId") String paramString2, @retrofit2.x.a GroupThingListParams paramGroupThingListParams);
  
  @retrofit2.x.f("{url}/v1/groups")
  public abstract q<PageListResult<GroupInfo>> K1(@s(encoded=true, value="url") String paramString, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("groupIds") String... paramVarArgs);
  
  @o("{url}/v1/groups/things")
  public abstract io.reactivex.a N(@s(encoded=true, value="url") String paramString, @retrofit2.x.a GroupThingGroupListParams paramGroupThingGroupListParams);
  
  @n("{url}/v1/groups")
  public abstract io.reactivex.a W0(@s(encoded=true, value="url") String paramString, @t("groupIds") List<String> paramList, @retrofit2.x.a GroupInfo paramGroupInfo);
  
  @p("{url}/v1/groups")
  public abstract io.reactivex.a c1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a GroupInfo paramGroupInfo);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */