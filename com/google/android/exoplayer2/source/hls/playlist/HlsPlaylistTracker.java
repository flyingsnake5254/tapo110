package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.f0.a;
import com.google.android.exoplayer2.source.hls.j;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.upstream.x.c;
import java.io.IOException;

public abstract interface HlsPlaylistTracker
{
  public abstract void a(b paramb);
  
  public abstract void c(Uri paramUri)
    throws IOException;
  
  public abstract long d();
  
  @Nullable
  public abstract f e();
  
  public abstract void f(Uri paramUri);
  
  public abstract void g(b paramb);
  
  public abstract boolean i(Uri paramUri);
  
  public abstract boolean j();
  
  public abstract boolean k(Uri paramUri, long paramLong);
  
  public abstract void l(Uri paramUri, f0.a parama, c paramc);
  
  public abstract void m()
    throws IOException;
  
  @Nullable
  public abstract g o(Uri paramUri, boolean paramBoolean);
  
  public abstract void stop();
  
  public static final class PlaylistResetException
    extends IOException
  {
    public final Uri url;
    
    public PlaylistResetException(Uri paramUri)
    {
      this.url = paramUri;
    }
  }
  
  public static final class PlaylistStuckException
    extends IOException
  {
    public final Uri url;
    
    public PlaylistStuckException(Uri paramUri)
    {
      this.url = paramUri;
    }
  }
  
  public static abstract interface a
  {
    public abstract HlsPlaylistTracker a(j paramj, x paramx, i parami);
  }
  
  public static abstract interface b
  {
    public abstract void g();
    
    public abstract boolean h(Uri paramUri, x.c paramc, boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void c(g paramg);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\playlist\HlsPlaylistTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */