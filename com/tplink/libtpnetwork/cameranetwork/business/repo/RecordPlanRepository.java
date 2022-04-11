package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RecordPlanRepository
  extends c
{
  private final MutableLiveData<o> d = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<CameraException>> e = new MutableLiveData();
  private o f;
  
  public RecordPlanRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private static o I(RecordPlanInfo paramRecordPlanInfo)
  {
    o localo = new o();
    boolean bool;
    if (OptionSwitch.fromString(paramRecordPlanInfo.getEnabled()) == OptionSwitch.ON) {
      bool = true;
    } else {
      bool = false;
    }
    localo.d(bool);
    localo.e(DayOfWeek.SUNDAY, ScheduleParser.parseSchedules(paramRecordPlanInfo.getSunday()));
    localo.e(DayOfWeek.MONDAY, ScheduleParser.parseSchedules(paramRecordPlanInfo.getMonday()));
    localo.e(DayOfWeek.TUESDAY, ScheduleParser.parseSchedules(paramRecordPlanInfo.getTuesday()));
    localo.e(DayOfWeek.WEDNESDAY, ScheduleParser.parseSchedules(paramRecordPlanInfo.getWednesday()));
    localo.e(DayOfWeek.THURSDAY, ScheduleParser.parseSchedules(paramRecordPlanInfo.getThursday()));
    localo.e(DayOfWeek.FRIDAY, ScheduleParser.parseSchedules(paramRecordPlanInfo.getFriday()));
    localo.e(DayOfWeek.SATURDAY, ScheduleParser.parseSchedules(paramRecordPlanInfo.getSaturday()));
    return localo;
  }
  
  private void M(Map<DayOfWeek, List<Schedule>> paramMap)
  {
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      ((o)localObject1).d(true);
      for (Object localObject2 : DayOfWeek.values()) {
        this.f.e((DayOfWeek)localObject2, (List)paramMap.get(localObject2));
      }
    }
  }
  
  public static RecordPlanInfo s(Map<DayOfWeek, List<Schedule>> paramMap)
  {
    return new RecordPlanInfo(OptionSwitch.fromBoolean(paramMap.isEmpty() ^ true).getRaw(), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.MONDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.TUESDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.THURSDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.FRIDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.SATURDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.SUNDAY)));
  }
  
  private void u(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CameraException)) {
      this.e.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a((CameraException)paramThrowable));
    }
  }
  
  private void v(o paramo)
  {
    this.f = paramo;
    this.d.postValue(paramo);
  }
  
  public q<Boolean> H()
  {
    return l().j0().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(j6.c).E(new h6(this)).C(new i6(this)).g0(l6.c);
  }
  
  public void J()
  {
    this.d.setValue(this.f);
  }
  
  public q<Boolean> K(Map<DayOfWeek, List<Schedule>> paramMap)
  {
    return l().T2(s(paramMap)).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new i6(this)).E(new k6(this, paramMap));
  }
  
  public q<Boolean> L(boolean paramBoolean)
  {
    Object localObject = this.f;
    if ((localObject != null) && (((o)localObject).a() != null))
    {
      RecordPlanInfo localRecordPlanInfo = s(this.f.a());
      if (paramBoolean) {
        localObject = "on";
      } else {
        localObject = "off";
      }
      localRecordPlanInfo.setEnabled((String)localObject);
      return l().T2(localRecordPlanInfo).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new g6(this, paramBoolean)).E(f6.c);
    }
    return q.f0(Boolean.TRUE);
  }
  
  public LiveData<o> t()
  {
    return this.d;
  }
  
  public boolean w()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((o)localObject).a() != null))
    {
      Iterator localIterator;
      do
      {
        localObject = this.f.a().values().iterator();
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((List)((Iterator)localObject).next()).iterator();
        }
      } while (((Schedule)localIterator.next()).getType() != 2);
      return true;
    }
    return false;
  }
  
  public boolean x()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((o)localObject).a() != null))
    {
      Iterator localIterator;
      do
      {
        localObject = this.f.a().values().iterator();
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((List)((Iterator)localObject).next()).iterator();
        }
      } while (((Schedule)localIterator.next()).getType() != 1);
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\RecordPlanRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */