package com.tplink.iot.devices.featuredactions.view;

import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment;
import com.tplink.iot.g.a.a.a;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class ButtonFeaturedActionChooseFragment
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
    return l.g(new a[] { T0("FA_TurnOnOffSmartDevices", 2131953725), T0("FA_AdjustBrightness", 2131953695), T0("FA_AdjustColorTemperature", 2131953680), T0("FA_SetRightMood", 2131953700), T0("FA_BuildSmartDoorbell", 2131953693) });
  }
  
  public void q0(a parama)
  {
    j.e(parama, "item");
    parama = parama.a();
    switch (parama.hashCode())
    {
    default: 
      break;
    case 1978741269: 
      if (parama.equals("FA_SetRightMood")) {
        FragmentKt.findNavController(this).navigate(2131361882, V0());
      }
      break;
    case 394014692: 
      if (parama.equals("FA_AdjustColorTemperature")) {
        FragmentKt.findNavController(this).navigate(2131361880, V0());
      }
      break;
    case 275394800: 
      if (parama.equals("FA_BuildSmartDoorbell")) {
        FragmentKt.findNavController(this).navigate(2131361881, V0());
      }
      break;
    case -1791188381: 
      if (parama.equals("FA_TurnOnOffSmartDevices")) {
        FragmentKt.findNavController(this).navigate(2131361883, V0());
      }
      break;
    case -2046614428: 
      if (parama.equals("FA_AdjustBrightness")) {
        FragmentKt.findNavController(this).navigate(2131361879, V0());
      }
      break;
    }
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\ButtonFeaturedActionChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */