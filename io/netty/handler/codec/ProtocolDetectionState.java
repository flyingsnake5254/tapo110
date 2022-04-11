package io.netty.handler.codec;

public enum ProtocolDetectionState
{
  static
  {
    ProtocolDetectionState localProtocolDetectionState1 = new ProtocolDetectionState("NEEDS_MORE_DATA", 0);
    NEEDS_MORE_DATA = localProtocolDetectionState1;
    ProtocolDetectionState localProtocolDetectionState2 = new ProtocolDetectionState("INVALID", 1);
    INVALID = localProtocolDetectionState2;
    ProtocolDetectionState localProtocolDetectionState3 = new ProtocolDetectionState("DETECTED", 2);
    DETECTED = localProtocolDetectionState3;
    $VALUES = new ProtocolDetectionState[] { localProtocolDetectionState1, localProtocolDetectionState2, localProtocolDetectionState3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\ProtocolDetectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */