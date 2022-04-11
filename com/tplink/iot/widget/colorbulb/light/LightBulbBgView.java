package com.tplink.iot.widget.colorbulb.light;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Nullable;

public class LightBulbBgView
  extends FrameLayout
{
  private int c;
  private Paint d = new Paint(1);
  private Drawable f = getResources().getDrawable(2131689520);
  private Drawable q = getResources().getDrawable(2131689521);
  private boolean x;
  private View y;
  
  public LightBulbBgView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LightBulbBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LightBulbBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setBackground(this.f);
    paramAttributeSet = new View(paramContext);
    this.y = paramAttributeSet;
    paramAttributeSet.setBackground(paramContext.getResources().getDrawable(2131231516));
    addView(this.y, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void setMaskAlphaByBrightness(int paramInt)
  {
    this.y.setVisibility(0);
    float f1 = (float)((100 - paramInt) * 1.0D / 100.0D);
    this.y.setAlpha(f1);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.x = paramBoolean;
    if (paramBoolean)
    {
      setBackground(this.q);
      setMaskAlphaByBrightness(paramInt2);
    }
    else
    {
      setBackground(this.f);
      this.y.setVisibility(8);
    }
    this.c = paramInt1;
    invalidate();
  }
  
  public int getColor()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.x)
    {
      this.d.setColor(this.c);
      float f1 = getWidth() / 2;
      float f2 = getHeight() / 2;
      int i = this.c;
      float f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      Object localObject = Shader.TileMode.MIRROR;
      localObject = new RadialGradient(f1, f2, f3, new int[] { i & 0xFFFFFF | 0xB3000000, i & 0xFFFFFF | 0x8000000 }, null, (Shader.TileMode)localObject);
      this.d.setShader((Shader)localObject);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.d);
    }
  }
  
  public void setBrightness(int paramInt)
  {
    if (this.x) {
      setMaskAlphaByBrightness(paramInt);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\light\LightBulbBgView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */