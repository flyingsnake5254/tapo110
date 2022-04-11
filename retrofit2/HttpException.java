package retrofit2;

import javax.annotation.Nullable;

public class HttpException
  extends RuntimeException
{
  private final int code;
  private final String message;
  private final transient q<?> response;
  
  public HttpException(q<?> paramq)
  {
    super(getMessage(paramq));
    this.code = paramq.b();
    this.message = paramq.f();
    this.response = paramq;
  }
  
  private static String getMessage(q<?> paramq)
  {
    v.b(paramq, "response == null");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HTTP ");
    localStringBuilder.append(paramq.b());
    localStringBuilder.append(" ");
    localStringBuilder.append(paramq.f());
    return localStringBuilder.toString();
  }
  
  public int code()
  {
    return this.code;
  }
  
  public String message()
  {
    return this.message;
  }
  
  @Nullable
  public q<?> response()
  {
    return this.response;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\HttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */