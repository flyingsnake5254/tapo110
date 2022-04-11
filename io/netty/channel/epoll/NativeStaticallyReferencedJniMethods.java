package io.netty.channel.epoll;

final class NativeStaticallyReferencedJniMethods
{
  static native int epollerr();
  
  static native int epollet();
  
  static native int epollin();
  
  static native int epollout();
  
  static native int epollrdhup();
  
  static native int iovMax();
  
  static native boolean isSupportingRecvmmsg();
  
  static native boolean isSupportingSendmmsg();
  
  static native boolean isSupportingTcpFastopen();
  
  static native String kernelVersion();
  
  static native long ssizeMax();
  
  static native int tcpMd5SigMaxKeyLen();
  
  static native int uioMaxIov();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\NativeStaticallyReferencedJniMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */