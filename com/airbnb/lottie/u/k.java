package com.airbnb.lottie.u;

import com.airbnb.lottie.model.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class k
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "fFamily", "fName", "fStyle", "ascent" });
  
  static b a(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader.e();
    String str1 = null;
    String str2 = null;
    String str3 = str2;
    float f = 0.0F;
    while (paramJsonReader.j())
    {
      int i = paramJsonReader.y(a);
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
              f = (float)paramJsonReader.l();
            }
          }
          else {
            str3 = paramJsonReader.u();
          }
        }
        else {
          str2 = paramJsonReader.u();
        }
      }
      else {
        str1 = paramJsonReader.u();
      }
    }
    paramJsonReader.i();
    return new b(str1, str2, str3, f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */