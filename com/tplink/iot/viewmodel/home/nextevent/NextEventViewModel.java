package com.tplink.iot.viewmodel.home.nextevent;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.t;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NextEventViewModel
  extends AndroidViewModel
{
  private ThingCloudRepository a = (ThingCloudRepository)b.d.b.f.b.c(b.d.s.a.a.f()).a(ThingCloudRepository.class);
  private MutableLiveData<List<ThingNextEvent>> b = new MutableLiveData();
  private c c;
  private Comparator<ThingNextEvent> d = new c();
  
  public NextEventViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private List<ThingNextEvent> j(List<ThingNextEvent> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ThingNextEvent localThingNextEvent = (ThingNextEvent)localIterator.next();
        Object localObject = null;
        paramList = (List<ThingNextEvent>)localObject;
        if (localThingNextEvent != null)
        {
          paramList = (List<ThingNextEvent>)localObject;
          if (!TextUtils.isEmpty(localThingNextEvent.getThingName()))
          {
            BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1(b.d.w.h.a.g(localThingNextEvent.getThingName()));
            paramList = (List<ThingNextEvent>)localObject;
            if (localBaseALIoTDevice != null) {
              paramList = localBaseALIoTDevice.getDeviceRegion();
            }
          }
        }
        if (t.i(localThingNextEvent, paramList)) {
          localArrayList.add(localThingNextEvent);
        }
      }
    }
    return localArrayList;
  }
  
  private boolean n(List<ThingNextEvent> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ThingNextEvent)paramList.next()).getNextEvent().getType() == 2) {
        return true;
      }
    }
    return false;
  }
  
  private void o(final List<ThingNextEvent> paramList)
  {
    p();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, k());
      if (!n(paramList))
      {
        this.b.postValue(paramList);
        return;
      }
      this.c = q.a0(0L, 1L, TimeUnit.SECONDS).E(new d(paramList)).F0();
    }
    else
    {
      this.b.postValue(paramList);
    }
  }
  
  private void r(List<ThingNextEvent> paramList)
  {
    long l = System.currentTimeMillis() / 1000L;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      NextEvent localNextEvent = ((ThingNextEvent)localIterator.next()).getNextEvent();
      if (localNextEvent.getType() == 2)
      {
        int i = (int)(localNextEvent.getStartTime() - l);
        if (i < 0) {
          localIterator.remove();
        } else {
          localNextEvent.setEndTime(i);
        }
      }
    }
    if (!n(paramList)) {
      p();
    }
  }
  
  public Comparator<ThingNextEvent> k()
  {
    return this.d;
  }
  
  @SuppressLint({"CheckResult"})
  public void l(String paramString)
  {
    this.a.b0(paramString).H0(new a(), new b());
  }
  
  public MutableLiveData<List<ThingNextEvent>> m()
  {
    return this.b;
  }
  
  public void p()
  {
    c localc = this.c;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  class a
    implements g<List<ThingNextEvent>>
  {
    a() {}
    
    public void a(List<ThingNextEvent> paramList)
      throws Exception
    {
      paramList = NextEventViewModel.f(NextEventViewModel.this, paramList);
      NextEventViewModel.g(NextEventViewModel.this, paramList);
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      NextEventViewModel.this.p();
      NextEventViewModel.h(NextEventViewModel.this).postValue(new ArrayList());
    }
  }
  
  class c
    implements Comparator<ThingNextEvent>
  {
    c() {}
    
    public int a(ThingNextEvent paramThingNextEvent1, ThingNextEvent paramThingNextEvent2)
    {
      if ((paramThingNextEvent1.getNextEvent() != null) && (paramThingNextEvent2.getNextEvent() != null)) {
        return paramThingNextEvent1.getNextEvent().getStartTime() - paramThingNextEvent2.getNextEvent().getStartTime();
      }
      return 1;
    }
  }
  
  class d
    implements g<Long>
  {
    d(List paramList) {}
    
    public void a(Long paramLong)
      throws Exception
    {
      NextEventViewModel.i(NextEventViewModel.this, paramList);
      NextEventViewModel.h(NextEventViewModel.this).postValue(paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\nextevent\NextEventViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */