package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class TransitionUtils
{
  private static final boolean HAS_IS_ATTACHED_TO_WINDOW;
  private static final boolean HAS_OVERLAY;
  private static final boolean HAS_PICTURE_BITMAP;
  private static final int MAX_IMAGE_SIZE = 1048576;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = true;
    boolean bool2;
    if (i >= 19) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    HAS_IS_ATTACHED_TO_WINDOW = bool2;
    if (i >= 18) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    HAS_OVERLAY = bool2;
    if (i >= 28) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    HAS_PICTURE_BITMAP = bool2;
  }
  
  static View copyViewImage(ViewGroup paramViewGroup, View paramView1, View paramView2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    ViewUtils.transformMatrixToGlobal(paramView1, localMatrix);
    ViewUtils.transformMatrixToLocal(paramViewGroup, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    localMatrix.mapRect(localRectF);
    int i = Math.round(localRectF.left);
    int j = Math.round(localRectF.top);
    int k = Math.round(localRectF.right);
    int m = Math.round(localRectF.bottom);
    paramView2 = new ImageView(paramView1.getContext());
    paramView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup = createViewBitmap(paramView1, localMatrix, localRectF, paramViewGroup);
    if (paramViewGroup != null) {
      paramView2.setImageBitmap(paramViewGroup);
    }
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
    paramView2.layout(i, j, k, m);
    return paramView2;
  }
  
  private static Bitmap createViewBitmap(View paramView, Matrix paramMatrix, RectF paramRectF, ViewGroup paramViewGroup)
  {
    boolean bool1;
    if (HAS_IS_ATTACHED_TO_WINDOW)
    {
      bool1 = paramView.isAttachedToWindow() ^ true;
      if (paramViewGroup != null)
      {
        bool2 = paramViewGroup.isAttachedToWindow();
        break label36;
      }
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = false;
    label36:
    boolean bool3 = HAS_OVERLAY;
    Object localObject1 = null;
    ViewGroup localViewGroup;
    int i;
    if ((bool3) && (bool1))
    {
      if (!bool2) {
        return null;
      }
      localViewGroup = (ViewGroup)paramView.getParent();
      i = localViewGroup.indexOfChild(paramView);
      paramViewGroup.getOverlay().add(paramView);
    }
    else
    {
      localViewGroup = null;
      i = 0;
    }
    int j = Math.round(paramRectF.width());
    int k = Math.round(paramRectF.height());
    Object localObject2 = localObject1;
    if (j > 0)
    {
      localObject2 = localObject1;
      if (k > 0)
      {
        float f = Math.min(1.0F, 1048576.0F / (j * k));
        j = Math.round(j * f);
        k = Math.round(k * f);
        paramMatrix.postTranslate(-paramRectF.left, -paramRectF.top);
        paramMatrix.postScale(f, f);
        if (HAS_PICTURE_BITMAP)
        {
          localObject2 = new Picture();
          paramRectF = ((Picture)localObject2).beginRecording(j, k);
          paramRectF.concat(paramMatrix);
          paramView.draw(paramRectF);
          ((Picture)localObject2).endRecording();
          localObject2 = Bitmap.createBitmap((Picture)localObject2);
        }
        else
        {
          localObject2 = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
          paramRectF = new Canvas((Bitmap)localObject2);
          paramRectF.concat(paramMatrix);
          paramView.draw(paramRectF);
        }
      }
    }
    if ((bool3) && (bool1))
    {
      paramViewGroup.getOverlay().remove(paramView);
      localViewGroup.addView(paramView, i);
    }
    return (Bitmap)localObject2;
  }
  
  static Animator mergeAnimators(Animator paramAnimator1, Animator paramAnimator2)
  {
    if (paramAnimator1 == null) {
      return paramAnimator2;
    }
    if (paramAnimator2 == null) {
      return paramAnimator1;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }
  
  static class MatrixEvaluator
    implements TypeEvaluator<Matrix>
  {
    final float[] mTempEndValues = new float[9];
    final Matrix mTempMatrix = new Matrix();
    final float[] mTempStartValues = new float[9];
    
    public Matrix evaluate(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
    {
      paramMatrix1.getValues(this.mTempStartValues);
      paramMatrix2.getValues(this.mTempEndValues);
      for (int i = 0; i < 9; i++)
      {
        paramMatrix1 = this.mTempEndValues;
        float f1 = paramMatrix1[i];
        paramMatrix2 = this.mTempStartValues;
        float f2 = paramMatrix2[i];
        paramMatrix2[i] += (f1 - f2) * paramFloat;
      }
      this.mTempMatrix.setValues(this.mTempEndValues);
      return this.mTempMatrix;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\TransitionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */