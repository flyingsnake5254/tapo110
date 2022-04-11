package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.b;
import com.google.android.exoplayer2.metadata.id3.b.a;
import com.google.android.exoplayer2.util.d0;
import java.io.EOFException;
import java.io.IOException;

public final class v
{
  private final d0 a = new d0(10);
  
  @Nullable
  public Metadata a(k paramk, @Nullable b.a parama)
    throws IOException
  {
    Object localObject = null;
    int i = 0;
    try
    {
      for (;;)
      {
        paramk.n(this.a.d(), 0, 10);
        this.a.P(0);
        if (this.a.G() != 4801587) {
          break;
        }
        this.a.Q(3);
        int j = this.a.C();
        int k = j + 10;
        if (localObject == null)
        {
          localObject = new byte[k];
          System.arraycopy(this.a.d(), 0, localObject, 0, 10);
          paramk.n((byte[])localObject, 10, j);
          localObject = new b(parama).d((byte[])localObject, k);
        }
        else
        {
          paramk.h(j);
        }
        i += k;
      }
    }
    catch (EOFException parama)
    {
      for (;;) {}
    }
    paramk.e();
    paramk.h(i);
    return (Metadata)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */