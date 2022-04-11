package io.reactivex.parallel;

import io.reactivex.g0.c;

public enum ParallelFailureHandling
  implements c<Long, Throwable, ParallelFailureHandling>
{
  static
  {
    ParallelFailureHandling localParallelFailureHandling1 = new ParallelFailureHandling("STOP", 0);
    STOP = localParallelFailureHandling1;
    ParallelFailureHandling localParallelFailureHandling2 = new ParallelFailureHandling("ERROR", 1);
    ERROR = localParallelFailureHandling2;
    ParallelFailureHandling localParallelFailureHandling3 = new ParallelFailureHandling("SKIP", 2);
    SKIP = localParallelFailureHandling3;
    ParallelFailureHandling localParallelFailureHandling4 = new ParallelFailureHandling("RETRY", 3);
    RETRY = localParallelFailureHandling4;
    $VALUES = new ParallelFailureHandling[] { localParallelFailureHandling1, localParallelFailureHandling2, localParallelFailureHandling3, localParallelFailureHandling4 };
  }
  
  public ParallelFailureHandling apply(Long paramLong, Throwable paramThrowable)
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\parallel\ParallelFailureHandling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */