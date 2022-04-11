package com.tplink.libmediakit.media.audioprocess;

public abstract class NativeAudioProcessor<T extends d>
  extends f<T>
{
  protected final String l = getClass().getSimpleName();
  private long m = r();
  
  static
  {
    System.loadLibrary("audio_proc");
  }
  
  public NativeAudioProcessor(c paramc, int paramInt)
  {
    super(paramc, paramInt);
  }
  
  private long r()
  {
    long l1 = nativeConstruct();
    nativeInit(l1, this.b.a);
    return l1;
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    s();
  }
  
  protected int l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return nativeProcess(paramArrayOfByte1, this.d, paramArrayOfByte2, q());
  }
  
  protected abstract long nativeConstruct();
  
  protected native void nativeDestroy(long paramLong);
  
  protected native void nativeInit(long paramLong, int paramInt);
  
  protected native int nativeProcess(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, long paramLong);
  
  protected native void nativeStop(long paramLong);
  
  protected boolean p()
  {
    return false;
  }
  
  protected long q()
  {
    return this.m;
  }
  
  public void s()
  {
    nativeStop(this.m);
    nativeDestroy(this.m);
    this.m = 0L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\NativeAudioProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */