package com.tplink.nbu.b;

import b.d.w.h.a;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;

public class p
  implements Interceptor
{
  private AtomicInteger a = new AtomicInteger(0);
  private final String b;
  private final String c;
  
  p(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  private String a(RequestBody paramRequestBody)
    throws NoSuchAlgorithmException, IOException
  {
    if (paramRequestBody != null)
    {
      Object localObject = new Buffer();
      paramRequestBody.writeTo((BufferedSink)localObject);
      localObject = ((Buffer)localObject).readByteArray();
      paramRequestBody = (RequestBody)localObject;
      if (localObject.length <= 0) {
        paramRequestBody = "{}".getBytes();
      }
    }
    else
    {
      paramRequestBody = "{}".getBytes();
    }
    return a.c(a.f(paramRequestBody));
  }
  
  private String b(String paramString1, long paramLong, String paramString2, String paramString3)
    throws NoSuchAlgorithmException, InvalidKeyException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append("\n");
    }
    localStringBuilder.append(paramLong);
    localStringBuilder.append("\n");
    if (paramString2 != null)
    {
      localStringBuilder.append(paramString2);
      localStringBuilder.append("\n");
    }
    localStringBuilder.append(paramString3);
    paramString1 = new SecretKeySpec(this.c.getBytes(), "HmacSHA1");
    paramString2 = Mac.getInstance("HmacSHA1");
    paramString2.init(paramString1);
    return a.k(paramString2.doFinal(localStringBuilder.toString().getBytes()));
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    Object localObject1 = localRequest.header("nbu-signature-required");
    Object localObject2 = localRequest.method();
    if ("true".equals(localObject1))
    {
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = localObject4;
      localObject1 = localObject3;
      try
      {
        long l = System.currentTimeMillis() / 1000L;
        localObject5 = localObject4;
        localObject1 = localObject3;
        String str1 = String.valueOf(this.a.getAndAdd(1));
        localObject5 = localObject4;
        localObject1 = localObject3;
        String str2 = localRequest.url().encodedPath();
        localObject5 = localObject4;
        localObject1 = localObject3;
        RequestBody localRequestBody = localRequest.body();
        localObject5 = localObject4;
        localObject1 = localObject3;
        if ("GET".equals(localObject2))
        {
          localObject5 = localObject4;
          localObject1 = localObject3;
          localObject2 = a.c(a.f("".getBytes()));
        }
        else
        {
          if (localRequestBody == null) {
            break label183;
          }
          localObject5 = localObject4;
          localObject1 = localObject3;
          if (localRequestBody.contentLength() <= 0L) {
            break label183;
          }
          localObject5 = localObject4;
          localObject1 = localObject3;
        }
        for (localObject2 = a(localRequestBody);; localObject2 = a(RequestBody.create(MediaType.parse("application/json"), "{}")))
        {
          break;
          label183:
          localObject5 = localObject4;
          localObject1 = localObject3;
        }
        localObject5 = localObject4;
        localObject1 = localObject3;
        str2 = b((String)localObject2, l, str1, str2);
        localObject5 = localObject4;
        localObject1 = localObject3;
        localObject2 = localRequest.headers().newBuilder();
        localObject5 = localObject2;
        localObject1 = localObject2;
        ((Headers.Builder)localObject2).add("X-Authorization", String.format("Id=%1$s,Timestamp=%2$s,AccessKey=%3$s,Signature=%4$s", new Object[] { str1, Long.valueOf(l), this.b, str2 }));
        localObject1 = localObject2;
      }
      catch (InvalidKeyException localInvalidKeyException)
      {
        localObject1 = localObject5;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
      localNoSuchAlgorithmException.printStackTrace();
      localObject5 = localRequest.newBuilder();
      if (localObject1 != null) {
        ((Request.Builder)localObject5).headers(((Headers.Builder)localObject1).build());
      }
      ((Request.Builder)localObject5).removeHeader("nbu-signature-required");
      return paramChain.proceed(((Request.Builder)localObject5).build());
    }
    return paramChain.proceed(localRequest);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */