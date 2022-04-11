package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class j
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "ch", "size", "w", "style", "fFamily", "data" });
  private static final JsonReader.a b = JsonReader.a.a(new String[] { "shapes" });
  
  static c a(JsonReader paramJsonReader, d paramd)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.e();
    String str1 = null;
    String str2 = str1;
    double d1 = 0.0D;
    double d2 = d1;
    int i = 0;
    int j = i;
    while (paramJsonReader.j())
    {
      i = paramJsonReader.y(a);
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
                if (i != 5)
                {
                  paramJsonReader.z();
                  paramJsonReader.A();
                }
                else
                {
                  paramJsonReader.e();
                  while (paramJsonReader.j()) {
                    if (paramJsonReader.y(b) != 0)
                    {
                      paramJsonReader.z();
                      paramJsonReader.A();
                    }
                    else
                    {
                      paramJsonReader.c();
                      while (paramJsonReader.j()) {
                        localArrayList.add((com.airbnb.lottie.model.content.j)g.a(paramJsonReader, paramd));
                      }
                      paramJsonReader.g();
                    }
                  }
                  paramJsonReader.i();
                }
              }
              else {
                str2 = paramJsonReader.u();
              }
            }
            else {
              str1 = paramJsonReader.u();
            }
          }
          else {
            d2 = paramJsonReader.l();
          }
        }
        else {
          d1 = paramJsonReader.l();
        }
      }
      else
      {
        i = paramJsonReader.u().charAt(0);
        j = i;
      }
    }
    paramJsonReader.i();
    return new c(localArrayList, j, d1, d2, str1, str2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */