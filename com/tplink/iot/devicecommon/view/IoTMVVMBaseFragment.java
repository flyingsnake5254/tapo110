package com.tplink.iot.devicecommon.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.tplink.iot.base.BaseFragment;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import kotlin.p;

public abstract class IoTMVVMBaseFragment<VDB extends ViewDataBinding>
  extends BaseFragment
{
  public static final a q = new a(null);
  private HashMap p0;
  private VDB x;
  private String y = "";
  private boolean z;
  
  public void H0()
  {
    HashMap localHashMap = this.p0;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @LayoutRes
  public abstract int I0();
  
  protected final VDB J0()
  {
    ViewDataBinding localViewDataBinding = this.x;
    j.c(localViewDataBinding);
    return localViewDataBinding;
  }
  
  protected final String K0()
  {
    return this.y;
  }
  
  protected final boolean L0()
  {
    return this.z;
  }
  
  public void N0() {}
  
  public void O0() {}
  
  public final void P0(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      paramString = "";
    }
    localBundle.putString("device_id_md5", paramString);
    paramString = p.a;
    setArguments(localBundle);
  }
  
  protected final void Q0(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.y = paramString;
  }
  
  public void R0() {}
  
  @CallSuper
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("device_id_md5");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "";
    }
    this.y = paramBundle;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    this.x = DataBindingUtil.inflate(paramLayoutInflater, I0(), paramViewGroup, false);
    return J0().getRoot();
  }
  
  @CallSuper
  public void onDestroyView()
  {
    super.onDestroyView();
    this.z = false;
    this.x = null;
    H0();
  }
  
  @CallSuper
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    this.z = true;
    J0().setLifecycleOwner(getViewLifecycleOwner());
    N0();
    R0();
    O0();
  }
  
  public static final class a
  {
    public final Bundle a(String paramString)
    {
      Bundle localBundle = new Bundle();
      if (paramString == null) {
        paramString = "";
      }
      localBundle.putString("device_id_md5", paramString);
      return localBundle;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\IoTMVVMBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */