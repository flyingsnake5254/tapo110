package b.d.b.e;

import androidx.annotation.NonNull;
import b.d.w.h.a;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
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

public class n
  implements Interceptor
{
  private final String a;
  private final String b;
  
  public n(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
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
    paramString1 = new SecretKeySpec(this.b.getBytes(), "HmacSHA1");
    paramString2 = Mac.getInstance("HmacSHA1");
    paramString2.init(paramString1);
    return a.k(paramString2.doFinal(localStringBuilder.toString().getBytes()));
  }
  
  @NonNull
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    if ("true".equals(localRequest.header("signature-required")))
    {
      Object localObject1 = null;
      Object localObject2 = null;
      Headers.Builder localBuilder = null;
      RequestBody localRequestBody;
      try
      {
        long l = System.currentTimeMillis() / 1000L;
        String str1 = UUID.randomUUID().toString();
        String str2 = localRequest.url().encodedPath();
        localRequestBody = localRequest.body();
        String str3;
        if ((localRequestBody != null) && (localRequestBody.contentLength() > 0L))
        {
          str3 = a(localRequestBody);
          localRequestBody = null;
        }
        else
        {
          localRequestBody = RequestBody.create(MediaType.parse("application/json"), "{}");
        }
        try
        {
          str3 = a(localRequestBody);
          localObject2 = localBuilder;
          Object localObject3 = localObject1;
          try
          {
            str2 = b(str3, l, str1, str2);
            localObject2 = localBuilder;
            localObject3 = localObject1;
            localBuilder = localRequest.headers().newBuilder();
            if (str3 != null)
            {
              localObject2 = localBuilder;
              localObject3 = localBuilder;
              localBuilder.add("Content-MD5", str3);
            }
            localObject2 = localBuilder;
            localObject3 = localBuilder;
            localBuilder.add("X-Authorization", String.format("Timestamp=%1$s, Nonce=%2$s, AccessKey=%3$s, Signature=%4$s", new Object[] { Long.valueOf(l), str1, this.a, str2 }));
            localObject2 = localBuilder;
          }
          catch (InvalidKeyException localInvalidKeyException1)
          {
            break label268;
          }
          catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
          {
            localObject2 = localInvalidKeyException1;
            NoSuchAlgorithmException localNoSuchAlgorithmException2 = localNoSuchAlgorithmException1;
            break label268;
          }
        }
        catch (InvalidKeyException localInvalidKeyException2) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException3) {}
        localRequestBody = null;
      }
      catch (InvalidKeyException localInvalidKeyException3) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException4) {}
      label268:
      localNoSuchAlgorithmException4.printStackTrace();
      Request.Builder localBuilder1 = localRequest.newBuilder();
      if (localObject2 != null) {
        localBuilder1.headers(((Headers.Builder)localObject2).build());
      }
      localBuilder1.removeHeader("signature-required");
      if (localRequestBody != null) {
        localBuilder1.method(localRequest.method(), localRequestBody);
      }
      return paramChain.proceed(localBuilder1.build());
    }
    return paramChain.proceed(localRequest);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\e\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */