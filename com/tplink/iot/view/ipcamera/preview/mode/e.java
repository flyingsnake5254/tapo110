package com.tplink.iot.view.ipcamera.preview.mode;

import com.tplink.libtpmediaother.database.model.e.a;
import com.tplink.libtpmediaother.database.model.e.b;
import com.tplink.libtpmediaother.database.model.e.c;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.a;
import com.tplink.libtpnetwork.cameranetwork.business.model.c.a;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository.a;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMode;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDayUtils;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
{
  private static MotionDetectRegion a(d paramd)
  {
    return new MotionDetectRegion(paramd.c(), paramd.d(), paramd.b(), paramd.a());
  }
  
  public static HashMap<String, List<IntrusionDetectionRegion>> b(List<e.c> paramList)
  {
    return AreaIntrusionRepository.d.a(c(paramList));
  }
  
  public static List<c.a> c(List<e.c> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      e.c localc = (e.c)localIterator.next();
      paramList = new c.a();
      paramList.e(localc.c());
      paramList.f(localc.d());
      paramList.g(localc.e());
      paramList.h(localc.f());
      localArrayList.add(paramList);
    }
    return localArrayList;
  }
  
  public static List<LineCrossingDetectionRegion> d(List<e.b> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((e.b)paramList.next()).a());
    }
    return localArrayList;
  }
  
  public static HashMap<String, List<LineCrossingDetectionRegion>> e(List<e.b> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("region_info", d(paramList));
    return localHashMap;
  }
  
  public static List<d> f(List<e.c> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (e.c)localIterator.next();
      d locald = new d();
      locald.e(paramList.c());
      locald.f(paramList.d());
      locald.g(paramList.e());
      locald.h(paramList.f());
      localArrayList.add(locald);
    }
    return localArrayList;
  }
  
  public static AlarmInfo g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean3) {
      localArrayList.add(AlarmMode.LIGHT.getRaw());
    }
    if (paramBoolean2) {
      localArrayList.add(AlarmMode.SOUND.getRaw());
    }
    return new AlarmInfo(paramString, OptionSwitch.fromBoolean(paramBoolean1).getRaw(), "0", localArrayList);
  }
  
  public static AlarmPlanInfo h(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Schedule localSchedule = new a(paramInt1, paramInt2, paramInt3, paramInt4, BitwiseWeekDayUtils.daysFromRawSet(paramInt5)).b();
    return new AlarmPlanInfo(OptionSwitch.fromBoolean(paramBoolean).getRaw(), ScheduleParser.formatAlarmSchedule(localSchedule));
  }
  
  public static ArmScheduleInfo i(e.a parama)
  {
    parama = m(parama);
    return new ArmScheduleInfo(ScheduleParser.formatIntrusionSchedules((List)parama.get(DayOfWeek.MONDAY)), ScheduleParser.formatIntrusionSchedules((List)parama.get(DayOfWeek.TUESDAY)), ScheduleParser.formatIntrusionSchedules((List)parama.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatIntrusionSchedules((List)parama.get(DayOfWeek.THURSDAY)), ScheduleParser.formatIntrusionSchedules((List)parama.get(DayOfWeek.FRIDAY)), ScheduleParser.formatIntrusionSchedules((List)parama.get(DayOfWeek.SATURDAY)), ScheduleParser.formatIntrusionSchedules((List)parama.get(DayOfWeek.SUNDAY)));
  }
  
  public static List<MotionDetectRegion> j(List<d> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((d)paramList.next()));
    }
    return localArrayList;
  }
  
  public static MsgPushInfo k(boolean paramBoolean1, boolean paramBoolean2)
  {
    return new MsgPushInfo(OptionSwitch.fromBoolean(paramBoolean1).getRaw(), OptionSwitch.fromBoolean(paramBoolean2).getRaw());
  }
  
  public static MsgPushPlanInfo l(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Schedule localSchedule = new Schedule(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    return new MsgPushPlanInfo(OptionSwitch.fromBoolean(paramBoolean).getRaw(), ScheduleParser.formatAlarmSchedule(localSchedule));
  }
  
  public static Map<DayOfWeek, List<IntrusionSchedule>> m(e.a parama)
  {
    EnumMap localEnumMap = new EnumMap(DayOfWeek.class);
    localEnumMap.put(DayOfWeek.SUNDAY, ScheduleParser.parseIntrusionSchedules(parama.f()));
    localEnumMap.put(DayOfWeek.MONDAY, ScheduleParser.parseIntrusionSchedules(parama.d()));
    localEnumMap.put(DayOfWeek.TUESDAY, ScheduleParser.parseIntrusionSchedules(parama.h()));
    localEnumMap.put(DayOfWeek.WEDNESDAY, ScheduleParser.parseIntrusionSchedules(parama.i()));
    localEnumMap.put(DayOfWeek.THURSDAY, ScheduleParser.parseIntrusionSchedules(parama.g()));
    localEnumMap.put(DayOfWeek.FRIDAY, ScheduleParser.parseIntrusionSchedules(parama.c()));
    localEnumMap.put(DayOfWeek.SATURDAY, ScheduleParser.parseIntrusionSchedules(parama.e()));
    return localEnumMap;
  }
  
  public static String n(int paramInt)
  {
    if (paramInt == 0) {
      return "low";
    }
    if (paramInt == 50) {
      return "medium";
    }
    if (paramInt == 100) {
      return "high";
    }
    return "low";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\mode\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */