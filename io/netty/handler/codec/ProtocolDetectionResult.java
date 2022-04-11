package io.netty.handler.codec;

import io.netty.util.internal.ObjectUtil;

public final class ProtocolDetectionResult<T>
{
  private static final ProtocolDetectionResult INVALID = new ProtocolDetectionResult(ProtocolDetectionState.INVALID, null);
  private static final ProtocolDetectionResult NEEDS_MORE_DATA = new ProtocolDetectionResult(ProtocolDetectionState.NEEDS_MORE_DATA, null);
  private final T result;
  private final ProtocolDetectionState state;
  
  private ProtocolDetectionResult(ProtocolDetectionState paramProtocolDetectionState, T paramT)
  {
    this.state = paramProtocolDetectionState;
    this.result = paramT;
  }
  
  public static <T> ProtocolDetectionResult<T> detected(T paramT)
  {
    return new ProtocolDetectionResult(ProtocolDetectionState.DETECTED, ObjectUtil.checkNotNull(paramT, "protocol"));
  }
  
  public static <T> ProtocolDetectionResult<T> invalid()
  {
    return INVALID;
  }
  
  public static <T> ProtocolDetectionResult<T> needsMoreData()
  {
    return NEEDS_MORE_DATA;
  }
  
  public T detectedProtocol()
  {
    return (T)this.result;
  }
  
  public ProtocolDetectionState state()
  {
    return this.state;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\ProtocolDetectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */