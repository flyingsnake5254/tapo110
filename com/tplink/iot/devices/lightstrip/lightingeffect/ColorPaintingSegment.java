package com.tplink.iot.devices.lightstrip.lightingeffect;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class ColorPaintingSegment
{
  private KasaLightState a;
  private int b;
  private boolean c;
  
  public ColorPaintingSegment(KasaLightState paramKasaLightState, int paramInt, boolean paramBoolean)
  {
    this.a = paramKasaLightState;
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public final ColorPaintingSegment a(KasaLightState paramKasaLightState, int paramInt, boolean paramBoolean)
  {
    j.e(paramKasaLightState, "lightState");
    return new ColorPaintingSegment(paramKasaLightState, paramInt, paramBoolean);
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final KasaLightState e()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    Class localClass;
    if (paramObject != null) {
      localClass = paramObject.getClass();
    } else {
      localClass = null;
    }
    if ((j.a(ColorPaintingSegment.class, localClass) ^ true)) {
      return false;
    }
    Objects.requireNonNull(paramObject, "null cannot be cast to non-null type com.tplink.iot.devices.lightstrip.lightingeffect.ColorPaintingSegment");
    paramObject = (ColorPaintingSegment)paramObject;
    return this.b == ((ColorPaintingSegment)paramObject).b;
  }
  
  public final boolean f()
  {
    Integer localInteger = this.a.getBrightness();
    if ((localInteger != null) && (localInteger.intValue() == 0))
    {
      localInteger = this.a.getSaturation();
      if ((localInteger != null) && (localInteger.intValue() == 0))
      {
        localInteger = this.a.getHue();
        if ((localInteger != null) && (localInteger.intValue() == 0)) {
          return true;
        }
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public int hashCode()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColorPaintingSegment(lightState=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class DiffCallback
    extends DiffUtil.ItemCallback<ColorPaintingSegment>
  {
    public boolean a(ColorPaintingSegment paramColorPaintingSegment1, ColorPaintingSegment paramColorPaintingSegment2)
    {
      j.e(paramColorPaintingSegment1, "oldItem");
      j.e(paramColorPaintingSegment2, "newItem");
      boolean bool;
      if ((j.a(paramColorPaintingSegment1.e().getHue(), paramColorPaintingSegment2.e().getHue())) && (j.a(paramColorPaintingSegment1.e().getSaturation(), paramColorPaintingSegment2.e().getSaturation())) && (j.a(paramColorPaintingSegment1.e().getBrightness(), paramColorPaintingSegment2.e().getBrightness())) && (j.a(paramColorPaintingSegment1.e().getRelayState(), paramColorPaintingSegment2.e().getRelayState())) && (paramColorPaintingSegment1.c() == paramColorPaintingSegment2.c())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean b(ColorPaintingSegment paramColorPaintingSegment1, ColorPaintingSegment paramColorPaintingSegment2)
    {
      j.e(paramColorPaintingSegment1, "oldItem");
      j.e(paramColorPaintingSegment2, "newItem");
      boolean bool;
      if (paramColorPaintingSegment1.d() == paramColorPaintingSegment2.d()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\ColorPaintingSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */