package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.ParcelableSparseArray;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class BadgeUtils
{
  public static final boolean USE_COMPAT_PARENT;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    USE_COMPAT_PARENT = bool;
  }
  
  public static void attachBadgeDrawable(@NonNull BadgeDrawable paramBadgeDrawable, @NonNull View paramView, @NonNull FrameLayout paramFrameLayout)
  {
    setBadgeDrawableBounds(paramBadgeDrawable, paramView, paramFrameLayout);
    if (USE_COMPAT_PARENT) {
      paramFrameLayout.setForeground(paramBadgeDrawable);
    } else {
      paramView.getOverlay().add(paramBadgeDrawable);
    }
  }
  
  @NonNull
  public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context paramContext, @NonNull ParcelableSparseArray paramParcelableSparseArray)
  {
    SparseArray localSparseArray = new SparseArray(paramParcelableSparseArray.size());
    int i = 0;
    while (i < paramParcelableSparseArray.size())
    {
      int j = paramParcelableSparseArray.keyAt(i);
      BadgeDrawable.SavedState localSavedState = (BadgeDrawable.SavedState)paramParcelableSparseArray.valueAt(i);
      if (localSavedState != null)
      {
        localSparseArray.put(j, BadgeDrawable.createFromSavedState(paramContext, localSavedState));
        i++;
      }
      else
      {
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
      }
    }
    return localSparseArray;
  }
  
  @NonNull
  public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> paramSparseArray)
  {
    ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      BadgeDrawable localBadgeDrawable = (BadgeDrawable)paramSparseArray.valueAt(i);
      if (localBadgeDrawable != null)
      {
        localParcelableSparseArray.put(j, localBadgeDrawable.getSavedState());
        i++;
      }
      else
      {
        throw new IllegalArgumentException("badgeDrawable cannot be null");
      }
    }
    return localParcelableSparseArray;
  }
  
  public static void detachBadgeDrawable(@Nullable BadgeDrawable paramBadgeDrawable, @NonNull View paramView, @NonNull FrameLayout paramFrameLayout)
  {
    if (paramBadgeDrawable == null) {
      return;
    }
    if (USE_COMPAT_PARENT) {
      paramFrameLayout.setForeground(null);
    } else {
      paramView.getOverlay().remove(paramBadgeDrawable);
    }
  }
  
  public static void setBadgeDrawableBounds(@NonNull BadgeDrawable paramBadgeDrawable, @NonNull View paramView, @NonNull FrameLayout paramFrameLayout)
  {
    Rect localRect = new Rect();
    Object localObject;
    if (USE_COMPAT_PARENT) {
      localObject = paramFrameLayout;
    } else {
      localObject = paramView;
    }
    ((View)localObject).getDrawingRect(localRect);
    paramBadgeDrawable.setBounds(localRect);
    paramBadgeDrawable.updateBadgeCoordinates(paramView, paramFrameLayout);
  }
  
  public static void updateBadgeBounds(@NonNull Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramRect.set((int)(paramFloat1 - paramFloat3), (int)(paramFloat2 - paramFloat4), (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\badge\BadgeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */