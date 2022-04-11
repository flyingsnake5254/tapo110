package com.airbnb.lottie.u;

import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class a0
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "nm", "p", "s", "r", "hd" });
  
  static com.airbnb.lottie.model.content.f a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
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
              localObject3 = d.e(paramJsonReader, paramd);
            }
          }
          else {
            localObject2 = d.i(paramJsonReader, paramd);
          }
        }
        else {
          localObject1 = a.b(paramJsonReader, paramd);
        }
      }
      else {
        str = paramJsonReader.u();
      }
    }
    return new com.airbnb.lottie.model.content.f(str, (m)localObject1, (com.airbnb.lottie.model.i.f)localObject2, (b)localObject3, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */