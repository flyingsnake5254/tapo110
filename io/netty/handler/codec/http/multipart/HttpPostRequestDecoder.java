package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.List;

public class HttpPostRequestDecoder
  implements InterfaceHttpPostRequestDecoder
{
  static final int DEFAULT_DISCARD_THRESHOLD = 10485760;
  private final InterfaceHttpPostRequestDecoder decoder;
  
  public HttpPostRequestDecoder(HttpRequest paramHttpRequest)
  {
    this(new DefaultHttpDataFactory(16384L), paramHttpRequest, HttpConstants.DEFAULT_CHARSET);
  }
  
  public HttpPostRequestDecoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest)
  {
    this(paramHttpDataFactory, paramHttpRequest, HttpConstants.DEFAULT_CHARSET);
  }
  
  public HttpPostRequestDecoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest, Charset paramCharset)
  {
    ObjectUtil.checkNotNull(paramHttpDataFactory, "factory");
    ObjectUtil.checkNotNull(paramHttpRequest, "request");
    ObjectUtil.checkNotNull(paramCharset, "charset");
    if (isMultipart(paramHttpRequest)) {
      this.decoder = new HttpPostMultipartRequestDecoder(paramHttpDataFactory, paramHttpRequest, paramCharset);
    } else {
      this.decoder = new HttpPostStandardRequestDecoder(paramHttpDataFactory, paramHttpRequest, paramCharset);
    }
  }
  
  protected static String[] getMultipartDataBoundary(String paramString)
  {
    Object localObject1 = splitHeaderContentType(paramString);
    paramString = HttpHeaderValues.MULTIPART_FORM_DATA.toString();
    if (localObject1[0].regionMatches(true, 0, paramString, 0, paramString.length()))
    {
      paramString = HttpHeaderValues.BOUNDARY.toString();
      int i;
      int j;
      if (localObject1[1].regionMatches(true, 0, paramString, 0, paramString.length()))
      {
        i = 1;
        j = 2;
      }
      else
      {
        if (!localObject1[2].regionMatches(true, 0, paramString, 0, paramString.length())) {
          break label274;
        }
        i = 2;
        j = 1;
      }
      Object localObject2 = StringUtil.substringAfter(localObject1[i], '=');
      if (localObject2 != null)
      {
        paramString = (String)localObject2;
        if (((String)localObject2).charAt(0) == '"')
        {
          String str = ((String)localObject2).trim();
          i = str.length() - 1;
          paramString = (String)localObject2;
          if (str.charAt(i) == '"') {
            paramString = str.substring(1, i);
          }
        }
        localObject2 = HttpHeaderValues.CHARSET.toString();
        if (localObject1[j].regionMatches(true, 0, (String)localObject2, 0, ((String)localObject2).length()))
        {
          localObject2 = StringUtil.substringAfter(localObject1[j], '=');
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("--");
            ((StringBuilder)localObject1).append(paramString);
            return new String[] { ((StringBuilder)localObject1).toString(), localObject2 };
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append(paramString);
        return new String[] { ((StringBuilder)localObject2).toString() };
      }
      throw new ErrorDataDecoderException("Needs a boundary value");
    }
    label274:
    return null;
  }
  
  public static boolean isMultipart(HttpRequest paramHttpRequest)
  {
    paramHttpRequest = paramHttpRequest.headers().get(HttpHeaderNames.CONTENT_TYPE);
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramHttpRequest != null)
    {
      bool2 = bool1;
      if (paramHttpRequest.startsWith(HttpHeaderValues.MULTIPART_FORM_DATA.toString()))
      {
        bool2 = bool1;
        if (getMultipartDataBoundary(paramHttpRequest) != null) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private static String[] splitHeaderContentType(String paramString)
  {
    int i = HttpPostBodyUtil.findNonWhitespace(paramString, 0);
    int j = paramString.indexOf(';');
    if (j == -1) {
      return new String[] { paramString, "", "" };
    }
    int k = HttpPostBodyUtil.findNonWhitespace(paramString, j + 1);
    int m = j;
    if (paramString.charAt(j - 1) == ' ') {
      m = j - 1;
    }
    int n = paramString.indexOf(';', k);
    if (n == -1)
    {
      j = HttpPostBodyUtil.findEndOfString(paramString);
      return new String[] { paramString.substring(i, m), paramString.substring(k, j), "" };
    }
    int i1 = HttpPostBodyUtil.findNonWhitespace(paramString, n + 1);
    j = n;
    if (paramString.charAt(n - 1) == ' ') {
      j = n - 1;
    }
    n = HttpPostBodyUtil.findEndOfString(paramString);
    return new String[] { paramString.substring(i, m), paramString.substring(k, j), paramString.substring(i1, n) };
  }
  
  public void cleanFiles()
  {
    this.decoder.cleanFiles();
  }
  
  public InterfaceHttpData currentPartialHttpData()
  {
    return this.decoder.currentPartialHttpData();
  }
  
  public void destroy()
  {
    this.decoder.destroy();
  }
  
  public InterfaceHttpData getBodyHttpData(String paramString)
  {
    return this.decoder.getBodyHttpData(paramString);
  }
  
  public List<InterfaceHttpData> getBodyHttpDatas()
  {
    return this.decoder.getBodyHttpDatas();
  }
  
  public List<InterfaceHttpData> getBodyHttpDatas(String paramString)
  {
    return this.decoder.getBodyHttpDatas(paramString);
  }
  
  public int getDiscardThreshold()
  {
    return this.decoder.getDiscardThreshold();
  }
  
  public boolean hasNext()
  {
    return this.decoder.hasNext();
  }
  
  public boolean isMultipart()
  {
    return this.decoder.isMultipart();
  }
  
  public InterfaceHttpData next()
  {
    return this.decoder.next();
  }
  
  public InterfaceHttpPostRequestDecoder offer(HttpContent paramHttpContent)
  {
    return this.decoder.offer(paramHttpContent);
  }
  
  public void removeHttpDataFromClean(InterfaceHttpData paramInterfaceHttpData)
  {
    this.decoder.removeHttpDataFromClean(paramInterfaceHttpData);
  }
  
  public void setDiscardThreshold(int paramInt)
  {
    this.decoder.setDiscardThreshold(paramInt);
  }
  
  public static class EndOfDataDecoderException
    extends DecoderException
  {
    private static final long serialVersionUID = 1336267941020800769L;
  }
  
  public static class ErrorDataDecoderException
    extends DecoderException
  {
    private static final long serialVersionUID = 5020247425493164465L;
    
    public ErrorDataDecoderException() {}
    
    public ErrorDataDecoderException(String paramString)
    {
      super();
    }
    
    public ErrorDataDecoderException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public ErrorDataDecoderException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  protected static enum MultiPartStatus
  {
    static
    {
      MultiPartStatus localMultiPartStatus1 = new MultiPartStatus("NOTSTARTED", 0);
      NOTSTARTED = localMultiPartStatus1;
      MultiPartStatus localMultiPartStatus2 = new MultiPartStatus("PREAMBLE", 1);
      PREAMBLE = localMultiPartStatus2;
      MultiPartStatus localMultiPartStatus3 = new MultiPartStatus("HEADERDELIMITER", 2);
      HEADERDELIMITER = localMultiPartStatus3;
      MultiPartStatus localMultiPartStatus4 = new MultiPartStatus("DISPOSITION", 3);
      DISPOSITION = localMultiPartStatus4;
      MultiPartStatus localMultiPartStatus5 = new MultiPartStatus("FIELD", 4);
      FIELD = localMultiPartStatus5;
      MultiPartStatus localMultiPartStatus6 = new MultiPartStatus("FILEUPLOAD", 5);
      FILEUPLOAD = localMultiPartStatus6;
      MultiPartStatus localMultiPartStatus7 = new MultiPartStatus("MIXEDPREAMBLE", 6);
      MIXEDPREAMBLE = localMultiPartStatus7;
      MultiPartStatus localMultiPartStatus8 = new MultiPartStatus("MIXEDDELIMITER", 7);
      MIXEDDELIMITER = localMultiPartStatus8;
      MultiPartStatus localMultiPartStatus9 = new MultiPartStatus("MIXEDDISPOSITION", 8);
      MIXEDDISPOSITION = localMultiPartStatus9;
      MultiPartStatus localMultiPartStatus10 = new MultiPartStatus("MIXEDFILEUPLOAD", 9);
      MIXEDFILEUPLOAD = localMultiPartStatus10;
      MultiPartStatus localMultiPartStatus11 = new MultiPartStatus("MIXEDCLOSEDELIMITER", 10);
      MIXEDCLOSEDELIMITER = localMultiPartStatus11;
      MultiPartStatus localMultiPartStatus12 = new MultiPartStatus("CLOSEDELIMITER", 11);
      CLOSEDELIMITER = localMultiPartStatus12;
      MultiPartStatus localMultiPartStatus13 = new MultiPartStatus("PREEPILOGUE", 12);
      PREEPILOGUE = localMultiPartStatus13;
      MultiPartStatus localMultiPartStatus14 = new MultiPartStatus("EPILOGUE", 13);
      EPILOGUE = localMultiPartStatus14;
      $VALUES = new MultiPartStatus[] { localMultiPartStatus1, localMultiPartStatus2, localMultiPartStatus3, localMultiPartStatus4, localMultiPartStatus5, localMultiPartStatus6, localMultiPartStatus7, localMultiPartStatus8, localMultiPartStatus9, localMultiPartStatus10, localMultiPartStatus11, localMultiPartStatus12, localMultiPartStatus13, localMultiPartStatus14 };
    }
  }
  
  public static class NotEnoughDataDecoderException
    extends DecoderException
  {
    private static final long serialVersionUID = -7846841864603865638L;
    
    public NotEnoughDataDecoderException() {}
    
    public NotEnoughDataDecoderException(String paramString)
    {
      super();
    }
    
    public NotEnoughDataDecoderException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public NotEnoughDataDecoderException(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\HttpPostRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */