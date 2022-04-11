package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieAnimationView
  extends AppCompatImageView
{
  private static final String c = LottieAnimationView.class.getSimpleName();
  private static final h<Throwable> d = new a();
  private boolean H3 = false;
  private boolean I3 = false;
  private boolean J3 = false;
  private boolean K3 = true;
  private RenderMode L3 = RenderMode.AUTOMATIC;
  private Set<j> M3 = new HashSet();
  private int N3 = 0;
  @Nullable
  private m<d> O3;
  @Nullable
  private d P3;
  private final h<d> f = new b();
  private boolean p0;
  private String p1;
  @RawRes
  private int p2;
  private boolean p3 = false;
  private final h<Throwable> q = new c();
  @Nullable
  private h<Throwable> x;
  @DrawableRes
  private int y = 0;
  private final f z = new f();
  
  public LottieAnimationView(Context paramContext)
  {
    super(paramContext);
    l(null, o.lottieAnimationViewStyle);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    l(paramAttributeSet, o.lottieAnimationViewStyle);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    l(paramAttributeSet, paramInt);
  }
  
  private void h()
  {
    m localm = this.O3;
    if (localm != null)
    {
      localm.k(this.f);
      this.O3.j(this.q);
    }
  }
  
  private void i()
  {
    this.P3 = null;
    this.z.f();
  }
  
  private void k()
  {
    int i = e.a[this.L3.ordinal()];
    int j = 2;
    int k = j;
    if (i != 1)
    {
      if ((i == 2) || (i != 3)) {}
      do
      {
        k = 1;
        break;
        d locald = this.P3;
        k = 0;
        if ((locald == null) || (!locald.p()) || (Build.VERSION.SDK_INT >= 28))
        {
          locald = this.P3;
          if (((locald == null) || (locald.l() <= 4)) && (Build.VERSION.SDK_INT >= 21)) {
            k = 1;
          }
        }
      } while (k == 0);
      k = j;
    }
    if (k != getLayerType()) {
      setLayerType(k, null);
    }
  }
  
  private void l(@Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    Object localObject1 = getContext();
    Object localObject2 = p.LottieAnimationView;
    boolean bool1 = false;
    paramAttributeSet = ((Context)localObject1).obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, 0);
    int i;
    if (!isInEditMode())
    {
      this.K3 = paramAttributeSet.getBoolean(p.LottieAnimationView_lottie_cacheComposition, true);
      i = p.LottieAnimationView_lottie_rawRes;
      boolean bool2 = paramAttributeSet.hasValue(i);
      int j = p.LottieAnimationView_lottie_fileName;
      boolean bool3 = paramAttributeSet.hasValue(j);
      paramInt = p.LottieAnimationView_lottie_url;
      boolean bool4 = paramAttributeSet.hasValue(paramInt);
      if ((bool2) && (bool3)) {
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
      }
      if (bool2)
      {
        paramInt = paramAttributeSet.getResourceId(i, 0);
        if (paramInt != 0) {
          setAnimation(paramInt);
        }
      }
      else if (bool3)
      {
        localObject1 = paramAttributeSet.getString(j);
        if (localObject1 != null) {
          setAnimation((String)localObject1);
        }
      }
      else if (bool4)
      {
        localObject1 = paramAttributeSet.getString(paramInt);
        if (localObject1 != null) {
          setAnimationFromUrl((String)localObject1);
        }
      }
      setFallbackResource(paramAttributeSet.getResourceId(p.LottieAnimationView_lottie_fallbackRes, 0));
    }
    if (paramAttributeSet.getBoolean(p.LottieAnimationView_lottie_autoPlay, false))
    {
      this.I3 = true;
      this.J3 = true;
    }
    if (paramAttributeSet.getBoolean(p.LottieAnimationView_lottie_loop, false)) {
      this.z.a0(-1);
    }
    paramInt = p.LottieAnimationView_lottie_repeatMode;
    if (paramAttributeSet.hasValue(paramInt)) {
      setRepeatMode(paramAttributeSet.getInt(paramInt, 1));
    }
    paramInt = p.LottieAnimationView_lottie_repeatCount;
    if (paramAttributeSet.hasValue(paramInt)) {
      setRepeatCount(paramAttributeSet.getInt(paramInt, -1));
    }
    paramInt = p.LottieAnimationView_lottie_speed;
    if (paramAttributeSet.hasValue(paramInt)) {
      setSpeed(paramAttributeSet.getFloat(paramInt, 1.0F));
    }
    setImageAssetsFolder(paramAttributeSet.getString(p.LottieAnimationView_lottie_imageAssetsFolder));
    setProgress(paramAttributeSet.getFloat(p.LottieAnimationView_lottie_progress, 0.0F));
    j(paramAttributeSet.getBoolean(p.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
    paramInt = p.LottieAnimationView_lottie_colorFilter;
    if (paramAttributeSet.hasValue(paramInt))
    {
      localObject2 = new q(paramAttributeSet.getColor(paramInt, 0));
      localObject1 = new com.airbnb.lottie.model.d(new String[] { "**" });
      localObject2 = new com.airbnb.lottie.w.c(localObject2);
      e((com.airbnb.lottie.model.d)localObject1, k.C, (com.airbnb.lottie.w.c)localObject2);
    }
    paramInt = p.LottieAnimationView_lottie_scale;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.z.d0(paramAttributeSet.getFloat(paramInt, 1.0F));
    }
    paramInt = p.LottieAnimationView_lottie_renderMode;
    if (paramAttributeSet.hasValue(paramInt))
    {
      localObject1 = RenderMode.AUTOMATIC;
      i = paramAttributeSet.getInt(paramInt, ((Enum)localObject1).ordinal());
      paramInt = i;
      if (i >= RenderMode.values().length) {
        paramInt = ((Enum)localObject1).ordinal();
      }
      setRenderMode(RenderMode.values()[paramInt]);
    }
    if (getScaleType() != null) {
      this.z.e0(getScaleType());
    }
    paramAttributeSet.recycle();
    paramAttributeSet = this.z;
    if (com.airbnb.lottie.v.h.f(getContext()) != 0.0F) {
      bool1 = true;
    }
    paramAttributeSet.g0(Boolean.valueOf(bool1));
    k();
    this.p0 = true;
  }
  
  private void setCompositionTask(m<d> paramm)
  {
    i();
    h();
    this.O3 = paramm.f(this.f).e(this.q);
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    c.a("buildDrawingCache");
    this.N3 += 1;
    super.buildDrawingCache(paramBoolean);
    if ((this.N3 == 1) && (getWidth() > 0) && (getHeight() > 0) && (getLayerType() == 1) && (getDrawingCache(paramBoolean) == null)) {
      setRenderMode(RenderMode.HARDWARE);
    }
    this.N3 -= 1;
    c.b("buildDrawingCache");
  }
  
  public boolean d(@NonNull j paramj)
  {
    d locald = this.P3;
    if (locald != null) {
      paramj.a(locald);
    }
    return this.M3.add(paramj);
  }
  
  public <T> void e(com.airbnb.lottie.model.d paramd, T paramT, com.airbnb.lottie.w.c<T> paramc)
  {
    this.z.c(paramd, paramT, paramc);
  }
  
  public <T> void f(com.airbnb.lottie.model.d paramd, T paramT, final com.airbnb.lottie.w.e<T> parame)
  {
    this.z.c(paramd, paramT, new d(parame));
  }
  
  @MainThread
  public void g()
  {
    this.I3 = false;
    this.H3 = false;
    this.p3 = false;
    this.z.e();
    k();
  }
  
  @Nullable
  public d getComposition()
  {
    return this.P3;
  }
  
  public long getDuration()
  {
    d locald = this.P3;
    long l;
    if (locald != null) {
      l = locald.d();
    } else {
      l = 0L;
    }
    return l;
  }
  
  public int getFrame()
  {
    return this.z.p();
  }
  
  @Nullable
  public String getImageAssetsFolder()
  {
    return this.z.s();
  }
  
  public float getMaxFrame()
  {
    return this.z.t();
  }
  
  public float getMinFrame()
  {
    return this.z.v();
  }
  
  @Nullable
  public n getPerformanceTracker()
  {
    return this.z.w();
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.z.x();
  }
  
  public int getRepeatCount()
  {
    return this.z.y();
  }
  
  public int getRepeatMode()
  {
    return this.z.z();
  }
  
  public float getScale()
  {
    return this.z.A();
  }
  
  public float getSpeed()
  {
    return this.z.B();
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    f localf = this.z;
    if (localDrawable == localf) {
      super.invalidateDrawable(localf);
    } else {
      super.invalidateDrawable(paramDrawable);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    this.z.j(paramBoolean);
  }
  
  public boolean m()
  {
    return this.z.E();
  }
  
  @MainThread
  public void n()
  {
    this.J3 = false;
    this.I3 = false;
    this.H3 = false;
    this.p3 = false;
    this.z.G();
    k();
  }
  
  @MainThread
  public void o()
  {
    if (isShown())
    {
      this.z.H();
      k();
    }
    else
    {
      this.p3 = true;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.J3) || (this.I3))
    {
      o();
      this.J3 = false;
      this.I3 = false;
    }
    if (Build.VERSION.SDK_INT < 23) {
      onVisibilityChanged(this, getVisibility());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (m())
    {
      g();
      this.I3 = true;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    String str = paramParcelable.c;
    this.p1 = str;
    if (!TextUtils.isEmpty(str)) {
      setAnimation(this.p1);
    }
    int i = paramParcelable.d;
    this.p2 = i;
    if (i != 0) {
      setAnimation(i);
    }
    setProgress(paramParcelable.f);
    if (paramParcelable.q) {
      o();
    }
    this.z.P(paramParcelable.x);
    setRepeatMode(paramParcelable.y);
    setRepeatCount(paramParcelable.z);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.c = this.p1;
    localSavedState.d = this.p2;
    localSavedState.f = this.z.x();
    boolean bool;
    if ((!this.z.E()) && ((ViewCompat.isAttachedToWindow(this)) || (!this.I3))) {
      bool = false;
    } else {
      bool = true;
    }
    localSavedState.q = bool;
    localSavedState.x = this.z.s();
    localSavedState.y = this.z.z();
    localSavedState.z = this.z.y();
    return localSavedState;
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (!this.p0) {
      return;
    }
    if (isShown())
    {
      if (this.H3) {
        q();
      } else if (this.p3) {
        o();
      }
      this.H3 = false;
      this.p3 = false;
    }
    else if (m())
    {
      n();
      this.H3 = true;
    }
  }
  
  public List<com.airbnb.lottie.model.d> p(com.airbnb.lottie.model.d paramd)
  {
    return this.z.I(paramd);
  }
  
  @MainThread
  public void q()
  {
    if (isShown())
    {
      this.z.J();
      k();
    }
    else
    {
      this.p3 = false;
      this.H3 = true;
    }
  }
  
  public void r(InputStream paramInputStream, @Nullable String paramString)
  {
    setCompositionTask(e.h(paramInputStream, paramString));
  }
  
  public void s(String paramString1, @Nullable String paramString2)
  {
    r(new ByteArrayInputStream(paramString1.getBytes()), paramString2);
  }
  
  public void setAnimation(@RawRes int paramInt)
  {
    this.p2 = paramInt;
    this.p1 = null;
    m localm;
    if (this.K3) {
      localm = e.m(getContext(), paramInt);
    } else {
      localm = e.n(getContext(), paramInt, null);
    }
    setCompositionTask(localm);
  }
  
  public void setAnimation(String paramString)
  {
    this.p1 = paramString;
    this.p2 = 0;
    if (this.K3) {
      paramString = e.d(getContext(), paramString);
    } else {
      paramString = e.e(getContext(), paramString, null);
    }
    setCompositionTask(paramString);
  }
  
  @Deprecated
  public void setAnimationFromJson(String paramString)
  {
    s(paramString, null);
  }
  
  public void setAnimationFromUrl(String paramString)
  {
    if (this.K3) {
      paramString = e.q(getContext(), paramString);
    } else {
      paramString = e.r(getContext(), paramString, null);
    }
    setCompositionTask(paramString);
  }
  
  public void setApplyingOpacityToLayersEnabled(boolean paramBoolean)
  {
    this.z.K(paramBoolean);
  }
  
  public void setCacheComposition(boolean paramBoolean)
  {
    this.K3 = paramBoolean;
  }
  
  public void setComposition(@NonNull d paramd)
  {
    if (c.a)
    {
      String str = c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Set Composition \n");
      ((StringBuilder)localObject).append(paramd);
      Log.v(str, ((StringBuilder)localObject).toString());
    }
    this.z.setCallback(this);
    this.P3 = paramd;
    boolean bool = this.z.L(paramd);
    k();
    if ((getDrawable() == this.z) && (!bool)) {
      return;
    }
    onVisibilityChanged(this, getVisibility());
    requestLayout();
    Object localObject = this.M3.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((j)((Iterator)localObject).next()).a(paramd);
    }
  }
  
  public void setFailureListener(@Nullable h<Throwable> paramh)
  {
    this.x = paramh;
  }
  
  public void setFallbackResource(@DrawableRes int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setFontAssetDelegate(a parama)
  {
    this.z.M(parama);
  }
  
  public void setFrame(int paramInt)
  {
    this.z.N(paramInt);
  }
  
  public void setImageAssetDelegate(b paramb)
  {
    this.z.O(paramb);
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.z.P(paramString);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    h();
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    h();
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    h();
    super.setImageResource(paramInt);
  }
  
  public void setMaxFrame(int paramInt)
  {
    this.z.Q(paramInt);
  }
  
  public void setMaxFrame(String paramString)
  {
    this.z.R(paramString);
  }
  
  public void setMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.z.S(paramFloat);
  }
  
  public void setMinAndMaxFrame(String paramString)
  {
    this.z.U(paramString);
  }
  
  public void setMinFrame(int paramInt)
  {
    this.z.V(paramInt);
  }
  
  public void setMinFrame(String paramString)
  {
    this.z.W(paramString);
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.z.X(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.z.Y(paramBoolean);
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.z.Z(paramFloat);
  }
  
  public void setRenderMode(RenderMode paramRenderMode)
  {
    this.L3 = paramRenderMode;
    k();
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.z.a0(paramInt);
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.z.b0(paramInt);
  }
  
  public void setSafeMode(boolean paramBoolean)
  {
    this.z.c0(paramBoolean);
  }
  
  public void setScale(float paramFloat)
  {
    this.z.d0(paramFloat);
    if (getDrawable() == this.z)
    {
      setImageDrawable(null);
      setImageDrawable(this.z);
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    super.setScaleType(paramScaleType);
    f localf = this.z;
    if (localf != null) {
      localf.e0(paramScaleType);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    this.z.f0(paramFloat);
  }
  
  public void setTextDelegate(r paramr)
  {
    this.z.h0(paramr);
  }
  
  private static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    String c;
    int d;
    float f;
    boolean q;
    String x;
    int y;
    int z;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.c = paramParcel.readString();
      this.f = paramParcel.readFloat();
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.q = bool;
      this.x = paramParcel.readString();
      this.y = paramParcel.readInt();
      this.z = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.c);
      paramParcel.writeFloat(this.f);
      paramParcel.writeInt(this.q);
      paramParcel.writeString(this.x);
      paramParcel.writeInt(this.y);
      paramParcel.writeInt(this.z);
    }
    
    class a
      implements Parcelable.Creator<LottieAnimationView.SavedState>
    {
      public LottieAnimationView.SavedState a(Parcel paramParcel)
      {
        return new LottieAnimationView.SavedState(paramParcel, null);
      }
      
      public LottieAnimationView.SavedState[] b(int paramInt)
      {
        return new LottieAnimationView.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements h<Throwable>
  {
    public void b(Throwable paramThrowable)
    {
      if (com.airbnb.lottie.v.h.k(paramThrowable))
      {
        com.airbnb.lottie.v.d.d("Unable to load composition.", paramThrowable);
        return;
      }
      throw new IllegalStateException("Unable to parse composition", paramThrowable);
    }
  }
  
  class b
    implements h<d>
  {
    b() {}
    
    public void b(d paramd)
    {
      LottieAnimationView.this.setComposition(paramd);
    }
  }
  
  class c
    implements h<Throwable>
  {
    c() {}
    
    public void b(Throwable paramThrowable)
    {
      Object localObject;
      if (LottieAnimationView.a(LottieAnimationView.this) != 0)
      {
        localObject = LottieAnimationView.this;
        ((LottieAnimationView)localObject).setImageResource(LottieAnimationView.a((LottieAnimationView)localObject));
      }
      if (LottieAnimationView.b(LottieAnimationView.this) == null) {
        localObject = LottieAnimationView.c();
      } else {
        localObject = LottieAnimationView.b(LottieAnimationView.this);
      }
      ((h)localObject).a(paramThrowable);
    }
  }
  
  class d
    extends com.airbnb.lottie.w.c<T>
  {
    d(com.airbnb.lottie.w.e parame) {}
    
    public T a(com.airbnb.lottie.w.b<T> paramb)
    {
      return (T)parame.a(paramb);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\LottieAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */