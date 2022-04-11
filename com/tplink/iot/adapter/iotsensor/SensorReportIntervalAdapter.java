package com.tplink.iot.adapter.iotsensor;

import android.content.Context;
import android.widget.TextView;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import kotlin.jvm.internal.j;

public final class SensorReportIntervalAdapter
  extends SingleCheckMarkAdapter<Integer>
{
  public void A(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, int paramInt1, int paramInt2)
  {
    j.e(paramSingleCheckMarkViewHolder, "holder");
    TextView localTextView = paramSingleCheckMarkViewHolder.d();
    paramSingleCheckMarkViewHolder = p();
    if (paramInt1 <= 1) {
      paramInt2 = 2131954291;
    } else {
      paramInt2 = 2131954293;
    }
    localTextView.setText(paramSingleCheckMarkViewHolder.getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iotsensor\SensorReportIntervalAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */