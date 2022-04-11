package com.tplink.iot.view.quicksetup.base;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class a
  implements View.OnClickListener
{
  private long c;
  
  public abstract void a(View paramView);
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.c >= 200L)
    {
      this.c = l;
      a(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */