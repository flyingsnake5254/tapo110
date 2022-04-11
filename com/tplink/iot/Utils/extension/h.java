package com.tplink.iot.Utils.extension;

import android.view.View;
import android.widget.TextView;
import com.tplink.iot.widget.OrderTextView;
import com.tplink.iot.widget.PointTextView;

public final class h
{
  public static final void a(View paramView, String paramString)
  {
    String str;
    if (paramString != null) {
      str = paramString;
    } else {
      str = "";
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setText(paramString);
    } else if ((paramView instanceof PointTextView)) {
      ((PointTextView)paramView).setContent(str);
    } else if ((paramView instanceof OrderTextView)) {
      ((OrderTextView)paramView).setContent(str);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */