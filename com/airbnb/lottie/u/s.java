package com.airbnb.lottie.u;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.i.j;
import com.airbnb.lottie.model.i.k;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import com.airbnb.lottie.v.h;
import com.airbnb.lottie.w.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class s
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd" });
  private static final JsonReader.a b = JsonReader.a.a(new String[] { "d", "a" });
  private static final JsonReader.a c = JsonReader.a.a(new String[] { "nm" });
  
  public static Layer a(com.airbnb.lottie.d paramd)
  {
    Rect localRect = paramd.b();
    return new Layer(Collections.emptyList(), paramd, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new l(), 0, 0, 0, 0.0F, 0.0F, localRect.width(), localRect.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
  }
  
  public static Layer b(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    Layer.MatteType localMatteType = Layer.MatteType.NONE;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramJsonReader.e();
    Float localFloat1 = Float.valueOf(1.0F);
    Float localFloat2 = Float.valueOf(0.0F);
    Object localObject1 = null;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    Object localObject6 = localObject5;
    long l1 = -1L;
    float f1 = 0.0F;
    float f2 = 0.0F;
    int i = 0;
    int j = 0;
    int k = 0;
    float f3 = 1.0F;
    float f4 = 0.0F;
    int m = 0;
    int n = 0;
    boolean bool = false;
    long l2 = 0L;
    Object localObject7 = localObject6;
    Object localObject8 = "UNSET";
    Object localObject9 = localObject4;
    localObject4 = localObject2;
    localObject2 = localObject1;
    localObject1 = localObject8;
    while (paramJsonReader.j())
    {
      int i1;
      switch (paramJsonReader.y(a))
      {
      default: 
        paramJsonReader.z();
        paramJsonReader.A();
        break;
      case 22: 
        bool = paramJsonReader.k();
        break;
      case 21: 
        localObject7 = paramJsonReader.u();
        break;
      case 20: 
        localObject6 = d.f(paramJsonReader, paramd, false);
        break;
      case 19: 
        f2 = (float)paramJsonReader.l();
        break;
      case 18: 
        f1 = (float)paramJsonReader.l();
        break;
      case 17: 
        n = (int)(paramJsonReader.s() * h.e());
        break;
      case 16: 
        m = (int)(paramJsonReader.s() * h.e());
        break;
      case 15: 
        f4 = (float)paramJsonReader.l();
        break;
      case 14: 
        f3 = (float)paramJsonReader.l();
        break;
      case 13: 
        paramJsonReader.c();
        ArrayList localArrayList3 = new ArrayList();
        while (paramJsonReader.j())
        {
          paramJsonReader.e();
          while (paramJsonReader.j()) {
            if (paramJsonReader.y(c) != 0)
            {
              paramJsonReader.z();
              paramJsonReader.A();
            }
            else
            {
              localArrayList3.add(paramJsonReader.u());
            }
          }
          paramJsonReader.i();
        }
        paramJsonReader.g();
        localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
        ((StringBuilder)localObject8).append(localArrayList3);
        paramd.a(((StringBuilder)localObject8).toString());
        break;
      case 12: 
        paramJsonReader.e();
        while (paramJsonReader.j())
        {
          i1 = paramJsonReader.y(b);
          if (i1 != 0)
          {
            if (i1 != 1)
            {
              paramJsonReader.z();
              paramJsonReader.A();
            }
            else
            {
              paramJsonReader.c();
              if (paramJsonReader.j()) {
                localObject5 = b.a(paramJsonReader, paramd);
              }
              while (paramJsonReader.j()) {
                paramJsonReader.A();
              }
              paramJsonReader.g();
            }
          }
          else {
            localObject9 = d.d(paramJsonReader, paramd);
          }
        }
        paramJsonReader.i();
        break;
      case 11: 
        paramJsonReader.c();
        while (paramJsonReader.j())
        {
          localObject8 = g.a(paramJsonReader, paramd);
          if (localObject8 != null) {
            localArrayList2.add(localObject8);
          }
        }
        paramJsonReader.g();
        break;
      case 10: 
        paramJsonReader.c();
        while (paramJsonReader.j()) {
          localArrayList1.add(u.a(paramJsonReader, paramd));
        }
        paramd.q(localArrayList1.size());
        paramJsonReader.g();
        break;
      case 9: 
        localMatteType = Layer.MatteType.values()[paramJsonReader.s()];
        paramd.q(1);
        break;
      case 8: 
        localObject3 = c.g(paramJsonReader, paramd);
        break;
      case 7: 
        k = Color.parseColor(paramJsonReader.u());
        break;
      case 6: 
        j = (int)(paramJsonReader.s() * h.e());
        break;
      case 5: 
        i = (int)(paramJsonReader.s() * h.e());
        break;
      case 4: 
        l1 = paramJsonReader.s();
        break;
      case 3: 
        i1 = paramJsonReader.s();
        localObject8 = Layer.LayerType.UNKNOWN;
        localObject2 = localObject8;
        if (i1 < ((Enum)localObject8).ordinal()) {
          localObject2 = Layer.LayerType.values()[i1];
        }
        break;
      case 2: 
        localObject4 = paramJsonReader.u();
        break;
      case 1: 
        l2 = paramJsonReader.s();
        break;
      case 0: 
        localObject1 = paramJsonReader.u();
      }
    }
    paramJsonReader.i();
    f1 /= f3;
    f2 /= f3;
    paramJsonReader = new ArrayList();
    if (f1 > 0.0F) {
      paramJsonReader.add(new a(paramd, localFloat2, localFloat2, null, 0.0F, Float.valueOf(f1)));
    }
    if (f2 <= 0.0F) {
      f2 = paramd.f();
    }
    paramJsonReader.add(new a(paramd, localFloat1, localFloat1, null, f1, Float.valueOf(f2)));
    paramJsonReader.add(new a(paramd, localFloat2, localFloat2, null, f2, Float.valueOf(Float.MAX_VALUE)));
    if ((((String)localObject1).endsWith(".ai")) || ("ai".equals(localObject7))) {
      paramd.a("Convert your Illustrator layers to shape layers.");
    }
    return new Layer(localArrayList2, paramd, (String)localObject1, l2, (Layer.LayerType)localObject2, l1, (String)localObject4, localArrayList1, (l)localObject3, i, j, k, f3, f4, m, n, (j)localObject9, (k)localObject5, paramJsonReader, localMatteType, (com.airbnb.lottie.model.i.b)localObject6, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */