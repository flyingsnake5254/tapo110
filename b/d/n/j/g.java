package b.d.n.j;

import android.text.TextUtils;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramMap != null)
    {
      str = paramString2;
      if (paramMap.size() > 0)
      {
        str = paramString2;
        if (paramMap.containsKey(paramString1))
        {
          str = (String)paramMap.get(paramString1);
          if (str == null) {
            str = paramString2;
          }
        }
      }
    }
    return str;
  }
  
  public static String b(RemoteMessage paramRemoteMessage)
  {
    paramRemoteMessage = paramRemoteMessage.getData();
    String str1 = "";
    String str2 = a(paramRemoteMessage, "iac", "");
    paramRemoteMessage = str1;
    if (!TextUtils.isEmpty(str2)) {
      try
      {
        paramRemoteMessage = new org/json/JSONObject;
        paramRemoteMessage.<init>(str2);
        paramRemoteMessage = paramRemoteMessage.optString("msgType", "");
      }
      catch (JSONException paramRemoteMessage)
      {
        paramRemoteMessage.printStackTrace();
        paramRemoteMessage = str1;
      }
    }
    return paramRemoteMessage;
  }
  
  public static String c(RemoteMessage paramRemoteMessage)
  {
    Object localObject = paramRemoteMessage.getData();
    String str1 = "";
    localObject = a((Map)localObject, "iac", "");
    String str2 = b(paramRemoteMessage);
    paramRemoteMessage = str1;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramRemoteMessage = str1;
      if ("pushWithTaskId".equals(str2)) {
        try
        {
          paramRemoteMessage = new org/json/JSONObject;
          paramRemoteMessage.<init>((String)localObject);
          paramRemoteMessage = paramRemoteMessage.optString("taskId", "");
        }
        catch (JSONException paramRemoteMessage)
        {
          paramRemoteMessage.printStackTrace();
          paramRemoteMessage = str1;
        }
      }
    }
    return paramRemoteMessage;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\j\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */