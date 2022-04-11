package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CanvasUtils
{
  private static Method sInorderBarrierMethod;
  private static boolean sOrderMethodsFetched;
  private static Method sReorderBarrierMethod;
  
  @SuppressLint({"SoonBlockedPrivateApi"})
  static void enableZ(@NonNull Canvas paramCanvas, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      if (i >= 29)
      {
        if (paramBoolean) {
          paramCanvas.enableZ();
        } else {
          paramCanvas.disableZ();
        }
      }
      else if ((i != 28) && (sOrderMethodsFetched)) {}
    }
    try
    {
      Method localMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
      sReorderBarrierMethod = localMethod;
      localMethod.setAccessible(true);
      localMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
      sInorderBarrierMethod = localMethod;
      localMethod.setAccessible(true);
      sOrderMethodsFetched = true;
      if (paramBoolean) {}
      try
      {
        try
        {
          localMethod = sReorderBarrierMethod;
          if (localMethod != null) {
            localMethod.invoke(paramCanvas, new Object[0]);
          }
        }
        catch (InvocationTargetException paramCanvas)
        {
          break label149;
        }
        if (paramBoolean) {
          break label161;
        }
        localMethod = sInorderBarrierMethod;
        if (localMethod == null) {
          break label161;
        }
        localMethod.invoke(paramCanvas, new Object[0]);
      }
      catch (IllegalAccessException paramCanvas)
      {
        label149:
        label161:
        for (;;) {}
      }
      throw new RuntimeException(paramCanvas.getCause());
      return;
      throw new IllegalStateException("This method doesn't work on Pie!");
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\CanvasUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */