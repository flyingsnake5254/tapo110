package androidx.core.util;

import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DebugUtils
{
  public static void buildShortClassTag(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
    }
    else
    {
      String str1 = paramObject.getClass().getSimpleName();
      String str2 = str1;
      if (str1.length() <= 0)
      {
        str1 = paramObject.getClass().getName();
        int i = str1.lastIndexOf('.');
        str2 = str1;
        if (i > 0) {
          str2 = str1.substring(i + 1);
        }
      }
      paramStringBuilder.append(str2);
      paramStringBuilder.append('{');
      paramStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\DebugUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */