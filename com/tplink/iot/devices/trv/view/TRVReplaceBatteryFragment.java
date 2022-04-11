package com.tplink.iot.devices.trv.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.databinding.FragmentTrvReplaceBatteryBinding;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;

public final class TRVReplaceBatteryFragment
  extends BaseBottomSheetDialog<FragmentTrvReplaceBatteryBinding>
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
    return 2131558987;
  }
  
  public BottomSheetOptions P0()
  {
    return new BottomSheetOptions().fullscreen(true).topRoundCorner(true).skipCollapsed(true);
  }
  
  public void Q0()
  {
    ((FragmentTrvReplaceBatteryBinding)O0()).c.setOnClickListener(new a(this));
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(TRVReplaceBatteryFragment paramTRVReplaceBatteryFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismissAllowingStateLoss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVReplaceBatteryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */