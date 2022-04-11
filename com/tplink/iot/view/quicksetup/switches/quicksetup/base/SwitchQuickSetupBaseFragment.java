package com.tplink.iot.view.quicksetup.switches.quicksetup.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import java.util.HashMap;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract class SwitchQuickSetupBaseFragment<VDB extends ViewDataBinding>
  extends BaseFragment
  implements g
{
  public static final a q = new a(null);
  private final f p0 = h.b(new b(this));
  private final f p1 = h.b(new c(this));
  private HashMap p2;
  private SwitchButton x = SwitchButton.FIRST;
  protected VDB y;
  private z1 z;
  
  public static final Bundle I0(SwitchButton paramSwitchButton)
  {
    return q.a(paramSwitchButton);
  }
  
  public void H0()
  {
    HashMap localHashMap = this.p2;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @LayoutRes
  public abstract int J0();
  
  protected final VDB K0()
  {
    ViewDataBinding localViewDataBinding = this.y;
    if (localViewDataBinding == null) {
      j.t("mBinding");
    }
    return localViewDataBinding;
  }
  
  protected final SwitchButton L0()
  {
    return this.x;
  }
  
  protected final z1 N0()
  {
    return this.z;
  }
  
  protected final SubGViewModel O0()
  {
    return (SubGViewModel)this.p0.getValue();
  }
  
  protected final SwitchQuickSetupViewModel P0()
  {
    return (SwitchQuickSetupViewModel)this.p1.getValue();
  }
  
  public void onAttach(Context paramContext)
  {
    j.e(paramContext, "context");
    super.onAttach(paramContext);
    SwitchButton.a locala = SwitchButton.Companion;
    Object localObject = getArguments();
    int i;
    if (localObject != null) {
      i = ((Bundle)localObject).getInt("ButtonPosArg");
    } else {
      i = 1;
    }
    localObject = locala.a(i);
    if (localObject == null) {
      localObject = SwitchButton.FIRST;
    }
    this.x = ((SwitchButton)localObject);
    localObject = paramContext;
    if (!(paramContext instanceof z1)) {
      localObject = null;
    }
    this.z = ((z1)localObject);
  }
  
  @CallSuper
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    paramLayoutInflater = DataBindingUtil.inflate(paramLayoutInflater, J0(), paramViewGroup, false);
    j.d(paramLayoutInflater, "DataBindingUtil.inflate(…youtId, container, false)");
    this.y = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      j.t("mBinding");
    }
    paramLayoutInflater.setVariable(94, O0());
    paramLayoutInflater = this.y;
    if (paramLayoutInflater == null) {
      j.t("mBinding");
    }
    paramLayoutInflater.setVariable(79, this);
    paramLayoutInflater = this.y;
    if (paramLayoutInflater == null) {
      j.t("mBinding");
    }
    return paramLayoutInflater.getRoot();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public static final class a
  {
    public final Bundle a(SwitchButton paramSwitchButton)
    {
      j.e(paramSwitchButton, "button");
      Bundle localBundle = new Bundle();
      localBundle.putInt("ButtonPosArg", paramSwitchButton.getPos());
      return localBundle;
    }
  }
  
  static final class b
    extends Lambda
    implements a<SubGViewModel>
  {
    b(SwitchQuickSetupBaseFragment paramSwitchQuickSetupBaseFragment)
    {
      super();
    }
    
    public final SubGViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(this.c.requireActivity()).get(SubGViewModel.class);
      j.d(localViewModel, "ViewModelProvider(requir…ubGViewModel::class.java)");
      return (SubGViewModel)localViewModel;
    }
  }
  
  static final class c
    extends Lambda
    implements a<SwitchQuickSetupViewModel>
  {
    c(SwitchQuickSetupBaseFragment paramSwitchQuickSetupBaseFragment)
    {
      super();
    }
    
    public final SwitchQuickSetupViewModel a()
    {
      ViewModel localViewModel = new ViewModelProvider(this.c.requireActivity()).get(SwitchQuickSetupViewModel.class);
      j.d(localViewModel, "ViewModelProvider(requir…tupViewModel::class.java)");
      return (SwitchQuickSetupViewModel)localViewModel;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\quicksetup\base\SwitchQuickSetupBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */