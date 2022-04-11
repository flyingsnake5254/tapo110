package com.tplink.libtpcontrols.tpthermostat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.u0;

public class TPThermostatDial
  extends FrameLayout
  implements View.OnClickListener
{
  private a H3;
  private View I3;
  private ImageView J3;
  private boolean K3 = false;
  private b L3;
  private b M3;
  private c N3;
  private int O3 = -13220789;
  private int P3 = -5789268;
  private int Q3 = -2136495700;
  private int R3;
  private float S3 = 288.0F;
  private TextView T3;
  private ImageView U3;
  private ImageView V3;
  private boolean W3 = false;
  private TextView X3;
  private TextView Y3;
  private TextView Z3;
  private TextView a4;
  private TextView b4;
  private int c;
  private TextView c4;
  private int d;
  private TextView d4;
  private TextView e4;
  private Paint f = null;
  private String f4;
  private String g4;
  private String h4;
  private String i4;
  private String j4;
  private String k4;
  private String l4;
  private int m4 = -1;
  private float p0;
  private float p1;
  private float p2;
  private int p3 = -13220789;
  private int q;
  private float x = 0.0F;
  private Bitmap y;
  private float z;
  
  public TPThermostatDial(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPThermostatDial(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    m(paramContext);
  }
  
  public TPThermostatDial(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.J3 = ((ImageView)findViewById(s0.energy_saving_state_icon));
    this.T3 = ((TextView)findViewById(s0.havc_heat_target_temp));
    this.U3 = ((ImageView)findViewById(s0.increase_btn));
    this.V3 = ((ImageView)findViewById(s0.decrease_btn));
    this.X3 = ((TextView)findViewById(s0.havcmode_notice));
    this.Y3 = ((TextView)findViewById(s0.havc_heatcool_tempreature_max));
    this.Z3 = ((TextView)findViewById(s0.havc_heatcool_tempreature_min));
    this.a4 = ((TextView)findViewById(s0.havc_heatcoolmode_select_notice));
    this.b4 = ((TextView)findViewById(s0.havc_heatcoolmode_heat_title));
    this.c4 = ((TextView)findViewById(s0.havc_heatcoolmode_cool_title));
    this.d4 = ((TextView)findViewById(s0.havc_off_title));
    this.e4 = ((TextView)findViewById(s0.havc_eco_title));
  }
  
  private float b()
  {
    throw null;
  }
  
  private float c(Point paramPoint)
  {
    double d1 = paramPoint.x - this.z;
    double d2 = paramPoint.y - this.p0;
    float f1 = 270.0F;
    boolean bool1 = d1 < 0.0D;
    if ((bool1) && (d2 < 0.0D))
    {
      f1 = (float)Math.toDegrees(Math.atan(d1 / Math.abs(d2)));
    }
    else if ((bool1) && (d2 > 0.0D))
    {
      f1 = (float)Math.toDegrees(Math.atan(d2 / d1)) + 90.0F;
    }
    else
    {
      boolean bool2 = d1 < 0.0D;
      if ((bool2) && (d2 > 0.0D))
      {
        f1 = (float)Math.toDegrees(Math.atan(Math.abs(d1) / d2)) + 180.0F;
      }
      else if ((bool2) && (d2 < 0.0D))
      {
        f1 = 270.0F + (float)Math.toDegrees(Math.atan(d2 / d1));
      }
      else
      {
        if ((!bool1) && (d2 < 0.0D)) {}
        do
        {
          f1 = 0.0F;
          break;
          if ((bool1) && (d2 == 0.0D))
          {
            f1 = 90.0F;
            break;
          }
          if ((!bool1) && (d2 > 0.0D))
          {
            f1 = 180.0F;
            break;
          }
        } while ((!bool2) || (d2 != 0.0D));
      }
    }
    f1 = (f1 - ((360.0F - this.S3) / 2.0F + 180.0F) + 360.0F) % 360.0F;
    paramPoint = new StringBuilder();
    paramPoint.append("11111 Finger Degree = ");
    paramPoint.append(f1);
    Log.e("aaaaa", paramPoint.toString());
    return f1;
  }
  
  private int d(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void e(Canvas paramCanvas)
  {
    b();
    this.y.getWidth();
    throw null;
  }
  
  private void f(Canvas paramCanvas)
  {
    if (this.M3 == null) {
      return;
    }
    this.f.setStrokeWidth(this.R3);
    this.f.setColor(this.O3);
    paramCanvas = a.b;
    throw null;
  }
  
  private void g(Canvas paramCanvas)
  {
    this.f.setColor(this.Q3);
    this.f.setStrokeWidth(this.c);
    b();
    paramCanvas = a.b;
    throw null;
  }
  
  private void h(MotionEvent paramMotionEvent)
  {
    if (this.M3 == null) {
      return;
    }
    c(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
    paramMotionEvent = a.b;
    throw null;
  }
  
  private void i(MotionEvent paramMotionEvent)
  {
    if ((this.K3) && (this.M3 != null))
    {
      c(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
      paramMotionEvent = a.b;
      throw null;
    }
  }
  
  private void j(MotionEvent paramMotionEvent)
  {
    requestDisallowInterceptTouchEvent(false);
    if (!this.K3) {
      return;
    }
    c(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
    paramMotionEvent = a.b;
    throw null;
  }
  
  private void k()
  {
    int[] arrayOfInt = a.b;
    throw null;
  }
  
  private void l()
  {
    int[] arrayOfInt = a.b;
    throw null;
  }
  
  private void m(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(t0.thermostat_dial_main, this, true);
    this.I3 = findViewById(s0.thermostat_dial_inner_view);
    this.f = new Paint(1);
    this.y = ((BitmapDrawable)ContextCompat.getDrawable(paramContext, u0.ic_current_temperature_bubble)).getBitmap();
    n();
    a();
    o();
  }
  
  private void n()
  {
    this.d = d(20.0F);
    this.c = d(2.0F);
    this.q = d(30.0F);
    this.R3 = d(2.0F);
    this.p2 = d(3.0F);
  }
  
  private void o()
  {
    this.U3.setOnClickListener(this);
    this.V3.setOnClickListener(this);
    this.Y3.setOnClickListener(this);
    this.Z3.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (s0.increase_btn == i)
    {
      l();
    }
    else if (s0.decrease_btn == i)
    {
      k();
    }
    else if (s0.havc_heatcool_tempreature_min == i)
    {
      if (this.M3 != null)
      {
        paramView = ThermostatHvacMode.HVAC_MODE_HEAT_COOL;
        throw null;
      }
    }
    else if ((s0.havc_heatcool_tempreature_max == i) && (this.M3 != null))
    {
      paramView = ThermostatHvacMode.HVAC_MODE_HEAT_COOL;
      throw null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.M3 == null) {
      return;
    }
    g(paramCanvas);
    f(paramCanvas);
    e(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.z = (getWidth() / 2.0F);
    this.p0 = ((getHeight() + this.y.getHeight() - this.d) / 2.0F);
    this.p1 = ((getHeight() - this.y.getHeight() + this.d) / 2.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label57;
          }
        }
        else
        {
          i(paramMotionEvent);
          break label57;
        }
      }
      j(paramMotionEvent);
    }
    else
    {
      h(paramMotionEvent);
    }
    label57:
    return this.K3;
  }
  
  public void setAdapter(a parama)
  {
    if ((this.H3 != null) && (this.L3 != null)) {
      throw null;
    }
    if (parama == null)
    {
      this.I3.setVisibility(8);
      return;
    }
    this.L3 = new c(null);
    throw null;
  }
  
  public void setCoolModeTitle(String paramString)
  {
    this.g4 = paramString;
  }
  
  public void setEcoModeTitle(String paramString)
  {
    this.h4 = paramString;
  }
  
  public void setHeatCoolModeCoolTitle(String paramString)
  {
    this.l4 = paramString;
  }
  
  public void setHeatCoolModeHeatTitle(String paramString)
  {
    this.k4 = paramString;
  }
  
  public void setHeatCoolModeTitle(String paramString)
  {
    this.j4 = paramString;
  }
  
  public void setHeatModeTitle(String paramString)
  {
    this.f4 = paramString;
  }
  
  public void setListener(c paramc)
  {
    this.N3 = paramc;
  }
  
  public void setOffModeTitle(String paramString)
  {
    this.i4 = paramString;
  }
  
  public static abstract class b {}
  
  private class c
    extends TPThermostatDial.b
  {
    private c() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpthermostat\TPThermostatDial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */