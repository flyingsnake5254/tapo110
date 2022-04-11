package com.bumptech.glide.request.k;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.j;

@Deprecated
public abstract class h<Z>
  extends a<Z>
{
  private final int d;
  private final int f;
  
  public h()
  {
    this(Integer.MIN_VALUE, Integer.MIN_VALUE);
  }
  
  public h(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.f = paramInt2;
  }
  
  public void a(@NonNull i parami) {}
  
  public final void j(@NonNull i parami)
  {
    if (j.u(this.d, this.f))
    {
      parami.d(this.d, this.f);
      return;
    }
    parami = new StringBuilder();
    parami.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
    parami.append(this.d);
    parami.append(" and height: ");
    parami.append(this.f);
    parami.append(", either provide dimensions in the constructor or call override()");
    throw new IllegalArgumentException(parami.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\k\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */