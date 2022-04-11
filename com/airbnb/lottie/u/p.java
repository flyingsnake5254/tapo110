package com.airbnb.lottie.u;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class p
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "x", "y" });
  
  private static PointF a(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    paramJsonReader.c();
    float f1 = (float)paramJsonReader.l();
    float f2 = (float)paramJsonReader.l();
    while (paramJsonReader.w() != JsonReader.Token.END_ARRAY) {
      paramJsonReader.A();
    }
    paramJsonReader.g();
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF b(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    float f1 = (float)paramJsonReader.l();
    float f2 = (float)paramJsonReader.l();
    while (paramJsonReader.j()) {
      paramJsonReader.A();
    }
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF c(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    paramJsonReader.e();
    float f1 = 0.0F;
    float f2 = 0.0F;
    while (paramJsonReader.j())
    {
      int i = paramJsonReader.y(a);
      if (i != 0)
      {
        if (i != 1)
        {
          paramJsonReader.z();
          paramJsonReader.A();
        }
        else
        {
          f2 = g(paramJsonReader);
        }
      }
      else {
        f1 = g(paramJsonReader);
      }
    }
    paramJsonReader.i();
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  @ColorInt
  static int d(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.c();
    int i = (int)(paramJsonReader.l() * 255.0D);
    int j = (int)(paramJsonReader.l() * 255.0D);
    int k = (int)(paramJsonReader.l() * 255.0D);
    while (paramJsonReader.j()) {
      paramJsonReader.A();
    }
    paramJsonReader.g();
    return Color.argb(255, i, j, k);
  }
  
  static PointF e(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    int i = a.a[paramJsonReader.w().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return c(paramJsonReader, paramFloat);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown point starts with ");
        localStringBuilder.append(paramJsonReader.w());
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return a(paramJsonReader, paramFloat);
    }
    return b(paramJsonReader, paramFloat);
  }
  
  static List<PointF> f(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.c();
    while (paramJsonReader.w() == JsonReader.Token.BEGIN_ARRAY)
    {
      paramJsonReader.c();
      localArrayList.add(e(paramJsonReader, paramFloat));
      paramJsonReader.g();
    }
    paramJsonReader.g();
    return localArrayList;
  }
  
  static float g(JsonReader paramJsonReader)
    throws IOException
  {
    JsonReader.Token localToken = paramJsonReader.w();
    int i = a.a[localToken.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        paramJsonReader.c();
        float f = (float)paramJsonReader.l();
        while (paramJsonReader.j()) {
          paramJsonReader.A();
        }
        paramJsonReader.g();
        return f;
      }
      paramJsonReader = new StringBuilder();
      paramJsonReader.append("Unknown value for token of type ");
      paramJsonReader.append(localToken);
      throw new IllegalArgumentException(paramJsonReader.toString());
    }
    return (float)paramJsonReader.l();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */