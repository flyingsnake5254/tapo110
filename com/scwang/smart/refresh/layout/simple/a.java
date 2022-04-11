package com.scwang.smart.refresh.layout.simple;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smart.refresh.layout.c.i;
import com.scwang.smart.refresh.layout.d.b;

public class a
  implements i
{
  public PointF a;
  public i b;
  public boolean c = true;
  
  public boolean a(View paramView)
  {
    i locali = this.b;
    if (locali != null) {
      return locali.a(paramView);
    }
    return b.b(paramView, this.a);
  }
  
  public boolean b(View paramView)
  {
    i locali = this.b;
    if (locali != null) {
      return locali.b(paramView);
    }
    return b.a(paramView, this.a, this.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\simple\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */