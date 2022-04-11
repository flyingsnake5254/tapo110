package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeAwayModeRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  public HomeAwayModeRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private void y(BabyCryingDetectionInfo paramBabyCryingDetectionInfo)
  {
    if ((paramBabyCryingDetectionInfo != null) && (paramBabyCryingDetectionInfo.getEnabled() != null) && (b() != null) && (((TPCameraDeviceContext)b()).getDeviceIdMD5() != null) && (!u.a(((TPCameraDeviceContext)b()).getDeviceIdMD5()).booleanValue()) && (paramBabyCryingDetectionInfo.getEnabled().equals("on"))) {
      u.h(((TPCameraDeviceContext)b()).getDeviceIdMD5(), true);
    }
  }
  
  public q<Boolean> t(MotionDetectConfig paramMotionDetectConfig, AlarmInfo paramAlarmInfo, MsgPushInfo paramMsgPushInfo, DetectionInfo paramDetectionInfo1, DetectionInfo paramDetectionInfo2, TamperDetectConfig paramTamperDetectConfig, HumanRecognitionInfo paramHumanRecognitionInfo, final BabyCryingDetectionInfo paramBabyCryingDetectionInfo, TargetTrackInfo paramTargetTrackInfo)
  {
    return l().g(paramMotionDetectConfig, paramAlarmInfo, paramMsgPushInfo, paramDetectionInfo1, paramDetectionInfo2, paramTamperDetectConfig, paramHumanRecognitionInfo, paramBabyCryingDetectionInfo, paramTargetTrackInfo).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(new a(paramBabyCryingDetectionInfo));
  }
  
  public q<Boolean> u(AlarmPlanInfo paramAlarmPlanInfo, MsgPushPlanInfo paramMsgPushPlanInfo, ArmScheduleInfo paramArmScheduleInfo1, ArmScheduleInfo paramArmScheduleInfo2)
  {
    return l().h(paramAlarmPlanInfo, paramMsgPushPlanInfo, paramArmScheduleInfo1, paramArmScheduleInfo2).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(i2.c);
  }
  
  public q<Boolean> v(List<MotionDetectRegion> paramList, Map<String, List<IntrusionDetectionRegion>> paramMap, HashMap<String, List<LineCrossingDetectionRegion>> paramHashMap)
  {
    return l().i(paramList, paramMap, paramHashMap).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(h2.c);
  }
  
  class a
    implements j<Boolean, Boolean>
  {
    a(BabyCryingDetectionInfo paramBabyCryingDetectionInfo) {}
    
    public Boolean a(@NonNull Boolean paramBoolean)
      throws Exception
    {
      HomeAwayModeRepository.s(HomeAwayModeRepository.this, paramBabyCryingDetectionInfo);
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\HomeAwayModeRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */