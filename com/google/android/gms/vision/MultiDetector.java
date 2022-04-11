package com.google.android.gms.vision;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiDetector
  extends Detector<Object>
{
  private List<Detector<? extends Object>> zzbd = new ArrayList();
  
  public SparseArray<Object> detect(Frame paramFrame)
  {
    SparseArray localSparseArray1 = new SparseArray();
    Iterator localIterator = this.zzbd.iterator();
    while (localIterator.hasNext())
    {
      SparseArray localSparseArray2 = ((Detector)localIterator.next()).detect(paramFrame);
      int j;
      for (int i = 0; i < localSparseArray2.size(); i++)
      {
        j = localSparseArray2.keyAt(i);
        if (localSparseArray1.get(j) != null) {
          break label92;
        }
        localSparseArray1.append(j, localSparseArray2.valueAt(i));
      }
      continue;
      label92:
      paramFrame = new StringBuilder(104);
      paramFrame.append("Detection ID overlap for id = ");
      paramFrame.append(j);
      paramFrame.append("  This means that one of the detectors is not using global IDs.");
      throw new IllegalStateException(paramFrame.toString());
    }
    return localSparseArray1;
  }
  
  public boolean isOperational()
  {
    Iterator localIterator = this.zzbd.iterator();
    while (localIterator.hasNext()) {
      if (!((Detector)localIterator.next()).isOperational()) {
        return false;
      }
    }
    return true;
  }
  
  public void receiveFrame(Frame paramFrame)
  {
    Iterator localIterator = this.zzbd.iterator();
    while (localIterator.hasNext()) {
      ((Detector)localIterator.next()).receiveFrame(paramFrame);
    }
  }
  
  public void release()
  {
    Iterator localIterator = this.zzbd.iterator();
    while (localIterator.hasNext()) {
      ((Detector)localIterator.next()).release();
    }
    this.zzbd.clear();
  }
  
  public void setProcessor(Detector.Processor<Object> paramProcessor)
  {
    throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
  }
  
  public static class Builder
  {
    private MultiDetector zzbg = new MultiDetector(null);
    
    public Builder add(Detector<? extends Object> paramDetector)
    {
      MultiDetector.zza(this.zzbg).add(paramDetector);
      return this;
    }
    
    public MultiDetector build()
    {
      if (MultiDetector.zza(this.zzbg).size() != 0) {
        return this.zzbg;
      }
      throw new RuntimeException("No underlying detectors added to MultiDetector.");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\MultiDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */