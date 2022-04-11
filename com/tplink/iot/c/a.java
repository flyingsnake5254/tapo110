package com.tplink.iot.c;

import androidx.annotation.NonNull;
import com.tplink.iot.c.b.c;
import com.tplink.iot.c.b.d;
import com.tplink.iot.c.b.e;
import com.tplink.iot.c.b.f;
import com.tplink.iot.c.b.g;
import com.tplink.iot.c.b.h;
import com.tplink.iot.c.b.j;
import com.tplink.iot.cloud.bean.auth.params.AuthParams;
import com.tplink.iot.cloud.bean.auth.result.AuthResult;
import com.tplink.iot.cloud.bean.billing.params.ReceiptParams;
import com.tplink.iot.cloud.bean.billing.result.JudgeReceiptResult;
import com.tplink.iot.cloud.bean.billing.result.ProductListResult;
import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.params.DeviceTypeParams;
import com.tplink.iot.cloud.bean.cloudvideo.params.DeviceVideoParams;
import com.tplink.iot.cloud.bean.cloudvideo.params.UnbindDeviceParams;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoDevicesResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CountryCodeListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceIdListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceOrderListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceVideoDateResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DowngradeInfoResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.OrderPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.TapoCareUrlResult;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.family.common.RoomOrderInfo;
import com.tplink.iot.cloud.bean.family.params.FamilyCommonOrderParams;
import com.tplink.iot.cloud.bean.family.params.ThingFamilyParams;
import com.tplink.iot.cloud.bean.family.result.FamilyCommonOrderResult;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.group.params.GroupThingGroupListParams;
import com.tplink.iot.cloud.bean.group.params.GroupThingListParams;
import com.tplink.iot.cloud.bean.push.params.IoTSubscribeMsgParams;
import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserListResult;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUsersParams;
import com.tplink.iot.cloud.bean.share.result.DeviceShareActionHandleListResult;
import com.tplink.iot.cloud.bean.share.result.DeviceShareLaunchResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceListResult;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.result.SmartExecResult;
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

public class a
  extends b.d.b.d.a.b
  implements com.tplink.iot.c.b.b, e, com.tplink.iot.c.b.i, j, d, com.tplink.iot.c.b.a, c, f, h, g
{
  private com.tplink.iot.c.b.b d;
  private e e;
  private com.tplink.iot.c.b.i f;
  private j g;
  private d h;
  private com.tplink.iot.c.b.a i;
  private c j;
  private f k;
  private h l;
  private g m;
  private com.tplink.iot.c.c.b n;
  
  public a(@NonNull String paramString, @NonNull com.tplink.iot.c.c.b paramb)
  {
    super(localStringBuilder.toString(), paramb.l());
    this.n = paramb;
    this.d = ((com.tplink.iot.c.b.b)R1(com.tplink.iot.c.b.b.class));
    this.e = ((e)R1(e.class));
    this.f = ((com.tplink.iot.c.b.i)R1(com.tplink.iot.c.b.i.class));
    this.g = ((j)R1(j.class));
    this.h = ((d)R1(d.class));
    this.i = ((com.tplink.iot.c.b.a)R1(com.tplink.iot.c.b.a.class));
    this.j = ((c)R1(c.class));
    this.k = ((f)R1(f.class));
    this.l = ((h)R1(h.class));
    this.m = ((g)R1(g.class));
  }
  
  public q<ThingServiceResult> A(String paramString1, String paramString2, ThingServiceParams paramThingServiceParams)
  {
    return this.g.A(paramString1, paramString2, paramThingServiceParams);
  }
  
  public q<TapoCareUrlResult> A0(String paramString1, String paramString2)
  {
    return this.h.A0(paramString1, paramString2);
  }
  
  public q<ThingCommonDeviceResult> A1(String paramString, ThingCommonDeviceParams paramThingCommonDeviceParams)
  {
    return this.g.A1(paramString, paramThingCommonDeviceParams);
  }
  
  public io.reactivex.a B(String paramString1, String paramString2, DeviceUsersParams paramDeviceUsersParams)
  {
    return this.l.B(paramString1, paramString2, paramDeviceUsersParams);
  }
  
  public io.reactivex.a B0(String paramString, String... paramVarArgs)
  {
    return this.k.B0(paramString, paramVarArgs);
  }
  
  public q<PageListResult<com.google.gson.i>> B1(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    return this.g.B1(paramString1, paramInt1, paramInt2, paramString2, paramString3);
  }
  
  public io.reactivex.a C(String paramString1, String paramString2)
  {
    return this.g.C(paramString1, paramString2);
  }
  
  public io.reactivex.a C0(String paramString, ThingFamilyParams paramThingFamilyParams)
  {
    return this.e.C0(paramString, paramThingFamilyParams);
  }
  
  public q<ThingRuleUpdateResult> D(String paramString1, String paramString2, String paramString3, ThingRuleAwayMode paramThingRuleAwayMode)
  {
    return this.g.D(paramString1, paramString2, paramString3, paramThingRuleAwayMode);
  }
  
  public q<List<ThingBatchUnbindResult>> D1(String paramString, ThingBatchUnbindParams paramThingBatchUnbindParams)
  {
    return this.g.D1(paramString, paramThingBatchUnbindParams);
  }
  
  public q<FirmwareDownloadState> E0(String paramString1, String paramString2)
  {
    return this.g.E0(paramString1, paramString2);
  }
  
  public io.reactivex.a E1(String paramString1, String paramString2)
  {
    return this.g.E1(paramString1, paramString2);
  }
  
  public q<ThingRuleListResult<ThingRuleTimer>> F(String paramString1, String paramString2, int paramInt)
  {
    return this.g.F(paramString1, paramString2, paramInt);
  }
  
  public q<DeviceOwnerInfoResult> F0(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.l.F0(paramString1, paramString2, paramBoolean);
  }
  
  public io.reactivex.a F1(String paramString, DeviceVideoParams paramDeviceVideoParams)
  {
    return this.h.F1(paramString, paramDeviceVideoParams);
  }
  
  public q<com.google.gson.i> G(String paramString1, String paramString2, String paramString3)
  {
    return this.g.G(paramString1, paramString2, paramString3);
  }
  
  public q<OrderPageListResult<OrderInfo>> G0(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return this.h.G0(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public q<AsyncResult> G1(String paramString1, String paramString2)
  {
    return this.i.G1(paramString1, paramString2);
  }
  
  public io.reactivex.a H(String paramString1, String paramString2, GroupThingListParams paramGroupThingListParams)
  {
    return this.k.H(paramString1, paramString2, paramGroupThingListParams);
  }
  
  public q<ThingShadowListResult> H0(String paramString, String... paramVarArgs)
  {
    return this.g.H0(paramString, paramVarArgs);
  }
  
  public io.reactivex.a H1(String paramString1, String paramString2, ThingRuleDeleteParams paramThingRuleDeleteParams)
  {
    return this.g.H1(paramString1, paramString2, paramThingRuleDeleteParams);
  }
  
  public q<ThingRuleListResult<ThingRuleLightEffect>> I(String paramString1, String paramString2, int paramInt)
  {
    return this.g.I(paramString1, paramString2, paramInt);
  }
  
  public q<PageListResult<SmartTemplate>> I0(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.f.I0(paramString1, paramString2, paramInt1, paramInt2, paramBoolean);
  }
  
  public io.reactivex.a J(String paramString, ThingFamilyParams paramThingFamilyParams)
  {
    return this.e.J(paramString, paramThingFamilyParams);
  }
  
  public io.reactivex.a J0(String paramString1, String paramString2, String paramString3)
  {
    return this.g.J0(paramString1, paramString2, paramString3);
  }
  
  public q<SubThingScanListResult> K(String paramString1, String paramString2)
  {
    return this.g.K(paramString1, paramString2);
  }
  
  public q<DowngradeInfoResult> K0(String paramString)
  {
    return this.h.K0(paramString);
  }
  
  public q<PageListResult<GroupInfo>> K1(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    return this.k.K1(paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  public q<ThingRuleUpdateResult> L(String paramString1, String paramString2, ThingRuleSchedule paramThingRuleSchedule)
  {
    return this.g.L(paramString1, paramString2, paramThingRuleSchedule);
  }
  
  public q<FamilyCommonOrderResult> L0(String paramString1, String paramString2)
  {
    return this.e.L0(paramString1, paramString2);
  }
  
  public q<ThingSetting> M0(String paramString1, String paramString2)
  {
    return this.g.M0(paramString1, paramString2);
  }
  
  public q<ThingDetail> M1(String paramString1, String paramString2)
  {
    return this.g.M1(paramString1, paramString2);
  }
  
  public io.reactivex.a N(String paramString, GroupThingGroupListParams paramGroupThingGroupListParams)
  {
    return this.k.N(paramString, paramGroupThingGroupListParams);
  }
  
  public q<com.google.gson.i> N1(String paramString, ThingLightingEffectParams paramThingLightingEffectParams)
  {
    return this.g.N1(paramString, paramThingLightingEffectParams);
  }
  
  public io.reactivex.a O(String paramString1, String paramString2, Integer paramInteger, com.google.gson.i parami)
  {
    return this.g.O(paramString1, paramString2, paramInteger, parami);
  }
  
  public q<ThingShadowUpdateResult> O1(String paramString1, String paramString2, ThingShadowUpdateParams paramThingShadowUpdateParams)
  {
    return this.g.O1(paramString1, paramString2, paramThingShadowUpdateParams);
  }
  
  public q<CloudVideoDevicesResult> P(String paramString, int paramInt1, int paramInt2)
  {
    return this.h.P(paramString, paramInt1, paramInt2);
  }
  
  public q<ThingNextEvent> P0(String paramString1, String paramString2)
  {
    return this.g.P0(paramString1, paramString2);
  }
  
  public io.reactivex.a P1(String paramString, UnbindDeviceParams paramUnbindDeviceParams)
  {
    return this.h.P1(paramString, paramUnbindDeviceParams);
  }
  
  public io.reactivex.a Q(String paramString1, String paramString2)
  {
    return this.e.Q(paramString1, paramString2);
  }
  
  public q<RoomInfo> R(String paramString1, String paramString2, RoomInfo paramRoomInfo)
  {
    return this.e.R(paramString1, paramString2, paramRoomInfo);
  }
  
  public q<ThingFirmware> R0(String paramString1, String paramString2)
  {
    return this.g.R0(paramString1, paramString2);
  }
  
  public q<ThingRuleUpdateResult> S(String paramString1, String paramString2, String paramString3, ThingRuleLightEffect paramThingRuleLightEffect)
  {
    return this.g.S(paramString1, paramString2, paramString3, paramThingRuleLightEffect);
  }
  
  public com.tplink.iot.c.c.b S1()
  {
    return this.n;
  }
  
  public io.reactivex.a T0(String paramString1, String paramString2, com.google.gson.i parami)
  {
    return this.g.T0(paramString1, paramString2, parami);
  }
  
  public void T1(String paramString)
  {
    this.n.n(paramString);
  }
  
  public q<SmartExecResult> U(String paramString1, String paramString2)
  {
    return this.f.U(paramString1, paramString2);
  }
  
  public q<DeviceCloudProduct> V(String paramString1, String paramString2)
  {
    return this.h.V(paramString1, paramString2);
  }
  
  public q<ThingRuleUpdateResult> V0(String paramString1, String paramString2, ThingRuleAwayMode paramThingRuleAwayMode)
  {
    return this.g.V0(paramString1, paramString2, paramThingRuleAwayMode);
  }
  
  public io.reactivex.a W(String paramString1, String paramString2, SubThingQuickSetupInfoListParams paramSubThingQuickSetupInfoListParams)
  {
    return this.g.W(paramString1, paramString2, paramSubThingQuickSetupInfoListParams);
  }
  
  public io.reactivex.a W0(String paramString, List<String> paramList, GroupInfo paramGroupInfo)
  {
    return this.k.W0(paramString, paramList, paramGroupInfo);
  }
  
  public q<com.google.gson.i> X0(String paramString1, String paramString2)
  {
    return this.g.X0(paramString1, paramString2);
  }
  
  public q<ThingSupportInfoResult> Z(String paramString1, String paramString2, String paramString3)
  {
    return this.g.Z(paramString1, paramString2, paramString3);
  }
  
  public q<List<ThingNextEvent>> Z0(String paramString1, String paramString2)
  {
    return this.g.Z0(paramString1, paramString2);
  }
  
  public q<CountryCodeListResult> a1(String paramString)
  {
    return this.h.a1(paramString);
  }
  
  public q<ShareDeviceListResult> b0(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    return this.l.b0(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramString4);
  }
  
  public io.reactivex.a c0(String paramString1, String paramString2)
  {
    return this.f.c0(paramString1, paramString2);
  }
  
  public io.reactivex.a c1(String paramString, GroupInfo paramGroupInfo)
  {
    return this.k.c1(paramString, paramGroupInfo);
  }
  
  public io.reactivex.a d0(String paramString, DeviceUserRoleListParams paramDeviceUserRoleListParams)
  {
    return this.l.d0(paramString, paramDeviceUserRoleListParams);
  }
  
  public q<PageListResult<com.google.gson.i>> e0(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    return this.g.e0(paramString1, paramInt1, paramInt2, paramString2, paramString3);
  }
  
  public io.reactivex.a f1(String paramString1, String paramString2)
  {
    return this.g.f1(paramString1, paramString2);
  }
  
  public q<ThingRuleListResult<ThingRuleSchedule>> g0(String paramString1, String paramString2, int paramInt)
  {
    return this.g.g0(paramString1, paramString2, paramInt);
  }
  
  public q<AuthResult> g1(String paramString, AuthParams paramAuthParams)
  {
    return this.d.g1(paramString, paramAuthParams);
  }
  
  public io.reactivex.a h(String paramString1, String paramString2, SubThingAddListParams paramSubThingAddListParams)
  {
    return this.g.h(paramString1, paramString2, paramSubThingAddListParams);
  }
  
  public q<PageListResult<SmartInfo>> h0(String paramString, int paramInt1, int paramInt2)
  {
    return this.f.h0(paramString, paramInt1, paramInt2);
  }
  
  public q<DeviceIdListResult> h1(String paramString, DeviceTypeParams paramDeviceTypeParams)
  {
    return this.h.h1(paramString, paramDeviceTypeParams);
  }
  
  public q<com.google.gson.i> i0(String paramString1, String paramString2, String paramString3, com.google.gson.i parami)
  {
    return this.g.i0(paramString1, paramString2, paramString3, parami);
  }
  
  public q<ThingEventLogResult> j(String paramString1, String paramString2, Long paramLong1, Long paramLong2, int paramInt, String paramString3, String paramString4)
  {
    return this.g.j(paramString1, paramString2, paramLong1, paramLong2, paramInt, paramString3, paramString4);
  }
  
  public q<PageListResult<FamilyInfo>> j0(String paramString, int paramInt1, int paramInt2)
  {
    return this.e.j0(paramString, paramInt1, paramInt2);
  }
  
  public q<DeviceShareLaunchResult> k(String paramString, DeviceShareListParams paramDeviceShareListParams)
  {
    return this.l.k(paramString, paramDeviceShareListParams);
  }
  
  public io.reactivex.a k1(String paramString, SmartInfo paramSmartInfo)
  {
    return this.f.k1(paramString, paramSmartInfo);
  }
  
  public q<ThingServiceSyncResult> l(String paramString1, String paramString2, ThingServiceParams paramThingServiceParams)
  {
    return this.g.l(paramString1, paramString2, paramThingServiceParams);
  }
  
  public q<NextEvent> l1(String paramString1, String paramString2)
  {
    return this.g.l1(paramString1, paramString2);
  }
  
  public q<ThingRuleUpdateResult> m(String paramString1, String paramString2, String paramString3, ThingRuleSchedule paramThingRuleSchedule)
  {
    return this.g.m(paramString1, paramString2, paramString3, paramThingRuleSchedule);
  }
  
  public q<FamilyInfo> m0(String paramString, FamilyInfo paramFamilyInfo)
  {
    return this.e.m0(paramString, paramFamilyInfo);
  }
  
  public q<com.google.gson.i> m1(String paramString, ThingLightingEffectParams paramThingLightingEffectParams)
  {
    return this.g.m1(paramString, paramThingLightingEffectParams);
  }
  
  public q<DeviceVideoDateResult<HasVideoTime>> n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.h.n(paramString1, paramString2, paramString3, paramString4);
  }
  
  public io.reactivex.a n0(String paramString, IoTSubscribeMsgParams paramIoTSubscribeMsgParams)
  {
    return this.m.n0(paramString, paramIoTSubscribeMsgParams);
  }
  
  public q<VerifyReceiptResult> n1(String paramString, ReceiptParams paramReceiptParams)
  {
    return this.j.n1(paramString, paramReceiptParams);
  }
  
  public q<PageListResult<SmartLog>> o(String paramString, int paramInt1, int paramInt2, Integer paramInteger1, Integer paramInteger2)
  {
    return this.f.o(paramString, paramInt1, paramInt2, paramInteger1, paramInteger2);
  }
  
  public q<DeviceOrderListResult<DeviceCloudProduct>> o0(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return this.h.o0(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public q<ThingRuleUpdateResult> p0(String paramString1, String paramString2, String paramString3, ThingRuleGuardMode paramThingRuleGuardMode)
  {
    return this.g.p0(paramString1, paramString2, paramString3, paramThingRuleGuardMode);
  }
  
  public q<JudgeReceiptResult> q(String paramString, ReceiptParams paramReceiptParams)
  {
    return this.j.q(paramString, paramReceiptParams);
  }
  
  public io.reactivex.a q0(String paramString1, String paramString2)
  {
    return this.g.q0(paramString1, paramString2);
  }
  
  public q<CloudVideoPageListResult<CloudVideo>> q1(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return this.h.q1(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public io.reactivex.a r0(String paramString1, String paramString2, RoomOrderInfo paramRoomOrderInfo)
  {
    return this.e.r0(paramString1, paramString2, paramRoomOrderInfo);
  }
  
  public q<PageListResult<com.google.gson.i>> r1(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    return this.g.r1(paramString1, paramInt1, paramInt2, paramString2, paramString3);
  }
  
  public io.reactivex.a s0(String paramString1, String paramString2, ThingSetting paramThingSetting)
  {
    return this.g.s0(paramString1, paramString2, paramThingSetting);
  }
  
  public q<PageListResult<ThingInfo>> t(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return this.g.t(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public q<ThingComponentResult> t0(String paramString1, String paramString2)
  {
    return this.g.t0(paramString1, paramString2);
  }
  
  public q<DeviceShareActionHandleListResult> u(String paramString, DeviceShareActionListParams paramDeviceShareActionListParams)
  {
    return this.l.u(paramString, paramDeviceShareActionListParams);
  }
  
  public q<ProductListResult> u0(String paramString)
  {
    return this.j.u0(paramString);
  }
  
  public q<ThingRuleUpdateResult> u1(String paramString1, String paramString2, String paramString3, ThingRuleTimer paramThingRuleTimer)
  {
    return this.g.u1(paramString1, paramString2, paramString3, paramThingRuleTimer);
  }
  
  public io.reactivex.a v0(String paramString1, String paramString2, FamilyCommonOrderParams paramFamilyCommonOrderParams)
  {
    return this.e.v0(paramString1, paramString2, paramFamilyCommonOrderParams);
  }
  
  public q<ThingModel> v1(String paramString1, String paramString2)
  {
    return this.g.v1(paramString1, paramString2);
  }
  
  public q<ThingRuleListResult<ThingRuleAwayMode>> w(String paramString1, String paramString2, int paramInt)
  {
    return this.g.w(paramString1, paramString2, paramInt);
  }
  
  public q<ThingRuleUpdateResult> w0(String paramString1, String paramString2, ThingRuleTimer paramThingRuleTimer)
  {
    return this.g.w0(paramString1, paramString2, paramThingRuleTimer);
  }
  
  public io.reactivex.a w1(String paramString)
  {
    return this.f.w1(paramString);
  }
  
  public q<ThingRealTimeInfo> x(String paramString1, String paramString2)
  {
    return this.g.x(paramString1, paramString2);
  }
  
  public q<ThingUsage> x0(String paramString1, String paramString2)
  {
    return this.g.x0(paramString1, paramString2);
  }
  
  public io.reactivex.a y0(String paramString1, String paramString2, SubThingCategoryScanParams paramSubThingCategoryScanParams)
  {
    return this.g.y0(paramString1, paramString2, paramSubThingCategoryScanParams);
  }
  
  public io.reactivex.a y1(String paramString1, String paramString2, String paramString3)
  {
    return this.e.y1(paramString1, paramString2, paramString3);
  }
  
  public q<ThingRuleListResult<ThingRuleGuardMode>> z(String paramString1, String paramString2, int paramInt)
  {
    return this.g.z(paramString1, paramString2, paramInt);
  }
  
  public q<DeviceUserListResult> z1(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.l.z1(paramString1, paramString2, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */