package com.google.android.gms.vision;

import android.util.SparseArray;
import javax.annotation.concurrent.GuardedBy;

public abstract class Detector<T>
{
  private final Object zzah = new Object();
  @GuardedBy("processorLock")
  private Processor<T> zzai;
  
  public abstract SparseArray<T> detect(Frame paramFrame);
  
  public boolean isOperational()
  {
    return true;
  }
  
  public void receiveFrame(Frame arg1)
  {
    Object localObject1 = new Frame.Metadata(???.getMetadata());
    ((Frame.Metadata)localObject1).zze();
    Detections localDetections = new Detections(detect(???), (Frame.Metadata)localObject1, isOperational());
    synchronized (this.zzah)
    {
      localObject1 = this.zzai;
      if (localObject1 != null)
      {
        ((Processor)localObject1).receiveDetections(localDetections);
        return;
      }
      localObject1 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject1).<init>("Detector processor must first be set with setProcessor in order to receive detection results.");
      throw ((Throwable)localObject1);
    }
  }
  
  public void release()
  {
    synchronized (this.zzah)
    {
      Processor localProcessor = this.zzai;
      if (localProcessor != null)
      {
        localProcessor.release();
        this.zzai = null;
      }
      return;
    }
  }
  
  public boolean setFocus(int paramInt)
  {
    return true;
  }
  
  public void setProcessor(Processor<T> paramProcessor)
  {
    synchronized (this.zzah)
    {
      Processor localProcessor = this.zzai;
      if (localProcessor != null) {
        localProcessor.release();
      }
      this.zzai = paramProcessor;
      return;
    }
  }
  
  public static class Detections<T>
  {
    private final SparseArray<T> zzal;
    private final Frame.Metadata zzam;
    private final boolean zzan;
    
    public Detections(SparseArray<T> paramSparseArray, Frame.Metadata paramMetadata, boolean paramBoolean)
    {
      this.zzal = paramSparseArray;
      this.zzam = paramMetadata;
      this.zzan = paramBoolean;
    }
    
    public boolean detectorIsOperational()
    {
      return this.zzan;
    }
    
    public SparseArray<T> getDetectedItems()
    {
      return this.zzal;
    }
    
    public Frame.Metadata getFrameMetadata()
    {
      return this.zzam;
    }
  }
  
  public static abstract interface Processor<T>
  {
    public abstract void receiveDetections(Detector.Detections<T> paramDetections);
    
    public abstract void release();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */