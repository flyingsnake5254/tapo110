package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMode;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

public class AlarmSettingRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  private com.tplink.libtpnetwork.cameranetwork.business.model.b d = new com.tplink.libtpnetwork.cameranetwork.business.model.b();
  
  public AlarmSettingRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private q<Boolean> N(AlarmInfo paramAlarmInfo)
  {
    return l().m2(paramAlarmInfo).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(h.c).E(new f(this, paramAlarmInfo));
  }
  
  private q<Boolean> O(AlarmPlanInfo paramAlarmPlanInfo)
  {
    return l().n2(paramAlarmPlanInfo).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(b.c).E(new g(this, paramAlarmPlanInfo));
  }
  
  private static com.tplink.libtpnetwork.cameranetwork.business.model.b w(AlarmInfo paramAlarmInfo, AlarmPlanInfo paramAlarmPlanInfo)
  {
    com.tplink.libtpnetwork.cameranetwork.business.model.b localb = new com.tplink.libtpnetwork.cameranetwork.business.model.b();
    List localList = AlarmMode.fromStringList(paramAlarmInfo.getModes());
    localb.h(OptionSwitch.isOn(paramAlarmInfo.getEnabled()));
    localb.i(localList.contains(AlarmMode.LIGHT));
    localb.l(localList.contains(AlarmMode.SOUND));
    localb.m(AlarmSoundType.fromString(paramAlarmInfo.getAlarmType()));
    localb.k(OptionSwitch.isOn(paramAlarmPlanInfo.getEnabled()));
    paramAlarmInfo = ScheduleParser.parseSchedule(paramAlarmPlanInfo.getPlan());
    if (paramAlarmInfo != null) {
      localb.j(new com.tplink.libtpnetwork.cameranetwork.business.model.a(paramAlarmInfo));
    }
    return localb;
  }
  
  private AlarmInfo x()
  {
    Object localObject1 = this.d.c();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = AlarmSoundType.ALARM;
    }
    localObject1 = new ArrayList();
    if ((!this.d.g()) && (!this.d.e()))
    {
      ((List)localObject1).add(AlarmMode.SOUND.getRaw());
    }
    else
    {
      if (this.d.e()) {
        ((List)localObject1).add(AlarmMode.LIGHT.getRaw());
      }
      if (this.d.g()) {
        ((List)localObject1).add(AlarmMode.SOUND.getRaw());
      }
    }
    return new AlarmInfo(((AlarmSoundType)localObject2).getRaw(), OptionSwitch.fromBoolean(this.d.d()).getRaw(), "0", (List)localObject1);
  }
  
  public q<AlarmInfo> L()
  {
    return l().x().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new c(this));
  }
  
  public q<com.tplink.libtpnetwork.cameranetwork.business.model.b> M()
  {
    q localq = l().y().i(m.a());
    return l().x().i(m.a()).i1(localq, d.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new e(this));
  }
  
  public void P(boolean paramBoolean)
  {
    this.d.h(paramBoolean);
  }
  
  public void Q(AlarmInfo paramAlarmInfo)
  {
    if (paramAlarmInfo != null)
    {
      List localList = AlarmMode.fromStringList(paramAlarmInfo.getModes());
      this.d.h(OptionSwitch.isOn(paramAlarmInfo.getEnabled()));
      this.d.i(localList.contains(AlarmMode.LIGHT));
      this.d.l(localList.contains(AlarmMode.SOUND));
      this.d.m(AlarmSoundType.fromString(paramAlarmInfo.getAlarmType()));
    }
  }
  
  public q<Boolean> s(boolean paramBoolean)
  {
    AlarmInfo localAlarmInfo = x();
    return N(new AlarmInfo(localAlarmInfo.getAlarmType(), OptionSwitch.fromBoolean(paramBoolean).getRaw(), localAlarmInfo.getLightType(), localAlarmInfo.getModes()));
  }
  
  public q<Boolean> t(boolean paramBoolean1, boolean paramBoolean2)
  {
    AlarmInfo localAlarmInfo = x();
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean2) {
      localArrayList.add(AlarmMode.LIGHT.getRaw());
    }
    if (paramBoolean1) {
      localArrayList.add(AlarmMode.SOUND.getRaw());
    }
    return N(new AlarmInfo(localAlarmInfo.getAlarmType(), localAlarmInfo.getEnabled(), localAlarmInfo.getLightType(), localArrayList));
  }
  
  public q<Boolean> u(boolean paramBoolean, com.tplink.libtpnetwork.cameranetwork.business.model.a parama)
  {
    return O(new AlarmPlanInfo(OptionSwitch.fromBoolean(paramBoolean).getRaw(), ScheduleParser.formatAlarmSchedule(parama.b())));
  }
  
  public q<Boolean> v(AlarmSoundType paramAlarmSoundType)
  {
    AlarmInfo localAlarmInfo = x();
    return N(new AlarmInfo(paramAlarmSoundType.getRaw(), localAlarmInfo.getEnabled(), localAlarmInfo.getLightType(), localAlarmInfo.getModes()));
  }
  
  public boolean y()
  {
    return this.d.d();
  }
  
  public com.tplink.libtpnetwork.cameranetwork.business.model.b z()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\AlarmSettingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */