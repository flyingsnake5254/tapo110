package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

public final class CacheStrategy
{
  @Nullable
  public final Response cacheResponse;
  @Nullable
  public final Request networkRequest;
  
  CacheStrategy(Request paramRequest, Response paramResponse)
  {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest)
  {
    int i = paramResponse.code();
    boolean bool1 = false;
    if ((i != 200) && (i != 410) && (i != 414) && (i != 501) && (i != 203) && (i != 204)) {
      if (i != 307)
      {
        if ((i == 308) || (i == 404) || (i == 405)) {}
      }
      else {
        switch (i)
        {
        default: 
          break;
        case 302: 
          if ((paramResponse.header("Expires") == null) && (paramResponse.cacheControl().maxAgeSeconds() == -1) && (!paramResponse.cacheControl().isPublic()) && (!paramResponse.cacheControl().isPrivate())) {
            return false;
          }
          break;
        }
      }
    }
    boolean bool2 = bool1;
    if (!paramResponse.cacheControl().noStore())
    {
      bool2 = bool1;
      if (!paramRequest.cacheControl().noStore()) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static class Factory
  {
    private int ageSeconds = -1;
    final Response cacheResponse;
    private String etag;
    private Date expires;
    private Date lastModified;
    private String lastModifiedString;
    final long nowMillis;
    private long receivedResponseMillis;
    final Request request;
    private long sentRequestMillis;
    private Date servedDate;
    private String servedDateString;
    
    public Factory(long paramLong, Request paramRequest, Response paramResponse)
    {
      this.nowMillis = paramLong;
      this.request = paramRequest;
      this.cacheResponse = paramResponse;
      if (paramResponse != null)
      {
        this.sentRequestMillis = paramResponse.sentRequestAtMillis();
        this.receivedResponseMillis = paramResponse.receivedResponseAtMillis();
        paramResponse = paramResponse.headers();
        int i = 0;
        int j = paramResponse.size();
        while (i < j)
        {
          String str = paramResponse.name(i);
          paramRequest = paramResponse.value(i);
          if ("Date".equalsIgnoreCase(str))
          {
            this.servedDate = HttpDate.parse(paramRequest);
            this.servedDateString = paramRequest;
          }
          else if ("Expires".equalsIgnoreCase(str))
          {
            this.expires = HttpDate.parse(paramRequest);
          }
          else if ("Last-Modified".equalsIgnoreCase(str))
          {
            this.lastModified = HttpDate.parse(paramRequest);
            this.lastModifiedString = paramRequest;
          }
          else if ("ETag".equalsIgnoreCase(str))
          {
            this.etag = paramRequest;
          }
          else if ("Age".equalsIgnoreCase(str))
          {
            this.ageSeconds = HttpHeaders.parseSeconds(paramRequest, -1);
          }
          i++;
        }
      }
    }
    
    private long cacheResponseAge()
    {
      Date localDate = this.servedDate;
      long l1 = 0L;
      if (localDate != null) {
        l1 = Math.max(0L, this.receivedResponseMillis - localDate.getTime());
      }
      int i = this.ageSeconds;
      long l2 = l1;
      if (i != -1) {
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(i));
      }
      l1 = this.receivedResponseMillis;
      return l2 + (l1 - this.sentRequestMillis) + (this.nowMillis - l1);
    }
    
    private long computeFreshnessLifetime()
    {
      Object localObject = this.cacheResponse.cacheControl();
      if (((CacheControl)localObject).maxAgeSeconds() != -1) {
        return TimeUnit.SECONDS.toMillis(((CacheControl)localObject).maxAgeSeconds());
      }
      localObject = this.expires;
      long l1 = 0L;
      if (localObject != null)
      {
        localObject = this.servedDate;
        if (localObject != null) {
          l2 = ((Date)localObject).getTime();
        } else {
          l2 = this.receivedResponseMillis;
        }
        l2 = this.expires.getTime() - l2;
        if (l2 > 0L) {
          l1 = l2;
        }
        return l1;
      }
      long l2 = l1;
      if (this.lastModified != null)
      {
        l2 = l1;
        if (this.cacheResponse.request().url().query() == null)
        {
          localObject = this.servedDate;
          if (localObject != null) {
            l2 = ((Date)localObject).getTime();
          } else {
            l2 = this.sentRequestMillis;
          }
          long l3 = l2 - this.lastModified.getTime();
          l2 = l1;
          if (l3 > 0L) {
            l2 = l3 / 10L;
          }
        }
      }
      return l2;
    }
    
    private CacheStrategy getCandidate()
    {
      if (this.cacheResponse == null) {
        return new CacheStrategy(this.request, null);
      }
      if ((this.request.isHttps()) && (this.cacheResponse.handshake() == null)) {
        return new CacheStrategy(this.request, null);
      }
      if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
        return new CacheStrategy(this.request, null);
      }
      Object localObject1 = this.request.cacheControl();
      if ((!((CacheControl)localObject1).noCache()) && (!hasConditions(this.request)))
      {
        Object localObject2 = this.cacheResponse.cacheControl();
        long l1 = cacheResponseAge();
        long l2 = computeFreshnessLifetime();
        long l3 = l2;
        if (((CacheControl)localObject1).maxAgeSeconds() != -1) {
          l3 = Math.min(l2, TimeUnit.SECONDS.toMillis(((CacheControl)localObject1).maxAgeSeconds()));
        }
        int i = ((CacheControl)localObject1).minFreshSeconds();
        long l4 = 0L;
        long l5;
        if (i != -1) {
          l5 = TimeUnit.SECONDS.toMillis(((CacheControl)localObject1).minFreshSeconds());
        } else {
          l5 = 0L;
        }
        l2 = l4;
        if (!((CacheControl)localObject2).mustRevalidate())
        {
          l2 = l4;
          if (((CacheControl)localObject1).maxStaleSeconds() != -1) {
            l2 = TimeUnit.SECONDS.toMillis(((CacheControl)localObject1).maxStaleSeconds());
          }
        }
        if (!((CacheControl)localObject2).noCache())
        {
          l5 += l1;
          if (l5 < l2 + l3)
          {
            localObject2 = this.cacheResponse.newBuilder();
            if (l5 >= l3) {
              ((Response.Builder)localObject2).addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if ((l1 > 86400000L) && (isFreshnessLifetimeHeuristic())) {
              ((Response.Builder)localObject2).addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new CacheStrategy(null, ((Response.Builder)localObject2).build());
          }
        }
        localObject2 = this.etag;
        localObject1 = "If-Modified-Since";
        if (localObject2 != null)
        {
          localObject1 = "If-None-Match";
        }
        else if (this.lastModified != null)
        {
          localObject2 = this.lastModifiedString;
        }
        else
        {
          if (this.servedDate == null) {
            break label410;
          }
          localObject2 = this.servedDateString;
        }
        Headers.Builder localBuilder = this.request.headers().newBuilder();
        Internal.instance.addLenient(localBuilder, (String)localObject1, (String)localObject2);
        return new CacheStrategy(this.request.newBuilder().headers(localBuilder.build()).build(), this.cacheResponse);
        label410:
        return new CacheStrategy(this.request, null);
      }
      return new CacheStrategy(this.request, null);
    }
    
    private static boolean hasConditions(Request paramRequest)
    {
      boolean bool;
      if ((paramRequest.header("If-Modified-Since") == null) && (paramRequest.header("If-None-Match") == null)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    private boolean isFreshnessLifetimeHeuristic()
    {
      boolean bool;
      if ((this.cacheResponse.cacheControl().maxAgeSeconds() == -1) && (this.expires == null)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public CacheStrategy get()
    {
      CacheStrategy localCacheStrategy1 = getCandidate();
      CacheStrategy localCacheStrategy2 = localCacheStrategy1;
      if (localCacheStrategy1.networkRequest != null)
      {
        localCacheStrategy2 = localCacheStrategy1;
        if (this.request.cacheControl().onlyIfCached()) {
          localCacheStrategy2 = new CacheStrategy(null, null);
        }
      }
      return localCacheStrategy2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\cache\CacheStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */