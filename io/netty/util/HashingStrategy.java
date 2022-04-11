package io.netty.util;

public abstract interface HashingStrategy<T>
{
  public static final HashingStrategy JAVA_HASHER = new HashingStrategy()
  {
    public boolean equals(Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      boolean bool;
      if ((paramAnonymousObject1 != paramAnonymousObject2) && ((paramAnonymousObject1 == null) || (!paramAnonymousObject1.equals(paramAnonymousObject2)))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public int hashCode(Object paramAnonymousObject)
    {
      int i;
      if (paramAnonymousObject != null) {
        i = paramAnonymousObject.hashCode();
      } else {
        i = 0;
      }
      return i;
    }
  };
  
  public abstract boolean equals(T paramT1, T paramT2);
  
  public abstract int hashCode(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\HashingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */