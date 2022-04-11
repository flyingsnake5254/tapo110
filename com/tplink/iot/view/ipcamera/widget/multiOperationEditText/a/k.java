package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;

public class k
{
  static final f.c a = new a();
  
  public static f a()
  {
    return a.createAnimator();
  }
  
  public static PorterDuff.Mode b(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          if (paramInt != 14)
          {
            if (paramInt != 15) {
              return paramMode;
            }
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  static final class a
    implements f.c
  {
    public f createAnimator()
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 12) {
        localObject = new h();
      } else {
        localObject = new g();
      }
      return new f((f.d)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */