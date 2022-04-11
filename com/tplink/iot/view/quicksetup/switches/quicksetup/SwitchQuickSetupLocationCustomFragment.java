package com.tplink.iot.view.quicksetup.switches.quicksetup;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.FragmentSubGSetupLocationCustomBinding;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.iot.widget.FlowTagLayout.c;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class SwitchQuickSetupLocationCustomFragment
  extends SwitchQuickSetupBaseFragment<FragmentSubGSetupLocationCustomBinding>
  implements FlowTagLayout.c
{
  public static final a p3 = new a(null);
  private CharSequence H3 = "";
  private boolean I3 = true;
  private HashMap J3;
  
  private final void V0()
  {
    Object localObject = ((FragmentSubGSetupLocationCustomBinding)K0()).z;
    j.d(localObject, "mBinding.maskView");
    i.l((View)localObject);
    localObject = ((FragmentSubGSetupLocationCustomBinding)K0()).p0;
    j.d(localObject, "mBinding.tvContinue");
    ((TextView)localObject).setEnabled(false);
  }
  
  private final void W0()
  {
    Object localObject = ((FragmentSubGSetupLocationCustomBinding)K0()).z;
    j.d(localObject, "mBinding.maskView");
    i.j((View)localObject);
    ((FragmentSubGSetupLocationCustomBinding)K0()).c.h();
    localObject = ((FragmentSubGSetupLocationCustomBinding)K0()).p0;
    j.d(localObject, "mBinding.tvContinue");
    ((TextView)localObject).setEnabled(true);
  }
  
  private final ArrayList<String> X0()
  {
    ArrayList localArrayList = new ArrayList();
    for (EnumDeviceNicknameType localEnumDeviceNicknameType : EnumDeviceNicknameType.values()) {
      if (localEnumDeviceNicknameType != EnumDeviceNicknameType.CUSTOM) {
        localArrayList.add(EnumDeviceNicknameType.fromType(localEnumDeviceNicknameType));
      }
    }
    return localArrayList;
  }
  
  private final void Y0()
  {
    TPRefreshableButton localTPRefreshableButton = ((FragmentSubGSetupLocationCustomBinding)K0()).c;
    j.d(localTPRefreshableButton, "mBinding.btnBottom");
    localTPRefreshableButton.setEnabled(false);
    ((FragmentSubGSetupLocationCustomBinding)K0()).d.f(new b(this));
    ((FragmentSubGSetupLocationCustomBinding)K0()).d.m();
    ((FragmentSubGSetupLocationCustomBinding)K0()).f.c(X0(), this);
  }
  
  private final void Z0()
  {
    com.tplink.iot.view.quicksetup.base.d.I(getActivity());
    P0().Q(this.H3.toString());
    P0().K();
    if (this.I3)
    {
      this.I3 = false;
      List localList = kotlin.collections.l.g(new String[] { P0().A(SwitchButton.FIRST), P0().A(SwitchButton.SECOND) });
      O0().D0(this.H3.toString(), localList);
    }
    V0();
    P0().x();
  }
  
  private final void a1()
  {
    P0().G().observe(getViewLifecycleOwner(), new c(this));
    P0().F().observe(getViewLifecycleOwner(), new d(this));
  }
  
  public void G(String paramString)
  {
    com.tplink.iot.Utils.z0.l.m(((FragmentSubGSetupLocationCustomBinding)K0()).d, paramString);
  }
  
  public void H0()
  {
    HashMap localHashMap = this.J3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int J0()
  {
    return 2131558971;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i != 2131362826)
      {
        if (i == 2131364387)
        {
          paramView = N0();
          if (paramView != null) {
            paramView.e0("SubGCompleteFragment.TAG", null);
          }
        }
      }
      else {
        O0().E0(20002);
      }
    }
    else {
      Z0();
    }
  }
  
  public void onDestroyView()
  {
    P0().r();
    super.onDestroyView();
    H0();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tplink.iot.view.quicksetup.base.d.i0(getActivity());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    Y0();
    a1();
  }
  
  public static final class a {}
  
  public static final class b
    implements TextWatcher
  {
    b(SwitchQuickSetupLocationCustomFragment paramSwitchQuickSetupLocationCustomFragment) {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      j.e(paramEditable, "s");
      String str = paramEditable.toString();
      Object localObject = kotlin.text.d.a;
      Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
      localObject = str.getBytes((Charset)localObject);
      j.d(localObject, "(this as java.lang.String).getBytes(charset)");
      if (localObject.length > 64)
      {
        paramEditable.delete(SwitchQuickSetupLocationCustomFragment.S0(this.c).length() - 1, SwitchQuickSetupLocationCustomFragment.S0(this.c).length());
        SwitchQuickSetupLocationCustomFragment.R0(this.c).d.setText(paramEditable);
        SwitchQuickSetupLocationCustomFragment.R0(this.c).d.setSelection(paramEditable.length());
      }
      localObject = SwitchQuickSetupLocationCustomFragment.R0(this.c).c;
      j.d(localObject, "mBinding.btnBottom");
      ((TPRefreshableButton)localObject).setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      j.e(paramCharSequence, "s");
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      j.e(paramCharSequence, "s");
      SwitchQuickSetupLocationCustomFragment.U0(this.c, paramCharSequence);
    }
  }
  
  static final class c<T>
    implements Observer<a<Boolean>>
  {
    c(SwitchQuickSetupLocationCustomFragment paramSwitchQuickSetupLocationCustomFragment) {}
    
    public final void a(a<Boolean> parama)
    {
      if (parama != null)
      {
        parama = (Boolean)parama.a();
        if (parama != null)
        {
          SwitchQuickSetupLocationCustomFragment.Q0(this.a);
          j.d(parama, "success");
          if (parama.booleanValue())
          {
            parama = SwitchQuickSetupLocationCustomFragment.T0(this.a);
            if (parama != null) {
              parama.e0("SubGCompleteFragment.TAG", null);
            }
          }
          else
          {
            s0.o(this.a.getActivity(), 2131952444, null);
          }
        }
      }
    }
  }
  
  static final class d<T>
    implements Observer<Integer>
  {
    d(SwitchQuickSetupLocationCustomFragment paramSwitchQuickSetupLocationCustomFragment) {}
    
    public final void a(Integer paramInteger)
    {
      TextView localTextView = SwitchQuickSetupLocationCustomFragment.R0(this.a).p0;
      j.d(localTextView, "mBinding.tvContinue");
      int i = paramInteger.intValue();
      int j = 0;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        i = j;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\quicksetup\SwitchQuickSetupLocationCustomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */