package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelExec
  extends ChannelSession
{
  byte[] command = new byte[0];
  
  public InputStream getErrStream()
    throws IOException
  {
    return getExtInputStream();
  }
  
  void init()
    throws JSchException
  {
    this.io.setInputStream(getSession().in);
    this.io.setOutputStream(getSession().out);
  }
  
  public void setCommand(String paramString)
  {
    this.command = Util.str2byte(paramString);
  }
  
  public void setCommand(byte[] paramArrayOfByte)
  {
    this.command = paramArrayOfByte;
  }
  
  public void setErrStream(OutputStream paramOutputStream)
  {
    setExtOutputStream(paramOutputStream);
  }
  
  public void setErrStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    setExtOutputStream(paramOutputStream, paramBoolean);
  }
  
  public void start()
    throws JSchException
  {
    Session localSession = getSession();
    try
    {
      sendRequests();
      Object localObject = new com/jcraft/jsch/RequestExec;
      ((RequestExec)localObject).<init>(this.command);
      ((Request)localObject).request(localSession, this);
      if (this.io.in != null)
      {
        localObject = new Thread(this);
        this.thread = ((Thread)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exec thread ");
        localStringBuilder.append(localSession.getHost());
        ((Thread)localObject).setName(localStringBuilder.toString());
        boolean bool = localSession.daemon_thread;
        if (bool) {
          this.thread.setDaemon(bool);
        }
        this.thread.start();
      }
      return;
    }
    catch (Exception localException)
    {
      if (!(localException instanceof JSchException)) {
        throw new JSchException("ChannelExec", localException);
      }
      throw ((JSchException)localException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */