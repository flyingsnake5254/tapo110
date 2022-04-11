package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;

public abstract class h
  implements l
{
  private final boolean b;
  private final ArrayList<a0> c;
  private int d;
  @Nullable
  private n e;
  
  protected h(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c = new ArrayList(1);
  }
  
  public final void b(a0 parama0)
  {
    g.e(parama0);
    if (!this.c.contains(parama0))
    {
      this.c.add(parama0);
      this.d += 1;
    }
  }
  
  protected final void o(int paramInt)
  {
    n localn = (n)o0.i(this.e);
    for (int i = 0; i < this.d; i++) {
      ((a0)this.c.get(i)).f(this, localn, this.b, paramInt);
    }
  }
  
  protected final void p()
  {
    n localn = (n)o0.i(this.e);
    for (int i = 0; i < this.d; i++) {
      ((a0)this.c.get(i)).b(this, localn, this.b);
    }
    this.e = null;
  }
  
  protected final void q(n paramn)
  {
    for (int i = 0; i < this.d; i++) {
      ((a0)this.c.get(i)).i(this, paramn, this.b);
    }
  }
  
  protected final void r(n paramn)
  {
    this.e = paramn;
    for (int i = 0; i < this.d; i++) {
      ((a0)this.c.get(i)).h(this, paramn, this.b);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */