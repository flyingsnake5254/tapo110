package com.tplink.libtpimagedownloadmedia.loader;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.h;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.f;
import java.io.File;

public class c<TranscodeType>
  extends h<TranscodeType>
  implements Cloneable
{
  c(@NonNull com.bumptech.glide.c paramc, @NonNull com.bumptech.glide.i parami, @NonNull Class<TranscodeType> paramClass, @NonNull Context paramContext)
  {
    super(paramc, parami, paramClass, paramContext);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> G0(@Nullable f<TranscodeType> paramf)
  {
    return (c)super.l0(paramf);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> H0(@NonNull a<?> parama)
  {
    return (c)super.m0(parama);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> I0()
  {
    return (c)super.c();
  }
  
  @CheckResult
  public c<TranscodeType> J0()
  {
    return (c)super.q0();
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> K0(@NonNull Class<?> paramClass)
  {
    return (c)super.e(paramClass);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> L0(@NonNull j paramj)
  {
    return (c)super.f(paramj);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> M0(@NonNull DownsampleStrategy paramDownsampleStrategy)
  {
    return (c)super.h(paramDownsampleStrategy);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> N0(@DrawableRes int paramInt)
  {
    return (c)super.j(paramInt);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> O0(@Nullable File paramFile)
  {
    return (c)super.z0(paramFile);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> P0(@Nullable Object paramObject)
  {
    return (c)super.A0(paramObject);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> Q0(@Nullable String paramString)
  {
    return (c)super.B0(paramString);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> R0()
  {
    return (c)super.P();
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> S0()
  {
    return (c)super.Q();
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> T0()
  {
    return (c)super.R();
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> U0(int paramInt1, int paramInt2)
  {
    return (c)super.U(paramInt1, paramInt2);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> V0(@DrawableRes int paramInt)
  {
    return (c)super.V(paramInt);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> W0(@NonNull Priority paramPriority)
  {
    return (c)super.W(paramPriority);
  }
  
  @CheckResult
  @NonNull
  public <Y> c<TranscodeType> X0(@NonNull e<Y> parame, @NonNull Y paramY)
  {
    return (c)super.b0(parame, paramY);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> Y0(@NonNull com.bumptech.glide.load.c paramc)
  {
    return (c)super.c0(paramc);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> Z0(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return (c)super.d0(paramFloat);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> a1(boolean paramBoolean)
  {
    return (c)super.e0(paramBoolean);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> b1(@NonNull com.bumptech.glide.load.i<Bitmap> parami)
  {
    return (c)super.f0(parami);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> c1(@NonNull com.bumptech.glide.load.i<Bitmap>... paramVarArgs)
  {
    return (c)super.j0(paramVarArgs);
  }
  
  @CheckResult
  @NonNull
  public c<TranscodeType> d1(boolean paramBoolean)
  {
    return (c)super.k0(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpimagedownloadmedia\loader\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */