package com.tplink.iot.adapter.iotsensor;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewKt;
import com.tplink.iot.Utils.extension.b;
import com.tplink.iot.Utils.extension.g;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.collections.l;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class SensorTriggerLogAdapter
  extends GeneralAdapter<a>
{
  private String d;
  private final f e;
  private final f f;
  private final f g;
  
  public SensorTriggerLogAdapter(Context paramContext, List<a> paramList)
  {
    super(paramContext, l.U(paramList));
    paramList = TimeZone.getDefault();
    j.d(paramList, "TimeZone.getDefault()");
    paramList = paramList.getID();
    j.d(paramList, "TimeZone.getDefault().id");
    this.d = paramList;
    this.e = h.b(new b(paramContext));
    this.f = h.b(new d(paramContext));
    this.g = h.b(new c(paramContext));
  }
  
  private final String C(TriggerLog paramTriggerLog)
  {
    if (paramTriggerLog != null)
    {
      Object localObject1 = p0.d(this.d);
      Object localObject2 = new Date(b.e(paramTriggerLog.getTimestamp()));
      Context localContext = r();
      j.d(localObject1, "deviceTimeZone");
      localObject1 = g.b((Date)localObject2, localContext, (TimeZone)localObject1, null, 4, null);
      localObject2 = paramTriggerLog.getEvent();
      if (localObject2 != null) {
        switch (((String)localObject2).hashCode())
        {
        default: 
          break;
        case 94756344: 
          if (((String)localObject2).equals("close"))
          {
            paramTriggerLog = r().getString(2131953780, new Object[] { localObject1 });
            j.d(paramTriggerLog, "mContext.getString(R.str…_log_content_close, time)");
          }
          break;
        case 3417674: 
          if (((String)localObject2).equals("open"))
          {
            paramTriggerLog = r().getString(2131953784, new Object[] { localObject1 });
            j.d(paramTriggerLog, "mContext.getString(R.str…r_log_content_open, time)");
          }
          break;
        case -40300674: 
          if (((String)localObject2).equals("rotation"))
          {
            paramTriggerLog = paramTriggerLog.getParams();
            if (paramTriggerLog != null)
            {
              paramTriggerLog = paramTriggerLog.get("rotate_deg");
              if (paramTriggerLog != null)
              {
                paramTriggerLog = paramTriggerLog.toString();
                if (paramTriggerLog != null)
                {
                  paramTriggerLog = m.i(paramTriggerLog);
                  if (paramTriggerLog != null)
                  {
                    d1 = paramTriggerLog.doubleValue();
                    break label268;
                  }
                }
              }
            }
            double d1 = 0.0D;
            if (d1 < 0.0D) {
              paramTriggerLog = r().getString(2131951850, new Object[] { localObject1 });
            } else {
              paramTriggerLog = r().getString(2131951851, new Object[] { localObject1 });
            }
            j.d(paramTriggerLog, "if (deg < 0.0) {\n       …, time)\n                }");
          }
          break;
        case -56853649: 
          if (((String)localObject2).equals("keepOpen"))
          {
            paramTriggerLog = r().getString(2131953782, new Object[] { localObject1 });
            j.d(paramTriggerLog, "mContext.getString(R.str…_content_keep_open, time)");
          }
          break;
        case -1068318794: 
          if (((String)localObject2).equals("motion"))
          {
            paramTriggerLog = r().getString(2131953783, new Object[] { localObject1 });
            j.d(paramTriggerLog, "mContext.getString(R.str…log_content_motion, time)");
          }
          break;
        case -1643834313: 
          if (((String)localObject2).equals("doubleClick"))
          {
            paramTriggerLog = r().getString(2131951852, new Object[] { localObject1 });
            j.d(paramTriggerLog, "mContext.getString(R.str…ger_log_double_tap, time)");
          }
          break;
        case -1757823456: 
          label268:
          if (((String)localObject2).equals("singleClick"))
          {
            paramTriggerLog = r().getString(2131951853, new Object[] { localObject1 });
            j.d(paramTriggerLog, "mContext.getString(R.str…ger_log_single_tap, time)");
          }
          break;
        }
      }
      paramTriggerLog = r().getString(2131953781, new Object[] { localObject1 });
      j.d(paramTriggerLog, "mContext.getString(R.str…log_content_common, time)");
      return paramTriggerLog;
    }
    return "";
  }
  
  private final String D(Long paramLong)
  {
    if (paramLong != null)
    {
      long l = paramLong.longValue();
      paramLong = new Date();
      Date localDate = new Date(l);
      TimeZone localTimeZone = p0.d(this.d);
      if (q0.f(paramLong, localDate, localTimeZone))
      {
        paramLong = E();
        j.d(paramLong, "mTodayStr");
      }
      else if (q0.i(localDate, localTimeZone))
      {
        paramLong = G();
        j.d(paramLong, "mYesterdayStr");
      }
      else
      {
        j.d(localTimeZone, "deviceTimeZone");
        paramLong = g.d(localDate, localTimeZone, null, 2, null);
      }
      return paramLong;
    }
    return "";
  }
  
  private final String E()
  {
    return (String)this.e.getValue();
  }
  
  private final String F()
  {
    return (String)this.g.getValue();
  }
  
  private final String G()
  {
    return (String)this.f.getValue();
  }
  
  private final SpannableString H(String paramString)
  {
    paramString = new SpannableString(paramString);
    paramString.setSpan(new a(this), 0, paramString.length(), 33);
    return paramString;
  }
  
  private final void J(GeneralAdapter.GeneralVH paramGeneralVH, a parama, int paramInt)
  {
    parama = paramGeneralVH.c(2131364805);
    boolean bool1 = false;
    boolean bool2;
    if (parama != null)
    {
      a locala = (a)l.z(s(), paramInt - 1);
      if ((locala != null) && (locala.c() == true)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ViewKt.setInvisible(parama, bool2);
    }
    parama = paramGeneralVH.c(2131364806);
    if (parama != null)
    {
      paramGeneralVH = (a)l.z(s(), paramInt + 1);
      if (paramGeneralVH != null)
      {
        bool2 = bool1;
        if (!paramGeneralVH.c()) {}
      }
      else
      {
        bool2 = true;
      }
      ViewKt.setInvisible(parama, bool2);
    }
  }
  
  public void B(GeneralAdapter.GeneralVH paramGeneralVH, a parama, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(parama, "data");
    if (((a)s().get(paramInt)).c())
    {
      paramGeneralVH.d(2131364395, D(parama.a()));
    }
    else
    {
      View localView = paramGeneralVH.c(2131363357);
      if (localView != null) {
        localView.setVisibility(0);
      }
      paramGeneralVH.d(2131364701, C(parama.b()));
      J(paramGeneralVH, parama, paramInt);
    }
  }
  
  public final void I(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.d = paramString;
  }
  
  public int getItemCount()
  {
    return s().size();
  }
  
  public int getItemViewType(int paramInt)
  {
    a locala = (a)l.z(s(), paramInt);
    if ((locala != null) && (locala.c() == true)) {
      return 1;
    }
    return 2;
  }
  
  public void n(GeneralAdapter.GeneralVH paramGeneralVH, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    Object localObject = (LinearLayout)paramGeneralVH.c(2131363357);
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(4);
    }
    localObject = (TextView)paramGeneralVH.c(2131364701);
    if (localObject != null)
    {
      ((TextView)localObject).setMovementMethod(new LinkMovementMethod());
      paramGeneralVH = F();
      j.d(paramGeneralVH, "mViewAllStr");
      ((TextView)localObject).setText(H(paramGeneralVH));
    }
  }
  
  public int p(int paramInt)
  {
    if (paramInt == 2) {
      paramInt = 2131559077;
    } else {
      paramInt = 2131559078;
    }
    return paramInt;
  }
  
  public static final class a
    extends ClickableSpan
  {
    private final int c;
    
    a(SensorTriggerLogAdapter paramSensorTriggerLogAdapter)
    {
      this.c = SensorTriggerLogAdapter.A(paramSensorTriggerLogAdapter).getResources().getColor(2131099811);
    }
    
    public void onClick(View paramView)
    {
      j.e(paramView, "widget");
      Toast.makeText(SensorTriggerLogAdapter.A(this.d), SensorTriggerLogAdapter.A(this.d).getString(2131953786), 0).show();
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      j.e(paramTextPaint, "ds");
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setColor(this.c);
      paramTextPaint.setUnderlineText(false);
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<String>
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final String a()
    {
      return this.c.getString(2131954302);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<String>
  {
    c(Context paramContext)
    {
      super();
    }
    
    public final String a()
    {
      return this.c.getString(2131953786);
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<String>
  {
    d(Context paramContext)
    {
      super();
    }
    
    public final String a()
    {
      return this.c.getString(2131954524);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iotsensor\SensorTriggerLogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */