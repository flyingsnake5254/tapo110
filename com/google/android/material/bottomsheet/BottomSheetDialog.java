package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.style;

public class BottomSheetDialog
  extends AppCompatDialog
{
  private BottomSheetBehavior<FrameLayout> behavior;
  @NonNull
  private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback()
  {
    public void onSlide(@NonNull View paramAnonymousView, float paramAnonymousFloat) {}
    
    public void onStateChanged(@NonNull View paramAnonymousView, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 5) {
        BottomSheetDialog.this.cancel();
      }
    }
  };
  boolean cancelable = true;
  private boolean canceledOnTouchOutside = true;
  private boolean canceledOnTouchOutsideSet;
  private FrameLayout container;
  boolean dismissWithAnimation;
  
  public BottomSheetDialog(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BottomSheetDialog(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    super(paramContext, getThemeResId(paramContext, paramInt));
    supportRequestWindowFeature(1);
  }
  
  protected BottomSheetDialog(@NonNull Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    supportRequestWindowFeature(1);
    this.cancelable = paramBoolean;
  }
  
  private FrameLayout ensureContainerAndBehavior()
  {
    if (this.container == null)
    {
      Object localObject = (FrameLayout)View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
      this.container = ((FrameLayout)localObject);
      localObject = BottomSheetBehavior.from((FrameLayout)((FrameLayout)localObject).findViewById(R.id.design_bottom_sheet));
      this.behavior = ((BottomSheetBehavior)localObject);
      ((BottomSheetBehavior)localObject).addBottomSheetCallback(this.bottomSheetCallback);
      this.behavior.setHideable(this.cancelable);
    }
    return this.container;
  }
  
  private static int getThemeResId(@NonNull Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, localTypedValue, true)) {
        i = localTypedValue.resourceId;
      } else {
        i = R.style.Theme_Design_Light_BottomSheetDialog;
      }
    }
    return i;
  }
  
  private View wrapInBottomSheet(int paramInt, @Nullable View paramView, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureContainerAndBehavior();
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)this.container.findViewById(R.id.coordinator);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)this.container.findViewById(R.id.design_bottom_sheet);
    paramView.removeAllViews();
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    } else {
      paramView.addView(localView, paramLayoutParams);
    }
    localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = BottomSheetDialog.this;
        if ((paramAnonymousView.cancelable) && (paramAnonymousView.isShowing()) && (BottomSheetDialog.this.shouldWindowCloseOnTouchOutside())) {
          BottomSheetDialog.this.cancel();
        }
      }
    });
    ViewCompat.setAccessibilityDelegate(paramView, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, @NonNull AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        if (BottomSheetDialog.this.cancelable)
        {
          paramAnonymousAccessibilityNodeInfoCompat.addAction(1048576);
          paramAnonymousAccessibilityNodeInfoCompat.setDismissable(true);
        }
        else
        {
          paramAnonymousAccessibilityNodeInfoCompat.setDismissable(false);
        }
      }
      
      public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt == 1048576)
        {
          BottomSheetDialog localBottomSheetDialog = BottomSheetDialog.this;
          if (localBottomSheetDialog.cancelable)
          {
            localBottomSheetDialog.cancel();
            return true;
          }
        }
        return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
      }
    });
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    return this.container;
  }
  
  public void cancel()
  {
    BottomSheetBehavior localBottomSheetBehavior = getBehavior();
    if ((this.dismissWithAnimation) && (localBottomSheetBehavior.getState() != 5)) {
      localBottomSheetBehavior.setState(5);
    } else {
      super.cancel();
    }
  }
  
  @NonNull
  public BottomSheetBehavior<FrameLayout> getBehavior()
  {
    if (this.behavior == null) {
      ensureContainerAndBehavior();
    }
    return this.behavior;
  }
  
  public boolean getDismissWithAnimation()
  {
    return this.dismissWithAnimation;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle.clearFlags(67108864);
        paramBundle.addFlags(Integer.MIN_VALUE);
      }
      paramBundle.setLayout(-1, -1);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    BottomSheetBehavior localBottomSheetBehavior = this.behavior;
    if ((localBottomSheetBehavior != null) && (localBottomSheetBehavior.getState() == 5)) {
      this.behavior.setState(4);
    }
  }
  
  void removeDefaultCallback()
  {
    this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.cancelable != paramBoolean)
    {
      this.cancelable = paramBoolean;
      BottomSheetBehavior localBottomSheetBehavior = this.behavior;
      if (localBottomSheetBehavior != null) {
        localBottomSheetBehavior.setHideable(paramBoolean);
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.cancelable)) {
      this.cancelable = true;
    }
    this.canceledOnTouchOutside = paramBoolean;
    this.canceledOnTouchOutsideSet = true;
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    super.setContentView(wrapInBottomSheet(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, paramLayoutParams));
  }
  
  public void setDismissWithAnimation(boolean paramBoolean)
  {
    this.dismissWithAnimation = paramBoolean;
  }
  
  boolean shouldWindowCloseOnTouchOutside()
  {
    if (!this.canceledOnTouchOutsideSet)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      this.canceledOnTouchOutside = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
      this.canceledOnTouchOutsideSet = true;
    }
    return this.canceledOnTouchOutside;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\bottomsheet\BottomSheetDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */