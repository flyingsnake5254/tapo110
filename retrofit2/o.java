package retrofit2;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.MultipartBody.Part;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

final class o
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final Pattern b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
  private final String c;
  private final HttpUrl d;
  @Nullable
  private String e;
  @Nullable
  private HttpUrl.Builder f;
  private final Request.Builder g;
  private final Headers.Builder h;
  @Nullable
  private MediaType i;
  private final boolean j;
  @Nullable
  private MultipartBody.Builder k;
  @Nullable
  private FormBody.Builder l;
  @Nullable
  private RequestBody m;
  
  o(String paramString1, HttpUrl paramHttpUrl, @Nullable String paramString2, @Nullable Headers paramHeaders, @Nullable MediaType paramMediaType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.c = paramString1;
    this.d = paramHttpUrl;
    this.e = paramString2;
    this.g = new Request.Builder();
    this.i = paramMediaType;
    this.j = paramBoolean1;
    if (paramHeaders != null) {
      this.h = paramHeaders.newBuilder();
    } else {
      this.h = new Headers.Builder();
    }
    if (paramBoolean2)
    {
      this.l = new FormBody.Builder();
    }
    else if (paramBoolean3)
    {
      paramString1 = new MultipartBody.Builder();
      this.k = paramString1;
      paramString1.setType(MultipartBody.FORM);
    }
  }
  
  private static String i(String paramString, boolean paramBoolean)
  {
    int n = paramString.length();
    int i1 = 0;
    for (;;)
    {
      localObject = paramString;
      if (i1 >= n) {
        break label113;
      }
      int i2 = paramString.codePointAt(i1);
      if ((i2 < 32) || (i2 >= 127) || (" \"<>^`{}|\\?#".indexOf(i2) != -1) || ((!paramBoolean) && ((i2 == 47) || (i2 == 37)))) {
        break;
      }
      i1 += Character.charCount(i2);
    }
    Object localObject = new Buffer();
    ((Buffer)localObject).writeUtf8(paramString, 0, i1);
    j((Buffer)localObject, paramString, i1, n, paramBoolean);
    localObject = ((Buffer)localObject).readUtf8();
    label113:
    return (String)localObject;
  }
  
  private static void j(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2;
    for (Object localObject1 = null; paramInt1 < paramInt2; localObject1 = localObject2)
    {
      int n = paramString.codePointAt(paramInt1);
      if (paramBoolean)
      {
        localObject2 = localObject1;
        if (n == 9) {
          break label220;
        }
        localObject2 = localObject1;
        if (n == 10) {
          break label220;
        }
        localObject2 = localObject1;
        if (n == 12) {
          break label220;
        }
        if (n == 13)
        {
          localObject2 = localObject1;
          break label220;
        }
      }
      if ((n >= 32) && (n < 127) && (" \"<>^`{}|\\?#".indexOf(n) == -1) && ((paramBoolean) || ((n != 47) && (n != 37))))
      {
        paramBuffer.writeUtf8CodePoint(n);
        localObject2 = localObject1;
      }
      else
      {
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Buffer();
        }
        ((Buffer)localObject3).writeUtf8CodePoint(n);
        for (;;)
        {
          localObject2 = localObject3;
          if (((Buffer)localObject3).exhausted()) {
            break;
          }
          int i1 = ((Buffer)localObject3).readByte() & 0xFF;
          paramBuffer.writeByte(37);
          localObject1 = a;
          paramBuffer.writeByte(localObject1[(i1 >> 4 & 0xF)]);
          paramBuffer.writeByte(localObject1[(i1 & 0xF)]);
        }
      }
      label220:
      paramInt1 += Character.charCount(n);
    }
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.l.addEncoded(paramString1, paramString2);
    } else {
      this.l.add(paramString1, paramString2);
    }
  }
  
  void b(String paramString1, String paramString2)
  {
    if ("Content-Type".equalsIgnoreCase(paramString1)) {
      try
      {
        this.i = MediaType.get(paramString2);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        paramString1 = new StringBuilder();
        paramString1.append("Malformed content type: ");
        paramString1.append(paramString2);
        throw new IllegalArgumentException(paramString1.toString(), localIllegalArgumentException);
      }
    } else {
      this.h.add(paramString1, paramString2);
    }
  }
  
  void c(Headers paramHeaders)
  {
    this.h.addAll(paramHeaders);
  }
  
  void d(Headers paramHeaders, RequestBody paramRequestBody)
  {
    this.k.addPart(paramHeaders, paramRequestBody);
  }
  
  void e(MultipartBody.Part paramPart)
  {
    this.k.addPart(paramPart);
  }
  
  void f(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.e != null)
    {
      String str1 = i(paramString2, paramBoolean);
      String str2 = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("}");
      paramString1 = str2.replace(localStringBuilder.toString(), str1);
      if (!b.matcher(paramString1).matches())
      {
        this.e = paramString1;
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
      paramString1.append(paramString2);
      throw new IllegalArgumentException(paramString1.toString());
    }
    throw new AssertionError();
  }
  
  void g(String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = this.d.newBuilder((String)localObject);
      this.f = ((HttpUrl.Builder)localObject);
      if (localObject != null)
      {
        this.e = null;
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("Malformed URL. Base: ");
        paramString1.append(this.d);
        paramString1.append(", Relative: ");
        paramString1.append(this.e);
        throw new IllegalArgumentException(paramString1.toString());
      }
    }
    if (paramBoolean) {
      this.f.addEncodedQueryParameter(paramString1, paramString2);
    } else {
      this.f.addQueryParameter(paramString1, paramString2);
    }
  }
  
  <T> void h(Class<T> paramClass, @Nullable T paramT)
  {
    this.g.tag(paramClass, paramT);
  }
  
  Request.Builder k()
  {
    Object localObject1 = this.f;
    HttpUrl localHttpUrl;
    if (localObject1 != null)
    {
      localHttpUrl = ((HttpUrl.Builder)localObject1).build();
    }
    else
    {
      localHttpUrl = this.d.resolve(this.e);
      if (localHttpUrl == null) {
        break label170;
      }
    }
    Object localObject2 = this.m;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.l;
      if (localObject1 != null)
      {
        localObject1 = ((FormBody.Builder)localObject1).build();
      }
      else
      {
        localObject1 = this.k;
        if (localObject1 != null)
        {
          localObject1 = ((MultipartBody.Builder)localObject1).build();
        }
        else
        {
          localObject1 = localObject2;
          if (this.j) {
            localObject1 = RequestBody.create(null, new byte[0]);
          }
        }
      }
    }
    MediaType localMediaType = this.i;
    localObject2 = localObject1;
    if (localMediaType != null) {
      if (localObject1 != null)
      {
        localObject2 = new a((RequestBody)localObject1, localMediaType);
      }
      else
      {
        this.h.add("Content-Type", localMediaType.toString());
        localObject2 = localObject1;
      }
    }
    return this.g.url(localHttpUrl).headers(this.h.build()).method(this.c, (RequestBody)localObject2);
    label170:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Malformed URL. Base: ");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append(", Relative: ");
    ((StringBuilder)localObject1).append(this.e);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  void l(RequestBody paramRequestBody)
  {
    this.m = paramRequestBody;
  }
  
  void m(Object paramObject)
  {
    this.e = paramObject.toString();
  }
  
  private static class a
    extends RequestBody
  {
    private final RequestBody a;
    private final MediaType b;
    
    a(RequestBody paramRequestBody, MediaType paramMediaType)
    {
      this.a = paramRequestBody;
      this.b = paramMediaType;
    }
    
    public long contentLength()
      throws IOException
    {
      return this.a.contentLength();
    }
    
    public MediaType contentType()
    {
      return this.b;
    }
    
    public void writeTo(BufferedSink paramBufferedSink)
      throws IOException
    {
      this.a.writeTo(paramBufferedSink);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */