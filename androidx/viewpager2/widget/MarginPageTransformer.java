package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

public final class MarginPageTransformer
  implements ViewPager2.PageTransformer
{
  private final int mMarginPx;
  
  public MarginPageTransformer(@Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt, "Margin must be non-negative");
    this.mMarginPx = paramInt;
  }
  
  private ViewPager2 requireViewPager(@NonNull View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    paramView = localViewParent.getParent();
    if (((localViewParent instanceof RecyclerView)) && ((paramView instanceof ViewPager2))) {
      return (ViewPager2)paramView;
    }
    throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
  }
  
  public void transformPage(@NonNull View paramView, float paramFloat)
  {
    ViewPager2 localViewPager2 = requireViewPager(paramView);
    float f = this.mMarginPx * paramFloat;
    if (localViewPager2.getOrientation() == 0)
    {
      paramFloat = f;
      if (localViewPager2.isRtl()) {
        paramFloat = -f;
      }
      paramView.setTranslationX(paramFloat);
    }
    else
    {
      paramView.setTranslationY(f);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\viewpager2\widget\MarginPageTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */