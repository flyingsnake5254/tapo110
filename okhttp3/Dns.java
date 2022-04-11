package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public abstract interface Dns
{
  public static final Dns SYSTEM = new Dns()
  {
    public List<InetAddress> lookup(String paramAnonymousString)
      throws UnknownHostException
    {
      if (paramAnonymousString != null) {
        try
        {
          List localList = Arrays.asList(InetAddress.getAllByName(paramAnonymousString));
          return localList;
        }
        catch (NullPointerException localNullPointerException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Broken system behaviour for dns lookup of ");
          localStringBuilder.append(paramAnonymousString);
          paramAnonymousString = new UnknownHostException(localStringBuilder.toString());
          paramAnonymousString.initCause(localNullPointerException);
          throw paramAnonymousString;
        }
      }
      throw new UnknownHostException("hostname == null");
    }
  };
  
  public abstract List<InetAddress> lookup(String paramString)
    throws UnknownHostException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Dns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */