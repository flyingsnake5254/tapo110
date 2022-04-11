package com.tplink.iot.viewmodel.home;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.x0.j;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HomeBaseViewModel
  extends AndroidViewModel
{
  TPIoTClientManager c;
  FamilyManagerRepository d;
  ThingCloudRepository f;
  GroupRepository q;
  r x;
  FirmwareManager y;
  
  HomeBaseViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.c = ((TPIoTClientManager)b.d.b.f.b.a(paramApplication, TPIoTClientManager.class));
    this.d = ((FamilyManagerRepository)b.d.b.f.b.a(paramApplication, FamilyManagerRepository.class));
    this.f = ((ThingCloudRepository)b.d.b.f.b.a(paramApplication, ThingCloudRepository.class));
    this.q = ((GroupRepository)b.d.b.f.b.a(paramApplication, GroupRepository.class));
    this.y = ((FirmwareManager)b.d.b.f.b.a(paramApplication, FirmwareManager.class));
    this.x = r.g();
  }
  
  private void t(List<e> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (e)paramList.next();
      if ((localObject instanceof k))
      {
        localObject = ((k)localObject).g();
        if (localObject != null)
        {
          ((BaseALIoTDevice)localObject).setCommonDevice(paramBoolean);
          if (!TextUtils.isEmpty(((BaseALIoTDevice)localObject).getDeviceId())) {
            localArrayList1.add(((BaseALIoTDevice)localObject).getDeviceId());
          }
        }
      }
      else if ((localObject instanceof com.tplink.iot.model.home.g))
      {
        localObject = (com.tplink.iot.model.home.g)localObject;
        if (!TextUtils.isEmpty(((com.tplink.iot.model.home.g)localObject).i())) {
          localArrayList2.add(((com.tplink.iot.model.home.g)localObject).i());
        }
      }
    }
    k();
    if (!localArrayList1.isEmpty()) {
      this.f.m1(localArrayList1, paramBoolean).F0();
    }
    if (!localArrayList2.isEmpty()) {
      this.q.w0(localArrayList2, paramBoolean).y();
    }
  }
  
  public void f(List<e> paramList)
  {
    t(paramList, true);
  }
  
  public FamilyInfo g()
  {
    return this.d.X();
  }
  
  boolean h(k paramk)
  {
    return this.d.j0(paramk.w(), paramk.u(), paramk.i());
  }
  
  boolean i(com.tplink.iot.model.home.g paramg)
  {
    return this.d.k0(paramg.g());
  }
  
  boolean j()
  {
    boolean bool;
    if ((b.d.w.f.b.j(getApplication())) && (b.d.w.f.b.i(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract void k();
  
  protected abstract void l(String paramString);
  
  public void m(List<e> paramList)
  {
    t(paramList, false);
  }
  
  protected abstract void n(String paramString);
  
  public void o(List<e> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (e)paramList.next();
        if ((localObject instanceof k))
        {
          localObject = (k)localObject;
          l(((k)localObject).l());
          if (((k)localObject).g() != null) {
            localArrayList1.add(((k)localObject).g());
          }
        }
        else if ((localObject instanceof com.tplink.iot.model.home.g))
        {
          localObject = (com.tplink.iot.model.home.g)localObject;
          n(((com.tplink.iot.model.home.g)localObject).e());
          if (!TextUtils.isEmpty(((com.tplink.iot.model.home.g)localObject).i())) {
            localArrayList2.add(((com.tplink.iot.model.home.g)localObject).i());
          }
        }
      }
      v();
      if (!localArrayList1.isEmpty()) {
        this.c.m1(localArrayList1);
      }
      if (!localArrayList2.isEmpty()) {
        this.q.K(localArrayList2).y();
      }
    }
  }
  
  public void p(boolean paramBoolean, String paramString)
  {
    this.x.l(paramBoolean, paramString);
  }
  
  public void r(boolean paramBoolean, String paramString)
  {
    this.x.m(paramBoolean, paramString);
  }
  
  public void s(final String paramString, boolean paramBoolean)
  {
    final long l = System.currentTimeMillis();
    p(false, paramString);
    this.c.h2(paramString).i(paramBoolean).r(io.reactivex.d0.b.a.a()).j(new b(paramString, l)).i(new a(paramString, l)).y();
  }
  
  public void u()
  {
    this.x.k();
  }
  
  protected abstract void v();
  
  class a
    implements io.reactivex.g0.a
  {
    a(String paramString, long paramLong) {}
    
    public void run()
      throws Exception
    {
      j.c(paramString, System.currentTimeMillis() - l, true);
    }
  }
  
  class b
    implements io.reactivex.g0.g<Throwable>
  {
    b(String paramString, long paramLong) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        w.f();
      }
      j.c(paramString, System.currentTimeMillis() - l, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\HomeBaseViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */