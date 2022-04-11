package kotlin.v;

import java.util.NoSuchElementException;
import kotlin.collections.z;

public final class c
  extends z
{
  private final int c;
  private boolean d;
  private int f;
  private final int q;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.q = paramInt3;
    this.c = paramInt2;
    boolean bool = true;
    if (paramInt3 > 0 ? paramInt1 > paramInt2 : paramInt1 < paramInt2) {
      bool = false;
    }
    this.d = bool;
    if (!bool) {
      paramInt1 = paramInt2;
    }
    this.f = paramInt1;
  }
  
  public boolean hasNext()
  {
    return this.d;
  }
  
  public int nextInt()
  {
    int i = this.f;
    if (i == this.c)
    {
      if (this.d) {
        this.d = false;
      } else {
        throw new NoSuchElementException();
      }
    }
    else {
      this.f = (this.q + i);
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\v\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */