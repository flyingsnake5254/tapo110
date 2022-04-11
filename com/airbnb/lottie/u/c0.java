package com.airbnb.lottie.u;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.w.d;
import java.io.IOException;

public class c0
  implements j0<d>
{
  public static final c0 a = new c0();
  
  public d b(JsonReader paramJsonReader, float paramFloat)
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
    float f1 = (float)paramJsonReader.l();
    float f2 = (float)paramJsonReader.l();
    while (paramJsonReader.j()) {
      paramJsonReader.A();
    }
    if (i != 0) {
      paramJsonReader.g();
    }
    return new d(f1 / 100.0F * paramFloat, f2 / 100.0F * paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */