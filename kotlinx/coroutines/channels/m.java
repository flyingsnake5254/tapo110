package kotlinx.coroutines.channels;

public class m<E>
  extends a<E>
{
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
      localObject1 = x(paramE);
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */