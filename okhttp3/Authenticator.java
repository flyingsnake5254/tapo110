package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

public abstract interface Authenticator
{
  public static final Authenticator NONE = new Authenticator()
  {
    public Request authenticate(@Nullable Route paramAnonymousRoute, Response paramAnonymousResponse)
    {
      return null;
    }
  };
  
  @Nullable
  public abstract Request authenticate(@Nullable Route paramRoute, Response paramResponse)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Authenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */