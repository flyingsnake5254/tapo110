package com.tplink.iot.view.ipcamera.preview.mode;

import android.text.TextUtils;
import android.util.Log;
import com.tplink.libtpmediaother.database.model.e.c;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.SubscribeItemBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.HomeAwayModeRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch.Companion;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import io.reactivex.g0.g;
import io.reactivex.g0.i;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.p;

public final class f
{
  private static final String a;
  private static final io.reactivex.e0.b b = new io.reactivex.e0.b();
  public static final f c = new f();
  
  static
  {
    String str = f.class.getSimpleName();
    kotlin.jvm.internal.j.d(str, "HomeAwayModeManager::class.java.simpleName");
    a = str;
  }
  
  private final d c(e.c paramc)
  {
    return new d(paramc.e(), paramc.f(), paramc.d(), paramc.c());
  }
  
  private final SubscribeItemBean e(String paramString)
  {
    return ((TCMessagePushRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCMessagePushRepository.class)).E(paramString);
  }
  
  private final void g(String paramString, boolean paramBoolean)
  {
    paramString = TPIoTClientManager.K1(paramString);
    kotlin.jvm.internal.j.d(paramString, "TPIoTClientManager.getCameraContext(deviceIdMD5)");
    paramString = (ALCameraDevice)paramString.getCameraDevice();
    if (paramString != null) {
      try
      {
        String str = paramString.getDeviceId();
        if ((!TextUtils.isEmpty(str)) && (paramBoolean) && (paramString.isRemote()))
        {
          SubscribeItemBean localSubscribeItemBean = new com/tplink/libtpnetwork/TPCloudNetwork/bean/SubscribeItemBean;
          localSubscribeItemBean.<init>(str);
          if (str != null) {
            paramString = c.e(str);
          } else {
            paramString = null;
          }
          if (paramString != null)
          {
            if (paramString.isSubscribeCameraMotion()) {
              return;
            }
            localSubscribeItemBean.setDeviceSubscribeOffBit(paramString.getDeviceSubscribeOffBit());
            localSubscribeItemBean.addSubscribeFunc(EnumMsgSubscribeType.CAMERA_MOTION);
            ((TCMessagePushRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCMessagePushRepository.class)).S(str, localSubscribeItemBean).F0();
          }
        }
        else {}
      }
      catch (Exception paramString)
      {
        b.d.w.c.a.d("camera mode openMsgPushAssociateSubscribe fail");
      }
    }
  }
  
  public final io.reactivex.e0.b d()
  {
    return b;
  }
  
  public final String f()
  {
    return a;
  }
  
  public final io.reactivex.e0.b h(List<String> paramList, boolean paramBoolean, final kotlin.jvm.b.l<? super Integer, p> paraml, final kotlin.jvm.b.l<? super HashSet<String>, p> paraml1)
  {
    kotlin.jvm.internal.j.e(paramList, "deviceIdMD5List");
    kotlin.jvm.internal.j.e(paraml, "progressCallback");
    kotlin.jvm.internal.j.e(paraml1, "connectionErrorCallback");
    final HashSet localHashSet1 = new HashSet();
    localHashSet1.addAll(paramList);
    final HashSet localHashSet2 = new HashSet();
    final HashSet localHashSet3 = new HashSet();
    b.d();
    if (paramList.isEmpty()) {
      paraml1.invoke(localHashSet3);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      b.d.q.b.l.g(paramList, paramBoolean, new a(paramList, localHashSet1, paraml1, localHashSet3, localHashSet2, paraml));
    }
    return b;
  }
  
  static final class a<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e>
  {
    a(String paramString, HashSet paramHashSet1, kotlin.jvm.b.l paraml1, HashSet paramHashSet2, HashSet paramHashSet3, kotlin.jvm.b.l paraml2) {}
    
    public final void b(final com.tplink.libtpmediaother.database.model.e parame)
    {
      final Object localObject = TPIoTClientManager.K1(this.a);
      kotlin.jvm.internal.j.d(localObject, "TPIoTClientManager.getCameraContext(deviceIdMD5)");
      final ALCameraDevice localALCameraDevice = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
      final MotionDetectionRepository localMotionDetectionRepository = (MotionDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.a, MotionDetectionRepository.class);
      final HomeAwayModeRepository localHomeAwayModeRepository = (HomeAwayModeRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.a, HomeAwayModeRepository.class);
      localObject = (CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.a, CommonCameraRepository.class);
      Boolean localBoolean = Boolean.FALSE;
      final com.tplink.libtpnetwork.Utils.f0.a locala = new com.tplink.libtpnetwork.Utils.f0.a(localBoolean);
      parame = com.tplink.iot.Utils.z0.h.c(this.a, null).q0(localBoolean).N(new a(locala, (CommonCameraRepository)localObject)).N(new b(this, locala, parame, localHomeAwayModeRepository, localMotionDetectionRepository, localALCameraDevice)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).T0(30L, TimeUnit.SECONDS).y(new c(this)).H0(new d(this), new e(this));
      f.c.d().b(parame);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<Boolean, t<? extends CameraComponent>>
    {
      a(com.tplink.libtpnetwork.Utils.f0.a parama, CommonCameraRepository paramCommonCameraRepository) {}
      
      public final t<? extends CameraComponent> a(Boolean paramBoolean)
      {
        kotlin.jvm.internal.j.e(paramBoolean, "t");
        this.c.a = Boolean.valueOf(kotlin.jvm.internal.j.a(paramBoolean, Boolean.TRUE));
        return localObject.K0();
      }
    }
    
    static final class b<T, R>
      implements io.reactivex.g0.j<CameraComponent, t<? extends Boolean>>
    {
      b(f.a parama, com.tplink.libtpnetwork.Utils.f0.a parama1, com.tplink.libtpmediaother.database.model.e parame, HomeAwayModeRepository paramHomeAwayModeRepository, MotionDetectionRepository paramMotionDetectionRepository, ALCameraDevice paramALCameraDevice) {}
      
      public final t<? extends Boolean> a(CameraComponent paramCameraComponent)
      {
        kotlin.jvm.internal.j.e(paramCameraComponent, "cameraComponent");
        boolean bool1 = paramCameraComponent.isSupportMsgPush();
        boolean bool2 = paramCameraComponent.isSupportLineCrossingDetection();
        boolean bool3 = paramCameraComponent.isSupportIntrusionDetection();
        boolean bool4 = paramCameraComponent.isSupportTamperDetection();
        boolean bool5 = paramCameraComponent.isSupportPersonEnhanced();
        boolean bool6 = paramCameraComponent.hasComponent(ComponentType.BABY_CRYING_DETECTION);
        boolean bool7 = paramCameraComponent.hasComponent(ComponentType.PERSON_DETECTION);
        boolean bool8 = paramCameraComponent.hasComponent(ComponentType.TARGET_TRACK);
        if (bool5)
        {
          paramCameraComponent = locala.a;
          kotlin.jvm.internal.j.d(paramCameraComponent, "isSubscribed.result");
          if (((Boolean)paramCameraComponent).booleanValue())
          {
            paramCameraComponent = parame;
            kotlin.jvm.internal.j.d(paramCameraComponent, "info");
            paramCameraComponent = Boolean.valueOf(paramCameraComponent.r());
            break label114;
          }
        }
        paramCameraComponent = null;
        label114:
        Object localObject1 = parame;
        kotlin.jvm.internal.j.d(localObject1, "info");
        int i = ((com.tplink.libtpmediaother.database.model.e)localObject1).J();
        localObject1 = parame;
        kotlin.jvm.internal.j.d(localObject1, "info");
        MotionDetectConfig localMotionDetectConfig = new MotionDetectConfig(i, ((com.tplink.libtpmediaother.database.model.e)localObject1).x(), paramCameraComponent);
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        boolean bool9 = paramCameraComponent.c();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        boolean bool10 = paramCameraComponent.g();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        bool5 = paramCameraComponent.f();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        AlarmInfo localAlarmInfo = e.g(bool9, bool10, bool5, paramCameraComponent.h());
        kotlin.jvm.internal.j.d(localAlarmInfo, "HomeAwayDataUtils.genera…led, info.alarmSoundType)");
        if (bool1)
        {
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          bool5 = paramCameraComponent.B();
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          paramCameraComponent = e.k(bool5, paramCameraComponent.C());
        }
        else
        {
          paramCameraComponent = null;
        }
        if (bool3)
        {
          localObject2 = OptionSwitch.Companion;
          localObject1 = parame;
          kotlin.jvm.internal.j.d(localObject1, "info");
          localObject1 = new DetectionInfo(((OptionSwitch.Companion)localObject2).fromBoolean(((com.tplink.libtpmediaother.database.model.e)localObject1).l()).getRaw());
        }
        else
        {
          localObject1 = null;
        }
        if (bool2)
        {
          localObject3 = OptionSwitch.Companion;
          localObject2 = parame;
          kotlin.jvm.internal.j.d(localObject2, "info");
          localObject2 = new DetectionInfo(((OptionSwitch.Companion)localObject3).fromBoolean(((com.tplink.libtpmediaother.database.model.e)localObject2).v()).getRaw());
        }
        else
        {
          localObject2 = null;
        }
        if (bool4)
        {
          localObject3 = OptionSwitch.Companion;
          localObject4 = parame;
          kotlin.jvm.internal.j.d(localObject4, "info");
          localObject3 = ((OptionSwitch.Companion)localObject3).fromBoolean(((com.tplink.libtpmediaother.database.model.e)localObject4).K()).getRaw();
          localObject4 = parame;
          kotlin.jvm.internal.j.d(localObject4, "info");
          localObject3 = new TamperDetectConfig(null, (String)localObject3, ((com.tplink.libtpmediaother.database.model.e)localObject4).L());
        }
        else
        {
          localObject3 = null;
        }
        if (bool7)
        {
          localObject4 = locala.a;
          kotlin.jvm.internal.j.d(localObject4, "isSubscribed.result");
          if (((Boolean)localObject4).booleanValue())
          {
            localObject4 = parame;
            kotlin.jvm.internal.j.d(localObject4, "info");
            localObject4 = new HumanRecognitionInfo(((com.tplink.libtpmediaother.database.model.e)localObject4).s());
            break label535;
          }
        }
        Object localObject4 = null;
        label535:
        if (bool6)
        {
          localObject5 = locala.a;
          kotlin.jvm.internal.j.d(localObject5, "isSubscribed.result");
          if (((Boolean)localObject5).booleanValue())
          {
            localObject5 = parame;
            kotlin.jvm.internal.j.d(localObject5, "info");
            bool7 = ((com.tplink.libtpmediaother.database.model.e)localObject5).n();
            localObject5 = parame;
            kotlin.jvm.internal.j.d(localObject5, "info");
            localObject5 = e.n(((com.tplink.libtpmediaother.database.model.e)localObject5).o());
            kotlin.jvm.internal.j.d(localObject5, "HomeAwayDataUtils.transf…yingDetectionSensitivity)");
            localObject5 = new BabyCryingDetectionInfo(bool7, (String)localObject5);
            break label636;
          }
        }
        Object localObject5 = null;
        label636:
        if (bool8)
        {
          localObject6 = locala.a;
          kotlin.jvm.internal.j.d(localObject6, "isSubscribed.result");
          if (((Boolean)localObject6).booleanValue())
          {
            localObject6 = parame;
            kotlin.jvm.internal.j.d(localObject6, "info");
            localObject6 = new TargetTrackInfo(((com.tplink.libtpmediaother.database.model.e)localObject6).M());
            break label701;
          }
        }
        Object localObject6 = null;
        label701:
        Object localObject3 = localHomeAwayModeRepository.t(localMotionDetectConfig, localAlarmInfo, paramCameraComponent, (DetectionInfo)localObject1, (DetectionInfo)localObject2, (TamperDetectConfig)localObject3, (HumanRecognitionInfo)localObject4, (BabyCryingDetectionInfo)localObject5, (TargetTrackInfo)localObject6);
        kotlin.jvm.internal.j.d(localObject3, "homeAwayRepository.chang…ionInfo, targetTrackInfo)");
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        bool8 = paramCameraComponent.I();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        int j = paramCameraComponent.i();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        int k = paramCameraComponent.j();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        int m = paramCameraComponent.d();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        i = paramCameraComponent.e();
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        localObject4 = e.h(bool8, j, k, m, i, paramCameraComponent.b());
        kotlin.jvm.internal.j.d(localObject4, "HomeAwayDataUtils.genera…          info.alarmDays)");
        if (bool1)
        {
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          bool8 = paramCameraComponent.D();
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          j = paramCameraComponent.E();
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          i = paramCameraComponent.F();
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          m = paramCameraComponent.z();
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          k = paramCameraComponent.A();
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          paramCameraComponent = e.l(bool8, j, i, m, k, paramCameraComponent.y());
        }
        else
        {
          paramCameraComponent = null;
        }
        if (bool3)
        {
          localObject1 = parame;
          kotlin.jvm.internal.j.d(localObject1, "info");
          localObject1 = e.i(((com.tplink.libtpmediaother.database.model.e)localObject1).k());
        }
        else
        {
          localObject1 = null;
        }
        if (bool2)
        {
          localObject2 = parame;
          kotlin.jvm.internal.j.d(localObject2, "info");
          localObject2 = e.i(((com.tplink.libtpmediaother.database.model.e)localObject2).u());
        }
        else
        {
          localObject2 = null;
        }
        Object localObject2 = localHomeAwayModeRepository.u((AlarmPlanInfo)localObject4, paramCameraComponent, (ArmScheduleInfo)localObject1, (ArmScheduleInfo)localObject2);
        paramCameraComponent = parame;
        kotlin.jvm.internal.j.d(paramCameraComponent, "info");
        localObject1 = paramCameraComponent.H();
        kotlin.jvm.internal.j.d(localObject1, "info.regionList");
        paramCameraComponent = new ArrayList(kotlin.collections.l.l((Iterable)localObject1, 10));
        localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject1 = (e.c)((Iterator)localObject4).next();
          localObject5 = f.c;
          kotlin.jvm.internal.j.d(localObject1, "it");
          paramCameraComponent.add(f.a((f)localObject5, (e.c)localObject1));
        }
        localObject4 = e.j(paramCameraComponent);
        kotlin.jvm.internal.j.d(localObject4, "HomeAwayDataUtils.genera…{ it.asNetworkRegion() })");
        if (bool3)
        {
          paramCameraComponent = parame;
          kotlin.jvm.internal.j.d(paramCameraComponent, "info");
          paramCameraComponent = e.b(paramCameraComponent.m());
        }
        else
        {
          paramCameraComponent = null;
        }
        if (bool2)
        {
          localObject1 = parame;
          kotlin.jvm.internal.j.d(localObject1, "info");
          localObject1 = e.e(((com.tplink.libtpmediaother.database.model.e)localObject1).w());
        }
        else
        {
          localObject1 = null;
        }
        paramCameraComponent = localHomeAwayModeRepository.v((List)localObject4, paramCameraComponent, (HashMap)localObject1);
        if (bool1)
        {
          localObject1 = f.c;
          localObject4 = this.c.a;
          localObject5 = parame;
          kotlin.jvm.internal.j.d(localObject5, "info");
          f.b((f)localObject1, (String)localObject4, ((com.tplink.libtpmediaother.database.model.e)localObject5).B());
          paramCameraComponent = q.e1((t)localObject3, (t)localObject2, paramCameraComponent, a.a);
        }
        else
        {
          localObject1 = localMotionDetectionRepository;
          localObject4 = parame;
          kotlin.jvm.internal.j.d(localObject4, "info");
          paramCameraComponent = q.d1(((MotionDetectionRepository)localObject1).c0(((com.tplink.libtpmediaother.database.model.e)localObject4).G()), (t)localObject3, (t)localObject2, paramCameraComponent, new b(this));
        }
        return paramCameraComponent;
      }
      
      static final class a<T1, T2, T3, R>
        implements io.reactivex.g0.h<Boolean, Boolean, Boolean, Boolean>
      {
        public static final a a = new a();
        
        public final Boolean b(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3)
        {
          kotlin.jvm.internal.j.e(paramBoolean1, "configs");
          kotlin.jvm.internal.j.e(paramBoolean2, "plans");
          kotlin.jvm.internal.j.e(paramBoolean3, "regions");
          boolean bool;
          if ((paramBoolean1.booleanValue()) && (paramBoolean2.booleanValue()) && (paramBoolean3.booleanValue())) {
            bool = true;
          } else {
            bool = false;
          }
          return Boolean.valueOf(bool);
        }
      }
      
      static final class b<T1, T2, T3, T4, R>
        implements i<Boolean, Boolean, Boolean, Boolean, Boolean>
      {
        b(f.a.b paramb) {}
        
        public final Boolean b(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4)
        {
          kotlin.jvm.internal.j.e(paramBoolean1, "notificationSubscribe");
          kotlin.jvm.internal.j.e(paramBoolean2, "configs");
          kotlin.jvm.internal.j.e(paramBoolean3, "plans");
          kotlin.jvm.internal.j.e(paramBoolean4, "regions");
          boolean bool1 = paramBoolean2.booleanValue();
          boolean bool2 = true;
          if ((bool1) && (paramBoolean3.booleanValue()) && (paramBoolean4.booleanValue()))
          {
            bool1 = bool2;
            if (paramBoolean1.booleanValue()) {
              break label99;
            }
            paramBoolean1 = this.a.y;
            bool1 = bool2;
            if (paramBoolean1 == null) {
              break label99;
            }
            if (paramBoolean1.isRemote() != true)
            {
              bool1 = bool2;
              break label99;
            }
          }
          bool1 = false;
          label99:
          return Boolean.valueOf(bool1);
        }
      }
    }
    
    static final class c
      implements io.reactivex.g0.a
    {
      c(f.a parama) {}
      
      public final void run()
      {
        f.a locala = this.a;
        locala.b.remove(locala.a);
        if (this.a.b.isEmpty())
        {
          locala = this.a;
          locala.c.invoke(locala.d);
        }
      }
    }
    
    static final class d<T>
      implements g<Boolean>
    {
      d(f.a parama) {}
      
      public final void a(Boolean paramBoolean)
      {
        paramBoolean = this.c;
        paramBoolean.e.add(paramBoolean.a);
        paramBoolean = this.c;
        paramBoolean.f.invoke(Integer.valueOf(paramBoolean.e.size()));
      }
    }
    
    static final class e<T>
      implements g<Throwable>
    {
      e(f.a parama) {}
      
      public final void a(Throwable paramThrowable)
      {
        b.d.w.c.a.e(f.c.f(), Log.getStackTraceString(paramThrowable));
        paramThrowable = this.c;
        paramThrowable.d.add(paramThrowable.a);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\mode\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */