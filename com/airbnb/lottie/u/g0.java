package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.k;
import com.airbnb.lottie.model.i.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class g0
{
  static JsonReader.a a = JsonReader.a.a(new String[] { "nm", "ind", "ks", "hd" });
  
  static k a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    int i = 0;
    String str = null;
    Object localObject = str;
    boolean bool = false;
    while (paramJsonReader.j())
    {
      int j = paramJsonReader.y(a);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3) {
              paramJsonReader.A();
            } else {
              bool = paramJsonReader.k();
            }
          }
          else {
            localObject = d.k(paramJsonReader, paramd);
          }
        }
        else {
          i = paramJsonReader.s();
        }
      }
      else {
        str = paramJsonReader.u();
      }
    }
    return new k(str, i, (h)localObject, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */