package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.n;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class MediaDrmCallbackException
  extends IOException
{
  public final long bytesLoaded;
  public final n dataSpec;
  public final Map<String, List<String>> responseHeaders;
  public final Uri uriAfterRedirects;
  
  public MediaDrmCallbackException(n paramn, Uri paramUri, Map<String, List<String>> paramMap, long paramLong, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.dataSpec = paramn;
    this.uriAfterRedirects = paramUri;
    this.responseHeaders = paramMap;
    this.bytesLoaded = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\MediaDrmCallbackException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */