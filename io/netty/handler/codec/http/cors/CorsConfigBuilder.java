package io.netty.handler.codec.http.cors;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public final class CorsConfigBuilder
{
  boolean allowCredentials;
  boolean allowNullOrigin;
  final boolean anyOrigin;
  boolean enabled = true;
  final Set<String> exposeHeaders = new HashSet();
  long maxAge;
  private boolean noPreflightHeaders;
  final Set<String> origins;
  final Map<CharSequence, Callable<?>> preflightHeaders = new HashMap();
  final Set<String> requestHeaders = new HashSet();
  final Set<HttpMethod> requestMethods = new HashSet();
  boolean shortCircuit;
  
  CorsConfigBuilder()
  {
    this.anyOrigin = true;
    this.origins = Collections.emptySet();
  }
  
  CorsConfigBuilder(String... paramVarArgs)
  {
    this.origins = new LinkedHashSet(Arrays.asList(paramVarArgs));
    this.anyOrigin = false;
  }
  
  public static CorsConfigBuilder forAnyOrigin()
  {
    return new CorsConfigBuilder();
  }
  
  public static CorsConfigBuilder forOrigin(String paramString)
  {
    if ("*".equals(paramString)) {
      return new CorsConfigBuilder();
    }
    return new CorsConfigBuilder(new String[] { paramString });
  }
  
  public static CorsConfigBuilder forOrigins(String... paramVarArgs)
  {
    return new CorsConfigBuilder(paramVarArgs);
  }
  
  public CorsConfigBuilder allowCredentials()
  {
    this.allowCredentials = true;
    return this;
  }
  
  public CorsConfigBuilder allowNullOrigin()
  {
    this.allowNullOrigin = true;
    return this;
  }
  
  public CorsConfigBuilder allowedRequestHeaders(CharSequence... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      CharSequence localCharSequence = paramVarArgs[j];
      this.requestHeaders.add(localCharSequence.toString());
    }
    return this;
  }
  
  public CorsConfigBuilder allowedRequestHeaders(String... paramVarArgs)
  {
    this.requestHeaders.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public CorsConfigBuilder allowedRequestMethods(HttpMethod... paramVarArgs)
  {
    this.requestMethods.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public CorsConfig build()
  {
    if ((this.preflightHeaders.isEmpty()) && (!this.noPreflightHeaders))
    {
      this.preflightHeaders.put(HttpHeaderNames.DATE, DateValueGenerator.INSTANCE);
      this.preflightHeaders.put(HttpHeaderNames.CONTENT_LENGTH, new ConstantValueGenerator("0", null));
    }
    return new CorsConfig(this);
  }
  
  public CorsConfigBuilder disable()
  {
    this.enabled = false;
    return this;
  }
  
  public CorsConfigBuilder exposeHeaders(CharSequence... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      CharSequence localCharSequence = paramVarArgs[j];
      this.exposeHeaders.add(localCharSequence.toString());
    }
    return this;
  }
  
  public CorsConfigBuilder exposeHeaders(String... paramVarArgs)
  {
    this.exposeHeaders.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public CorsConfigBuilder maxAge(long paramLong)
  {
    this.maxAge = paramLong;
    return this;
  }
  
  public CorsConfigBuilder noPreflightResponseHeaders()
  {
    this.noPreflightHeaders = true;
    return this;
  }
  
  public <T> CorsConfigBuilder preflightResponseHeader(CharSequence paramCharSequence, Iterable<T> paramIterable)
  {
    this.preflightHeaders.put(paramCharSequence, new ConstantValueGenerator(paramIterable, null));
    return this;
  }
  
  public <T> CorsConfigBuilder preflightResponseHeader(CharSequence paramCharSequence, Callable<T> paramCallable)
  {
    this.preflightHeaders.put(paramCharSequence, paramCallable);
    return this;
  }
  
  public CorsConfigBuilder preflightResponseHeader(CharSequence paramCharSequence, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 1) {
      this.preflightHeaders.put(paramCharSequence, new ConstantValueGenerator(paramVarArgs[0], null));
    } else {
      preflightResponseHeader(paramCharSequence, Arrays.asList(paramVarArgs));
    }
    return this;
  }
  
  public CorsConfigBuilder shortCircuit()
  {
    this.shortCircuit = true;
    return this;
  }
  
  private static final class ConstantValueGenerator
    implements Callable<Object>
  {
    private final Object value;
    
    private ConstantValueGenerator(Object paramObject)
    {
      if (paramObject != null)
      {
        this.value = paramObject;
        return;
      }
      throw new IllegalArgumentException("value must not be null");
    }
    
    public Object call()
    {
      return this.value;
    }
  }
  
  private static final class DateValueGenerator
    implements Callable<Date>
  {
    static final DateValueGenerator INSTANCE = new DateValueGenerator();
    
    public Date call()
      throws Exception
    {
      return new Date();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cors\CorsConfigBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */