package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

public abstract interface Connection
{
  @Nullable
  public abstract Handshake handshake();
  
  public abstract Protocol protocol();
  
  public abstract Route route();
  
  public abstract Socket socket();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */