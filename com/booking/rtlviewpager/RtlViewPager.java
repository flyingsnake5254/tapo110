package com.booking.rtlviewpager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.text.TextUtilsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.util.Map;

public class RtlViewPager
  extends ViewPager
{
  @NonNull
  private final Map<ViewPager.OnPageChangeListener, d> c = new ArrayMap(1);
  @Nullable
  private DataSetObserver d;
  private boolean f;
  
  public RtlViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public RtlViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int c(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (d()) {
        if (getAdapter() == null) {
          i = 0;
        } else {
          i = getAdapter().getCount() - paramInt - 1;
        }
      }
    }
    return i;
  }
  
  private void e(PagerAdapter paramPagerAdapter)
  {
    if (((paramPagerAdapter instanceof c)) && (this.d == null))
    {
      b localb = new b((c)paramPagerAdapter, null);
      this.d = localb;
      paramPagerAdapter.registerDataSetObserver(localb);
      c.b((c)paramPagerAdapter);
    }
  }
  
  private void f()
  {
    PagerAdapter localPagerAdapter = super.getAdapter();
    if ((localPagerAdapter instanceof c))
    {
      DataSetObserver localDataSetObserver = this.d;
      if (localDataSetObserver != null)
      {
        localPagerAdapter.unregisterDataSetObserver(localDataSetObserver);
        this.d = null;
      }
    }
  }
  
  private void setCurrentItemWithoutNotification(int paramInt)
  {
    this.f = true;
    setCurrentItem(paramInt, false);
    this.f = false;
  }
  
  public void addOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    Object localObject = paramOnPageChangeListener;
    if (d())
    {
      localObject = new d(paramOnPageChangeListener, null);
      this.c.put(paramOnPageChangeListener, localObject);
    }
    super.addOnPageChangeListener((ViewPager.OnPageChangeListener)localObject);
  }
  
  protected boolean d()
  {
    int i = TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (!d()) {
      paramFloat = -paramFloat;
    }
    super.fakeDragBy(paramFloat);
  }
  
  @Nullable
  public PagerAdapter getAdapter()
  {
    PagerAdapter localPagerAdapter1 = super.getAdapter();
    PagerAdapter localPagerAdapter2 = localPagerAdapter1;
    if ((localPagerAdapter1 instanceof c)) {
      localPagerAdapter2 = ((c)localPagerAdapter1).a();
    }
    return localPagerAdapter2;
  }
  
  public int getCurrentItem()
  {
    return c(super.getCurrentItem());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e(super.getAdapter());
  }
  
  protected void onDetachedFromWindow()
  {
    f();
    super.onDetachedFromWindow();
  }
  
  public void removeOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = paramOnPageChangeListener;
    if (d()) {
      localOnPageChangeListener = (ViewPager.OnPageChangeListener)this.c.remove(paramOnPageChangeListener);
    }
    super.removeOnPageChangeListener(localOnPageChangeListener);
  }
  
  public void setAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    f();
    int i;
    if ((paramPagerAdapter != null) && (d())) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = paramPagerAdapter;
    if (i != 0)
    {
      localObject = new c(paramPagerAdapter);
      e((PagerAdapter)localObject);
    }
    super.setAdapter((PagerAdapter)localObject);
    if (i != 0) {
      setCurrentItemWithoutNotification(0);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    super.setCurrentItem(c(paramInt));
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    super.setCurrentItem(c(paramInt), paramBoolean);
  }
  
  private static class b
    extends DataSetObserver
  {
    @NonNull
    private final RtlViewPager.c a;
    
    private b(@NonNull RtlViewPager.c paramc)
    {
      this.a = paramc;
    }
    
    public void onChanged()
    {
      super.onChanged();
      RtlViewPager.c.b(this.a);
    }
  }
  
  private class c
    extends a
  {
    private int b;
    
    public c(PagerAdapter paramPagerAdapter)
    {
      super();
      this.b = paramPagerAdapter.getCount();
    }
    
    private void c()
    {
      int i = getCount();
      int j = this.b;
      if (i != j)
      {
        RtlViewPager.a(RtlViewPager.this, Math.max(0, j - 1));
        this.b = i;
      }
    }
    
    private int d(int paramInt)
    {
      return getCount() - paramInt - 1;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      super.destroyItem(paramViewGroup, d(paramInt), paramObject);
    }
    
    public int getItemPosition(Object paramObject)
    {
      int i = super.getItemPosition(paramObject);
      if (i >= 0) {
        i = d(i);
      }
      return i;
    }
    
    public CharSequence getPageTitle(int paramInt)
    {
      return super.getPageTitle(d(paramInt));
    }
    
    public float getPageWidth(int paramInt)
    {
      return super.getPageWidth(d(paramInt));
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      return super.instantiateItem(paramViewGroup, d(paramInt));
    }
    
    public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      super.setPrimaryItem(paramViewGroup, this.b - paramInt - 1, paramObject);
    }
  }
  
  private class d
    implements ViewPager.OnPageChangeListener
  {
    @NonNull
    private final ViewPager.OnPageChangeListener c;
    private int d;
    
    private d(ViewPager.OnPageChangeListener paramOnPageChangeListener)
    {
      this.c = paramOnPageChangeListener;
      this.d = -1;
    }
    
    private int a(int paramInt)
    {
      PagerAdapter localPagerAdapter = RtlViewPager.this.getAdapter();
      if (localPagerAdapter != null) {
        paramInt = localPagerAdapter.getCount() - paramInt - 1;
      }
      return paramInt;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      if (!RtlViewPager.b(RtlViewPager.this)) {
        this.c.onPageScrollStateChanged(paramInt);
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (!RtlViewPager.b(RtlViewPager.this))
      {
        boolean bool = paramFloat < 0.0F;
        if ((!bool) && (paramInt2 == 0)) {
          this.d = a(paramInt1);
        } else {
          this.d = a(paramInt1 + 1);
        }
        ViewPager.OnPageChangeListener localOnPageChangeListener = this.c;
        paramInt1 = this.d;
        float f1 = paramFloat;
        if (bool) {
          f1 = 1.0F - paramFloat;
        }
        localOnPageChangeListener.onPageScrolled(paramInt1, f1, paramInt2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      if (!RtlViewPager.b(RtlViewPager.this)) {
        this.c.onPageSelected(a(paramInt));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\booking\rtlviewpager\RtlViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */