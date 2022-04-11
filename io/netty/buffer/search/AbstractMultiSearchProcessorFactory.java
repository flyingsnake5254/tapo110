package io.netty.buffer.search;

public abstract class AbstractMultiSearchProcessorFactory
  implements MultiSearchProcessorFactory
{
  public static AhoCorasicSearchProcessorFactory newAhoCorasicSearchProcessorFactory(byte[]... paramVarArgs)
  {
    return new AhoCorasicSearchProcessorFactory(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\search\AbstractMultiSearchProcessorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */