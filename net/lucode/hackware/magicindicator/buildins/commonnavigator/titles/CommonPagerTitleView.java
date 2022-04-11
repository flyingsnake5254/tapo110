package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b;

public class CommonPagerTitleView
  extends FrameLayout
  implements b
{
  private b c;
  private a d;
  
  public CommonPagerTitleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b localb = this.c;
    if (localb != null) {
      localb.a(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    b localb = this.c;
    if (localb != null) {
      localb.b(paramInt1, paramInt2, paramFloat, paramBoolean);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    b localb = this.c;
    if (localb != null) {
      localb.c(paramInt1, paramInt2);
    }
  }
  
  public void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    b localb = this.c;
    if (localb != null) {
      localb.d(paramInt1, paramInt2, paramFloat, paramBoolean);
    }
  }
  
  public void e(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    removeAllViews();
    if (paramView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      }
      addView(paramView, localLayoutParams);
    }
  }
  
  public int getContentBottom()
  {
    a locala = this.d;
    if (locala != null) {
      return locala.getContentBottom();
    }
    return getBottom();
  }
  
  public int getContentLeft()
  {
    a locala = this.d;
    if (locala != null) {
      return locala.getContentLeft();
    }
    return getLeft();
  }
  
  public a getContentPositionDataProvider()
  {
    return this.d;
  }
  
  public int getContentRight()
  {
    a locala = this.d;
    if (locala != null) {
      return locala.getContentRight();
    }
    return getRight();
  }
  
  public int getContentTop()
  {
    a locala = this.d;
    if (locala != null) {
      return locala.getContentTop();
    }
    return getTop();
  }
  
  public b getOnPagerTitleChangeListener()
  {
    return this.c;
  }
  
  public void setContentPositionDataProvider(a parama)
  {
    this.d = parama;
  }
  
  public void setContentView(int paramInt)
  {
    e(LayoutInflater.from(getContext()).inflate(paramInt, null), null);
  }
  
  public void setContentView(View paramView)
  {
    e(paramView, null);
  }
  
  public void setOnPagerTitleChangeListener(b paramb)
  {
    this.c = paramb;
  }
  
  public static abstract interface a
  {
    public abstract int getContentBottom();
    
    public abstract int getContentLeft();
    
    public abstract int getContentRight();
    
    public abstract int getContentTop();
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean);
    
    public abstract void c(int paramInt1, int paramInt2);
    
    public abstract void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\titles\CommonPagerTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */