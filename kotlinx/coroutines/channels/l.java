package kotlinx.coroutines.channels;

import kotlin.TypeCastException;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.i;

public class l<E>
  extends a<E>
{
  private final void T(c.a<? extends E> parama)
  {
    for (parama = parama.D(); (parama instanceof c.a); parama = parama.D()) {
      if (!parama.I()) {
        parama.F();
      }
    }
  }
  
  private final s<?> U(E paramE)
  {
    paramE = new c.a(paramE);
    g localg = o();
    Object localObject;
    do
    {
      localObject = localg.C();
      if (localObject == null) {
        break;
      }
      localObject = (i)localObject;
      if ((localObject instanceof s)) {
        return (s)localObject;
      }
    } while (!((i)localObject).u(paramE, localg));
    T(paramE);
    return null;
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
  }
  
  protected final boolean K()
  {
    return true;
  }
  
  protected final boolean L()
  {
    return true;
  }
  
  protected final boolean s()
  {
    return false;
  }
  
  protected final boolean t()
  {
    return false;
  }
  
  protected Object v(E paramE)
  {
    Object localObject1;
    do
    {
      localObject1 = super.v(paramE);
      Object localObject2 = b.a;
      if (localObject1 == localObject2) {
        return localObject2;
      }
      if (localObject1 != b.b) {
        break;
      }
      localObject1 = U(paramE);
      if (localObject1 == null) {
        return localObject2;
      }
    } while (!(localObject1 instanceof k));
    return localObject1;
    if ((localObject1 instanceof k)) {
      return localObject1;
    }
    paramE = new StringBuilder();
    paramE.append("Invalid offerInternal result ");
    paramE.append(localObject1);
    throw new IllegalStateException(paramE.toString().toString());
  }
  
  protected void w(i parami)
  {
    j.f(parami, "closed");
    i locali = parami.D();
    parami = locali;
    if (!(locali instanceof c.a)) {
      parami = null;
    }
    parami = (c.a)parami;
    if (parami != null) {
      T(parami);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */