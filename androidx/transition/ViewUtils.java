package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

class ViewUtils
{
  static final Property<View, Rect> CLIP_BOUNDS = new Property(Rect.class, "clipBounds")
  {
    public Rect get(View paramAnonymousView)
    {
      return ViewCompat.getClipBounds(paramAnonymousView);
    }
    
    public void set(View paramAnonymousView, Rect paramAnonymousRect)
    {
      ViewCompat.setClipBounds(paramAnonymousView, paramAnonymousRect);
    }
  };
  private static final ViewUtilsBase IMPL;
  private static final String TAG = "ViewUtils";
  static final Property<View, Float> TRANSITION_ALPHA;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      IMPL = new ViewUtilsApi29();
    } else if (i >= 23) {
      IMPL = new ViewUtilsApi23();
    } else if (i >= 22) {
      IMPL = new ViewUtilsApi22();
    } else if (i >= 21) {
      IMPL = new ViewUtilsApi21();
    } else if (i >= 19) {
      IMPL = new ViewUtilsApi19();
    } else {
      IMPL = new ViewUtilsBase();
    }
    TRANSITION_ALPHA = new Property(Float.class, "translationAlpha")
    {
      public Float get(View paramAnonymousView)
      {
        return Float.valueOf(ViewUtils.getTransitionAlpha(paramAnonymousView));
      }
      
      public void set(View paramAnonymousView, Float paramAnonymousFloat)
      {
        ViewUtils.setTransitionAlpha(paramAnonymousView, paramAnonymousFloat.floatValue());
      }
    };
  }
  
  static void clearNonTransitionAlpha(@NonNull View paramView)
  {
    IMPL.clearNonTransitionAlpha(paramView);
  }
  
  static ViewOverlayImpl getOverlay(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new ViewOverlayApi18(paramView);
    }
    return ViewOverlayApi14.createFrom(paramView);
  }
  
  static float getTransitionAlpha(@NonNull View paramView)
  {
    return IMPL.getTransitionAlpha(paramView);
  }
  
  static WindowIdImpl getWindowId(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new WindowIdApi18(paramView);
    }
    return new WindowIdApi14(paramView.getWindowToken());
  }
  
  static void saveNonTransitionAlpha(@NonNull View paramView)
  {
    IMPL.saveNonTransitionAlpha(paramView);
  }
  
  static void setAnimationMatrix(@NonNull View paramView, @Nullable Matrix paramMatrix)
  {
    IMPL.setAnimationMatrix(paramView, paramMatrix);
  }
  
  static void setLeftTopRightBottom(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setLeftTopRightBottom(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    IMPL.setTransitionAlpha(paramView, paramFloat);
  }
  
  static void setTransitionVisibility(@NonNull View paramView, int paramInt)
  {
    IMPL.setTransitionVisibility(paramView, paramInt);
  }
  
  static void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    IMPL.transformMatrixToGlobal(paramView, paramMatrix);
  }
  
  static void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    IMPL.transformMatrixToLocal(paramView, paramMatrix);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */