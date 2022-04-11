package com.airbnb.lottie.u;

import com.airbnb.lottie.model.i.a;
import com.airbnb.lottie.model.i.k;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

public class b
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "a" });
  private static JsonReader.a b = JsonReader.a.a(new String[] { "fc", "sc", "sw", "t" });
  
  public static k a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    paramJsonReader.e();
    k localk = null;
    while (paramJsonReader.j()) {
      if (paramJsonReader.y(a) != 0)
      {
        paramJsonReader.z();
        paramJsonReader.A();
      }
      else
      {
        localk = b(paramJsonReader, paramd);
      }
    }
    paramJsonReader.i();
    if (localk == null) {
      return new k(null, null, null, null);
    }
    return localk;
  }
  
  private static k b(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    paramJsonReader.e();
    a locala1 = null;
    a locala2 = null;
    Object localObject1 = locala2;
    Object localObject2 = localObject1;
    while (paramJsonReader.j())
    {
      int i = paramJsonReader.y(b);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              paramJsonReader.z();
              paramJsonReader.A();
            }
            else
            {
              localObject2 = d.e(paramJsonReader, paramd);
            }
          }
          else {
            localObject1 = d.e(paramJsonReader, paramd);
          }
        }
        else {
          locala2 = d.c(paramJsonReader, paramd);
        }
      }
      else {
        locala1 = d.c(paramJsonReader, paramd);
      }
    }
    paramJsonReader.i();
    return new k(locala1, locala2, (com.airbnb.lottie.model.i.b)localObject1, (com.airbnb.lottie.model.i.b)localObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */