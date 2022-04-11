package com.tplink.iot.devicecommon.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.base.BaseLocationFragment;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class DeviceLocationCheckFragment
  extends BaseLocationFragment
{
  public static final a x = new a(null);
  private b y;
  private HashMap z;
  
  public void K0()
  {
    b localb = this.y;
    if (localb != null) {
      localb.X();
    }
  }
  
  public void R0()
  {
    HashMap localHashMap = this.z;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void S0(AppCompatActivity paramAppCompatActivity)
  {
    j.e(paramAppCompatActivity, "activity");
    if (paramAppCompatActivity.getSupportFragmentManager().findFragmentByTag("DeviceLocationCheckFragment") != null) {
      return;
    }
    paramAppCompatActivity.getSupportFragmentManager().beginTransaction().add(this, "DeviceLocationCheckFragment").commitAllowingStateLoss();
  }
  
  public final void T0(b paramb)
  {
    j.e(paramb, "callback");
    this.y = paramb;
  }
  
  public static final class a
  {
    public final DeviceLocationCheckFragment a(DeviceLocationCheckFragment.b paramb)
    {
      j.e(paramb, "callback");
      DeviceLocationCheckFragment localDeviceLocationCheckFragment = new DeviceLocationCheckFragment();
      localDeviceLocationCheckFragment.T0(paramb);
      return localDeviceLocationCheckFragment;
    }
  }
  
  public static abstract interface b
  {
    public abstract void X();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\DeviceLocationCheckFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */