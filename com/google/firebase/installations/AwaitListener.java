package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class AwaitListener
  implements OnCompleteListener<Void>
{
  private final CountDownLatch latch = new CountDownLatch(1);
  
  public boolean await(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.latch.await(paramLong, paramTimeUnit);
  }
  
  public void onComplete(@NonNull Task<Void> paramTask)
  {
    this.latch.countDown();
  }
  
  public void onSuccess()
  {
    this.latch.countDown();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\AwaitListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */