package io.netty.util;

public final class AttributeKey<T>
  extends AbstractConstant<AttributeKey<T>>
{
  private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool()
  {
    protected AttributeKey<Object> newConstant(int paramAnonymousInt, String paramAnonymousString)
    {
      return new AttributeKey(paramAnonymousInt, paramAnonymousString, null);
    }
  };
  
  private AttributeKey(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public static boolean exists(String paramString)
  {
    return pool.exists(paramString);
  }
  
  public static <T> AttributeKey<T> newInstance(String paramString)
  {
    return (AttributeKey)pool.newInstance(paramString);
  }
  
  public static <T> AttributeKey<T> valueOf(Class<?> paramClass, String paramString)
  {
    return (AttributeKey)pool.valueOf(paramClass, paramString);
  }
  
  public static <T> AttributeKey<T> valueOf(String paramString)
  {
    return (AttributeKey)pool.valueOf(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\AttributeKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */