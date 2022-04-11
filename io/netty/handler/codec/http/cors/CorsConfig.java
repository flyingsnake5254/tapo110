package io.netty.handler.codec.http.cors;

import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public final class CorsConfig
{
  private final boolean allowCredentials;
  private final boolean allowNullOrigin;
  private final Set<String> allowedRequestHeaders;
  private final Set<HttpMethod> allowedRequestMethods;
  private final boolean anyOrigin;
  private final boolean enabled;
  private final Set<String> exposeHeaders;
  private final long maxAge;
  private final Set<String> origins;
  private final Map<CharSequence, Callable<?>> preflightHeaders;
  private final boolean shortCircuit;
  
  CorsConfig(CorsConfigBuilder paramCorsConfigBuilder)
  {
    this.origins = new LinkedHashSet(paramCorsConfigBuilder.origins);
    this.anyOrigin = paramCorsConfigBuilder.anyOrigin;
    this.enabled = paramCorsConfigBuilder.enabled;
    this.exposeHeaders = paramCorsConfigBuilder.exposeHeaders;
    this.allowCredentials = paramCorsConfigBuilder.allowCredentials;
    this.maxAge = paramCorsConfigBuilder.maxAge;
    this.allowedRequestMethods = paramCorsConfigBuilder.requestMethods;
    this.allowedRequestHeaders = paramCorsConfigBuilder.requestHeaders;
    this.allowNullOrigin = paramCorsConfigBuilder.allowNullOrigin;
    this.preflightHeaders = paramCorsConfigBuilder.preflightHeaders;
    this.shortCircuit = paramCorsConfigBuilder.shortCircuit;
  }
  
  private static <T> T getValue(Callable<T> paramCallable)
  {
    try
    {
      Object localObject = paramCallable.call();
      return (T)localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not generate value for callable [");
      localStringBuilder.append(paramCallable);
      localStringBuilder.append(']');
      throw new IllegalStateException(localStringBuilder.toString(), localException);
    }
  }
  
  @Deprecated
  public static Builder withAnyOrigin()
  {
    return new Builder();
  }
  
  @Deprecated
  public static Builder withOrigin(String paramString)
  {
    if ("*".equals(paramString)) {
      return new Builder();
    }
    return new Builder(new String[] { paramString });
  }
  
  @Deprecated
  public static Builder withOrigins(String... paramVarArgs)
  {
    return new Builder(paramVarArgs);
  }
  
  public Set<String> allowedRequestHeaders()
  {
    return Collections.unmodifiableSet(this.allowedRequestHeaders);
  }
  
  public Set<HttpMethod> allowedRequestMethods()
  {
    return Collections.unmodifiableSet(this.allowedRequestMethods);
  }
  
  public Set<String> exposedHeaders()
  {
    return Collections.unmodifiableSet(this.exposeHeaders);
  }
  
  public boolean isAnyOriginSupported()
  {
    return this.anyOrigin;
  }
  
  public boolean isCorsSupportEnabled()
  {
    return this.enabled;
  }
  
  public boolean isCredentialsAllowed()
  {
    return this.allowCredentials;
  }
  
  public boolean isNullOriginAllowed()
  {
    return this.allowNullOrigin;
  }
  
  public boolean isShortCircuit()
  {
    return this.shortCircuit;
  }
  
  @Deprecated
  public boolean isShortCurcuit()
  {
    return isShortCircuit();
  }
  
  public long maxAge()
  {
    return this.maxAge;
  }
  
  public String origin()
  {
    String str;
    if (this.origins.isEmpty()) {
      str = "*";
    } else {
      str = (String)this.origins.iterator().next();
    }
    return str;
  }
  
  public Set<String> origins()
  {
    return this.origins;
  }
  
  public HttpHeaders preflightResponseHeaders()
  {
    if (this.preflightHeaders.isEmpty()) {
      return EmptyHttpHeaders.INSTANCE;
    }
    DefaultHttpHeaders localDefaultHttpHeaders = new DefaultHttpHeaders();
    Iterator localIterator = this.preflightHeaders.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = getValue((Callable)localEntry.getValue());
      if ((localObject instanceof Iterable)) {
        localDefaultHttpHeaders.add((CharSequence)localEntry.getKey(), (Iterable)localObject);
      } else {
        localDefaultHttpHeaders.add((CharSequence)localEntry.getKey(), localObject);
      }
    }
    return localDefaultHttpHeaders;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("[enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", origins=");
    localStringBuilder.append(this.origins);
    localStringBuilder.append(", anyOrigin=");
    localStringBuilder.append(this.anyOrigin);
    localStringBuilder.append(", exposedHeaders=");
    localStringBuilder.append(this.exposeHeaders);
    localStringBuilder.append(", isCredentialsAllowed=");
    localStringBuilder.append(this.allowCredentials);
    localStringBuilder.append(", maxAge=");
    localStringBuilder.append(this.maxAge);
    localStringBuilder.append(", allowedRequestMethods=");
    localStringBuilder.append(this.allowedRequestMethods);
    localStringBuilder.append(", allowedRequestHeaders=");
    localStringBuilder.append(this.allowedRequestHeaders);
    localStringBuilder.append(", preflightHeaders=");
    localStringBuilder.append(this.preflightHeaders);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  @Deprecated
  public static class Builder
  {
    private final CorsConfigBuilder builder;
    
    @Deprecated
    public Builder()
    {
      this.builder = new CorsConfigBuilder();
    }
    
    @Deprecated
    public Builder(String... paramVarArgs)
    {
      this.builder = new CorsConfigBuilder(paramVarArgs);
    }
    
    @Deprecated
    public Builder allowCredentials()
    {
      this.builder.allowCredentials();
      return this;
    }
    
    @Deprecated
    public Builder allowNullOrigin()
    {
      this.builder.allowNullOrigin();
      return this;
    }
    
    @Deprecated
    public Builder allowedRequestHeaders(String... paramVarArgs)
    {
      this.builder.allowedRequestHeaders(paramVarArgs);
      return this;
    }
    
    @Deprecated
    public Builder allowedRequestMethods(HttpMethod... paramVarArgs)
    {
      this.builder.allowedRequestMethods(paramVarArgs);
      return this;
    }
    
    @Deprecated
    public CorsConfig build()
    {
      return this.builder.build();
    }
    
    @Deprecated
    public Builder disable()
    {
      this.builder.disable();
      return this;
    }
    
    @Deprecated
    public Builder exposeHeaders(String... paramVarArgs)
    {
      this.builder.exposeHeaders(paramVarArgs);
      return this;
    }
    
    @Deprecated
    public Builder maxAge(long paramLong)
    {
      this.builder.maxAge(paramLong);
      return this;
    }
    
    @Deprecated
    public Builder noPreflightResponseHeaders()
    {
      this.builder.noPreflightResponseHeaders();
      return this;
    }
    
    @Deprecated
    public <T> Builder preflightResponseHeader(CharSequence paramCharSequence, Iterable<T> paramIterable)
    {
      this.builder.preflightResponseHeader(paramCharSequence, paramIterable);
      return this;
    }
    
    @Deprecated
    public Builder preflightResponseHeader(CharSequence paramCharSequence, Object... paramVarArgs)
    {
      this.builder.preflightResponseHeader(paramCharSequence, paramVarArgs);
      return this;
    }
    
    @Deprecated
    public <T> Builder preflightResponseHeader(String paramString, Callable<T> paramCallable)
    {
      this.builder.preflightResponseHeader(paramString, paramCallable);
      return this;
    }
    
    @Deprecated
    public Builder shortCurcuit()
    {
      this.builder.shortCircuit();
      return this;
    }
  }
  
  @Deprecated
  public static final class DateValueGenerator
    implements Callable<Date>
  {
    public Date call()
      throws Exception
    {
      return new Date();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cors\CorsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */