package com.google.mlkit.vision.barcode;

import android.graphics.Matrix;
import android.graphics.Point;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.vision.Frame;
import com.google.android.libraries.barhopper.Barcode;
import com.google.android.libraries.barhopper.BarhopperV2;
import com.google.android.libraries.barhopper.RecognitionOptions;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerOptionsParcel;
import com.google.mlkit.vision.barcode.internal.a.a;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

final class d
  extends a.a
{
  private final RecognitionOptions a;
  @Nullable
  private BarhopperV2 b;
  
  d(BarcodeScannerOptionsParcel paramBarcodeScannerOptionsParcel)
  {
    RecognitionOptions localRecognitionOptions = new RecognitionOptions();
    this.a = localRecognitionOptions;
    localRecognitionOptions.a(paramBarcodeScannerOptionsParcel.c);
  }
  
  public final IObjectWrapper a(IObjectWrapper paramIObjectWrapper, @NonNull VisionImageMetadataParcel paramVisionImageMetadataParcel)
  {
    if (this.b == null)
    {
      Log.w("BarcodeScannerImpl", "Start method should be called first before scanning.");
      localObject1 = new BarhopperV2();
      this.b = ((BarhopperV2)localObject1);
      ((BarhopperV2)localObject1).a();
    }
    Object localObject2 = (Frame)ObjectWrapper.unwrap(paramIObjectWrapper);
    Object localObject1 = ((Frame)localObject2).getGrayscaleImageData();
    paramIObjectWrapper = null;
    if (((Frame)localObject2).getBitmap() != null) {
      paramIObjectWrapper = this.b.g(((Frame)localObject2).getBitmap(), this.a);
    } else if (localObject1 != null) {
      if (((ByteBuffer)localObject1).isDirect())
      {
        paramIObjectWrapper = this.b.c(paramVisionImageMetadataParcel.c, paramVisionImageMetadataParcel.d, (ByteBuffer)localObject1, this.a);
      }
      else if ((((ByteBuffer)localObject1).hasArray()) && (((ByteBuffer)localObject1).arrayOffset() == 0))
      {
        paramIObjectWrapper = this.b.e(paramVisionImageMetadataParcel.c, paramVisionImageMetadataParcel.d, ((ByteBuffer)localObject1).array(), this.a);
      }
      else
      {
        paramIObjectWrapper = new byte[((ByteBuffer)localObject1).remaining()];
        ((ByteBuffer)localObject1).get(paramIObjectWrapper);
        paramIObjectWrapper = this.b.e(paramVisionImageMetadataParcel.c, paramVisionImageMetadataParcel.d, paramIObjectWrapper, this.a);
      }
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = paramVisionImageMetadataParcel.a();
    int i = paramIObjectWrapper.length;
    for (int j = 0; j < i; j++)
    {
      Barcode localBarcode = paramIObjectWrapper[j];
      if ((localBarcode.cornerPoints != null) && (localObject1 != null))
      {
        localObject2 = new float[8];
        Object localObject3;
        for (int k = 0;; k++)
        {
          localObject3 = localBarcode.cornerPoints;
          if (k >= localObject3.length) {
            break;
          }
          m = k * 2;
          localObject2[m] = localObject3[k].x;
          localObject2[(m + 1)] = localObject3[k].y;
        }
        ((Matrix)localObject1).mapPoints((float[])localObject2);
        int m = paramVisionImageMetadataParcel.x;
        for (k = 0;; k++)
        {
          localObject3 = localBarcode.cornerPoints;
          if (k >= localObject3.length) {
            break;
          }
          localObject3 = localObject3[((k + m) % localObject3.length)];
          int n = k * 2;
          ((Point)localObject3).x = ((int)localObject2[n]);
          ((Point)localObject3).y = ((int)localObject2[(n + 1)]);
        }
      }
      localArrayList.add(new f(localBarcode));
    }
    return ObjectWrapper.wrap(localArrayList);
  }
  
  public final void a_()
  {
    if (this.b != null) {
      return;
    }
    BarhopperV2 localBarhopperV2 = new BarhopperV2();
    this.b = localBarhopperV2;
    localBarhopperV2.a();
  }
  
  public final void zzb()
  {
    BarhopperV2 localBarhopperV2 = this.b;
    if (localBarhopperV2 != null)
    {
      localBarhopperV2.close();
      this.b = null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */