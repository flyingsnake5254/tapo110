package com.tplink.iot.view.about;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public class PrivacySettingFragment_ViewBinding
  implements Unbinder
{
  private PrivacySettingFragment b;
  
  @UiThread
  public PrivacySettingFragment_ViewBinding(PrivacySettingFragment paramPrivacySettingFragment, View paramView)
  {
    this.b = paramPrivacySettingFragment;
    paramPrivacySettingFragment.mJoinUserExperienceSwitch = ((TPSwitchCompat)c.d(paramView, 2131364129, "field 'mJoinUserExperienceSwitch'", TPSwitchCompat.class));
    paramPrivacySettingFragment.mJoinUserExperienceDescTv = ((TextView)c.d(paramView, 2131364497, "field 'mJoinUserExperienceDescTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    PrivacySettingFragment localPrivacySettingFragment = this.b;
    if (localPrivacySettingFragment != null)
    {
      this.b = null;
      localPrivacySettingFragment.mJoinUserExperienceSwitch = null;
      localPrivacySettingFragment.mJoinUserExperienceDescTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\PrivacySettingFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */