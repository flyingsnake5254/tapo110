package com.google.android.material.transition.platform;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator;

@RequiresApi(21)
class TransitionUtils
{
  private static final RectF transformAlphaRectF = new RectF();
  
  static float calculateArea(@NonNull RectF paramRectF)
  {
    return paramRectF.width() * paramRectF.height();
  }
  
  static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel paramShapeAppearanceModel, RectF paramRectF)
  {
    paramShapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator()
    {
      @NonNull
      public CornerSize apply(@NonNull CornerSize paramAnonymousCornerSize)
      {
        if (!(paramAnonymousCornerSize instanceof RelativeCornerSize)) {
          paramAnonymousCornerSize = new RelativeCornerSize(paramAnonymousCornerSize.getCornerSize(this.val$bounds) / this.val$bounds.height());
        }
        return paramAnonymousCornerSize;
      }
    });
  }
  
  static Shader createColorShader(@ColorInt int paramInt)
  {
    return new LinearGradient(0.0F, 0.0F, 0.0F, 0.0F, paramInt, paramInt, Shader.TileMode.CLAMP);
  }
  
  @NonNull
  static <T> T defaultIfNull(@Nullable T paramT1, @NonNull T paramT2)
  {
    if (paramT1 == null) {
      paramT1 = paramT2;
    }
    return paramT1;
  }
  
  static View findAncestorById(View paramView, @IdRes int paramInt)
  {
    String str = paramView.getResources().getResourceName(paramInt);
    while (paramView != null)
    {
      if (paramView.getId() == paramInt) {
        return paramView;
      }
      paramView = paramView.getParent();
      if (!(paramView instanceof View)) {
        break;
      }
      paramView = (View)paramView;
    }
    paramView = new StringBuilder();
    paramView.append(str);
    paramView.append(" is not a valid ancestor");
    throw new IllegalArgumentException(paramView.toString());
  }
  
  static View findDescendantOrAncestorById(View paramView, @IdRes int paramInt)
  {
    View localView = paramView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return findAncestorById(paramView, paramInt);
  }
  
  static RectF getLocationOnScreen(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    return new RectF(i, j, k + i, m + j);
  }
  
  static RectF getRelativeBounds(View paramView)
  {
    return new RectF(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  static Rect getRelativeBoundsRect(View paramView)
  {
    return new Rect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel paramShapeAppearanceModel, RectF paramRectF)
  {
    boolean bool;
    if ((paramShapeAppearanceModel.getTopLeftCornerSize().getCornerSize(paramRectF) == 0.0F) && (paramShapeAppearanceModel.getTopRightCornerSize().getCornerSize(paramRectF) == 0.0F) && (paramShapeAppearanceModel.getBottomRightCornerSize().getCornerSize(paramRectF) == 0.0F) && (paramShapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(paramRectF) == 0.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  static float lerp(float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  static float lerp(float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3, @FloatRange(from=0.0D, to=1.0D) float paramFloat4, @FloatRange(from=0.0D, to=1.0D) float paramFloat5)
  {
    if (paramFloat5 < paramFloat3) {
      return paramFloat1;
    }
    if (paramFloat5 > paramFloat4) {
      return paramFloat2;
    }
    return lerp(paramFloat1, paramFloat2, (paramFloat5 - paramFloat3) / (paramFloat4 - paramFloat3));
  }
  
  static int lerp(int paramInt1, int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3)
  {
    if (paramFloat3 < paramFloat1) {
      return paramInt1;
    }
    if (paramFloat3 > paramFloat2) {
      return paramInt2;
    }
    return (int)lerp(paramInt1, paramInt2, (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1));
  }
  
  static ShapeAppearanceModel lerp(ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF1, final RectF paramRectF2, @FloatRange(from=0.0D, to=1.0D) final float paramFloat1, @FloatRange(from=0.0D, to=1.0D) final float paramFloat2, @FloatRange(from=0.0D, to=1.0D) final float paramFloat3)
  {
    if (paramFloat3 < paramFloat1) {
      return paramShapeAppearanceModel1;
    }
    if (paramFloat3 > paramFloat2) {
      return paramShapeAppearanceModel2;
    }
    transformCornerSizes(paramShapeAppearanceModel1, paramShapeAppearanceModel2, paramRectF1, new CornerSizeBinaryOperator()
    {
      @NonNull
      public CornerSize apply(@NonNull CornerSize paramAnonymousCornerSize1, @NonNull CornerSize paramAnonymousCornerSize2)
      {
        return new AbsoluteCornerSize(TransitionUtils.lerp(paramAnonymousCornerSize1.getCornerSize(this.val$startBounds), paramAnonymousCornerSize2.getCornerSize(paramRectF2), paramFloat1, paramFloat2, paramFloat3));
      }
    });
  }
  
  static void maybeAddTransition(TransitionSet paramTransitionSet, @Nullable Transition paramTransition)
  {
    if (paramTransition != null) {
      paramTransitionSet.addTransition(paramTransition);
    }
  }
  
  static void maybeRemoveTransition(TransitionSet paramTransitionSet, @Nullable Transition paramTransition)
  {
    if (paramTransition != null) {
      paramTransitionSet.removeTransition(paramTransition);
    }
  }
  
  private static int saveLayerAlphaCompat(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    RectF localRectF = transformAlphaRectF;
    localRectF.set(paramRect);
    if (Build.VERSION.SDK_INT >= 21) {
      return paramCanvas.saveLayerAlpha(localRectF, paramInt);
    }
    return paramCanvas.saveLayerAlpha(localRectF.left, localRectF.top, localRectF.right, localRectF.bottom, paramInt, 31);
  }
  
  static void transform(Canvas paramCanvas, Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, CanvasOperation paramCanvasOperation)
  {
    if (paramInt <= 0) {
      return;
    }
    int i = paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramCanvas.scale(paramFloat3, paramFloat3);
    if (paramInt < 255) {
      saveLayerAlphaCompat(paramCanvas, paramRect, paramInt);
    }
    paramCanvasOperation.run(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF, CornerSizeBinaryOperator paramCornerSizeBinaryOperator)
  {
    if (isShapeAppearanceSignificant(paramShapeAppearanceModel1, paramRectF)) {
      paramRectF = paramShapeAppearanceModel1;
    } else {
      paramRectF = paramShapeAppearanceModel2;
    }
    return paramRectF.toBuilder().setTopLeftCornerSize(paramCornerSizeBinaryOperator.apply(paramShapeAppearanceModel1.getTopLeftCornerSize(), paramShapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(paramCornerSizeBinaryOperator.apply(paramShapeAppearanceModel1.getTopRightCornerSize(), paramShapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(paramCornerSizeBinaryOperator.apply(paramShapeAppearanceModel1.getBottomLeftCornerSize(), paramShapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(paramCornerSizeBinaryOperator.apply(paramShapeAppearanceModel1.getBottomRightCornerSize(), paramShapeAppearanceModel2.getBottomRightCornerSize())).build();
  }
  
  static abstract interface CanvasOperation
  {
    public abstract void run(Canvas paramCanvas);
  }
  
  static abstract interface CornerSizeBinaryOperator
  {
    @NonNull
    public abstract CornerSize apply(@NonNull CornerSize paramCornerSize1, @NonNull CornerSize paramCornerSize2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\TransitionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */