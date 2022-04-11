package kotlin.coroutines;

import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.j;

public final class CombinedContext
  implements f, Serializable
{
  private final f.b element;
  private final f left;
  
  public CombinedContext(f paramf, f.b paramb)
  {
    this.left = paramf;
    this.element = paramb;
  }
  
  private final boolean contains(f.b paramb)
  {
    return j.a(get(paramb.getKey()), paramb);
  }
  
  private final boolean containsAll(CombinedContext paramCombinedContext)
  {
    for (;;)
    {
      if (!contains(paramCombinedContext.element)) {
        return false;
      }
      paramCombinedContext = paramCombinedContext.left;
      if (!(paramCombinedContext instanceof CombinedContext)) {
        break;
      }
      paramCombinedContext = (CombinedContext)paramCombinedContext;
    }
    Objects.requireNonNull(paramCombinedContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
    return contains((f.b)paramCombinedContext);
  }
  
  private final int size()
  {
    int i = 2;
    Object localObject = this;
    for (;;)
    {
      f localf = ((CombinedContext)localObject).left;
      localObject = localf;
      if (!(localf instanceof CombinedContext)) {
        localObject = null;
      }
      localObject = (CombinedContext)localObject;
      if (localObject == null) {
        break;
      }
      i++;
    }
    return i;
  }
  
  private final Object writeReplace()
  {
    int i = size();
    f[] arrayOff = new f[i];
    final Ref.IntRef localIntRef = new Ref.IntRef();
    int j = 0;
    localIntRef.element = 0;
    fold(kotlin.p.a, new c(arrayOff, localIntRef));
    if (localIntRef.element == i) {
      j = 1;
    }
    if (j != 0) {
      return new a(arrayOff);
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CombinedContext))
      {
        paramObject = (CombinedContext)paramObject;
        if ((((CombinedContext)paramObject).size() == size()) && (((CombinedContext)paramObject).containsAll(this))) {}
      }
      else
      {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public <R> R fold(R paramR, kotlin.jvm.b.p<? super R, ? super f.b, ? extends R> paramp)
  {
    j.e(paramp, "operation");
    return (R)paramp.invoke(this.left.fold(paramR, paramp), this.element);
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    j.e(paramc, "key");
    for (Object localObject = this;; localObject = (CombinedContext)localObject)
    {
      f.b localb = ((CombinedContext)localObject).element.get(paramc);
      if (localb != null) {
        return localb;
      }
      localObject = ((CombinedContext)localObject).left;
      if (!(localObject instanceof CombinedContext)) {
        break;
      }
    }
    return ((f)localObject).get(paramc);
  }
  
  public int hashCode()
  {
    return this.left.hashCode() + this.element.hashCode();
  }
  
  public f minusKey(f.c<?> paramc)
  {
    j.e(paramc, "key");
    if (this.element.get(paramc) != null) {
      return this.left;
    }
    paramc = this.left.minusKey(paramc);
    if (paramc == this.left) {
      paramc = this;
    } else if (paramc == EmptyCoroutineContext.INSTANCE) {
      paramc = this.element;
    } else {
      paramc = new CombinedContext(paramc, this.element);
    }
    return paramc;
  }
  
  public f plus(f paramf)
  {
    j.e(paramf, "context");
    return f.a.a(this, paramf);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append((String)fold("", b.c));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private static final class a
    implements Serializable
  {
    public static final a c = new a(null);
    private final f[] d;
    
    public a(f[] paramArrayOff)
    {
      this.d = paramArrayOff;
    }
    
    public static final class a {}
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.p<String, f.b, String>
  {
    public static final b c = new b();
    
    b()
    {
      super();
    }
    
    public final String a(String paramString, f.b paramb)
    {
      j.e(paramString, "acc");
      j.e(paramb, "element");
      int i;
      if (paramString.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramString = paramb.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramb);
        paramString = localStringBuilder.toString();
      }
      return paramString;
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.p<kotlin.p, f.b, kotlin.p>
  {
    c(f[] paramArrayOff, Ref.IntRef paramIntRef)
    {
      super();
    }
    
    public final void a(kotlin.p paramp, f.b paramb)
    {
      j.e(paramp, "<anonymous parameter 0>");
      j.e(paramb, "element");
      f[] arrayOff = this.c;
      paramp = localIntRef;
      int i = paramp.element;
      paramp.element = (i + 1);
      arrayOff[i] = paramb;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\CombinedContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */