package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
@VisibleForTesting
public final class JsonUtils
{
  private static final Pattern zzhd = Pattern.compile("\\\\.");
  private static final Pattern zzhe = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  
  @KeepForSdk
  public static boolean areJsonValuesEquivalent(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return true;
    }
    JSONObject localJSONObject;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      if (((paramObject1 instanceof JSONObject)) && ((paramObject2 instanceof JSONObject)))
      {
        paramObject1 = (JSONObject)paramObject1;
        localJSONObject = (JSONObject)paramObject2;
        if (((JSONObject)paramObject1).length() != localJSONObject.length()) {
          return false;
        }
        paramObject2 = ((JSONObject)paramObject1).keys();
      }
    }
    for (;;)
    {
      if (!((Iterator)paramObject2).hasNext()) {
        break label114;
      }
      String str = (String)((Iterator)paramObject2).next();
      if (!localJSONObject.has(str)) {
        return false;
      }
      try
      {
        bool = areJsonValuesEquivalent(((JSONObject)paramObject1).get(str), localJSONObject.get(str));
        if (bool) {}
      }
      catch (JSONException paramObject1)
      {
        boolean bool;
        int i;
        for (;;) {}
      }
    }
    return false;
    label114:
    return true;
    if (((paramObject1 instanceof JSONArray)) && ((paramObject2 instanceof JSONArray)))
    {
      paramObject1 = (JSONArray)paramObject1;
      paramObject2 = (JSONArray)paramObject2;
      if (((JSONArray)paramObject1).length() != ((JSONArray)paramObject2).length()) {
        return false;
      }
      i = 0;
      while (i < ((JSONArray)paramObject1).length()) {
        try
        {
          bool = areJsonValuesEquivalent(((JSONArray)paramObject1).get(i), ((JSONArray)paramObject2).get(i));
          if (!bool) {
            return false;
          }
          i++;
        }
        catch (JSONException paramObject1)
        {
          return false;
        }
      }
      return true;
    }
    return paramObject1.equals(paramObject2);
    return false;
  }
  
  @KeepForSdk
  public static String escapeString(String paramString)
  {
    Object localObject1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = zzhe.matcher(paramString);
      Object localObject2 = null;
      while (localMatcher.find())
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new StringBuffer();
        }
        int i = localMatcher.group().charAt(0);
        if (i != 12)
        {
          if (i != 13)
          {
            if (i != 34)
            {
              if (i != 47)
              {
                if (i != 92)
                {
                  switch (i)
                  {
                  default: 
                    localObject2 = localObject1;
                    break;
                  case 10: 
                    localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\n");
                    localObject2 = localObject1;
                    break;
                  case 9: 
                    localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\t");
                    localObject2 = localObject1;
                    break;
                  case 8: 
                    localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\b");
                    localObject2 = localObject1;
                    break;
                  }
                }
                else
                {
                  localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\\\\\");
                  localObject2 = localObject1;
                }
              }
              else
              {
                localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\/");
                localObject2 = localObject1;
              }
            }
            else
            {
              localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\\\\"");
              localObject2 = localObject1;
            }
          }
          else
          {
            localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\r");
            localObject2 = localObject1;
          }
        }
        else
        {
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\f");
          localObject2 = localObject1;
        }
      }
      if (localObject2 == null) {
        return paramString;
      }
      localMatcher.appendTail((StringBuffer)localObject2);
      localObject1 = ((StringBuffer)localObject2).toString();
    }
    return (String)localObject1;
  }
  
  @KeepForSdk
  public static String unescapeString(String paramString)
  {
    String str1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      String str2 = zzd.unescape(paramString);
      Matcher localMatcher = zzhd.matcher(str2);
      str1 = null;
      while (localMatcher.find())
      {
        paramString = str1;
        if (str1 == null) {
          paramString = new StringBuffer();
        }
        int i = localMatcher.group().charAt(1);
        if (i != 34)
        {
          if (i != 47)
          {
            if (i != 92)
            {
              if (i != 98)
              {
                if (i != 102)
                {
                  if (i != 110)
                  {
                    if (i != 114)
                    {
                      if (i == 116)
                      {
                        localMatcher.appendReplacement(paramString, "\t");
                        str1 = paramString;
                      }
                      else
                      {
                        throw new IllegalStateException("Found an escaped character that should never be.");
                      }
                    }
                    else
                    {
                      localMatcher.appendReplacement(paramString, "\r");
                      str1 = paramString;
                    }
                  }
                  else
                  {
                    localMatcher.appendReplacement(paramString, "\n");
                    str1 = paramString;
                  }
                }
                else
                {
                  localMatcher.appendReplacement(paramString, "\f");
                  str1 = paramString;
                }
              }
              else
              {
                localMatcher.appendReplacement(paramString, "\b");
                str1 = paramString;
              }
            }
            else
            {
              localMatcher.appendReplacement(paramString, "\\\\");
              str1 = paramString;
            }
          }
          else
          {
            localMatcher.appendReplacement(paramString, "/");
            str1 = paramString;
          }
        }
        else
        {
          localMatcher.appendReplacement(paramString, "\"");
          str1 = paramString;
        }
      }
      if (str1 == null) {
        return str2;
      }
      localMatcher.appendTail(str1);
      str1 = str1.toString();
    }
    return str1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */