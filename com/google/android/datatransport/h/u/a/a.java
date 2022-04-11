package com.google.android.datatransport.h.u.a;

public final class a<T>
  implements d.a.a<T>
{
  private static final Object a = new Object();
  private volatile d.a.a<T> b;
  private volatile Object c = a;
  
  private a(d.a.a<T> parama)
  {
    this.b = parama;
  }
  
  public static <P extends d.a.a<T>, T> d.a.a<T> a(P paramP)
  {
    d.b(paramP);
    if ((paramP instanceof a)) {
      return paramP;
    }
    return new a(paramP);
  }
  
  public static Object b(Object paramObject1, Object paramObject2)
  {
    int i;
    if (paramObject1 != a) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramObject1 != paramObject2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Scoped provider was invoked recursively returning different results: ");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(" & ");
      localStringBuilder.append(paramObject2);
      localStringBuilder.append(". This is likely due to a circular dependency.");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return paramObject2;
  }
  
  public T get()
  {
    Object localObject1 = this.c;
    Object localObject2 = a;
    Object localObject3 = localObject1;
    if (localObject1 == localObject2) {
      try
      {
        localObject1 = this.c;
        localObject3 = localObject1;
        if (localObject1 == localObject2)
        {
          localObject3 = this.b.get();
          this.c = b(this.c, localObject3);
          this.b = null;
        }
      }
      finally {}
    }
    return ?;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\u\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */