package com.tplink.iot.base;

import android.content.Intent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.viewmodel.common.LocationViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.util.c;

public abstract class BaseLocationFragment
  extends BaseFragment
{
  private LocationViewModel q;
  
  private void J0()
  {
    if (com.tplink.iot.view.quicksetup.base.f.a.a(getActivity())) {
      L0();
    } else {
      startActivityForResult(new Intent(getActivity(), LocationPrepareActivity.class), 300);
    }
  }
  
  private void L0()
  {
    s0.l(getActivity());
    this.q.g();
  }
  
  private void P0()
  {
    new TPMaterialDialogV2.Builder(getContext()).j(getString(2131953797)).b(false).c(false).l(2131951763, 2131099804, null).o(2131951767, 2131099808, new b()).g(8, 8).a().show();
  }
  
  private void Q0()
  {
    LocationViewModel localLocationViewModel = this.q;
    if (localLocationViewModel != null) {
      localLocationViewModel.h().observe(this, new a());
    }
  }
  
  public void I0(String paramString)
  {
    if (this.q == null)
    {
      this.q = ((LocationViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramString)).get(LocationViewModel.class));
      Q0();
    }
    if (O0(paramString)) {
      K0();
    } else {
      P0();
    }
  }
  
  public abstract void K0();
  
  public LocalIoTBaseDevice N0(String paramString)
  {
    paramString = c.b(paramString);
    if ((paramString instanceof AbstractThingRepository)) {
      return (LocalIoTBaseDevice)((AbstractThingRepository)paramString).j1().getValue();
    }
    if ((paramString instanceof AbstractSubThingRepository)) {
      return (LocalIoTBaseDevice)((AbstractSubThingRepository)paramString).Y0().getValue();
    }
    return null;
  }
  
  public boolean O0(String paramString)
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
        LocalIoTBaseDevice localLocalIoTBaseDevice = N0(paramString);
        if (localLocalIoTBaseDevice != null)
        {
          paramString = new StringBuilder();
          paramString.append("hasSetLocationInfo: ");
          paramString.append(localLocalIoTBaseDevice.getNickname());
          paramString.append(" ");
          paramString.append(localLocalIoTBaseDevice.isHasSetLocationInfo());
          b.d.w.c.a.a(paramString.toString());
        }
        else
        {
          b.d.w.c.a.a("hasSetLocationInfo: null device false");
        }
        bool2 = bool1;
        if (localLocalIoTBaseDevice != null)
        {
          bool2 = bool1;
          if (localLocalIoTBaseDevice.isHasSetLocationInfo()) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 300) && (com.tplink.iot.view.quicksetup.base.f.a.a(getActivity()))) {
      L0();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
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
        BaseLocationFragment.this.K0();
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 30))
      {
        s0.g();
        s0.s(BaseLocationFragment.this.getActivity(), 2131952742);
      }
      else
      {
        s0.g();
        s0.n(BaseLocationFragment.this.getActivity(), 2131953328);
      }
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      BaseLocationFragment.H0(BaseLocationFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\base\BaseLocationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */