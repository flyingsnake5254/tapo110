package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode.zzee;
import com.google.android.gms.internal.mlkit_vision_barcode.zzeg;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.j;
import java.util.List;

@KeepForSdk
public class BarcodeRegistrar
  implements ComponentRegistrar
{
  public List<Component<?>> getComponents()
  {
    return zzap.zza(zzee.zza, zzed.zza, zzeg.zza, Component.builder(d.class).add(Dependency.required(j.class)).factory(b.a).build(), Component.builder(BarcodeScannerImpl.a.class).add(Dependency.required(zzeg.class)).add(Dependency.required(d.class)).add(Dependency.required(com.google.mlkit.common.sdkinternal.d.class)).factory(c.a).build());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\barcode\internal\BarcodeRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */