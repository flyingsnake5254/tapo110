package io.codetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c.a.a.a;

public class RevealFrameLayout
  extends FrameLayout
  implements a
{
  private Path c = new Path();
  private final Rect d = new Rect();
  private boolean f;
  private float q;
  
  public RevealFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RevealFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RevealFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (!this.f) {
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    throw null;
  }
  
  public float getRevealRadius()
  {
    return this.q;
  }
  
  public void setRevealRadius(float paramFloat)
  {
    this.q = paramFloat;
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\codetail\widget\RevealFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */