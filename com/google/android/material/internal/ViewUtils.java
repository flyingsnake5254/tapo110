package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils
{
  public static void doOnApplyWindowInsets(@NonNull View paramView, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    doOnApplyWindowInsets(paramView, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  public static void doOnApplyWindowInsets(@NonNull View paramView, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2, @Nullable final OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    paramAttributeSet = paramView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Insets, paramInt1, paramInt2);
    boolean bool1 = paramAttributeSet.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
    final boolean bool2 = paramAttributeSet.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
    final boolean bool3 = paramAttributeSet.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
    paramAttributeSet.recycle();
    doOnApplyWindowInsets(paramView, new OnApplyWindowInsetsListener()
    {
      @NonNull
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, @NonNull WindowInsetsCompat paramAnonymousWindowInsetsCompat, @NonNull ViewUtils.RelativePadding paramAnonymousRelativePadding)
      {
        if (this.val$paddingBottomSystemWindowInsets) {
          paramAnonymousRelativePadding.bottom += paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom();
        }
        boolean bool = ViewUtils.isLayoutRtl(paramAnonymousView);
        if (bool2) {
          if (bool) {
            paramAnonymousRelativePadding.end += paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft();
          } else {
            paramAnonymousRelativePadding.start += paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft();
          }
        }
        if (bool3) {
          if (bool) {
            paramAnonymousRelativePadding.start += paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight();
          } else {
            paramAnonymousRelativePadding.end += paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight();
          }
        }
        paramAnonymousRelativePadding.applyToView(paramAnonymousView);
        ViewUtils.OnApplyWindowInsetsListener localOnApplyWindowInsetsListener = paramOnApplyWindowInsetsListener;
        WindowInsetsCompat localWindowInsetsCompat = paramAnonymousWindowInsetsCompat;
        if (localOnApplyWindowInsetsListener != null) {
          localWindowInsetsCompat = localOnApplyWindowInsetsListener.onApplyWindowInsets(paramAnonymousView, paramAnonymousWindowInsetsCompat, paramAnonymousRelativePadding);
        }
        return localWindowInsetsCompat;
      }
    });
  }
  
  public static void doOnApplyWindowInsets(@NonNull View paramView, @NonNull OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    ViewCompat.setOnApplyWindowInsetsListener(paramView, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return this.val$listener.onApplyWindowInsets(paramAnonymousView, paramAnonymousWindowInsetsCompat, new ViewUtils.RelativePadding(this.val$initialPadding));
      }
    });
    requestApplyInsetsWhenAttached(paramView);
  }
  
  public static float dpToPx(@NonNull Context paramContext, @Dimension(unit=0) int paramInt)
  {
    paramContext = paramContext.getResources();
    return TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics());
  }
  
  @Nullable
  public static ViewGroup getContentView(@Nullable View paramView)
  {
    if (paramView == null) {
      return null;
    }
    View localView = paramView.getRootView();
    ViewGroup localViewGroup = (ViewGroup)localView.findViewById(16908290);
    if (localViewGroup != null) {
      return localViewGroup;
    }
    if ((localView != paramView) && ((localView instanceof ViewGroup))) {
      return (ViewGroup)localView;
    }
    return null;
  }
  
  @Nullable
  public static ViewOverlayImpl getContentViewOverlay(@NonNull View paramView)
  {
    return getOverlay(getContentView(paramView));
  }
  
  @Nullable
  public static ViewOverlayImpl getOverlay(@Nullable View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 18) {
      return new ViewOverlayApi18(paramView);
    }
    return ViewOverlayApi14.createFrom(paramView);
  }
  
  public static float getParentAbsoluteElevation(@NonNull View paramView)
  {
    paramView = paramView.getParent();
    float f = 0.0F;
    while ((paramView instanceof View))
    {
      f += ViewCompat.getElevation((View)paramView);
      paramView = paramView.getParent();
    }
    return f;
  }
  
  public static boolean isLayoutRtl(View paramView)
  {
    int i = ViewCompat.getLayoutDirection(paramView);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  public static void requestApplyInsetsWhenAttached(@NonNull View paramView)
  {
    if (ViewCompat.isAttachedToWindow(paramView)) {
      ViewCompat.requestApplyInsets(paramView);
    } else {
      paramView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public void onViewAttachedToWindow(@NonNull View paramAnonymousView)
        {
          paramAnonymousView.removeOnAttachStateChangeListener(this);
          ViewCompat.requestApplyInsets(paramAnonymousView);
        }
        
        public void onViewDetachedFromWindow(View paramAnonymousView) {}
      });
    }
  }
  
  public static void requestFocusAndShowKeyboard(@NonNull View paramView)
  {
    paramView.requestFocus();
    paramView.post(new Runnable()
    {
      public void run()
      {
        ((InputMethodManager)this.val$view.getContext().getSystemService("input_method")).showSoftInput(this.val$view, 1);
      }
    });
  }
  
  public static abstract interface OnApplyWindowInsetsListener
  {
    public abstract WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat, ViewUtils.RelativePadding paramRelativePadding);
  }
  
  public static class RelativePadding
  {
    public int bottom;
    public int end;
    public int start;
    public int top;
    
    public RelativePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.start = paramInt1;
      this.top = paramInt2;
      this.end = paramInt3;
      this.bottom = paramInt4;
    }
    
    public RelativePadding(@NonNull RelativePadding paramRelativePadding)
    {
      this.start = paramRelativePadding.start;
      this.top = paramRelativePadding.top;
      this.end = paramRelativePadding.end;
      this.bottom = paramRelativePadding.bottom;
    }
    
    public void applyToView(View paramView)
    {
      ViewCompat.setPaddingRelative(paramView, this.start, this.top, this.end, this.bottom);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */