package retrofit2;

import java.io.IOException;
import okhttp3.Request;

public abstract interface b<T>
  extends Cloneable
{
  public abstract void cancel();
  
  public abstract b<T> clone();
  
  public abstract q<T> execute()
    throws IOException;
  
  public abstract void i(d<T> paramd);
  
  public abstract boolean isCanceled();
  
  public abstract Request request();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */