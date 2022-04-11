package com.hitomi.cslibrary.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.View;

public class CornerShadowView
  extends View
{
  private Paint c;
  private Path d;
  private int f;
  private int[] q;
  private float x;
  private float y;
  
  private CornerShadowView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  private void c()
  {
    float f1 = this.x;
    Object localObject1 = new RectF(-f1, -f1, f1, f1);
    Object localObject2 = new RectF((RectF)localObject1);
    f1 = this.y;
    ((RectF)localObject2).inset(-f1, -f1);
    this.d.reset();
    this.d.setFillType(Path.FillType.EVEN_ODD);
    this.d.moveTo(-this.x, 0.0F);
    this.d.rLineTo(-this.y, 0.0F);
    this.d.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
    this.d.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
    this.d.close();
    f1 = this.x;
    f1 /= (this.y + f1);
    localObject1 = this.c;
    float f2 = this.x;
    float f3 = this.y;
    int[] arrayOfInt = this.q;
    localObject2 = Shader.TileMode.CLAMP;
    ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, arrayOfInt, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
  }
  
  private void d()
  {
    Paint localPaint = new Paint(4);
    this.c = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.d = new Path();
  }
  
  private void setShadowColor(int[] paramArrayOfInt)
  {
    this.q = paramArrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(getMeasuredWidth(), getMeasuredHeight());
    paramCanvas.rotate(this.f, -getMeasuredWidth() / 2.0F, -getMeasuredHeight() / 2.0F);
    paramCanvas.drawPath(this.d, this.c);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(this.y + this.x);
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public void setCornerRadius(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public void setDirection(int paramInt)
  {
    if (paramInt != 32)
    {
      if (paramInt != 64)
      {
        if (paramInt != 128) {
          this.f = 0;
        } else {
          this.f = 270;
        }
      }
      else {
        this.f = 180;
      }
    }
    else {
      this.f = 90;
    }
  }
  
  public void setShadowColors(int[] paramArrayOfInt)
  {
    this.q = paramArrayOfInt;
    c();
    invalidate();
  }
  
  public void setShadowSize(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public static class b
  {
    private Context a;
    private int[] b;
    private float c;
    private float d;
    private int e;
    
    public CornerShadowView a()
    {
      CornerShadowView localCornerShadowView = new CornerShadowView(this.a, null);
      CornerShadowView.a(localCornerShadowView, this.b);
      localCornerShadowView.setCornerRadius(this.c);
      localCornerShadowView.setShadowSize(this.d);
      localCornerShadowView.setDirection(this.e);
      CornerShadowView.b(localCornerShadowView);
      return localCornerShadowView;
    }
    
    public b b(Context paramContext)
    {
      this.a = paramContext;
      return this;
    }
    
    public b c(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }
    
    public b d(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    public b e(int[] paramArrayOfInt)
    {
      this.b = paramArrayOfInt;
      return this;
    }
    
    public b f(float paramFloat)
    {
      this.d = paramFloat;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hitomi\cslibrary\base\view\CornerShadowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */