package com.tplink.libtpnetwork.cameranetwork.h4;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
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
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.NetworkInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.OsdConfig;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordAudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
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
import com.tplink.libtpnetwork.cameranetwork.model.Wrapper;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackItem;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class h4
  implements com.tplink.libtpnetwork.cameranetwork.net.a
{
  protected boolean a;
  @NonNull
  protected final l4 b = new l4();
  
  public io.reactivex.q<Response<ClockTimezoneInfo>> A()
  {
    return c3(this.b.M()).Z0().n().g0(f2.c);
  }
  
  public io.reactivex.q<Response> A3(ArmScheduleInfo paramArmScheduleInfo)
  {
    return c3(this.b.k1(paramArmScheduleInfo)).Q0(1L).g0(x0.c);
  }
  
  public io.reactivex.q<Response<MarkedPositionListInfo>> B()
  {
    return c3(this.b.N()).Q0(1L).g0(n.c);
  }
  
  public io.reactivex.q<Response> B3(boolean paramBoolean)
  {
    return c3(this.b.m1(paramBoolean)).Q0(1L).g0(z.c);
  }
  
  public io.reactivex.q<Response<CameraComponent>> C()
  {
    return c3(this.b.O()).Q0(1L).g0(d1.c);
  }
  
  public io.reactivex.q<Response> C3(String paramString)
  {
    return e3(this.b.l1(paramString)).g0(i1.c);
  }
  
  public io.reactivex.q<Response<ConnectStatus>> D()
  {
    return e3(this.b.P()).g0(w.c);
  }
  
  public io.reactivex.q<Response> D3(String paramString)
  {
    return c3(this.b.n1(paramString)).Q0(1L).g0(l0.c);
  }
  
  public io.reactivex.q<Response<CoverConfigInfo>> E()
  {
    return c3(this.b.Q()).Q0(1L).g0(w3.c);
  }
  
  public io.reactivex.q<Response> E3(LensMaskInfo paramLensMaskInfo)
  {
    return c3(this.b.o1(paramLensMaskInfo)).Q0(1L).g0(d0.c);
  }
  
  public io.reactivex.q<Response<List<DailyPlaybackItem>>> F(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return c3(this.b.R(paramInt1, paramString, paramInt2, paramInt3)).Q0(1L).g0(f.c);
  }
  
  public io.reactivex.q<Response> F3(LensMaskInfo paramLensMaskInfo)
  {
    return c3(this.b.p1(paramLensMaskInfo)).Q0(1L).g0(q2.c);
  }
  
  public io.reactivex.q<Response<List<DailyPlaybackItem>>> G(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    return c3(this.b.S(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3)).Q0(1L).g0(t2.c);
  }
  
  public io.reactivex.q<Response> G3(String paramString)
  {
    return c3(this.b.q1(paramString)).Q0(1L).g0(o3.c);
  }
  
  public io.reactivex.q<Response<DetectionSetting>> H(CameraComponent paramCameraComponent)
  {
    return d3(this.b.T(paramCameraComponent)).g0(r2.c);
  }
  
  public io.reactivex.q<Response> H3(DetectionInfo paramDetectionInfo)
  {
    return c3(this.b.r1(paramDetectionInfo)).Q0(1L).g0(f3.c);
  }
  
  public io.reactivex.q<Response<CameraInfo>> I()
  {
    return c3(this.b.U()).Q0(1L).g0(i.c);
  }
  
  public io.reactivex.q<Response> I3(ArmScheduleInfo paramArmScheduleInfo)
  {
    return c3(this.b.s1(paramArmScheduleInfo)).Q0(1L).g0(f0.c);
  }
  
  public io.reactivex.q<Response<SystemInfo>> J()
  {
    return c3(this.b.V()).Q0(1L).g0(j1.c);
  }
  
  public io.reactivex.q<Response> J3(boolean paramBoolean)
  {
    return c3(this.b.t1(paramBoolean)).Q0(1L).g0(d3.c);
  }
  
  public io.reactivex.q<Response<DiagnoseStatus>> K()
  {
    return c3(this.b.s()).Q0(1L).g0(k1.c);
  }
  
  public io.reactivex.q<Response> K3(MicroPhoneInfo paramMicroPhoneInfo)
  {
    return c3(this.b.u1(paramMicroPhoneInfo)).Q0(1L).g0(i3.c);
  }
  
  public io.reactivex.q<Response<LatestFirmwareInfo>> L()
  {
    return c3(this.b.W()).g0(b4.c).L(h3.c);
  }
  
  public io.reactivex.q<Response> L3(MsgPushInfo paramMsgPushInfo)
  {
    return c3(this.b.v1(paramMsgPushInfo)).Q0(1L).g0(m.c);
  }
  
  public io.reactivex.q<Response<FirmwareUpdateStatus>> M()
  {
    return c3(this.b.X()).Q0(1L).g0(i0.c);
  }
  
  public io.reactivex.q<Response> M3(MsgPushPlanInfo paramMsgPushPlanInfo)
  {
    return c3(this.b.w1(paramMsgPushPlanInfo)).Q0(1L).g0(g3.c);
  }
  
  public io.reactivex.q<Response<ImageFlip>> N()
  {
    return c3(this.b.Y()).Q0(1L).g0(u2.c);
  }
  
  public io.reactivex.q<Response> N3(NightMode paramNightMode)
  {
    return c3(this.b.x1(paramNightMode)).Q0(1L).g0(t1.c);
  }
  
  public io.reactivex.q<Response<HomePageDeviceInfo>> O()
  {
    return d3(this.b.Z()).g0(r0.c);
  }
  
  public io.reactivex.q<Response> O3(NightVisionMode paramNightVisionMode)
  {
    return c3(this.b.y1(paramNightVisionMode)).Q0(1L).g0(y2.c);
  }
  
  public io.reactivex.q<Response<IntrusionDetectionInfo>> P()
  {
    return c3(this.b.a0()).Q0(1L).g0(p1.c);
  }
  
  public io.reactivex.q<Response> P3(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    return c3(this.b.z1(paramBoolean1, paramBoolean2, paramString, paramBoolean3)).Q0(1L).g0(k2.c);
  }
  
  public io.reactivex.q<Response<List<Map<String, IntrusionDetectionRegion>>>> Q()
  {
    return c3(this.b.b0()).Q0(1L).g0(t.c);
  }
  
  public io.reactivex.q<Response> Q3(boolean paramBoolean)
  {
    return c3(this.b.A1(paramBoolean)).Q0(1L).g0(o2.c);
  }
  
  public io.reactivex.q<Response<Wan>> R()
  {
    return c3(this.b.c0()).Q0(1L).g0(x3.c);
  }
  
  public io.reactivex.q<Response> R3(RebootInfo paramRebootInfo)
  {
    return c3(this.b.B1(paramRebootInfo)).Q0(1L).g0(e0.c);
  }
  
  public io.reactivex.q<Response<ImageFlip>> S()
  {
    return c3(this.b.e0()).Q0(1L).g0(o.c);
  }
  
  public io.reactivex.q<Response> S3(boolean paramBoolean)
  {
    return c3(this.b.C1(paramBoolean)).Q0(1L).g0(c0.c);
  }
  
  public io.reactivex.q<Response<AlarmMultiInfo>> T(CameraComponent paramCameraComponent)
  {
    return d3(this.b.d0(paramCameraComponent)).g0(m3.c);
  }
  
  public io.reactivex.q<Response> T3(RecordPlanInfo paramRecordPlanInfo)
  {
    return c3(this.b.D1(paramRecordPlanInfo)).Q0(1L).g0(t3.c);
  }
  
  public io.reactivex.q<Response<LensMaskInfo>> U()
  {
    return c3(this.b.f0()).Q0(1L).g0(s1.c);
  }
  
  public io.reactivex.q<Response> U3(ResolutionType paramResolutionType)
  {
    return c3(this.b.E1(paramResolutionType)).Q0(1L).g0(a2.c);
  }
  
  public io.reactivex.q<Response<Light>> V()
  {
    return c3(this.b.g0()).Q0(1L).g0(x.c);
  }
  
  public io.reactivex.q<Response> V3(SpeakerInfo paramSpeakerInfo)
  {
    return c3(this.b.F1(paramSpeakerInfo)).Q0(1L).g0(q1.c);
  }
  
  public io.reactivex.q<Response<LineCrossingDetectionInfo>> W()
  {
    return c3(this.b.h0()).Q0(1L).g0(b2.c);
  }
  
  public io.reactivex.q<Response> W3(TamperDetectConfig paramTamperDetectConfig)
  {
    return c3(this.b.G1(paramTamperDetectConfig)).Q0(1L).g0(q0.c);
  }
  
  public io.reactivex.q<Response<List<Map<String, LineCrossingDetectionRegion>>>> X()
  {
    return c3(this.b.i0()).Q0(1L).g0(h.c);
  }
  
  public io.reactivex.q<Response> X3(boolean paramBoolean)
  {
    return c3(this.b.H1(paramBoolean)).g0(u3.c);
  }
  
  public io.reactivex.q<Response<VideoQuality>> Y()
  {
    return c3(this.b.j0()).Q0(1L).g0(y.c);
  }
  
  public io.reactivex.q<Response> Y3(String paramString1, String paramString2)
  {
    return c3(this.b.I1(paramString1, paramString2)).Q0(1L).g0(z0.c);
  }
  
  public io.reactivex.q<Response<MotionDetectionInfo>> Z()
  {
    return c3(this.b.k0()).Q0(1L).g0(g0.c);
  }
  
  public io.reactivex.q<Response> Z3(UpnpCommStatus paramUpnpCommStatus)
  {
    return c3(this.b.J1(paramUpnpCommStatus)).Q0(1L).g0(z1.c);
  }
  
  public io.reactivex.q<Response<List<YearlyPlaybackItem>>> a(Date paramDate1, Date paramDate2)
  {
    return c3(this.b.M0(paramDate1, paramDate2)).Q0(1L).g0(p.c);
  }
  
  public io.reactivex.q<Response<MsgPushInfo>> a0()
  {
    return c3(this.b.l0()).Q0(1L).g0(e3.c);
  }
  
  public io.reactivex.q<Response> a4(UpnpInfo paramUpnpInfo)
  {
    return c3(this.b.K1(paramUpnpInfo)).Q0(1L).g0(s.c);
  }
  
  public io.reactivex.q<Response<MarkPositionConfirmInfo>> b(CloudTerracePoint paramCloudTerracePoint)
  {
    return c3(this.b.w(paramCloudTerracePoint)).Q0(1L).g0(l.c);
  }
  
  public io.reactivex.q<Response<MsgPushPlanInfo>> b0()
  {
    return c3(this.b.m0()).Q0(1L).g0(s3.c);
  }
  
  public io.reactivex.q<Response> b4(WhiteLampConfig paramWhiteLampConfig)
  {
    return c3(this.b.L1(paramWhiteLampConfig)).Q0(1L).g0(z2.c);
  }
  
  public io.reactivex.q<Response> c(List<CoverConfigRegion> paramList)
  {
    return c3(this.b.l(paramList)).Q0(1L).g0(r1.c);
  }
  
  public io.reactivex.q<Response<NetworkInfo>> c0()
  {
    return c3(this.b.n0()).Q0(1L).g0(r.c);
  }
  
  protected abstract io.reactivex.q<Response<Wrappers>> c3(Request<MultipleRequest> paramRequest);
  
  public io.reactivex.q<Response<BindStatus>> c4(Account paramAccount, String paramString1, String paramString2, String paramString3, RecordPlanInfo paramRecordPlanInfo)
  {
    return c3(this.b.M1(paramAccount, paramString1, paramString2, paramString3, paramRecordPlanInfo)).g0(a4.c);
  }
  
  public io.reactivex.q<Response> d(Map<String, List<IntrusionDetectionRegion>> paramMap)
  {
    return c3(this.b.m(paramMap)).Q0(1L).g0(l3.c);
  }
  
  public io.reactivex.q<Response<OsdConfig>> d0(boolean paramBoolean)
  {
    return c3(this.b.o0(paramBoolean)).Q0(1L).g0(v2.c);
  }
  
  protected abstract io.reactivex.q<Response<MultipleResponse>> d3(Request<MultipleRequest> paramRequest);
  
  public io.reactivex.q<Response<BindStatus>> d4(Account paramAccount, String paramString1, String paramString2, RecordPlanInfo paramRecordPlanInfo)
  {
    return c3(this.b.N1(paramAccount, paramString1, paramString2, paramRecordPlanInfo)).g0(a3.c);
  }
  
  public io.reactivex.q<Response> e(Map<String, List<LineCrossingDetectionRegion>> paramMap)
  {
    return c3(this.b.n(paramMap)).Q0(1L).g0(y0.c);
  }
  
  public io.reactivex.q<Response<P2PSharePwd>> e0()
  {
    return c3(this.b.p0()).Q0(1L).g0(d.c);
  }
  
  protected abstract io.reactivex.q<Response<Wrappers>> e3(Request paramRequest);
  
  public io.reactivex.q<Response> e4()
  {
    return c3(this.b.O1()).Q0(1L).g0(x2.c);
  }
  
  public io.reactivex.q<Response> f(List<MotionDetectRegion> paramList)
  {
    return c3(this.b.o(paramList)).Q0(1L).g0(c1.c);
  }
  
  public io.reactivex.q<Response<RebootInfo>> f0()
  {
    return c3(this.b.q0()).Q0(1L).g0(m0.c);
  }
  
  public io.reactivex.q<Response> f3()
  {
    return c3(this.b.R0()).Q0(1L).g0(e2.c);
  }
  
  public io.reactivex.q<Response> f4()
  {
    return c3(this.b.R1()).Q0(1L).g0(h2.c);
  }
  
  public io.reactivex.q<Response<?>> g(String paramString1, String paramString2)
  {
    return c3(this.b.p(paramString1, paramString2)).Q0(1L).g0(v.c);
  }
  
  public io.reactivex.q<Response<RecordAudioInfo>> g0()
  {
    return c3(this.b.r0()).Q0(1L).g0(l1.c);
  }
  
  public io.reactivex.q<Response> g3(CloudTerraceResetInfo paramCloudTerraceResetInfo)
  {
    return c3(this.b.C(paramCloudTerraceResetInfo)).Q0(1L).g0(v1.c);
  }
  
  public io.reactivex.q<Response> g4(String paramString1, String paramString2)
  {
    return c3(this.b.S1(paramString1, paramString2)).Q0(1L).g0(v0.c);
  }
  
  @SuppressLint({"CheckResult"})
  public io.reactivex.q<Response> h(MotionDetectConfig paramMotionDetectConfig, AlarmInfo paramAlarmInfo, MsgPushInfo paramMsgPushInfo, DetectionInfo paramDetectionInfo1, DetectionInfo paramDetectionInfo2, TamperDetectConfig paramTamperDetectConfig, HumanRecognitionInfo paramHumanRecognitionInfo, BabyCryingDetectionInfo paramBabyCryingDetectionInfo, TargetTrackInfo paramTargetTrackInfo)
  {
    paramAlarmInfo = this.b.t0(paramMotionDetectConfig, paramAlarmInfo, paramMsgPushInfo, paramDetectionInfo1, paramDetectionInfo2, paramTamperDetectConfig, paramHumanRecognitionInfo, paramBabyCryingDetectionInfo, paramTargetTrackInfo);
    int i = paramAlarmInfo.size();
    if (i <= 5) {
      return c3(this.b.Q0(paramAlarmInfo)).g0(p0.c);
    }
    paramMotionDetectConfig = this.b.Q0(paramAlarmInfo.subList(0, 5));
    paramAlarmInfo = this.b.Q0(paramAlarmInfo.subList(5, i));
    return io.reactivex.q.f1(c3(paramMotionDetectConfig).g0(p2.c), c3(paramAlarmInfo).g0(m1.c), new a());
  }
  
  public io.reactivex.q<Response<RecordPlanInfo>> h0()
  {
    return c3(this.b.s0()).Q0(1L).g0(c.c);
  }
  
  public io.reactivex.q<Response> h3()
  {
    return c3(this.b.S0()).Q0(1L).g0(n3.c);
  }
  
  public io.reactivex.q<Response> i(AlarmPlanInfo paramAlarmPlanInfo, MsgPushPlanInfo paramMsgPushPlanInfo, ArmScheduleInfo paramArmScheduleInfo1, ArmScheduleInfo paramArmScheduleInfo2)
  {
    return c3(this.b.u0(paramAlarmPlanInfo, paramMsgPushPlanInfo, paramArmScheduleInfo1, paramArmScheduleInfo2)).g0(s2.c);
  }
  
  public io.reactivex.q<Response<SettingComposite>> i0()
  {
    return d3(this.b.w0()).g0(c3.c);
  }
  
  public io.reactivex.q<Response> i3()
  {
    return c3(this.b.B()).Q0(1L).g0(f1.c);
  }
  
  public io.reactivex.q<Response> j(List<MotionDetectRegion> paramList, Map<String, List<IntrusionDetectionRegion>> paramMap, HashMap<String, List<LineCrossingDetectionRegion>> paramHashMap)
  {
    return c3(this.b.v0(paramList, paramMap, paramHashMap)).g0(y3.c);
  }
  
  public io.reactivex.q<Response<SdCardFormatProgress>> j0()
  {
    return c3(this.b.x0()).Q0(1L).g0(m2.c);
  }
  
  public io.reactivex.q<Response> j3()
  {
    return c3(this.b.T0()).Q0(1L).g0(s0.c);
  }
  
  public io.reactivex.q<Response> k(MotionDetectConfig paramMotionDetectConfig)
  {
    return c3(this.b.q(paramMotionDetectConfig)).Q0(1L).g0(n2.c);
  }
  
  public io.reactivex.q<Response<SettingComposite>> k0()
  {
    return d3(this.b.y0()).g0(b1.c);
  }
  
  public io.reactivex.q<Response<WifiList>> k3()
  {
    return e3(this.b.U0()).g0(d2.c);
  }
  
  public io.reactivex.q<Response> l(String paramString1, String paramString2)
  {
    return c3(this.b.r(paramString1, paramString2)).Q0(1L).g0(j.c);
  }
  
  public io.reactivex.q<Response<ServiceList>> l0()
  {
    return c3(this.b.z0()).Q0(1L).g0(j0.c);
  }
  
  public io.reactivex.q<Response> l3(AlarmInfo paramAlarmInfo)
  {
    return c3(this.b.V0(paramAlarmInfo)).Q0(1L).g0(h0.c);
  }
  
  public io.reactivex.q<Response<ResetSupportInfo>> m()
  {
    return c3(this.b.t()).Q0(1L).g0(j2.c);
  }
  
  public io.reactivex.q<Response<SettingComposite>> m0(CameraComponent paramCameraComponent)
  {
    return d3(this.b.A0(paramCameraComponent)).g0(o1.c);
  }
  
  public io.reactivex.q<Response> m3(AlarmPlanInfo paramAlarmPlanInfo)
  {
    return c3(this.b.W0(paramAlarmPlanInfo)).Q0(1L).g0(y1.c);
  }
  
  public io.reactivex.q<Response> n(boolean paramBoolean)
  {
    return c3(this.b.x(paramBoolean)).Q0(1L).g0(k.c);
  }
  
  public io.reactivex.q<Response<SettingCompositeV2>> n0(CameraComponent paramCameraComponent)
  {
    return d3(this.b.B0(paramCameraComponent)).g0(q3.c);
  }
  
  public io.reactivex.q<Response> n3(AutoUpdateInfo paramAutoUpdateInfo)
  {
    return c3(this.b.X0(paramAutoUpdateInfo)).Q0(1L).g0(a1.c);
  }
  
  public io.reactivex.q<Response> o()
  {
    return c3(this.b.Q1()).Q0(1L).g0(w2.c);
  }
  
  public io.reactivex.q<Response<DetectionList>> o0(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return c3(this.b.C0(paramLong1, paramLong2, paramInt1, paramInt2)).Q0(1L).g0(x1.c);
  }
  
  public void o3(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public io.reactivex.q<Response> p(CloudTerraceMoveInfo paramCloudTerraceMoveInfo)
  {
    return c3(this.b.y(paramCloudTerraceMoveInfo)).Q0(1L).g0(u0.c);
  }
  
  public io.reactivex.q<Response<TamperDetectConfig>> p0()
  {
    return c3(this.b.D0()).Q0(1L).g0(z3.c);
  }
  
  public io.reactivex.q<Response> p3(boolean paramBoolean, String paramString)
  {
    return c3(this.b.Y0(paramBoolean, paramString)).g0(l2.c);
  }
  
  public io.reactivex.q<Response> q(String paramString)
  {
    return c3(this.b.z(paramString)).Q0(1L).g0(c2.c);
  }
  
  public io.reactivex.q<Response<TargetTrackInfo>> q0()
  {
    return c3(this.b.E0()).Q0(1L).g0(a0.c);
  }
  
  public io.reactivex.q<Response> q3(String paramString)
  {
    return e3(this.b.Z0(paramString)).g0(a.c);
  }
  
  public io.reactivex.q<Response<ConnectResult>> r(Wifi paramWifi)
  {
    return e3(this.b.v(paramWifi)).g0(p3.c);
  }
  
  public io.reactivex.q<Response<AccountInfo>> r0()
  {
    return c3(this.b.F0()).Q0(1L).g0(g1.c);
  }
  
  public io.reactivex.q<Response> r3(boolean paramBoolean)
  {
    return c3(this.b.b1(paramBoolean)).Q0(1L).g0(w0.c);
  }
  
  public io.reactivex.q<Response<StartUpdateFirmwareInfo>> s()
  {
    return c3(this.b.P1()).Q0(1L).g0(k3.c);
  }
  
  public io.reactivex.q<Response<Timezone>> s0()
  {
    return c3(this.b.G0()).Q0(1L).g0(b0.c);
  }
  
  public io.reactivex.q<Response> s3(String paramString)
  {
    return c3(this.b.c1(paramString)).Q0(1L).g0(h1.c);
  }
  
  public io.reactivex.q<Response> t()
  {
    return c3(this.b.D()).Q0(1L).g0(q.c);
  }
  
  public io.reactivex.q<Response<UpnpInfo>> t0()
  {
    return c3(this.b.H0()).Q0(1L).g0(g2.c);
  }
  
  public io.reactivex.q<Response> t3(String paramString1, String paramString2)
  {
    return c3(this.b.d1(paramString1, paramString2)).g0(j3.c);
  }
  
  public io.reactivex.q<Response<AESEncryptKey>> u()
  {
    return c3(this.b.G()).Q0(1L).g0(t0.c);
  }
  
  public io.reactivex.q<Response<UpnpMultiInfo>> u0()
  {
    return d3(this.b.I0()).g0(o0.c);
  }
  
  public io.reactivex.q<Response> u3(String paramString)
  {
    return c3(this.b.e1(paramString)).Q0(1L).g0(k0.c);
  }
  
  public io.reactivex.q<Response<AlarmInfo>> v()
  {
    return c3(this.b.I()).Q0(1L).g0(r3.c);
  }
  
  public io.reactivex.q<Response<UpnpPsk>> v0()
  {
    return c3(this.b.J0()).Q0(1L).g0(new b());
  }
  
  public io.reactivex.q<Response> v3(boolean paramBoolean)
  {
    return c3(this.b.f1(paramBoolean)).Q0(1L).g0(b3.c);
  }
  
  public io.reactivex.q<Response<AlarmPlanInfo>> w()
  {
    return c3(this.b.H()).Q0(1L).g0(g.c);
  }
  
  public io.reactivex.q<Response<VodUserId>> w0()
  {
    return c3(this.b.K0()).Q0(1L).g0(v3.c);
  }
  
  public io.reactivex.q<Response> w3(WhitelampState paramWhitelampState)
  {
    return c3(this.b.g1(paramWhitelampState)).Q0(1L).g0(e1.c);
  }
  
  public io.reactivex.q<Response<AudioInfo>> x()
  {
    return c3(this.b.J()).Q0(1L).g0(n1.c);
  }
  
  public io.reactivex.q<Response<ImageFlip>> x0()
  {
    return c3(this.b.L0()).Q0(1L).g0(u1.c);
  }
  
  public io.reactivex.q<Response> x3(boolean paramBoolean)
  {
    return c3(this.b.h1(paramBoolean)).g0(w1.c);
  }
  
  public io.reactivex.q<Response<AutoUpdateInfo>> y()
  {
    return c3(this.b.K()).Q0(1L).g0(i2.c);
  }
  
  public io.reactivex.q<Response> y0(int paramInt)
  {
    return c3(this.b.A(paramInt)).Q0(1L).g0(n0.c);
  }
  
  public io.reactivex.q<Response> y3(boolean paramBoolean)
  {
    return c3(this.b.i1(paramBoolean)).Q0(1L).g0(e.c);
  }
  
  public io.reactivex.q<Response<ClockTimezoneDstStatus>> z()
  {
    return c3(this.b.L()).Z0().n().g0(b.c);
  }
  
  public boolean z0()
  {
    return this.a;
  }
  
  public io.reactivex.q<Response> z3(DetectionInfo paramDetectionInfo)
  {
    return c3(this.b.j1(paramDetectionInfo)).Q0(1L).g0(u.c);
  }
  
  class a
    implements io.reactivex.g0.c<Response, Response, Response>
  {
    a() {}
    
    public Response a(Response paramResponse1, Response paramResponse2)
      throws Exception
    {
      return paramResponse2;
    }
  }
  
  class b
    implements io.reactivex.g0.j<Response<Wrappers>, Response<UpnpPsk>>
  {
    b() {}
    
    public Response<UpnpPsk> a(@NonNull Response<Wrappers> paramResponse)
      throws Exception
    {
      if ((paramResponse.getResult() != null) && (((Wrappers)paramResponse.getResult()).getWrapperList().size() > 0) && (((Wrapper)((Wrappers)paramResponse.getResult()).getWrapperList().get(0)).getData() != null)) {
        return new Response(paramResponse.getErrorCode(), paramResponse.getMethod(), com.tplink.libtpnetwork.Utils.i.b(((Wrapper)((Wrappers)paramResponse.getResult()).getWrapperList().get(0)).getData().toString(), UpnpPsk.class));
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\h4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */