package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.util.Map;

public class ChangeImageTransform
  extends Transition
{
  private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = new Property(Matrix.class, "animatedTransform")
  {
    public Matrix get(ImageView paramAnonymousImageView)
    {
      return null;
    }
    
    public void set(ImageView paramAnonymousImageView, Matrix paramAnonymousMatrix)
    {
      ImageViewUtils.animateTransform(paramAnonymousImageView, paramAnonymousMatrix);
    }
  };
  private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR;
  private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
  private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
  private static final String[] sTransitionProperties = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  
  static
  {
    NULL_MATRIX_EVALUATOR = new TypeEvaluator()
    {
      public Matrix evaluate(float paramAnonymousFloat, Matrix paramAnonymousMatrix1, Matrix paramAnonymousMatrix2)
      {
        return null;
      }
    };
  }
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if (((localView instanceof ImageView)) && (localView.getVisibility() == 0))
    {
      ImageView localImageView = (ImageView)localView;
      if (localImageView.getDrawable() == null) {
        return;
      }
      paramTransitionValues = paramTransitionValues.values;
      paramTransitionValues.put("android:changeImageTransform:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramTransitionValues.put("android:changeImageTransform:matrix", copyImageMatrix(localImageView));
    }
  }
  
  private static Matrix centerCropMatrix(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    int i = localDrawable.getIntrinsicWidth();
    float f1 = paramImageView.getWidth();
    float f2 = i;
    float f3 = f1 / f2;
    i = localDrawable.getIntrinsicHeight();
    float f4 = paramImageView.getHeight();
    float f5 = i;
    f3 = Math.max(f3, f4 / f5);
    int j = Math.round((f1 - f2 * f3) / 2.0F);
    i = Math.round((f4 - f5 * f3) / 2.0F);
    paramImageView = new Matrix();
    paramImageView.postScale(f3, f3);
    paramImageView.postTranslate(j, i);
    return paramImageView;
  }
  
  @NonNull
  private static Matrix copyImageMatrix(@NonNull ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable.getIntrinsicWidth() > 0) && (localDrawable.getIntrinsicHeight() > 0))
    {
      int i = 3.$SwitchMap$android$widget$ImageView$ScaleType[paramImageView.getScaleType().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return centerCropMatrix(paramImageView);
        }
      }
      else {
        return fitXYMatrix(paramImageView);
      }
    }
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  private ObjectAnimator createMatrixAnimator(ImageView paramImageView, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    return ObjectAnimator.ofObject(paramImageView, ANIMATED_TRANSFORM_PROPERTY, new TransitionUtils.MatrixEvaluator(), new Matrix[] { paramMatrix1, paramMatrix2 });
  }
  
  @NonNull
  private ObjectAnimator createNullAnimator(@NonNull ImageView paramImageView)
  {
    Property localProperty = ANIMATED_TRANSFORM_PROPERTY;
    TypeEvaluator localTypeEvaluator = NULL_MATRIX_EVALUATOR;
    Matrix localMatrix = MatrixUtils.IDENTITY_MATRIX;
    return ObjectAnimator.ofObject(paramImageView, localProperty, localTypeEvaluator, new Matrix[] { localMatrix, localMatrix });
  }
  
  private static Matrix fitXYMatrix(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramImageView.getWidth() / localDrawable.getIntrinsicWidth(), paramImageView.getHeight() / localDrawable.getIntrinsicHeight());
    return localMatrix;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    Matrix localMatrix = null;
    paramViewGroup = localMatrix;
    if (paramTransitionValues1 != null) {
      if (paramTransitionValues2 == null)
      {
        paramViewGroup = localMatrix;
      }
      else
      {
        Rect localRect1 = (Rect)paramTransitionValues1.values.get("android:changeImageTransform:bounds");
        Rect localRect2 = (Rect)paramTransitionValues2.values.get("android:changeImageTransform:bounds");
        paramViewGroup = localMatrix;
        if (localRect1 != null) {
          if (localRect2 == null)
          {
            paramViewGroup = localMatrix;
          }
          else
          {
            paramTransitionValues1 = (Matrix)paramTransitionValues1.values.get("android:changeImageTransform:matrix");
            localMatrix = (Matrix)paramTransitionValues2.values.get("android:changeImageTransform:matrix");
            if (((paramTransitionValues1 == null) && (localMatrix == null)) || ((paramTransitionValues1 != null) && (paramTransitionValues1.equals(localMatrix)))) {
              i = 1;
            } else {
              i = 0;
            }
            if ((localRect1.equals(localRect2)) && (i != 0)) {
              return null;
            }
            paramTransitionValues2 = (ImageView)paramTransitionValues2.view;
            paramViewGroup = paramTransitionValues2.getDrawable();
            int j = paramViewGroup.getIntrinsicWidth();
            int i = paramViewGroup.getIntrinsicHeight();
            if ((j > 0) && (i > 0))
            {
              paramViewGroup = paramTransitionValues1;
              if (paramTransitionValues1 == null) {
                paramViewGroup = MatrixUtils.IDENTITY_MATRIX;
              }
              paramTransitionValues1 = localMatrix;
              if (localMatrix == null) {
                paramTransitionValues1 = MatrixUtils.IDENTITY_MATRIX;
              }
              ANIMATED_TRANSFORM_PROPERTY.set(paramTransitionValues2, paramViewGroup);
              paramViewGroup = createMatrixAnimator(paramTransitionValues2, paramViewGroup, paramTransitionValues1);
            }
            else
            {
              paramViewGroup = createNullAnimator(paramTransitionValues2);
            }
          }
        }
      }
    }
    return paramViewGroup;
  }
  
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ChangeImageTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */