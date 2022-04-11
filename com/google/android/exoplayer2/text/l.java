package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import java.util.Collections;
import java.util.List;

public final class l
  extends u0
  implements Handler.Callback
{
  @Nullable
  private final Handler I3;
  private final k J3;
  private final h K3;
  private final i1 L3;
  private boolean M3;
  private boolean N3;
  private boolean O3;
  private int P3;
  @Nullable
  private Format Q3;
  @Nullable
  private g R3;
  @Nullable
  private i S3;
  @Nullable
  private j T3;
  @Nullable
  private j U3;
  private int V3;
  private long W3;
  
  public l(k paramk, @Nullable Looper paramLooper)
  {
    this(paramk, paramLooper, h.a);
  }
  
  public l(k paramk, @Nullable Looper paramLooper, h paramh)
  {
    super(3);
    this.J3 = ((k)com.google.android.exoplayer2.util.g.e(paramk));
    if (paramLooper == null) {
      paramk = null;
    } else {
      paramk = o0.u(paramLooper, this);
    }
    this.I3 = paramk;
    this.K3 = paramh;
    this.L3 = new i1();
    this.W3 = -9223372036854775807L;
  }
  
  private void N()
  {
    W(Collections.emptyList());
  }
  
  private long O()
  {
    int i = this.V3;
    long l = Long.MAX_VALUE;
    if (i == -1) {
      return Long.MAX_VALUE;
    }
    com.google.android.exoplayer2.util.g.e(this.T3);
    if (this.V3 < this.T3.d()) {
      l = this.T3.c(this.V3);
    }
    return l;
  }
  
  private void P(SubtitleDecoderException paramSubtitleDecoderException)
  {
    String str = String.valueOf(this.Q3);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 39);
    localStringBuilder.append("Subtitle decoding failed. streamFormat=");
    localStringBuilder.append(str);
    u.d("TextRenderer", localStringBuilder.toString(), paramSubtitleDecoderException);
    N();
    U();
  }
  
  private void Q()
  {
    this.O3 = true;
    this.R3 = this.K3.b((Format)com.google.android.exoplayer2.util.g.e(this.Q3));
  }
  
  private void R(List<c> paramList)
  {
    this.J3.B(paramList);
  }
  
  private void S()
  {
    this.S3 = null;
    this.V3 = -1;
    j localj = this.T3;
    if (localj != null)
    {
      localj.n();
      this.T3 = null;
    }
    localj = this.U3;
    if (localj != null)
    {
      localj.n();
      this.U3 = null;
    }
  }
  
  private void T()
  {
    S();
    ((g)com.google.android.exoplayer2.util.g.e(this.R3)).release();
    this.R3 = null;
    this.P3 = 0;
  }
  
  private void U()
  {
    T();
    Q();
  }
  
  private void W(List<c> paramList)
  {
    Handler localHandler = this.I3;
    if (localHandler != null) {
      localHandler.obtainMessage(0, paramList).sendToTarget();
    } else {
      R(paramList);
    }
  }
  
  protected void E()
  {
    this.Q3 = null;
    this.W3 = -9223372036854775807L;
    N();
    T();
  }
  
  protected void G(long paramLong, boolean paramBoolean)
  {
    N();
    this.M3 = false;
    this.N3 = false;
    this.W3 = -9223372036854775807L;
    if (this.P3 != 0)
    {
      U();
    }
    else
    {
      S();
      ((g)com.google.android.exoplayer2.util.g.e(this.R3)).flush();
    }
  }
  
  protected void K(Format[] paramArrayOfFormat, long paramLong1, long paramLong2)
  {
    this.Q3 = paramArrayOfFormat[0];
    if (this.R3 != null) {
      this.P3 = 1;
    } else {
      Q();
    }
  }
  
  public void V(long paramLong)
  {
    com.google.android.exoplayer2.util.g.g(m());
    this.W3 = paramLong;
  }
  
  public int a(Format paramFormat)
  {
    if (this.K3.a(paramFormat))
    {
      int i;
      if (paramFormat.a4 == null) {
        i = 4;
      } else {
        i = 2;
      }
      return c2.a(i);
    }
    if (y.p(paramFormat.H3)) {
      return c2.a(1);
    }
    return c2.a(0);
  }
  
  public boolean d()
  {
    return this.N3;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public String getName()
  {
    return "TextRenderer";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      R((List)paramMessage.obj);
      return true;
    }
    throw new IllegalStateException();
  }
  
  public void t(long paramLong1, long paramLong2)
  {
    if (m())
    {
      paramLong2 = this.W3;
      if ((paramLong2 != -9223372036854775807L) && (paramLong1 >= paramLong2))
      {
        S();
        this.N3 = true;
      }
    }
    if (this.N3) {
      return;
    }
    if (this.U3 == null)
    {
      ((g)com.google.android.exoplayer2.util.g.e(this.R3)).a(paramLong1);
      try
      {
        this.U3 = ((j)((g)com.google.android.exoplayer2.util.g.e(this.R3)).b());
      }
      catch (SubtitleDecoderException localSubtitleDecoderException1)
      {
        P(localSubtitleDecoderException1);
        return;
      }
    }
    if (getState() != 2) {
      return;
    }
    if (this.T3 != null)
    {
      paramLong2 = O();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.V3 += 1;
        paramLong2 = O();
      }
    }
    int i = 0;
    Object localObject2 = this.U3;
    int j = i;
    Object localObject1;
    if (localObject2 != null) {
      if (((a)localObject2).k())
      {
        j = i;
        if (i == 0)
        {
          j = i;
          if (O() == Long.MAX_VALUE) {
            if (this.P3 == 2)
            {
              U();
              j = i;
            }
            else
            {
              S();
              this.N3 = true;
              j = i;
            }
          }
        }
      }
      else
      {
        j = i;
        if (((f)localObject2).d <= paramLong1)
        {
          localObject1 = this.T3;
          if (localObject1 != null) {
            ((f)localObject1).n();
          }
          this.V3 = ((j)localObject2).a(paramLong1);
          this.T3 = ((j)localObject2);
          this.U3 = null;
          j = 1;
        }
      }
    }
    if (j != 0)
    {
      com.google.android.exoplayer2.util.g.e(this.T3);
      W(this.T3.b(paramLong1));
    }
    if (this.P3 == 2) {
      return;
    }
    try
    {
      while (!this.M3)
      {
        localObject2 = this.S3;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = (i)((g)com.google.android.exoplayer2.util.g.e(this.R3)).d();
          if (localObject1 == null) {
            return;
          }
          this.S3 = ((i)localObject1);
        }
        if (this.P3 == 1)
        {
          ((a)localObject1).m(4);
          ((g)com.google.android.exoplayer2.util.g.e(this.R3)).c(localObject1);
          this.S3 = null;
          this.P3 = 2;
          return;
        }
        i = L(this.L3, (DecoderInputBuffer)localObject1, 0);
        if (i == -4)
        {
          if (((a)localObject1).k())
          {
            this.M3 = true;
            this.O3 = false;
          }
          else
          {
            localObject2 = this.L3.b;
            if (localObject2 == null) {
              return;
            }
            ((i)localObject1).p1 = ((Format)localObject2).L3;
            ((DecoderInputBuffer)localObject1).p();
            int k = this.O3;
            if (!((a)localObject1).l()) {
              i = 1;
            } else {
              i = 0;
            }
            this.O3 = (k & i);
          }
          if (!this.O3)
          {
            ((g)com.google.android.exoplayer2.util.g.e(this.R3)).c(localObject1);
            this.S3 = null;
          }
        }
        else if (i == -3) {}
      }
    }
    catch (SubtitleDecoderException localSubtitleDecoderException2)
    {
      P(localSubtitleDecoderException2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */