package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzcj;
import com.google.android.gms.internal.mlkit_vision_common.zzck;
import com.google.android.gms.internal.mlkit_vision_common.zzco;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzh;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.List;

@KeepForSdk
public class VisionCommonRegistrar
  implements ComponentRegistrar
{
  public List<Component<?>> getComponents()
  {
    return zzh.zza(zzco.zza, zzck.zza, zzcj.zza, zzcq.zza, Component.builder(e.class).add(Dependency.setOf(e.a.class)).factory(i.a).build());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\VisionCommonRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */