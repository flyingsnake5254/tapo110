package com.tplink.iot.view.about;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.model.about.c;
import com.tplink.iot.model.about.d;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import io.reactivex.a;

public class PrivacySettingFragment
  extends Fragment
{
  @BindView
  TextView mJoinUserExperienceDescTv;
  @BindView
  TPSwitchCompat mJoinUserExperienceSwitch;
  
  @SuppressLint({"CheckResult"})
  private void C0(boolean paramBoolean)
  {
    c.n(paramBoolean).l(new f(this)).A(new g(paramBoolean), new e(this, paramBoolean));
  }
  
  private void G0()
  {
    Intent localIntent = new Intent(getActivity(), AboutWebActivity.class);
    localIntent.putExtra("toolbar_title", getString(2131952069));
    localIntent.putExtra("url", d.g());
    startActivity(localIntent);
    getActivity().overridePendingTransition(2130772068, 2130772067);
  }
  
  private void H0()
  {
    this.mJoinUserExperienceSwitch.setChecked(c.f());
    this.mJoinUserExperienceSwitch.setOnSwitchCheckedChangeListener(new a());
    String str1 = getString(2131952887, new Object[] { getString(2131952888) });
    String str2 = getString(2131952888);
    d0.e(this.mJoinUserExperienceDescTv, str1, str2, getResources().getColor(2131099808), new b());
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558945, paramViewGroup, false);
    ButterKnife.b(this, paramLayoutInflater);
    H0();
    return paramLayoutInflater;
  }
  
  class a
    implements TPSwitchCompat.a
  {
    a() {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2) {
        PrivacySettingFragment.A0(PrivacySettingFragment.this, paramBoolean1);
      }
    }
  }
  
  class b
    implements d0.g
  {
    b() {}
    
    public void a()
    {
      PrivacySettingFragment.B0(PrivacySettingFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\PrivacySettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */