package com.tplink.iot.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.x0.s;
import com.tplink.iot.view.quicksetup.base.f.a;
import com.tplink.iot.viewmodel.common.LocationViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.util.c;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;

public abstract class BaseLocationActivity
  extends BaseActivity
{
  private LocationViewModel y;
  
  private void g1()
  {
    if (a.a(this)) {
      i1();
    } else {
      startActivityForResult(new Intent(this, LocationPrepareActivity.class), 200);
    }
  }
  
  private void i1()
  {
    s0.l(this);
    this.y.g();
  }
  
  private void l1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953797)).b(false).c(false).l(2131951763, 2131099804, null).o(2131951767, 2131099808, new b()).g(8, 8).a().show();
  }
  
  private void m1()
  {
    LocationViewModel localLocationViewModel = this.y;
    if (localLocationViewModel != null) {
      localLocationViewModel.h().observe(this, new a());
    }
  }
  
  public void f1(String paramString)
  {
    if (this.y == null)
    {
      this.y = ((LocationViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramString)).get(LocationViewModel.class));
      m1();
    }
    if (k1(paramString))
    {
      h1();
    }
    else
    {
      l1();
      s.b(paramString);
    }
  }
  
  public abstract void h1();
  
  public LocalIoTBaseDevice j1(String paramString)
  {
    ThingBaseRepository localThingBaseRepository = c.b(paramString);
    if ((localThingBaseRepository instanceof AbstractThingRepository)) {
      return (LocalIoTBaseDevice)((AbstractThingRepository)localThingBaseRepository).j1().getValue();
    }
    if ((localThingBaseRepository instanceof AbstractSubThingRepository))
    {
      paramString = TPIoTClientManager.k2(paramString).getIoTDevice();
      if ((paramString != null) && ((paramString.getLocalIoTDevice() instanceof LocalIoTBaseDevice))) {
        return (LocalIoTBaseDevice)paramString.getLocalIoTDevice();
      }
      return (LocalIoTBaseDevice)((AbstractSubThingRepository)localThingBaseRepository).Y0().getValue();
    }
    return null;
  }
  
  public boolean k1(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      if (paramString.isEmpty())
      {
        bool2 = bool1;
      }
      else
      {
        paramString = j1(paramString);
        bool2 = bool1;
        if (paramString != null)
        {
          bool2 = bool1;
          if (paramString.isHasSetLocationInfo()) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 200) && (a.a(this))) {
      i1();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  class a
    implements Observer<Integer>
  {
    a() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      if ((paramInteger != null) && (paramInteger.intValue() == 0))
      {
        s0.g();
        BaseLocationActivity.this.h1();
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 64524))
      {
        s0.g();
        w.f();
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 30))
      {
        s0.g();
        s0.s(BaseLocationActivity.this, 2131952742);
      }
      else
      {
        s0.g();
        s0.n(BaseLocationActivity.this, 2131953328);
      }
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      BaseLocationActivity.e1(BaseLocationActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\base\BaseLocationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */