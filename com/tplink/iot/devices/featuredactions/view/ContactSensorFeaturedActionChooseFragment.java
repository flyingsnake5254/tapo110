package com.tplink.iot.devices.featuredactions.view;

import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment;
import com.tplink.iot.g.a.a.a;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class ContactSensorFeaturedActionChooseFragment
  extends AbstractFeaturedActionChooseFragment
{
  public static final a H3 = new a(null);
  private HashMap I3;
  
  public void H0()
  {
    HashMap localHashMap = this.I3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public List<a> U0()
  {
    return l.g(new a[] { T0("FA_LightWayWhenArrivingHome", 2131953709), T0("FA_SecureDoorOrWindow", 2131953713) });
  }
  
  public void q0(a parama)
  {
    j.e(parama, "item");
    parama = parama.a();
    int i = parama.hashCode();
    if (i != -1700897934)
    {
      if (i != -507879236)
      {
        if ((i == 399091818) && (parama.equals("FA_LightWayWhenArrivingHome"))) {
          FragmentKt.findNavController(this).navigate(2131361886, V0());
        }
      }
      else if (parama.equals("FA_SecureDoorOrWindow")) {
        FragmentKt.findNavController(this).navigate(2131361887, V0());
      }
    }
    else if (parama.equals("FA_BuildSmartAlarm")) {
      FragmentKt.findNavController(this).navigate(2131361885, V0());
    }
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\ContactSensorFeaturedActionChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */