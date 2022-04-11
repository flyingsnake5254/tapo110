package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class z
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd" });
  
  static PolystarShape a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    String str = null;
    Object localObject1 = str;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    Object localObject6 = localObject5;
    Object localObject7 = localObject6;
    Object localObject8 = localObject7;
    boolean bool = false;
    while (paramJsonReader.j()) {
      switch (paramJsonReader.y(a))
      {
      default: 
        paramJsonReader.z();
        paramJsonReader.A();
        break;
      case 9: 
        bool = paramJsonReader.k();
        break;
      case 8: 
        localObject7 = d.f(paramJsonReader, paramd, false);
        break;
      case 7: 
        localObject5 = d.e(paramJsonReader, paramd);
        break;
      case 6: 
        localObject8 = d.f(paramJsonReader, paramd, false);
        break;
      case 5: 
        localObject6 = d.e(paramJsonReader, paramd);
        break;
      case 4: 
        localObject4 = d.f(paramJsonReader, paramd, false);
        break;
      case 3: 
        localObject3 = a.b(paramJsonReader, paramd);
        break;
      case 2: 
        localObject2 = d.f(paramJsonReader, paramd, false);
        break;
      case 1: 
        localObject1 = PolystarShape.Type.forValue(paramJsonReader.s());
        break;
      case 0: 
        str = paramJsonReader.u();
      }
    }
    return new PolystarShape(str, (PolystarShape.Type)localObject1, (b)localObject2, (m)localObject3, (b)localObject4, (b)localObject5, (b)localObject6, (b)localObject7, (b)localObject8, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */