package com.tplink.iot.Utils.extension;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import kotlin.jvm.internal.j;

public final class i
{
  public static final void a(TPSwitchCompat paramTPSwitchCompat, long paramLong)
  {
    j.e(paramTPSwitchCompat, "$this$disableForAWhile");
    paramTPSwitchCompat.setEnabled(false);
    paramTPSwitchCompat.postDelayed(new a(paramTPSwitchCompat), paramLong);
  }
  
  public static final void c(Activity paramActivity, int paramInt)
  {
    j.e(paramActivity, "$this$hideKeyboard");
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null) {
      paramActivity = paramActivity.getDecorView();
    } else {
      paramActivity = null;
    }
    if ((localInputMethodManager != null) && (paramActivity != null)) {
      localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindowToken(), paramInt);
    }
  }
  
  public static final void e(Activity paramActivity, View paramView, int paramInt)
  {
    j.e(paramActivity, "$this$hideKeyboardFromView");
    j.e(paramView, "view");
    paramActivity = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (paramActivity != null) {
      paramActivity.hideSoftInputFromWindow(paramView.getWindowToken(), paramInt);
    }
  }
  
  public static final void g(RecyclerView paramRecyclerView)
  {
    j.e(paramRecyclerView, "$this$removeItemAnimator");
    RecyclerView.ItemAnimator localItemAnimator = paramRecyclerView.getItemAnimator();
    paramRecyclerView = localItemAnimator;
    if (!(localItemAnimator instanceof SimpleItemAnimator)) {
      paramRecyclerView = null;
    }
    paramRecyclerView = (SimpleItemAnimator)paramRecyclerView;
    if (paramRecyclerView != null) {
      paramRecyclerView.setSupportsChangeAnimations(false);
    }
  }
  
  public static final void h(Activity paramActivity, int paramInt)
  {
    j.e(paramActivity, "$this$showKeyboard");
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if ((localInputMethodManager != null) && (paramActivity.getCurrentFocus() != null)) {
      localInputMethodManager.showSoftInput(paramActivity.getCurrentFocus(), paramInt);
    }
  }
  
  public static final void i(Activity paramActivity)
  {
    j.e(paramActivity, "$this$showKeyboardImplicit");
    h(paramActivity, 1);
  }
  
  public static final void j(View paramView)
  {
    j.e(paramView, "$this$toGone");
    paramView.setVisibility(8);
  }
  
  public static final void k(View paramView)
  {
    j.e(paramView, "$this$toInvisible");
    paramView.setVisibility(4);
  }
  
  public static final void l(View paramView)
  {
    j.e(paramView, "$this$toVisible");
    paramView.setVisibility(0);
  }
  
  static final class a
    implements Runnable
  {
    a(TPSwitchCompat paramTPSwitchCompat) {}
    
    public final void run()
    {
      this.c.setEnabled(true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */