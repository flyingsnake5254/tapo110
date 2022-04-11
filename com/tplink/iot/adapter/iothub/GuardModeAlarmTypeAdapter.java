package com.tplink.iot.adapter.iothub;

import android.app.Application;
import android.content.Context;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class GuardModeAlarmTypeAdapter
  extends SingleCheckMarkAdapter<String>
{
  public static final a g = new a(null);
  
  public GuardModeAlarmTypeAdapter(List<String> paramList, Context paramContext)
  {
    super(paramContext, paramList, 0, 4, null);
  }
  
  public void A(SingleCheckMarkViewHolder paramSingleCheckMarkViewHolder, String paramString, int paramInt)
  {
    j.e(paramSingleCheckMarkViewHolder, "holder");
    j.e(paramString, "data");
    paramSingleCheckMarkViewHolder.d().setText(g.a(paramString));
  }
  
  public final void B(String paramString)
  {
    if (paramString == null) {
      z(0);
    } else {
      z(q().indexOf(paramString));
    }
  }
  
  public static final class a
  {
    public final String a(String paramString)
    {
      j.e(paramString, "rawName");
      Object localObject = new a(paramString);
      if (m.A(paramString, "Doorbell Ring", false, 2, null))
      {
        localObject = ((a)localObject).a("Doorbell Ring", 2131951790);
      }
      else if (m.A(paramString, "Alarm", false, 2, null))
      {
        localObject = ((a)localObject).a("Alarm", 2131951788);
      }
      else if (m.A(paramString, "Connection", false, 2, null))
      {
        localObject = ((a)localObject).a("Connection", 2131951789);
      }
      else if (j.a(paramString, "Phone Ring"))
      {
        localObject = AppContext.c.getString(2131951796);
        j.d(localObject, "AppContext.instance.getS….string.alarm_phone_ring)");
      }
      else
      {
        localObject = paramString;
        if (j.a(paramString, "Dripping Tap"))
        {
          localObject = AppContext.c.getString(2131951791);
          j.d(localObject, "AppContext.instance.getS…tring.alarm_dripping_tap)");
        }
      }
      return (String)localObject;
    }
    
    static final class a
      extends Lambda
      implements p<String, Integer, String>
    {
      a(String paramString)
      {
        super();
      }
      
      public final String a(String paramString, @StringRes int paramInt)
      {
        j.e(paramString, "prefix");
        String str = this.c;
        int i = paramString.length();
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        paramString = str.substring(i);
        j.d(paramString, "(this as java.lang.String).substring(startIndex)");
        Objects.requireNonNull(paramString, "null cannot be cast to non-null type kotlin.CharSequence");
        paramString = m.t0(paramString).toString();
        paramString = AppContext.c.getString(paramInt, new Object[] { paramString });
        j.d(paramString, "AppContext.instance.getString(resId, numStr)");
        return paramString;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iothub\GuardModeAlarmTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */