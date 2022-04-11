package io.netty.channel.epoll;

public enum EpollMode
{
  static
  {
    EpollMode localEpollMode1 = new EpollMode("EDGE_TRIGGERED", 0);
    EDGE_TRIGGERED = localEpollMode1;
    EpollMode localEpollMode2 = new EpollMode("LEVEL_TRIGGERED", 1);
    LEVEL_TRIGGERED = localEpollMode2;
    $VALUES = new EpollMode[] { localEpollMode1, localEpollMode2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */