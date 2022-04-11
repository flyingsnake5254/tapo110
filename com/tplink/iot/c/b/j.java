package com.tplink.iot.c.b;

import com.google.gson.i;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.params.ThingBatchUnbindParams;
import com.tplink.iot.cloud.bean.thing.params.ThingCommonDeviceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingLightingEffectParams;
import com.tplink.iot.cloud.bean.thing.params.ThingRuleDeleteParams;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingShadowUpdateParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingBatchUnbindResult;
import com.tplink.iot.cloud.bean.thing.result.ThingCommonDeviceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingComponentResult;
import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceSyncResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingSupportInfoResult;
import io.reactivex.q;
import java.util.List;
import retrofit2.x.b;
import retrofit2.x.f;
import retrofit2.x.n;
import retrofit2.x.o;
import retrofit2.x.p;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface j
{
  @o("{url}/v1/things/{thingName}/services")
  public abstract q<ThingServiceResult> A(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingServiceParams paramThingServiceParams);
  
  @o("{url}/v1/things/common-device")
  public abstract q<ThingCommonDeviceResult> A1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a ThingCommonDeviceParams paramThingCommonDeviceParams);
  
  @f("{url}/v1/lighting-effect/predefined-effect")
  public abstract q<PageListResult<i>> B1(@s(encoded=true, value="url") String paramString1, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("effectIds") String paramString2, @t("versions") String paramString3);
  
  @b("{url}/v1/lighting-effect/customized-effect")
  public abstract io.reactivex.a C(@s(encoded=true, value="url") String paramString1, @t("id") String paramString2);
  
  @p("{url}/v1/things/{thingName}/rules/{ruleId}/type/awayMode")
  public abstract q<ThingRuleUpdateResult> D(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @s("ruleId") String paramString3, @retrofit2.x.a ThingRuleAwayMode paramThingRuleAwayMode);
  
  @o("{url}/v1/things/batch-unbind")
  public abstract q<List<ThingBatchUnbindResult>> D1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a ThingBatchUnbindParams paramThingBatchUnbindParams);
  
  @f("{url}/v1/things/{thingName}/firmwares/process")
  public abstract q<FirmwareDownloadState> E0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @o("{url}/v1/things/{thingName}/unbind")
  public abstract io.reactivex.a E1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @f("{url}/v1/things/{thingName}/rules?ruleType=timer")
  public abstract q<ThingRuleListResult<ThingRuleTimer>> F(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("startIndex") int paramInt);
  
  @f("{url}/v1/things/{thingName}/features/{featureType}")
  public abstract q<i> G(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @s("featureType") String paramString3);
  
  @f("{url}/v1/things/shadows")
  public abstract q<ThingShadowListResult> H0(@s(encoded=true, value="url") String paramString, @t("thingNames") String... paramVarArgs);
  
  @o("{url}/v1/things/{thingName}/rules/batchDelete")
  public abstract io.reactivex.a H1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingRuleDeleteParams paramThingRuleDeleteParams);
  
  @f("{url}/v1/things/{thingName}/rules?ruleType=dynamicLightEffect")
  public abstract q<ThingRuleListResult<ThingRuleLightEffect>> I(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("startIndex") int paramInt);
  
  @o("{url}/v1/things/{thingName}/events/mute")
  public abstract io.reactivex.a J0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("msgTypes") String paramString3);
  
  @f("{url}/v1/things/{thingName}/onboarding/sub-things")
  public abstract q<SubThingScanListResult> K(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @o("{url}/v1/things/{thingName}/rules/type/schedule")
  public abstract q<ThingRuleUpdateResult> L(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingRuleSchedule paramThingRuleSchedule);
  
  @f("{url}/v1/things/{thingName}/settings")
  public abstract q<ThingSetting> M0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @f("{url}/v1/things/{thingName}/details")
  public abstract q<ThingDetail> M1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @p("{url}/v1/lighting-effect/customized-effect")
  public abstract q<i> N1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a ThingLightingEffectParams paramThingLightingEffectParams);
  
  @o("{url}/v1/things/{thingName}/presets")
  public abstract io.reactivex.a O(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("index") Integer paramInteger, @retrofit2.x.a i parami);
  
  @n("{url}/v1/things/{thingName}/shadows")
  public abstract q<ThingShadowUpdateResult> O1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingShadowUpdateParams paramThingShadowUpdateParams);
  
  @f("{url}/v1/next-events/latest")
  public abstract q<ThingNextEvent> P0(@s(encoded=true, value="url") String paramString1, @t("familyId") String paramString2);
  
  @f("{url}/v1/things/{thingName}/firmwares/latest")
  public abstract q<ThingFirmware> R0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @p("{url}/v1/things/{thingName}/rules/{ruleId}/type/dynamicLightEffect")
  public abstract q<ThingRuleUpdateResult> S(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @s("ruleId") String paramString3, @retrofit2.x.a ThingRuleLightEffect paramThingRuleLightEffect);
  
  @o("{url}/v1/things/{thingName}/presets")
  public abstract io.reactivex.a T0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a i parami);
  
  @o("{url}/v1/things/{thingName}/rules/type/awayMode")
  public abstract q<ThingRuleUpdateResult> V0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingRuleAwayMode paramThingRuleAwayMode);
  
  @o("{url}/v1/things/{thingName}/onboarding/sub-things/setting")
  public abstract io.reactivex.a W(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a SubThingQuickSetupInfoListParams paramSubThingQuickSetupInfoListParams);
  
  @f("{url}/v1/things/{thingName}/presets")
  public abstract q<i> X0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @f("{url}/v1/things/{thingName}/support-info")
  public abstract q<ThingSupportInfoResult> Z(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("typeList") String paramString3);
  
  @f("{url}/v1/next-events")
  public abstract q<List<ThingNextEvent>> Z0(@s(encoded=true, value="url") String paramString1, @t("familyId") String paramString2);
  
  @f("{url}/v1/lighting-effect/predefined-effect-template")
  public abstract q<PageListResult<i>> e0(@s(encoded=true, value="url") String paramString1, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("effectIds") String paramString2, @t("versions") String paramString3);
  
  @b("{url}/v1/things/{thingName}/events")
  public abstract io.reactivex.a f1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @f("{url}/v1/things/{thingName}/rules?ruleType=schedule")
  public abstract q<ThingRuleListResult<ThingRuleSchedule>> g0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("startIndex") int paramInt);
  
  @o("{url}/v1/things/{thingName}/onboarding/sub-things")
  public abstract io.reactivex.a h(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a SubThingAddListParams paramSubThingAddListParams);
  
  @n("{url}/v1/things/{thingName}/features/{featureType}")
  public abstract q<i> i0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @s("featureType") String paramString3, @retrofit2.x.a i parami);
  
  @f("{url}/v1/things/{thingName}/events")
  public abstract q<ThingEventLogResult> j(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("afterTime") Long paramLong1, @t("beforeTime") Long paramLong2, @t("fetchSize") int paramInt, @t("filteredEventIds") String paramString3, @t("order") String paramString4);
  
  @o("{url}/v1/things/{thingName}/services-sync")
  public abstract q<ThingServiceSyncResult> l(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingServiceParams paramThingServiceParams);
  
  @f("{url}/v1/things/{thingName}/next-events")
  public abstract q<NextEvent> l1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @p("{url}/v1/things/{thingName}/rules/{ruleId}/type/schedule")
  public abstract q<ThingRuleUpdateResult> m(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @s("ruleId") String paramString3, @retrofit2.x.a ThingRuleSchedule paramThingRuleSchedule);
  
  @o("{url}/v1/lighting-effect/customized-effect")
  public abstract q<i> m1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a ThingLightingEffectParams paramThingLightingEffectParams);
  
  @p("{url}/v1/things/{thingName}/rules/{ruleId}/type/guardMode")
  public abstract q<ThingRuleUpdateResult> p0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @s("ruleId") String paramString3, @retrofit2.x.a ThingRuleGuardMode paramThingRuleGuardMode);
  
  @o("{url}/v1/things/{thingName}/command/firmware-upgrade")
  public abstract io.reactivex.a q0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @f("{url}/v1/lighting-effect/customized-effect")
  public abstract q<PageListResult<i>> r1(@s(encoded=true, value="url") String paramString1, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("effectIds") String paramString2, @t("versions") String paramString3);
  
  @n("{url}/v1/things/{thingName}/settings")
  public abstract io.reactivex.a s0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingSetting paramThingSetting);
  
  @f("{url}/v1/things")
  public abstract q<PageListResult<ThingInfo>> t(@s(encoded=true, value="url") String paramString1, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("deviceTypes") String paramString2);
  
  @f("{url}/v1/things/{thingName}/components")
  public abstract q<ThingComponentResult> t0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @p("{url}/v1/things/{thingName}/rules/{ruleId}/type/timer")
  public abstract q<ThingRuleUpdateResult> u1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @s("ruleId") String paramString3, @retrofit2.x.a ThingRuleTimer paramThingRuleTimer);
  
  @f("{url}/v1/things/models/{thingModelId}")
  public abstract q<ThingModel> v1(@s(encoded=true, value="url") String paramString1, @s("thingModelId") String paramString2);
  
  @f("{url}/v1/things/{thingName}/rules?ruleType=awayMode")
  public abstract q<ThingRuleListResult<ThingRuleAwayMode>> w(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("startIndex") int paramInt);
  
  @o("{url}/v1/things/{thingName}/rules/type/timer")
  public abstract q<ThingRuleUpdateResult> w0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a ThingRuleTimer paramThingRuleTimer);
  
  @f("{url}/v1/things/{thingName}/rt-info")
  public abstract q<ThingRealTimeInfo> x(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @f("{url}/v1/things/{thingName}/usage")
  public abstract q<ThingUsage> x0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2);
  
  @o("{url}/v1/things/{thingName}/onboarding")
  public abstract io.reactivex.a y0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a SubThingCategoryScanParams paramSubThingCategoryScanParams);
  
  @f("{url}/v1/things/{thingName}/rules?ruleType=guardMode")
  public abstract q<ThingRuleListResult<ThingRuleGuardMode>> z(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("startIndex") int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */