package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.tplink.iot.Utils.z0.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class ColorPresetEditWrapView
  extends LinearLayout
  implements TitleSelectorView.a, com.tplink.iot.widget.colorbulb.c.c, SeekBar.OnSeekBarChangeListener, com.tplink.iot.widget.colorbulb.c.b
{
  private int H3;
  private boolean I3 = true;
  private TitleSelectorView c;
  private TextView d;
  private AppCompatSeekBar f;
  private boolean p0 = true;
  private int p1 = 0;
  private b p2;
  private io.reactivex.e0.c p3;
  private ColorTempWrapView q;
  private ColorPlateWrapView x;
  private View y;
  private int z = 1;
  
  public ColorPresetEditWrapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorPresetEditWrapView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorPresetEditWrapView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.ColorPresetEditWrapView, paramInt, 0);
    if (paramAttributeSet != null)
    {
      this.z = paramAttributeSet.getInt(1, 1);
      this.p0 = paramAttributeSet.getBoolean(0, true);
      paramAttributeSet.recycle();
    }
    i(paramContext);
  }
  
  private void i(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559407, this, true);
    this.c = ((TitleSelectorView)findViewById(2131364257));
    this.y = findViewById(2131363267);
    this.d = ((TextView)findViewById(2131364355));
    this.f = ((AppCompatSeekBar)findViewById(2131364008));
    paramContext = this.y;
    int i;
    if (this.p0) {
      i = 0;
    } else {
      i = 8;
    }
    paramContext.setVisibility(i);
    paramContext = (ColorTempWrapView)findViewById(2131362294);
    this.q = paramContext;
    paramContext.setOnSampleLightStateCallback(this);
    this.q.setOnLightTypeSelectListener(this);
    paramContext = (ColorPlateWrapView)findViewById(2131362289);
    this.x = paramContext;
    paramContext.setOnSampleLightStateCallback(this);
    this.x.setOnLightTypeSelectListener(this);
    this.q.setColorTemp(2700);
    this.f.setProgress(100);
    this.d.setText("100%");
    this.f.setOnSeekBarChangeListener(this);
    this.c.setOnSelectedTitleListener(this);
    setColorMode(this.z);
  }
  
  private void j(int paramInt)
  {
    if (this.p2 != null)
    {
      LightStateBean localLightStateBean = getLightState();
      localLightStateBean.setBrightness(paramInt);
      this.p2.a(localLightStateBean);
    }
  }
  
  private void k()
  {
    io.reactivex.e0.c localc = this.p3;
    if (localc != null) {
      localc.dispose();
    }
    this.I3 = false;
    this.H3 = this.f.getProgress();
    this.p3 = q.a0(500L, 500L, TimeUnit.MILLISECONDS).L0(a.c()).G0(new a());
  }
  
  public void S(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      this.p1 = 0;
      this.x.setSelectedStatus(false);
    }
    else if (paramInt == 1)
    {
      this.p1 = 1;
      this.q.setSelectedStatus(false);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.q.setVisibility(0);
      this.x.setVisibility(4);
    }
    else
    {
      this.q.setVisibility(4);
      this.x.setVisibility(0);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.p2 != null)
    {
      LightStateBean localLightStateBean = new LightStateBean(paramInt2, paramInt3, paramInt1, this.f.getProgress());
      this.p2.a(localLightStateBean);
    }
  }
  
  public LightStateBean getLightState()
  {
    LightStateBean localLightStateBean = new LightStateBean(true);
    if (this.p1 == 0)
    {
      localLightStateBean.setColorTemp(this.q.getColorTemp());
    }
    else
    {
      localLightStateBean.setColorTemp(0);
      localLightStateBean.setHue(this.x.getHue());
      localLightStateBean.setSaturation(this.x.getSat());
    }
    localLightStateBean.setBrightness(this.f.getProgress());
    return localLightStateBean;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      paramSeekBar.setProgress(1);
      i = 1;
    }
    TextView localTextView = this.d;
    paramSeekBar = new StringBuilder();
    paramSeekBar.append(i);
    paramSeekBar.append("%");
    localTextView.setText(paramSeekBar.toString());
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.I3 = false;
    k();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.I3 = true;
  }
  
  public void setColorMode(int paramInt)
  {
    this.z = paramInt;
    if (paramInt == 1) {
      this.c.setBackgroundResource(2131230890);
    } else {
      this.c.setBackgroundResource(2131230891);
    }
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setLightStates(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      if (paramLightStateBean.getColorTemp() == 0)
      {
        setSelectedItem(1);
        int i = i.a(paramLightStateBean.getHue(), paramLightStateBean.getSaturation());
        this.x.b(i, paramLightStateBean.getHue(), paramLightStateBean.getSaturation());
      }
      else
      {
        setSelectedItem(0);
        this.q.setColorTemp(paramLightStateBean.getColorTemp());
      }
      this.f.setProgress(paramLightStateBean.getBrightness());
      TextView localTextView = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLightStateBean.getBrightness());
      localStringBuilder.append("%");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  public void setOnSampleLightStateChangeCallback(b paramb)
  {
    this.p2 = paramb;
  }
  
  public void setSelectedItem(int paramInt)
  {
    this.c.setSelectedTitleIndex(paramInt);
  }
  
  class a
    implements g<Long>
  {
    a() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      int i = ColorPresetEditWrapView.c(ColorPresetEditWrapView.this).getProgress();
      if (i != ColorPresetEditWrapView.d(ColorPresetEditWrapView.this)) {
        ColorPresetEditWrapView.f(ColorPresetEditWrapView.this, i);
      }
      ColorPresetEditWrapView.e(ColorPresetEditWrapView.this, i);
      if ((ColorPresetEditWrapView.g(ColorPresetEditWrapView.this)) && (ColorPresetEditWrapView.h(ColorPresetEditWrapView.this) != null)) {
        ColorPresetEditWrapView.h(ColorPresetEditWrapView.this).dispose();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(LightStateBean paramLightStateBean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorPresetEditWrapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */