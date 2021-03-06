package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.style;
import androidx.appcompat.R.styleable;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable
  extends Drawable
{
  public static final int ARROW_DIRECTION_END = 3;
  public static final int ARROW_DIRECTION_LEFT = 0;
  public static final int ARROW_DIRECTION_RIGHT = 1;
  public static final int ARROW_DIRECTION_START = 2;
  private static final float ARROW_HEAD_ANGLE = (float)Math.toRadians(45.0D);
  private float mArrowHeadLength;
  private float mArrowShaftLength;
  private float mBarGap;
  private float mBarLength;
  private int mDirection;
  private float mMaxCutForBarSize;
  private final Paint mPaint;
  private final Path mPath;
  private float mProgress;
  private final int mSize;
  private boolean mSpin;
  private boolean mVerticalMirror;
  
  public DrawerArrowDrawable(Context paramContext)
  {
    Paint localPaint = new Paint();
    this.mPaint = localPaint;
    this.mPath = new Path();
    this.mVerticalMirror = false;
    this.mDirection = 2;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeJoin(Paint.Join.MITER);
    localPaint.setStrokeCap(Paint.Cap.BUTT);
    localPaint.setAntiAlias(true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
    setColor(paramContext.getColor(R.styleable.DrawerArrowToggle_color, 0));
    setBarThickness(paramContext.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0F));
    setSpinEnabled(paramContext.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
    setGapSize(Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0F)));
    this.mSize = paramContext.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
    this.mBarLength = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0F));
    this.mArrowHeadLength = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0F));
    this.mArrowShaftLength = paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0F);
    paramContext.recycle();
  }
  
  private static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = this.mDirection;
    int j = 0;
    int k = j;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 3)
        {
          k = j;
          if (DrawableCompat.getLayoutDirection(this) != 1) {
            break label60;
          }
        }
        else
        {
          k = j;
          if (DrawableCompat.getLayoutDirection(this) != 0) {
            break label60;
          }
        }
      }
      k = 1;
    }
    label60:
    float f1 = this.mArrowHeadLength;
    f1 = (float)Math.sqrt(f1 * f1 * 2.0F);
    float f2 = lerp(this.mBarLength, f1, this.mProgress);
    float f3 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
    float f4 = Math.round(lerp(0.0F, this.mMaxCutForBarSize, this.mProgress));
    float f5 = lerp(0.0F, ARROW_HEAD_ANGLE, this.mProgress);
    if (k != 0) {
      f1 = 0.0F;
    } else {
      f1 = -180.0F;
    }
    if (k != 0) {
      f6 = 180.0F;
    } else {
      f6 = 0.0F;
    }
    f1 = lerp(f1, f6, this.mProgress);
    double d1 = f2;
    double d2 = f5;
    float f6 = (float)Math.round(Math.cos(d2) * d1);
    f5 = (float)Math.round(d1 * Math.sin(d2));
    this.mPath.rewind();
    float f7 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
    f2 = -f3 / 2.0F;
    this.mPath.moveTo(f2 + f4, 0.0F);
    this.mPath.rLineTo(f3 - f4 * 2.0F, 0.0F);
    this.mPath.moveTo(f2, f7);
    this.mPath.rLineTo(f6, f5);
    this.mPath.moveTo(f2, -f7);
    this.mPath.rLineTo(f6, -f5);
    this.mPath.close();
    paramCanvas.save();
    f6 = this.mPaint.getStrokeWidth();
    f4 = localRect.height();
    f3 = this.mBarGap;
    f4 = (int)(f4 - 3.0F * f6 - 2.0F * f3) / 4 * 2;
    paramCanvas.translate(localRect.centerX(), f4 + (f6 * 1.5F + f3));
    if (this.mSpin)
    {
      if ((this.mVerticalMirror ^ k)) {
        k = -1;
      } else {
        k = 1;
      }
      paramCanvas.rotate(f1 * k);
    }
    else if (k != 0)
    {
      paramCanvas.rotate(180.0F);
    }
    paramCanvas.drawPath(this.mPath, this.mPaint);
    paramCanvas.restore();
  }
  
  public float getArrowHeadLength()
  {
    return this.mArrowHeadLength;
  }
  
  public float getArrowShaftLength()
  {
    return this.mArrowShaftLength;
  }
  
  public float getBarLength()
  {
    return this.mBarLength;
  }
  
  public float getBarThickness()
  {
    return this.mPaint.getStrokeWidth();
  }
  
  @ColorInt
  public int getColor()
  {
    return this.mPaint.getColor();
  }
  
  public int getDirection()
  {
    return this.mDirection;
  }
  
  public float getGapSize()
  {
    return this.mBarGap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mSize;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mSize;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.mProgress;
  }
  
  public boolean isSpinEnabled()
  {
    return this.mSpin;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setArrowHeadLength(float paramFloat)
  {
    if (this.mArrowHeadLength != paramFloat)
    {
      this.mArrowHeadLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setArrowShaftLength(float paramFloat)
  {
    if (this.mArrowShaftLength != paramFloat)
    {
      this.mArrowShaftLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarLength(float paramFloat)
  {
    if (this.mBarLength != paramFloat)
    {
      this.mBarLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarThickness(float paramFloat)
  {
    if (this.mPaint.getStrokeWidth() != paramFloat)
    {
      this.mPaint.setStrokeWidth(paramFloat);
      this.mMaxCutForBarSize = ((float)(paramFloat / 2.0F * Math.cos(ARROW_HEAD_ANGLE)));
      invalidateSelf();
    }
  }
  
  public void setColor(@ColorInt int paramInt)
  {
    if (paramInt != this.mPaint.getColor())
    {
      this.mPaint.setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDirection(int paramInt)
  {
    if (paramInt != this.mDirection)
    {
      this.mDirection = paramInt;
      invalidateSelf();
    }
  }
  
  public void setGapSize(float paramFloat)
  {
    if (paramFloat != this.mBarGap)
    {
      this.mBarGap = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.mProgress != paramFloat)
    {
      this.mProgress = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setSpinEnabled(boolean paramBoolean)
  {
    if (this.mSpin != paramBoolean)
    {
      this.mSpin = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setVerticalMirror(boolean paramBoolean)
  {
    if (this.mVerticalMirror != paramBoolean)
    {
      this.mVerticalMirror = paramBoolean;
      invalidateSelf();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface ArrowDirection {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\graphics\drawable\DrawerArrowDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */