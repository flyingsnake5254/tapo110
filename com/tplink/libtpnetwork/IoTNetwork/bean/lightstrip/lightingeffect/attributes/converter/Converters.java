package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

public final class Converters
{
  public static final BooleanConverter booleanConverter = new BooleanConverter();
  public static final IntegerConverter integerConverter = new IntegerConverter();
  public static final LocaleConverter localeConverter = new LocaleConverter();
  public static final LongConverter longConverter = new LongConverter();
  public static final StringConverter stringConverter = new StringConverter();
  public static final StringReplaceConverter urlConverter = new StringReplaceConverter("\\/", "/");
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\converter\Converters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */