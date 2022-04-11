package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class f0
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "nm", "hd", "it" });
  
  static j a(JsonReader paramJsonReader, d paramd)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    String str = null;
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
            paramJsonReader.A();
          }
          else
          {
            paramJsonReader.c();
            while (paramJsonReader.j())
            {
              b localb = g.a(paramJsonReader, paramd);
              if (localb != null) {
                localArrayList.add(localb);
              }
            }
            paramJsonReader.g();
          }
        }
        else {
          bool = paramJsonReader.k();
        }
      }
      else {
        str = paramJsonReader.u();
      }
    }
    return new j(str, localArrayList, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */