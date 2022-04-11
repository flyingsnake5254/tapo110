package com.airbnb.lottie.u;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import java.io.IOException;

public class f
  implements j0<Integer>
{
  public static final f a = new f();
  
  public Integer b(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    int i;
    if (paramJsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJsonReader.c();
    }
    double d1 = paramJsonReader.l();
    double d2 = paramJsonReader.l();
    double d3 = paramJsonReader.l();
    double d4 = paramJsonReader.l();
    if (i != 0) {
      paramJsonReader.g();
    }
    double d5 = d1;
    double d6 = d2;
    double d7 = d3;
    double d8 = d4;
    if (d1 <= 1.0D)
    {
      d5 = d1;
      d6 = d2;
      d7 = d3;
      d8 = d4;
      if (d2 <= 1.0D)
      {
        d5 = d1;
        d6 = d2;
        d7 = d3;
        d8 = d4;
        if (d3 <= 1.0D)
        {
          d1 *= 255.0D;
          d2 *= 255.0D;
          d3 *= 255.0D;
          d5 = d1;
          d6 = d2;
          d7 = d3;
          d8 = d4;
          if (d4 <= 1.0D)
          {
            d8 = d4 * 255.0D;
            d7 = d3;
            d6 = d2;
            d5 = d1;
          }
        }
      }
    }
    return Integer.valueOf(Color.argb((int)d8, (int)d5, (int)d6, (int)d7));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */