package com.google.android.gms.vision;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MultiProcessor<T>
  implements Detector.Processor<T>
{
  private int zzat = 3;
  private Factory<T> zzbe;
  private SparseArray<zza> zzbf = new SparseArray();
  
  public void receiveDetections(Detector.Detections<T> paramDetections)
  {
    Object localObject1 = paramDetections.getDetectedItems();
    int j;
    Object localObject3;
    for (int i = 0; i < ((SparseArray)localObject1).size(); i++)
    {
      j = ((SparseArray)localObject1).keyAt(i);
      localObject2 = ((SparseArray)localObject1).valueAt(i);
      if (this.zzbf.get(j) == null)
      {
        localObject3 = new zza(null);
        zza.zza((zza)localObject3, this.zzbe.create(localObject2));
        zza.zza((zza)localObject3).onNewItem(j, localObject2);
        this.zzbf.append(j, localObject3);
      }
    }
    Object localObject2 = paramDetections.getDetectedItems();
    localObject1 = new HashSet();
    for (i = 0; i < this.zzbf.size(); i++)
    {
      j = this.zzbf.keyAt(i);
      if (((SparseArray)localObject2).get(j) == null)
      {
        localObject3 = (zza)this.zzbf.valueAt(i);
        zza.zzb((zza)localObject3);
        if (zza.zzc((zza)localObject3) >= this.zzat)
        {
          zza.zza((zza)localObject3).onDone();
          ((Set)localObject1).add(Integer.valueOf(j));
        }
        else
        {
          zza.zza((zza)localObject3).onMissing(paramDetections);
        }
      }
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      this.zzbf.delete(((Integer)localObject2).intValue());
    }
    localObject1 = paramDetections.getDetectedItems();
    for (i = 0; i < ((SparseArray)localObject1).size(); i++)
    {
      j = ((SparseArray)localObject1).keyAt(i);
      localObject3 = ((SparseArray)localObject1).valueAt(i);
      localObject2 = (zza)this.zzbf.get(j);
      zza.zza((zza)localObject2, 0);
      zza.zza((zza)localObject2).onUpdate(paramDetections, localObject3);
    }
  }
  
  public void release()
  {
    for (int i = 0; i < this.zzbf.size(); i++) {
      zza.zza((zza)this.zzbf.valueAt(i)).onDone();
    }
    this.zzbf.clear();
  }
  
  public static class Builder<T>
  {
    private MultiProcessor<T> zzbh;
    
    public Builder(MultiProcessor.Factory<T> paramFactory)
    {
      MultiProcessor localMultiProcessor = new MultiProcessor(null);
      this.zzbh = localMultiProcessor;
      if (paramFactory != null)
      {
        MultiProcessor.zza(localMultiProcessor, paramFactory);
        return;
      }
      throw new IllegalArgumentException("No factory supplied.");
    }
    
    public MultiProcessor<T> build()
    {
      return this.zzbh;
    }
    
    public Builder<T> setMaxGapFrames(int paramInt)
    {
      if (paramInt >= 0)
      {
        MultiProcessor.zza(this.zzbh, paramInt);
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder(28);
      localStringBuilder.append("Invalid max gap: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public static abstract interface Factory<T>
  {
    public abstract Tracker<T> create(T paramT);
  }
  
  final class zza
  {
    private Tracker<T> zzas;
    private int zzaw = 0;
    
    private zza() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\MultiProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */