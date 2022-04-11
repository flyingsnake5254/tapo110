package okio;

import java.io.IOException;

public abstract class ForwardingSink
  implements Sink
{
  private final Sink delegate;
  
  public ForwardingSink(Sink paramSink)
  {
    if (paramSink != null)
    {
      this.delegate = paramSink;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final Sink delegate()
  {
    return this.delegate;
  }
  
  public void flush()
    throws IOException
  {
    this.delegate.flush();
  }
  
  public Timeout timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    localStringBuilder.append(this.delegate.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    this.delegate.write(paramBuffer, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\ForwardingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */