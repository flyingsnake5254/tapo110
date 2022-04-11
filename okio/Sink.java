package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract interface Sink
  extends Closeable, Flushable
{
  public abstract void close()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract Timeout timeout();
  
  public abstract void write(Buffer paramBuffer, long paramLong)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\Sink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */