package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.model.a;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import com.airbnb.lottie.v.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d0
  implements j0<h>
{
  public static final d0 a = new d0();
  private static final JsonReader.a b = JsonReader.a.a(new String[] { "c", "v", "i", "o" });
  
  public h b(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    if (paramJsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
      paramJsonReader.c();
    }
    paramJsonReader.e();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    boolean bool = false;
    int i;
    while (paramJsonReader.j())
    {
      i = paramJsonReader.y(b);
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
              localObject3 = p.f(paramJsonReader, paramFloat);
            }
          }
          else {
            localObject2 = p.f(paramJsonReader, paramFloat);
          }
        }
        else {
          localObject1 = p.f(paramJsonReader, paramFloat);
        }
      }
      else {
        bool = paramJsonReader.k();
      }
    }
    paramJsonReader.i();
    if (paramJsonReader.w() == JsonReader.Token.END_ARRAY) {
      paramJsonReader.g();
    }
    if ((localObject1 != null) && (localObject2 != null) && (localObject3 != null))
    {
      if (((List)localObject1).isEmpty()) {
        return new h(new PointF(), false, Collections.emptyList());
      }
      int j = ((List)localObject1).size();
      PointF localPointF1 = (PointF)((List)localObject1).get(0);
      paramJsonReader = new ArrayList(j);
      PointF localPointF5;
      for (i = 1; i < j; i++)
      {
        PointF localPointF2 = (PointF)((List)localObject1).get(i);
        int k = i - 1;
        PointF localPointF3 = (PointF)((List)localObject1).get(k);
        PointF localPointF4 = (PointF)((List)localObject3).get(k);
        localPointF5 = (PointF)((List)localObject2).get(i);
        paramJsonReader.add(new a(g.a(localPointF3, localPointF4), g.a(localPointF2, localPointF5), localPointF2));
      }
      if (bool)
      {
        localPointF5 = (PointF)((List)localObject1).get(0);
        i = j - 1;
        localObject1 = (PointF)((List)localObject1).get(i);
        localObject3 = (PointF)((List)localObject3).get(i);
        localObject2 = (PointF)((List)localObject2).get(0);
        paramJsonReader.add(new a(g.a((PointF)localObject1, (PointF)localObject3), g.a(localPointF5, (PointF)localObject2), localPointF5));
      }
      return new h(localPointF1, bool, paramJsonReader);
    }
    throw new IllegalArgumentException("Shape data was missing information.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */