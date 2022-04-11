package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.g;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class b0
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "nm", "c", "o", "tr", "hd" });
  
  static g a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    boolean bool = false;
    while (paramJsonReader.j())
    {
      int i = paramJsonReader.y(a);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                paramJsonReader.A();
              } else {
                bool = paramJsonReader.k();
              }
            }
            else {
              localObject3 = c.g(paramJsonReader, paramd);
            }
          }
          else {
            localObject2 = d.f(paramJsonReader, paramd, false);
          }
        }
        else {
          localObject1 = d.f(paramJsonReader, paramd, false);
        }
      }
      else {
        str = paramJsonReader.u();
      }
    }
    return new g(str, (b)localObject1, (b)localObject2, (l)localObject3, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */