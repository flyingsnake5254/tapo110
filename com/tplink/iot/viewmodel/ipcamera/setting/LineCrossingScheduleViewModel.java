package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.iot.Utils.x0.d;
import com.tplink.libtpmediaother.database.model.e.a;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.f;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LineCrossingDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanBean;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.e0.b;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class LineCrossingScheduleViewModel
  extends AndroidViewModel
{
  private String a;
  private LineCrossingDetectionRepository b;
  public ObservableBoolean c = new ObservableBoolean(false);
  public ObservableField<String> d = new ObservableField();
  private ArrayList<RecordPlanBean> e = new ArrayList();
  private MutableLiveData<ArrayList<RecordPlanBean>> f = new MutableLiveData();
  public ObservableBoolean g = new ObservableBoolean(false);
  private final b h = new b();
  public MediatorLiveData<a<String>> i = new MediatorLiveData();
  private final String j;
  private final String k;
  private int l = 3;
  
  public LineCrossingScheduleViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.j = paramApplication.getString(2131953854);
    this.k = paramApplication.getString(2131952609);
    w(false);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.a = paramApplication;
    this.b = ((LineCrossingDetectionRepository)e.c(paramApplication, LineCrossingDetectionRepository.class));
  }
  
  private void A(Map<DayOfWeek, List<IntrusionSchedule>> paramMap)
  {
    int m = this.l;
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    paramMap = f(paramMap);
    l.s(this.a, bool, new m4(paramMap));
  }
  
  private static RecordPlanBean B(DayOfWeek paramDayOfWeek, IntrusionSchedule paramIntrusionSchedule)
  {
    int m;
    if (paramDayOfWeek == DayOfWeek.SUNDAY) {
      m = 0;
    } else {
      m = paramDayOfWeek.ordinal() + 1;
    }
    return new RecordPlanBean(1, m, paramIntrusionSchedule.getStartHour() * 60 + paramIntrusionSchedule.getStartMinute(), paramIntrusionSchedule.getEndHour() * 60 + paramIntrusionSchedule.getEndMinute());
  }
  
  private e.a f(Map<DayOfWeek, List<IntrusionSchedule>> paramMap)
  {
    return new e.a(ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.MONDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.TUESDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.THURSDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.FRIDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.SATURDAY)), ScheduleParser.formatIntrusionSchedules((List)paramMap.get(DayOfWeek.SUNDAY)));
  }
  
  private void g(f paramf)
  {
    for (DayOfWeek localDayOfWeek : )
    {
      Object localObject = paramf.b(localDayOfWeek);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          IntrusionSchedule localIntrusionSchedule = (IntrusionSchedule)((Iterator)localObject).next();
          this.e.add(B(localDayOfWeek, localIntrusionSchedule));
        }
      }
    }
  }
  
  private void v()
  {
    int m = this.l;
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    l.g(this.a, bool, new l4(this));
  }
  
  private void x(f paramf, e.a parama)
  {
    paramf.f(DayOfWeek.SUNDAY, ScheduleParser.parseIntrusionSchedules(parama.f()));
    paramf.f(DayOfWeek.MONDAY, ScheduleParser.parseIntrusionSchedules(parama.d()));
    paramf.f(DayOfWeek.TUESDAY, ScheduleParser.parseIntrusionSchedules(parama.h()));
    paramf.f(DayOfWeek.WEDNESDAY, ScheduleParser.parseIntrusionSchedules(parama.i()));
    paramf.f(DayOfWeek.THURSDAY, ScheduleParser.parseIntrusionSchedules(parama.g()));
    paramf.f(DayOfWeek.FRIDAY, ScheduleParser.parseIntrusionSchedules(parama.c()));
    paramf.f(DayOfWeek.SATURDAY, ScheduleParser.parseIntrusionSchedules(parama.e()));
  }
  
  private static Pair<DayOfWeek, IntrusionSchedule> y(RecordPlanBean paramRecordPlanBean)
  {
    int m = paramRecordPlanBean.getDayIndex();
    DayOfWeek localDayOfWeek;
    if (m == 0) {
      localDayOfWeek = DayOfWeek.SUNDAY;
    } else {
      localDayOfWeek = DayOfWeek.of(m);
    }
    return new Pair(localDayOfWeek, new IntrusionSchedule(paramRecordPlanBean.getStartTime() / 60, paramRecordPlanBean.getStartTime() % 60, paramRecordPlanBean.getEndTime() / 60, paramRecordPlanBean.getEndTime() % 60));
  }
  
  public ArrayList<RecordPlanBean> h()
  {
    return this.e;
  }
  
  public MutableLiveData<ArrayList<RecordPlanBean>> i()
  {
    return this.f;
  }
  
  public void j(int paramInt)
  {
    this.l = paramInt;
  }
  
  public boolean k()
  {
    return this.g.get();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.h.dispose();
  }
  
  public void u()
  {
    this.e.clear();
    if (this.l == 3) {
      g(this.b.A());
    } else {
      v();
    }
    this.f.postValue(this.e);
  }
  
  public void w(boolean paramBoolean)
  {
    ObservableField localObservableField = this.d;
    String str;
    if (paramBoolean) {
      str = this.k;
    } else {
      str = this.j;
    }
    localObservableField.set(str);
    this.g.set(paramBoolean);
  }
  
  public String z(List<RecordPlanBean> paramList)
  {
    EnumMap localEnumMap = new EnumMap(DayOfWeek.class);
    TreeSet localTreeSet = new TreeSet();
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = y((RecordPlanBean)localIterator.next());
      localObject = (List)localEnumMap.get(localPair.first);
      paramList = (List<RecordPlanBean>)localObject;
      if (localObject == null) {
        paramList = new ArrayList();
      }
      paramList.add(localPair.second);
      localEnumMap.put(localPair.first, paramList);
    }
    paramList = localEnumMap.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      if (((List)((Map.Entry)localObject).getValue()).size() > 6) {
        localTreeSet.add(((Map.Entry)localObject).getKey());
      }
    }
    if (localTreeSet.size() > 0)
    {
      localObject = localTreeSet.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (DayOfWeek)((Iterator)localObject).next();
        if (localStringBuffer.length() == 0)
        {
          localStringBuffer.append(paramList.name());
        }
        else
        {
          localStringBuffer.append(", ");
          localStringBuffer.append(paramList.name());
        }
      }
      return localStringBuffer.toString();
    }
    int m = this.l;
    boolean bool = true;
    if (m == 3)
    {
      if (this.b != null)
      {
        this.c.set(true);
        paramList = this.b.F(localEnumMap).y(new k4(this)).H0(j4.c, new i4(this));
        this.h.b(paramList);
      }
    }
    else {
      A(localEnumMap);
    }
    paramList = f(localEnumMap);
    Object localObject = this.a;
    if (this.l == 3) {
      bool = false;
    }
    d.e((String)localObject, paramList, bool);
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\LineCrossingScheduleViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */