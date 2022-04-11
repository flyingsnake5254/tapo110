package com.tplink.iot.devices.switches.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.databinding.FragmentSwitchReplaceBatteryBinding;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SwitchReplaceBatteryFragment
  extends BaseBottomSheetDialog<FragmentSwitchReplaceBatteryBinding>
{
  public static final a p1 = new a(null);
  private String p2 = "";
  private HashMap p3;
  
  @DrawableRes
  private final int U0()
  {
    String str = this.p2;
    int i;
    if ((str.hashCode() == 2522301) && (str.equals("S220"))) {
      i = 2131231000;
    } else {
      i = 2131230993;
    }
    return i;
  }
  
  public void A0()
  {
    HashMap localHashMap = this.p3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int L0()
  {
    return 2131558980;
  }
  
  public BottomSheetOptions P0()
  {
    return new BottomSheetOptions().fullscreen(true).topRoundCorner(true).skipCollapsed(true);
  }
  
  public void Q0()
  {
    ((FragmentSwitchReplaceBatteryBinding)O0()).c.setOnClickListener(new b(this));
    ((FragmentSwitchReplaceBatteryBinding)O0()).d.setImageResource(U0());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("ArgDeviceModel");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "S210";
    }
    this.p2 = paramBundle;
  }
  
  public static final class a
  {
    public final SwitchReplaceBatteryFragment a(String paramString)
    {
      j.e(paramString, "deviceModel");
      SwitchReplaceBatteryFragment localSwitchReplaceBatteryFragment = new SwitchReplaceBatteryFragment();
      Bundle localBundle = new Bundle();
      localBundle.putString("ArgDeviceModel", paramString);
      paramString = p.a;
      localSwitchReplaceBatteryFragment.setArguments(localBundle);
      return localSwitchReplaceBatteryFragment;
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(SwitchReplaceBatteryFragment paramSwitchReplaceBatteryFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismissAllowingStateLoss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\view\SwitchReplaceBatteryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */