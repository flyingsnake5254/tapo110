package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler
{
  protected Matrix mCenterViewPortMatrixBuffer = new Matrix();
  protected float mChartHeight = 0.0F;
  protected float mChartWidth = 0.0F;
  protected RectF mContentRect = new RectF();
  protected final Matrix mMatrixTouch = new Matrix();
  private float mMaxScaleX = Float.MAX_VALUE;
  private float mMaxScaleY = Float.MAX_VALUE;
  private float mMinScaleX = 1.0F;
  private float mMinScaleY = 1.0F;
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private float mTransOffsetX = 0.0F;
  private float mTransOffsetY = 0.0F;
  private float mTransX = 0.0F;
  private float mTransY = 0.0F;
  protected final float[] matrixBuffer = new float[9];
  protected float[] valsBufferForFitScreen = new float[9];
  
  public boolean canZoomInMoreX()
  {
    boolean bool;
    if (this.mScaleX < this.mMaxScaleX) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean canZoomInMoreY()
  {
    boolean bool;
    if (this.mScaleY < this.mMaxScaleY) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean canZoomOutMoreX()
  {
    boolean bool;
    if (this.mScaleX > this.mMinScaleX) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean canZoomOutMoreY()
  {
    boolean bool;
    if (this.mScaleY > this.mMinScaleY) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void centerViewPort(float[] paramArrayOfFloat, View paramView)
  {
    Matrix localMatrix = this.mCenterViewPortMatrixBuffer;
    localMatrix.reset();
    localMatrix.set(this.mMatrixTouch);
    float f1 = paramArrayOfFloat[0];
    float f2 = offsetLeft();
    float f3 = paramArrayOfFloat[1];
    float f4 = offsetTop();
    localMatrix.postTranslate(-(f1 - f2), -(f3 - f4));
    refresh(localMatrix, paramView, true);
  }
  
  public float contentBottom()
  {
    return this.mContentRect.bottom;
  }
  
  public float contentHeight()
  {
    return this.mContentRect.height();
  }
  
  public float contentLeft()
  {
    return this.mContentRect.left;
  }
  
  public float contentRight()
  {
    return this.mContentRect.right;
  }
  
  public float contentTop()
  {
    return this.mContentRect.top;
  }
  
  public float contentWidth()
  {
    return this.mContentRect.width();
  }
  
  public Matrix fitScreen()
  {
    Matrix localMatrix = new Matrix();
    fitScreen(localMatrix);
    return localMatrix;
  }
  
  public void fitScreen(Matrix paramMatrix)
  {
    this.mMinScaleX = 1.0F;
    this.mMinScaleY = 1.0F;
    paramMatrix.set(this.mMatrixTouch);
    float[] arrayOfFloat = this.valsBufferForFitScreen;
    for (int i = 0; i < 9; i++) {
      arrayOfFloat[i] = 0.0F;
    }
    paramMatrix.getValues(arrayOfFloat);
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[4] = 1.0F;
    paramMatrix.setValues(arrayOfFloat);
  }
  
  public float getChartHeight()
  {
    return this.mChartHeight;
  }
  
  public float getChartWidth()
  {
    return this.mChartWidth;
  }
  
  public MPPointF getContentCenter()
  {
    return MPPointF.getInstance(this.mContentRect.centerX(), this.mContentRect.centerY());
  }
  
  public RectF getContentRect()
  {
    return this.mContentRect;
  }
  
  public Matrix getMatrixTouch()
  {
    return this.mMatrixTouch;
  }
  
  public float getMaxScaleX()
  {
    return this.mMaxScaleX;
  }
  
  public float getMaxScaleY()
  {
    return this.mMaxScaleY;
  }
  
  public float getMinScaleX()
  {
    return this.mMinScaleX;
  }
  
  public float getMinScaleY()
  {
    return this.mMinScaleY;
  }
  
  public float getScaleX()
  {
    return this.mScaleX;
  }
  
  public float getScaleY()
  {
    return this.mScaleY;
  }
  
  public float getSmallestContentExtension()
  {
    return Math.min(this.mContentRect.width(), this.mContentRect.height());
  }
  
  public float getTransX()
  {
    return this.mTransX;
  }
  
  public float getTransY()
  {
    return this.mTransY;
  }
  
  public boolean hasChartDimens()
  {
    return (this.mChartHeight > 0.0F) && (this.mChartWidth > 0.0F);
  }
  
  public boolean hasNoDragOffset()
  {
    boolean bool;
    if ((this.mTransOffsetX <= 0.0F) && (this.mTransOffsetY <= 0.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFullyZoomedOut()
  {
    boolean bool;
    if ((isFullyZoomedOutX()) && (isFullyZoomedOutY())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFullyZoomedOutX()
  {
    float f1 = this.mScaleX;
    float f2 = this.mMinScaleX;
    boolean bool;
    if ((f1 <= f2) && (f2 <= 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFullyZoomedOutY()
  {
    float f1 = this.mScaleY;
    float f2 = this.mMinScaleY;
    boolean bool;
    if ((f1 <= f2) && (f2 <= 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInBounds(float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if ((isInBoundsX(paramFloat1)) && (isInBoundsY(paramFloat2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInBoundsBottom(float paramFloat)
  {
    paramFloat = (int)(paramFloat * 100.0F) / 100.0F;
    boolean bool;
    if (this.mContentRect.bottom >= paramFloat) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInBoundsLeft(float paramFloat)
  {
    boolean bool;
    if (this.mContentRect.left <= paramFloat + 1.0F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInBoundsRight(float paramFloat)
  {
    paramFloat = (int)(paramFloat * 100.0F) / 100.0F;
    boolean bool;
    if (this.mContentRect.right >= paramFloat - 1.0F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInBoundsTop(float paramFloat)
  {
    boolean bool;
    if (this.mContentRect.top <= paramFloat) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInBoundsX(float paramFloat)
  {
    boolean bool;
    if ((isInBoundsLeft(paramFloat)) && (isInBoundsRight(paramFloat))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInBoundsY(float paramFloat)
  {
    boolean bool;
    if ((isInBoundsTop(paramFloat)) && (isInBoundsBottom(paramFloat))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void limitTransAndScale(Matrix paramMatrix, RectF paramRectF)
  {
    paramMatrix.getValues(this.matrixBuffer);
    float[] arrayOfFloat = this.matrixBuffer;
    float f1 = arrayOfFloat[2];
    float f2 = arrayOfFloat[0];
    float f3 = arrayOfFloat[5];
    float f4 = arrayOfFloat[4];
    this.mScaleX = Math.min(Math.max(this.mMinScaleX, f2), this.mMaxScaleX);
    this.mScaleY = Math.min(Math.max(this.mMinScaleY, f4), this.mMaxScaleY);
    f2 = 0.0F;
    if (paramRectF != null)
    {
      f2 = paramRectF.width();
      f4 = paramRectF.height();
    }
    else
    {
      f4 = 0.0F;
    }
    this.mTransX = Math.min(Math.max(f1, -f2 * (this.mScaleX - 1.0F) - this.mTransOffsetX), this.mTransOffsetX);
    f2 = Math.max(Math.min(f3, f4 * (this.mScaleY - 1.0F) + this.mTransOffsetY), -this.mTransOffsetY);
    this.mTransY = f2;
    paramRectF = this.matrixBuffer;
    paramRectF[2] = this.mTransX;
    paramRectF[0] = this.mScaleX;
    paramRectF[5] = f2;
    paramRectF[4] = this.mScaleY;
    paramMatrix.setValues(paramRectF);
  }
  
  public float offsetBottom()
  {
    return this.mChartHeight - this.mContentRect.bottom;
  }
  
  public float offsetLeft()
  {
    return this.mContentRect.left;
  }
  
  public float offsetRight()
  {
    return this.mChartWidth - this.mContentRect.right;
  }
  
  public float offsetTop()
  {
    return this.mContentRect.top;
  }
  
  public Matrix refresh(Matrix paramMatrix, View paramView, boolean paramBoolean)
  {
    this.mMatrixTouch.set(paramMatrix);
    limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    if (paramBoolean) {
      paramView.invalidate();
    }
    paramMatrix.set(this.mMatrixTouch);
    return paramMatrix;
  }
  
  public void resetZoom(Matrix paramMatrix)
  {
    paramMatrix.reset();
    paramMatrix.set(this.mMatrixTouch);
    paramMatrix.postScale(1.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void restrainViewPort(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mContentRect.set(paramFloat1, paramFloat2, this.mChartWidth - paramFloat3, this.mChartHeight - paramFloat4);
  }
  
  public void setChartDimens(float paramFloat1, float paramFloat2)
  {
    float f1 = offsetLeft();
    float f2 = offsetTop();
    float f3 = offsetRight();
    float f4 = offsetBottom();
    this.mChartHeight = paramFloat2;
    this.mChartWidth = paramFloat1;
    restrainViewPort(f1, f2, f3, f4);
  }
  
  public void setDragOffsetX(float paramFloat)
  {
    this.mTransOffsetX = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setDragOffsetY(float paramFloat)
  {
    this.mTransOffsetY = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setMaximumScaleX(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = Float.MAX_VALUE;
    }
    this.mMaxScaleX = f;
    limitTransAndScale(this.mMatrixTouch, this.mContentRect);
  }
  
  public void setMaximumScaleY(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = Float.MAX_VALUE;
    }
    this.mMaxScaleY = f;
    limitTransAndScale(this.mMatrixTouch, this.mContentRect);
  }
  
  public void setMinMaxScaleX(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 < 1.0F) {
      f = 1.0F;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 == 0.0F) {
      paramFloat1 = Float.MAX_VALUE;
    }
    this.mMinScaleX = f;
    this.mMaxScaleX = paramFloat1;
    limitTransAndScale(this.mMatrixTouch, this.mContentRect);
  }
  
  public void setMinMaxScaleY(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 < 1.0F) {
      f = 1.0F;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 == 0.0F) {
      paramFloat1 = Float.MAX_VALUE;
    }
    this.mMinScaleY = f;
    this.mMaxScaleY = paramFloat1;
    limitTransAndScale(this.mMatrixTouch, this.mContentRect);
  }
  
  public void setMinimumScaleX(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 1.0F) {
      f = 1.0F;
    }
    this.mMinScaleX = f;
    limitTransAndScale(this.mMatrixTouch, this.mContentRect);
  }
  
  public void setMinimumScaleY(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 1.0F) {
      f = 1.0F;
    }
    this.mMinScaleY = f;
    limitTransAndScale(this.mMatrixTouch, this.mContentRect);
  }
  
  public Matrix setZoom(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    setZoom(paramFloat1, paramFloat2, localMatrix);
    return localMatrix;
  }
  
  public Matrix setZoom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(this.mMatrixTouch);
    localMatrix.setScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return localMatrix;
  }
  
  public void setZoom(float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    paramMatrix.reset();
    paramMatrix.set(this.mMatrixTouch);
    paramMatrix.setScale(paramFloat1, paramFloat2);
  }
  
  public Matrix translate(float[] paramArrayOfFloat)
  {
    Matrix localMatrix = new Matrix();
    translate(paramArrayOfFloat, localMatrix);
    return localMatrix;
  }
  
  public void translate(float[] paramArrayOfFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    paramMatrix.set(this.mMatrixTouch);
    float f1 = paramArrayOfFloat[0];
    float f2 = offsetLeft();
    float f3 = paramArrayOfFloat[1];
    float f4 = offsetTop();
    paramMatrix.postTranslate(-(f1 - f2), -(f3 - f4));
  }
  
  public Matrix zoom(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    zoom(paramFloat1, paramFloat2, localMatrix);
    return localMatrix;
  }
  
  public Matrix zoom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix localMatrix = new Matrix();
    zoom(paramFloat1, paramFloat2, paramFloat3, paramFloat4, localMatrix);
    return localMatrix;
  }
  
  public void zoom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Matrix paramMatrix)
  {
    paramMatrix.reset();
    paramMatrix.set(this.mMatrixTouch);
    paramMatrix.postScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void zoom(float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    paramMatrix.reset();
    paramMatrix.set(this.mMatrixTouch);
    paramMatrix.postScale(paramFloat1, paramFloat2);
  }
  
  public Matrix zoomIn(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    zoomIn(paramFloat1, paramFloat2, localMatrix);
    return localMatrix;
  }
  
  public void zoomIn(float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    paramMatrix.reset();
    paramMatrix.set(this.mMatrixTouch);
    paramMatrix.postScale(1.4F, 1.4F, paramFloat1, paramFloat2);
  }
  
  public Matrix zoomOut(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    zoomOut(paramFloat1, paramFloat2, localMatrix);
    return localMatrix;
  }
  
  public void zoomOut(float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    paramMatrix.reset();
    paramMatrix.set(this.mMatrixTouch);
    paramMatrix.postScale(0.7F, 0.7F, paramFloat1, paramFloat2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\ViewPortHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */