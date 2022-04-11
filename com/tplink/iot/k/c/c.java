package com.tplink.iot.k.c;

import android.view.View;
import android.view.View.OnClickListener;

public class c
  implements View.OnClickListener
{
  private long c = 0L;
  private d d = null;
  
  public c(d paramd)
  {
    this.d = paramd;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.c > 1000L)
    {
      this.c = l;
      d locald = this.d;
      if (locald != null) {
        locald.onClick(paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\k\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */