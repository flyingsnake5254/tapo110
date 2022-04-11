package com.tplink.iot.widget.colorbulb.light;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.iot.widget.colorbulb.BgRippleLayout;

public class LightBgAnimView
  extends FrameLayout
{
  private LightBulbBgView c;
  private LightBulbBgView d;
  private BgRippleLayout f;
  private boolean p0;
  private View q;
  private View x;
  private Animation y;
  private Animation z;
  
  public LightBgAnimView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LightBgAnimView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LightBgAnimView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559428, this, true);
    this.c = ((LightBulbBgView)findViewById(2131362010));
    this.d = ((LightBulbBgView)findViewById(2131362011));
    this.f = ((BgRippleLayout)findViewById(2131362009));
    this.q = findViewById(2131362007);
    this.x = findViewById(2131362008);
    paramContext = new AlphaAnimation(0.0F, 1.0F);
    this.y = paramContext;
    paramContext.setDuration(500L);
    paramContext = new AlphaAnimation(1.0F, 0.0F);
    this.z = paramContext;
    paramContext.setDuration(500L);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = this.p0;
    if (bool != paramBoolean)
    {
      this.c.a(bool, paramInt1, paramInt2);
      this.d.a(paramBoolean, paramInt1, paramInt2);
      this.f.setOn(paramBoolean);
    }
    else
    {
      this.c.setColor(paramInt1);
      this.d.setColor(paramInt1);
    }
    this.p0 = paramBoolean;
  }
  
  public void setAnimValueChange(float paramFloat)
  {
    BgRippleLayout localBgRippleLayout = this.f;
    if (localBgRippleLayout != null) {
      localBgRippleLayout.setAnimValue(paramFloat);
    }
  }
  
  public void setBrightness(int paramInt)
  {
    this.c.setBrightness(paramInt);
    this.d.setBrightness(paramInt);
  }
  
  public void setLightEffectOn(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.x.setVisibility(0);
    } else {
      this.x.setVisibility(8);
    }
  }
  
  public void setOn(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public void setRunning(boolean paramBoolean)
  {
    BgRippleLayout localBgRippleLayout = this.f;
    if (localBgRippleLayout != null) {
      localBgRippleLayout.setRunning(paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\light\LightBgAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */