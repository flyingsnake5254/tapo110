package com.google.android.gms.vision.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzaj;
import com.google.android.gms.internal.vision.zzam;
import com.google.android.gms.internal.vision.zzan;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.internal.vision.zzv;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame.Metadata;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class TextRecognizer
  extends Detector<TextBlock>
{
  private final zzan zzem;
  
  private TextRecognizer()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  private TextRecognizer(zzan paramzzan)
  {
    this.zzem = paramzzan;
  }
  
  public final SparseArray<TextBlock> detect(Frame paramFrame)
  {
    Object localObject1 = new zzaj(new Rect());
    if (paramFrame != null)
    {
      Object localObject2 = zzu.zzd(paramFrame);
      Object localObject3 = paramFrame.getBitmap();
      int i = 0;
      int m;
      if (localObject3 != null)
      {
        localObject3 = paramFrame.getBitmap();
      }
      else
      {
        localObject3 = paramFrame.getMetadata();
        localObject4 = paramFrame.getGrayscaleImageData();
        j = ((Frame.Metadata)localObject3).getFormat();
        k = ((zzu)localObject2).width;
        m = ((zzu)localObject2).height;
        if ((((ByteBuffer)localObject4).hasArray()) && (((ByteBuffer)localObject4).arrayOffset() == 0))
        {
          localObject3 = ((ByteBuffer)localObject4).array();
        }
        else
        {
          localObject3 = new byte[((ByteBuffer)localObject4).capacity()];
          ((ByteBuffer)localObject4).get((byte[])localObject3);
        }
        localObject4 = new ByteArrayOutputStream();
        new YuvImage((byte[])localObject3, j, k, m, null).compressToJpeg(new Rect(0, 0, k, m), 100, (OutputStream)localObject4);
        localObject3 = ((ByteArrayOutputStream)localObject4).toByteArray();
        localObject3 = BitmapFactory.decodeByteArray((byte[])localObject3, 0, localObject3.length);
      }
      Object localObject4 = zzv.zzb((Bitmap)localObject3, (zzu)localObject2);
      if (!((zzaj)localObject1).zzey.isEmpty())
      {
        localObject3 = ((zzaj)localObject1).zzey;
        j = paramFrame.getMetadata().getWidth();
        k = paramFrame.getMetadata().getHeight();
        m = ((zzu)localObject2).rotation;
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3) {
              paramFrame = (Frame)localObject3;
            } else {
              paramFrame = new Rect(((Rect)localObject3).top, j - ((Rect)localObject3).right, ((Rect)localObject3).bottom, j - ((Rect)localObject3).left);
            }
          }
          else {
            paramFrame = new Rect(j - ((Rect)localObject3).right, k - ((Rect)localObject3).bottom, j - ((Rect)localObject3).left, k - ((Rect)localObject3).top);
          }
        }
        else {
          paramFrame = new Rect(k - ((Rect)localObject3).bottom, ((Rect)localObject3).left, k - ((Rect)localObject3).top, ((Rect)localObject3).right);
        }
        ((zzaj)localObject1).zzey.set(paramFrame);
      }
      ((zzu)localObject2).rotation = 0;
      localObject2 = this.zzem.zza((Bitmap)localObject4, (zzu)localObject2, (zzaj)localObject1);
      localObject1 = new SparseArray();
      int k = localObject2.length;
      for (int j = 0; j < k; j++)
      {
        localObject4 = localObject2[j];
        localObject3 = (SparseArray)((SparseArray)localObject1).get(((zzah)localObject4).zzew);
        paramFrame = (Frame)localObject3;
        if (localObject3 == null)
        {
          paramFrame = new SparseArray();
          ((SparseArray)localObject1).append(((zzah)localObject4).zzew, paramFrame);
        }
        paramFrame.append(((zzah)localObject4).zzex, localObject4);
      }
      paramFrame = new SparseArray(((SparseArray)localObject1).size());
      for (j = i; j < ((SparseArray)localObject1).size(); j++) {
        paramFrame.append(((SparseArray)localObject1).keyAt(j), new TextBlock((SparseArray)((SparseArray)localObject1).valueAt(j)));
      }
      return paramFrame;
    }
    throw new IllegalArgumentException("No frame supplied.");
  }
  
  public final boolean isOperational()
  {
    return this.zzem.isOperational();
  }
  
  public final void release()
  {
    super.release();
    this.zzem.zzp();
  }
  
  public static class Builder
  {
    private zzam zzen;
    private Context zzg;
    
    public Builder(Context paramContext)
    {
      this.zzg = paramContext;
      this.zzen = new zzam();
    }
    
    public TextRecognizer build()
    {
      return new TextRecognizer(new zzan(this.zzg, this.zzen), null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\text\TextRecognizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */