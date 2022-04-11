package com.tplink.iot.Utils;

public class m
{
  public static String a(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 256)
      {
        if (paramInt != 16)
        {
          if (paramInt != 17) {
            str = "invalid";
          } else {
            str = "upnp";
          }
        }
        else {
          str = "P2P";
        }
      }
      else {
        str = "local";
      }
    }
    else {
      str = "relay";
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */