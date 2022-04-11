package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;
import androidx.databinding.library.baseAdapters.R.id;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:backgroundTint", method="setBackgroundTintList", type=View.class), @androidx.databinding.BindingMethod(attribute="android:fadeScrollbars", method="setScrollbarFadingEnabled", type=View.class), @androidx.databinding.BindingMethod(attribute="android:getOutline", method="setOutlineProvider", type=View.class), @androidx.databinding.BindingMethod(attribute="android:nextFocusForward", method="setNextFocusForwardId", type=View.class), @androidx.databinding.BindingMethod(attribute="android:nextFocusLeft", method="setNextFocusLeftId", type=View.class), @androidx.databinding.BindingMethod(attribute="android:nextFocusRight", method="setNextFocusRightId", type=View.class), @androidx.databinding.BindingMethod(attribute="android:nextFocusUp", method="setNextFocusUpId", type=View.class), @androidx.databinding.BindingMethod(attribute="android:nextFocusDown", method="setNextFocusDownId", type=View.class), @androidx.databinding.BindingMethod(attribute="android:requiresFadingEdge", method="setVerticalFadingEdgeEnabled", type=View.class), @androidx.databinding.BindingMethod(attribute="android:scrollbarDefaultDelayBeforeFade", method="setScrollBarDefaultDelayBeforeFade", type=View.class), @androidx.databinding.BindingMethod(attribute="android:scrollbarFadeDuration", method="setScrollBarFadeDuration", type=View.class), @androidx.databinding.BindingMethod(attribute="android:scrollbarSize", method="setScrollBarSize", type=View.class), @androidx.databinding.BindingMethod(attribute="android:scrollbarStyle", method="setScrollBarStyle", type=View.class), @androidx.databinding.BindingMethod(attribute="android:transformPivotX", method="setPivotX", type=View.class), @androidx.databinding.BindingMethod(attribute="android:transformPivotY", method="setPivotY", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onDrag", method="setOnDragListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onClick", method="setOnClickListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onApplyWindowInsets", method="setOnApplyWindowInsetsListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onCreateContextMenu", method="setOnCreateContextMenuListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onFocusChange", method="setOnFocusChangeListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onGenericMotion", method="setOnGenericMotionListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onHover", method="setOnHoverListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onKey", method="setOnKeyListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onLongClick", method="setOnLongClickListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onSystemUiVisibilityChange", method="setOnSystemUiVisibilityChangeListener", type=View.class), @androidx.databinding.BindingMethod(attribute="android:onTouch", method="setOnTouchListener", type=View.class)})
public class ViewBindingAdapter
{
  public static final int FADING_EDGE_HORIZONTAL = 1;
  public static final int FADING_EDGE_NONE = 0;
  public static final int FADING_EDGE_VERTICAL = 2;
  
  private static int pixelsToDimensionPixelSize(float paramFloat)
  {
    int i = (int)(0.5F + paramFloat);
    if (i != 0) {
      return i;
    }
    boolean bool = paramFloat < 0.0F;
    if (!bool) {
      return 0;
    }
    if (bool) {
      return 1;
    }
    return -1;
  }
  
  @BindingAdapter({"android:background"})
  public static void setBackground(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.setBackground(paramDrawable);
    } else {
      paramView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  @BindingAdapter({"android:onClickListener", "android:clickable"})
  public static void setClickListener(View paramView, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setClickable(paramBoolean);
  }
  
  @BindingAdapter(requireAll=false, value={"android:onViewDetachedFromWindow", "android:onViewAttachedToWindow"})
  public static void setOnAttachStateChangeListener(View paramView, final OnViewDetachedFromWindow paramOnViewDetachedFromWindow, OnViewAttachedToWindow paramOnViewAttachedToWindow)
  {
    if ((paramOnViewDetachedFromWindow == null) && (paramOnViewAttachedToWindow == null)) {
      paramOnViewDetachedFromWindow = null;
    } else {
      paramOnViewDetachedFromWindow = new View.OnAttachStateChangeListener()
      {
        public void onViewAttachedToWindow(View paramAnonymousView)
        {
          ViewBindingAdapter.OnViewAttachedToWindow localOnViewAttachedToWindow = this.val$attach;
          if (localOnViewAttachedToWindow != null) {
            localOnViewAttachedToWindow.onViewAttachedToWindow(paramAnonymousView);
          }
        }
        
        public void onViewDetachedFromWindow(View paramAnonymousView)
        {
          ViewBindingAdapter.OnViewDetachedFromWindow localOnViewDetachedFromWindow = paramOnViewDetachedFromWindow;
          if (localOnViewDetachedFromWindow != null) {
            localOnViewDetachedFromWindow.onViewDetachedFromWindow(paramAnonymousView);
          }
        }
      };
    }
    paramOnViewAttachedToWindow = (View.OnAttachStateChangeListener)ListenerUtil.trackListener(paramView, paramOnViewDetachedFromWindow, R.id.onAttachStateChangeListener);
    if (paramOnViewAttachedToWindow != null) {
      paramView.removeOnAttachStateChangeListener(paramOnViewAttachedToWindow);
    }
    if (paramOnViewDetachedFromWindow != null) {
      paramView.addOnAttachStateChangeListener(paramOnViewDetachedFromWindow);
    }
  }
  
  @BindingAdapter({"android:onClick", "android:clickable"})
  public static void setOnClick(View paramView, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setClickable(paramBoolean);
  }
  
  @BindingAdapter({"android:onLayoutChange"})
  public static void setOnLayoutChangeListener(View paramView, View.OnLayoutChangeListener paramOnLayoutChangeListener1, View.OnLayoutChangeListener paramOnLayoutChangeListener2)
  {
    if (paramOnLayoutChangeListener1 != null) {
      paramView.removeOnLayoutChangeListener(paramOnLayoutChangeListener1);
    }
    if (paramOnLayoutChangeListener2 != null) {
      paramView.addOnLayoutChangeListener(paramOnLayoutChangeListener2);
    }
  }
  
  @BindingAdapter({"android:onLongClick", "android:longClickable"})
  public static void setOnLongClick(View paramView, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean)
  {
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setLongClickable(paramBoolean);
  }
  
  @BindingAdapter({"android:onLongClickListener", "android:longClickable"})
  public static void setOnLongClickListener(View paramView, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean)
  {
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setLongClickable(paramBoolean);
  }
  
  @BindingAdapter({"android:padding"})
  public static void setPadding(View paramView, float paramFloat)
  {
    int i = pixelsToDimensionPixelSize(paramFloat);
    paramView.setPadding(i, i, i, i);
  }
  
  @BindingAdapter({"android:paddingBottom"})
  public static void setPaddingBottom(View paramView, float paramFloat)
  {
    int i = pixelsToDimensionPixelSize(paramFloat);
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), i);
  }
  
  @BindingAdapter({"android:paddingEnd"})
  public static void setPaddingEnd(View paramView, float paramFloat)
  {
    int i = pixelsToDimensionPixelSize(paramFloat);
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setPaddingRelative(paramView.getPaddingStart(), paramView.getPaddingTop(), i, paramView.getPaddingBottom());
    } else {
      paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), i, paramView.getPaddingBottom());
    }
  }
  
  @BindingAdapter({"android:paddingLeft"})
  public static void setPaddingLeft(View paramView, float paramFloat)
  {
    paramView.setPadding(pixelsToDimensionPixelSize(paramFloat), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  @BindingAdapter({"android:paddingRight"})
  public static void setPaddingRight(View paramView, float paramFloat)
  {
    int i = pixelsToDimensionPixelSize(paramFloat);
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), i, paramView.getPaddingBottom());
  }
  
  @BindingAdapter({"android:paddingStart"})
  public static void setPaddingStart(View paramView, float paramFloat)
  {
    int i = pixelsToDimensionPixelSize(paramFloat);
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setPaddingRelative(i, paramView.getPaddingTop(), paramView.getPaddingEnd(), paramView.getPaddingBottom());
    } else {
      paramView.setPadding(i, paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
    }
  }
  
  @BindingAdapter({"android:paddingTop"})
  public static void setPaddingTop(View paramView, float paramFloat)
  {
    int i = pixelsToDimensionPixelSize(paramFloat);
    paramView.setPadding(paramView.getPaddingLeft(), i, paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  @BindingAdapter({"android:requiresFadingEdge"})
  public static void setRequiresFadingEdge(View paramView, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2;
    if ((paramInt & 0x2) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    }
    paramView.setVerticalFadingEdgeEnabled(bool2);
    paramView.setHorizontalFadingEdgeEnabled(bool1);
  }
  
  @TargetApi(12)
  public static abstract interface OnViewAttachedToWindow
  {
    public abstract void onViewAttachedToWindow(View paramView);
  }
  
  @TargetApi(12)
  public static abstract interface OnViewDetachedFromWindow
  {
    public abstract void onViewDetachedFromWindow(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\ViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */