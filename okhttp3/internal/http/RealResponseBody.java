package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody
  extends ResponseBody
{
  private final long contentLength;
  @Nullable
  private final String contentTypeString;
  private final BufferedSource source;
  
  public RealResponseBody(@Nullable String paramString, long paramLong, BufferedSource paramBufferedSource)
  {
    this.contentTypeString = paramString;
    this.contentLength = paramLong;
    this.source = paramBufferedSource;
  }
  
  public long contentLength()
  {
    return this.contentLength;
  }
  
  public MediaType contentType()
  {
    Object localObject = this.contentTypeString;
    if (localObject != null) {
      localObject = MediaType.parse((String)localObject);
    } else {
      localObject = null;
    }
    return (MediaType)localObject;
  }
  
  public BufferedSource source()
  {
    return this.source;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http\RealResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */