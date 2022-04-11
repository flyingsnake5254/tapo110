package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink
  extends ForwardingSink
{
  private boolean hasErrors;
  
  FaultHidingSink(Sink paramSink)
  {
    super(paramSink);
  }
  
  public void close()
    throws IOException
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.close();
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }
  
  public void flush()
    throws IOException
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.flush();
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }
  
  protected void onException(IOException paramIOException) {}
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (this.hasErrors)
    {
      paramBuffer.skip(paramLong);
      return;
    }
    try
    {
      super.write(paramBuffer, paramLong);
    }
    catch (IOException paramBuffer)
    {
      this.hasErrors = true;
      onException(paramBuffer);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\cache\FaultHidingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */