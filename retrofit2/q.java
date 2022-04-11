package retrofit2;

import javax.annotation.Nullable;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class q<T>
{
  private final Response a;
  @Nullable
  private final T b;
  @Nullable
  private final ResponseBody c;
  
  private q(Response paramResponse, @Nullable T paramT, @Nullable ResponseBody paramResponseBody)
  {
    this.a = paramResponse;
    this.b = paramT;
    this.c = paramResponseBody;
  }
  
  public static <T> q<T> c(ResponseBody paramResponseBody, Response paramResponse)
  {
    v.b(paramResponseBody, "body == null");
    v.b(paramResponse, "rawResponse == null");
    if (!paramResponse.isSuccessful()) {
      return new q(paramResponse, null, paramResponseBody);
    }
    throw new IllegalArgumentException("rawResponse should not be successful response");
  }
  
  public static <T> q<T> g(@Nullable T paramT, Response paramResponse)
  {
    v.b(paramResponse, "rawResponse == null");
    if (paramResponse.isSuccessful()) {
      return new q(paramResponse, paramT, null);
    }
    throw new IllegalArgumentException("rawResponse must be successful response");
  }
  
  @Nullable
  public T a()
  {
    return (T)this.b;
  }
  
  public int b()
  {
    return this.a.code();
  }
  
  @Nullable
  public ResponseBody d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.a.isSuccessful();
  }
  
  public String f()
  {
    return this.a.message();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */