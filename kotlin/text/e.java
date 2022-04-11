package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.r.a;
import kotlin.sequences.f;
import kotlin.v.d;

final class e
  implements f<d>
{
  private final CharSequence a;
  private final int b;
  private final int c;
  private final p<CharSequence, Integer, Pair<Integer, Integer>> d;
  
  public e(CharSequence paramCharSequence, int paramInt1, int paramInt2, p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> paramp)
  {
    this.a = paramCharSequence;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramp;
  }
  
  public Iterator<d> iterator()
  {
    return new a(this);
  }
  
  public static final class a
    implements Iterator<d>, a
  {
    private int c = -1;
    private int d;
    private int f;
    private d q;
    private int x;
    
    a(e parame)
    {
      int i = kotlin.v.e.f(e.d(parame), 0, e.b(parame).length());
      this.d = i;
      this.f = i;
    }
    
    private final void a()
    {
      int i = this.f;
      int j = 0;
      if (i < 0)
      {
        this.c = 0;
        this.q = null;
      }
      else
      {
        if (e.c(this.y) > 0)
        {
          i = this.x + 1;
          this.x = i;
          if (i >= e.c(this.y)) {}
        }
        else
        {
          if (this.f <= e.b(this.y).length()) {
            break label109;
          }
        }
        this.q = new d(this.d, w.G(e.b(this.y)));
        this.f = -1;
        break label238;
        label109:
        Pair localPair = (Pair)e.a(this.y).invoke(e.b(this.y), Integer.valueOf(this.f));
        if (localPair == null)
        {
          this.q = new d(this.d, w.G(e.b(this.y)));
          this.f = -1;
        }
        else
        {
          int k = ((Number)localPair.component1()).intValue();
          i = ((Number)localPair.component2()).intValue();
          this.q = kotlin.v.e.i(this.d, k);
          k += i;
          this.d = k;
          if (i == 0) {
            j = 1;
          }
          this.f = (k + j);
        }
        label238:
        this.c = 1;
      }
    }
    
    public d b()
    {
      if (this.c == -1) {
        a();
      }
      if (this.c != 0)
      {
        d locald = this.q;
        Objects.requireNonNull(locald, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.q = null;
        this.c = -1;
        return locald;
      }
      throw new NoSuchElementException();
    }
    
    public boolean hasNext()
    {
      if (this.c == -1) {
        a();
      }
      int i = this.c;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */