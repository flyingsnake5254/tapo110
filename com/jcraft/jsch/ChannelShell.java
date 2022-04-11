package com.jcraft.jsch;

public class ChannelShell
  extends ChannelSession
{
  ChannelShell()
  {
    this.pty = true;
  }
  
  void init()
    throws JSchException
  {
    this.io.setInputStream(getSession().in);
    this.io.setOutputStream(getSession().out);
  }
  
  public void start()
    throws JSchException
  {
    Session localSession = getSession();
    try
    {
      sendRequests();
      Object localObject = new com/jcraft/jsch/RequestShell;
      ((RequestShell)localObject).<init>();
      ((Request)localObject).request(localSession, this);
      if (this.io.in != null)
      {
        localObject = new Thread(this);
        this.thread = ((Thread)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Shell for ");
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
        throw new JSchException("ChannelShell", localException);
      }
      throw ((JSchException)localException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */