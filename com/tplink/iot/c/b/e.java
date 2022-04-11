package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.family.common.RoomOrderInfo;
import com.tplink.iot.cloud.bean.family.params.FamilyCommonOrderParams;
import com.tplink.iot.cloud.bean.family.params.ThingFamilyParams;
import com.tplink.iot.cloud.bean.family.result.FamilyCommonOrderResult;
import io.reactivex.q;
import retrofit2.x.b;
import retrofit2.x.f;
import retrofit2.x.o;
import retrofit2.x.p;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface e
{
  @o("{url}/v1/families/thing-onboarding")
  public abstract io.reactivex.a C0(@s(encoded=true, value="url") String paramString, @retrofit2.x.a ThingFamilyParams paramThingFamilyParams);
  
  @o("{url}/v1/families/thing-settings")
  public abstract io.reactivex.a J(@s(encoded=true, value="url") String paramString, @retrofit2.x.a ThingFamilyParams paramThingFamilyParams);
  
  @f("{url}/v1/families/{familyId}/common-order")
  public abstract q<FamilyCommonOrderResult> L0(@s(encoded=true, value="url") String paramString1, @s("familyId") String paramString2);
  
  @b("{url}/v1/families/{familyId}")
  public abstract io.reactivex.a Q(@s(encoded=true, value="url") String paramString1, @s("familyId") String paramString2);
  
  @p("{url}/v1/families/{familyId}/rooms")
  public abstract q<RoomInfo> R(@s(encoded=true, value="url") String paramString1, @s("familyId") String paramString2, @retrofit2.x.a RoomInfo paramRoomInfo);
  
  @f("{url}/v1/families")
  public abstract q<PageListResult<FamilyInfo>> j0(@s(encoded=true, value="url") String paramString, @t("page") int paramInt1, @t("pageSize") int paramInt2);
  
  @p("{url}/v1/families")
  public abstract q<FamilyInfo> m0(@s(encoded=true, value="url") String paramString, @retrofit2.x.a FamilyInfo paramFamilyInfo);
  
  @o("{url}/v1/families/{familyId}/rooms/order")
  public abstract io.reactivex.a r0(@s(encoded=true, value="url") String paramString1, @s("familyId") String paramString2, @retrofit2.x.a RoomOrderInfo paramRoomOrderInfo);
  
  @o("{url}/v1/families/{familyId}/common-order")
  public abstract io.reactivex.a v0(@s(encoded=true, value="url") String paramString1, @s("familyId") String paramString2, @retrofit2.x.a FamilyCommonOrderParams paramFamilyCommonOrderParams);
  
  @b("{url}/v1/families/{familyId}/rooms/{roomId}")
  public abstract io.reactivex.a y1(@s(encoded=true, value="url") String paramString1, @s("familyId") String paramString2, @s("roomId") String paramString3);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */