package io.reactivex.internal.util;

import io.reactivex.v;
import java.io.Serializable;

public enum NotificationLite
{
  static
  {
    NotificationLite localNotificationLite = new NotificationLite("COMPLETE", 0);
    COMPLETE = localNotificationLite;
    $VALUES = new NotificationLite[] { localNotificationLite };
  }
  
  public static <T> boolean accept(Object paramObject, e.b.b<? super T> paramb)
  {
    if (paramObject == COMPLETE)
    {
      paramb.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramb.onError(((b)paramObject).c);
      return true;
    }
    paramb.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean accept(Object paramObject, v<? super T> paramv)
  {
    if (paramObject == COMPLETE)
    {
      paramv.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramv.onError(((b)paramObject).c);
      return true;
    }
    paramv.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, e.b.b<? super T> paramb)
  {
    if (paramObject == COMPLETE)
    {
      paramb.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramb.onError(((b)paramObject).c);
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramb.onSubscribe(((c)paramObject).c);
      return false;
    }
    paramb.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, v<? super T> paramv)
  {
    if (paramObject == COMPLETE)
    {
      paramv.onComplete();
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramv.onError(((b)paramObject).c);
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramv.onSubscribe(((a)paramObject).c);
      return false;
    }
    paramv.onNext(paramObject);
    return false;
  }
  
  public static Object complete()
  {
    return COMPLETE;
  }
  
  public static Object disposable(io.reactivex.e0.c paramc)
  {
    return new a(paramc);
  }
  
  public static Object error(Throwable paramThrowable)
  {
    return new b(paramThrowable);
  }
  
  public static io.reactivex.e0.c getDisposable(Object paramObject)
  {
    return ((a)paramObject).c;
  }
  
  public static Throwable getError(Object paramObject)
  {
    return ((b)paramObject).c;
  }
  
  public static e.b.c getSubscription(Object paramObject)
  {
    return ((c)paramObject).c;
  }
  
  public static <T> T getValue(Object paramObject)
  {
    return (T)paramObject;
  }
  
  public static boolean isComplete(Object paramObject)
  {
    boolean bool;
    if (paramObject == COMPLETE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isDisposable(Object paramObject)
  {
    return paramObject instanceof a;
  }
  
  public static boolean isError(Object paramObject)
  {
    return paramObject instanceof b;
  }
  
  public static boolean isSubscription(Object paramObject)
  {
    return paramObject instanceof c;
  }
  
  public static <T> Object next(T paramT)
  {
    return paramT;
  }
  
  public static Object subscription(e.b.c paramc)
  {
    return new c(paramc);
  }
  
  public String toString()
  {
    return "NotificationLite.Complete";
  }
  
  static final class a
    implements Serializable
  {
    final io.reactivex.e0.c c;
    
    a(io.reactivex.e0.c paramc)
    {
      this.c = paramc;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationLite.Disposable[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    implements Serializable
  {
    final Throwable c;
    
    b(Throwable paramThrowable)
    {
      this.c = paramThrowable;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        return io.reactivex.h0.a.b.c(this.c, ((b)paramObject).c);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationLite.Error[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    implements Serializable
  {
    final e.b.c c;
    
    c(e.b.c paramc)
    {
      this.c = paramc;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationLite.Subscription[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\NotificationLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */