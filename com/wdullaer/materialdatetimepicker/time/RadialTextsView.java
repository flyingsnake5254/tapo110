package com.wdullaer.materialdatetimepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;

public class RadialTextsView
  extends View
{
  private boolean H3;
  private boolean I3;
  private float J3;
  private float K3;
  private float L3;
  private float M3;
  private float N3;
  private float O3;
  private int P3;
  private int Q3;
  private float R3;
  private boolean S3;
  private float T3;
  private float U3;
  private float[] V3;
  private float[] W3;
  private float[] X3;
  private float[] Y3;
  private float Z3;
  private float a4;
  private float b4;
  private final Paint c = new Paint();
  ObjectAnimator c4;
  private final Paint d = new Paint();
  ObjectAnimator d4;
  private a e4;
  private final Paint f = new Paint();
  private Typeface p0;
  private Typeface p1;
  private String[] p2;
  private String[] p3;
  private boolean q;
  private boolean x = false;
  private int y = -1;
  private b z;
  
  public RadialTextsView(Context paramContext)
  {
    super(paramContext);
  }
  
  private Paint[] a(String[] paramArrayOfString)
  {
    Paint[] arrayOfPaint = new Paint[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      int j = Integer.parseInt(paramArrayOfString[i]);
      if (j == this.y) {
        arrayOfPaint[i] = this.d;
      } else if (this.z.a(j)) {
        arrayOfPaint[i] = this.c;
      } else {
        arrayOfPaint[i] = this.f;
      }
    }
    return arrayOfPaint;
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = (float)Math.sqrt(3.0D) * paramFloat1 / 2.0F;
    float f2 = paramFloat1 / 2.0F;
    this.c.setTextSize(paramFloat4);
    this.d.setTextSize(paramFloat4);
    this.f.setTextSize(paramFloat4);
    paramFloat3 -= (this.c.descent() + this.c.ascent()) / 2.0F;
    paramArrayOfFloat1[0] = (paramFloat3 - paramFloat1);
    paramArrayOfFloat2[0] = (paramFloat2 - paramFloat1);
    paramArrayOfFloat1[1] = (paramFloat3 - f1);
    paramArrayOfFloat2[1] = (paramFloat2 - f1);
    paramArrayOfFloat1[2] = (paramFloat3 - f2);
    paramArrayOfFloat2[2] = (paramFloat2 - f2);
    paramArrayOfFloat1[3] = paramFloat3;
    paramArrayOfFloat2[3] = paramFloat2;
    paramArrayOfFloat1[4] = (paramFloat3 + f2);
    paramArrayOfFloat2[4] = (f2 + paramFloat2);
    paramArrayOfFloat1[5] = (paramFloat3 + f1);
    paramArrayOfFloat2[5] = (f1 + paramFloat2);
    paramArrayOfFloat1[6] = (paramFloat3 + paramFloat1);
    paramArrayOfFloat2[6] = (paramFloat2 + paramFloat1);
  }
  
  private void c(Canvas paramCanvas, float paramFloat, Typeface paramTypeface, String[] paramArrayOfString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.c.setTextSize(paramFloat);
    this.c.setTypeface(paramTypeface);
    paramTypeface = a(paramArrayOfString);
    paramCanvas.drawText(paramArrayOfString[0], paramArrayOfFloat1[3], paramArrayOfFloat2[0], paramTypeface[0]);
    paramCanvas.drawText(paramArrayOfString[1], paramArrayOfFloat1[4], paramArrayOfFloat2[1], paramTypeface[1]);
    paramCanvas.drawText(paramArrayOfString[2], paramArrayOfFloat1[5], paramArrayOfFloat2[2], paramTypeface[2]);
    paramCanvas.drawText(paramArrayOfString[3], paramArrayOfFloat1[6], paramArrayOfFloat2[3], paramTypeface[3]);
    paramCanvas.drawText(paramArrayOfString[4], paramArrayOfFloat1[5], paramArrayOfFloat2[4], paramTypeface[4]);
    paramCanvas.drawText(paramArrayOfString[5], paramArrayOfFloat1[4], paramArrayOfFloat2[5], paramTypeface[5]);
    paramCanvas.drawText(paramArrayOfString[6], paramArrayOfFloat1[3], paramArrayOfFloat2[6], paramTypeface[6]);
    paramCanvas.drawText(paramArrayOfString[7], paramArrayOfFloat1[2], paramArrayOfFloat2[5], paramTypeface[7]);
    paramCanvas.drawText(paramArrayOfString[8], paramArrayOfFloat1[1], paramArrayOfFloat2[4], paramTypeface[8]);
    paramCanvas.drawText(paramArrayOfString[9], paramArrayOfFloat1[0], paramArrayOfFloat2[3], paramTypeface[9]);
    paramCanvas.drawText(paramArrayOfString[10], paramArrayOfFloat1[1], paramArrayOfFloat2[2], paramTypeface[10]);
    paramCanvas.drawText(paramArrayOfString[11], paramArrayOfFloat1[2], paramArrayOfFloat2[1], paramTypeface[11]);
  }
  
  private void d()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2F, this.a4), Keyframe.ofFloat(1.0F, this.b4) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration('Ǵ');
    this.c4 = localObjectAnimator;
    localObjectAnimator.addUpdateListener(this.e4);
    float f1 = 'Ǵ';
    int i = (int)(1.25F * f1);
    f1 = f1 * 0.25F / i;
    localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, this.b4), Keyframe.ofFloat(f1, this.b4), Keyframe.ofFloat(1.0F - (1.0F - f1) * 0.2F, this.a4), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(f1, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) }).setDuration(i);
    this.d4 = localObjectAnimator;
    localObjectAnimator.addUpdateListener(this.e4);
  }
  
  public ObjectAnimator getDisappearAnimator()
  {
    if ((this.x) && (this.q))
    {
      ObjectAnimator localObjectAnimator = this.c4;
      if (localObjectAnimator != null) {
        return localObjectAnimator;
      }
    }
    Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
    return null;
  }
  
  public ObjectAnimator getReappearAnimator()
  {
    if ((this.x) && (this.q))
    {
      ObjectAnimator localObjectAnimator = this.d4;
      if (localObjectAnimator != null) {
        return localObjectAnimator;
      }
    }
    Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() != 0) && (this.x))
    {
      if (!this.q)
      {
        this.P3 = (getWidth() / 2);
        int i = getHeight() / 2;
        this.Q3 = i;
        float f1 = Math.min(this.P3, i) * this.J3;
        this.R3 = f1;
        if (!this.H3)
        {
          float f2 = this.K3;
          this.Q3 = ((int)(this.Q3 - f2 * f1 * 0.75D));
        }
        this.T3 = (this.N3 * f1);
        if (this.I3) {
          this.U3 = (f1 * this.O3);
        }
        d();
        this.S3 = true;
        this.q = true;
      }
      if (this.S3)
      {
        b(this.R3 * this.L3 * this.Z3, this.P3, this.Q3, this.T3, this.V3, this.W3);
        if (this.I3) {
          b(this.R3 * this.M3 * this.Z3, this.P3, this.Q3, this.U3, this.X3, this.Y3);
        }
        this.S3 = false;
      }
      c(paramCanvas, this.T3, this.p0, this.p2, this.W3, this.V3);
      if (this.I3) {
        c(paramCanvas, this.U3, this.p1, this.p3, this.Y3, this.X3);
      }
    }
  }
  
  public void setAnimationRadiusMultiplier(float paramFloat)
  {
    this.Z3 = paramFloat;
    this.S3 = true;
  }
  
  protected void setSelection(int paramInt)
  {
    this.y = paramInt;
  }
  
  private class a
    implements ValueAnimator.AnimatorUpdateListener
  {}
  
  static abstract interface b
  {
    public abstract boolean a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\time\RadialTextsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */