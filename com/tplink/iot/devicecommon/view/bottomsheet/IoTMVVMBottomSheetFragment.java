package com.tplink.iot.devicecommon.view.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public abstract class IoTMVVMBottomSheetFragment<VDB extends ViewDataBinding>
  extends BottomSheetDialogFragment
{
  private VDB c;
  private String d = "";
  private HashMap f;
  
  public void A0()
  {
    HashMap localHashMap = this.f;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void B0(BottomSheetBehavior<?> paramBottomSheetBehavior)
  {
    j.e(paramBottomSheetBehavior, "behavior");
    paramBottomSheetBehavior.setSkipCollapsed(true);
    paramBottomSheetBehavior.setState(3);
  }
  
  public void C0(FrameLayout paramFrameLayout)
  {
    j.e(paramFrameLayout, "bottomSheet");
  }
  
  @LayoutRes
  public abstract int G0();
  
  protected final VDB H0()
  {
    ViewDataBinding localViewDataBinding = this.c;
    j.c(localViewDataBinding);
    return localViewDataBinding;
  }
  
  protected final String I0()
  {
    return this.d;
  }
  
  public abstract void J0();
  
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
    this.d = paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    this.c = DataBindingUtil.inflate(paramLayoutInflater, G0(), paramViewGroup, false);
    return H0().getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.c = null;
    A0();
  }
  
  public void onViewCreated(final View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    paramBundle = getDialog();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getWindow();
      if (paramBundle != null) {
        paramBundle.setWindowAnimations(2132017412);
      }
    }
    Dialog localDialog = getDialog();
    paramBundle = localDialog;
    if (!(localDialog instanceof BottomSheetDialog)) {
      paramBundle = null;
    }
    paramBundle = (BottomSheetDialog)paramBundle;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBehavior();
      if (paramBundle != null) {
        B0(paramBundle);
      }
    }
    paramView.post(new a(this, paramView));
    J0();
  }
  
  static final class a
    implements Runnable
  {
    a(IoTMVVMBottomSheetFragment paramIoTMVVMBottomSheetFragment, View paramView) {}
    
    public final void run()
    {
      ViewParent localViewParent = paramView.getParent();
      Object localObject = localViewParent;
      if (!(localViewParent instanceof FrameLayout)) {
        localObject = null;
      }
      localObject = (FrameLayout)localObject;
      if (localObject != null) {
        this.c.C0((FrameLayout)localObject);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\bottomsheet\IoTMVVMBottomSheetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */