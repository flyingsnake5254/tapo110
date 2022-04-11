package io.netty.handler.codec;

public class UnsupportedMessageTypeException
  extends CodecException
{
  private static final long serialVersionUID = 2799598826487038726L;
  
  public UnsupportedMessageTypeException() {}
  
  public UnsupportedMessageTypeException(Object paramObject, Class<?>... paramVarArgs)
  {
    super(message((String)paramObject, paramVarArgs));
  }
  
  public UnsupportedMessageTypeException(String paramString)
  {
    super(paramString);
  }
  
  public UnsupportedMessageTypeException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UnsupportedMessageTypeException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  private static String message(String paramString, Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localStringBuilder.append(" (expected: ");
      localStringBuilder.append(paramVarArgs[0].getName());
      for (int i = 1; i < paramVarArgs.length; i++)
      {
        paramString = paramVarArgs[i];
        if (paramString == null) {
          break;
        }
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString.getName());
      }
      localStringBuilder.append(')');
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\UnsupportedMessageTypeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */