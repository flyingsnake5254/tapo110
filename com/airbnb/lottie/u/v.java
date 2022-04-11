package com.airbnb.lottie.u;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.MergePaths.MergePathsMode;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import java.io.IOException;

class v
{
  private static final JsonReader.a a = JsonReader.a.a(new String[] { "nm", "mm", "hd" });
  
  static MergePaths a(JsonReader paramJsonReader)
    throws IOException
  {
    String str = null;
    MergePaths.MergePathsMode localMergePathsMode = null;
    boolean bool = false;
    while (paramJsonReader.j())
    {
      int i = paramJsonReader.y(a);
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
            bool = paramJsonReader.k();
          }
        }
        else {
          localMergePathsMode = MergePaths.MergePathsMode.forId(paramJsonReader.s());
        }
      }
      else {
        str = paramJsonReader.u();
      }
    }
    return new MergePaths(str, localMergePathsMode, bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */