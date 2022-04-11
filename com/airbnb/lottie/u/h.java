package com.airbnb.lottie.u;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.DocumentData.Justification;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

public class h
  implements j0<DocumentData>
{
  public static final h a = new h();
  private static final JsonReader.a b = JsonReader.a.a(new String[] { "t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of" });
  
  public DocumentData b(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    Object localObject = DocumentData.Justification.CENTER;
    paramJsonReader.e();
    String str1 = null;
    String str2 = str1;
    float f1 = 0.0F;
    int i = 0;
    float f2 = 0.0F;
    float f3 = 0.0F;
    int j = 0;
    int k = 0;
    paramFloat = 0.0F;
    boolean bool = true;
    while (paramJsonReader.j()) {
      switch (paramJsonReader.y(b))
      {
      default: 
        paramJsonReader.z();
        paramJsonReader.A();
        break;
      case 10: 
        bool = paramJsonReader.k();
        break;
      case 9: 
        paramFloat = (float)paramJsonReader.l();
        break;
      case 8: 
        k = p.d(paramJsonReader);
        break;
      case 7: 
        j = p.d(paramJsonReader);
        break;
      case 6: 
        f3 = (float)paramJsonReader.l();
        break;
      case 5: 
        f2 = (float)paramJsonReader.l();
        break;
      case 4: 
        i = paramJsonReader.s();
        break;
      case 3: 
        int m = paramJsonReader.s();
        DocumentData.Justification localJustification = DocumentData.Justification.CENTER;
        localObject = localJustification;
        if (m <= localJustification.ordinal()) {
          if (m < 0) {
            localObject = localJustification;
          } else {
            localObject = DocumentData.Justification.values()[m];
          }
        }
        break;
      case 2: 
        f1 = (float)paramJsonReader.l();
        break;
      case 1: 
        str2 = paramJsonReader.u();
        break;
      case 0: 
        str1 = paramJsonReader.u();
      }
    }
    paramJsonReader.i();
    return new DocumentData(str1, str2, f1, (DocumentData.Justification)localObject, i, f2, f3, j, k, paramFloat, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */