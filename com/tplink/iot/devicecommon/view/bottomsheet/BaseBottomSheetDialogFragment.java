package com.tplink.iot.devicecommon.view.bottomsheet;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public abstract class BaseBottomSheetDialogFragment
  extends BottomSheetDialogFragment
{
  protected abstract int A0();
  
  protected abstract void B0(View paramView);
  
  public void C0()
  {
    dismissAllowingStateLoss();
  }
  
  @NonNull
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = (BottomSheetDialog)super.onCreateDialog(paramBundle);
    View localView = View.inflate(getContext(), A0(), null);
    paramBundle.setContentView(localView);
    Object localObject = paramBundle.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).findViewById(2131362392).setBackgroundColor(0);
      ((Window)localObject).setWindowAnimations(2132017412);
    }
    localObject = localView.getLayoutParams();
    int i = getResources().getDisplayMetrics().heightPixels;
    ((ViewGroup.LayoutParams)localObject).height = i;
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = paramBundle.getBehavior();
    ((BottomSheetBehavior)localObject).setPeekHeight(i);
    ((BottomSheetBehavior)localObject).setSkipCollapsed(true);
    ((BottomSheetBehavior)localObject).setState(3);
    B0(localView);
    return paramBundle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\bottomsheet\BaseBottomSheetDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */