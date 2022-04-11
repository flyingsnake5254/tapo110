package com.tplink.iot.view.quicksetup.switches.quicksetup;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.FragmentSubGSetupNameBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment.a;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import com.tplink.iot.widget.DrawableEditText;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class SwitchQuickSetupNameFragment
  extends SwitchQuickSetupBaseFragment<FragmentSubGSetupNameBinding>
{
  public static final a p3 = new a(null);
  private CharSequence H3 = "";
  private HashMap I3;
  
  @StringRes
  private final int T0()
  {
    SwitchButton localSwitchButton = L0();
    int i = b.a[localSwitchButton.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        i = 2131954201;
      } else {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      i = 2131954199;
    }
    return i;
  }
  
  private final void U0()
  {
    ((FragmentSubGSetupNameBinding)K0()).d.f(new b(this));
  }
  
  private final void V0()
  {
    String str = P0().B(L0());
    if (!(m.r(str) ^ true))
    {
      str = getString(2131954061);
      j.d(str, "getString(R.string.smart_switch)");
    }
    this.H3 = str;
    O0().m.set(str);
    ((FragmentSubGSetupNameBinding)K0()).d.m();
  }
  
  private final void W0()
  {
    P0().N(L0(), this.H3.toString());
    z1 localz1 = N0();
    if (localz1 != null) {
      localz1.e0("SwitchQuickSetupAvatarFragment", SwitchQuickSetupBaseFragment.q.a(L0()));
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.I3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int J0()
  {
    return 2131558973;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362831) {
        O0().E0(20002);
      }
    }
    else {
      W0();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tplink.iot.view.quicksetup.base.d.i0(getActivity());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    paramView = (FragmentSubGSetupNameBinding)K0();
    paramView.f.setImageResource(2131689501);
    paramBundle = paramView.f;
    j.d(paramBundle, "imgClose");
    i.l(paramBundle);
    paramView.y.setText(2131954200);
    paramView.x.setText(T0());
    V0();
    U0();
  }
  
  public static final class a {}
  
  public static final class b
    implements TextWatcher
  {
    b(SwitchQuickSetupNameFragment paramSwitchQuickSetupNameFragment) {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      j.e(paramEditable, "s");
      Object localObject = paramEditable.toString();
      Charset localCharset = kotlin.text.d.a;
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type java.lang.String");
      localObject = ((String)localObject).getBytes(localCharset);
      j.d(localObject, "(this as java.lang.String).getBytes(charset)");
      if (localObject.length > 64)
      {
        paramEditable.delete(SwitchQuickSetupNameFragment.R0(this.c).length() - 1, SwitchQuickSetupNameFragment.R0(this.c).length());
        SwitchQuickSetupNameFragment.Q0(this.c).d.setText(paramEditable);
        SwitchQuickSetupNameFragment.Q0(this.c).d.setSelection(paramEditable.length());
      }
      localObject = SwitchQuickSetupNameFragment.Q0(this.c).c;
      j.d(localObject, "mBinding.btnBottom");
      ((Button)localObject).setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      j.e(paramCharSequence, "s");
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      j.e(paramCharSequence, "s");
      SwitchQuickSetupNameFragment.S0(this.c, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\quicksetup\SwitchQuickSetupNameFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */