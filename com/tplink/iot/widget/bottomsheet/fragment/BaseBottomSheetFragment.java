package com.tplink.iot.widget.bottomsheet.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions.a;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public abstract class BaseBottomSheetFragment<VDB extends ViewDataBinding>
  extends BottomSheetDialogFragment
{
  public static final a c = new a(null);
  private VDB d;
  private BottomSheetBehavior<FrameLayout> f;
  private FrameLayout q;
  private BottomSheetOptions x;
  private HashMap y;
  
  private final void C0(BottomSheetOptions paramBottomSheetOptions)
  {
    if (paramBottomSheetOptions != null)
    {
      setCancelable(paramBottomSheetOptions.getCancelable());
      BottomSheetBehavior localBottomSheetBehavior = this.f;
      if (localBottomSheetBehavior != null)
      {
        localBottomSheetBehavior.setHideable(paramBottomSheetOptions.getHideable());
        localBottomSheetBehavior.setSkipCollapsed(paramBottomSheetOptions.getSkipCollapsed());
      }
      if (paramBottomSheetOptions.getTopSpacedPixels() != 0) {
        O0(paramBottomSheetOptions.getTopSpacedPixels());
      } else if (paramBottomSheetOptions.getFullscreen()) {
        R0();
      }
    }
  }
  
  private final void H0()
  {
    if ((this.f == null) && (getShowsDialog()))
    {
      Object localObject1 = getDialog();
      boolean bool = localObject1 instanceof BottomSheetDialog;
      Object localObject2 = null;
      if (!bool) {
        localObject1 = null;
      }
      BottomSheetDialog localBottomSheetDialog = (BottomSheetDialog)localObject1;
      localObject1 = localObject2;
      if (localBottomSheetDialog != null) {
        localObject1 = localBottomSheetDialog.getBehavior();
      }
      this.f = ((BottomSheetBehavior)localObject1);
    }
  }
  
  private final void I0()
  {
    if (this.q != null) {
      return;
    }
    boolean bool = getShowsDialog();
    Object localObject = null;
    Dialog localDialog = null;
    if (bool)
    {
      localDialog = getDialog();
      if (localDialog != null) {
        localObject = (FrameLayout)localDialog.findViewById(2131362392);
      }
    }
    else
    {
      localObject = getView();
      if (localObject != null) {
        localObject = ((View)localObject).getParent();
      } else {
        localObject = null;
      }
      if (!(localObject instanceof FrameLayout)) {
        localObject = localDialog;
      }
      localObject = (FrameLayout)localObject;
    }
    this.q = ((FrameLayout)localObject);
  }
  
  private final void O0(int paramInt)
  {
    Resources localResources = getResources();
    j.d(localResources, "resources");
    paramInt = localResources.getDisplayMetrics().heightPixels - paramInt;
    if (getShowsDialog()) {
      P0(paramInt);
    } else {
      Q0(paramInt);
    }
  }
  
  private final void P0(int paramInt)
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = paramInt;
      }
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((BottomSheetBehavior)localObject).setPeekHeight(paramInt);
      ((BottomSheetBehavior)localObject).setHideable(false);
    }
  }
  
  private final void Q0(int paramInt)
  {
    Object localObject = getView();
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = paramInt;
      }
    }
  }
  
  private final void R0()
  {
    if (getShowsDialog()) {
      S0();
    } else {
      T0();
    }
  }
  
  private final void S0()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
    localObject = this.f;
    if (localObject != null) {
      ((BottomSheetBehavior)localObject).setState(3);
    }
  }
  
  private final void T0()
  {
    Object localObject = getView();
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
  }
  
  public void A0()
  {
    HashMap localHashMap = this.y;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void B0(BottomSheetBehavior<FrameLayout> paramBottomSheetBehavior)
  {
    j.e(paramBottomSheetBehavior, "behavior");
  }
  
  public void G0(FrameLayout paramFrameLayout) {}
  
  @LayoutRes
  public abstract int J0();
  
  protected final VDB K0()
  {
    ViewDataBinding localViewDataBinding = this.d;
    j.c(localViewDataBinding);
    return localViewDataBinding;
  }
  
  public BottomSheetOptions L0()
  {
    return this.x;
  }
  
  public abstract void N0();
  
  public int getTheme()
  {
    BottomSheetOptions localBottomSheetOptions = L0();
    int i = 2132017407;
    int j = i;
    if (localBottomSheetOptions != null) {
      if ((localBottomSheetOptions.getNoDim()) && (localBottomSheetOptions.getTopRoundCorner()))
      {
        j = 2132017409;
      }
      else if (localBottomSheetOptions.getNoDim())
      {
        j = 2132017408;
      }
      else
      {
        j = i;
        if (localBottomSheetOptions.getTopRoundCorner()) {
          j = 2132017410;
        }
      }
    }
    return j;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    I0();
    H0();
    C0(L0());
    paramBundle = this.f;
    if (paramBundle != null) {
      B0(paramBundle);
    }
    G0(this.q);
  }
  
  @CallSuper
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.x = BottomSheetOptions.Companion.a(getArguments());
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new BottomSheetDialog(requireContext(), getTheme());
    this.f = paramBundle.getBehavior();
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    this.d = DataBindingUtil.inflate(paramLayoutInflater, J0(), paramViewGroup, false);
    return K0().getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.d = null;
    A0();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    K0().setLifecycleOwner(getViewLifecycleOwner());
    N0();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\bottomsheet\fragment\BaseBottomSheetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */