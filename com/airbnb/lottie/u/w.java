package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import java.io.IOException;

class w
{
  static com.airbnb.lottie.s.c.h a(JsonReader paramJsonReader, d paramd)
    throws IOException
  {
    boolean bool;
    if (paramJsonReader.w() == JsonReader.Token.BEGIN_OBJECT) {
      bool = true;
    } else {
      bool = false;
    }
    return new com.airbnb.lottie.s.c.h(paramd, q.b(paramJsonReader, paramd, com.airbnb.lottie.v.h.e(), x.a, bool));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */