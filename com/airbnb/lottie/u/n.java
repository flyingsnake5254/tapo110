package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.model.content.e;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.c;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class n
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d" });
  private static final JsonReader.a b = JsonReader.a.a(new String[] { "p", "k" });
  private static final JsonReader.a c = JsonReader.a.a(new String[] { "n", "v" });
  
  static e a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    com.airbnb.lottie.model.i.d locald = null;
    f localf1 = null;
    f localf2 = null;
    b localb = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    float f = 0.0F;
    Object localObject3 = null;
    boolean bool = false;
    while (paramJsonReader.j())
    {
      Object localObject4;
      int i;
      switch (paramJsonReader.y(a))
      {
      default: 
        paramJsonReader.z();
        paramJsonReader.A();
        break;
      case 11: 
        paramJsonReader.c();
        while (paramJsonReader.j())
        {
          paramJsonReader.e();
          String str2 = null;
          localObject4 = null;
          while (paramJsonReader.j())
          {
            i = paramJsonReader.y(c);
            if (i != 0)
            {
              if (i != 1)
              {
                paramJsonReader.z();
                paramJsonReader.A();
              }
              else
              {
                localObject4 = d.e(paramJsonReader, paramd);
              }
            }
            else {
              str2 = paramJsonReader.u();
            }
          }
          paramJsonReader.i();
          if (str2.equals("o"))
          {
            localObject3 = localObject4;
          }
          else
          {
            if ((!str2.equals("d")) && (!str2.equals("g"))) {
              break label270;
            }
            paramd.t(true);
            localArrayList.add(localObject4);
          }
        }
        paramJsonReader.g();
        if (localArrayList.size() == 1) {
          localArrayList.add(localArrayList.get(0));
        }
        break;
      case 10: 
        bool = paramJsonReader.k();
        break;
      case 9: 
        f = (float)paramJsonReader.l();
        break;
      case 8: 
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.s() - 1)];
        break;
      case 7: 
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJsonReader.s() - 1)];
        break;
      case 6: 
        localb = d.e(paramJsonReader, paramd);
        break;
      case 5: 
        localf2 = d.i(paramJsonReader, paramd);
        break;
      case 4: 
        localf1 = d.i(paramJsonReader, paramd);
        break;
      case 3: 
        if (paramJsonReader.s() == 1) {
          localObject4 = GradientType.LINEAR;
        } else {
          localObject4 = GradientType.RADIAL;
        }
        localObject1 = localObject4;
        break;
      case 2: 
        locald = d.h(paramJsonReader, paramd);
        break;
      case 1: 
        i = -1;
        paramJsonReader.e();
        localObject4 = localObject2;
        while (paramJsonReader.j())
        {
          int j = paramJsonReader.y(b);
          if (j != 0)
          {
            if (j != 1)
            {
              paramJsonReader.z();
              paramJsonReader.A();
            }
            else
            {
              localObject4 = d.g(paramJsonReader, paramd, i);
            }
          }
          else {
            i = paramJsonReader.s();
          }
        }
        paramJsonReader.i();
        localObject2 = localObject4;
        break;
      case 0: 
        label270:
        str1 = paramJsonReader.u();
      }
    }
    return new e(str1, (GradientType)localObject1, (c)localObject2, locald, localf1, localf2, localb, localLineCapType, localLineJoinType, f, localArrayList, (b)localObject3, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */