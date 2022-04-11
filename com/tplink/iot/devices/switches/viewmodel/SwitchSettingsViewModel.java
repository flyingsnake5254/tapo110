package com.tplink.iot.devices.switches.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.g.c.a.b;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import io.reactivex.q;
import kotlin.t.c;

public final class SwitchSettingsViewModel
  extends IoTSettingsBaseViewModel
{
  private final c p;
  private final LiveData<DelayActionInfoBean> q;
  private final LiveData<String> r;
  private final boolean s;
  private final boolean t;
  
  public SwitchSettingsViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
    this.p = new a(paramThingContext);
    this.q = E().l4();
    paramApplication = Transformations.map(E().n4(), b.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mSwi…ff)\n        } ?: \"\"\n    }");
    this.r = paramApplication;
    this.s = a.f(paramThingContext, EnumIoTComponent.DELAY_ACTION);
    this.t = a.f(paramThingContext, EnumIoTComponent.DOUBLE_CLICK);
  }
  
  private final SwitchRepository E()
  {
    return (SwitchRepository)this.p.b(this, o[0]);
  }
  
  public final void A()
  {
    E().k4().F0();
  }
  
  public final LiveData<DelayActionInfoBean> B()
  {
    return this.q;
  }
  
  public final void C()
  {
    E().m4().F0();
  }
  
  public final LiveData<String> D()
  {
    return this.r;
  }
  
  public final boolean F()
  {
    return this.s;
  }
  
  public final boolean G()
  {
    return this.t;
  }
  
  public int l(String paramString)
  {
    EnumSwitchAvatarType localEnumSwitchAvatarType = EnumSwitchAvatarType.fromString(paramString);
    paramString = (BaseALIoTDevice)j().getValue();
    if (paramString != null) {
      paramString = paramString.getDeviceModel();
    } else {
      paramString = null;
    }
    return b.b(localEnumSwitchAvatarType, paramString);
  }
  
  public void m()
  {
    E().Z0().F0();
  }
  
  public void o()
  {
    E().g1().F0();
  }
  
  public LiveData<ThingFirmware> p()
  {
    MutableLiveData localMutableLiveData = E().h1();
    kotlin.jvm.internal.j.d(localMutableLiveData, "mSwitchRepository.firmwareLatestInfoData");
    return localMutableLiveData;
  }
  
  public static final class a
    implements c<Object, SwitchRepository>
  {
    private final SwitchRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, SwitchRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public SwitchRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class b<I, O>
    implements Function<DoubleClickInfoBean, String>
  {
    public static final b a = new b();
    
    public final String a(DoubleClickInfoBean paramDoubleClickInfoBean)
    {
      if (paramDoubleClickInfoBean != null)
      {
        AppContext localAppContext = AppContext.c;
        int i;
        if (paramDoubleClickInfoBean.getEnable()) {
          i = 2131954119;
        } else {
          i = 2131954118;
        }
        paramDoubleClickInfoBean = localAppContext.getString(i);
        if (paramDoubleClickInfoBean != null) {}
      }
      else
      {
        paramDoubleClickInfoBean = "";
      }
      return paramDoubleClickInfoBean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\viewmodel\SwitchSettingsViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */