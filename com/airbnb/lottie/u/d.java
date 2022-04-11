package com.airbnb.lottie.u;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.c;
import com.airbnb.lottie.model.i.g;
import com.airbnb.lottie.model.i.j;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;

public class d
{
  @Nullable
  private static <T> List<com.airbnb.lottie.w.a<T>> a(JsonReader paramJsonReader, float paramFloat, com.airbnb.lottie.d paramd, j0<T> paramj0)
    throws IOException
  {
    return r.a(paramJsonReader, paramd, paramFloat, paramj0);
  }
  
  @Nullable
  private static <T> List<com.airbnb.lottie.w.a<T>> b(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, j0<T> paramj0)
    throws IOException
  {
    return r.a(paramJsonReader, paramd, 1.0F, paramj0);
  }
  
  static com.airbnb.lottie.model.i.a c(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    return new com.airbnb.lottie.model.i.a(b(paramJsonReader, paramd, f.a));
  }
  
  static j d(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    return new j(b(paramJsonReader, paramd, h.a));
  }
  
  public static b e(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    return f(paramJsonReader, paramd, true);
  }
  
  public static b f(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, boolean paramBoolean)
    throws IOException
  {
    float f;
    if (paramBoolean) {
      f = com.airbnb.lottie.v.h.e();
    } else {
      f = 1.0F;
    }
    return new b(a(paramJsonReader, f, paramd, i.a));
  }
  
  static c g(JsonReader paramJsonReader, com.airbnb.lottie.d paramd, int paramInt)
    throws IOException
  {
    return new c(b(paramJsonReader, paramd, new l(paramInt)));
  }
  
  static com.airbnb.lottie.model.i.d h(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    return new com.airbnb.lottie.model.i.d(b(paramJsonReader, paramd, o.a));
  }
  
  static com.airbnb.lottie.model.i.f i(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    return new com.airbnb.lottie.model.i.f(a(paramJsonReader, com.airbnb.lottie.v.h.e(), paramd, y.a));
  }
  
  static g j(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    return new g(b(paramJsonReader, paramd, c0.a));
  }
  
  static com.airbnb.lottie.model.i.h k(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    return new com.airbnb.lottie.model.i.h(a(paramJsonReader, com.airbnb.lottie.v.h.e(), paramd, d0.a));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */