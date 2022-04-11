package io.netty.handler.logging;

public enum ByteBufFormat
{
  static
  {
    ByteBufFormat localByteBufFormat1 = new ByteBufFormat("SIMPLE", 0);
    SIMPLE = localByteBufFormat1;
    ByteBufFormat localByteBufFormat2 = new ByteBufFormat("HEX_DUMP", 1);
    HEX_DUMP = localByteBufFormat2;
    $VALUES = new ByteBufFormat[] { localByteBufFormat1, localByteBufFormat2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\logging\ByteBufFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */