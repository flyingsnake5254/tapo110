package com.airbnb.lottie.u;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class o
  implements j0<Integer>
{
  public static final o a = new o();
  
  public Integer b(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    return Integer.valueOf(Math.round(p.g(paramJsonReader) * paramFloat));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */