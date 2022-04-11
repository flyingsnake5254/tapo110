package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;

final class v
{
  @Nullable
  private final a a;
  private int b;
  private long c;
  private long d;
  private long e;
  private long f;
  
  public v(AudioTrack paramAudioTrack)
  {
    if (o0.a >= 19)
    {
      this.a = new a(paramAudioTrack);
      g();
    }
    else
    {
      this.a = null;
      h(3);
    }
  }
  
  private void h(int paramInt)
  {
    this.b = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt == 4) {
            this.d = 500000L;
          } else {
            throw new IllegalStateException();
          }
        }
        else {
          this.d = 10000000L;
        }
      }
      else {
        this.d = 10000L;
      }
    }
    else
    {
      this.e = 0L;
      this.f = -1L;
      this.c = (System.nanoTime() / 1000L);
      this.d = 10000L;
    }
  }
  
  public void a()
  {
    if (this.b == 4) {
      g();
    }
  }
  
  @TargetApi(19)
  public long b()
  {
    a locala = this.a;
    long l;
    if (locala != null) {
      l = locala.a();
    } else {
      l = -1L;
    }
    return l;
  }
  
  @TargetApi(19)
  public long c()
  {
    a locala = this.a;
    long l;
    if (locala != null) {
      l = locala.b();
    } else {
      l = -9223372036854775807L;
    }
    return l;
  }
  
  public boolean d()
  {
    boolean bool;
    if (this.b == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @TargetApi(19)
  public boolean e(long paramLong)
  {
    a locala = this.a;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (locala != null) {
      if (paramLong - this.e < this.d)
      {
        bool2 = bool1;
      }
      else
      {
        this.e = paramLong;
        boolean bool3 = locala.c();
        int i = this.b;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4) {
                  throw new IllegalStateException();
                }
              }
              else if (bool3) {
                g();
              }
            }
            else if (!bool3) {
              g();
            }
          }
          else if (bool3)
          {
            if (this.a.a() > this.f) {
              h(2);
            }
          }
          else {
            g();
          }
        }
        else if (bool3)
        {
          bool2 = bool1;
          if (this.a.b() < this.c) {
            break label218;
          }
          this.f = this.a.a();
          h(1);
        }
        else if (paramLong - this.c > 500000L)
        {
          h(3);
        }
        bool2 = bool3;
      }
    }
    label218:
    return bool2;
  }
  
  public void f()
  {
    h(4);
  }
  
  public void g()
  {
    if (this.a != null) {
      h(0);
    }
  }
  
  @RequiresApi(19)
  private static final class a
  {
    private final AudioTrack a;
    private final AudioTimestamp b;
    private long c;
    private long d;
    private long e;
    
    public a(AudioTrack paramAudioTrack)
    {
      this.a = paramAudioTrack;
      this.b = new AudioTimestamp();
    }
    
    public long a()
    {
      return this.e;
    }
    
    public long b()
    {
      return this.b.nanoTime / 1000L;
    }
    
    public boolean c()
    {
      boolean bool = this.a.getTimestamp(this.b);
      if (bool)
      {
        long l = this.b.framePosition;
        if (this.d > l) {
          this.c += 1L;
        }
        this.d = l;
        this.e = (l + (this.c << 32));
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */