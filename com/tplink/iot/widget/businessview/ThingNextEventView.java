package com.tplink.iot.widget.businessview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.t;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPointView;
import com.tplink.iot.widget.colorbulb.ColorPointView;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVNextEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ThingNextEventView
  extends LinearLayout
{
  private TextView H3;
  private ImageView I3;
  private ColorPointView J3;
  private LightingEffectPointView K3;
  private d L3;
  private Timer c;
  private Timer d;
  private b f;
  private Context p0;
  private TextView p1;
  private TextView p2;
  private TextView p3;
  private c q;
  private long x = 0L;
  private long y = 0L;
  private Handler z;
  
  public ThingNextEventView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ThingNextEventView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ThingNextEventView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    j(paramContext);
  }
  
  private void g()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.q = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.d = null;
    }
  }
  
  private long getTodayEndTimeStamp()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), 23, 59, 59);
    return localCalendar.getTimeInMillis();
  }
  
  private String h(Context paramContext, long paramLong, String paramString)
  {
    Object localObject = Calendar.getInstance(p0.d(paramString));
    ((Calendar)localObject).setTime(new Date(paramLong));
    int i = ((Calendar)localObject).get(11);
    int j = ((Calendar)localObject).get(12);
    if (paramLong > getTodayEndTimeStamp()) {
      localObject = com.tplink.iot.Utils.z0.l.l(paramContext, ((Calendar)localObject).get(7));
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(p0.a(paramContext, i * 60 + j));
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramContext = new StringBuilder();
      paramContext.append(" ");
      paramContext.append((String)localObject);
      localObject = paramContext.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(p0.e(paramString));
    return localStringBuilder.toString();
  }
  
  private void i()
  {
    this.J3.setVisibility(8);
    this.p3.setVisibility(8);
    this.K3.setVisibility(8);
    this.H3.setVisibility(8);
  }
  
  private void j(Context paramContext)
  {
    this.p0 = paramContext;
    LayoutInflater.from(paramContext).inflate(2131559433, this, true);
    this.I3 = ((ImageView)findViewById(2131363088));
    this.p1 = ((TextView)findViewById(2131364543));
    this.p2 = ((TextView)findViewById(2131364541));
    this.H3 = ((TextView)findViewById(2131364542));
    this.J3 = ((ColorPointView)findViewById(2131362290));
    this.K3 = ((LightingEffectPointView)findViewById(2131363235));
    this.p3 = ((TextView)findViewById(2131364355));
    this.z = new Handler();
    setVisibility(8);
    i();
  }
  
  private void n(NextEvent paramNextEvent, boolean paramBoolean)
  {
    int i = t.a(paramNextEvent.getType());
    this.I3.setImageResource(i);
    if (paramNextEvent.getType() == 3)
    {
      i();
      TextView localTextView = this.p2;
      if (paramBoolean)
      {
        paramNextEvent = this.p0;
        i = 2131951834;
      }
      else
      {
        paramNextEvent = this.p0;
        i = 2131951836;
      }
      localTextView.setText(paramNextEvent.getString(i));
    }
    else
    {
      setNextEventAction(paramNextEvent);
    }
  }
  
  private void o(String paramString)
  {
    this.p3.setVisibility(0);
    this.p3.setText(paramString);
  }
  
  private void p()
  {
    this.c = new Timer();
    b localb = new b(null);
    this.f = localb;
    this.c.schedule(localb, 0L, 1000L);
  }
  
  private void q()
  {
    com.tplink.libtpnetwork.Utils.l.a(a.c);
    this.d = new Timer();
    c localc = new c(null);
    this.q = localc;
    this.d.schedule(localc, new Date(this.y));
  }
  
  @SuppressLint({"SetTextI18n"})
  private void setNextEventAction(NextEvent paramNextEvent)
  {
    i();
    boolean bool1 = paramNextEvent instanceof BulbNextEvent;
    boolean bool2 = false;
    Object localObject3;
    if (bool1)
    {
      paramNextEvent = (BulbNextEvent)paramNextEvent;
      Object localObject1 = paramNextEvent.getDesiredStates();
      paramNextEvent = paramNextEvent.getFormatDesiredStates();
      if ((localObject1 != null) && (paramNextEvent != null) && (paramNextEvent.isOn()))
      {
        Object localObject2 = ((Map)localObject1).get("brightness");
        localObject3 = ((Map)localObject1).get("color_temp");
        Object localObject4 = ((Map)localObject1).get("hue");
        localObject1 = ((Map)localObject1).get("lighting_effect");
        this.p2.setText(this.p0.getString(2131954365));
        if (paramNextEvent.isAuto())
        {
          this.p2.setText(i.b(this.p0, paramNextEvent.getAutoMode()));
        }
        else if (localObject1 != null)
        {
          paramNextEvent = paramNextEvent.getLightingEffectData();
          this.K3.setVisibility(0);
          this.K3.h(1);
          if (paramNextEvent.brightness != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramNextEvent.brightness);
            ((StringBuilder)localObject3).append("%");
            o(((StringBuilder)localObject3).toString());
          }
        }
        else if ((localObject3 == null) && (localObject4 == null))
        {
          if (localObject2 != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramNextEvent.getBrightness());
            ((StringBuilder)localObject3).append("%");
            o(((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          if (localObject2 != null)
          {
            localObject1 = i.e(paramNextEvent.getColorTemp());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramNextEvent.getBrightness());
            ((StringBuilder)localObject3).append("%");
            ((StringBuilder)localObject3).append((String)localObject1);
            o(((StringBuilder)localObject3).toString());
          }
          this.J3.setVisibility(0);
          this.J3.setInnerCircleColor(i.c(paramNextEvent.getColorTemp(), paramNextEvent.getHue(), paramNextEvent.getSaturation()));
        }
      }
      else
      {
        this.p2.setText(this.p0.getString(2131954364));
      }
    }
    else if ((paramNextEvent instanceof PlugNextEvent))
    {
      localObject3 = (PlugNextEvent)paramNextEvent;
      if (((PlugNextEvent)localObject3).getFormatDesiredStates() == null)
      {
        if (paramNextEvent.getAction() == 1) {
          bool2 = true;
        }
      }
      else {
        bool2 = ((PlugNextEvent)localObject3).getFormatDesiredStates().isOn();
      }
      paramNextEvent = this.p0;
      if (bool2) {
        paramNextEvent = paramNextEvent.getString(2131954365);
      } else {
        paramNextEvent = paramNextEvent.getString(2131954364);
      }
      this.p2.setText(paramNextEvent);
    }
    else if ((paramNextEvent instanceof TRVNextEvent))
    {
      this.p3.setVisibility(8);
      paramNextEvent = (TRVNextEvent)paramNextEvent;
      if (paramNextEvent.getDesiredStatesBean() != null) {
        if ((paramNextEvent.getDesiredStatesBean().isFrostProtectionOn() ^ true))
        {
          paramNextEvent = com.tplink.iot.g.d.a.b.e(paramNextEvent.getDesiredStatesBean().getTargetTemp(), paramNextEvent.getDesiredStatesBean().getTempUnit());
          this.p2.setText(this.p0.getString(2131953998, new Object[] { paramNextEvent }));
          this.H3.setText("");
          this.H3.setVisibility(0);
        }
        else
        {
          this.p2.setText(this.p0.getString(2131953962));
          this.H3.setText("");
          this.H3.setVisibility(8);
        }
      }
    }
  }
  
  public void e()
  {
    f();
    g();
    Handler localHandler = this.z;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.z = null;
    }
  }
  
  public void f()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.f = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.c = null;
    }
  }
  
  public void r(NextEvent paramNextEvent, String paramString)
  {
    g();
    f();
    setVisibility(8);
    if ((paramNextEvent != null) && (t.h(paramNextEvent.getType())))
    {
      long l = 0L;
      boolean bool;
      if (t.h(paramNextEvent.getType()))
      {
        l = o0.k(paramNextEvent.getStartTime(), paramString);
        if ((paramNextEvent.getType() == 3) && (l < System.currentTimeMillis()))
        {
          l = o0.k(paramNextEvent.getEndTime(), paramString);
          bool = true;
        }
        else
        {
          bool = false;
        }
        this.y = (l + 1000L);
      }
      else
      {
        bool = false;
      }
      com.tplink.libtpnetwork.Utils.l.a(new c(this));
      if (this.y > System.currentTimeMillis()) {
        q();
      }
      n(paramNextEvent, bool);
      int i = paramNextEvent.getType();
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label191;
          }
        }
        else
        {
          this.x = (1000L + l);
          p();
          break label191;
        }
      }
      this.p1.setText(h(this.p0, l, paramString));
      label191:
      if (l > System.currentTimeMillis()) {
        setVisibility(0);
      }
    }
  }
  
  public void setOnNextEventCallback(d paramd)
  {
    this.L3 = paramd;
  }
  
  private class b
    extends TimerTask
  {
    private b() {}
    
    public void run()
    {
      ThingNextEventView.c(ThingNextEventView.this).postDelayed(new a(), 0L);
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        int i = (int)((ThingNextEventView.a(ThingNextEventView.this) - System.currentTimeMillis()) / 1000L);
        if (i < 0)
        {
          ThingNextEventView.this.f();
          ThingNextEventView.this.setVisibility(8);
        }
        else
        {
          ThingNextEventView.b(ThingNextEventView.this).setText(o0.e(i));
        }
      }
    }
  }
  
  private class c
    extends TimerTask
  {
    private c() {}
    
    public void run()
    {
      if (ThingNextEventView.d(ThingNextEventView.this) != null)
      {
        com.tplink.libtpnetwork.Utils.l.a(b.c);
        ThingNextEventView.d(ThingNextEventView.this).a();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\businessview\ThingNextEventView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */