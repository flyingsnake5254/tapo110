package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;

public abstract interface ForwardedTCPIPDaemon
  extends Runnable
{
  public abstract void setArg(Object[] paramArrayOfObject);
  
  public abstract void setChannel(ChannelForwardedTCPIP paramChannelForwardedTCPIP, InputStream paramInputStream, OutputStream paramOutputStream);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ForwardedTCPIPDaemon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */