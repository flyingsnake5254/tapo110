package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsBase
{
  private static final String TAG = "ViewUtilsBase";
  private static final int VISIBILITY_MASK = 12;
  private static boolean sSetFrameFetched;
  private static Method sSetFrameMethod;
  private static Field sViewFlagsField;
  private static boolean sViewFlagsFieldFetched;
  private float[] mMatrixValues;
  
  @SuppressLint({"PrivateApi"})
  private void fetchSetFrame()
  {
    if (!sSetFrameFetched)
    {
      try
      {
        Object localObject = Integer.TYPE;
        localObject = View.class.getDeclaredMethod("setFrame", new Class[] { localObject, localObject, localObject, localObject });
        sSetFrameMethod = (Method)localObject;
        ((Method)localObject).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", localNoSuchMethodException);
      }
      sSetFrameFetched = true;
    }
  }
  
  public void clearNonTransitionAlpha(@NonNull View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.setTag(R.id.save_non_transition_alpha, null);
    }
  }
  
  public float getTransitionAlpha(@NonNull View paramView)
  {
    Float localFloat = (Float)paramView.getTag(R.id.save_non_transition_alpha);
    if (localFloat != null) {
      return paramView.getAlpha() / localFloat.floatValue();
    }
    return paramView.getAlpha();
  }
  
  public void saveNonTransitionAlpha(@NonNull View paramView)
  {
    int i = R.id.save_non_transition_alpha;
    if (paramView.getTag(i) == null) {
      paramView.setTag(i, Float.valueOf(paramView.getAlpha()));
    }
  }
  
  public void setAnimationMatrix(@NonNull View paramView, @Nullable Matrix paramMatrix)
  {
    if ((paramMatrix != null) && (!paramMatrix.isIdentity()))
    {
      float[] arrayOfFloat1 = this.mMatrixValues;
      float[] arrayOfFloat2 = arrayOfFloat1;
      if (arrayOfFloat1 == null)
      {
        arrayOfFloat2 = new float[9];
        this.mMatrixValues = arrayOfFloat2;
      }
      paramMatrix.getValues(arrayOfFloat2);
      float f1 = arrayOfFloat2[3];
      float f2 = (float)Math.sqrt(1.0F - f1 * f1);
      int i;
      if (arrayOfFloat2[0] < 0.0F) {
        i = -1;
      } else {
        i = 1;
      }
      float f3 = f2 * i;
      f1 = (float)Math.toDegrees(Math.atan2(f1, f3));
      f2 = arrayOfFloat2[0] / f3;
      f3 = arrayOfFloat2[4] / f3;
      float f4 = arrayOfFloat2[2];
      float f5 = arrayOfFloat2[5];
      paramView.setPivotX(0.0F);
      paramView.setPivotY(0.0F);
      paramView.setTranslationX(f4);
      paramView.setTranslationY(f5);
      paramView.setRotation(f1);
      paramView.setScaleX(f2);
      paramView.setScaleY(f3);
    }
    else
    {
      paramView.setPivotX(paramView.getWidth() / 2);
      paramView.setPivotY(paramView.getHeight() / 2);
      paramView.setTranslationX(0.0F);
      paramView.setTranslationY(0.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      paramView.setRotation(0.0F);
    }
  }
  
  public void setLeftTopRightBottom(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    fetchSetFrame();
    Method localMethod = sSetFrameMethod;
    if (localMethod != null) {}
    try
    {
      try
      {
        localMethod.invoke(paramView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      return;
    }
    catch (IllegalAccessException paramView)
    {
      for (;;) {}
    }
  }
  
  public void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    Float localFloat = (Float)paramView.getTag(R.id.save_non_transition_alpha);
    if (localFloat != null) {
      paramView.setAlpha(localFloat.floatValue() * paramFloat);
    } else {
      paramView.setAlpha(paramFloat);
    }
  }
  
  public void setTransitionVisibility(@NonNull View paramView, int paramInt)
  {
    if (!sViewFlagsFieldFetched)
    {
      try
      {
        Field localField1 = View.class.getDeclaredField("mViewFlags");
        sViewFlagsField = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
      }
      sViewFlagsFieldFetched = true;
    }
    Field localField2 = sViewFlagsField;
    if (localField2 != null) {}
    try
    {
      int i = localField2.getInt(paramView);
      sViewFlagsField.setInt(paramView, paramInt | i & 0xFFFFFFF3);
      return;
    }
    catch (IllegalAccessException paramView)
    {
      for (;;) {}
    }
  }
  
  public void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      transformMatrixToGlobal((View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity()) {
      paramMatrix.preConcat(paramView);
    }
  }
  
  public void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      transformMatrixToLocal((View)localObject, paramMatrix);
      paramMatrix.postTranslate(((View)localObject).getScrollX(), ((View)localObject).getScrollY());
    }
    paramMatrix.postTranslate(-paramView.getLeft(), -paramView.getTop());
    localObject = paramView.getMatrix();
    if (!((Matrix)localObject).isIdentity())
    {
      paramView = new Matrix();
      if (((Matrix)localObject).invert(paramView)) {
        paramMatrix.postConcat(paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewUtilsBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */