package com.tplink.iot.devices.featuredactions.view;

import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment;
import com.tplink.iot.g.a.a.a;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class MotionSensorFeaturedActionChooseFragment
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
    return l.g(new a[] { T0("FA_SetNightLight", 2131953717), T0("FA_SetAutomaticLighting", 2131953715) });
  }
  
  public void q0(a parama)
  {
    j.e(parama, "item");
    parama = parama.a();
    int i = parama.hashCode();
    if (i != -1700897934)
    {
      if (i != 1589685049)
      {
        if ((i == 1996381500) && (parama.equals("FA_SetNightLight"))) {
          FragmentKt.findNavController(this).navigate(2131361910, V0());
        }
      }
      else if (parama.equals("FA_SetAutomaticLighting")) {
        FragmentKt.findNavController(this).navigate(2131361909, V0());
      }
    }
    else if (parama.equals("FA_BuildSmartAlarm")) {
      FragmentKt.findNavController(this).navigate(2131361908, V0());
    }
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\MotionSensorFeaturedActionChooseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */