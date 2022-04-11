package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import java.io.IOException;

public class y
  implements j0<PointF>
{
  public static final y a = new y();
  
  public PointF b(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    Object localObject = paramJsonReader.w();
    if (localObject == JsonReader.Token.BEGIN_ARRAY) {
      return p.e(paramJsonReader, paramFloat);
    }
    if (localObject == JsonReader.Token.BEGIN_OBJECT) {
      return p.e(paramJsonReader, paramFloat);
    }
    if (localObject == JsonReader.Token.NUMBER)
    {
      localObject = new PointF((float)paramJsonReader.l() * paramFloat, (float)paramJsonReader.l() * paramFloat);
      while (paramJsonReader.j()) {
        paramJsonReader.A();
      }
      return (PointF)localObject;
    }
    paramJsonReader = new StringBuilder();
    paramJsonReader.append("Cannot convert json to point. Next token is ");
    paramJsonReader.append(localObject);
    throw new IllegalArgumentException(paramJsonReader.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */