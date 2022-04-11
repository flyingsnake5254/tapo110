package com.tplink.iot.view.iotsensor;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.databinding.FragmentButtonReplaceBatteryBinding;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;

public final class ButtonReplaceBatteryFragment
  extends BaseBottomSheetDialog<FragmentButtonReplaceBatteryBinding>
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
    return 2131558860;
  }
  
  public BottomSheetOptions P0()
  {
    return new BottomSheetOptions().fullscreen(true).topRoundCorner(true).skipCollapsed(true);
  }
  
  public void Q0()
  {
    ((FragmentButtonReplaceBatteryBinding)O0()).c.setOnClickListener(new a(this));
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(ButtonReplaceBatteryFragment paramButtonReplaceBatteryFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismissAllowingStateLoss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\ButtonReplaceBatteryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */