package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;

public final class BarcodeDetector
  extends Detector<Barcode>
{
  private final zzm zzbr;
  
  private BarcodeDetector()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  private BarcodeDetector(zzm paramzzm)
  {
    this.zzbr = paramzzm;
  }
  
  public final SparseArray<Barcode> detect(Frame paramFrame)
  {
    if (paramFrame != null)
    {
      Object localObject1 = zzu.zzd(paramFrame);
      if (paramFrame.getBitmap() != null)
      {
        paramFrame = this.zzbr.zza(paramFrame.getBitmap(), (zzu)localObject1);
        if (paramFrame == null) {
          throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
        }
      }
      else
      {
        paramFrame = paramFrame.getGrayscaleImageData();
        paramFrame = this.zzbr.zza(paramFrame, (zzu)localObject1);
      }
      localObject1 = new SparseArray(paramFrame.length);
      int i = paramFrame.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject2 = paramFrame[j];
        ((SparseArray)localObject1).append(((Barcode)localObject2).rawValue.hashCode(), localObject2);
      }
      return (SparseArray<Barcode>)localObject1;
    }
    throw new IllegalArgumentException("No frame supplied.");
  }
  
  public final boolean isOperational()
  {
    return this.zzbr.isOperational();
  }
  
  public final void release()
  {
    super.release();
    this.zzbr.zzp();
  }
  
  public static class Builder
  {
    private zzk zzbs;
    private Context zzg;
    
    public Builder(Context paramContext)
    {
      this.zzg = paramContext;
      this.zzbs = new zzk();
    }
    
    public BarcodeDetector build()
    {
      return new BarcodeDetector(new zzm(this.zzg, this.zzbs), null);
    }
    
    public Builder setBarcodeFormats(int paramInt)
    {
      this.zzbs.zzbt = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\barcode\BarcodeDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */