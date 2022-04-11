package com.google.mlkit.vision.barcode;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.util.List;

public abstract interface BarcodeScanner
  extends LifecycleObserver, Closeable
{
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public abstract void close();
  
  @NonNull
  public abstract Task<List<a>> q(@NonNull b.b.a.a.a.a parama);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\BarcodeScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */