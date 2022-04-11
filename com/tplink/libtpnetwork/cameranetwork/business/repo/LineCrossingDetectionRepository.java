package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.f;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;

public final class LineCrossingDetectionRepository
  extends c
{
  public static final a d = new a(null);
  private final f e = new f();
  
  public LineCrossingDetectionRepository(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private final void C(ArmScheduleInfo paramArmScheduleInfo)
  {
    this.e.f(DayOfWeek.SUNDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getSunday()));
    this.e.f(DayOfWeek.MONDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getMonday()));
    this.e.f(DayOfWeek.TUESDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getTuesday()));
    this.e.f(DayOfWeek.WEDNESDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getWednesday()));
    this.e.f(DayOfWeek.THURSDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getThursday()));
    this.e.f(DayOfWeek.FRIDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getFriday()));
    this.e.f(DayOfWeek.SATURDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getSaturday()));
  }
  
  private final void D(LineCrossingDetectionInfo paramLineCrossingDetectionInfo)
  {
    f localf = this.e;
    Object localObject = paramLineCrossingDetectionInfo.getDetectionInfo();
    if (localObject != null) {
      localObject = ((DetectionInfo)localObject).getEnabled();
    } else {
      localObject = null;
    }
    localf.d(kotlin.jvm.internal.j.a("on", localObject));
    paramLineCrossingDetectionInfo = paramLineCrossingDetectionInfo.getArmScheduleInfo();
    if (paramLineCrossingDetectionInfo != null) {
      C(paramLineCrossingDetectionInfo);
    }
  }
  
  private final HashMap<String, List<LineCrossingDetectionRegion>> x(List<LineCrossingDetectionRegion> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("region_info", paramList);
    return localHashMap;
  }
  
  private final ArmScheduleInfo y(Map<DayOfWeek, ? extends List<IntrusionSchedule>> paramMap)
  {
    return new ArmScheduleInfo(ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.MONDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.TUESDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.THURSDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.FRIDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.SATURDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.SUNDAY)));
  }
  
  private final q<List<Map<String, LineCrossingDetectionRegion>>> z()
  {
    Object localObject = this.c;
    kotlin.jvm.internal.j.d(localObject, "cameraClient");
    localObject = ((f4)localObject).Z().i(m.a()).L0(a.c()).E(new c(this));
    kotlin.jvm.internal.j.d(localObject, "cameraClient.linecrossin…onsList\n                }");
    return (q<List<Map<String, LineCrossingDetectionRegion>>>)localObject;
  }
  
  public final f A()
  {
    return this.e;
  }
  
  public final q<Boolean> B()
  {
    Object localObject = this.c;
    kotlin.jvm.internal.j.d(localObject, "cameraClient");
    localObject = ((f4)localObject).Y().i(m.a()).L0(a.c()).E(new d(this)).N(new e(this)).g0(f.c);
    kotlin.jvm.internal.j.d(localObject, "cameraClient.linecrossin…   true\n                }");
    return (q<Boolean>)localObject;
  }
  
  public final q<Boolean> E(final DetectionInfo paramDetectionInfo)
  {
    kotlin.jvm.internal.j.e(paramDetectionInfo, "detectionInfo");
    paramDetectionInfo = this.c.H2(paramDetectionInfo).i(m.a()).L0(a.c()).g0(new g(this, paramDetectionInfo));
    kotlin.jvm.internal.j.d(paramDetectionInfo, "cameraClient.setLinecros…   true\n                }");
    return paramDetectionInfo;
  }
  
  public final q<Boolean> F(final Map<DayOfWeek, ? extends List<IntrusionSchedule>> paramMap)
  {
    kotlin.jvm.internal.j.e(paramMap, "schedules");
    paramMap = this.c.I2(y(paramMap)).i(m.a()).L0(a.c()).g0(new h(this, paramMap));
    kotlin.jvm.internal.j.d(paramMap, "cameraClient.setLinecros…   true\n                }");
    return paramMap;
  }
  
  public final void G(LineCrossingDetectionInfo paramLineCrossingDetectionInfo)
  {
    kotlin.jvm.internal.j.e(paramLineCrossingDetectionInfo, "detectionInfo");
    D(paramLineCrossingDetectionInfo);
  }
  
  public final q<Boolean> w(final List<LineCrossingDetectionRegion> paramList)
  {
    kotlin.jvm.internal.j.e(paramList, "regions");
    HashMap localHashMap = x(paramList);
    paramList = this.c.e(localHashMap).i(m.a()).L0(a.c()).g0(new b(this, paramList));
    kotlin.jvm.internal.j.d(paramList, "cameraClient.addLinecros…   true\n                }");
    return paramList;
  }
  
  public static final class a {}
  
  static final class b<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    b(LineCrossingDetectionRepository paramLineCrossingDetectionRepository, List paramList) {}
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      LineCrossingDetectionRepository.u(this.c).e(paramList);
      return Boolean.TRUE;
    }
  }
  
  static final class c<T>
    implements g<List<Map<String, LineCrossingDetectionRegion>>>
  {
    c(LineCrossingDetectionRepository paramLineCrossingDetectionRepository) {}
    
    public final void a(List<Map<String, LineCrossingDetectionRegion>> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      kotlin.jvm.internal.j.d(paramList, "it");
      int i = paramList.size();
      for (int j = 0; j < i; j++) {
        localArrayList.add((LineCrossingDetectionRegion)l.w(((Map)paramList.get(j)).values()));
      }
      LineCrossingDetectionRepository.u(this.c).e(localArrayList);
    }
  }
  
  static final class d<T>
    implements g<LineCrossingDetectionInfo>
  {
    d(LineCrossingDetectionRepository paramLineCrossingDetectionRepository) {}
    
    public final void a(LineCrossingDetectionInfo paramLineCrossingDetectionInfo)
    {
      f localf = LineCrossingDetectionRepository.u(this.c);
      Object localObject = paramLineCrossingDetectionInfo.getDetectionInfo();
      if (localObject != null) {
        localObject = ((DetectionInfo)localObject).getEnabled();
      } else {
        localObject = null;
      }
      localf.d(kotlin.jvm.internal.j.a("on", localObject));
      paramLineCrossingDetectionInfo = paramLineCrossingDetectionInfo.getArmScheduleInfo();
      if (paramLineCrossingDetectionInfo != null) {
        LineCrossingDetectionRepository.v(this.c, paramLineCrossingDetectionInfo);
      }
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<LineCrossingDetectionInfo, t<? extends List<? extends Map<String, ? extends LineCrossingDetectionRegion>>>>
  {
    e(LineCrossingDetectionRepository paramLineCrossingDetectionRepository) {}
    
    public final t<? extends List<Map<String, LineCrossingDetectionRegion>>> a(LineCrossingDetectionInfo paramLineCrossingDetectionInfo)
    {
      kotlin.jvm.internal.j.e(paramLineCrossingDetectionInfo, "<anonymous parameter 0>");
      return LineCrossingDetectionRepository.t(this.c);
    }
  }
  
  static final class f<T, R>
    implements io.reactivex.g0.j<List<? extends Map<String, ? extends LineCrossingDetectionRegion>>, Boolean>
  {
    public static final f c = new f();
    
    public final Boolean a(List<? extends Map<String, LineCrossingDetectionRegion>> paramList)
    {
      kotlin.jvm.internal.j.e(paramList, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    g(LineCrossingDetectionRepository paramLineCrossingDetectionRepository, DetectionInfo paramDetectionInfo) {}
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      LineCrossingDetectionRepository.u(this.c).d(kotlin.jvm.internal.j.a("on", paramDetectionInfo.getEnabled()));
      return Boolean.TRUE;
    }
  }
  
  static final class h<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    h(LineCrossingDetectionRepository paramLineCrossingDetectionRepository, Map paramMap) {}
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      paramObject = this.c;
      LineCrossingDetectionRepository.v((LineCrossingDetectionRepository)paramObject, LineCrossingDetectionRepository.s((LineCrossingDetectionRepository)paramObject, paramMap));
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\LineCrossingDetectionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */