package io.netty.buffer.search;

public abstract class AbstractSearchProcessorFactory
  implements SearchProcessorFactory
{
  public static BitapSearchProcessorFactory newBitapSearchProcessorFactory(byte[] paramArrayOfByte)
  {
    return new BitapSearchProcessorFactory(paramArrayOfByte);
  }
  
  public static KmpSearchProcessorFactory newKmpSearchProcessorFactory(byte[] paramArrayOfByte)
  {
    return new KmpSearchProcessorFactory(paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\search\AbstractSearchProcessorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */