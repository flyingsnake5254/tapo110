package com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import okhttp3.Cookie;
import okhttp3.Cookie.Builder;

public class SerializableCookie
  implements Serializable
{
  private static final long serialVersionUID = 6374381828722046732L;
  private transient Cookie clientCookie;
  private final transient Cookie cookie;
  
  public SerializableCookie(Cookie paramCookie)
  {
    this.cookie = paramCookie;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    String str1 = (String)paramObjectInputStream.readObject();
    String str2 = (String)paramObjectInputStream.readObject();
    long l = paramObjectInputStream.readLong();
    String str3 = (String)paramObjectInputStream.readObject();
    String str4 = (String)paramObjectInputStream.readObject();
    boolean bool1 = paramObjectInputStream.readBoolean();
    boolean bool2 = paramObjectInputStream.readBoolean();
    boolean bool3 = paramObjectInputStream.readBoolean();
    paramObjectInputStream.readBoolean();
    paramObjectInputStream = new Cookie.Builder().name(str1).value(str2).expiresAt(l).path(str4);
    if (bool3) {
      paramObjectInputStream.hostOnlyDomain(str3);
    } else {
      paramObjectInputStream.domain(str3);
    }
    if (bool1) {
      paramObjectInputStream.secure();
    }
    if (bool2) {
      paramObjectInputStream.httpOnly();
    }
    this.clientCookie = paramObjectInputStream.build();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this.cookie.name());
    paramObjectOutputStream.writeObject(this.cookie.value());
    paramObjectOutputStream.writeLong(this.cookie.expiresAt());
    paramObjectOutputStream.writeObject(this.cookie.domain());
    paramObjectOutputStream.writeObject(this.cookie.path());
    paramObjectOutputStream.writeBoolean(this.cookie.secure());
    paramObjectOutputStream.writeBoolean(this.cookie.httpOnly());
    paramObjectOutputStream.writeBoolean(this.cookie.hostOnly());
    paramObjectOutputStream.writeBoolean(this.cookie.persistent());
  }
  
  public Cookie getCookie()
  {
    Object localObject = this.cookie;
    Cookie localCookie = this.clientCookie;
    if (localCookie != null) {
      localObject = localCookie;
    }
    return (Cookie)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\cookie\SerializableCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */