package com.airbnb.lottie.u;

import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class e
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "nm", "p", "s", "hd", "d" });
  
  static com.airbnb.lottie.model.content.a a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, int paramInt)
    throws IOException
  {
    boolean bool1;
    if (paramInt == 3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    boolean bool2 = false;
    while (paramJsonReader.j())
    {
      paramInt = paramJsonReader.y(a);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                paramJsonReader.z();
                paramJsonReader.A();
              }
              else if (paramJsonReader.s() == 3)
              {
                bool1 = true;
              }
              else
              {
                bool1 = false;
              }
            }
            else {
              bool2 = paramJsonReader.k();
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
    return new com.airbnb.lottie.model.content.a(str, (m)localObject1, (f)localObject2, bool1, bool2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */