package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import net.lucode.hackware.magicindicator.f.a;

public class MagicIndicator
  extends FrameLayout
{
  private a c;
  
  public MagicIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public MagicIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    a locala = this.c;
    if (locala != null) {
      locala.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void b(int paramInt1, float paramFloat, int paramInt2)
  {
    a locala = this.c;
    if (locala != null) {
      locala.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void c(int paramInt)
  {
    a locala = this.c;
    if (locala != null) {
      locala.onPageSelected(paramInt);
    }
  }
  
  public a getNavigator()
  {
    return this.c;
  }
  
  public void setNavigator(a parama)
  {
    a locala = this.c;
    if (locala == parama) {
      return;
    }
    if (locala != null) {
      locala.f();
    }
    this.c = parama;
    removeAllViews();
    if ((this.c instanceof View))
    {
      parama = new FrameLayout.LayoutParams(-1, -1);
      addView((View)this.c, parama);
      this.c.e();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\MagicIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */