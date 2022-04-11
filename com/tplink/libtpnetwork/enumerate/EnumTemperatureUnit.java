package com.tplink.libtpnetwork.enumerate;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public enum EnumTemperatureUnit
{
  public static final b Companion = new b(null);
  private final String value;
  
  static
  {
    a locala = new a("CELSIUS", 0);
    CELSIUS = locala;
    c localc = new c("FAHRENHEIT", 1);
    FAHRENHEIT = localc;
    $VALUES = new EnumTemperatureUnit[] { locala, localc };
  }
  
  private EnumTemperatureUnit(String paramString)
  {
    this.value = paramString;
  }
  
  public static final EnumTemperatureUnit fromString(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public abstract String getUnitText();
  
  public final String getValue()
  {
    return this.value;
  }
  
  @c("celsius")
  static final class a
    extends EnumTemperatureUnit
  {
    a(String paramString, int paramInt)
    {
      super(paramInt, "celsius", null);
    }
    
    public String getUnitText()
    {
      return "℃";
    }
  }
  
  public static final class b
  {
    public final EnumTemperatureUnit a(String paramString)
    {
      EnumTemperatureUnit localEnumTemperatureUnit = EnumTemperatureUnit.FAHRENHEIT;
      if (j.a(paramString, localEnumTemperatureUnit.getValue())) {
        paramString = localEnumTemperatureUnit;
      } else {
        paramString = EnumTemperatureUnit.CELSIUS;
      }
      return paramString;
    }
  }
  
  @c("fahrenheit")
  static final class c
    extends EnumTemperatureUnit
  {
    c(String paramString, int paramInt)
    {
      super(paramInt, "fahrenheit", null);
    }
    
    public String getUnitText()
    {
      return "℉";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumTemperatureUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */