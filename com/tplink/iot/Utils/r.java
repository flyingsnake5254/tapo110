package com.tplink.iot.Utils;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.j;

public final class r
{
  public static final boolean a(View paramView)
  {
    j.e(paramView, "$this$isSafeToRequestDirectly");
    boolean bool1 = paramView.isInLayout();
    boolean bool2 = true;
    if (bool1)
    {
      if (!paramView.isLayoutRequested()) {}
    }
    else
    {
      int i;
      label67:
      do
      {
        bool2 = false;
        break;
        for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
          if (paramView.isLayoutRequested())
          {
            i = 1;
            break label67;
          }
        }
        i = 0;
      } while (i != 0);
    }
    return bool2;
  }
  
  public static final void b(View paramView)
  {
    j.e(paramView, "$this$safeRequestLayout");
    if (a(paramView)) {
      paramView.requestLayout();
    } else {
      paramView.post(new a(paramView));
    }
  }
  
  static final class a
    implements Runnable
  {
    a(View paramView) {}
    
    public final void run()
    {
      this.c.requestLayout();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */