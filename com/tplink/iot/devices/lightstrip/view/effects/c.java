package com.tplink.iot.devices.lightstrip.view.effects;

import com.tplink.iot.devices.lightstrip.widget.IntRangePickerDialog.b;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.j;

public final class c
  implements IntRangePickerDialog.b, g
{
  public c(p paramp)
  {
    this.a = paramp;
  }
  
  public kotlin.c b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof IntRangePickerDialog.b)) && ((paramObject instanceof g)) && (j.a(this.a, ((g)paramObject).b()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */