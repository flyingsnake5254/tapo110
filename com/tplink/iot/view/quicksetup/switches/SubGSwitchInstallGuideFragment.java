package com.tplink.iot.view.quicksetup.switches;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.databinding.FragmentSubgSwitchHowToInstallBinding;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SubGSwitchInstallGuideFragment
  extends BaseBottomSheetDialog<FragmentSubgSwitchHowToInstallBinding>
{
  public static final a p1 = new a(null);
  private String p2 = "";
  private HashMap p3;
  
  public static final SubGSwitchInstallGuideFragment U0(String paramString)
  {
    return p1.a(paramString);
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
    return 2131558978;
  }
  
  public BottomSheetOptions P0()
  {
    return new BottomSheetOptions().fullscreen(true).noDim(true).topRoundCorner(false);
  }
  
  public void Q0()
  {
    ((FragmentSubgSwitchHowToInstallBinding)O0()).c.setOnClickListener(new b(this));
    String str = this.p2;
    int i = str.hashCode();
    if (i != 2522270)
    {
      if ((i == 2522301) && (str.equals("S220"))) {
        ((FragmentSubgSwitchHowToInstallBinding)O0()).d.setImageResource(2131690424);
      }
    }
    else if (str.equals("S210")) {
      ((FragmentSubgSwitchHowToInstallBinding)O0()).d.setImageResource(2131690423);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("DeviceModel");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "";
    }
    this.p2 = paramBundle;
  }
  
  public static final class a
  {
    public final SubGSwitchInstallGuideFragment a(String paramString)
    {
      j.e(paramString, "deviceModel");
      SubGSwitchInstallGuideFragment localSubGSwitchInstallGuideFragment = new SubGSwitchInstallGuideFragment();
      Bundle localBundle = new Bundle();
      localBundle.putString("DeviceModel", paramString);
      paramString = p.a;
      localSubGSwitchInstallGuideFragment.setArguments(localBundle);
      return localSubGSwitchInstallGuideFragment;
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(SubGSwitchInstallGuideFragment paramSubGSwitchInstallGuideFragment) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismiss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\SubGSwitchInstallGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */