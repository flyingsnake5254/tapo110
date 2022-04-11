package com.tplink.iot.devices.switches.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class SwitchDelayOffTimeAdapter
  extends SingleCheckMarkAdapter<Integer>
{
  private static final List<Integer> g = l.g(new Integer[] { Integer.valueOf(30), Integer.valueOf(20), Integer.valueOf(10), Integer.valueOf(5) });
  public static final a h = new a(null);
  
  public SwitchDelayOffTimeAdapter(Context paramContext)
  {
    super(paramContext, g, 0);
  }
  
  public void A(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, int paramInt1, int paramInt2)
  {
    j.e(paramSingleCheckMarkViewHolder, "holder");
    paramSingleCheckMarkViewHolder.c().setImageResource(2131690317);
    paramSingleCheckMarkViewHolder.d().setText(p().getString(2131954293, new Object[] { Integer.valueOf(paramInt1) }));
  }
  
  public final void B(int paramInt)
  {
    z(Math.max(g.indexOf(Integer.valueOf(paramInt)), 0));
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\adapter\SwitchDelayOffTimeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */