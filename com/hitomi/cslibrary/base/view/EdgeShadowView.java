package com.hitomi.cslibrary.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.view.View;

public class EdgeShadowView
  extends View
{
  private Paint c;
  private int[] d;
  private float f;
  private float q;
  private float x;
  private int y;
  
  private EdgeShadowView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c()
  {
    Object localObject = new Paint();
    this.c = ((Paint)localObject);
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    Paint localPaint = this.c;
    float f1 = this.x;
    float f2 = -f1;
    float f3 = this.f;
    f1 = -f1;
    int[] arrayOfInt = this.d;
    localObject = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(0.0F, f2 + f3, 0.0F, f1 - f3, arrayOfInt, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
  }
  
  private void setShadowColor(int[] paramArrayOfInt)
  {
    this.d = paramArrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i = this.y;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            paramCanvas.translate(this.q, -this.x);
            paramCanvas.rotate(180.0F);
          }
        }
        else
        {
          paramCanvas.translate(-this.x, 0.0F);
          paramCanvas.rotate(90.0F);
        }
      }
      else {
        paramCanvas.translate(0.0F, this.x + this.f);
      }
    }
    else
    {
      paramCanvas.translate(this.x + this.f, this.q);
      paramCanvas.rotate(270.0F);
    }
    float f1 = this.x;
    paramCanvas.drawRect(0.0F, -f1 - this.f, this.q, -f1, this.c);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.y;
    if ((paramInt1 != 1) && (paramInt1 != 4))
    {
      paramInt2 = Math.round(this.q);
      paramInt1 = Math.round(this.f);
    }
    else
    {
      paramInt2 = Math.round(this.f);
      paramInt1 = Math.round(this.q);
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setCornerRadius(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public void setDirection(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setShadowColors(int[] paramArrayOfInt)
  {
    this.d = paramArrayOfInt;
    c();
    invalidate();
  }
  
  public void setShadowRadius(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setShadowSize(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public static class b
  {
    private Context a;
    private int[] b;
    private float c;
    private float d;
    private float e;
    private int f;
    
    public EdgeShadowView a()
    {
      EdgeShadowView localEdgeShadowView = new EdgeShadowView(this.a, null);
      EdgeShadowView.a(localEdgeShadowView, this.b);
      localEdgeShadowView.setShadowRadius(this.c);
      localEdgeShadowView.setShadowSize(this.d);
      localEdgeShadowView.setCornerRadius(this.e);
      localEdgeShadowView.setDirection(this.f);
      EdgeShadowView.b(localEdgeShadowView);
      return localEdgeShadowView;
    }
    
    public b b(Context paramContext)
    {
      this.a = paramContext;
      return this;
    }
    
    public b c(float paramFloat)
    {
      this.e = paramFloat;
      return this;
    }
    
    public b d(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
    
    public b e(int[] paramArrayOfInt)
    {
      this.b = paramArrayOfInt;
      return this;
    }
    
    public b f(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }
    
    public b g(float paramFloat)
    {
      this.d = paramFloat;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hitomi\cslibrary\base\view\EdgeShadowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */