package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.h;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.l0.a;
import io.reactivex.q;

public class MsgPushRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  private h d = new h();
  
  public MsgPushRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private MsgPushInfo t(boolean paramBoolean1, boolean paramBoolean2)
  {
    return new MsgPushInfo(OptionSwitch.fromBoolean(paramBoolean1).getRaw(), OptionSwitch.fromBoolean(paramBoolean2).getRaw());
  }
  
  private MsgPushPlanInfo u(boolean paramBoolean, Schedule paramSchedule)
  {
    return new MsgPushPlanInfo(OptionSwitch.fromBoolean(paramBoolean).getRaw(), ScheduleParser.formatAlarmSchedule(paramSchedule));
  }
  
  public q<Boolean> C()
  {
    return this.c.c0().i(m.a()).i1(this.c.d0().i(m.a()), new a()).L0(a.c()).C(f7.c);
  }
  
  public q<Boolean> D(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.c.L2(t(paramBoolean1, paramBoolean2)).C(f7.c).i(m.g()).L0(a.c()).g0(q3.c).E(new t3(this, paramBoolean1, paramBoolean2));
  }
  
  public q<Boolean> E(boolean paramBoolean, Schedule paramSchedule)
  {
    return this.c.M2(u(paramBoolean, paramSchedule)).C(f7.c).i(m.g()).L0(a.c()).g0(s3.c).E(new r3(this, paramBoolean, paramSchedule));
  }
  
  public void F(MsgPushInfo paramMsgPushInfo)
  {
    if (paramMsgPushInfo != null)
    {
      this.d.f(OptionSwitch.isOn(paramMsgPushInfo.getNotificationEnabled()));
      this.d.g(OptionSwitch.isOn(paramMsgPushInfo.getRichNotificationEnabled()));
    }
  }
  
  public h v()
  {
    return this.d;
  }
  
  class a
    implements io.reactivex.g0.c<MsgPushInfo, MsgPushPlanInfo, Boolean>
  {
    a() {}
    
    public Boolean a(MsgPushInfo paramMsgPushInfo, MsgPushPlanInfo paramMsgPushPlanInfo)
      throws Exception
    {
      MsgPushRepository.s(MsgPushRepository.this).f(OptionSwitch.isOn(paramMsgPushInfo.getNotificationEnabled()));
      MsgPushRepository.s(MsgPushRepository.this).g(OptionSwitch.isOn(paramMsgPushInfo.getRichNotificationEnabled()));
      MsgPushRepository.s(MsgPushRepository.this).e(OptionSwitch.isOn(paramMsgPushPlanInfo.getEnabled()));
      paramMsgPushInfo = ScheduleParser.parseSchedule(paramMsgPushPlanInfo.getPlan());
      MsgPushRepository.s(MsgPushRepository.this).h(paramMsgPushInfo);
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\MsgPushRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */