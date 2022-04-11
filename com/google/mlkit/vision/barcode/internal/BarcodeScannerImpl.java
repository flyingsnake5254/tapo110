package com.google.mlkit.vision.barcode.internal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzad;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzad.zza;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl.zzao.zzc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzeg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga.zzb;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.e;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.b;
import com.google.mlkit.vision.barcode.b.a;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.List;
import java.util.concurrent.Executor;

public class BarcodeScannerImpl
  extends MobileVisionBase<List<com.google.mlkit.vision.barcode.a>>
  implements BarcodeScanner
{
  private static final b y = new b.a().a();
  
  @VisibleForTesting
  BarcodeScannerImpl(@NonNull zzeg paramzzeg, @NonNull b paramb, @NonNull g paramg, @NonNull Executor paramExecutor)
  {
    super(paramg, paramExecutor);
    paramb = (zzbl.zzao)zzbl.zzao.zza().zza(paramb.c()).zzg();
    paramzzeg.zza(zzbl.zzad.zzb().zza(paramb), zzbw.zzb);
  }
  
  @NonNull
  public Task<List<com.google.mlkit.vision.barcode.a>> q(@NonNull b.b.a.a.a.a parama)
  {
    return super.a(parama);
  }
  
  public static class a
  {
    private final zzeg a;
    private final d b;
    private final com.google.mlkit.common.sdkinternal.d c;
    
    a(zzeg paramzzeg, d paramd, com.google.mlkit.common.sdkinternal.d paramd1)
    {
      this.a = paramzzeg;
      this.b = paramd;
      this.c = paramd1;
    }
    
    public final BarcodeScannerImpl a(@NonNull b paramb)
    {
      return new BarcodeScannerImpl(this.a, paramb, (g)this.b.get(paramb), this.c.a(paramb.b()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\BarcodeScannerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */