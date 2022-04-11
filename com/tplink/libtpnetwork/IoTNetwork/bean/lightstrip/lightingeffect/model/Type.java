package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;

public enum Type
{
  static
  {
    Type localType1 = new Type("RANDOM", 0);
    RANDOM = localType1;
    Type localType2 = new Type("SEQUENCE", 1);
    SEQUENCE = localType2;
    Type localType3 = new Type("STATIC", 2);
    STATIC = localType3;
    Type localType4 = new Type("PULSE", 3);
    PULSE = localType4;
    $VALUES = new Type[] { localType1, localType2, localType3, localType4 };
  }
  
  public static final class TypeDeserializer
    implements h<Type>
  {
    public Type deserialize(i parami, java.lang.reflect.Type paramType, g paramg)
      throws JsonParseException
    {
      try
      {
        parami = Type.valueOf(parami.e().toUpperCase());
        return parami;
      }
      catch (Exception parami)
      {
        throw new IllegalArgumentException(parami);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */