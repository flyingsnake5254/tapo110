package com.google.android.exoplayer2.source.hls.playlist;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.y.a;
import java.util.List;

public final class e
  implements i
{
  private final i a;
  private final List<StreamKey> b;
  
  public e(i parami, List<StreamKey> paramList)
  {
    this.a = parami;
    this.b = paramList;
  }
  
  public y.a<h> a(f paramf, @Nullable g paramg)
  {
    return new com.google.android.exoplayer2.offline.f(this.a.a(paramf, paramg), this.b);
  }
  
  public y.a<h> b()
  {
    return new com.google.android.exoplayer2.offline.f(this.a.b(), this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\playlist\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */