package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.f;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.HardDiskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardFormatProgress;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import com.tplink.libtpnetwork.cameranetwork.model.SettingComposite;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.b;

public class CameraSettingRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  private final SettingsData d = new SettingsData();
  private com.tplink.libtpnetwork.cameranetwork.business.model.o e = new com.tplink.libtpnetwork.cameranetwork.business.model.o();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<CameraException>> f = new MutableLiveData();
  private TPCameraDeviceContext g;
  
  public CameraSettingRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    this.g = paramTPCameraDeviceContext;
  }
  
  private void J1(Map<DayOfWeek, List<Schedule>> paramMap)
  {
    com.tplink.libtpnetwork.cameranetwork.business.model.o localo = this.e;
    if (localo != null)
    {
      localo.d(true);
      for (localo : DayOfWeek.values()) {
        this.e.e(localo, (List)paramMap.get(localo));
      }
    }
  }
  
  private String N(String paramString1, String paramString2)
  {
    boolean bool = paramString2.contains("KB");
    String str = "MB";
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(s1(paramString2));
      ((StringBuilder)localObject).append("MB");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = paramString2;
      if (paramString2.contains("B"))
      {
        localObject = paramString2;
        if (!paramString2.contains("KB"))
        {
          localObject = paramString2;
          if (!paramString2.contains("MB"))
          {
            localObject = paramString2;
            if (!paramString2.contains("GB")) {
              localObject = "0MB";
            }
          }
        }
      }
    }
    if (paramString1.contains("KB"))
    {
      paramString2 = new StringBuilder();
      paramString2.append(s1(paramString1));
      paramString2.append("MB");
      paramString2 = paramString2.toString();
    }
    else
    {
      paramString2 = paramString1;
      if (paramString1.contains("B"))
      {
        paramString2 = paramString1;
        if (!paramString1.contains("KB"))
        {
          paramString2 = paramString1;
          if (!paramString1.contains("MB"))
          {
            paramString2 = paramString1;
            if (!paramString1.contains("GB")) {
              paramString2 = "0MB";
            }
          }
        }
      }
    }
    float f1 = 0.0F;
    float f2;
    try
    {
      f2 = Float.parseFloat(paramString2.substring(0, paramString2.length() - 2));
      try
      {
        f3 = Float.parseFloat(((String)localObject).substring(0, ((String)localObject).length() - 2));
      }
      catch (NumberFormatException paramString1) {}
      paramString1.printStackTrace();
    }
    catch (NumberFormatException paramString1)
    {
      f2 = 0.0F;
    }
    float f3 = 0.0F;
    if (paramString2.contains("GB")) {
      paramString1 = "GB";
    } else {
      paramString1 = "MB";
    }
    if (((String)localObject).contains("GB")) {
      paramString2 = "GB";
    } else {
      paramString2 = "MB";
    }
    if ("GB".equals(paramString1))
    {
      if ("GB".equals(paramString2)) {
        f2 -= f3;
      } else {
        f2 = (f2 * 1000.0F - f3) / 1000.0F;
      }
      paramString1 = "GB";
    }
    else if ("MB".equals(paramString2))
    {
      f2 -= f3;
      paramString1 = str;
    }
    else
    {
      paramString1 = "";
      f2 = f1;
    }
    Object localObject = String.format("%.1f", new Object[] { Float.valueOf(f2), Locale.US });
    paramString2 = (String)localObject;
    if (((String)localObject).contains(",")) {
      paramString2 = ((String)localObject).replace(",", ".");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString1);
    return ((StringBuilder)localObject).toString();
  }
  
  private void O(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CameraException)) {
      this.f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a((CameraException)paramThrowable));
    }
  }
  
  private void P(CameraComponent paramCameraComponent, SettingCompositeV2 paramSettingCompositeV2)
  {
    if ((paramSettingCompositeV2.getMotionDetectionInfo() != null) && (paramSettingCompositeV2.getMotionDetectionInfo().getConfig() != null)) {
      ((MotionDetectionRepository)e.b(this.g, MotionDetectionRepository.class)).d0(paramSettingCompositeV2.getMotionDetectionInfo().getConfig());
    }
    if ((paramCameraComponent.isSupportLineCrossingDetection()) && (paramSettingCompositeV2.getLineCrossingDetectionInfo() != null)) {
      ((LineCrossingDetectionRepository)e.b(this.g, LineCrossingDetectionRepository.class)).G(paramSettingCompositeV2.getLineCrossingDetectionInfo());
    }
    if ((paramCameraComponent.isSupportIntrusionDetection()) && (paramSettingCompositeV2.getIntrusionDetectionInfo() != null)) {
      ((AreaIntrusionRepository)e.b(this.g, AreaIntrusionRepository.class)).F(paramSettingCompositeV2.getIntrusionDetectionInfo());
    }
    if ((paramCameraComponent.isSupportTamperDetection()) && (paramSettingCompositeV2.getTamperDetectConfig() != null)) {
      ((TamperDetectionRepository)e.b(this.g, TamperDetectionRepository.class)).x(paramSettingCompositeV2.getTamperDetectConfig());
    }
    if ((paramCameraComponent.isSupportBabyCry()) && (paramSettingCompositeV2.getBabyCryDetectionInfo() != null)) {
      ((AIDetectionRepository)e.b(this.g, AIDetectionRepository.class)).z(paramSettingCompositeV2.getBabyCryDetectionInfo());
    }
    if ((paramCameraComponent.isSupportPersonDetection()) && (paramSettingCompositeV2.getHumanRecognitionInfo() != null)) {
      ((AIDetectionRepository)e.b(this.g, AIDetectionRepository.class)).A(paramSettingCompositeV2.getHumanRecognitionInfo());
    }
  }
  
  private float s1(String paramString)
  {
    float f1 = 0.0F;
    try
    {
      boolean bool = paramString.contains("GB");
      float f2;
      if (bool) {
        f2 = Float.parseFloat(paramString.replace("GB", "")) * 1000.0F;
      }
      for (;;)
      {
        break;
        if (paramString.contains("MB"))
        {
          f2 = Float.parseFloat(paramString.replace("MB", ""));
        }
        else
        {
          f2 = f1;
          if (!paramString.contains("KB")) {
            break;
          }
          f2 = Float.parseFloat(paramString.replace("KB", ""));
          f2 /= 1000.0F;
        }
      }
      return f2;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      f2 = f1;
    }
  }
  
  private static com.tplink.libtpnetwork.cameranetwork.business.model.o t1(RecordPlanInfo paramRecordPlanInfo)
  {
    com.tplink.libtpnetwork.cameranetwork.business.model.o localo = new com.tplink.libtpnetwork.cameranetwork.business.model.o();
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
  
  public static RecordPlanInfo w(Map<DayOfWeek, List<Schedule>> paramMap)
  {
    return new RecordPlanInfo(OptionSwitch.fromBoolean(paramMap.isEmpty() ^ true).getRaw(), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.MONDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.TUESDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.THURSDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.FRIDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.SATURDAY)), ScheduleParser.formatRecordSchedules((List)paramMap.get(DayOfWeek.SUNDAY)));
  }
  
  public io.reactivex.q<Boolean> A()
  {
    return l().X().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new b1(this)).C(new t0(this)).g0(k0.c);
  }
  
  public io.reactivex.q<Boolean> A1(boolean paramBoolean)
  {
    f4 localf4 = l();
    OptionSwitch localOptionSwitch;
    if (paramBoolean) {
      localOptionSwitch = OptionSwitch.ON;
    } else {
      localOptionSwitch = OptionSwitch.OFF;
    }
    return localf4.D2(localOptionSwitch.toString()).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new e1(this, paramBoolean)).C(new w(this, paramBoolean)).g0(v.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<Boolean> B()
  {
    return l().e0().E(new v0(this)).C(new m0(this)).g0(x0.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<Boolean> B1(String paramString)
  {
    return l().G2(paramString).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(z0.c);
  }
  
  public io.reactivex.q<Boolean> C(boolean paramBoolean)
  {
    return l().f0(paramBoolean).i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new j0(this)).C(new t0(this)).g0(s0.c);
  }
  
  public io.reactivex.q<Boolean> C1(boolean paramBoolean)
  {
    return l().J2(paramBoolean).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g1(this, paramBoolean)).C(new w0(this, paramBoolean)).g0(f0.c);
  }
  
  public int D(String paramString1, String paramString2)
  {
    return (int)(s1(paramString1) * 100.0D / s1(paramString2));
  }
  
  public io.reactivex.q<Boolean> D1(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    return l().P2(paramBoolean1, paramBoolean2, paramString, paramBoolean3).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(q0.c);
  }
  
  public io.reactivex.q<Boolean> E()
  {
    return l().h0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new a()).g0(n.c);
  }
  
  public io.reactivex.q<Boolean> E1(boolean paramBoolean)
  {
    return l().Q2(paramBoolean).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(p.c);
  }
  
  public io.reactivex.q<HardDiskInfo> F()
  {
    return l().k0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(new b());
  }
  
  public io.reactivex.q<Boolean> F1(RebootInfo paramRebootInfo)
  {
    return l().R2(paramRebootInfo).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new s(this, paramRebootInfo)).C(new i(this)).g0(c1.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<SdCardFormatProgress> G()
  {
    return l().l0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public void G1(RecordPlanInfo paramRecordPlanInfo)
  {
    this.e = t1(paramRecordPlanInfo);
  }
  
  public io.reactivex.q<SdCardStatus> H()
  {
    return l().m0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(new j(this));
  }
  
  public io.reactivex.q<Boolean> H1(String paramString1, String paramString2)
  {
    return l().Y2(paramString1, paramString2).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(q.c);
  }
  
  public Map<DayOfWeek, List<Schedule>> I(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Schedule(0, 0, 24, 0, paramInt));
    localHashMap.put(DayOfWeek.MONDAY, localArrayList);
    localHashMap.put(DayOfWeek.TUESDAY, localArrayList);
    localHashMap.put(DayOfWeek.WEDNESDAY, localArrayList);
    localHashMap.put(DayOfWeek.THURSDAY, localArrayList);
    localHashMap.put(DayOfWeek.FRIDAY, localArrayList);
    localHashMap.put(DayOfWeek.SATURDAY, localArrayList);
    localHashMap.put(DayOfWeek.SUNDAY, localArrayList);
    return localHashMap;
  }
  
  public io.reactivex.q<Boolean> I1()
  {
    return l().e3().i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(z.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<ServiceList> J()
  {
    return l().n0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).E(new c());
  }
  
  public io.reactivex.q<Boolean> K(CameraComponent paramCameraComponent)
  {
    return l().o0(paramCameraComponent).u0(1L).g0(c7.c).g0(new l(this, paramCameraComponent)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<Boolean> K1(String paramString1, String paramString2)
  {
    return l().k3(paramString1, paramString2).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(y0.c);
  }
  
  public io.reactivex.q<SettingCompositeV2> L(CameraComponent paramCameraComponent)
  {
    return l().p0(paramCameraComponent).L0(io.reactivex.l0.a.c()).C(a0.c).g0(g7.c).E(new u0(this, paramCameraComponent));
  }
  
  public io.reactivex.q<Boolean> M()
  {
    return l().t0().E(new a1(this)).g0(t.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public boolean Q()
  {
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.e.a().values().iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
    } while (((Schedule)localIterator2.next()).getType() != 2);
    return true;
    return false;
  }
  
  public boolean R()
  {
    MotionDetectionRepository localMotionDetectionRepository = (MotionDetectionRepository)e.b(this.g, MotionDetectionRepository.class);
    LineCrossingDetectionRepository localLineCrossingDetectionRepository = (LineCrossingDetectionRepository)e.b(this.g, LineCrossingDetectionRepository.class);
    AreaIntrusionRepository localAreaIntrusionRepository = (AreaIntrusionRepository)e.b(this.g, AreaIntrusionRepository.class);
    TamperDetectionRepository localTamperDetectionRepository = (TamperDetectionRepository)e.b(this.g, TamperDetectionRepository.class);
    AIDetectionRepository localAIDetectionRepository = (AIDetectionRepository)e.b(this.g, AIDetectionRepository.class);
    com.tplink.libtpnetwork.cameranetwork.business.model.g localg = localMotionDetectionRepository.y();
    boolean bool1 = true;
    if ((localg != null) && (localMotionDetectionRepository.y().e())) {
      return true;
    }
    int i;
    if ((localMotionDetectionRepository.y() != null) && (b.b(localMotionDetectionRepository.y().b()))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool2 = bool1;
    if (!localLineCrossingDetectionRepository.A().c())
    {
      bool2 = bool1;
      if (!localAreaIntrusionRepository.z().c())
      {
        bool2 = bool1;
        if (!localTamperDetectionRepository.t().c())
        {
          bool2 = bool1;
          if (i == 0)
          {
            bool2 = bool1;
            if (!com.tplink.libtpnetwork.Utils.j.h(localAIDetectionRepository.t())) {
              if (com.tplink.libtpnetwork.Utils.j.h(localAIDetectionRepository.v())) {
                bool2 = bool1;
              } else {
                bool2 = false;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean S()
  {
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.e.a().values().iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
    } while (((Schedule)localIterator2.next()).getType() != 1);
    return true;
    return false;
  }
  
  public boolean T()
  {
    com.tplink.libtpnetwork.cameranetwork.business.model.o localo = this.e;
    if (localo != null) {
      return localo.c();
    }
    return false;
  }
  
  public io.reactivex.q<Boolean> h()
  {
    return l().h2().i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(o.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<Boolean> u(String paramString1, String paramString2)
  {
    return l().k(paramString1, paramString2).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new x(this, paramString1)).C(new t0(this)).g0(c0.c);
  }
  
  public io.reactivex.q<Boolean> u1()
  {
    return l().f2().i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(d1.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<Boolean> v()
  {
    return l().v().C(f7.c).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new t0(this)).g0(r0.c);
  }
  
  public io.reactivex.q<Boolean> v1(Map<DayOfWeek, List<Schedule>> paramMap)
  {
    return l().T2(w(paramMap)).E(new b0(this, paramMap)).g0(g0.c).C(new e0(this)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<Boolean> w1(boolean paramBoolean)
  {
    return io.reactivex.q.f0(l()).N(new k(this, paramBoolean)).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new m(this, paramBoolean)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public SettingsData x()
  {
    return this.d;
  }
  
  public io.reactivex.q<Boolean> x1(String paramString)
  {
    return l().u2(paramString).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new p0(this, paramString)).C(new t0(this)).g0(u.c);
  }
  
  public io.reactivex.q<Boolean> y()
  {
    return l().K().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new r(this)).C(new t0(this)).g0(y.c);
  }
  
  public io.reactivex.q<Boolean> y1(String paramString)
  {
    return l().s2(paramString).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new i0(this, paramString)).C(new t0(this)).g0(d0.c);
  }
  
  public io.reactivex.q<Boolean> z()
  {
    return l().T().E(new h0(this)).g0(f1.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public io.reactivex.q<Boolean> z1(boolean paramBoolean)
  {
    return l().y2(paramBoolean).i(com.tplink.libtpnetwork.cameranetwork.g4.m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new l0(this, paramBoolean)).C(new o0(this, paramBoolean)).g0(n0.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  class a
    implements io.reactivex.g0.g<RebootInfo>
  {
    a() {}
    
    public void a(RebootInfo paramRebootInfo)
      throws Exception
    {
      if (paramRebootInfo != null)
      {
        OptionSwitch localOptionSwitch = OptionSwitch.fromString(paramRebootInfo.getEnabled());
        paramRebootInfo = paramRebootInfo.getTime();
        CameraSettingRepository.s(CameraSettingRepository.this).setRebootConfig(new RebootInfoCache(localOptionSwitch, paramRebootInfo));
      }
    }
  }
  
  class b
    implements io.reactivex.g0.j<Response<SettingComposite>, HardDiskInfo>
  {
    b() {}
    
    public HardDiskInfo a(Response<SettingComposite> paramResponse)
      throws Exception
    {
      if ((paramResponse.getResult() != null) && (((SettingComposite)paramResponse.getResult()).getHardDiskInfo() != null)) {
        return ((SettingComposite)paramResponse.getResult()).getHardDiskInfo();
      }
      throw new Exception("hardDiskInfo is null");
    }
  }
  
  class c
    implements io.reactivex.g0.g<ServiceList>
  {
    c() {}
    
    public void a(ServiceList paramServiceList)
      throws Exception
    {
      if (paramServiceList != null)
      {
        com.tplink.libtpnetwork.Utils.o.h0().A0(CameraSettingRepository.t(CameraSettingRepository.this).getDeviceIdMD5(), paramServiceList.toString());
        CameraSettingRepository.s(CameraSettingRepository.this).setTapoCareNeedPayFunctionList(paramServiceList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\CameraSettingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */