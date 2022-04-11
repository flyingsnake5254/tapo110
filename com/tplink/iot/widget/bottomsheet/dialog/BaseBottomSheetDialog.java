package com.tplink.iot.widget.bottomsheet.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public abstract class BaseBottomSheetDialog<VDB extends ViewDataBinding>
  extends BottomSheetDialogFragment
{
  public static final a c = new a(null);
  protected VDB d;
  protected BottomSheetBehavior<FrameLayout> f;
  private HashMap p0;
  private FrameLayout q;
  private boolean x;
  private BottomSheetOptions y = new BottomSheetOptions();
  private final List<Runnable> z = new ArrayList();
  
  private final void H0(BottomSheetDialog paramBottomSheetDialog, BottomSheetOptions paramBottomSheetOptions)
  {
    if (paramBottomSheetOptions != null)
    {
      setCancelable(paramBottomSheetOptions.getCancelable());
      BottomSheetBehavior localBottomSheetBehavior = paramBottomSheetDialog.getBehavior();
      localBottomSheetBehavior.setHideable(paramBottomSheetOptions.getHideable());
      localBottomSheetBehavior.setSkipCollapsed(paramBottomSheetOptions.getSkipCollapsed());
      if (paramBottomSheetOptions.getTopSpacedPixels() != 0) {
        R0(paramBottomSheetDialog, paramBottomSheetOptions.getTopSpacedPixels());
      } else if (paramBottomSheetOptions.getFullscreen()) {
        T0(paramBottomSheetDialog);
      }
    }
  }
  
  private final void R0(BottomSheetDialog paramBottomSheetDialog, int paramInt)
  {
    Object localObject = getResources();
    j.d(localObject, "resources");
    paramInt = ((Resources)localObject).getDisplayMetrics().heightPixels - paramInt;
    localObject = K0(paramBottomSheetDialog);
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = paramInt;
      }
    }
    paramBottomSheetDialog = paramBottomSheetDialog.getBehavior();
    paramBottomSheetDialog.setPeekHeight(paramInt);
    paramBottomSheetDialog.setHideable(false);
  }
  
  private final void S0()
  {
    this.x = true;
    if ((true ^ this.z.isEmpty()))
    {
      Iterator localIterator = this.z.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.z.clear();
  }
  
  private final void T0(BottomSheetDialog paramBottomSheetDialog)
  {
    Object localObject = K0(paramBottomSheetDialog);
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
    paramBottomSheetDialog.getBehavior().setState(3);
  }
  
  public void A0()
  {
    HashMap localHashMap = this.p0;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void G0(BottomSheetBehavior<FrameLayout> paramBottomSheetBehavior)
  {
    j.e(paramBottomSheetBehavior, "behavior");
  }
  
  public void I0(BottomSheetDialog paramBottomSheetDialog)
  {
    j.e(paramBottomSheetDialog, "dialog");
  }
  
  public void J0(FrameLayout paramFrameLayout) {}
  
  protected final FrameLayout K0(BottomSheetDialog paramBottomSheetDialog)
  {
    j.e(paramBottomSheetDialog, "dialog");
    return (FrameLayout)paramBottomSheetDialog.findViewById(2131362392);
  }
  
  @LayoutRes
  public abstract int L0();
  
  protected final BottomSheetBehavior<FrameLayout> N0()
  {
    BottomSheetBehavior localBottomSheetBehavior = this.f;
    if (localBottomSheetBehavior == null) {
      j.t("mBehavior");
    }
    return localBottomSheetBehavior;
  }
  
  protected final VDB O0()
  {
    ViewDataBinding localViewDataBinding = this.d;
    if (localViewDataBinding == null) {
      j.t("mBinding");
    }
    return localViewDataBinding;
  }
  
  public BottomSheetOptions P0()
  {
    return this.y;
  }
  
  public abstract void Q0();
  
  public int getTheme()
  {
    BottomSheetOptions localBottomSheetOptions = P0();
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
  
  @CallSuper
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = BottomSheetOptions.Companion.a(getArguments());
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), L0(), null, false);
    j.d(paramBundle, "DataBindingUtil.inflate(…tLayoutId(), null, false)");
    this.d = paramBundle;
    Q0();
    paramBundle = new BottomSheetDialog(requireContext(), getTheme());
    Object localObject = this.d;
    if (localObject == null) {
      j.t("mBinding");
    }
    paramBundle.setContentView(((ViewDataBinding)localObject).getRoot());
    localObject = paramBundle.getBehavior();
    j.d(localObject, "behavior");
    this.f = ((BottomSheetBehavior)localObject);
    this.q = K0(paramBundle);
    H0(paramBundle, P0());
    I0(paramBundle);
    J0(this.q);
    localObject = paramBundle.getBehavior();
    j.d(localObject, "behavior");
    G0((BottomSheetBehavior)localObject);
    S0();
    return paramBundle;
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\bottomsheet\dialog\BaseBottomSheetDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */