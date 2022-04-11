package com.google.android.gms.vision.face;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.FocusingProcessor;
import com.google.android.gms.vision.Tracker;

public class LargestFaceFocusingProcessor
  extends FocusingProcessor<Face>
{
  public LargestFaceFocusingProcessor(Detector<Face> paramDetector, Tracker<Face> paramTracker)
  {
    super(paramDetector, paramTracker);
  }
  
  public int selectFocus(Detector.Detections<Face> paramDetections)
  {
    paramDetections = paramDetections.getDetectedItems();
    if (paramDetections.size() != 0)
    {
      int i = paramDetections.keyAt(0);
      float f1 = ((Face)paramDetections.valueAt(0)).getWidth();
      int j = 1;
      while (j < paramDetections.size())
      {
        int k = paramDetections.keyAt(j);
        float f2 = ((Face)paramDetections.valueAt(j)).getWidth();
        float f3 = f1;
        if (f2 > f1)
        {
          i = k;
          f3 = f2;
        }
        j++;
        f1 = f3;
      }
      return i;
    }
    throw new IllegalArgumentException("No faces for selectFocus.");
  }
  
  public static class Builder
  {
    private LargestFaceFocusingProcessor zzcx;
    
    public Builder(Detector<Face> paramDetector, Tracker<Face> paramTracker)
    {
      this.zzcx = new LargestFaceFocusingProcessor(paramDetector, paramTracker);
    }
    
    public LargestFaceFocusingProcessor build()
    {
      return this.zzcx;
    }
    
    public Builder setMaxGapFrames(int paramInt)
    {
      LargestFaceFocusingProcessor.zza(this.zzcx, paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\LargestFaceFocusingProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */