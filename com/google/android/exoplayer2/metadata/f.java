package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends u0
  implements Handler.Callback
{
  private final c I3;
  private final e J3;
  @Nullable
  private final Handler K3;
  private final d L3;
  @Nullable
  private b M3;
  private boolean N3;
  private boolean O3;
  private long P3;
  private long Q3;
  @Nullable
  private Metadata R3;
  
  public f(e parame, @Nullable Looper paramLooper)
  {
    this(parame, paramLooper, c.a);
  }
  
  public f(e parame, @Nullable Looper paramLooper, c paramc)
  {
    super(5);
    this.J3 = ((e)g.e(parame));
    if (paramLooper == null) {
      parame = null;
    } else {
      parame = o0.u(paramLooper, this);
    }
    this.K3 = parame;
    this.I3 = ((c)g.e(paramc));
    this.L3 = new d();
    this.Q3 = -9223372036854775807L;
  }
  
  private void N(Metadata paramMetadata, List<Metadata.Entry> paramList)
  {
    for (int i = 0; i < paramMetadata.d(); i++)
    {
      Object localObject = paramMetadata.c(i).g();
      if ((localObject != null) && (this.I3.a((Format)localObject)))
      {
        localObject = this.I3.b((Format)localObject);
        byte[] arrayOfByte = (byte[])g.e(paramMetadata.c(i).k());
        this.L3.f();
        this.L3.o(arrayOfByte.length);
        ((ByteBuffer)o0.i(this.L3.f)).put(arrayOfByte);
        this.L3.p();
        localObject = ((b)localObject).a(this.L3);
        if (localObject != null) {
          N((Metadata)localObject, paramList);
        }
      }
      else
      {
        paramList.add(paramMetadata.c(i));
      }
    }
  }
  
  private void O(Metadata paramMetadata)
  {
    Handler localHandler = this.K3;
    if (localHandler != null) {
      localHandler.obtainMessage(0, paramMetadata).sendToTarget();
    } else {
      P(paramMetadata);
    }
  }
  
  private void P(Metadata paramMetadata)
  {
    this.J3.w(paramMetadata);
  }
  
  private boolean Q(long paramLong)
  {
    Metadata localMetadata = this.R3;
    boolean bool;
    if ((localMetadata != null) && (this.Q3 <= paramLong))
    {
      O(localMetadata);
      this.R3 = null;
      this.Q3 = -9223372036854775807L;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((this.N3) && (this.R3 == null)) {
      this.O3 = true;
    }
    return bool;
  }
  
  private void R()
  {
    if ((!this.N3) && (this.R3 == null))
    {
      this.L3.f();
      Object localObject = A();
      int i = L((i1)localObject, this.L3, 0);
      if (i == -4)
      {
        if (this.L3.k())
        {
          this.N3 = true;
        }
        else
        {
          localObject = this.L3;
          ((d)localObject).p1 = this.P3;
          ((DecoderInputBuffer)localObject).p();
          localObject = ((b)o0.i(this.M3)).a(this.L3);
          if (localObject != null)
          {
            ArrayList localArrayList = new ArrayList(((Metadata)localObject).d());
            N((Metadata)localObject, localArrayList);
            if (!localArrayList.isEmpty())
            {
              this.R3 = new Metadata(localArrayList);
              this.Q3 = this.L3.x;
            }
          }
        }
      }
      else if (i == -5) {
        this.P3 = ((Format)g.e(((i1)localObject).b)).L3;
      }
    }
  }
  
  protected void E()
  {
    this.R3 = null;
    this.Q3 = -9223372036854775807L;
    this.M3 = null;
  }
  
  protected void G(long paramLong, boolean paramBoolean)
  {
    this.R3 = null;
    this.Q3 = -9223372036854775807L;
    this.N3 = false;
    this.O3 = false;
  }
  
  protected void K(Format[] paramArrayOfFormat, long paramLong1, long paramLong2)
  {
    this.M3 = this.I3.b(paramArrayOfFormat[0]);
  }
  
  public int a(Format paramFormat)
  {
    if (this.I3.a(paramFormat))
    {
      int i;
      if (paramFormat.a4 == null) {
        i = 4;
      } else {
        i = 2;
      }
      return c2.a(i);
    }
    return c2.a(0);
  }
  
  public boolean d()
  {
    return this.O3;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public String getName()
  {
    return "MetadataRenderer";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      P((Metadata)paramMessage.obj);
      return true;
    }
    throw new IllegalStateException();
  }
  
  public void t(long paramLong1, long paramLong2)
  {
    for (boolean bool = true; bool; bool = Q(paramLong1)) {
      R();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */