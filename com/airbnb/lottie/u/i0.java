package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class i0
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "s", "e", "o", "nm", "m", "hd" });
  
  static ShapeTrimPath a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
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
              if (i != 4)
              {
                if (i != 5) {
                  paramJsonReader.A();
                } else {
                  bool = paramJsonReader.k();
                }
              }
              else {
                localObject1 = ShapeTrimPath.Type.forId(paramJsonReader.s());
              }
            }
            else {
              str = paramJsonReader.u();
            }
          }
          else {
            localObject4 = d.f(paramJsonReader, paramd, false);
          }
        }
        else {
          localObject3 = d.f(paramJsonReader, paramd, false);
        }
      }
      else {
        localObject2 = d.f(paramJsonReader, paramd, false);
      }
    }
    return new ShapeTrimPath(str, (ShapeTrimPath.Type)localObject1, (b)localObject2, (b)localObject3, (b)localObject4, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */