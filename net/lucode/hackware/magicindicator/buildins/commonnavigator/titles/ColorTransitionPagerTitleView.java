package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.widget.TextView;
import net.lucode.hackware.magicindicator.g.a;

public class ColorTransitionPagerTitleView
  extends SimplePagerTitleView
{
  public ColorTransitionPagerTitleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    setTextColor(a.a(paramFloat, this.d, this.c));
  }
  
  public void c(int paramInt1, int paramInt2) {}
  
  public void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    setTextColor(a.a(paramFloat, this.c, this.d));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\titles\ColorTransitionPagerTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */