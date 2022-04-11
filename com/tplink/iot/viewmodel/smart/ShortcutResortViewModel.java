package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShortcutResortViewModel
  extends AndroidViewModel
{
  private SmartRepository a;
  private SingleLiveEvent<List<SmartInfo>> b = new SingleLiveEvent();
  
  public ShortcutResortViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (SmartRepository)b.a(a.f(), SmartRepository.class);
    this.a = paramApplication;
    this.b.addSource(paramApplication.P(), new a());
  }
  
  private void h(List<SmartInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SmartInfo localSmartInfo = (SmartInfo)paramList.next();
        if ((localSmartInfo != null) && (localSmartInfo.getTriggerSetting() != null) && (localSmartInfo.getTriggerSetting().isManual())) {
          localArrayList.add(localSmartInfo);
        }
      }
    }
    this.b.postValue(localArrayList);
  }
  
  public void g()
  {
    this.a.S().F0();
  }
  
  public SingleLiveEvent<List<SmartInfo>> i()
  {
    return this.b;
  }
  
  public void j(List<SmartInfo> paramList)
  {
    this.a.D1(paramList);
  }
  
  class a
    implements Observer<List<SmartInfo>>
  {
    a() {}
    
    public void a(@Nullable List<SmartInfo> paramList)
    {
      ShortcutResortViewModel.f(ShortcutResortViewModel.this, paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\ShortcutResortViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */