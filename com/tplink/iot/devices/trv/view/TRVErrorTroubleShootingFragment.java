package com.tplink.iot.devices.trv.view;

import com.tplink.iot.databinding.FragmentTrvErrorTroubleShootingBinding;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;

public final class TRVErrorTroubleShootingFragment
  extends BaseBottomSheetDialog<FragmentTrvErrorTroubleShootingBinding>
{
  private HashMap p1;
  
  public void A0()
  {
    HashMap localHashMap = this.p1;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int L0()
  {
    return 2131558986;
  }
  
  public BottomSheetOptions P0()
  {
    return new BottomSheetOptions().fullscreen(true).topRoundCorner(true);
  }
  
  public void Q0() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVErrorTroubleShootingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */