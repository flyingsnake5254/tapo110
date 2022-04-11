package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.model.i.a;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class h0
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d" });
  private static final JsonReader.a b = JsonReader.a.a(new String[] { "n", "v" });
  
  static ShapeStroke a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject1 = null;
    a locala = null;
    com.airbnb.lottie.model.i.d locald = null;
    b localb = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    float f = 0.0F;
    boolean bool = false;
    while (paramJsonReader.j()) {
      switch (paramJsonReader.y(a))
      {
      default: 
        paramJsonReader.A();
        break;
      case 8: 
        paramJsonReader.c();
        Object localObject2 = localObject1;
        while (paramJsonReader.j())
        {
          paramJsonReader.e();
          String str2 = null;
          localObject1 = null;
          while (paramJsonReader.j())
          {
            i = paramJsonReader.y(b);
            if (i != 0)
            {
              if (i != 1)
              {
                paramJsonReader.z();
                paramJsonReader.A();
              }
              else
              {
                localObject1 = d.e(paramJsonReader, paramd);
              }
            }
            else {
              str2 = paramJsonReader.u();
            }
          }
          paramJsonReader.i();
          str2.hashCode();
          switch (str2.hashCode())
          {
          }
          do
          {
            do
            {
              do
              {
                i = -1;
                break;
              } while (!str2.equals("o"));
              i = 2;
              break;
            } while (!str2.equals("g"));
            i = 1;
            break;
          } while (!str2.equals("d"));
          int i = 0;
          switch (i)
          {
          default: 
            break;
          case 2: 
            localObject2 = localObject1;
            break;
          case 0: 
          case 1: 
            paramd.t(true);
            localArrayList.add(localObject1);
          }
        }
        paramJsonReader.g();
        localObject1 = localObject2;
        if (localArrayList.size() == 1)
        {
          localArrayList.add(localArrayList.get(0));
          localObject1 = localObject2;
        }
        break;
      case 7: 
        bool = paramJsonReader.k();
        break;
      case 6: 
        f = (float)paramJsonReader.l();
        break;
      case 5: 
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.s() - 1)];
        break;
      case 4: 
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJsonReader.s() - 1)];
        break;
      case 3: 
        locald = d.h(paramJsonReader, paramd);
        break;
      case 2: 
        localb = d.e(paramJsonReader, paramd);
        break;
      case 1: 
        locala = d.c(paramJsonReader, paramd);
        break;
      case 0: 
        str1 = paramJsonReader.u();
      }
    }
    return new ShapeStroke(str1, (b)localObject1, localArrayList, locala, locald, localb, localLineCapType, localLineJoinType, f, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */