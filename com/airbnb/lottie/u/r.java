package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import com.airbnb.lottie.s.c.h;
import com.airbnb.lottie.w.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class r
{
  static JsonReader.a a = JsonReader.a.a(new String[] { "k" });
  
  static <T> List<a<T>> a(JsonReader paramJsonReader, d paramd, float paramFloat, j0<T> paramj0)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.w() == JsonReader.Token.STRING)
    {
      paramd.a("Lottie doesn't support expressions.");
      return localArrayList;
    }
    paramJsonReader.e();
    while (paramJsonReader.j()) {
      if (paramJsonReader.y(a) != 0)
      {
        paramJsonReader.A();
      }
      else if (paramJsonReader.w() == JsonReader.Token.BEGIN_ARRAY)
      {
        paramJsonReader.c();
        if (paramJsonReader.w() == JsonReader.Token.NUMBER) {
          localArrayList.add(q.b(paramJsonReader, paramd, paramFloat, paramj0, false));
        } else {
          while (paramJsonReader.j()) {
            localArrayList.add(q.b(paramJsonReader, paramd, paramFloat, paramj0, true));
          }
        }
        paramJsonReader.g();
      }
      else
      {
        localArrayList.add(q.b(paramJsonReader, paramd, paramFloat, paramj0, false));
      }
    }
    paramJsonReader.i();
    b(localArrayList);
    return localArrayList;
  }
  
  public static <T> void b(List<? extends a<T>> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k;
    for (;;)
    {
      k = i - 1;
      if (j >= k) {
        break;
      }
      locala = (a)paramList.get(j);
      k = j + 1;
      Object localObject = (a)paramList.get(k);
      locala.f = Float.valueOf(((a)localObject).e);
      j = k;
      if (locala.c == null)
      {
        localObject = ((a)localObject).b;
        j = k;
        if (localObject != null)
        {
          locala.c = localObject;
          j = k;
          if ((locala instanceof h))
          {
            ((h)locala).i();
            j = k;
          }
        }
      }
    }
    a locala = (a)paramList.get(k);
    if (((locala.b == null) || (locala.c == null)) && (paramList.size() > 1)) {
      paramList.remove(locala);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */