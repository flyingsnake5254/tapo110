package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SmartLogViewModel
  extends AndroidViewModel
{
  private com.tplink.cloud.context.b a;
  private SmartRepository b;
  private SingleLiveEvent<List<SmartLog>> c = new SingleLiveEvent();
  
  public SmartLogViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = paramApplication;
    paramApplication = (SmartRepository)b.d.b.f.b.a(paramApplication, SmartRepository.class);
    this.b = paramApplication;
    this.c.addSource(paramApplication.i0(), new l(this));
    this.c.addSource(this.b.e0(), new m(this));
  }
  
  private boolean n(List<SmartLog> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SmartLog localSmartLog = (SmartLog)paramList.next();
        if ((localSmartLog.getTimestamp() == null) || (localSmartLog.getTriggerId() == null) || (localSmartLog.getSmartId() == null)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean o(@NonNull List<SmartLog> paramList1, @NonNull List<SmartLog> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      SmartLog localSmartLog1 = (SmartLog)paramList1.get(i);
      SmartLog localSmartLog2 = (SmartLog)paramList2.get(i);
      if ((localSmartLog1.getTimestamp().equals(localSmartLog2.getTimestamp())) && (localSmartLog1.getTriggerId().equals(localSmartLog2.getTriggerId())) && (localSmartLog1.getSmartId().equals(localSmartLog2.getSmartId()))) {
        i++;
      } else {
        return false;
      }
    }
    return true;
  }
  
  private void s(List<SmartLog> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        SmartLog localSmartLog = (SmartLog)localIterator.next();
        if (!localHashSet.contains(localSmartLog.getId()))
        {
          localArrayList.add(localSmartLog);
          localHashSet.add(localSmartLog.getId());
        }
      }
      localHashSet.clear();
      paramList.clear();
      paramList.addAll(localArrayList);
    }
  }
  
  private void u(List<SmartLog> paramList)
  {
    List localList = j();
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = localList;
    if (!n(localList)) {
      paramList = new ArrayList();
    }
    paramList.addAll((Collection)localObject);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).add(5, -30);
    long l = ((Calendar)localObject).getTimeInMillis();
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (Long.parseLong(((SmartLog)((Iterator)localObject).next()).getTimestamp()) * 1000L < l) {
        ((Iterator)localObject).remove();
      }
    }
    s(paramList);
    t(paramList);
    this.c.postValue(paramList);
  }
  
  private void v(List<SmartLog> paramList)
  {
    List localList = j();
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if ((((List)localObject).size() < 100) && (n(localList)) && (!o((List)localObject, localList))) {
      ((List)localObject).addAll(localList);
    }
    paramList = Calendar.getInstance();
    paramList.add(5, -30);
    long l = paramList.getTimeInMillis();
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext()) {
      if (Long.parseLong(((SmartLog)paramList.next()).getTimestamp()) * 1000L < l) {
        paramList.remove();
      }
    }
    s((List)localObject);
    t((List)localObject);
    this.c.postValue(localObject);
  }
  
  public void f()
  {
    this.b.G().y();
  }
  
  public SingleLiveEvent<Boolean> g()
  {
    return this.b.Y();
  }
  
  public SingleLiveEvent<List<SmartLog>> h()
  {
    return this.c;
  }
  
  public void i(Integer paramInteger)
  {
    this.b.g0(null, paramInteger).F0();
  }
  
  public List<SmartLog> j()
  {
    if ((this.a.c() != null) && (this.a.c().getCloudUserName() != null))
    {
      List localList = b.d.w.d.a.c(b.d.w.h.a.g(this.a.c().getCloudUserName()), "smart_log_cache_list", "smart_log_cache_list", SmartLog.class);
      if ((localList != null) && (!localList.isEmpty())) {
        s(localList);
      }
      return localList;
    }
    return new ArrayList();
  }
  
  public Integer k()
  {
    List localList = j();
    if (n(localList)) {
      return Integer.valueOf(Integer.parseInt(((SmartLog)localList.get(localList.size() - 1)).getTimestamp()));
    }
    return Integer.valueOf(0);
  }
  
  public void l(Integer paramInteger)
  {
    this.b.h0(paramInteger, null).F0();
  }
  
  public Integer m()
  {
    List localList = j();
    if (n(localList)) {
      return Integer.valueOf(Integer.parseInt(((SmartLog)localList.get(0)).getTimestamp()));
    }
    return Integer.valueOf(0);
  }
  
  public void t(List<SmartLog> paramList)
  {
    if ((this.a.c() != null) && (this.a.c().getCloudUserName() != null)) {
      b.d.w.d.a.l(b.d.w.h.a.g(this.a.c().getCloudUserName()), paramList, "smart_log_cache_list", "smart_log_cache_list");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\SmartLogViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */