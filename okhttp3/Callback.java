package okhttp3;

import java.io.IOException;

public abstract interface Callback
{
  public abstract void onFailure(Call paramCall, IOException paramIOException);
  
  public abstract void onResponse(Call paramCall, Response paramResponse)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */