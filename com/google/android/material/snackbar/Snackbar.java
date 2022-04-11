package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R.attr;
import com.google.android.material.R.layout;

public class Snackbar
  extends BaseTransientBottomBar<Snackbar>
{
  private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
  private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;
  @Nullable
  private final AccessibilityManager accessibilityManager;
  @Nullable
  private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
  private boolean hasAction;
  
  static
  {
    int i = R.attr.snackbarButtonStyle;
    SNACKBAR_BUTTON_STYLE_ATTR = new int[] { i };
    SNACKBAR_CONTENT_STYLE_ATTRS = new int[] { i, R.attr.snackbarTextViewStyle };
  }
  
  private Snackbar(@NonNull ViewGroup paramViewGroup, @NonNull View paramView, @NonNull ContentViewCallback paramContentViewCallback)
  {
    super(paramViewGroup, paramView, paramContentViewCallback);
    this.accessibilityManager = ((AccessibilityManager)paramViewGroup.getContext().getSystemService("accessibility"));
  }
  
  @Nullable
  private static ViewGroup findSuitableParent(View paramView)
  {
    Object localObject1 = null;
    View localView = paramView;
    Object localObject2;
    do
    {
      if ((localView instanceof CoordinatorLayout)) {
        return (ViewGroup)localView;
      }
      localObject2 = localObject1;
      if ((localView instanceof FrameLayout))
      {
        if (localView.getId() == 16908290) {
          return (ViewGroup)localView;
        }
        localObject2 = (ViewGroup)localView;
      }
      paramView = localView;
      if (localView != null)
      {
        paramView = localView.getParent();
        if ((paramView instanceof View)) {
          paramView = (View)paramView;
        } else {
          paramView = null;
        }
      }
      localObject1 = localObject2;
      localView = paramView;
    } while (paramView != null);
    return (ViewGroup)localObject2;
  }
  
  @Deprecated
  protected static boolean hasSnackbarButtonStyleAttr(@NonNull Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
    boolean bool = false;
    int i = paramContext.getResourceId(0, -1);
    paramContext.recycle();
    if (i != -1) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean hasSnackbarContentStyleAttrs(@NonNull Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
    boolean bool1 = false;
    int i = paramContext.getResourceId(0, -1);
    int j = paramContext.getResourceId(1, -1);
    paramContext.recycle();
    boolean bool2 = bool1;
    if (i != -1)
    {
      bool2 = bool1;
      if (j != -1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  @NonNull
  public static Snackbar make(@NonNull View paramView, @StringRes int paramInt1, int paramInt2)
  {
    return make(paramView, paramView.getResources().getText(paramInt1), paramInt2);
  }
  
  @NonNull
  public static Snackbar make(@NonNull View paramView, @NonNull CharSequence paramCharSequence, int paramInt)
  {
    paramView = findSuitableParent(paramView);
    if (paramView != null)
    {
      Object localObject = LayoutInflater.from(paramView.getContext());
      int i;
      if (hasSnackbarContentStyleAttrs(paramView.getContext())) {
        i = R.layout.mtrl_layout_snackbar_include;
      } else {
        i = R.layout.design_layout_snackbar_include;
      }
      localObject = (SnackbarContentLayout)((LayoutInflater)localObject).inflate(i, paramView, false);
      paramView = new Snackbar(paramView, (View)localObject, (ContentViewCallback)localObject);
      paramView.setText(paramCharSequence);
      paramView.setDuration(paramInt);
      return paramView;
    }
    throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public int getDuration()
  {
    int i = super.getDuration();
    if (i == -2) {
      return -2;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      if (this.hasAction) {
        j = 4;
      } else {
        j = 0;
      }
      return this.accessibilityManager.getRecommendedTimeoutMillis(i, j | 0x1 | 0x2);
    }
    int j = i;
    if (this.hasAction)
    {
      j = i;
      if (this.accessibilityManager.isTouchExplorationEnabled()) {
        j = -2;
      }
    }
    return j;
  }
  
  public boolean isShown()
  {
    return super.isShown();
  }
  
  @NonNull
  public Snackbar setAction(@StringRes int paramInt, View.OnClickListener paramOnClickListener)
  {
    return setAction(getContext().getText(paramInt), paramOnClickListener);
  }
  
  @NonNull
  public Snackbar setAction(@Nullable CharSequence paramCharSequence, @Nullable final View.OnClickListener paramOnClickListener)
  {
    Button localButton = ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView();
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramOnClickListener != null))
    {
      this.hasAction = true;
      localButton.setVisibility(0);
      localButton.setText(paramCharSequence);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramOnClickListener.onClick(paramAnonymousView);
          Snackbar.this.dispatchDismiss(1);
        }
      });
    }
    else
    {
      localButton.setVisibility(8);
      localButton.setOnClickListener(null);
      this.hasAction = false;
    }
    return this;
  }
  
  @NonNull
  public Snackbar setActionTextColor(@ColorInt int paramInt)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(paramInt);
    return this;
  }
  
  @NonNull
  public Snackbar setActionTextColor(ColorStateList paramColorStateList)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(paramColorStateList);
    return this;
  }
  
  @NonNull
  public Snackbar setBackgroundTint(@ColorInt int paramInt)
  {
    return setBackgroundTintList(ColorStateList.valueOf(paramInt));
  }
  
  @NonNull
  public Snackbar setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.view.setBackgroundTintList(paramColorStateList);
    return this;
  }
  
  @NonNull
  public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.view.setBackgroundTintMode(paramMode);
    return this;
  }
  
  @Deprecated
  @NonNull
  public Snackbar setCallback(@Nullable Callback paramCallback)
  {
    BaseTransientBottomBar.BaseCallback localBaseCallback = this.callback;
    if (localBaseCallback != null) {
      removeCallback(localBaseCallback);
    }
    if (paramCallback != null) {
      addCallback(paramCallback);
    }
    this.callback = paramCallback;
    return this;
  }
  
  @NonNull
  public Snackbar setMaxInlineActionWidth(@Dimension int paramInt)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).setMaxInlineActionWidth(paramInt);
    return this;
  }
  
  @NonNull
  public Snackbar setText(@StringRes int paramInt)
  {
    return setText(getContext().getText(paramInt));
  }
  
  @NonNull
  public Snackbar setText(@NonNull CharSequence paramCharSequence)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getMessageView().setText(paramCharSequence);
    return this;
  }
  
  @NonNull
  public Snackbar setTextColor(@ColorInt int paramInt)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getMessageView().setTextColor(paramInt);
    return this;
  }
  
  @NonNull
  public Snackbar setTextColor(ColorStateList paramColorStateList)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getMessageView().setTextColor(paramColorStateList);
    return this;
  }
  
  public void show()
  {
    super.show();
  }
  
  public static class Callback
    extends BaseTransientBottomBar.BaseCallback<Snackbar>
  {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;
    
    public void onDismissed(Snackbar paramSnackbar, int paramInt) {}
    
    public void onShown(Snackbar paramSnackbar) {}
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final class SnackbarLayout
    extends BaseTransientBottomBar.SnackbarBaseLayout
  {
    public SnackbarLayout(Context paramContext)
    {
      super();
    }
    
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      int i = getChildCount();
      paramInt2 = getMeasuredWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      for (paramInt1 = 0; paramInt1 < i; paramInt1++)
      {
        View localView = getChildAt(paramInt1);
        if (localView.getLayoutParams().width == -1) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 - j - k, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\snackbar\Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */