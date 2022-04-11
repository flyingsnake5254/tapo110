package com.tplink.iot.viewmodel.home;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.iot.model.notification.NotificationCenterManager;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;

public class NotificationCenterViewModel
  extends AndroidViewModel
{
  private NotificationCenterManager a;
  private MediatorLiveData<List<NotificationMsgBean>> b = new MediatorLiveData();
  private MutableLiveData<Boolean> c = new MutableLiveData();
  
  public NotificationCenterViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (NotificationCenterManager)b.a(b.d.s.a.a.f(), NotificationCenterManager.class);
    this.a = paramApplication;
    this.b.addSource(paramApplication.w(), new a());
  }
  
  public boolean h(List<NotificationMsgBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!((NotificationMsgBean)paramList.next()).isReadFlag()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void i(List<NotificationMsgBean> paramList)
  {
    this.a.r(paramList).i(new c()).j(new b()).y();
  }
  
  public LiveData<Boolean> j()
  {
    return this.c;
  }
  
  public void k()
  {
    this.a.t().F0();
  }
  
  public LiveData<List<NotificationMsgBean>> l()
  {
    return this.b;
  }
  
  public LiveData<Boolean> m()
  {
    return this.a.y();
  }
  
  public void n(List<NotificationMsgBean> paramList)
  {
    this.a.M(paramList).y();
  }
  
  public void o(boolean paramBoolean)
  {
    this.a.R(paramBoolean);
  }
  
  class a
    implements Observer<List<NotificationMsgBean>>
  {
    a() {}
    
    public void a(@Nullable List<NotificationMsgBean> paramList)
    {
      NotificationCenterViewModel.f(NotificationCenterViewModel.this).postValue(paramList);
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      NotificationCenterViewModel.g(NotificationCenterViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class c
    implements io.reactivex.g0.a
  {
    c() {}
    
    public void run()
      throws Exception
    {
      NotificationCenterViewModel.g(NotificationCenterViewModel.this).postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\NotificationCenterViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */