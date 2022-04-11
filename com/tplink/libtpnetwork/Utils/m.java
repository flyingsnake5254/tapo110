package com.tplink.libtpnetwork.Utils;

import java.util.Random;

public class m
{
  public static String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramInt; i++)
    {
      int j;
      if (localRandom.nextInt(2) == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        if (localRandom.nextInt(2) == 0) {
          j = 65;
        } else {
          j = 97;
        }
        localStringBuilder.append(Character.toString(Character.toChars(localRandom.nextInt(26) + j)[0]));
      }
      else
      {
        localStringBuilder.append(String.valueOf(localRandom.nextInt(10)));
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */