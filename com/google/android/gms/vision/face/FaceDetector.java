package com.google.android.gms.vision.face;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.zzb;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

public final class FaceDetector
  extends Detector<Face>
{
  public static final int ACCURATE_MODE = 1;
  public static final int ALL_CLASSIFICATIONS = 1;
  public static final int ALL_LANDMARKS = 1;
  public static final int CONTOUR_LANDMARKS = 2;
  public static final int FAST_MODE = 0;
  public static final int NO_CLASSIFICATIONS = 0;
  public static final int NO_LANDMARKS = 0;
  public static final int SELFIE_MODE = 2;
  private final Object lock = new Object();
  private final zzc zzcr = new zzc();
  @GuardedBy("lock")
  private final zzb zzcs;
  @GuardedBy("lock")
  private boolean zzct = true;
  
  private FaceDetector()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  private FaceDetector(zzb paramzzb)
  {
    this.zzcs = paramzzb;
  }
  
  private static boolean zza(zzf paramzzf)
  {
    int i = paramzzf.mode;
    boolean bool1 = false;
    boolean bool2;
    if ((i != 2) && (paramzzf.landmarkType == 2))
    {
      Log.e("FaceDetector", "Contour is not supported for non-SELFIE mode.");
      bool2 = false;
    }
    else
    {
      bool2 = true;
    }
    if ((paramzzf.landmarkType == 2) && (paramzzf.zzcw == 1))
    {
      Log.e("FaceDetector", "Classification is not supported with contour.");
      bool2 = bool1;
    }
    return bool2;
  }
  
  public final SparseArray<Face> detect(Frame paramFrame)
  {
    if (paramFrame != null)
    {
      ??? = paramFrame.getPlanes();
      int i = 0;
      if ((??? != null) && (paramFrame.getPlanes().length == 3)) {
        synchronized (this.lock)
        {
          if (this.zzct)
          {
            paramFrame = this.zzcs.zza(paramFrame.getPlanes(), zzu.zzd(paramFrame));
            break label379;
          }
          paramFrame = new java/lang/IllegalStateException;
          paramFrame.<init>("Cannot use detector after release()");
          throw paramFrame;
        }
      }
      Object localObject2;
      int j;
      int k;
      int m;
      int n;
      int i5;
      if (paramFrame.getBitmap() != null)
      {
        localObject2 = paramFrame.getBitmap();
        j = ((Bitmap)localObject2).getWidth();
        k = ((Bitmap)localObject2).getHeight();
        m = j * k;
        ??? = ByteBuffer.allocateDirect(((j + 1) / 2 * ((k + 1) / 2) << 1) + m);
        k = m;
        n = 0;
        for (;;)
        {
          ??? = ???;
          if (n >= m) {
            break;
          }
          int i1 = n % j;
          int i2 = n / j;
          int i3 = ((Bitmap)localObject2).getPixel(i1, i2);
          int i4 = Color.red(i3);
          i5 = Color.green(i3);
          i3 = Color.blue(i3);
          float f1 = i4;
          float f2 = i5;
          float f3 = i3;
          ((ByteBuffer)???).put(n, (byte)(int)(0.299F * f1 + 0.587F * f2 + 0.114F * f3));
          i5 = k;
          if (i2 % 2 == 0)
          {
            i5 = k;
            if (i1 % 2 == 0)
            {
              i1 = k + 1;
              ((ByteBuffer)???).put(k, (byte)(int)(-0.169F * f1 + -0.331F * f2 + f3 * 0.5F + 128.0F));
              i5 = i1 + 1;
              ((ByteBuffer)???).put(i1, (byte)(int)(f1 * 0.5F + f2 * -0.419F + f3 * -0.081F + 128.0F));
            }
          }
          n++;
          k = i5;
        }
      }
      ??? = paramFrame.getGrayscaleImageData();
      synchronized (this.lock)
      {
        if (this.zzct)
        {
          paramFrame = this.zzcs.zzb((ByteBuffer)???, zzu.zzd(paramFrame));
          label379:
          ??? = new HashSet();
          localObject2 = new SparseArray(paramFrame.length);
          j = paramFrame.length;
          k = 0;
          for (n = i; n < j; n++)
          {
            ??? = paramFrame[n];
            i = ((Face)???).getId();
            m = Math.max(k, i);
            k = m;
            i5 = i;
            if (((Set)???).contains(Integer.valueOf(i)))
            {
              i5 = m + 1;
              k = i5;
            }
            ((Set)???).add(Integer.valueOf(i5));
            ((SparseArray)localObject2).append(this.zzcr.zzb(i5), ???);
          }
          return (SparseArray<Face>)localObject2;
        }
        paramFrame = new java/lang/IllegalStateException;
        paramFrame.<init>("Cannot use detector after release()");
        throw paramFrame;
      }
    }
    throw new IllegalArgumentException("No frame supplied.");
  }
  
  /* Error */
  protected final void finalize()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/google/android/gms/vision/face/FaceDetector:lock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 46	com/google/android/gms/vision/face/FaceDetector:zzct	Z
    //   11: ifeq +15 -> 26
    //   14: ldc 72
    //   16: ldc -41
    //   18: invokestatic 218	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   21: pop
    //   22: aload_0
    //   23: invokevirtual 221	com/google/android/gms/vision/Detector:release	()V
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: invokespecial 223	java/lang/Object:finalize	()V
    //   32: return
    //   33: astore_2
    //   34: aload_1
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: aload_0
    //   40: invokespecial 223	java/lang/Object:finalize	()V
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	FaceDetector
    //   33	4	2	localObject2	Object
    //   38	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	33	finally
    //   26	28	33	finally
    //   34	36	33	finally
    //   0	7	38	finally
    //   36	38	38	finally
  }
  
  public final boolean isOperational()
  {
    return this.zzcs.isOperational();
  }
  
  public final void release()
  {
    super.release();
    synchronized (this.lock)
    {
      if (!this.zzct) {
        return;
      }
      this.zzcs.zzp();
      this.zzct = false;
      return;
    }
  }
  
  public final boolean setFocus(int paramInt)
  {
    paramInt = this.zzcr.zzc(paramInt);
    synchronized (this.lock)
    {
      if (this.zzct)
      {
        boolean bool = this.zzcs.zzd(paramInt);
        return bool;
      }
      RuntimeException localRuntimeException = new java/lang/RuntimeException;
      localRuntimeException.<init>("Cannot use detector after release()");
      throw localRuntimeException;
    }
  }
  
  public static class Builder
  {
    private int landmarkType = 0;
    private int mode = 0;
    private float proportionalMinFaceSize = -1.0F;
    private boolean trackingEnabled = true;
    private boolean zzcv = false;
    private int zzcw = 0;
    private final Context zzg;
    
    public Builder(Context paramContext)
    {
      this.zzg = paramContext;
    }
    
    public FaceDetector build()
    {
      zzf localzzf = new zzf();
      localzzf.mode = this.mode;
      localzzf.landmarkType = this.landmarkType;
      localzzf.zzcw = this.zzcw;
      localzzf.zzcv = this.zzcv;
      localzzf.trackingEnabled = this.trackingEnabled;
      localzzf.proportionalMinFaceSize = this.proportionalMinFaceSize;
      if (FaceDetector.zzb(localzzf)) {
        return new FaceDetector(new zzb(this.zzg, localzzf), null);
      }
      throw new IllegalArgumentException("Invalid build options");
    }
    
    public Builder setClassificationType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1))
      {
        StringBuilder localStringBuilder = new StringBuilder(40);
        localStringBuilder.append("Invalid classification type: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      this.zzcw = paramInt;
      return this;
    }
    
    public Builder setLandmarkType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
      {
        StringBuilder localStringBuilder = new StringBuilder(34);
        localStringBuilder.append("Invalid landmark type: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      this.landmarkType = paramInt;
      return this;
    }
    
    public Builder setMinFaceSize(float paramFloat)
    {
      if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
      {
        this.proportionalMinFaceSize = paramFloat;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder(47);
      localStringBuilder.append("Invalid proportional face size: ");
      localStringBuilder.append(paramFloat);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public Builder setMode(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
      {
        StringBuilder localStringBuilder = new StringBuilder(25);
        localStringBuilder.append("Invalid mode: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      this.mode = paramInt;
      return this;
    }
    
    public Builder setProminentFaceOnly(boolean paramBoolean)
    {
      this.zzcv = paramBoolean;
      return this;
    }
    
    public Builder setTrackingEnabled(boolean paramBoolean)
    {
      this.trackingEnabled = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\face\FaceDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */