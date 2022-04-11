package com.airbnb.lottie.u;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class g
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "ty", "d" });
  
  @Nullable
  static b a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    paramJsonReader.e();
    int i = 2;
    int j = 2;
    Object localObject1;
    for (;;)
    {
      boolean bool = paramJsonReader.j();
      localObject1 = null;
      if (!bool) {
        break label70;
      }
      int k = paramJsonReader.y(a);
      if (k == 0) {
        break;
      }
      if (k != 1)
      {
        paramJsonReader.z();
        paramJsonReader.A();
      }
      else
      {
        j = paramJsonReader.s();
      }
    }
    Object localObject2 = paramJsonReader.u();
    break label73;
    label70:
    localObject2 = null;
    label73:
    if (localObject2 == null) {
      return null;
    }
    switch (((String)localObject2).hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            i = -1;
                            break;
                          } while (!((String)localObject2).equals("tr"));
                          i = 12;
                          break;
                        } while (!((String)localObject2).equals("tm"));
                        i = 11;
                        break;
                      } while (!((String)localObject2).equals("st"));
                      i = 10;
                      break;
                    } while (!((String)localObject2).equals("sr"));
                    i = 9;
                    break;
                  } while (!((String)localObject2).equals("sh"));
                  i = 8;
                  break;
                } while (!((String)localObject2).equals("rp"));
                i = 7;
                break;
              } while (!((String)localObject2).equals("rc"));
              i = 6;
              break;
            } while (!((String)localObject2).equals("mm"));
            i = 5;
            break;
          } while (!((String)localObject2).equals("gs"));
          i = 4;
          break;
        } while (!((String)localObject2).equals("gr"));
        i = 3;
        break;
        if (((String)localObject2).equals("gf")) {
          break;
        }
      } while ((goto 200) || (!((String)localObject2).equals("fl")));
      i = 1;
      break;
    } while (!((String)localObject2).equals("el"));
    i = 0;
    switch (i)
    {
    default: 
      paramd = new StringBuilder();
      paramd.append("Unknown shape type ");
      paramd.append((String)localObject2);
      com.airbnb.lottie.v.d.c(paramd.toString());
      paramd = (com.airbnb.lottie.d)localObject1;
      break;
    case 12: 
      paramd = c.g(paramJsonReader, paramd);
      break;
    case 11: 
      paramd = i0.a(paramJsonReader, paramd);
      break;
    case 10: 
      paramd = h0.a(paramJsonReader, paramd);
      break;
    case 9: 
      paramd = z.a(paramJsonReader, paramd);
      break;
    case 8: 
      paramd = g0.a(paramJsonReader, paramd);
      break;
    case 7: 
      paramd = b0.a(paramJsonReader, paramd);
      break;
    case 6: 
      paramd = a0.a(paramJsonReader, paramd);
      break;
    case 5: 
      localObject2 = v.a(paramJsonReader);
      paramd.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
      paramd = (com.airbnb.lottie.d)localObject2;
      break;
    case 4: 
      paramd = n.a(paramJsonReader, paramd);
      break;
    case 3: 
      paramd = f0.a(paramJsonReader, paramd);
      break;
    case 2: 
      paramd = m.a(paramJsonReader, paramd);
      break;
    case 1: 
      paramd = e0.a(paramJsonReader, paramd);
      break;
    case 0: 
      paramd = e.a(paramJsonReader, paramd, j);
    }
    while (paramJsonReader.j()) {
      paramJsonReader.A();
    }
    paramJsonReader.i();
    return paramd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */