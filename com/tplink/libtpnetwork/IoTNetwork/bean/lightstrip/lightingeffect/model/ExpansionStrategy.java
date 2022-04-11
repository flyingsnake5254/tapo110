package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import java.lang.reflect.Type;

public enum ExpansionStrategy
{
  static
  {
    ExpansionStrategy localExpansionStrategy1 = new ExpansionStrategy("REPEAT", 0);
    REPEAT = localExpansionStrategy1;
    ExpansionStrategy localExpansionStrategy2 = new ExpansionStrategy("STRETCH", 1);
    STRETCH = localExpansionStrategy2;
    $VALUES = new ExpansionStrategy[] { localExpansionStrategy1, localExpansionStrategy2 };
  }
  
  public static final class ExpansionStrategyDeserializer
    implements h<ExpansionStrategy>
  {
    public ExpansionStrategy deserialize(i parami, Type paramType, g paramg)
      throws JsonParseException
    {
      try
      {
        parami = ExpansionStrategy.valueOf(parami.e().toUpperCase());
        return parami;
      }
      catch (Exception parami)
      {
        throw new IllegalArgumentException(parami);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\ExpansionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */