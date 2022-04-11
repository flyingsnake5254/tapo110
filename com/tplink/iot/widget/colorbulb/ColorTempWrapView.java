package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.widget.colorbulb.c.b;
import com.tplink.iot.widget.colorbulb.c.c;

public class ColorTempWrapView
  extends LinearLayout
  implements ColorTemperatureView.b
{
  private final String c = "%sK";
  private TextView d;
  private ColorTemperatureView f;
  private c q;
  private b x;
  
  public ColorTempWrapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorTempWrapView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorTempWrapView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559413, this, true);
    this.d = ((TextView)findViewById(2131364375));
    paramContext = (ColorTemperatureView)findViewById(2131362293);
    this.f = paramContext;
    paramContext.setOnColorTemperatureListener(this);
    setColorTempValueText(this.f.getColorTemp());
  }
  
  private void setColorTempValueText(int paramInt)
  {
    if (this.f.h()) {
      this.d.setText(String.format("%sK", new Object[] { Integer.valueOf(paramInt) }));
    } else {
      this.d.setText("");
    }
  }
  
  public void a(int paramInt)
  {
    setColorTempValueText(paramInt);
  }
  
  public void b(int paramInt)
  {
    c localc = this.q;
    if (localc != null) {
      localc.b(paramInt, 0, 0);
    }
  }
  
  public void c()
  {
    b localb = this.x;
    if (localb != null) {
      localb.S(0, true);
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.f.l(paramInt1, paramInt2);
  }
  
  public int getColorTemp()
  {
    return this.f.getColorTemp();
  }
  
  public void setColorTemp(int paramInt)
  {
    this.f.setColorTemp(paramInt);
    setColorTempValueText(paramInt);
  }
  
  public void setOnLightTypeSelectListener(b paramb)
  {
    this.x = paramb;
  }
  
  public void setOnSampleLightStateCallback(c paramc)
  {
    this.q = paramc;
  }
  
  public void setSelectedStatus(boolean paramBoolean)
  {
    this.f.setSelectedStatus(paramBoolean);
    if (!paramBoolean) {
      setColorTempValueText(0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorTempWrapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */