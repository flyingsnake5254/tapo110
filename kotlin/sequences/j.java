package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;

class j
  extends i
{
  public static <T> f<T> a(Iterator<? extends T> paramIterator)
  {
    kotlin.jvm.internal.j.e(paramIterator, "$this$asSequence");
    return b(new a(paramIterator));
  }
  
  public static final <T> f<T> b(f<? extends T> paramf)
  {
    kotlin.jvm.internal.j.e(paramf, "$this$constrainOnce");
    if (!(paramf instanceof a)) {
      paramf = new a(paramf);
    }
    return paramf;
  }
  
  public static <T> f<T> c(kotlin.jvm.b.a<? extends T> parama, l<? super T, ? extends T> paraml)
  {
    kotlin.jvm.internal.j.e(parama, "seedFunction");
    kotlin.jvm.internal.j.e(paraml, "nextFunction");
    return new e(parama, paraml);
  }
  
  public static final class a
    implements f<T>
  {
    public a(Iterator paramIterator) {}
    
    public Iterator<T> iterator()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\sequences\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */