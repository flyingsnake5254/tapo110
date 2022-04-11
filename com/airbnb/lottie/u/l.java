package com.airbnb.lottie.u;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.v.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class l
  implements j0<c>
{
  private int a;
  
  public l(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void b(c paramc, List<Float> paramList)
  {
    int i = this.a * 4;
    if (paramList.size() <= i) {
      return;
    }
    int j = (paramList.size() - i) / 2;
    double[] arrayOfDouble1 = new double[j];
    double[] arrayOfDouble2 = new double[j];
    int k = 0;
    int m = 0;
    for (;;)
    {
      j = k;
      if (i >= paramList.size()) {
        break;
      }
      if (i % 2 == 0)
      {
        arrayOfDouble1[m] = ((Float)paramList.get(i)).floatValue();
      }
      else
      {
        arrayOfDouble2[m] = ((Float)paramList.get(i)).floatValue();
        m++;
      }
      i++;
    }
    while (j < paramc.c())
    {
      i = paramc.a()[j];
      i = Color.argb(c(paramc.b()[j], arrayOfDouble1, arrayOfDouble2), Color.red(i), Color.green(i), Color.blue(i));
      paramc.a()[j] = i;
      j++;
    }
  }
  
  @IntRange(from=0L, to=255L)
  private int c(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i = 1;
    int j;
    if (i < paramArrayOfDouble1.length)
    {
      j = i - 1;
      double d1 = paramArrayOfDouble1[j];
      double d2 = paramArrayOfDouble1[i];
      if (paramArrayOfDouble1[i] >= paramDouble) {
        paramDouble = (paramDouble - d1) / (d2 - d1);
      }
    }
    for (paramDouble = g.i(paramArrayOfDouble2[j], paramArrayOfDouble2[i], paramDouble);; paramDouble = paramArrayOfDouble2[(paramArrayOfDouble2.length - 1)])
    {
      return (int)(paramDouble * 255.0D);
      i++;
      break;
    }
  }
  
  public c d(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    JsonReader.Token localToken = paramJsonReader.w();
    Object localObject = JsonReader.Token.BEGIN_ARRAY;
    int i = 0;
    if (localToken == localObject) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      paramJsonReader.c();
    }
    while (paramJsonReader.j()) {
      localArrayList.add(Float.valueOf((float)paramJsonReader.l()));
    }
    if (j != 0) {
      paramJsonReader.g();
    }
    if (this.a == -1) {
      this.a = (localArrayList.size() / 4);
    }
    int j = this.a;
    paramJsonReader = new float[j];
    localObject = new int[j];
    int k = 0;
    int m = 0;
    j = i;
    i = k;
    while (j < this.a * 4)
    {
      int n = j / 4;
      double d = ((Float)localArrayList.get(j)).floatValue();
      k = j % 4;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k == 3) {
              localObject[n] = Color.argb(255, i, m, (int)(d * 255.0D));
            }
          }
          else {
            m = (int)(d * 255.0D);
          }
        }
        else {
          i = (int)(d * 255.0D);
        }
      }
      else {
        paramJsonReader[n] = ((float)d);
      }
      j++;
    }
    paramJsonReader = new c(paramJsonReader, (int[])localObject);
    b(paramJsonReader, localArrayList);
    return paramJsonReader;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */