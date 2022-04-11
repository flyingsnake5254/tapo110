package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.Mask.MaskMode;
import com.airbnb.lottie.model.i.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class u
{
  static Mask a(JsonReader paramJsonReader, com.airbnb.lottie.d paramd)
    throws IOException
  {
    paramJsonReader.e();
    Object localObject1 = null;
    h localh = null;
    Object localObject2 = localh;
    boolean bool = false;
    while (paramJsonReader.j())
    {
      String str = paramJsonReader.t();
      str.hashCode();
      int i = str.hashCode();
      int j = 3;
      switch (i)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              i = -1;
              break;
            } while (!str.equals("mode"));
            i = 3;
            break;
          } while (!str.equals("inv"));
          i = 2;
          break;
        } while (!str.equals("pt"));
        i = 1;
        break;
      } while (!str.equals("o"));
      i = 0;
      switch (i)
      {
      default: 
        paramJsonReader.A();
        break;
      case 3: 
        localObject1 = paramJsonReader.u();
        ((String)localObject1).hashCode();
        switch (((String)localObject1).hashCode())
        {
        }
        do
        {
          do
          {
            do
            {
              i = -1;
              break;
              i = j;
              if (((String)localObject1).equals("s")) {
                break;
              }
            } while ((goto 264) || (!((String)localObject1).equals("n")));
            i = 2;
            break;
          } while (!((String)localObject1).equals("i"));
          i = 1;
          break;
        } while (!((String)localObject1).equals("a"));
        i = 0;
        switch (i)
        {
        default: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Unknown mask mode ");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(". Defaulting to Add.");
          com.airbnb.lottie.v.d.c(((StringBuilder)localObject1).toString());
          localObject1 = Mask.MaskMode.MASK_MODE_ADD;
          break;
        case 3: 
          localObject1 = Mask.MaskMode.MASK_MODE_SUBTRACT;
          break;
        case 2: 
          localObject1 = Mask.MaskMode.MASK_MODE_NONE;
          break;
        case 1: 
          paramd.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
          localObject1 = Mask.MaskMode.MASK_MODE_INTERSECT;
          break;
        case 0: 
          localObject1 = Mask.MaskMode.MASK_MODE_ADD;
        }
        break;
      case 2: 
        bool = paramJsonReader.k();
        break;
      case 1: 
        localh = d.k(paramJsonReader, paramd);
        break;
      case 0: 
        localObject2 = d.h(paramJsonReader, paramd);
      }
    }
    paramJsonReader.i();
    return new Mask((Mask.MaskMode)localObject1, localh, (com.airbnb.lottie.model.i.d)localObject2, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */