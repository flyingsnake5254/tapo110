package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.List;

public abstract class Utils
{
  public static final double DEG2RAD = 0.017453292519943295D;
  public static final double DOUBLE_EPSILON = Double.longBitsToDouble(1L);
  public static final float FDEG2RAD = 0.017453292F;
  public static final float FLOAT_EPSILON = Float.intBitsToFloat(1);
  private static final int[] POW_10;
  private static Rect mCalcTextHeightRect = new Rect();
  private static Rect mCalcTextSizeRect;
  private static ValueFormatter mDefaultValueFormatter;
  private static Rect mDrawTextRectBuffer = new Rect();
  private static Rect mDrawableBoundsCache;
  private static Paint.FontMetrics mFontMetrics = new Paint.FontMetrics();
  private static Paint.FontMetrics mFontMetricsBuffer = new Paint.FontMetrics();
  private static int mMaximumFlingVelocity = 8000;
  private static DisplayMetrics mMetrics;
  private static int mMinimumFlingVelocity = 50;
  
  static
  {
    mCalcTextSizeRect = new Rect();
    POW_10 = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
    mDefaultValueFormatter = generateDefaultValueFormatter();
    mDrawableBoundsCache = new Rect();
  }
  
  public static int calcTextHeight(Paint paramPaint, String paramString)
  {
    Rect localRect = mCalcTextHeightRect;
    localRect.set(0, 0, 0, 0);
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }
  
  public static FSize calcTextSize(Paint paramPaint, String paramString)
  {
    FSize localFSize = FSize.getInstance(0.0F, 0.0F);
    calcTextSize(paramPaint, paramString, localFSize);
    return localFSize;
  }
  
  public static void calcTextSize(Paint paramPaint, String paramString, FSize paramFSize)
  {
    Rect localRect = mCalcTextSizeRect;
    localRect.set(0, 0, 0, 0);
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    paramFSize.width = localRect.width();
    paramFSize.height = localRect.height();
  }
  
  public static int calcTextWidth(Paint paramPaint, String paramString)
  {
    return (int)paramPaint.measureText(paramString);
  }
  
  public static float convertDpToPixel(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = mMetrics;
    if (localDisplayMetrics == null)
    {
      Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
      return paramFloat;
    }
    return paramFloat * localDisplayMetrics.density;
  }
  
  public static int[] convertIntegers(List<Integer> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    copyIntegers(paramList, arrayOfInt);
    return arrayOfInt;
  }
  
  public static float convertPixelsToDp(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = mMetrics;
    if (localDisplayMetrics == null)
    {
      Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
      return paramFloat;
    }
    return paramFloat / localDisplayMetrics.density;
  }
  
  public static String[] convertStrings(List<String> paramList)
  {
    int i = paramList.size();
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++) {
      arrayOfString[j] = ((String)paramList.get(j));
    }
    return arrayOfString;
  }
  
  public static void copyIntegers(List<Integer> paramList, int[] paramArrayOfInt)
  {
    int i;
    if (paramArrayOfInt.length < paramList.size()) {
      i = paramArrayOfInt.length;
    } else {
      i = paramList.size();
    }
    for (int j = 0; j < i; j++) {
      paramArrayOfInt[j] = ((Integer)paramList.get(j)).intValue();
    }
  }
  
  public static void copyStrings(List<String> paramList, String[] paramArrayOfString)
  {
    int i;
    if (paramArrayOfString.length < paramList.size()) {
      i = paramArrayOfString.length;
    } else {
      i = paramList.size();
    }
    for (int j = 0; j < i; j++) {
      paramArrayOfString[j] = ((String)paramList.get(j));
    }
  }
  
  public static void drawImage(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    MPPointF localMPPointF = MPPointF.getInstance();
    localMPPointF.x = (paramInt1 - paramInt3 / 2);
    localMPPointF.y = (paramInt2 - paramInt4 / 2);
    paramDrawable.copyBounds(mDrawableBoundsCache);
    Rect localRect = mDrawableBoundsCache;
    paramInt1 = localRect.left;
    paramInt2 = localRect.top;
    paramDrawable.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt3 + paramInt2);
    paramInt1 = paramCanvas.save();
    paramCanvas.translate(localMPPointF.x, localMPPointF.y);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(paramInt1);
  }
  
  public static void drawMultilineText(Canvas paramCanvas, StaticLayout paramStaticLayout, float paramFloat1, float paramFloat2, TextPaint paramTextPaint, MPPointF paramMPPointF, float paramFloat3)
  {
    float f1 = paramTextPaint.getFontMetrics(mFontMetricsBuffer);
    float f2 = paramStaticLayout.getWidth();
    float f3 = paramStaticLayout.getLineCount() * f1;
    float f4 = 0.0F - mDrawTextRectBuffer.left;
    float f5 = f3 + 0.0F;
    Paint.Align localAlign = paramTextPaint.getTextAlign();
    paramTextPaint.setTextAlign(Paint.Align.LEFT);
    float f6;
    if (paramFloat3 != 0.0F)
    {
      if (paramMPPointF.x == 0.5F)
      {
        f6 = paramFloat1;
        f1 = paramFloat2;
        if (paramMPPointF.y == 0.5F) {}
      }
      else
      {
        FSize localFSize = getSizeOfRotatedRectangleByDegrees(f2, f3, paramFloat3);
        f6 = paramFloat1 - localFSize.width * (paramMPPointF.x - 0.5F);
        f1 = paramFloat2 - localFSize.height * (paramMPPointF.y - 0.5F);
        FSize.recycleInstance(localFSize);
      }
      paramCanvas.save();
      paramCanvas.translate(f6, f1);
      paramCanvas.rotate(paramFloat3);
      paramCanvas.translate(f4 - f2 * 0.5F, f5 - f3 * 0.5F);
      paramStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
    else
    {
      f6 = paramMPPointF.x;
      if (f6 == 0.0F)
      {
        f1 = f4;
        paramFloat3 = f5;
        if (paramMPPointF.y == 0.0F) {}
      }
      else
      {
        f1 = f4 - f2 * f6;
        paramFloat3 = f5 - f3 * paramMPPointF.y;
      }
      paramCanvas.save();
      paramCanvas.translate(f1 + paramFloat1, paramFloat3 + paramFloat2);
      paramStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramTextPaint.setTextAlign(localAlign);
  }
  
  public static void drawMultilineText(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, TextPaint paramTextPaint, FSize paramFSize, MPPointF paramMPPointF, float paramFloat3)
  {
    drawMultilineText(paramCanvas, new StaticLayout(paramString, 0, paramString.length(), paramTextPaint, (int)Math.max(Math.ceil(paramFSize.width), 1.0D), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false), paramFloat1, paramFloat2, paramTextPaint, paramMPPointF, paramFloat3);
  }
  
  public static void drawXAxisValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint, MPPointF paramMPPointF, float paramFloat3)
  {
    float f1 = paramPaint.getFontMetrics(mFontMetricsBuffer);
    paramPaint.getTextBounds(paramString, 0, paramString.length(), mDrawTextRectBuffer);
    float f2 = 0.0F - mDrawTextRectBuffer.left;
    float f3 = -mFontMetricsBuffer.ascent + 0.0F;
    Paint.Align localAlign = paramPaint.getTextAlign();
    paramPaint.setTextAlign(Paint.Align.LEFT);
    float f6;
    if (paramFloat3 != 0.0F)
    {
      float f4 = mDrawTextRectBuffer.width();
      float f5;
      if (paramMPPointF.x == 0.5F)
      {
        f5 = paramFloat1;
        f6 = paramFloat2;
        if (paramMPPointF.y == 0.5F) {}
      }
      else
      {
        FSize localFSize = getSizeOfRotatedRectangleByDegrees(mDrawTextRectBuffer.width(), f1, paramFloat3);
        f5 = paramFloat1 - localFSize.width * (paramMPPointF.x - 0.5F);
        f6 = paramFloat2 - localFSize.height * (paramMPPointF.y - 0.5F);
        FSize.recycleInstance(localFSize);
      }
      paramCanvas.save();
      paramCanvas.translate(f5, f6);
      paramCanvas.rotate(paramFloat3);
      paramCanvas.drawText(paramString, f2 - f4 * 0.5F, f3 - f1 * 0.5F, paramPaint);
      paramCanvas.restore();
    }
    else
    {
      if (paramMPPointF.x == 0.0F)
      {
        f6 = f2;
        paramFloat3 = f3;
        if (paramMPPointF.y == 0.0F) {}
      }
      else
      {
        f6 = f2 - mDrawTextRectBuffer.width() * paramMPPointF.x;
        paramFloat3 = f3 - f1 * paramMPPointF.y;
      }
      paramCanvas.drawText(paramString, f6 + paramFloat1, paramFloat3 + paramFloat2, paramPaint);
    }
    paramPaint.setTextAlign(localAlign);
  }
  
  public static String formatNumber(float paramFloat, int paramInt, boolean paramBoolean)
  {
    return formatNumber(paramFloat, paramInt, paramBoolean, '.');
  }
  
  public static String formatNumber(float paramFloat, int paramInt, boolean paramBoolean, char paramChar)
  {
    char[] arrayOfChar = new char[35];
    if (paramFloat == 0.0F) {
      return "0";
    }
    int i = 0;
    int j;
    if ((paramFloat < 1.0F) && (paramFloat > -1.0F)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (paramFloat < 0.0F)
    {
      paramFloat = -paramFloat;
      k = 1;
    }
    else
    {
      k = 0;
    }
    int[] arrayOfInt = POW_10;
    int m;
    if (paramInt > arrayOfInt.length) {
      m = arrayOfInt.length - 1;
    } else {
      m = paramInt;
    }
    long l = Math.round(paramFloat * arrayOfInt[m]);
    char c1 = '"';
    char c2;
    for (paramInt = 0;; paramInt = c2)
    {
      if ((l == 0L) && (i >= m + 1))
      {
        paramChar = c1;
        paramInt = i;
        if (j != 0)
        {
          arrayOfChar[c1] = ((char)48);
          paramInt = i + 1;
          paramChar = c1 - '\001';
        }
        c2 = paramInt;
        if (k != 0)
        {
          arrayOfChar[paramChar] = ((char)45);
          c2 = paramInt + 1;
        }
        paramInt = '#' - c2;
        return String.valueOf(arrayOfChar, paramInt, 35 - paramInt);
      }
      int n = (int)(l % 10L);
      l /= 10L;
      c2 = c1 - '\001';
      arrayOfChar[c1] = ((char)(char)(n + 48));
      i++;
      if (i == m)
      {
        c1 = c2 - '\001';
        arrayOfChar[c2] = ((char)44);
        paramInt = i + 1;
        c2 = '\001';
      }
      else
      {
        if ((paramBoolean) && (l != 0L) && (i > m))
        {
          if (paramInt != 0)
          {
            if ((i - m) % 4 != 0) {
              break label344;
            }
            c1 = c2 - '\001';
            arrayOfChar[c2] = ((char)paramChar);
          }
          else
          {
            if ((i - m) % 4 != 3) {
              break label344;
            }
            c1 = c2 - '\001';
            arrayOfChar[c2] = ((char)paramChar);
          }
          i++;
          c2 = paramInt;
          paramInt = i;
          break label354;
        }
        label344:
        c1 = c2;
        c2 = paramInt;
        paramInt = i;
      }
      label354:
      i = paramInt;
    }
  }
  
  private static ValueFormatter generateDefaultValueFormatter()
  {
    return new DefaultValueFormatter(1);
  }
  
  public static int getDecimals(float paramFloat)
  {
    paramFloat = roundToNextSignificant(paramFloat);
    if (Float.isInfinite(paramFloat)) {
      return 0;
    }
    return (int)Math.ceil(-Math.log10(paramFloat)) + 2;
  }
  
  public static ValueFormatter getDefaultValueFormatter()
  {
    return mDefaultValueFormatter;
  }
  
  public static float getLineHeight(Paint paramPaint)
  {
    return getLineHeight(paramPaint, mFontMetrics);
  }
  
  public static float getLineHeight(Paint paramPaint, Paint.FontMetrics paramFontMetrics)
  {
    paramPaint.getFontMetrics(paramFontMetrics);
    return paramFontMetrics.descent - paramFontMetrics.ascent;
  }
  
  public static float getLineSpacing(Paint paramPaint)
  {
    return getLineSpacing(paramPaint, mFontMetrics);
  }
  
  public static float getLineSpacing(Paint paramPaint, Paint.FontMetrics paramFontMetrics)
  {
    paramPaint.getFontMetrics(paramFontMetrics);
    return paramFontMetrics.ascent - paramFontMetrics.top + paramFontMetrics.bottom;
  }
  
  public static int getMaximumFlingVelocity()
  {
    return mMaximumFlingVelocity;
  }
  
  public static int getMinimumFlingVelocity()
  {
    return mMinimumFlingVelocity;
  }
  
  public static float getNormalizedAngle(float paramFloat)
  {
    while (paramFloat < 0.0F) {
      paramFloat += 360.0F;
    }
    return paramFloat % 360.0F;
  }
  
  public static MPPointF getPosition(MPPointF paramMPPointF, float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = MPPointF.getInstance(0.0F, 0.0F);
    getPosition(paramMPPointF, paramFloat1, paramFloat2, localMPPointF);
    return localMPPointF;
  }
  
  public static void getPosition(MPPointF paramMPPointF1, float paramFloat1, float paramFloat2, MPPointF paramMPPointF2)
  {
    double d1 = paramMPPointF1.x;
    double d2 = paramFloat1;
    double d3 = paramFloat2;
    paramMPPointF2.x = ((float)(d1 + Math.cos(Math.toRadians(d3)) * d2));
    paramMPPointF2.y = ((float)(paramMPPointF1.y + d2 * Math.sin(Math.toRadians(d3))));
  }
  
  public static int getSDKInt()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static FSize getSizeOfRotatedRectangleByDegrees(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return getSizeOfRotatedRectangleByRadians(paramFloat1, paramFloat2, paramFloat3 * 0.017453292F);
  }
  
  public static FSize getSizeOfRotatedRectangleByDegrees(FSize paramFSize, float paramFloat)
  {
    return getSizeOfRotatedRectangleByRadians(paramFSize.width, paramFSize.height, paramFloat * 0.017453292F);
  }
  
  public static FSize getSizeOfRotatedRectangleByRadians(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d = paramFloat3;
    return FSize.getInstance(Math.abs((float)Math.cos(d) * paramFloat1) + Math.abs((float)Math.sin(d) * paramFloat2), Math.abs(paramFloat1 * (float)Math.sin(d)) + Math.abs(paramFloat2 * (float)Math.cos(d)));
  }
  
  public static FSize getSizeOfRotatedRectangleByRadians(FSize paramFSize, float paramFloat)
  {
    return getSizeOfRotatedRectangleByRadians(paramFSize.width, paramFSize.height, paramFloat);
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null)
    {
      mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
      mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
      Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
    }
    else
    {
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
      mMinimumFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
      mMaximumFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
      mMetrics = paramContext.getResources().getDisplayMetrics();
    }
  }
  
  @Deprecated
  public static void init(Resources paramResources)
  {
    mMetrics = paramResources.getDisplayMetrics();
    mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
    mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
  }
  
  public static double nextUp(double paramDouble)
  {
    if (paramDouble == Double.POSITIVE_INFINITY) {
      return paramDouble;
    }
    paramDouble += 0.0D;
    long l1 = Double.doubleToRawLongBits(paramDouble);
    long l2;
    if (paramDouble >= 0.0D) {
      l2 = 1L;
    } else {
      l2 = -1L;
    }
    return Double.longBitsToDouble(l1 + l2);
  }
  
  @SuppressLint({"NewApi"})
  public static void postInvalidateOnAnimation(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.postInvalidateOnAnimation();
    } else {
      paramView.postInvalidateDelayed(10L);
    }
  }
  
  public static float roundToNextSignificant(double paramDouble)
  {
    if ((!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble)) && (paramDouble != 0.0D))
    {
      double d;
      if (paramDouble < 0.0D) {
        d = -paramDouble;
      } else {
        d = paramDouble;
      }
      float f = (float)Math.pow(10.0D, 1 - (int)(float)Math.ceil((float)Math.log10(d)));
      return (float)Math.round(paramDouble * f) / f;
    }
    return 0.0F;
  }
  
  public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent paramMotionEvent, VelocityTracker paramVelocityTracker)
  {
    paramVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramVelocityTracker.getXVelocity(j);
    float f2 = paramVelocityTracker.getYVelocity(j);
    int k = paramMotionEvent.getPointerCount();
    for (j = 0; j < k; j++) {
      if (j != i)
      {
        int m = paramMotionEvent.getPointerId(j);
        if (paramVelocityTracker.getXVelocity(m) * f1 + paramVelocityTracker.getYVelocity(m) * f2 < 0.0F)
        {
          paramVelocityTracker.clear();
          break;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */