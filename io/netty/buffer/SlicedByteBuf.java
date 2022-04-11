package io.netty.buffer;

@Deprecated
public class SlicedByteBuf
  extends AbstractUnpooledSlicedByteBuf
{
  private int length;
  
  public SlicedByteBuf(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    super(paramByteBuf, paramInt1, paramInt2);
  }
  
  public int capacity()
  {
    return this.length;
  }
  
  final void initLength(int paramInt)
  {
    this.length = paramInt;
  }
  
  final int length()
  {
    return this.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\SlicedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */