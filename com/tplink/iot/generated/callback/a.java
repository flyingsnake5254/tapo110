package com.tplink.iot.generated.callback;

import android.view.View;
import android.view.View.OnClickListener;

public final class a
  implements View.OnClickListener
{
  final a c;
  final int d;
  
  public a(a parama, int paramInt)
  {
    this.c = parama;
    this.d = paramInt;
  }
  
  public void onClick(View paramView)
  {
    this.c.d(this.d, paramView);
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\generated\callback\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */