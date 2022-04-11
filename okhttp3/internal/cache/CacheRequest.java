package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;

public abstract interface CacheRequest
{
  public abstract void abort();
  
  public abstract Sink body()
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\cache\CacheRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */