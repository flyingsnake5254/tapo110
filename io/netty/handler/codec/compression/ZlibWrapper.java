package io.netty.handler.codec.compression;

public enum ZlibWrapper
{
  static
  {
    ZlibWrapper localZlibWrapper1 = new ZlibWrapper("ZLIB", 0);
    ZLIB = localZlibWrapper1;
    ZlibWrapper localZlibWrapper2 = new ZlibWrapper("GZIP", 1);
    GZIP = localZlibWrapper2;
    ZlibWrapper localZlibWrapper3 = new ZlibWrapper("NONE", 2);
    NONE = localZlibWrapper3;
    ZlibWrapper localZlibWrapper4 = new ZlibWrapper("ZLIB_OR_NONE", 3);
    ZLIB_OR_NONE = localZlibWrapper4;
    $VALUES = new ZlibWrapper[] { localZlibWrapper1, localZlibWrapper2, localZlibWrapper3, localZlibWrapper4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\ZlibWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */