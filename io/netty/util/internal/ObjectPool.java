package io.netty.util.internal;

import io.netty.util.Recycler;
import io.netty.util.Recycler.a;

public abstract class ObjectPool<T>
{
  public static <T> ObjectPool<T> newPool(ObjectCreator<T> paramObjectCreator)
  {
    return new RecyclerObjectPool((ObjectCreator)ObjectUtil.checkNotNull(paramObjectCreator, "creator"));
  }
  
  public abstract T get();
  
  public static abstract interface Handle<T>
  {
    public abstract void recycle(T paramT);
  }
  
  public static abstract interface ObjectCreator<T>
  {
    public abstract T newObject(ObjectPool.Handle<T> paramHandle);
  }
  
  private static final class RecyclerObjectPool<T>
    extends ObjectPool<T>
  {
    private final Recycler<T> recycler;
    
    RecyclerObjectPool(final ObjectPool.ObjectCreator<T> paramObjectCreator)
    {
      this.recycler = new Recycler()
      {
        protected T newObject(Recycler.a<T> paramAnonymousa)
        {
          return (T)paramObjectCreator.newObject(paramAnonymousa);
        }
      };
    }
    
    public T get()
    {
      return (T)this.recycler.get();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ObjectPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */