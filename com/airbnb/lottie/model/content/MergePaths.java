package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.l;
import com.airbnb.lottie.v.d;

public class MergePaths
  implements b
{
  private final String a;
  private final MergePathsMode b;
  private final boolean c;
  
  public MergePaths(String paramString, MergePathsMode paramMergePathsMode, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramMergePathsMode;
    this.c = paramBoolean;
  }
  
  @Nullable
  public c a(f paramf, a parama)
  {
    if (!paramf.k())
    {
      d.c("Animation contains merge paths but they are disabled.");
      return null;
    }
    return new l(this);
  }
  
  public MergePathsMode b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MergePaths{mode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static enum MergePathsMode
  {
    static
    {
      MergePathsMode localMergePathsMode1 = new MergePathsMode("MERGE", 0);
      MERGE = localMergePathsMode1;
      MergePathsMode localMergePathsMode2 = new MergePathsMode("ADD", 1);
      ADD = localMergePathsMode2;
      MergePathsMode localMergePathsMode3 = new MergePathsMode("SUBTRACT", 2);
      SUBTRACT = localMergePathsMode3;
      MergePathsMode localMergePathsMode4 = new MergePathsMode("INTERSECT", 3);
      INTERSECT = localMergePathsMode4;
      MergePathsMode localMergePathsMode5 = new MergePathsMode("EXCLUDE_INTERSECTIONS", 4);
      EXCLUDE_INTERSECTIONS = localMergePathsMode5;
      $VALUES = new MergePathsMode[] { localMergePathsMode1, localMergePathsMode2, localMergePathsMode3, localMergePathsMode4, localMergePathsMode5 };
    }
    
    public static MergePathsMode forId(int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return MERGE;
              }
              return EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
          }
          return SUBTRACT;
        }
        return ADD;
      }
      return MERGE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\MergePaths.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */