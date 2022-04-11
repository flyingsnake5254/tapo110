package com.tplink.iot.devices.featuredactions.view;

import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment;
import com.tplink.iot.g.a.a.a;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class HubFeaturedActionChooseFragment
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
    return l.g(new a[] { T0("FA_SecureDoorOrWindow", 2131953713), T0("FA_BuildSmartDoorbell", 2131953692), T0("FA_BuildNeedHelpButton", 2131953686) });
  }
  
  public void q0(a parama)
  {
    j.e(parama, "item");
    parama = parama.a();
    switch (parama.hashCode())
    {
    default: 
      break;
    case 1470499362: 
      if (parama.equals("FA_LeaveHomeWithConfidence")) {
        FragmentKt.findNavController(this).navigate(2131361896, V0());
      }
      break;
    case 452069246: 
      if (parama.equals("FA_SleepWithPeaceOfMind")) {
        FragmentKt.findNavController(this).navigate(2131361898, V0());
      }
      break;
    case 275394800: 
      if (parama.equals("FA_BuildSmartDoorbell")) {
        FragmentKt.findNavController(this).navigate(2131361895, V0());
      }
      break;
    case -430752909: 
      if (parama.equals("FA_BuildNeedHelpButton")) {
        FragmentKt.findNavController(this).navigate(2131361894, V0());
      }
      break;
    case -507879236: 
      if (parama.equals("FA_SecureDoorOrWindow")) {
        FragmentKt.findNavController(this).navigate(2131361897, V0());
      }
      break;
    }
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\HubFeaturedActionChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */