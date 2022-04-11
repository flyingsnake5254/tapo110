package com.tplink.iot.view.iotsensor.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.tplink.iot.widget.ItemSettingLayout;
import kotlin.jvm.internal.j;

public final class a
{
  @BindingAdapter({"intervalInfo"})
  public static final void a(ItemSettingLayout paramItemSettingLayout, Integer paramInteger)
  {
    j.e(paramItemSettingLayout, "view");
    Context localContext = paramItemSettingLayout.getContext();
    if ((paramInteger != null) && (paramInteger.intValue() >= 0))
    {
      if (paramInteger.intValue() <= 1) {
        paramItemSettingLayout.setItemInfo(localContext.getString(2131954291, new Object[] { paramInteger }));
      } else {
        paramItemSettingLayout.setItemInfo(localContext.getString(2131954293, new Object[] { paramInteger }));
      }
    }
    else {
      paramItemSettingLayout.setItemInfo("");
    }
  }
  
  @BindingAdapter({"sensitivityHintColor"})
  public static final void b(TextView paramTextView, Integer paramInteger)
  {
    j.e(paramTextView, "view");
    int i = Integer.parseInt(paramTextView.getTag().toString());
    if ((paramInteger != null) && (i == paramInteger.intValue()))
    {
      paramInteger = paramTextView.getContext();
      j.d(paramInteger, "view.context");
      paramTextView.setTextColor(paramInteger.getResources().getColor(2131099799));
    }
    else
    {
      paramInteger = paramTextView.getContext();
      j.d(paramInteger, "view.context");
      paramTextView.setTextColor(paramInteger.getResources().getColor(2131099806));
    }
  }
  
  @BindingAdapter({"sensitivityInfo"})
  public static final void c(ItemSettingLayout paramItemSettingLayout, String paramString)
  {
    j.e(paramItemSettingLayout, "view");
    Context localContext = paramItemSettingLayout.getContext();
    if (paramString != null)
    {
      int i = paramString.hashCode();
      if (i != -1039745817)
      {
        if (i != 107348)
        {
          if ((i == 3202466) && (paramString.equals("high")))
          {
            paramString = localContext.getString(2131953102);
            break label104;
          }
        }
        else if (paramString.equals("low"))
        {
          paramString = localContext.getString(2131953103);
          break label104;
        }
      }
      else if (paramString.equals("normal"))
      {
        paramString = localContext.getString(2131953104);
        break label104;
      }
    }
    paramString = "";
    label104:
    j.d(paramString, "when (sensitivity) {\n   …\n        else -> \"\"\n    }");
    paramItemSettingLayout.setItemInfo(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */