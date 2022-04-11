package com.airbnb.lottie.u;

import android.graphics.Path.FillType;
import com.airbnb.lottie.model.content.i;
import com.airbnb.lottie.model.i.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class e0
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "nm", "c", "o", "fillEnabled", "r", "hd" });
  
  static i a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    int i = 1;
    boolean bool1 = false;
    boolean bool2 = false;
    while (paramJsonReader.j())
    {
      int j = paramJsonReader.y(a);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j != 5)
                {
                  paramJsonReader.z();
                  paramJsonReader.A();
                }
                else
                {
                  bool2 = paramJsonReader.k();
                }
              }
              else {
                i = paramJsonReader.s();
              }
            }
            else {
              bool1 = paramJsonReader.k();
            }
          }
          else {
            localObject2 = d.h(paramJsonReader, paramd);
          }
        }
        else {
          localObject1 = d.c(paramJsonReader, paramd);
        }
      }
      else {
        str = paramJsonReader.u();
      }
    }
    if (i == 1) {
      paramJsonReader = Path.FillType.WINDING;
    } else {
      paramJsonReader = Path.FillType.EVEN_ODD;
    }
    return new i(str, bool1, paramJsonReader, (a)localObject1, (com.airbnb.lottie.model.i.d)localObject2, bool2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */