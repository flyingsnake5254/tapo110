package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelSubsystem
  extends ChannelSession
{
  boolean pty = false;
  String subsystem = "";
  boolean want_reply = true;
  boolean xforwading = false;
  
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
  
  public void setErrStream(OutputStream paramOutputStream)
  {
    setExtOutputStream(paramOutputStream);
  }
  
  public void setPty(boolean paramBoolean)
  {
    this.pty = paramBoolean;
  }
  
  public void setSubsystem(String paramString)
  {
    this.subsystem = paramString;
  }
  
  public void setWantReply(boolean paramBoolean)
  {
    this.want_reply = paramBoolean;
  }
  
  public void setXForwarding(boolean paramBoolean)
  {
    this.xforwading = paramBoolean;
  }
  
  public void start()
    throws JSchException
  {
    Session localSession = getSession();
    try
    {
      if (this.xforwading)
      {
        localObject = new com/jcraft/jsch/RequestX11;
        ((RequestX11)localObject).<init>();
        ((Request)localObject).request(localSession, this);
      }
      if (this.pty)
      {
        localObject = new com/jcraft/jsch/RequestPtyReq;
        ((RequestPtyReq)localObject).<init>();
        ((Request)localObject).request(localSession, this);
      }
      Object localObject = new com/jcraft/jsch/RequestSubsystem;
      ((RequestSubsystem)localObject).<init>();
      ((RequestSubsystem)localObject).request(localSession, this, this.subsystem, this.want_reply);
      if (this.io.in != null)
      {
        localObject = new Thread(this);
        this.thread = ((Thread)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Subsystem for ");
        localStringBuilder.append(localSession.host);
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
        throw new JSchException("ChannelSubsystem", localException);
      }
      throw ((JSchException)localException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelSubsystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */