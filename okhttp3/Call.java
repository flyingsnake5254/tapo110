package okhttp3;

import java.io.IOException;
import okio.Timeout;

public abstract interface Call
  extends Cloneable
{
  public abstract void cancel();
  
  public abstract Call clone();
  
  public abstract void enqueue(Callback paramCallback);
  
  public abstract Response execute()
    throws IOException;
  
  public abstract boolean isCanceled();
  
  public abstract boolean isExecuted();
  
  public abstract Request request();
  
  public abstract Timeout timeout();
  
  public static abstract interface Factory
  {
    public abstract Call newCall(Request paramRequest);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */