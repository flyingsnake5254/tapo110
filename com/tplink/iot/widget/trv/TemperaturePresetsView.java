package com.tplink.iot.widget.trv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tplink.iot.Utils.k;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class TemperaturePresetsView
  extends RadioGroup
{
  private b c;
  private final List<RadioButton> d = new ArrayList();
  private int f;
  
  public TemperaturePresetsView(Context paramContext)
  {
    this(paramContext, null, 2, null);
  }
  
  public TemperaturePresetsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnCheckedChangeListener(new a(this));
  }
  
  public final void d()
  {
    if (this.f == -1) {
      return;
    }
    this.f = -1;
    check(-1);
  }
  
  public final void e(List<Integer> paramList, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    j.e(paramEnumTemperatureUnit, "tempUnit");
    removeAllViews();
    this.d.clear();
    int i;
    if ((paramList != null) && (!paramList.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      setPadding(0, 0, 0, 0);
      return;
    }
    setPadding(0, k.a(getContext(), 20.0F), 0, 0);
    paramList = l.M(paramList).iterator();
    while (paramList.hasNext())
    {
      i = ((Number)paramList.next()).intValue();
      Object localObject1 = LayoutInflater.from(getContext()).inflate(2131559437, null);
      Objects.requireNonNull(localObject1, "null cannot be cast to non-null type android.widget.RadioButton");
      localObject1 = (RadioButton)localObject1;
      ((RadioButton)localObject1).setText(b.d(i, paramEnumTemperatureUnit));
      ((RadioButton)localObject1).setTag(Integer.valueOf(i));
      addView((View)localObject1);
      Object localObject2 = ((RadioButton)localObject1).getLayoutParams();
      Objects.requireNonNull(localObject2, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
      localObject2 = (RadioGroup.LayoutParams)localObject2;
      ((RadioGroup.LayoutParams)localObject2).leftMargin = k.a(getContext(), 12.0F);
      ((RadioButton)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.d.add(localObject1);
    }
  }
  
  public final void setOnPresetItemCheckListener(b paramb)
  {
    this.c = paramb;
  }
  
  static final class a
    implements RadioGroup.OnCheckedChangeListener
  {
    a(TemperaturePresetsView paramTemperaturePresetsView) {}
    
    public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      if ((paramInt != -1) && (TemperaturePresetsView.a(this.c) != -1)) {
        try
        {
          paramRadioGroup = (RadioButton)this.c.findViewById(paramInt);
          if ((paramRadioGroup == null) || (paramRadioGroup.getTag() == null)) {
            return;
          }
          paramRadioGroup = paramRadioGroup.getTag();
          if (paramRadioGroup != null)
          {
            int i = ((Integer)paramRadioGroup).intValue();
            TemperaturePresetsView.c(this.c, paramInt);
            paramRadioGroup = TemperaturePresetsView.b(this.c);
            if (paramRadioGroup == null) {
              return;
            }
            paramRadioGroup.a(i);
            return;
          }
          paramRadioGroup = new java/lang/NullPointerException;
          paramRadioGroup.<init>("null cannot be cast to non-null type kotlin.Int");
          throw paramRadioGroup;
        }
        catch (Exception paramRadioGroup)
        {
          paramRadioGroup.printStackTrace();
        }
      }
      if (TemperaturePresetsView.a(this.c) == -1) {
        TemperaturePresetsView.c(this.c, 0);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\trv\TemperaturePresetsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */