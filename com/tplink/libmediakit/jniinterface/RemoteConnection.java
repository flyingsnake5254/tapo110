package com.tplink.libmediakit.jniinterface;

public class RemoteConnection
{
  static
  {
    System.loadLibrary("remote-connection-lib");
  }
  
  private RemoteConnection()
  {
    initP2P();
  }
  
  public static RemoteConnection d()
  {
    return b.a();
  }
  
  private native void initP2P();
  
  private native void p2pBreakDestroy(int paramInt);
  
  private native int p2pConfigCreate(String paramString);
  
  private native int p2pConnectionBuild(int paramInt, String paramString);
  
  private native int p2pGetError(int paramInt);
  
  private native int p2pNatTypeApp();
  
  private native int p2pNatTypeDut(String paramString);
  
  private void t(Runnable paramRunnable)
  {
    try
    {
      paramRunnable.run();
      return;
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public void a(int paramInt)
  {
    t(new f(this, paramInt));
  }
  
  public int b(int paramInt, String paramString)
  {
    b.d.p.e.a locala = new b.d.p.e.a(Integer.valueOf(-1));
    t(new b(this, locala, paramInt, paramString));
    return ((Integer)locala.a).intValue();
  }
  
  public int c(String paramString)
  {
    b.d.p.e.a locala = new b.d.p.e.a(Integer.valueOf(-1));
    t(new c(this, locala, paramString));
    return ((Integer)locala.a).intValue();
  }
  
  public int e(int paramInt)
  {
    b.d.p.e.a locala = new b.d.p.e.a(Integer.valueOf(-1));
    t(new a(this, locala, paramInt));
    return ((Integer)locala.a).intValue();
  }
  
  public int f()
  {
    b.d.p.e.a locala = new b.d.p.e.a(Integer.valueOf(-1));
    t(new e(this, locala));
    return ((Integer)locala.a).intValue();
  }
  
  public int g(String paramString)
  {
    b.d.p.e.a locala = new b.d.p.e.a(Integer.valueOf(-1));
    t(new d(this, locala, paramString));
    return ((Integer)locala.a).intValue();
  }
  
  private static class b
  {
    private static final RemoteConnection a = new RemoteConnection(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\jniinterface\RemoteConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */