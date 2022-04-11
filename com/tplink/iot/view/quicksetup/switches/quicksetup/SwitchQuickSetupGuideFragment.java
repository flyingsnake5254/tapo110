package com.tplink.iot.view.quicksetup.switches.quicksetup;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.FragmentSwitchQuicksetupGuideBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment.a;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class SwitchQuickSetupGuideFragment
  extends SwitchQuickSetupBaseFragment<FragmentSwitchQuicksetupGuideBinding>
{
  public static final a p3 = new a(null);
  private HashMap H3;
  
  private final void Q0()
  {
    if (L0() == SwitchButton.FIRST) {
      O0().E0(20001);
    } else {
      O0().E0(20002);
    }
  }
  
  @DrawableRes
  private final int R0()
  {
    SwitchButton localSwitchButton = L0();
    int i = a.a[localSwitchButton.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        i = 2131690070;
      } else {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      i = 2131690064;
    }
    return i;
  }
  
  private final void S0()
  {
    z1 localz1 = N0();
    if (localz1 != null) {
      localz1.e0("SwitchQuickSetupNameFragment", SwitchQuickSetupBaseFragment.q.a(L0()));
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.H3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int J0()
  {
    return 2131558979;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    P0().U(O0().r());
    P0().O(O0().t());
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362831) {
        Q0();
      }
    }
    else {
      S0();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    if (L0() == SwitchButton.FIRST)
    {
      paramView = N0();
      if (paramView != null) {
        paramView.q0();
      }
    }
    else
    {
      ((FragmentSwitchQuicksetupGuideBinding)K0()).d.setImageResource(2131689501);
      paramView = ((FragmentSwitchQuicksetupGuideBinding)K0()).d;
      j.d(paramView, "mBinding.imgClose");
      i.l(paramView);
      paramView = ((FragmentSwitchQuicksetupGuideBinding)K0()).x;
      j.d(paramView, "mBinding.tvTitle");
      i.k(paramView);
      ((FragmentSwitchQuicksetupGuideBinding)K0()).q.setText(2131954197);
    }
    ((FragmentSwitchQuicksetupGuideBinding)K0()).f.setImageResource(R0());
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\quicksetup\SwitchQuickSetupGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */