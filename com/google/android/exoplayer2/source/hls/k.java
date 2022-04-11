package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.l0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface k
{
  public static final k a = new g();
  
  public abstract n a(Uri paramUri, Format paramFormat, @Nullable List<Format> paramList, l0 paraml0, Map<String, List<String>> paramMap, com.google.android.exoplayer2.o2.k paramk)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */