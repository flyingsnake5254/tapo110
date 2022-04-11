package kotlinx.coroutines;

public class f1
  extends j1
  implements q
{
  private final boolean d;
  
  public f1(d1 paramd1)
  {
    super(true);
    O(paramd1);
    this.d = p0();
  }
  
  private final boolean p0()
  {
    m localm = this.parentHandle;
    Object localObject = localm;
    if (!(localm instanceof n)) {
      localObject = null;
    }
    localObject = (n)localObject;
    if (localObject != null)
    {
      localObject = (j1)((i1)localObject).q;
      if (localObject != null) {
        do
        {
          if (((j1)localObject).I()) {
            return true;
          }
          localm = ((j1)localObject).parentHandle;
          localObject = localm;
          if (!(localm instanceof n)) {
            localObject = null;
          }
          localObject = (n)localObject;
          if (localObject == null) {
            break;
          }
          localObject = (j1)((i1)localObject).q;
        } while (localObject != null);
      }
    }
    return false;
  }
  
  public boolean I()
  {
    return this.d;
  }
  
  public boolean J()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\f1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */