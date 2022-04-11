package com.tplink.iot.devices.lightstrip.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.databinding.LayoutLightStripControllerBinding;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.a;
import io.reactivex.d0.b.a;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

public final class LightStripControllerLayout
  extends FrameLayout
  implements LightStripBrightnessController.a, TPCheckboxCompat.a
{
  private final LayoutLightStripControllerBinding c;
  private final SimpleTextSwitcher d;
  private final LightStripBrightnessController f;
  private boolean p0;
  private int p1;
  private boolean p2;
  private final TPCheckboxCompat q;
  private final TextView x;
  private c y;
  private a z;
  
  public LightStripControllerLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightStripControllerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightStripControllerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559170, this, true);
    j.d(paramContext, "DataBindingUtil.inflate(…troller, this, true\n    )");
    Object localObject = (LayoutLightStripControllerBinding)paramContext;
    this.c = ((LayoutLightStripControllerBinding)localObject);
    paramContext = ((LayoutLightStripControllerBinding)localObject).c;
    j.d(paramContext, "mBinding.brightnessSwitcher");
    this.d = paramContext;
    paramContext = ((LayoutLightStripControllerBinding)localObject).f;
    j.d(paramContext, "mBinding.lsBrightnessController");
    this.f = paramContext;
    paramAttributeSet = ((LayoutLightStripControllerBinding)localObject).d;
    j.d(paramAttributeSet, "mBinding.lightStripSwitch");
    this.q = paramAttributeSet;
    localObject = ((LayoutLightStripControllerBinding)localObject).q;
    j.d(localObject, "mBinding.tvColorTempValue");
    this.x = ((TextView)localObject);
    this.p2 = true;
    paramContext.setOnBrightnessChangeListener(this);
    paramAttributeSet.setOnCheckedChangeListener(this);
  }
  
  private final void k()
  {
    this.p1 = this.f.getBrightness();
    this.y = q.a0(500L, 500L, TimeUnit.MILLISECONDS).l0(a.a()).E(new c(this)).F0();
  }
  
  private final void l()
  {
    c localc = this.y;
    if ((localc != null) && (!localc.isDisposed()))
    {
      localc = this.y;
      if (localc != null) {
        localc.dispose();
      }
      this.y = null;
    }
  }
  
  @SuppressLint({"SetTextI18n"})
  private final void n(int paramInt)
  {
    TextView localTextView = this.x;
    int i = 0;
    int j;
    if (paramInt != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      j = i;
    } else {
      j = 8;
    }
    localTextView.setVisibility(j);
    localTextView = this.x;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append('K');
    localTextView.setText(localStringBuilder.toString());
  }
  
  public void a()
  {
    k();
  }
  
  public void b()
  {
    l();
    a locala = this.z;
    if (locala != null) {
      locala.w(this.f.getBrightness(), true);
    }
  }
  
  public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.q.setEnabled(false);
      u0.a(getContext(), 200L);
      paramCompoundButton = this.z;
      if (paramCompoundButton != null) {
        paramCompoundButton.v0(paramBoolean1);
      }
      this.q.postDelayed(new b(this), 800L);
    }
  }
  
  public void d(int paramInt)
  {
    this.d.a(true, paramInt, false);
    a locala = this.z;
    if (locala != null) {
      locala.E(paramInt);
    }
  }
  
  public final void j(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    SimpleTextSwitcher localSimpleTextSwitcher = this.d;
    boolean bool;
    if ((!this.p2) && (this.p0 != paramBoolean)) {
      bool = true;
    } else {
      bool = false;
    }
    localSimpleTextSwitcher.a(paramBoolean, paramInt1, bool);
    n(paramInt2);
    this.q.setChecked(paramBoolean);
    if (paramBoolean) {
      this.f.i(paramInt1, this.p2 ^ true);
    } else {
      this.f.c(this.p2 ^ true);
    }
    this.p0 = paramBoolean;
    if (this.p2) {
      this.p2 = false;
    }
  }
  
  public final void m(List<Integer> paramList)
  {
    j.e(paramList, "colors");
    this.f.m(paramList);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    l();
  }
  
  public final void setControllerStateListener(a parama)
  {
    j.e(parama, "listener");
    this.z = parama;
  }
  
  public static abstract interface a
  {
    public abstract void E(int paramInt);
    
    public abstract void v0(boolean paramBoolean);
    
    public abstract void w(int paramInt, boolean paramBoolean);
  }
  
  static final class b
    implements Runnable
  {
    b(LightStripControllerLayout paramLightStripControllerLayout) {}
    
    public final void run()
    {
      LightStripControllerLayout.h(this.c).setEnabled(true);
    }
  }
  
  static final class c<T>
    implements g<Long>
  {
    c(LightStripControllerLayout paramLightStripControllerLayout) {}
    
    public final void a(Long paramLong)
    {
      int i = LightStripControllerLayout.e(this.c).getBrightness();
      if (LightStripControllerLayout.f(this.c) != i)
      {
        LightStripControllerLayout.i(this.c, i);
        paramLong = LightStripControllerLayout.g(this.c);
        if (paramLong != null) {
          paramLong.w(i, false);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightStripControllerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */