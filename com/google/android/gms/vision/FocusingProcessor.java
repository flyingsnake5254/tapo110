package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;

public abstract class FocusingProcessor<T>
  implements Detector.Processor<T>
{
  private Tracker<T> zzas;
  private int zzat = 3;
  private boolean zzau = false;
  private int zzav;
  private int zzaw = 0;
  private Detector<T> zzx;
  
  public FocusingProcessor(Detector<T> paramDetector, Tracker<T> paramTracker)
  {
    this.zzx = paramDetector;
    this.zzas = paramTracker;
  }
  
  public void receiveDetections(Detector.Detections<T> paramDetections)
  {
    Object localObject1 = paramDetections.getDetectedItems();
    if (((SparseArray)localObject1).size() == 0)
    {
      if (this.zzaw == this.zzat)
      {
        this.zzas.onDone();
        this.zzau = false;
      }
      else
      {
        this.zzas.onMissing(paramDetections);
      }
      this.zzaw += 1;
      return;
    }
    this.zzaw = 0;
    if (this.zzau)
    {
      Object localObject2 = ((SparseArray)localObject1).get(this.zzav);
      if (localObject2 != null)
      {
        this.zzas.onUpdate(paramDetections, localObject2);
        return;
      }
      this.zzas.onDone();
      this.zzau = false;
    }
    int i = selectFocus(paramDetections);
    localObject1 = ((SparseArray)localObject1).get(i);
    if (localObject1 == null)
    {
      paramDetections = new StringBuilder(35);
      paramDetections.append("Invalid focus selected: ");
      paramDetections.append(i);
      Log.w("FocusingProcessor", paramDetections.toString());
      return;
    }
    this.zzau = true;
    this.zzav = i;
    this.zzx.setFocus(i);
    this.zzas.onNewItem(this.zzav, localObject1);
    this.zzas.onUpdate(paramDetections, localObject1);
  }
  
  public void release()
  {
    this.zzas.onDone();
  }
  
  public abstract int selectFocus(Detector.Detections<T> paramDetections);
  
  protected final void zza(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.zzat = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(28);
    localStringBuilder.append("Invalid max gap: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\FocusingProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */