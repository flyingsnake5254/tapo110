package com.airbnb.lottie.parser.moshi;

final class c
{
  static String a(int paramInt, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    for (int i = 0; i < paramInt; i++)
    {
      int j = paramArrayOfInt1[i];
      if ((j != 1) && (j != 2))
      {
        if ((j == 3) || (j == 4) || (j == 5))
        {
          localStringBuilder.append('.');
          if (paramArrayOfString[i] != null) {
            localStringBuilder.append(paramArrayOfString[i]);
          }
        }
      }
      else
      {
        localStringBuilder.append('[');
        localStringBuilder.append(paramArrayOfInt2[i]);
        localStringBuilder.append(']');
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\parser\moshi\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */