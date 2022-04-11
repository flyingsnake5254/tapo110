package com.bumptech.glide.load.engine.a0;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.f;

public class g
  extends f<c, u<?>>
  implements h
{
  private h.a e;
  
  public g(long paramLong)
  {
    super(paramLong);
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (paramInt >= 40) {
      b();
    } else if ((paramInt >= 20) || (paramInt == 15)) {
      m(h() / 2L);
    }
  }
  
  public void e(@NonNull h.a parama)
  {
    this.e = parama;
  }
  
  protected int n(@Nullable u<?> paramu)
  {
    if (paramu == null) {
      return super.i(null);
    }
    return paramu.a();
  }
  
  protected void o(@NonNull c paramc, @Nullable u<?> paramu)
  {
    paramc = this.e;
    if ((paramc != null) && (paramu != null)) {
      paramc.a(paramu);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */