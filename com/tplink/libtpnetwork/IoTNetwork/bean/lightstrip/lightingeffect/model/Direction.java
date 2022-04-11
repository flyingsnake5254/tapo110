package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import java.lang.reflect.Type;

public enum Direction
{
  static
  {
    Direction localDirection1 = new Direction("FORWARD", 0);
    FORWARD = localDirection1;
    Direction localDirection2 = new Direction("BACKWARD", 1);
    BACKWARD = localDirection2;
    Direction localDirection3 = new Direction("PINGPONG", 2);
    PINGPONG = localDirection3;
    Direction localDirection4 = new Direction("RANDOM", 3);
    RANDOM = localDirection4;
    $VALUES = new Direction[] { localDirection1, localDirection2, localDirection3, localDirection4 };
  }
  
  public static final class DirectionDeserializer
    implements h<Direction>
  {
    public Direction deserialize(i parami, Type paramType, g paramg)
      throws JsonParseException
    {
      try
      {
        parami = Direction.valueOf(parami.e().toUpperCase());
        return parami;
      }
      catch (Exception parami)
      {
        throw new IllegalArgumentException(parami);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\Direction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */