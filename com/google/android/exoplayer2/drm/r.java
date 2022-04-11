package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class r
{
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (o0.a >= 27) {
      return paramArrayOfByte;
    }
    return o0.e0(c(o0.B(paramArrayOfByte)));
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    if (o0.a >= 27) {
      return paramArrayOfByte;
    }
    try
    {
      Object localObject1 = new org/json/JSONObject;
      ((JSONObject)localObject1).<init>(o0.B(paramArrayOfByte));
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("{\"keys\":[");
      localObject1 = ((JSONObject)localObject1).getJSONArray("keys");
      for (int i = 0; i < ((JSONArray)localObject1).length(); i++)
      {
        if (i != 0) {
          ((StringBuilder)localObject2).append(",");
        }
        JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
        ((StringBuilder)localObject2).append("{\"k\":\"");
        ((StringBuilder)localObject2).append(d(localJSONObject.getString("k")));
        ((StringBuilder)localObject2).append("\",\"kid\":\"");
        ((StringBuilder)localObject2).append(d(localJSONObject.getString("kid")));
        ((StringBuilder)localObject2).append("\",\"kty\":\"");
        ((StringBuilder)localObject2).append(localJSONObject.getString("kty"));
        ((StringBuilder)localObject2).append("\"}");
      }
      ((StringBuilder)localObject2).append("]}");
      localObject2 = o0.e0(((StringBuilder)localObject2).toString());
      return (byte[])localObject2;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = String.valueOf(o0.B(paramArrayOfByte));
      if (((String)localObject2).length() != 0) {
        localObject2 = "Failed to adjust response data: ".concat((String)localObject2);
      } else {
        localObject2 = new String("Failed to adjust response data: ");
      }
      u.d("ClearKeyUtil", (String)localObject2, localJSONException);
    }
    return paramArrayOfByte;
  }
  
  private static String c(String paramString)
  {
    return paramString.replace('+', '-').replace('/', '_');
  }
  
  private static String d(String paramString)
  {
    return paramString.replace('-', '+').replace('_', '/');
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */