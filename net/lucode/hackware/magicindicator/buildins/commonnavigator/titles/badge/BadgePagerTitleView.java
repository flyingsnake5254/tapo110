package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d;

public class BadgePagerTitleView
  extends FrameLayout
  implements b
{
  private d c;
  private View d;
  private boolean f = true;
  private a q;
  private a x;
  
  public BadgePagerTitleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    d locald = this.c;
    if (locald != null) {
      locald.a(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    d locald = this.c;
    if (locald != null) {
      locald.b(paramInt1, paramInt2, paramFloat, paramBoolean);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    d locald = this.c;
    if (locald != null) {
      locald.c(paramInt1, paramInt2);
    }
    if (this.f) {
      setBadgeView(null);
    }
  }
  
  public void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    d locald = this.c;
    if (locald != null) {
      locald.d(paramInt1, paramInt2, paramFloat, paramBoolean);
    }
  }
  
  public View getBadgeView()
  {
    return this.d;
  }
  
  public int getContentBottom()
  {
    d locald = this.c;
    if ((locald instanceof b)) {
      return ((b)locald).getContentBottom();
    }
    return getBottom();
  }
  
  public int getContentLeft()
  {
    if ((this.c instanceof b)) {
      return getLeft() + ((b)this.c).getContentLeft();
    }
    return getLeft();
  }
  
  public int getContentRight()
  {
    if ((this.c instanceof b)) {
      return getLeft() + ((b)this.c).getContentRight();
    }
    return getRight();
  }
  
  public int getContentTop()
  {
    d locald = this.c;
    if ((locald instanceof b)) {
      return ((b)locald).getContentTop();
    }
    return getTop();
  }
  
  public d getInnerPagerTitleView()
  {
    return this.c;
  }
  
  public a getXBadgeRule()
  {
    return this.q;
  }
  
  public a getYBadgeRule()
  {
    return this.x;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.c;
    if (((localObject1 instanceof View)) && (this.d != null))
    {
      int[] arrayOfInt = new int[14];
      localObject1 = (View)localObject1;
      arrayOfInt[0] = ((View)localObject1).getLeft();
      arrayOfInt[1] = ((View)localObject1).getTop();
      arrayOfInt[2] = ((View)localObject1).getRight();
      arrayOfInt[3] = ((View)localObject1).getBottom();
      Object localObject2 = this.c;
      if ((localObject2 instanceof b))
      {
        localObject2 = (b)localObject2;
        arrayOfInt[4] = ((b)localObject2).getContentLeft();
        arrayOfInt[5] = ((b)localObject2).getContentTop();
        arrayOfInt[6] = ((b)localObject2).getContentRight();
        arrayOfInt[7] = ((b)localObject2).getContentBottom();
      }
      else
      {
        for (paramInt1 = 4; paramInt1 < 8; paramInt1++) {
          arrayOfInt[paramInt1] = arrayOfInt[(paramInt1 - 4)];
        }
      }
      arrayOfInt[8] = (((View)localObject1).getWidth() / 2);
      arrayOfInt[9] = (((View)localObject1).getHeight() / 2);
      arrayOfInt[10] = (arrayOfInt[4] / 2);
      arrayOfInt[11] = (arrayOfInt[5] / 2);
      arrayOfInt[12] = (arrayOfInt[6] + (arrayOfInt[2] - arrayOfInt[6]) / 2);
      arrayOfInt[13] = (arrayOfInt[7] + (arrayOfInt[3] - arrayOfInt[7]) / 2);
      if (this.q == null)
      {
        if (this.x != null) {
          throw null;
        }
      }
      else {
        throw null;
      }
    }
  }
  
  public void setAutoCancelBadge(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setBadgeView(View paramView)
  {
    if (this.d == paramView) {
      return;
    }
    this.d = paramView;
    removeAllViews();
    if ((this.c instanceof View))
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      addView((View)this.c, paramView);
    }
    if (this.d != null)
    {
      paramView = new FrameLayout.LayoutParams(-2, -2);
      addView(this.d, paramView);
    }
  }
  
  public void setInnerPagerTitleView(d paramd)
  {
    if (this.c == paramd) {
      return;
    }
    this.c = paramd;
    removeAllViews();
    if ((this.c instanceof View))
    {
      paramd = new FrameLayout.LayoutParams(-1, -1);
      addView((View)this.c, paramd);
    }
    if (this.d != null)
    {
      paramd = new FrameLayout.LayoutParams(-2, -2);
      addView(this.d, paramd);
    }
  }
  
  public void setXBadgeRule(a parama)
  {
    if (parama == null) {
      return;
    }
    throw null;
  }
  
  public void setYBadgeRule(a parama)
  {
    if (parama == null) {
      return;
    }
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\titles\badge\BadgePagerTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */