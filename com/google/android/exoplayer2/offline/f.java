package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.y.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class f<T extends e<T>>
  implements y.a<T>
{
  private final y.a<? extends T> a;
  @Nullable
  private final List<StreamKey> b;
  
  public f(y.a<? extends T> parama, @Nullable List<StreamKey> paramList)
  {
    this.a = parama;
    this.b = paramList;
  }
  
  public T b(Uri paramUri, InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = (e)this.a.a(paramUri, paramInputStream);
    List localList = this.b;
    paramUri = paramInputStream;
    if (localList != null) {
      if (localList.isEmpty()) {
        paramUri = paramInputStream;
      } else {
        paramUri = (e)paramInputStream.a(this.b);
      }
    }
    return paramUri;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\offline\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */