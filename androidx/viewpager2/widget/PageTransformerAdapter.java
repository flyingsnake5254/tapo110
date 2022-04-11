package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import java.util.Locale;

final class PageTransformerAdapter
  extends ViewPager2.OnPageChangeCallback
{
  private final LinearLayoutManager mLayoutManager;
  private ViewPager2.PageTransformer mPageTransformer;
  
  PageTransformerAdapter(LinearLayoutManager paramLinearLayoutManager)
  {
    this.mLayoutManager = paramLinearLayoutManager;
  }
  
  ViewPager2.PageTransformer getPageTransformer()
  {
    return this.mPageTransformer;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.mPageTransformer == null) {
      return;
    }
    float f = -paramFloat;
    paramInt2 = 0;
    while (paramInt2 < this.mLayoutManager.getChildCount())
    {
      View localView = this.mLayoutManager.getChildAt(paramInt2);
      if (localView != null)
      {
        paramFloat = this.mLayoutManager.getPosition(localView) - paramInt1;
        this.mPageTransformer.transformPage(localView, paramFloat + f);
        paramInt2++;
      }
      else
      {
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.mLayoutManager.getChildCount()) }));
      }
    }
  }
  
  public void onPageSelected(int paramInt) {}
  
  void setPageTransformer(@Nullable ViewPager2.PageTransformer paramPageTransformer)
  {
    this.mPageTransformer = paramPageTransformer;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\viewpager2\widget\PageTransformerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */