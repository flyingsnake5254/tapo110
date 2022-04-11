package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.e;
import com.airbnb.lottie.model.i.g;
import com.airbnb.lottie.model.i.i;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;
import java.util.List;

public class c
{
  private static JsonReader.a a = JsonReader.a.a(new String[] { "a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa" });
  private static JsonReader.a b = JsonReader.a.a(new String[] { "k" });
  
  private static boolean a(e parame)
  {
    boolean bool1 = false;
    boolean bool2;
    if (parame != null)
    {
      bool2 = bool1;
      if (parame.c())
      {
        bool2 = bool1;
        if (!((PointF)((com.airbnb.lottie.w.a)parame.b().get(0)).b).equals(0.0F, 0.0F)) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  private static boolean b(m<PointF, PointF> paramm)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramm != null)
    {
      bool2 = bool1;
      if (!(paramm instanceof i))
      {
        bool2 = bool1;
        if (paramm.c())
        {
          bool2 = bool1;
          if (!((PointF)((com.airbnb.lottie.w.a)paramm.b().get(0)).b).equals(0.0F, 0.0F)) {}
        }
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  private static boolean c(b paramb)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramb != null)
    {
      bool2 = bool1;
      if (paramb.c())
      {
        bool2 = bool1;
        if (((Float)((com.airbnb.lottie.w.a)paramb.b().get(0)).b).floatValue() != 0.0F) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  private static boolean d(g paramg)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramg != null)
    {
      bool2 = bool1;
      if (paramg.c())
      {
        bool2 = bool1;
        if (!((com.airbnb.lottie.w.d)((com.airbnb.lottie.w.a)paramg.b().get(0)).b).a(1.0F, 1.0F)) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  private static boolean e(b paramb)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramb != null)
    {
      bool2 = bool1;
      if (paramb.c())
      {
        bool2 = bool1;
        if (((Float)((com.airbnb.lottie.w.a)paramb.b().get(0)).b).floatValue() != 0.0F) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  private static boolean f(b paramb)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramb != null)
    {
      bool2 = bool1;
      if (paramb.c())
      {
        bool2 = bool1;
        if (((Float)((com.airbnb.lottie.w.a)paramb.b().get(0)).b).floatValue() != 0.0F) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public static l g(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    int i;
    if (paramJsonReader.w() == JsonReader.Token.BEGIN_OBJECT) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJsonReader.e();
    }
    Object localObject1 = null;
    Object localObject2 = null;
    m localm = null;
    g localg = null;
    b localb1 = null;
    b localb2 = null;
    com.airbnb.lottie.model.i.d locald = null;
    b localb3 = null;
    b localb4 = null;
    while (paramJsonReader.j()) {
      switch (paramJsonReader.y(a))
      {
      default: 
        paramJsonReader.z();
        paramJsonReader.A();
        break;
      case 9: 
        localb2 = d.f(paramJsonReader, paramd, false);
        break;
      case 8: 
        localb1 = d.f(paramJsonReader, paramd, false);
        break;
      case 7: 
        localb4 = d.f(paramJsonReader, paramd, false);
        break;
      case 6: 
        localb3 = d.f(paramJsonReader, paramd, false);
        break;
      case 5: 
        locald = d.h(paramJsonReader, paramd);
        break;
      case 3: 
        paramd.a("Lottie doesn't support 3D layers.");
      case 4: 
        localObject1 = d.f(paramJsonReader, paramd, false);
        if (((b)localObject1).b().isEmpty()) {
          ((b)localObject1).b().add(new com.airbnb.lottie.w.a(paramd, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramd.f())));
        } else if (((com.airbnb.lottie.w.a)((b)localObject1).b().get(0)).b == null) {
          ((b)localObject1).b().set(0, new com.airbnb.lottie.w.a(paramd, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(paramd.f())));
        }
        break;
      case 2: 
        localg = d.j(paramJsonReader, paramd);
        break;
      case 1: 
        localm = a.b(paramJsonReader, paramd);
      case 0: 
        for (;;)
        {
          break;
          paramJsonReader.e();
          while (paramJsonReader.j()) {
            if (paramJsonReader.y(b) != 0)
            {
              paramJsonReader.z();
              paramJsonReader.A();
            }
            else
            {
              localObject2 = a.a(paramJsonReader, paramd);
            }
          }
          paramJsonReader.i();
        }
      }
    }
    if (i != 0) {
      paramJsonReader.i();
    }
    if (a((e)localObject2)) {
      paramJsonReader = null;
    } else {
      paramJsonReader = (JsonReader)localObject2;
    }
    if (b(localm)) {
      paramd = null;
    } else {
      paramd = localm;
    }
    if (c((b)localObject1)) {
      localObject2 = null;
    } else {
      localObject2 = localObject1;
    }
    localObject1 = localg;
    if (d(localg)) {
      localObject1 = null;
    }
    if (f(localb1)) {
      localb1 = null;
    }
    if (e(localb2)) {
      localb2 = null;
    }
    return new l(paramJsonReader, paramd, (g)localObject1, (b)localObject2, locald, localb3, localb4, localb1, localb2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */