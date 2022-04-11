package io.netty.handler.codec.spdy;

public enum SpdyVersion
{
  private final int minorVersion;
  private final int version;
  
  static
  {
    SpdyVersion localSpdyVersion = new SpdyVersion("SPDY_3_1", 0, 3, 1);
    SPDY_3_1 = localSpdyVersion;
    $VALUES = new SpdyVersion[] { localSpdyVersion };
  }
  
  private SpdyVersion(int paramInt1, int paramInt2)
  {
    this.version = paramInt1;
    this.minorVersion = paramInt2;
  }
  
  int getMinorVersion()
  {
    return this.minorVersion;
  }
  
  int getVersion()
  {
    return this.version;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */