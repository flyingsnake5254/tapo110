package io.netty.handler.codec.http;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class QueryStringEncoder
{
  private static final char[] CHAR_MAP = "0123456789ABCDEF".toCharArray();
  private static final byte WRITE_UTF_UNKNOWN = 63;
  private final Charset charset;
  private boolean hasParams;
  private final StringBuilder uriBuilder;
  
  public QueryStringEncoder(String paramString)
  {
    this(paramString, HttpConstants.DEFAULT_CHARSET);
  }
  
  public QueryStringEncoder(String paramString, Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramCharset, "charset");
    this.uriBuilder = new StringBuilder(paramString);
    paramString = paramCharset;
    if (CharsetUtil.UTF_8.equals(paramCharset)) {
      paramString = null;
    }
    this.charset = paramString;
  }
  
  private void appendEncoded(int paramInt)
  {
    StringBuilder localStringBuilder = this.uriBuilder;
    localStringBuilder.append('%');
    localStringBuilder.append(forDigit(paramInt >> 4));
    localStringBuilder.append(forDigit(paramInt));
  }
  
  private static boolean dontNeedEncoding(char paramChar)
  {
    boolean bool;
    if (((paramChar < 'a') || (paramChar > 'z')) && ((paramChar < 'A') || (paramChar > 'Z')) && ((paramChar < '0') || (paramChar > '9')) && (paramChar != '-') && (paramChar != '_') && (paramChar != '.') && (paramChar != '*')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void encodeComponent(CharSequence paramCharSequence)
  {
    if (this.charset == null) {
      encodeUtf8Component(paramCharSequence);
    } else {
      encodeNonUtf8Component(paramCharSequence);
    }
  }
  
  private void encodeNonUtf8Component(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    Object localObject1 = null;
    int j = 0;
    while (j < i)
    {
      char c1 = paramCharSequence.charAt(j);
      if (dontNeedEncoding(c1))
      {
        this.uriBuilder.append(c1);
        j++;
      }
      else
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new char[paramCharSequence.length() - j];
        }
        int k = 0;
        char c2 = c1;
        int n;
        do
        {
          localObject2[k] = ((char)c2);
          m = k + 1;
          n = j + 1;
          if (n >= paramCharSequence.length()) {
            break;
          }
          c1 = paramCharSequence.charAt(n);
          j = n;
          c2 = c1;
          k = m;
        } while (!dontNeedEncoding(c1));
        byte[] arrayOfByte = new String((char[])localObject2, 0, m).getBytes(this.charset);
        int m = arrayOfByte.length;
        for (k = 0;; k++)
        {
          localObject1 = localObject2;
          j = n;
          if (k >= m) {
            break;
          }
          appendEncoded(arrayOfByte[k]);
        }
      }
    }
  }
  
  private void encodeUtf8Component(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    for (int j = 0; j < i; j++) {
      if (!dontNeedEncoding(paramCharSequence.charAt(j)))
      {
        encodeUtf8Component(paramCharSequence, j, i);
        return;
      }
    }
    this.uriBuilder.append(paramCharSequence);
  }
  
  private void encodeUtf8Component(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.uriBuilder.append(paramCharSequence, 0, paramInt1);
    }
    encodeUtf8ComponentSlow(paramCharSequence, paramInt1, paramInt2);
  }
  
  private void encodeUtf8ComponentSlow(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (c < '')
      {
        if (dontNeedEncoding(c)) {
          this.uriBuilder.append(c);
        } else {
          appendEncoded(c);
        }
      }
      else if (c < 'ࠀ')
      {
        appendEncoded(c >> '\006' | 0xC0);
        appendEncoded(c & 0x3F | 0x80);
      }
      else if (StringUtil.isSurrogate(c))
      {
        if (!Character.isHighSurrogate(c))
        {
          appendEncoded(63);
        }
        else
        {
          paramInt1++;
          if (paramInt1 == paramCharSequence.length())
          {
            appendEncoded(63);
            break;
          }
          writeUtf8Surrogate(c, paramCharSequence.charAt(paramInt1));
        }
      }
      else
      {
        appendEncoded(c >> '\f' | 0xE0);
        appendEncoded(c >> '\006' & 0x3F | 0x80);
        appendEncoded(c & 0x3F | 0x80);
      }
      paramInt1++;
    }
  }
  
  private static char forDigit(int paramInt)
  {
    return CHAR_MAP[(paramInt & 0xF)];
  }
  
  private void writeUtf8Surrogate(char paramChar1, char paramChar2)
  {
    if (!Character.isLowSurrogate(paramChar2))
    {
      appendEncoded(63);
      i = paramChar2;
      if (Character.isHighSurrogate(paramChar2)) {
        i = 63;
      }
      appendEncoded(i);
      return;
    }
    int i = Character.toCodePoint(paramChar1, paramChar2);
    appendEncoded(i >> 18 | 0xF0);
    appendEncoded(i >> 12 & 0x3F | 0x80);
    appendEncoded(i >> 6 & 0x3F | 0x80);
    appendEncoded(i & 0x3F | 0x80);
  }
  
  public void addParam(String paramString1, String paramString2)
  {
    ObjectUtil.checkNotNull(paramString1, "name");
    if (this.hasParams)
    {
      this.uriBuilder.append('&');
    }
    else
    {
      this.uriBuilder.append('?');
      this.hasParams = true;
    }
    encodeComponent(paramString1);
    if (paramString2 != null)
    {
      this.uriBuilder.append('=');
      encodeComponent(paramString2);
    }
  }
  
  public String toString()
  {
    return this.uriBuilder.toString();
  }
  
  public URI toUri()
    throws URISyntaxException
  {
    return new URI(toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\QueryStringEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */