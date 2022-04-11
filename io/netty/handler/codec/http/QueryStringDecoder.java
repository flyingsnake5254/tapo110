package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QueryStringDecoder
{
  private static final int DEFAULT_MAX_PARAMS = 1024;
  private final Charset charset;
  private final int maxParams;
  private Map<String, List<String>> params;
  private String path;
  private int pathEndIdx;
  private final boolean semicolonIsNormalChar;
  private final String uri;
  
  public QueryStringDecoder(String paramString)
  {
    this(paramString, HttpConstants.DEFAULT_CHARSET);
  }
  
  public QueryStringDecoder(String paramString, Charset paramCharset)
  {
    this(paramString, paramCharset, true);
  }
  
  public QueryStringDecoder(String paramString, Charset paramCharset, boolean paramBoolean)
  {
    this(paramString, paramCharset, paramBoolean, 1024);
  }
  
  public QueryStringDecoder(String paramString, Charset paramCharset, boolean paramBoolean, int paramInt)
  {
    this(paramString, paramCharset, paramBoolean, paramInt, false);
  }
  
  public QueryStringDecoder(String paramString, Charset paramCharset, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.uri = ((String)ObjectUtil.checkNotNull(paramString, "uri"));
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
    this.maxParams = ObjectUtil.checkPositive(paramInt, "maxParams");
    this.semicolonIsNormalChar = paramBoolean2;
    if (paramBoolean1) {
      paramInt = -1;
    } else {
      paramInt = 0;
    }
    this.pathEndIdx = paramInt;
  }
  
  public QueryStringDecoder(String paramString, boolean paramBoolean)
  {
    this(paramString, HttpConstants.DEFAULT_CHARSET, paramBoolean);
  }
  
  public QueryStringDecoder(URI paramURI)
  {
    this(paramURI, HttpConstants.DEFAULT_CHARSET);
  }
  
  public QueryStringDecoder(URI paramURI, Charset paramCharset)
  {
    this(paramURI, paramCharset, 1024);
  }
  
  public QueryStringDecoder(URI paramURI, Charset paramCharset, int paramInt)
  {
    this(paramURI, paramCharset, paramInt, false);
  }
  
  public QueryStringDecoder(URI paramURI, Charset paramCharset, int paramInt, boolean paramBoolean)
  {
    String str1 = paramURI.getRawPath();
    String str2 = str1;
    if (str1 == null) {
      str2 = "";
    }
    str1 = paramURI.getRawQuery();
    if (str1 == null)
    {
      paramURI = str2;
    }
    else
    {
      paramURI = new StringBuilder();
      paramURI.append(str2);
      paramURI.append('?');
      paramURI.append(str1);
      paramURI = paramURI.toString();
    }
    this.uri = paramURI;
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
    this.maxParams = ObjectUtil.checkPositive(paramInt, "maxParams");
    this.semicolonIsNormalChar = paramBoolean;
    this.pathEndIdx = str2.length();
  }
  
  private static boolean addParam(String paramString, int paramInt1, int paramInt2, int paramInt3, Map<String, List<String>> paramMap, Charset paramCharset)
  {
    if (paramInt1 >= paramInt3) {
      return false;
    }
    int i = paramInt2;
    if (paramInt2 <= paramInt1) {
      i = paramInt3 + 1;
    }
    String str1 = decodeComponent(paramString, paramInt1, i - 1, paramCharset, false);
    String str2 = decodeComponent(paramString, i, paramInt3, paramCharset, false);
    paramCharset = (List)paramMap.get(str1);
    paramString = paramCharset;
    if (paramCharset == null)
    {
      paramString = new ArrayList(1);
      paramMap.put(str1, paramString);
    }
    paramString.add(str2);
    return true;
  }
  
  public static String decodeComponent(String paramString)
  {
    return decodeComponent(paramString, HttpConstants.DEFAULT_CHARSET);
  }
  
  private static String decodeComponent(String paramString, int paramInt1, int paramInt2, Charset paramCharset, boolean paramBoolean)
  {
    int i = paramInt2 - paramInt1;
    if (i <= 0) {
      return "";
    }
    for (int j = paramInt1; j < paramInt2; j++)
    {
      int k = paramString.charAt(j);
      m = j;
      if (k == 37) {
        break label69;
      }
      if ((k == 43) && (!paramBoolean))
      {
        m = j;
        break label69;
      }
    }
    int m = -1;
    label69:
    if (m == -1) {
      return paramString.substring(paramInt1, paramInt2);
    }
    byte[] arrayOfByte = PlatformDependent.allocateUninitializedArray((paramInt2 - m) / 3);
    StringBuilder localStringBuilder = new StringBuilder(i);
    localStringBuilder.append(paramString, paramInt1, m);
    paramInt1 = m;
    while (paramInt1 < paramInt2)
    {
      j = paramString.charAt(paramInt1);
      if (j != 37)
      {
        int n = j;
        if (j == 43) {
          if (paramBoolean)
          {
            n = j;
          }
          else
          {
            j = 32;
            n = j;
          }
        }
        localStringBuilder.append(n);
      }
      else
      {
        m = 0;
        j = paramInt1;
        for (paramInt1 = m;; paramInt1 = m)
        {
          i = j + 3;
          if (i > paramInt2) {
            break label276;
          }
          m = paramInt1 + 1;
          arrayOfByte[paramInt1] = StringUtil.decodeHexByte(paramString, j + 1);
          if ((i >= paramInt2) || (paramString.charAt(i) != '%')) {
            break;
          }
          j = i;
        }
        paramInt1 = i - 1;
        localStringBuilder.append(new String(arrayOfByte, 0, m, paramCharset));
      }
      paramInt1++;
      continue;
      label276:
      paramCharset = new StringBuilder();
      paramCharset.append("unterminated escape sequence at index ");
      paramCharset.append(j);
      paramCharset.append(" of: ");
      paramCharset.append(paramString);
      throw new IllegalArgumentException(paramCharset.toString());
    }
    return localStringBuilder.toString();
  }
  
  public static String decodeComponent(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      return "";
    }
    return decodeComponent(paramString, 0, paramString.length(), paramCharset, false);
  }
  
  private static Map<String, List<String>> decodeParams(String paramString, int paramInt1, Charset paramCharset, int paramInt2, boolean paramBoolean)
  {
    int i = paramString.length();
    if (paramInt1 >= i) {
      return Collections.emptyMap();
    }
    int j = paramInt1;
    if (paramString.charAt(paramInt1) == '?') {
      j = paramInt1 + 1;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramInt1 = j;
    j = paramInt1;
    int k = -1;
    int m = paramInt1;
    while (j < i)
    {
      paramInt1 = paramString.charAt(j);
      if (paramInt1 == 35) {
        break;
      }
      if (paramInt1 != 38)
      {
        if (paramInt1 != 59)
        {
          if (paramInt1 != 61)
          {
            paramInt1 = m;
            n = k;
            i1 = paramInt2;
            break label212;
          }
          if (m == j)
          {
            paramInt1 = paramInt2;
            break label198;
          }
          paramInt1 = m;
          n = k;
          i1 = paramInt2;
          if (k >= m) {
            break label212;
          }
          n = j + 1;
          paramInt1 = m;
          i1 = paramInt2;
          break label212;
        }
        if (paramBoolean)
        {
          paramInt1 = m;
          n = k;
          i1 = paramInt2;
          break label212;
        }
      }
      paramInt1 = paramInt2;
      if (addParam(paramString, m, k, j, localLinkedHashMap, paramCharset))
      {
        paramInt2--;
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          return localLinkedHashMap;
        }
      }
      label198:
      paramInt2 = j + 1;
      int i1 = paramInt1;
      int n = k;
      paramInt1 = paramInt2;
      label212:
      j++;
      m = paramInt1;
      k = n;
      paramInt2 = i1;
    }
    addParam(paramString, m, k, j, localLinkedHashMap, paramCharset);
    return localLinkedHashMap;
  }
  
  private static int findPathEndIndex(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    while (j < i)
    {
      int k = paramString.charAt(j);
      if ((k != 63) && (k != 35)) {
        j++;
      } else {
        return j;
      }
    }
    return i;
  }
  
  private int pathEndIdx()
  {
    if (this.pathEndIdx == -1) {
      this.pathEndIdx = findPathEndIndex(this.uri);
    }
    return this.pathEndIdx;
  }
  
  public Map<String, List<String>> parameters()
  {
    if (this.params == null) {
      this.params = decodeParams(this.uri, pathEndIdx(), this.charset, this.maxParams, this.semicolonIsNormalChar);
    }
    return this.params;
  }
  
  public String path()
  {
    if (this.path == null) {
      this.path = decodeComponent(this.uri, 0, pathEndIdx(), this.charset, true);
    }
    return this.path;
  }
  
  public String rawPath()
  {
    return this.uri.substring(0, pathEndIdx());
  }
  
  public String rawQuery()
  {
    int i = pathEndIdx() + 1;
    String str;
    if (i < this.uri.length()) {
      str = this.uri.substring(i);
    } else {
      str = "";
    }
    return str;
  }
  
  public String toString()
  {
    return uri();
  }
  
  public String uri()
  {
    return this.uri;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\QueryStringDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */