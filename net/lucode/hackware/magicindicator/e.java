package net.lucode.hackware.magicindicator;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class e
{
  public static void a(MagicIndicator paramMagicIndicator, ViewPager paramViewPager)
  {
    paramViewPager.addOnPageChangeListener(new a(paramMagicIndicator));
  }
  
  static final class a
    implements ViewPager.OnPageChangeListener
  {
    a(MagicIndicator paramMagicIndicator) {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      this.c.a(paramInt);
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      this.c.b(paramInt1, paramFloat, paramInt2);
    }
    
    public void onPageSelected(int paramInt)
    {
      this.c.c(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */