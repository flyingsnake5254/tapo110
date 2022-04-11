package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.c;
import com.tplink.libtpnetwork.cameranetwork.business.model.f;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;
import com.tplink.libtpnetwork.cameranetwork.business.model.p;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AIDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LineCrossingDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordPlanRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TamperDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanBean;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class RecordPlanViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public ObservableField<String> b = new ObservableField();
  public ObservableBoolean c = new ObservableBoolean(false);
  private RecordPlanRepository d;
  private MotionDetectionRepository e;
  private LineCrossingDetectionRepository f;
  private AreaIntrusionRepository g;
  private TamperDetectionRepository h;
  private AIDetectionRepository i;
  private io.reactivex.e0.b j = new io.reactivex.e0.b();
  private MediatorLiveData<o> k = new MediatorLiveData();
  private ArrayList<RecordPlanBean> l = new ArrayList();
  public MediatorLiveData<a<String>> m = new MediatorLiveData();
  private final String n;
  private final String o;
  private String p;
  
  public RecordPlanViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.n = paramApplication.getString(2131953854);
    this.o = paramApplication.getString(2131952609);
    D(false);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.p = paramApplication;
    this.e = ((MotionDetectionRepository)e.c(paramApplication, MotionDetectionRepository.class));
    this.d = ((RecordPlanRepository)e.c(this.p, RecordPlanRepository.class));
    this.f = ((LineCrossingDetectionRepository)e.c(this.p, LineCrossingDetectionRepository.class));
    this.g = ((AreaIntrusionRepository)e.c(this.p, AreaIntrusionRepository.class));
    this.h = ((TamperDetectionRepository)e.c(this.p, TamperDetectionRepository.class));
    this.i = ((AIDetectionRepository)e.c(this.p, AIDetectionRepository.class));
  }
  
  private static Pair<DayOfWeek, Schedule> E(RecordPlanBean paramRecordPlanBean)
  {
    int i1 = paramRecordPlanBean.getDayIndex();
    DayOfWeek localDayOfWeek;
    if (i1 == 0) {
      localDayOfWeek = DayOfWeek.SUNDAY;
    } else {
      localDayOfWeek = DayOfWeek.of(i1);
    }
    return new Pair(localDayOfWeek, new Schedule(paramRecordPlanBean.getStartTime() / 60, paramRecordPlanBean.getStartTime() % 60, paramRecordPlanBean.getEndTime() / 60, paramRecordPlanBean.getEndTime() % 60, paramRecordPlanBean.getRecordType()));
  }
  
  private static RecordPlanBean G(DayOfWeek paramDayOfWeek, Schedule paramSchedule)
  {
    int i1 = paramSchedule.getType();
    int i2;
    if (paramDayOfWeek == DayOfWeek.SUNDAY) {
      i2 = 0;
    } else {
      i2 = paramDayOfWeek.ordinal() + 1;
    }
    return new RecordPlanBean(i1, i2, paramSchedule.getStartHour() * 60 + paramSchedule.getStartMinute(), paramSchedule.getEndHour() * 60 + paramSchedule.getEndMinute());
  }
  
  private void I()
  {
    LiveData localLiveData = this.d.t();
    this.k.removeSource(localLiveData);
    MediatorLiveData localMediatorLiveData = this.k;
    localMediatorLiveData.getClass();
    localMediatorLiveData.addSource(localLiveData, new e9(localMediatorLiveData));
  }
  
  public void C(@Nullable String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.j.b(this.d.H().E(new n7(this)).N(new m7(this)).H0(new o7(this), new l7(this)));
  }
  
  public void D(boolean paramBoolean)
  {
    ObservableField localObservableField = this.b;
    String str;
    if (paramBoolean) {
      str = this.o;
    } else {
      str = this.n;
    }
    localObservableField.set(str);
    this.c.set(paramBoolean);
  }
  
  public String F(List<RecordPlanBean> paramList)
  {
    EnumMap localEnumMap = new EnumMap(DayOfWeek.class);
    TreeSet localTreeSet = new TreeSet();
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = E((RecordPlanBean)localIterator.next());
      localObject = (List)localEnumMap.get(localPair.first);
      paramList = (List<RecordPlanBean>)localObject;
      if (localObject == null) {
        paramList = new ArrayList();
      }
      paramList.add(localPair.second);
      localEnumMap.put(localPair.first, paramList);
    }
    Object localObject = localEnumMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (Map.Entry)((Iterator)localObject).next();
      if (((List)paramList.getValue()).size() > 10) {
        localTreeSet.add(paramList.getKey());
      }
    }
    if (localTreeSet.size() > 0)
    {
      paramList = localTreeSet.iterator();
      while (paramList.hasNext())
      {
        localObject = (DayOfWeek)paramList.next();
        if (localStringBuffer.length() == 0)
        {
          localStringBuffer.append(((Enum)localObject).name());
        }
        else
        {
          localStringBuffer.append(", ");
          localStringBuffer.append(((Enum)localObject).name());
        }
      }
      return localStringBuffer.toString();
    }
    if (this.d != null)
    {
      com.tplink.iot.Utils.x0.g.h(this.p, localEnumMap);
      this.a.set(true);
      paramList = this.d.K(localEnumMap).y(new i7(this)).H0(h7.c, new j7(this));
      this.j.b(paramList);
    }
    return null;
  }
  
  public void H(LifecycleOwner paramLifecycleOwner, Observer<ArrayList<RecordPlanBean>> paramObserver)
  {
    this.k.observe(paramLifecycleOwner, new k7(this, paramObserver));
  }
  
  public q<Boolean> f()
  {
    RecordPlanRepository localRecordPlanRepository = this.d;
    if (localRecordPlanRepository != null) {
      return localRecordPlanRepository.L(false);
    }
    return q.f0(Boolean.TRUE);
  }
  
  public String g()
  {
    return this.p;
  }
  
  public ArrayList<RecordPlanBean> h()
  {
    return this.l;
  }
  
  public boolean i()
  {
    RecordPlanRepository localRecordPlanRepository = this.d;
    if (localRecordPlanRepository != null) {
      return localRecordPlanRepository.w();
    }
    return false;
  }
  
  public boolean j()
  {
    MotionDetectionRepository localMotionDetectionRepository = this.e;
    boolean bool1 = true;
    if ((localMotionDetectionRepository != null) && (localMotionDetectionRepository.y() != null) && (this.e.y().e())) {
      return true;
    }
    localMotionDetectionRepository = this.e;
    int i1;
    if ((localMotionDetectionRepository != null) && (localMotionDetectionRepository.y() != null) && (org.apache.commons.lang.b.b(this.e.y().b()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool2 = bool1;
    if (!this.f.A().c())
    {
      bool2 = bool1;
      if (!this.g.z().c())
      {
        bool2 = bool1;
        if (!this.h.t().c())
        {
          bool2 = bool1;
          if (i1 == 0)
          {
            bool2 = bool1;
            if (!j.h(this.i.t())) {
              if (j.h(this.i.v())) {
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
  
  public boolean k()
  {
    RecordPlanRepository localRecordPlanRepository = this.d;
    if (localRecordPlanRepository != null) {
      return localRecordPlanRepository.x();
    }
    return false;
  }
  
  public boolean l()
  {
    return this.c.get();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\RecordPlanViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */