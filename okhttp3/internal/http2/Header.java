package okhttp3.internal.http2;

import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Header
{
  public static final ByteString PSEUDO_PREFIX = ByteString.encodeUtf8(":");
  public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(":status");
  public static final String RESPONSE_STATUS_UTF8 = ":status";
  public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
  public static final String TARGET_AUTHORITY_UTF8 = ":authority";
  public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(":method");
  public static final String TARGET_METHOD_UTF8 = ":method";
  public static final ByteString TARGET_PATH = ByteString.encodeUtf8(":path");
  public static final String TARGET_PATH_UTF8 = ":path";
  public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
  public static final String TARGET_SCHEME_UTF8 = ":scheme";
  final int hpackSize;
  public final ByteString name;
  public final ByteString value;
  
  public Header(String paramString1, String paramString2)
  {
    this(ByteString.encodeUtf8(paramString1), ByteString.encodeUtf8(paramString2));
  }
  
  public Header(ByteString paramByteString, String paramString)
  {
    this(paramByteString, ByteString.encodeUtf8(paramString));
  }
  
  public Header(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.name = paramByteString1;
    this.value = paramByteString2;
    this.hpackSize = (paramByteString1.size() + 32 + paramByteString2.size());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Header;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (Header)paramObject;
      bool3 = bool2;
      if (this.name.equals(((Header)paramObject).name))
      {
        bool3 = bool2;
        if (this.value.equals(((Header)paramObject).value)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    return (527 + this.name.hashCode()) * 31 + this.value.hashCode();
  }
  
  public String toString()
  {
    return Util.format("%s: %s", new Object[] { this.name.utf8(), this.value.utf8() });
  }
  
  static abstract interface Listener
  {
    public abstract void onHeaders(Headers paramHeaders);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http2\Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */