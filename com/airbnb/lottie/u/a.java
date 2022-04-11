package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.e;
import com.airbnb.lottie.model.i.i;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import com.airbnb.lottie.v.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "k", "x", "y" });
  
  public static e a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.w() == JsonReader.Token.BEGIN_ARRAY)
    {
      paramJsonReader.c();
      while (paramJsonReader.j()) {
        localArrayList.add(w.a(paramJsonReader, paramd));
      }
      paramJsonReader.g();
      r.b(localArrayList);
    }
    else
    {
      localArrayList.add(new com.airbnb.lottie.w.a(p.e(paramJsonReader, h.e())));
    }
    return new e(localArrayList);
  }
  
  static m<PointF, PointF> b(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    paramJsonReader.e();
    e locale = null;
    b localb1 = null;
    b localb2 = localb1;
    int i = 0;
    while (paramJsonReader.w() != JsonReader.Token.END_OBJECT)
    {
      int j = paramJsonReader.y(a);
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            paramJsonReader.z();
            paramJsonReader.A();
            continue;
          }
          if (paramJsonReader.w() == JsonReader.Token.STRING) {
            paramJsonReader.A();
          } else {
            localb2 = d.e(paramJsonReader, paramd);
          }
        }
        else
        {
          if (paramJsonReader.w() != JsonReader.Token.STRING) {
            break label108;
          }
          paramJsonReader.A();
        }
        i = 1;
        continue;
        label108:
        localb1 = d.e(paramJsonReader, paramd);
      }
      else
      {
        locale = a(paramJsonReader, paramd);
      }
    }
    paramJsonReader.i();
    if (i != 0) {
      paramd.a("Lottie doesn't support expressions.");
    }
    if (locale != null) {
      return locale;
    }
    return new i(localb1, localb2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */