package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.c.a;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;

public final class AreaIntrusionRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  public static final a d = new a(null);
  private final com.tplink.libtpnetwork.cameranetwork.business.model.c e = new com.tplink.libtpnetwork.cameranetwork.business.model.c();
  
  public AreaIntrusionRepository(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private final void B(ArmScheduleInfo paramArmScheduleInfo)
  {
    this.e.f(DayOfWeek.SUNDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getSunday()));
    this.e.f(DayOfWeek.MONDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getMonday()));
    this.e.f(DayOfWeek.TUESDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getTuesday()));
    this.e.f(DayOfWeek.WEDNESDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getWednesday()));
    this.e.f(DayOfWeek.THURSDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getThursday()));
    this.e.f(DayOfWeek.FRIDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getFriday()));
    this.e.f(DayOfWeek.SATURDAY, ScheduleParser.parseIntrusionSchedules(paramArmScheduleInfo.getSaturday()));
  }
  
  private final void C(IntrusionDetectionInfo paramIntrusionDetectionInfo)
  {
    com.tplink.libtpnetwork.cameranetwork.business.model.c localc = this.e;
    Object localObject = paramIntrusionDetectionInfo.getDetectionInfo();
    if (localObject != null) {
      localObject = ((DetectionInfo)localObject).getEnabled();
    } else {
      localObject = null;
    }
    localc.d(kotlin.jvm.internal.j.a("on", localObject));
    paramIntrusionDetectionInfo = paramIntrusionDetectionInfo.getArmScheduleInfo();
    if (paramIntrusionDetectionInfo != null) {
      B(paramIntrusionDetectionInfo);
    }
  }
  
  private final ArmScheduleInfo x(Map<DayOfWeek, ? extends List<IntrusionSchedule>> paramMap)
  {
    return new ArmScheduleInfo(ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.MONDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.TUESDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.THURSDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.FRIDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.SATURDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.SUNDAY)));
  }
  
  private final q<List<Map<String, IntrusionDetectionRegion>>> y()
  {
    Object localObject = this.c;
    kotlin.jvm.internal.j.d(localObject, "cameraClient");
    localObject = ((f4)localObject).S().i(m.a()).L0(a.c()).E(new c(this));
    kotlin.jvm.internal.j.d(localObject, "cameraClient.intrusionDe…onsList\n                }");
    return (q<List<Map<String, IntrusionDetectionRegion>>>)localObject;
  }
  
  public final q<Boolean> A()
  {
    Object localObject = this.c;
    kotlin.jvm.internal.j.d(localObject, "cameraClient");
    localObject = ((f4)localObject).R().i(m.a()).L0(a.c()).E(new d(this)).N(new e(this)).g0(f.c);
    kotlin.jvm.internal.j.d(localObject, "cameraClient.intrusionDe…   true\n                }");
    return (q<Boolean>)localObject;
  }
  
  public final q<Boolean> D(final DetectionInfo paramDetectionInfo)
  {
    kotlin.jvm.internal.j.e(paramDetectionInfo, "detectionInfo");
    paramDetectionInfo = this.c.z2(paramDetectionInfo).i(m.a()).L0(a.c()).g0(new g(this, paramDetectionInfo));
    kotlin.jvm.internal.j.d(paramDetectionInfo, "cameraClient.setIntrusio…   true\n                }");
    return paramDetectionInfo;
  }
  
  public final q<Boolean> E(final Map<DayOfWeek, ? extends List<IntrusionSchedule>> paramMap)
  {
    kotlin.jvm.internal.j.e(paramMap, "schedules");
    paramMap = this.c.A2(x(paramMap)).i(m.a()).L0(a.c()).g0(new h(this, paramMap));
    kotlin.jvm.internal.j.d(paramMap, "cameraClient.setIntrusio…   true\n                }");
    return paramMap;
  }
  
  public final void F(IntrusionDetectionInfo paramIntrusionDetectionInfo)
  {
    kotlin.jvm.internal.j.e(paramIntrusionDetectionInfo, "intrusionDetectionInfo");
    C(paramIntrusionDetectionInfo);
  }
  
  public final q<Boolean> w(final List<? extends c.a> paramList)
  {
    kotlin.jvm.internal.j.e(paramList, "regions");
    HashMap localHashMap = d.a(paramList);
    paramList = this.c.d(localHashMap).i(m.a()).L0(a.c()).g0(new b(this, paramList));
    kotlin.jvm.internal.j.d(paramList, "cameraClient.addIntrusio…   true\n                }");
    return paramList;
  }
  
  public final com.tplink.libtpnetwork.cameranetwork.business.model.c z()
  {
    return this.e;
  }
  
  public static final class a
  {
    public final HashMap<String, List<IntrusionDetectionRegion>> a(List<? extends c.a> paramList)
    {
      kotlin.jvm.internal.j.e(paramList, "regions");
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        c.a locala = (c.a)paramList.next();
        localArrayList.add(new IntrusionDetectionRegion(String.valueOf(locala.c()), String.valueOf(locala.d()), String.valueOf(locala.c() + locala.b()), String.valueOf(locala.d()), String.valueOf(locala.c() + locala.b()), String.valueOf(locala.d() + locala.a()), String.valueOf(locala.c()), String.valueOf(locala.d() + locala.a()), "50", "0", "0"));
      }
      paramList = new HashMap();
      paramList.put("region_info", localArrayList);
      return paramList;
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    b(AreaIntrusionRepository paramAreaIntrusionRepository, List paramList) {}
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      AreaIntrusionRepository.t(this.c).e(paramList);
      return Boolean.TRUE;
    }
  }
  
  static final class c<T>
    implements g<List<Map<String, IntrusionDetectionRegion>>>
  {
    c(AreaIntrusionRepository paramAreaIntrusionRepository) {}
    
    public final void a(List<Map<String, IntrusionDetectionRegion>> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      kotlin.jvm.internal.j.d(paramList, "it");
      int i = paramList.size();
      int j = 0;
      int k = 0;
      while (j < i)
      {
        IntrusionDetectionRegion localIntrusionDetectionRegion = (IntrusionDetectionRegion)l.w(((Map)paramList.get(j)).values());
        c.a locala = new c.a();
        locala.g(Integer.parseInt(localIntrusionDetectionRegion.getLeftTopX()));
        locala.h(Integer.parseInt(localIntrusionDetectionRegion.getLeftTopY()));
        locala.f(Integer.parseInt(localIntrusionDetectionRegion.getRightTopX()) - Integer.parseInt(localIntrusionDetectionRegion.getLeftTopX()));
        locala.e(Integer.parseInt(localIntrusionDetectionRegion.getLeftBottomY()) - Integer.parseInt(localIntrusionDetectionRegion.getLeftTopY()));
        localArrayList.add(locala);
        if (Integer.parseInt(localIntrusionDetectionRegion.getLeftBottomX()) < Integer.parseInt(localIntrusionDetectionRegion.getRightBottomX())) {
          k = 1;
        }
        j++;
      }
      if (k != 0) {
        this.c.w(localArrayList).C(a.c).F0();
      }
      AreaIntrusionRepository.t(this.c).e(localArrayList);
    }
    
    static final class a<T>
      implements g<Throwable>
    {
      public static final a c = new a();
      
      public final void a(Throwable paramThrowable)
      {
        paramThrowable.printStackTrace();
      }
    }
  }
  
  static final class d<T>
    implements g<IntrusionDetectionInfo>
  {
    d(AreaIntrusionRepository paramAreaIntrusionRepository) {}
    
    public final void a(IntrusionDetectionInfo paramIntrusionDetectionInfo)
    {
      com.tplink.libtpnetwork.cameranetwork.business.model.c localc = AreaIntrusionRepository.t(this.c);
      Object localObject = paramIntrusionDetectionInfo.getDetectionInfo();
      if (localObject != null) {
        localObject = ((DetectionInfo)localObject).getEnabled();
      } else {
        localObject = null;
      }
      localc.d(kotlin.jvm.internal.j.a("on", localObject));
      paramIntrusionDetectionInfo = paramIntrusionDetectionInfo.getArmScheduleInfo();
      if (paramIntrusionDetectionInfo != null) {
        AreaIntrusionRepository.v(this.c, paramIntrusionDetectionInfo);
      }
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<IntrusionDetectionInfo, t<? extends List<? extends Map<String, ? extends IntrusionDetectionRegion>>>>
  {
    e(AreaIntrusionRepository paramAreaIntrusionRepository) {}
    
    public final t<? extends List<Map<String, IntrusionDetectionRegion>>> a(IntrusionDetectionInfo paramIntrusionDetectionInfo)
    {
      kotlin.jvm.internal.j.e(paramIntrusionDetectionInfo, "<anonymous parameter 0>");
      return AreaIntrusionRepository.u(this.c);
    }
  }
  
  static final class f<T, R>
    implements io.reactivex.g0.j<List<? extends Map<String, ? extends IntrusionDetectionRegion>>, Boolean>
  {
    public static final f c = new f();
    
    public final Boolean a(List<? extends Map<String, IntrusionDetectionRegion>> paramList)
    {
      kotlin.jvm.internal.j.e(paramList, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    g(AreaIntrusionRepository paramAreaIntrusionRepository, DetectionInfo paramDetectionInfo) {}
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      AreaIntrusionRepository.t(this.c).d(kotlin.jvm.internal.j.a("on", paramDetectionInfo.getEnabled()));
      return Boolean.TRUE;
    }
  }
  
  static final class h<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    h(AreaIntrusionRepository paramAreaIntrusionRepository, Map paramMap) {}
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      paramObject = this.c;
      AreaIntrusionRepository.v((AreaIntrusionRepository)paramObject, AreaIntrusionRepository.s((AreaIntrusionRepository)paramObject, paramMap));
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\AreaIntrusionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */