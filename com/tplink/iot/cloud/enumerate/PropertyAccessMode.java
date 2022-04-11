package com.tplink.iot.cloud.enumerate;

import com.google.gson.q.c;

public enum PropertyAccessMode
{
  static
  {
    PropertyAccessMode localPropertyAccessMode1 = new PropertyAccessMode("READ", 0);
    READ = localPropertyAccessMode1;
    PropertyAccessMode localPropertyAccessMode2 = new PropertyAccessMode("WRITE", 1);
    WRITE = localPropertyAccessMode2;
    $VALUES = new PropertyAccessMode[] { localPropertyAccessMode1, localPropertyAccessMode2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\enumerate\PropertyAccessMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */