package io.netty.util.internal.shaded.org.jctools.queues.atomic;

abstract class MpscAtomicArrayQueueMidPad<E>
  extends MpscAtomicArrayQueueProducerIndexField<E>
{
  long p01;
  long p02;
  long p03;
  long p04;
  long p05;
  long p06;
  long p07;
  long p10;
  long p11;
  long p12;
  long p13;
  long p14;
  long p15;
  long p16;
  long p17;
  
  MpscAtomicArrayQueueMidPad(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\queues\atomic\MpscAtomicArrayQueueMidPad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */