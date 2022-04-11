package com.airbnb.lottie.u;

import android.graphics.Path.FillType;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.i.c;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class m
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "nm", "g", "o", "t", "s", "e", "r", "hd" });
  private static final JsonReader.a b = JsonReader.a.a(new String[] { "p", "k" });
  
  static com.airbnb.lottie.model.content.d a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    Object localObject1 = Path.FillType.WINDING;
    String str = null;
    Object localObject2 = str;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    Object localObject6 = localObject5;
    boolean bool = false;
    Object localObject7 = localObject2;
    while (paramJsonReader.j()) {
      switch (paramJsonReader.y(a))
      {
      default: 
        paramJsonReader.z();
        paramJsonReader.A();
        break;
      case 7: 
        bool = paramJsonReader.k();
        break;
      case 6: 
        if (paramJsonReader.s() == 1) {
          localObject2 = Path.FillType.WINDING;
        } else {
          localObject2 = Path.FillType.EVEN_ODD;
        }
        localObject1 = localObject2;
        break;
      case 5: 
        localObject6 = d.i(paramJsonReader, paramd);
        break;
      case 4: 
        localObject5 = d.i(paramJsonReader, paramd);
        break;
      case 3: 
        if (paramJsonReader.s() == 1) {
          localObject2 = GradientType.LINEAR;
        } else {
          localObject2 = GradientType.RADIAL;
        }
        localObject7 = localObject2;
        break;
      case 2: 
        localObject4 = d.h(paramJsonReader, paramd);
        break;
      case 1: 
        int i = -1;
        paramJsonReader.e();
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
              localObject3 = d.g(paramJsonReader, paramd, i);
            }
          }
          else {
            i = paramJsonReader.s();
          }
        }
        paramJsonReader.i();
        break;
      case 0: 
        str = paramJsonReader.u();
      }
    }
    return new com.airbnb.lottie.model.content.d(str, (GradientType)localObject7, (Path.FillType)localObject1, (c)localObject3, (com.airbnb.lottie.model.i.d)localObject4, (f)localObject5, (f)localObject6, null, null, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */