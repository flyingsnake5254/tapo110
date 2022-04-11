package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector
{
  private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
  private LinearLayoutManager mLayoutManager;
  
  static
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
    ZERO_MARGIN_LAYOUT_PARAMS = localMarginLayoutParams;
    localMarginLayoutParams.setMargins(0, 0, 0, 0);
  }
  
  AnimateLayoutChangeDetector(@NonNull LinearLayoutManager paramLinearLayoutManager)
  {
    this.mLayoutManager = paramLinearLayoutManager;
  }
  
  private boolean arePagesLaidOutContiguously()
  {
    int i = this.mLayoutManager.getChildCount();
    if (i == 0) {
      return true;
    }
    if (this.mLayoutManager.getOrientation() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    int[][] arrayOfInt = new int[i][2];
    int k = 0;
    while (k < i)
    {
      View localView = this.mLayoutManager.getChildAt(k);
      if (localView != null)
      {
        Object localObject = localView.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
        } else {
          localObject = ZERO_MARGIN_LAYOUT_PARAMS;
        }
        int[] arrayOfInt1 = arrayOfInt[k];
        int m;
        int n;
        if (j != 0)
        {
          m = localView.getLeft();
          n = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        }
        else
        {
          m = localView.getTop();
          n = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
        }
        arrayOfInt1[0] = (m - n);
        arrayOfInt1 = arrayOfInt[k];
        if (j != 0)
        {
          m = localView.getRight();
          n = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        else
        {
          m = localView.getBottom();
          n = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        }
        arrayOfInt1[1] = (m + n);
        k++;
      }
      else
      {
        throw new IllegalStateException("null view contained in the view hierarchy");
      }
    }
    Arrays.sort(arrayOfInt, new Comparator()
    {
      public int compare(int[] paramAnonymousArrayOfInt1, int[] paramAnonymousArrayOfInt2)
      {
        return paramAnonymousArrayOfInt1[0] - paramAnonymousArrayOfInt2[0];
      }
    });
    for (int j = 1; j < i; j++) {
      if (arrayOfInt[(j - 1)][1] != arrayOfInt[j][0]) {
        return false;
      }
    }
    j = arrayOfInt[0][1];
    k = arrayOfInt[0][0];
    return (arrayOfInt[0][0] <= 0) && (arrayOfInt[(i - 1)][1] >= j - k);
  }
  
  private boolean hasRunningChangingLayoutTransition()
  {
    int i = this.mLayoutManager.getChildCount();
    for (int j = 0; j < i; j++) {
      if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(j))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean hasRunningChangingLayoutTransition(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      paramView = localViewGroup.getLayoutTransition();
      if ((paramView != null) && (paramView.isChangingLayout())) {
        return true;
      }
      int i = localViewGroup.getChildCount();
      for (int j = 0; j < i; j++) {
        if (hasRunningChangingLayoutTransition(localViewGroup.getChildAt(j))) {
          return true;
        }
      }
    }
    return false;
  }
  
  boolean mayHaveInterferingAnimations()
  {
    boolean bool1 = arePagesLaidOutContiguously();
    boolean bool2 = true;
    if (((bool1) && (this.mLayoutManager.getChildCount() > 1)) || (!hasRunningChangingLayoutTransition())) {
      bool2 = false;
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\viewpager2\widget\AnimateLayoutChangeDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */