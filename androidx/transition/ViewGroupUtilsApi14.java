package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtilsApi14
{
  private static final int LAYOUT_TRANSITION_CHANGING = 4;
  private static final String TAG = "ViewGroupUtilsApi14";
  private static Method sCancelMethod;
  private static boolean sCancelMethodFetched;
  private static LayoutTransition sEmptyLayoutTransition;
  private static Field sLayoutSuppressedField;
  private static boolean sLayoutSuppressedFieldFetched;
  
  private static void cancelLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    if (!sCancelMethodFetched)
    {
      try
      {
        Method localMethod1 = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
        sCancelMethod = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
      }
      sCancelMethodFetched = true;
    }
    Method localMethod2 = sCancelMethod;
    if (localMethod2 != null) {
      try
      {
        localMethod2.invoke(paramLayoutTransition, new Object[0]);
      }
      catch (InvocationTargetException paramLayoutTransition)
      {
        Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
      }
      catch (IllegalAccessException paramLayoutTransition)
      {
        Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
      }
    }
  }
  
  static void suppressLayout(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Object localObject = sEmptyLayoutTransition;
    boolean bool1 = false;
    bool2 = false;
    if (localObject == null)
    {
      localObject = new LayoutTransition()
      {
        public boolean isChangingLayout()
        {
          return true;
        }
      };
      sEmptyLayoutTransition = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      sEmptyLayoutTransition.setAnimator(0, null);
      sEmptyLayoutTransition.setAnimator(1, null);
      sEmptyLayoutTransition.setAnimator(3, null);
      sEmptyLayoutTransition.setAnimator(4, null);
    }
    Field localField;
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          cancelLayoutTransition((LayoutTransition)localObject);
        }
        if (localObject != sEmptyLayoutTransition) {
          paramViewGroup.setTag(R.id.transition_layout_save, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(sEmptyLayoutTransition);
    }
    else
    {
      paramViewGroup.setLayoutTransition(null);
      if (!sLayoutSuppressedFieldFetched)
      {
        try
        {
          localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
          sLayoutSuppressedField = (Field)localObject;
          ((Field)localObject).setAccessible(true);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
        }
        sLayoutSuppressedFieldFetched = true;
      }
      localField = sLayoutSuppressedField;
      paramBoolean = bool1;
      if (localField == null) {}
    }
    try
    {
      paramBoolean = localField.getBoolean(paramViewGroup);
      if (paramBoolean) {
        try
        {
          sLayoutSuppressedField.setBoolean(paramViewGroup, false);
        }
        catch (IllegalAccessException localIllegalAccessException1) {}
      }
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      for (;;)
      {
        int i;
        LayoutTransition localLayoutTransition;
        paramBoolean = bool2;
      }
    }
    Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
    if (paramBoolean) {
      paramViewGroup.requestLayout();
    }
    i = R.id.transition_layout_save;
    localLayoutTransition = (LayoutTransition)paramViewGroup.getTag(i);
    if (localLayoutTransition != null)
    {
      paramViewGroup.setTag(i, null);
      paramViewGroup.setLayoutTransition(localLayoutTransition);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewGroupUtilsApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */