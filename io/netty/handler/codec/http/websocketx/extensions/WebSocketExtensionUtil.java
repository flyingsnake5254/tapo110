package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.AsciiString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebSocketExtensionUtil
{
  private static final String EXTENSION_SEPARATOR = ",";
  private static final Pattern PARAMETER = Pattern.compile("^([^=]+)(=[\\\"]?([^\\\"]+)[\\\"]?)?$");
  private static final char PARAMETER_EQUAL = '=';
  private static final String PARAMETER_SEPARATOR = ";";
  
  static String appendExtension(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i;
    if (paramString1 != null) {
      i = paramString1.length();
    } else {
      i = paramString2.length() + 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(i);
    if ((paramString1 != null) && (!paramString1.trim().isEmpty()))
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",");
    }
    localStringBuilder.append(paramString2);
    paramString2 = paramMap.entrySet().iterator();
    while (paramString2.hasNext())
    {
      paramString1 = (Map.Entry)paramString2.next();
      localStringBuilder.append(";");
      localStringBuilder.append((String)paramString1.getKey());
      if (paramString1.getValue() != null)
      {
        localStringBuilder.append('=');
        localStringBuilder.append((String)paramString1.getValue());
      }
    }
    return localStringBuilder.toString();
  }
  
  public static List<WebSocketExtensionData> extractExtensions(String paramString)
  {
    String[] arrayOfString1 = paramString.split(",");
    if (arrayOfString1.length > 0)
    {
      ArrayList localArrayList = new ArrayList(arrayOfString1.length);
      int i = arrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String[] arrayOfString2 = arrayOfString1[j].split(";");
        String str = arrayOfString2[0].trim();
        if (arrayOfString2.length > 1)
        {
          HashMap localHashMap = new HashMap(arrayOfString2.length - 1);
          for (int k = 1;; k++)
          {
            paramString = localHashMap;
            if (k >= arrayOfString2.length) {
              break;
            }
            paramString = arrayOfString2[k].trim();
            paramString = PARAMETER.matcher(paramString);
            if ((paramString.matches()) && (paramString.group(1) != null)) {
              localHashMap.put(paramString.group(1), paramString.group(3));
            }
          }
        }
        paramString = Collections.emptyMap();
        localArrayList.add(new WebSocketExtensionData(str, paramString));
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  static boolean isWebsocketUpgrade(HttpHeaders paramHttpHeaders)
  {
    AsciiString localAsciiString1 = HttpHeaderNames.CONNECTION;
    AsciiString localAsciiString2 = HttpHeaderValues.UPGRADE;
    boolean bool = true;
    if ((!paramHttpHeaders.containsValue(localAsciiString1, localAsciiString2, true)) || (!paramHttpHeaders.contains(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET, true))) {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketExtensionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */