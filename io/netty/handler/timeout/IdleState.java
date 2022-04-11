package io.netty.handler.timeout;

public enum IdleState
{
  static
  {
    IdleState localIdleState1 = new IdleState("READER_IDLE", 0);
    READER_IDLE = localIdleState1;
    IdleState localIdleState2 = new IdleState("WRITER_IDLE", 1);
    WRITER_IDLE = localIdleState2;
    IdleState localIdleState3 = new IdleState("ALL_IDLE", 2);
    ALL_IDLE = localIdleState3;
    $VALUES = new IdleState[] { localIdleState1, localIdleState2, localIdleState3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\IdleState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */