package b.d.b.e;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

public class l
  implements Interceptor
{
  private RequestBody a(final RequestBody paramRequestBody)
  {
    return new a(paramRequestBody);
  }
  
  @NonNull
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    if (localRequest.body() == null) {
      return paramChain.proceed(localRequest);
    }
    if ("gzip".equalsIgnoreCase(localRequest.header("Content-Encoding"))) {
      return paramChain.proceed(localRequest.newBuilder().method(localRequest.method(), a(localRequest.body())).build());
    }
    return paramChain.proceed(localRequest);
  }
  
  class a
    extends RequestBody
  {
    a(RequestBody paramRequestBody) {}
    
    public long contentLength()
    {
      return -1L;
    }
    
    public MediaType contentType()
    {
      return paramRequestBody.contentType();
    }
    
    public void writeTo(BufferedSink paramBufferedSink)
      throws IOException
    {
      paramBufferedSink = Okio.buffer(new GzipSink(paramBufferedSink));
      paramRequestBody.writeTo(paramBufferedSink);
      paramBufferedSink.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\e\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */