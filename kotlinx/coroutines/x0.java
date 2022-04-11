package kotlinx.coroutines;

public final class x0
  implements y0
{
  private final n1 c;
  
  public x0(n1 paramn1)
  {
    this.c = paramn1;
  }
  
  public n1 d()
  {
    return this.c;
  }
  
  public boolean isActive()
  {
    return false;
  }
  
  public String toString()
  {
    String str;
    if (g0.c()) {
      str = d().L("New");
    } else {
      str = super.toString();
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\x0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */