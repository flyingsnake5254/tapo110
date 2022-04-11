package com.airbnb.lottie.u;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.b;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import com.airbnb.lottie.v.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers" });
  static JsonReader.a b = JsonReader.a.a(new String[] { "id", "layers", "w", "h", "p", "u" });
  private static final JsonReader.a c = JsonReader.a.a(new String[] { "list" });
  private static final JsonReader.a d = JsonReader.a.a(new String[] { "cm", "tm", "dr" });
  
  public static com.airbnb.lottie.d a(JsonReader paramJsonReader)
    throws IOException
  {
    float f1 = h.e();
    LongSparseArray localLongSparseArray = new LongSparseArray();
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    ArrayList localArrayList2 = new ArrayList();
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat();
    com.airbnb.lottie.d locald = new com.airbnb.lottie.d();
    paramJsonReader.e();
    int i = 0;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    int j = 0;
    for (;;)
    {
      Object localObject = paramJsonReader;
      if (!paramJsonReader.j()) {
        break;
      }
      switch (((JsonReader)localObject).y(a))
      {
      default: 
        paramJsonReader.z();
        paramJsonReader.A();
        break;
      case 10: 
        f((JsonReader)localObject, locald, localArrayList2);
        break;
      case 9: 
        c((JsonReader)localObject, locald, localSparseArrayCompat);
        break;
      case 8: 
        d((JsonReader)localObject, localHashMap3);
        break;
      case 7: 
        b((JsonReader)localObject, locald, localHashMap1, localHashMap2);
        break;
      case 6: 
        e((JsonReader)localObject, locald, localArrayList1, localLongSparseArray);
        break;
      case 5: 
        localObject = paramJsonReader.u().split("\\.");
        if (!h.j(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Integer.parseInt(localObject[2]), 4, 4, 0)) {
          locald.a("Lottie only supports bodymovin >= 4.4.0");
        }
        break;
      case 4: 
        f4 = (float)paramJsonReader.l();
        break;
      case 3: 
        f3 = (float)paramJsonReader.l() - 0.01F;
        break;
      case 2: 
        f2 = (float)paramJsonReader.l();
        break;
      case 1: 
        j = paramJsonReader.s();
        break;
      }
      i = paramJsonReader.s();
    }
    locald.r(new Rect(0, 0, (int)(i * f1), (int)(j * f1)), f2, f3, f4, localArrayList1, localLongSparseArray, localHashMap1, localHashMap2, localSparseArrayCompat, localHashMap3, localArrayList2);
    return locald;
  }
  
  private static void b(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, Map<String, List<Layer>> paramMap, Map<String, com.airbnb.lottie.g> paramMap1)
    throws IOException
  {
    paramJsonReader.c();
    while (paramJsonReader.j())
    {
      ArrayList localArrayList = new ArrayList();
      LongSparseArray localLongSparseArray = new LongSparseArray();
      paramJsonReader.e();
      String str = null;
      Object localObject1 = str;
      Object localObject2 = localObject1;
      int i = 0;
      int j = 0;
      while (paramJsonReader.j())
      {
        int k = paramJsonReader.y(b);
        if (k != 0)
        {
          if (k != 1)
          {
            if (k != 2)
            {
              if (k != 3)
              {
                if (k != 4)
                {
                  if (k != 5)
                  {
                    paramJsonReader.z();
                    paramJsonReader.A();
                  }
                  else
                  {
                    localObject2 = paramJsonReader.u();
                  }
                }
                else {
                  localObject1 = paramJsonReader.u();
                }
              }
              else {
                j = paramJsonReader.s();
              }
            }
            else {
              i = paramJsonReader.s();
            }
          }
          else
          {
            paramJsonReader.c();
            while (paramJsonReader.j())
            {
              Layer localLayer = s.b(paramJsonReader, paramd);
              localLongSparseArray.put(localLayer.b(), localLayer);
              localArrayList.add(localLayer);
            }
            paramJsonReader.g();
          }
        }
        else {
          str = paramJsonReader.u();
        }
      }
      paramJsonReader.i();
      if (localObject1 != null)
      {
        localObject1 = new com.airbnb.lottie.g(i, j, str, (String)localObject1, (String)localObject2);
        paramMap1.put(((com.airbnb.lottie.g)localObject1).d(), localObject1);
      }
      else
      {
        paramMap.put(str, localArrayList);
      }
    }
    paramJsonReader.g();
  }
  
  private static void c(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, SparseArrayCompat<c> paramSparseArrayCompat)
    throws IOException
  {
    paramJsonReader.c();
    while (paramJsonReader.j())
    {
      c localc = j.a(paramJsonReader, paramd);
      paramSparseArrayCompat.put(localc.hashCode(), localc);
    }
    paramJsonReader.g();
  }
  
  private static void d(JsonReader paramJsonReader, Map<String, b> paramMap)
    throws IOException
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
        paramJsonReader.c();
        while (paramJsonReader.j())
        {
          b localb = k.a(paramJsonReader);
          paramMap.put(localb.b(), localb);
        }
        paramJsonReader.g();
      }
    }
    paramJsonReader.i();
  }
  
  private static void e(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray)
    throws IOException
  {
    paramJsonReader.c();
    int i = 0;
    while (paramJsonReader.j())
    {
      Object localObject = s.b(paramJsonReader, paramd);
      int j = i;
      if (((Layer)localObject).d() == Layer.LayerType.IMAGE) {
        j = i + 1;
      }
      paramList.add(localObject);
      paramLongSparseArray.put(((Layer)localObject).b(), localObject);
      i = j;
      if (j > 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("You have ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
        com.airbnb.lottie.v.d.c(((StringBuilder)localObject).toString());
        i = j;
      }
    }
    paramJsonReader.g();
  }
  
  private static void f(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, List<com.airbnb.lottie.model.g> paramList)
    throws IOException
  {
    paramJsonReader.c();
    while (paramJsonReader.j())
    {
      paramd = null;
      paramJsonReader.e();
      float f1 = 0.0F;
      float f2 = 0.0F;
      while (paramJsonReader.j())
      {
        int i = paramJsonReader.y(d);
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              paramJsonReader.z();
              paramJsonReader.A();
            }
            else
            {
              f2 = (float)paramJsonReader.l();
            }
          }
          else {
            f1 = (float)paramJsonReader.l();
          }
        }
        else {
          paramd = paramJsonReader.u();
        }
      }
      paramJsonReader.i();
      paramList.add(new com.airbnb.lottie.model.g(paramd, f1, f2));
    }
    paramJsonReader.g();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */