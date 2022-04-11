package androidx.room.util;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class StringUtil
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  
  public static void appendPlaceholders(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      paramStringBuilder.append("?");
      if (i < paramInt - 1) {
        paramStringBuilder.append(",");
      }
    }
  }
  
  @Nullable
  public static String joinIntoString(@Nullable List<Integer> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i = paramList.size();
    if (i == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; j < i; j++)
    {
      localStringBuilder.append(Integer.toString(((Integer)paramList.get(j)).intValue()));
      if (j < i - 1) {
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static StringBuilder newStringBuilder()
  {
    return new StringBuilder();
  }
  
  @Nullable
  public static List<Integer> splitToIntList(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = new StringTokenizer(paramString, ",");
    while (paramString.hasMoreElements())
    {
      String str = paramString.nextToken();
      try
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e("ROOM", "Malformed integer list", localNumberFormatException);
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\util\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */