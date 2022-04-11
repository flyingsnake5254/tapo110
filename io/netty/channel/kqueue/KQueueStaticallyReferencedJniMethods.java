package io.netty.channel.kqueue;

final class KQueueStaticallyReferencedJniMethods
{
  static native short evAdd();
  
  static native short evClear();
  
  static native short evDelete();
  
  static native short evDisable();
  
  static native short evEOF();
  
  static native short evEnable();
  
  static native short evError();
  
  static native short evfiltRead();
  
  static native short evfiltSock();
  
  static native short evfiltUser();
  
  static native short evfiltWrite();
  
  static native short noteConnReset();
  
  static native short noteDisconnected();
  
  static native short noteReadClosed();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueStaticallyReferencedJniMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */