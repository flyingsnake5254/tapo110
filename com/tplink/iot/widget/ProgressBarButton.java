package com.tplink.iot.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatButton;
import com.tplink.iot.b;

public class ProgressBarButton
  extends AppCompatButton
{
  private int H3;
  private int I3;
  private float J3 = 0.0F;
  private Matrix K3;
  private int c = -14955521;
  private Paint d;
  private PorterDuffXfermode f;
  private int p0;
  private int p1;
  private int p2;
  private int p3;
  private RectF q;
  private RectF x;
  private int y = 0;
  private int z = 0;
  
  public ProgressBarButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProgressBarButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProgressBarButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ProgressBarButton, paramInt, 0);
    if (paramContext != null)
    {
      this.y = paramContext.getInteger(4, 0);
      this.p1 = paramContext.getColor(0, this.c);
      this.p2 = paramContext.getColor(2, this.c);
      this.p3 = paramContext.getColor(1, this.c);
      this.H3 = paramContext.getColor(5, this.c);
      this.I3 = paramContext.getColor(3, this.c);
      paramContext.recycle();
    }
    c();
  }
  
  private int a(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private int b(int paramInt)
  {
    if (paramInt == 0) {
      return this.p1;
    }
    if (paramInt == 1) {
      return this.p2;
    }
    if (paramInt == 2) {
      return this.p3;
    }
    if (paramInt == 4) {
      return this.H3;
    }
    return this.I3;
  }
  
  private void c()
  {
    Paint localPaint = new Paint(1);
    this.d = localPaint;
    localPaint.setColor(this.c);
    this.d.setAntiAlias(true);
    this.d.setStyle(Paint.Style.FILL);
    this.f = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    setGravity(17);
    this.K3 = new Matrix();
  }
  
  public void d(int paramInt, String paramString)
  {
    this.z = paramInt;
    invalidate();
    g(paramString, b(paramInt));
  }
  
  public void e()
  {
    TextPaint localTextPaint = getPaint();
    String str1 = getContext().getString(2131952733);
    Object localObject = getContext().getString(2131954378);
    String str2 = getContext().getString(2131954375);
    String str3 = getContext().getString(2131952466);
    float f1 = localTextPaint.measureText(str1);
    float f2 = localTextPaint.measureText((String)localObject);
    float f3 = localTextPaint.measureText(str2);
    f1 = Math.max(localTextPaint.measureText(str3), Math.max(f3, Math.max(f1, f2))) + a(28.0F);
    f2 = a(84.0F);
    f3 = f1;
    if (f1 < f2) {
      f3 = f2;
    }
    localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)f3);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void f(int paramInt, String paramString)
  {
    this.z = 1;
    this.p0 = paramInt;
    invalidate();
    g(paramString, this.p2);
  }
  
  public void g(String paramString, int paramInt)
  {
    setTextColor(paramInt);
    setText(paramString);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = this.q.height();
    float f2 = this.q.width();
    if ((f1 >= 0.0F) && (f2 >= 0.0F))
    {
      float f3 = (float)(f1 / 2.0D);
      float f4 = (float)(this.x.height() / 2.0D);
      this.d.setShader(null);
      int i = this.z;
      if (i != 0)
      {
        Object localObject;
        if (i != 1)
        {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                break label650;
              }
            }
          }
          for (;;)
          {
            this.d.setColor(-7829368);
            paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
            continue;
            this.d.setColor(-1);
            paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
            continue;
            f4 = this.J3;
            f1 = f2 / 30.0F;
            if (f4 + f1 > 2.0F * f2) {
              f1 = 0.0F;
            } else {
              f1 = f4 + f1;
            }
            this.J3 = f1;
            this.K3.setTranslate(f1, 0.0F);
            f1 = -f2;
            i = this.c;
            localObject = Shader.TileMode.CLAMP;
            localObject = new LinearGradient(f1, 0.0F, 0.0F, 0.0F, new int[] { i, -13155590, i }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
            ((LinearGradient)localObject).setLocalMatrix(this.K3);
            this.d.setShader((Shader)localObject);
            paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
            postInvalidateDelayed(10L);
          }
        }
        else
        {
          f1 = f2 - (int)(this.p0 * 1.0D / 100.0D * f2);
          i = this.c;
          localObject = Shader.TileMode.CLAMP;
          localObject = new LinearGradient(f1, 0.0F, f2, 0.0F, new int[] { i, -13155590 }, new float[] { 0.0F, 1.0F }, (Shader.TileMode)localObject);
          i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
          if (this.y == 0)
          {
            this.d.setColor(this.c);
            paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
            this.d.setColor(-1);
            paramCanvas.drawRoundRect(this.x, f4, f4, this.d);
          }
          else
          {
            this.d.setColor(-4000518);
            paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
          }
          this.d.setXfermode(this.f);
          this.d.setShader((Shader)localObject);
          paramCanvas.save();
          paramCanvas.translate(-f1, 0.0F);
          paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
          paramCanvas.restore();
          paramCanvas.restoreToCount(i);
          this.d.setXfermode(null);
        }
      }
      else if (this.y == 0)
      {
        this.d.setColor(this.c);
        paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
        this.d.setColor(-1);
        paramCanvas.drawRoundRect(this.x, f4, f4, this.d);
      }
      else
      {
        this.d.setColor(this.c);
        paramCanvas.drawRoundRect(this.q, f3, f3, this.d);
      }
      label650:
      boolean bool;
      if (this.z == 0) {
        bool = true;
      } else {
        bool = false;
      }
      setClickable(bool);
      super.onDraw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.q = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.x = new RectF(4.0F, 4.0F, paramInt1 - 4, paramInt2 - 4);
  }
  
  public void setType(int paramInt)
  {
    this.y = paramInt;
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\ProgressBarButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */