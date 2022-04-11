package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.media.Image.Plane;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzc.zzb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzc.zzb.zza;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzeg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzem;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga.zzb;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame.Builder;
import com.google.android.gms.vision.Frame.Metadata;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.gms.vision.barcode.BarcodeDetector.Builder;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;
import com.google.mlkit.vision.common.internal.c;
import com.google.mlkit.vision.common.internal.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends com.google.mlkit.common.sdkinternal.g<List<com.google.mlkit.vision.barcode.a>, b.b.a.a.a.a>
{
  private static final d d = ;
  @VisibleForTesting
  private static boolean e = true;
  private final Context f;
  private final com.google.mlkit.vision.barcode.b g;
  private final zzeg h;
  private final com.google.mlkit.vision.common.internal.a i = new com.google.mlkit.vision.common.internal.a();
  @Nullable
  private a j;
  @Nullable
  private BarcodeDetector k;
  
  public g(@NonNull com.google.mlkit.common.sdkinternal.j paramj, @NonNull com.google.mlkit.vision.barcode.b paramb)
  {
    Preconditions.checkNotNull(paramj, "MlKitContext can not be null");
    Preconditions.checkNotNull(paramb, "BarcodeScannerOptions can not be null");
    this.f = paramj.b();
    this.g = paramb;
    this.h = ((zzeg)paramj.a(zzeg.class));
  }
  
  private static Frame k(@NonNull b.b.a.a.a.a parama)
    throws MlKitException
  {
    try
    {
      if (parama.d() == -1)
      {
        localBuilder = new com/google/android/gms/vision/Frame$Builder;
        localBuilder.<init>();
        parama = localBuilder.setBitmap(parama.b()).setRotation(parama.g()).build();
        return parama;
      }
      if (parama.d() == 17)
      {
        localBuilder = new com/google/android/gms/vision/Frame$Builder;
        localBuilder.<init>();
        parama = localBuilder.setImageData(parama.c(), parama.h(), parama.e(), 17).setRotation(com.google.mlkit.vision.common.internal.b.a(parama.g())).build();
        return parama;
      }
      if (parama.d() == 842094169)
      {
        localBuilder = new com/google/android/gms/vision/Frame$Builder;
        localBuilder.<init>();
        parama = localBuilder.setImageData(c.d().b(parama, false), parama.h(), parama.e(), 17).setRotation(com.google.mlkit.vision.common.internal.b.a(parama.g())).build();
        return parama;
      }
      if ((Build.VERSION.SDK_INT >= 19) && (parama.d() == 35))
      {
        localBuilder = new com/google/android/gms/vision/Frame$Builder;
        localBuilder.<init>();
        parama = localBuilder.setImageData(parama.f()[0].getBuffer(), parama.h(), parama.e(), 17).setRotation(com.google.mlkit.vision.common.internal.b.a(parama.g())).build();
        return parama;
      }
      parama = c.d().c(parama);
      Frame.Builder localBuilder = new com/google/android/gms/vision/Frame$Builder;
      localBuilder.<init>();
      parama = localBuilder.setBitmap(parama).build();
      return parama;
    }
    finally {}
  }
  
  @WorkerThread
  private final void l(zzbv paramzzbv, long paramLong, @NonNull b.b.a.a.a.a parama, @Nullable List<com.google.mlkit.vision.barcode.a> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (com.google.mlkit.vision.barcode.a)localIterator.next();
        localArrayList1.add(paramList.d());
        localArrayList2.add(paramList.e());
      }
    }
    paramLong = SystemClock.elapsedRealtime() - paramLong;
    paramList = new f(this, paramLong, paramzzbv, localArrayList1, localArrayList2, parama);
    this.h.zza(paramList, zzbw.zza);
    paramzzbv = zzbl.zzc.zzb.zza().zza(paramzzbv).zza(e);
    paramList = d;
    parama = (zzbl.zzc.zzb)paramzzbv.zza(zzem.zza(paramList.b(parama), paramList.c(parama))).zza(this.g.c()).zza(localArrayList1).zzb(localArrayList2).zzg();
    paramzzbv = new i(this);
    this.h.zza(parama, paramLong, zzbw.zzc, paramzzbv);
  }
  
  @Nullable
  @VisibleForTesting
  private final a m()
    throws MlKitException
  {
    if (DynamiteModule.getLocalVersion(this.f, "com.google.mlkit.dynamite.barcode") > 0)
    {
      try
      {
        m localm = l.asInterface(DynamiteModule.load(this.f, DynamiteModule.PREFER_LOCAL, "com.google.mlkit.dynamite.barcode").instantiate("com.google.mlkit.vision.barcode.BarcodeScannerCreator"));
        Object localObject = new com/google/mlkit/vision/barcode/internal/BarcodeScannerOptionsParcel;
        ((BarcodeScannerOptionsParcel)localObject).<init>(this.g.a());
        localObject = localm.newBarcodeScanner((BarcodeScannerOptionsParcel)localObject);
        return (a)localObject;
      }
      catch (DynamiteModule.LoadingException localLoadingException) {}catch (RemoteException localRemoteException) {}
      throw new MlKitException("Failed to load barcode scanner module.", 14, localRemoteException);
    }
    return null;
  }
  
  @WorkerThread
  private final List<com.google.mlkit.vision.barcode.a> n(@NonNull b.b.a.a.a.a parama)
    throws MlKitException
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      this.i.a(parama);
      Object localObject1 = k(parama);
      Object localObject2 = new java/util/ArrayList;
      ((ArrayList)localObject2).<init>();
      Object localObject3 = this.j;
      Object localObject4;
      if (localObject3 != null)
      {
        try
        {
          localObject3 = ObjectWrapper.wrap(localObject1);
          localObject4 = new com/google/mlkit/vision/common/internal/VisionImageMetadataParcel;
          ((VisionImageMetadataParcel)localObject4).<init>(((Frame)localObject1).getMetadata().getWidth(), ((Frame)localObject1).getMetadata().getHeight(), 0, SystemClock.elapsedRealtime(), ((Frame)localObject1).getMetadata().getRotation());
          localObject1 = ((List)ObjectWrapper.unwrap(this.j.a((IObjectWrapper)localObject3, (VisionImageMetadataParcel)localObject4))).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (h)((Iterator)localObject1).next();
            localObject3 = new com/google/mlkit/vision/barcode/a;
            ((com.google.mlkit.vision.barcode.a)localObject3).<init>((h)localObject4);
            ((List)localObject2).add(localObject3);
          }
          localObject3 = this.k;
        }
        catch (RemoteException parama)
        {
          localObject2 = new com/google/mlkit/common/MlKitException;
          ((MlKitException)localObject2).<init>("Failed to run barcode scanner.", 14, parama);
          throw ((Throwable)localObject2);
        }
      }
      else
      {
        if (localObject3 == null) {
          break label324;
        }
        if (!((BarcodeDetector)localObject3).isOperational()) {
          break label299;
        }
        SparseArray localSparseArray = this.k.detect((Frame)localObject1);
        for (int m = 0; m < localSparseArray.size(); m++)
        {
          localObject1 = (Barcode)localSparseArray.get(localSparseArray.keyAt(m));
          localObject4 = new com/google/mlkit/vision/barcode/a;
          localObject3 = new com/google/mlkit/vision/barcode/internal/j;
          ((j)localObject3).<init>((Barcode)localObject1);
          ((com.google.mlkit.vision.barcode.a)localObject4).<init>((h)localObject3);
          ((List)localObject2).add(localObject4);
        }
      }
      l(zzbv.zza, l, parama, (List)localObject2);
      e = false;
      return (List<com.google.mlkit.vision.barcode.a>)localObject2;
      label299:
      l(zzbv.zzb, l, parama, null);
      parama = new com/google/mlkit/common/MlKitException;
      parama.<init>("Waiting for the barcode scanning model to be downloaded. Please wait.", 14);
      throw parama;
      label324:
      l(zzbv.zzc, l, parama, null);
      parama = new com/google/mlkit/common/MlKitException;
      parama.<init>("Model source is unavailable. Please load the model resource first.", 14);
      throw parama;
    }
    finally {}
  }
  
  private final boolean o()
  {
    return this.j != null;
  }
  
  @WorkerThread
  public final void b()
    throws MlKitException
  {
    try
    {
      if (this.j == null) {
        this.j = m();
      }
      a locala = this.j;
      if (locala != null) {
        try
        {
          locala.a_();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          MlKitException localMlKitException = new com/google/mlkit/common/MlKitException;
          localMlKitException.<init>("Failed to start barcode scanner pipeline.", 14, localRemoteException);
          throw localMlKitException;
        }
      }
      if (this.k == null)
      {
        BarcodeDetector.Builder localBuilder = new com/google/android/gms/vision/barcode/BarcodeDetector$Builder;
        localBuilder.<init>(this.f);
        this.k = localBuilder.setBarcodeFormats(this.g.a()).build();
      }
      return;
    }
    finally {}
  }
  
  @WorkerThread
  public final void d()
  {
    try
    {
      a locala = this.j;
      if (locala != null)
      {
        try
        {
          locala.zzb();
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("BarcodeScannerTask", "Failed to stop barcode scanner pipeline.", localRemoteException);
        }
        this.j = null;
      }
      BarcodeDetector localBarcodeDetector = this.k;
      if (localBarcodeDetector != null)
      {
        localBarcodeDetector.release();
        this.k = null;
      }
      e = true;
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */