package com.tplink.libtpnetwork.cameranetwork;

import androidx.annotation.NonNull;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.common.EnumCameraTransportType;
import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.h4.i4;
import com.tplink.libtpnetwork.cameranetwork.model.AESEncryptKey;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BindStatus;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneDstStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerracePoint;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ConnectResult;
import com.tplink.libtpnetwork.cameranetwork.model.ConnectStatus;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigRegion;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionList;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionSetting;
import com.tplink.libtpnetwork.cameranetwork.model.DiagnoseStatus;
import com.tplink.libtpnetwork.cameranetwork.model.FirmwareUpdateStatus;
import com.tplink.libtpnetwork.cameranetwork.model.HomePageDeviceInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LensMaskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Light;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MarkPositionConfirmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionListInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NetworkInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.OsdConfig;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordAudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ResetSupportInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardFormatProgress;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import com.tplink.libtpnetwork.cameranetwork.model.SettingComposite;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import com.tplink.libtpnetwork.cameranetwork.model.SpeakerInfo;
import com.tplink.libtpnetwork.cameranetwork.model.StartUpdateFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SystemInfo;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Timezone;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpPsk;
import com.tplink.libtpnetwork.cameranetwork.model.VideoQuality;
import com.tplink.libtpnetwork.cameranetwork.model.VodUserId;
import com.tplink.libtpnetwork.cameranetwork.model.Wan;
import com.tplink.libtpnetwork.cameranetwork.model.WhiteLampConfig;
import com.tplink.libtpnetwork.cameranetwork.model.WhitelampState;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.model.WifiList;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackItem;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ResponseBody;

public class f4
  implements com.tplink.libtpnetwork.cameranetwork.net.a
{
  private com.tplink.libtpnetwork.cameranetwork.h4.o4.s a;
  private com.tplink.libtpnetwork.cameranetwork.h4.p4.e b;
  private com.tplink.libtpnetwork.cameranetwork.h4.n4.b c;
  private io.reactivex.m0.g<Boolean> d = io.reactivex.m0.b.n1().l1();
  private TPCameraDeviceContext e;
  private io.reactivex.e0.c f;
  
  public f4() {}
  
  public f4(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    i3(paramTPCameraDeviceContext);
    this.e = paramTPCameraDeviceContext;
  }
  
  private void g3()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((h4)localObject).z0()))
    {
      this.d.onNext(Boolean.TRUE);
      return;
    }
    localObject = this.c;
    if ((localObject != null) && (((h4)localObject).z0()))
    {
      this.d.onNext(Boolean.TRUE);
      return;
    }
    localObject = this.b;
    if ((localObject != null) && (((h4)localObject).z0()))
    {
      this.d.onNext(Boolean.TRUE);
      return;
    }
    this.d.onNext(Boolean.FALSE);
  }
  
  private h4 k2(EnumCameraTransportType paramEnumCameraTransportType)
  {
    if (paramEnumCameraTransportType == null)
    {
      paramEnumCameraTransportType = this.a;
      if ((paramEnumCameraTransportType != null) && (paramEnumCameraTransportType.z0()) && (!this.a.T4())) {
        return this.a;
      }
      paramEnumCameraTransportType = this.b;
      if ((paramEnumCameraTransportType != null) && (paramEnumCameraTransportType.z0()))
      {
        paramEnumCameraTransportType = this.a;
        if ((paramEnumCameraTransportType != null) && (paramEnumCameraTransportType.T4())) {
          e2();
        }
        return this.b;
      }
      paramEnumCameraTransportType = this.c;
      if ((paramEnumCameraTransportType != null) && (paramEnumCameraTransportType.z0())) {
        return this.c;
      }
    }
    else if (paramEnumCameraTransportType == EnumCameraTransportType.LOCAL)
    {
      paramEnumCameraTransportType = this.a;
      if ((paramEnumCameraTransportType != null) && (paramEnumCameraTransportType.z0())) {
        return this.a;
      }
    }
    else if (paramEnumCameraTransportType == EnumCameraTransportType.REMOTE)
    {
      paramEnumCameraTransportType = this.b;
      if ((paramEnumCameraTransportType != null) && (paramEnumCameraTransportType.z0())) {
        return this.b;
      }
    }
    else if (paramEnumCameraTransportType == EnumCameraTransportType.IOT_REMOTE)
    {
      paramEnumCameraTransportType = this.c;
      if ((paramEnumCameraTransportType != null) && (paramEnumCameraTransportType.z0())) {
        return this.c;
      }
      paramEnumCameraTransportType = this.c;
      if (paramEnumCameraTransportType != null) {
        paramEnumCameraTransportType.o3(true);
      }
    }
    return null;
  }
  
  private io.reactivex.q<h4> v0(EnumCameraTransportType paramEnumCameraTransportType)
  {
    return this.d.Q0(1L).N(m1.c).l0(io.reactivex.l0.a.c()).g0(new t0(this, paramEnumCameraTransportType)).T0(30L, TimeUnit.SECONDS);
  }
  
  public io.reactivex.q<Response<AutoUpdateInfo>> A()
  {
    return v0(null).N(j.c);
  }
  
  public io.reactivex.q<Response<ImageFlip>> A0()
  {
    return v0(null).N(r.c);
  }
  
  public io.reactivex.q<Response> A2(ArmScheduleInfo paramArmScheduleInfo)
  {
    return v0(null).N(new y2(paramArmScheduleInfo));
  }
  
  public io.reactivex.q<Response<ClockTimezoneDstStatus>> B()
  {
    return v0(null).N(p3.c);
  }
  
  public io.reactivex.q<Response> B0(int paramInt)
  {
    return v0(null).N(new e0(paramInt));
  }
  
  public io.reactivex.q<Response> B2(boolean paramBoolean)
  {
    return v0(null).N(new t2(paramBoolean));
  }
  
  public io.reactivex.q<Response<ClockTimezoneInfo>> C()
  {
    return v0(null).N(z3.c);
  }
  
  public io.reactivex.q<Response> C2(String paramString)
  {
    return v0(EnumCameraTransportType.LOCAL).N(new q1(paramString));
  }
  
  public io.reactivex.q<Response<MarkedPositionListInfo>> D()
  {
    return v0(null).N(f3.c);
  }
  
  public io.reactivex.q<Response> D2(String paramString)
  {
    return v0(null).N(new v2(paramString));
  }
  
  public io.reactivex.q<Response<CameraComponent>> E()
  {
    return v0(null).N(d3.c);
  }
  
  public io.reactivex.q<Response> E2(LensMaskInfo paramLensMaskInfo)
  {
    return v0(null).N(new n0(paramLensMaskInfo));
  }
  
  public io.reactivex.q<Response<ConnectStatus>> F()
  {
    return v0(EnumCameraTransportType.LOCAL).N(g3.c);
  }
  
  public io.reactivex.q<Response> F2(LensMaskInfo paramLensMaskInfo)
  {
    return v0(null).N(new p2(paramLensMaskInfo));
  }
  
  public io.reactivex.q<Response<CoverConfigInfo>> G()
  {
    return v0(null).N(w3.c);
  }
  
  public io.reactivex.q<Response> G2(String paramString)
  {
    return v0(null).N(new m0(paramString));
  }
  
  public io.reactivex.q<Response<List<DailyPlaybackItem>>> H(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return v0(null).N(new j1(paramInt1, paramString, paramInt2, paramInt3));
  }
  
  public io.reactivex.q<Response> H2(DetectionInfo paramDetectionInfo)
  {
    return v0(null).N(new i0(paramDetectionInfo));
  }
  
  public io.reactivex.q<Response<List<DailyPlaybackItem>>> I(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    return v0(null).N(new i1(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3));
  }
  
  public io.reactivex.q<Response> I2(ArmScheduleInfo paramArmScheduleInfo)
  {
    return v0(null).N(new c2(paramArmScheduleInfo));
  }
  
  public io.reactivex.q<Response<DetectionSetting>> J(CameraComponent paramCameraComponent)
  {
    return v0(null).N(new d0(paramCameraComponent));
  }
  
  public io.reactivex.q<Response> J2(boolean paramBoolean)
  {
    return v0(null).N(new p0(paramBoolean));
  }
  
  public io.reactivex.q<Response<CameraInfo>> K()
  {
    return v0(null).N(l3.c);
  }
  
  public io.reactivex.q<Response> K2(MicroPhoneInfo paramMicroPhoneInfo)
  {
    return v0(null).N(new h1(paramMicroPhoneInfo));
  }
  
  public io.reactivex.q<Response<SystemInfo>> L()
  {
    return v0(null).N(b0.c);
  }
  
  public io.reactivex.q<Response> L2(MsgPushInfo paramMsgPushInfo)
  {
    return v0(null).N(new l0(paramMsgPushInfo));
  }
  
  public io.reactivex.q<Response<DiagnoseStatus>> M()
  {
    return v0(null).N(j3.c);
  }
  
  public io.reactivex.q<Response> M2(MsgPushPlanInfo paramMsgPushPlanInfo)
  {
    return v0(null).N(new x1(paramMsgPushPlanInfo));
  }
  
  public io.reactivex.q<Response<LatestFirmwareInfo>> N()
  {
    return v0(null).N(g.c);
  }
  
  public io.reactivex.q<Response> N2(NightMode paramNightMode)
  {
    return v0(null).N(new k2(paramNightMode));
  }
  
  public io.reactivex.q<Response<FirmwareUpdateStatus>> O()
  {
    return v0(null).N(q.c);
  }
  
  public io.reactivex.q<Response> O2(NightVisionMode paramNightVisionMode)
  {
    return v0(null).N(new u0(paramNightVisionMode));
  }
  
  public io.reactivex.q<Response<ImageFlip>> P()
  {
    return v0(null).N(e3.c);
  }
  
  public io.reactivex.q<Response> P2(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    return v0(null).N(new z2(paramBoolean1, paramBoolean2, paramString, paramBoolean3));
  }
  
  public io.reactivex.q<Response<HomePageDeviceInfo>> Q()
  {
    return v0(null).N(d.c);
  }
  
  public io.reactivex.q<Response> Q2(boolean paramBoolean)
  {
    return v0(null).N(new l2(paramBoolean));
  }
  
  public io.reactivex.q<Response<IntrusionDetectionInfo>> R()
  {
    return v0(null).N(k.c);
  }
  
  public io.reactivex.q<Response> R2(RebootInfo paramRebootInfo)
  {
    return v0(null).N(new h2(paramRebootInfo));
  }
  
  public io.reactivex.q<Response<List<Map<String, IntrusionDetectionRegion>>>> S()
  {
    return v0(null).N(q3.c);
  }
  
  public io.reactivex.q<Response> S2(boolean paramBoolean)
  {
    return v0(null).N(new g0(paramBoolean));
  }
  
  public io.reactivex.q<Response<Wan>> T()
  {
    return v0(null).N(z.c);
  }
  
  public io.reactivex.q<Response> T2(RecordPlanInfo paramRecordPlanInfo)
  {
    return v0(null).N(new r2(paramRecordPlanInfo));
  }
  
  public io.reactivex.q<Response<ImageFlip>> U()
  {
    return v0(null).N(n.c);
  }
  
  public io.reactivex.q<Response> U2(ResolutionType paramResolutionType)
  {
    return v0(null).N(new g1(paramResolutionType));
  }
  
  public io.reactivex.q<Response<AlarmMultiInfo>> V(CameraComponent paramCameraComponent)
  {
    return v0(null).N(new p1(paramCameraComponent));
  }
  
  public io.reactivex.q<Response> V2(SpeakerInfo paramSpeakerInfo)
  {
    return v0(null).N(new l1(paramSpeakerInfo));
  }
  
  public io.reactivex.q<Response<LensMaskInfo>> W()
  {
    return v0(null).N(e4.c);
  }
  
  public io.reactivex.q<Response> W2(TamperDetectConfig paramTamperDetectConfig)
  {
    return v0(null).N(new y0(paramTamperDetectConfig));
  }
  
  public io.reactivex.q<Response<Light>> X()
  {
    return v0(null).N(a.c);
  }
  
  public io.reactivex.q<Response> X2(boolean paramBoolean)
  {
    return v0(null).N(new g2(paramBoolean));
  }
  
  public io.reactivex.q<Response<LineCrossingDetectionInfo>> Y()
  {
    return v0(null).N(u3.c);
  }
  
  public io.reactivex.q<Response> Y2(String paramString1, String paramString2)
  {
    return v0(null).N(new q0(paramString1, paramString2));
  }
  
  public io.reactivex.q<Response<List<Map<String, LineCrossingDetectionRegion>>>> Z()
  {
    return v0(null).N(h3.c);
  }
  
  public io.reactivex.q<Response> Z2(UpnpCommStatus paramUpnpCommStatus)
  {
    return v0(null).N(new k0(paramUpnpCommStatus));
  }
  
  public io.reactivex.q<Response<List<YearlyPlaybackItem>>> a(Date paramDate1, Date paramDate2)
  {
    return v0(null).N(new w1(paramDate1, paramDate2));
  }
  
  public io.reactivex.q<Response<VideoQuality>> a0()
  {
    return v0(null).N(u.c);
  }
  
  public io.reactivex.q<Response> a3(UpnpInfo paramUpnpInfo)
  {
    return v0(null).N(new b1(paramUpnpInfo));
  }
  
  public io.reactivex.q<Response<MarkPositionConfirmInfo>> b(CloudTerracePoint paramCloudTerracePoint)
  {
    return v0(null).N(new e1(paramCloudTerracePoint));
  }
  
  public io.reactivex.q<Response<MotionDetectionInfo>> b0()
  {
    return v0(null).N(h.c);
  }
  
  public io.reactivex.q<Response> b3(WhiteLampConfig paramWhiteLampConfig)
  {
    return v0(null).N(new a1(paramWhiteLampConfig));
  }
  
  public io.reactivex.q<Response> c(List<CoverConfigRegion> paramList)
  {
    return v0(null).N(new a2(paramList));
  }
  
  public io.reactivex.q<Response<MsgPushInfo>> c0()
  {
    return v0(null).N(x3.c);
  }
  
  public io.reactivex.q<Response<BindStatus>> c3(Account paramAccount, String paramString1, String paramString2, String paramString3, RecordPlanInfo paramRecordPlanInfo)
  {
    return v0(null).N(new i2(paramAccount, paramString1, paramString2, paramString3, paramRecordPlanInfo));
  }
  
  public io.reactivex.q<Response> d(Map<String, List<IntrusionDetectionRegion>> paramMap)
  {
    return v0(null).N(new f2(paramMap));
  }
  
  public io.reactivex.q<Response<MsgPushPlanInfo>> d0()
  {
    return v0(null).N(n3.c);
  }
  
  public io.reactivex.q<String> d2(Account paramAccount)
  {
    return v0(EnumCameraTransportType.LOCAL).N(new w2(paramAccount));
  }
  
  public io.reactivex.q<Response<BindStatus>> d3(Account paramAccount, String paramString1, String paramString2, RecordPlanInfo paramRecordPlanInfo)
  {
    return v0(EnumCameraTransportType.LOCAL).N(new n2(paramAccount, paramString1, paramString2, paramRecordPlanInfo));
  }
  
  public io.reactivex.q<Response> e(Map<String, List<LineCrossingDetectionRegion>> paramMap)
  {
    return v0(null).N(new z1(paramMap));
  }
  
  public io.reactivex.q<Response<NetworkInfo>> e0()
  {
    return v0(null).N(y3.c);
  }
  
  public void e2()
  {
    if (!this.e.isOwner()) {
      return;
    }
    if ((this.e.getTcAccountContext() != null) && (this.e.getTcAccountContext().c() != null))
    {
      TCAccountBean localTCAccountBean = this.e.getTcAccountContext().c();
      Object localObject = this.b;
      if ((localObject != null) && (((h4)localObject).z0()))
      {
        localObject = this.b.i4();
        if (localObject != null)
        {
          ((com.tplink.libtpnetwork.cameranetwork.h4.p4.g)localObject).f(localTCAccountBean.getToken());
          ((com.tplink.libtpnetwork.cameranetwork.h4.p4.g)localObject).e(this.e.getTcAccountContext().e());
          this.b.k4((com.tplink.libtpnetwork.cameranetwork.h4.p4.g)localObject);
        }
        this.f = this.b.g("empty", localTCAccountBean.getPassword()).L0(io.reactivex.l0.a.c()).H0(new w0(this, localTCAccountBean), s0.c);
      }
    }
  }
  
  public io.reactivex.q<Response> e3()
  {
    return v0(EnumCameraTransportType.LOCAL).N(m.c);
  }
  
  public io.reactivex.q<Response> f(List<MotionDetectRegion> paramList)
  {
    return v0(null).N(new r1(paramList));
  }
  
  public io.reactivex.q<Response<OsdConfig>> f0(boolean paramBoolean)
  {
    return v0(null).N(new r0(paramBoolean));
  }
  
  public io.reactivex.q<Response> f2()
  {
    return v0(null).N(b.c);
  }
  
  public io.reactivex.q<Response> f3()
  {
    return v0(null).N(w.c);
  }
  
  public io.reactivex.q<Response> g(MotionDetectConfig paramMotionDetectConfig, AlarmInfo paramAlarmInfo, MsgPushInfo paramMsgPushInfo, DetectionInfo paramDetectionInfo1, DetectionInfo paramDetectionInfo2, TamperDetectConfig paramTamperDetectConfig, HumanRecognitionInfo paramHumanRecognitionInfo, BabyCryingDetectionInfo paramBabyCryingDetectionInfo, TargetTrackInfo paramTargetTrackInfo)
  {
    return v0(null).N(new z0(paramMotionDetectConfig, paramAlarmInfo, paramMsgPushInfo, paramDetectionInfo1, paramDetectionInfo2, paramTamperDetectConfig, paramHumanRecognitionInfo, paramBabyCryingDetectionInfo, paramTargetTrackInfo));
  }
  
  public io.reactivex.q<Response<P2PSharePwd>> g0()
  {
    return v0(null).N(c3.c);
  }
  
  public io.reactivex.q<Response> g2(CloudTerraceResetInfo paramCloudTerraceResetInfo)
  {
    return v0(null).N(new f0(paramCloudTerraceResetInfo));
  }
  
  public io.reactivex.q<Response> h(AlarmPlanInfo paramAlarmPlanInfo, MsgPushPlanInfo paramMsgPushPlanInfo, ArmScheduleInfo paramArmScheduleInfo1, ArmScheduleInfo paramArmScheduleInfo2)
  {
    return v0(null).N(new k1(paramAlarmPlanInfo, paramMsgPushPlanInfo, paramArmScheduleInfo1, paramArmScheduleInfo2));
  }
  
  public io.reactivex.q<Response<RebootInfo>> h0()
  {
    return v0(null).N(o3.c);
  }
  
  public io.reactivex.q<Response> h2()
  {
    return v0(null).N(i.c);
  }
  
  public void h3(@NonNull com.tplink.cloud.context.b paramb, @NonNull String paramString1, @NonNull String paramString2)
  {
    u(new com.tplink.libtpnetwork.cameranetwork.h4.p4.g(paramString2, paramString1, paramb.e(), paramb.c().getToken()));
  }
  
  public io.reactivex.q<Response> i(List<MotionDetectRegion> paramList, Map<String, List<IntrusionDetectionRegion>> paramMap, HashMap<String, List<LineCrossingDetectionRegion>> paramHashMap)
  {
    return v0(null).N(new o1(paramList, paramMap, paramHashMap));
  }
  
  public io.reactivex.q<Response<RecordAudioInfo>> i0()
  {
    return v0(null).N(f1.c);
  }
  
  public io.reactivex.q<Response> i2()
  {
    return v0(null).N(s.c);
  }
  
  public void i3(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice();
    com.tplink.cloud.context.b localb = paramTPCameraDeviceContext.getTcAccountContext();
    if (localALCameraDevice != null)
    {
      Object localObject1 = localALCameraDevice.getTdpCameraDevice();
      Object localObject2 = b.d.w.h.a.g(localb.c().getCloudUserName());
      if ((localObject1 != null) && (((String)localObject2).equalsIgnoreCase(((TDPIoTDevice)localObject1).getOwner())))
      {
        if (((TDPCameraDevice)localObject1).getHttpPort() <= 0) {
          ((TDPIoTDevice)localObject1).setHttpPort(443);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localb.c().getCloudUserName());
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(com.tplink.libtpnetwork.Utils.z.b(((BaseTDPDevice)localObject1).getMac()));
        localObject2 = ((StringBuilder)localObject2).toString();
        u(new com.tplink.libtpnetwork.cameranetwork.h4.o4.u(((BaseTDPDevice)localObject1).getIp(), ((TDPCameraDevice)localObject1).getHttpPort(), localb.c().getCloudUserName(), localb.c().getPassword(), b.d.w.h.a.g(((TDPCameraDevice)localObject1).getDeviceId()), (String)localObject2));
      }
      else
      {
        r(EnumCameraTransportType.LOCAL);
      }
      localObject1 = localALCameraDevice.getCloudCameraDevice();
      if ((localObject1 != null) && (((TCDeviceBean)localObject1).getAppServerUrl() != null) && (localALCameraDevice.getThingDevice() == null)) {
        u(new com.tplink.libtpnetwork.cameranetwork.h4.p4.g(((TCDeviceBean)localObject1).getAppServerUrl(), ((TCDeviceBean)localObject1).getDeviceId(), localb.e(), localb.c().getToken()));
      } else {
        r(EnumCameraTransportType.REMOTE);
      }
      if ((localALCameraDevice.getThingDevice() != null) && (localALCameraDevice.getThingDevice().getThingUrl() != null))
      {
        b.d.w.c.a.c("testcamera", "iot remote");
        u(new com.tplink.libtpnetwork.cameranetwork.h4.n4.d(localALCameraDevice.getDeviceId(), paramTPCameraDeviceContext));
      }
      else
      {
        r(EnumCameraTransportType.IOT_REMOTE);
      }
    }
  }
  
  public io.reactivex.q<Response> j(MotionDetectConfig paramMotionDetectConfig)
  {
    return v0(null).N(new d2(paramMotionDetectConfig));
  }
  
  public io.reactivex.q<Response<RecordPlanInfo>> j0()
  {
    return v0(null).N(f.c);
  }
  
  public io.reactivex.q<Response> j2()
  {
    return v0(EnumCameraTransportType.LOCAL).N(v.c);
  }
  
  public void j3(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    Object localObject1 = (ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice();
    paramTPCameraDeviceContext = paramTPCameraDeviceContext.getTcAccountContext();
    if ((localObject1 != null) && (((ALCameraDevice)localObject1).getTdpCameraDevice() != null))
    {
      localObject1 = ((ALCameraDevice)localObject1).getTdpCameraDevice();
      if (((TDPCameraDevice)localObject1).getHttpPort() <= 0) {
        ((TDPIoTDevice)localObject1).setHttpPort(443);
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramTPCameraDeviceContext.c().getCloudUserName());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(com.tplink.libtpnetwork.Utils.z.b(((BaseTDPDevice)localObject1).getMac()));
      localObject2 = ((StringBuilder)localObject2).toString();
      u(new com.tplink.libtpnetwork.cameranetwork.h4.o4.u(((BaseTDPDevice)localObject1).getIp(), ((TDPCameraDevice)localObject1).getHttpPort(), paramTPCameraDeviceContext.c().getCloudUserName(), paramTPCameraDeviceContext.c().getPassword(), b.d.w.h.a.g(((TDPCameraDevice)localObject1).getDeviceId()), (String)localObject2));
    }
  }
  
  public io.reactivex.q<Response> k(String paramString1, String paramString2)
  {
    return v0(null).N(new u2(paramString1, paramString2));
  }
  
  public io.reactivex.q<Response<SettingComposite>> k0()
  {
    return v0(null).N(t3.c);
  }
  
  public io.reactivex.q<Response> k3(String paramString1, String paramString2)
  {
    return v0(null).N(new j0(paramString1, paramString2));
  }
  
  public io.reactivex.q<Response<ResetSupportInfo>> l()
  {
    return v0(EnumCameraTransportType.LOCAL).N(i3.c);
  }
  
  public io.reactivex.q<Response<SdCardFormatProgress>> l0()
  {
    return v0(null).N(s3.c);
  }
  
  public io.reactivex.q<Response<WifiList>> l2()
  {
    return v0(EnumCameraTransportType.LOCAL).N(v3.c);
  }
  
  public io.reactivex.q<Response> m(boolean paramBoolean)
  {
    return v0(null).N(new y1(paramBoolean));
  }
  
  public io.reactivex.q<Response<SettingComposite>> m0()
  {
    return v0(null).N(y.c);
  }
  
  public io.reactivex.q<Response> m2(AlarmInfo paramAlarmInfo)
  {
    return v0(null).N(new c1(paramAlarmInfo));
  }
  
  public io.reactivex.q<Response> n()
  {
    return v0(null).N(t.c);
  }
  
  public io.reactivex.q<Response<ServiceList>> n0()
  {
    return v0(null).N(a4.c);
  }
  
  public io.reactivex.q<Response> n2(AlarmPlanInfo paramAlarmPlanInfo)
  {
    return v0(null).N(new b2(paramAlarmPlanInfo));
  }
  
  public io.reactivex.q<Response> o(CloudTerraceMoveInfo paramCloudTerraceMoveInfo)
  {
    return v0(null).N(new j2(paramCloudTerraceMoveInfo));
  }
  
  public io.reactivex.q<Response<SettingComposite>> o0(CameraComponent paramCameraComponent)
  {
    return v0(null).N(new b3(paramCameraComponent));
  }
  
  public io.reactivex.q<Response> o2(AutoUpdateInfo paramAutoUpdateInfo)
  {
    return v0(null).N(new q2(paramAutoUpdateInfo));
  }
  
  public io.reactivex.q<Response> p(String paramString)
  {
    return v0(null).N(new o0(paramString));
  }
  
  public io.reactivex.q<Response<SettingCompositeV2>> p0(CameraComponent paramCameraComponent)
  {
    return v0(null).N(new t1(paramCameraComponent));
  }
  
  public io.reactivex.q<Response> p2(boolean paramBoolean, String paramString)
  {
    return v0(null).N(new a3(paramBoolean, paramString));
  }
  
  public io.reactivex.q<Response<ConnectResult>> q(Wifi paramWifi)
  {
    return v0(EnumCameraTransportType.LOCAL).N(new x2(paramWifi));
  }
  
  public io.reactivex.q<Response<DetectionList>> q0(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return v0(null).N(new v1(paramLong1, paramLong2, paramInt1, paramInt2));
  }
  
  public io.reactivex.q<Response> q2(String paramString)
  {
    return v0(EnumCameraTransportType.LOCAL).N(new m2(paramString));
  }
  
  public void r(EnumCameraTransportType paramEnumCameraTransportType)
  {
    if (paramEnumCameraTransportType == null) {
      return;
    }
    int i = a.a[paramEnumCameraTransportType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          paramEnumCameraTransportType = this.c;
          if (paramEnumCameraTransportType != null) {
            paramEnumCameraTransportType.o3(false);
          }
        }
      }
      else
      {
        paramEnumCameraTransportType = this.b;
        if (paramEnumCameraTransportType != null) {
          paramEnumCameraTransportType.o3(false);
        }
      }
    }
    else
    {
      paramEnumCameraTransportType = this.a;
      if (paramEnumCameraTransportType != null) {
        paramEnumCameraTransportType.o3(false);
      }
    }
    g3();
  }
  
  public io.reactivex.q<Response<TamperDetectConfig>> r0()
  {
    return v0(null).N(l.c);
  }
  
  public io.reactivex.q<Response> r2(boolean paramBoolean)
  {
    return v0(null).N(new d1(paramBoolean));
  }
  
  public io.reactivex.q<Response<StartUpdateFirmwareInfo>> s()
  {
    return v0(null).N(c.c);
  }
  
  public io.reactivex.q<Response<TargetTrackInfo>> s0()
  {
    return v0(null).N(d4.c);
  }
  
  public io.reactivex.q<Response> s2(String paramString)
  {
    return v0(null).N(new h0(paramString));
  }
  
  public io.reactivex.q<ResponseBody> t()
  {
    return v0(EnumCameraTransportType.LOCAL).N(s1.c);
  }
  
  public io.reactivex.q<Response<AccountInfo>> t0()
  {
    return v0(null).N(k3.c);
  }
  
  public io.reactivex.q<Response> t2(String paramString1, String paramString2)
  {
    return v0(null).N(new o2(paramString1, paramString2));
  }
  
  public void u(i4 parami4)
  {
    if (parami4 == null) {
      return;
    }
    Object localObject;
    if ((parami4 instanceof com.tplink.libtpnetwork.cameranetwork.h4.o4.u))
    {
      localObject = this.a;
      if (localObject == null) {
        this.a = new com.tplink.libtpnetwork.cameranetwork.h4.o4.s((com.tplink.libtpnetwork.cameranetwork.h4.o4.u)parami4);
      } else {
        ((com.tplink.libtpnetwork.cameranetwork.h4.o4.s)localObject).W4((com.tplink.libtpnetwork.cameranetwork.h4.o4.u)parami4);
      }
      this.a.o3(true);
    }
    else if ((parami4 instanceof com.tplink.libtpnetwork.cameranetwork.h4.p4.g))
    {
      localObject = this.b;
      if (localObject == null) {
        this.b = new com.tplink.libtpnetwork.cameranetwork.h4.p4.e((com.tplink.libtpnetwork.cameranetwork.h4.p4.g)parami4);
      } else {
        ((com.tplink.libtpnetwork.cameranetwork.h4.p4.e)localObject).k4((com.tplink.libtpnetwork.cameranetwork.h4.p4.g)parami4);
      }
      this.b.o3(true);
    }
    else if ((parami4 instanceof com.tplink.libtpnetwork.cameranetwork.h4.n4.d))
    {
      localObject = this.c;
      if (localObject == null) {
        this.c = new com.tplink.libtpnetwork.cameranetwork.h4.n4.b((com.tplink.libtpnetwork.cameranetwork.h4.n4.d)parami4);
      } else {
        ((com.tplink.libtpnetwork.cameranetwork.h4.n4.b)localObject).h4((com.tplink.libtpnetwork.cameranetwork.h4.n4.d)parami4);
      }
      this.c.o3(true);
    }
    g3();
  }
  
  public io.reactivex.q<Response<Timezone>> u0()
  {
    return v0(null).N(o.c);
  }
  
  public io.reactivex.q<Response> u2(String paramString)
  {
    return v0(null).N(new v0(paramString));
  }
  
  public io.reactivex.q<Response> v()
  {
    return v0(null).N(r3.c);
  }
  
  public io.reactivex.q<Response> v2(boolean paramBoolean)
  {
    return v0(null).N(new u1(paramBoolean));
  }
  
  public io.reactivex.q<Response<AESEncryptKey>> w()
  {
    return v0(null).N(c4.c);
  }
  
  public io.reactivex.q<Response<UpnpInfo>> w0()
  {
    return v0(null).N(p.c);
  }
  
  public io.reactivex.q<Response> w2(WhitelampState paramWhitelampState)
  {
    return v0(null).N(new n1(paramWhitelampState));
  }
  
  public io.reactivex.q<Response<AlarmInfo>> x()
  {
    return v0(null).N(x.c);
  }
  
  public io.reactivex.q<Response<UpnpMultiInfo>> x0()
  {
    return v0(null).N(m3.c);
  }
  
  public io.reactivex.q<Response> x2(boolean paramBoolean)
  {
    return v0(null).N(new x0(paramBoolean));
  }
  
  public io.reactivex.q<Response<AlarmPlanInfo>> y()
  {
    return v0(null).N(a0.c);
  }
  
  public io.reactivex.q<Response<UpnpPsk>> y0()
  {
    return v0(null).N(c0.c);
  }
  
  public io.reactivex.q<Response> y2(boolean paramBoolean)
  {
    return v0(null).N(new e2(paramBoolean));
  }
  
  public io.reactivex.q<Response<AudioInfo>> z()
  {
    return v0(null).N(b4.c);
  }
  
  public io.reactivex.q<Response<VodUserId>> z0()
  {
    return v0(null).N(e.c);
  }
  
  public io.reactivex.q<Response> z2(DetectionInfo paramDetectionInfo)
  {
    return v0(null).N(new s2(paramDetectionInfo));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\f4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */