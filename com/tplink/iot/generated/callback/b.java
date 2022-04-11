package com.tplink.iot.generated.callback;

import android.view.View;
import android.view.View.OnLongClickListener;

public final class b
  implements View.OnLongClickListener
{
  final a c;
  final int d;
  
  public b(a parama, int paramInt)
  {
    this.c = parama;
    this.d = paramInt;
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.c.b(this.d, paramView);
  }
  
  public static abstract interface a
  {
    public abstract boolean b(int paramInt, View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\generated\callback\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */