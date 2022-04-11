package com.tplink.iot.widget.trv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tplink.iot.databinding.LayoutTemperatureSeekbarBinding;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.l;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class TemperatureSeekBarLayout
  extends FrameLayout
{
  private static final List<Integer> c = l.g(new Integer[] { Integer.valueOf(5), Integer.valueOf(15), Integer.valueOf(20), Integer.valueOf(25), Integer.valueOf(30) });
  private static final List<Integer> d = l.g(new Integer[] { Integer.valueOf(41), Integer.valueOf(59), Integer.valueOf(68), Integer.valueOf(77), Integer.valueOf(86) });
  public static final c f = new c(null);
  private d p0;
  private boolean p1;
  private final LayoutTemperatureSeekbarBinding q;
  private final f x;
  private final f y;
  private EnumTemperatureUnit z;
  
  public TemperatureSeekBarLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public TemperatureSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public TemperatureSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = LayoutTemperatureSeekbarBinding.h(LayoutInflater.from(paramContext), this, true);
    j.d(paramContext, "LayoutTemperatureSeekbar…rom(context), this, true)");
    this.q = paramContext;
    this.x = h.b(new f(this));
    this.y = h.b(new e(this));
    this.z = EnumTemperatureUnit.CELSIUS;
    this.p1 = true;
    getMPresetView().setOnPresetItemCheckListener(new a(this));
    getMTempSeekBar().setOnSeekBarChangeListener(new b(this));
    d();
  }
  
  private final void d()
  {
    EnumTemperatureUnit localEnumTemperatureUnit = this.z;
    int i = a.b[localEnumTemperatureUnit.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        i = 72;
      } else {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      i = 22;
    }
    getMTempSeekBar().h(i);
  }
  
  private final TemperaturePresetsView getMPresetView()
  {
    return (TemperaturePresetsView)this.y.getValue();
  }
  
  private final TemperatureSeekBar getMTempSeekBar()
  {
    return (TemperatureSeekBar)this.x.getValue();
  }
  
  public final void e(int paramInt1, int paramInt2, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "tempUnit");
    this.z = paramEnumTemperatureUnit;
    setPresets(paramEnumTemperatureUnit);
    getMTempSeekBar().i(paramInt1, paramInt2, paramEnumTemperatureUnit);
    if (this.p1) {
      d();
    }
  }
  
  public final TextView getHeaderTextView()
  {
    TextView localTextView = this.q.f;
    j.d(localTextView, "mBinding.tvHeader");
    return localTextView;
  }
  
  public final int getMaxTemperature()
  {
    return getMTempSeekBar().getMaxTemperature();
  }
  
  public final int getMinTemperature()
  {
    return getMTempSeekBar().getMinTemperature();
  }
  
  public final int getTemperature()
  {
    return getMTempSeekBar().getTemperature();
  }
  
  public final EnumTemperatureUnit getTemperatureUnit()
  {
    return this.z;
  }
  
  public final void setHeaderTextViewVisible(boolean paramBoolean)
  {
    TextView localTextView = this.q.f;
    j.d(localTextView, "mBinding.tvHeader");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public final void setOnProgressBarChangeListener(d paramd)
  {
    this.p0 = paramd;
  }
  
  public final void setPresets(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "tempUnit");
    int i = a.a[paramEnumTemperatureUnit.ordinal()];
    List localList;
    if (i != 1)
    {
      if (i == 2) {
        localList = d;
      } else {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      localList = c;
    }
    getMPresetView().e(localList, paramEnumTemperatureUnit);
  }
  
  public final void setTemperature(int paramInt)
  {
    this.p1 = false;
    getMTempSeekBar().h(paramInt);
  }
  
  public final void setTemperatureUnit(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    if (paramEnumTemperatureUnit == null) {
      paramEnumTemperatureUnit = EnumTemperatureUnit.CELSIUS;
    }
    this.z = paramEnumTemperatureUnit;
    getMTempSeekBar().setTemperatureUnit(this.z);
  }
  
  public static final class a
    implements TemperaturePresetsView.b
  {
    a(TemperatureSeekBarLayout paramTemperatureSeekBarLayout) {}
    
    public void a(int paramInt)
    {
      this.a.setTemperature(paramInt);
    }
  }
  
  public static final class b
    implements TemperatureSeekBar.b
  {
    b(TemperatureSeekBarLayout paramTemperatureSeekBarLayout) {}
    
    public void a(SeekBar paramSeekBar, int paramInt, EnumTemperatureUnit paramEnumTemperatureUnit, boolean paramBoolean)
    {
      j.e(paramEnumTemperatureUnit, "tempUnit");
      paramSeekBar = TemperatureSeekBarLayout.b(this.a);
      if (paramSeekBar != null) {
        paramSeekBar.onChange();
      }
      if (paramBoolean) {
        TemperatureSeekBarLayout.c(this.a).d();
      }
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
  
  public static final class c {}
  
  public static abstract interface d
  {
    public abstract void onChange();
  }
  
  static final class e
    extends Lambda
    implements a<TemperaturePresetsView>
  {
    e(TemperatureSeekBarLayout paramTemperatureSeekBarLayout)
    {
      super();
    }
    
    public final TemperaturePresetsView a()
    {
      TemperaturePresetsView localTemperaturePresetsView = TemperatureSeekBarLayout.a(this.c).c;
      j.d(localTemperaturePresetsView, "mBinding.presetView");
      return localTemperaturePresetsView;
    }
  }
  
  static final class f
    extends Lambda
    implements a<TemperatureSeekBar>
  {
    f(TemperatureSeekBarLayout paramTemperatureSeekBarLayout)
    {
      super();
    }
    
    public final TemperatureSeekBar a()
    {
      TemperatureSeekBar localTemperatureSeekBar = TemperatureSeekBarLayout.a(this.c).d;
      j.d(localTemperatureSeekBar, "mBinding.tempSeekBar");
      return localTemperatureSeekBar;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\trv\TemperatureSeekBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */