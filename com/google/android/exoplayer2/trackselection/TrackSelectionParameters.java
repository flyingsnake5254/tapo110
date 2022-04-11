package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public class TrackSelectionParameters
  implements Parcelable
{
  public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new a();
  public static final TrackSelectionParameters c;
  @Deprecated
  public static final TrackSelectionParameters d;
  public final int H3;
  public final boolean I3;
  public final ImmutableList<String> J3;
  public final ImmutableList<String> K3;
  public final int L3;
  public final int M3;
  public final int N3;
  public final ImmutableList<String> O3;
  public final ImmutableList<String> P3;
  public final int Q3;
  public final boolean R3;
  public final boolean S3;
  public final boolean T3;
  public final int f;
  public final int p0;
  public final int p1;
  public final int p2;
  public final int p3;
  public final int q;
  public final int x;
  public final int y;
  public final int z;
  
  static
  {
    TrackSelectionParameters localTrackSelectionParameters = new b().w();
    c = localTrackSelectionParameters;
    d = localTrackSelectionParameters;
  }
  
  TrackSelectionParameters(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList(localArrayList, null);
    this.K3 = ImmutableList.copyOf(localArrayList);
    this.L3 = paramParcel.readInt();
    localArrayList = new ArrayList();
    paramParcel.readList(localArrayList, null);
    this.P3 = ImmutableList.copyOf(localArrayList);
    this.Q3 = paramParcel.readInt();
    this.R3 = o0.A0(paramParcel);
    this.f = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readInt();
    this.p0 = paramParcel.readInt();
    this.p1 = paramParcel.readInt();
    this.p2 = paramParcel.readInt();
    this.p3 = paramParcel.readInt();
    this.H3 = paramParcel.readInt();
    this.I3 = o0.A0(paramParcel);
    localArrayList = new ArrayList();
    paramParcel.readList(localArrayList, null);
    this.J3 = ImmutableList.copyOf(localArrayList);
    this.M3 = paramParcel.readInt();
    this.N3 = paramParcel.readInt();
    localArrayList = new ArrayList();
    paramParcel.readList(localArrayList, null);
    this.O3 = ImmutableList.copyOf(localArrayList);
    this.S3 = o0.A0(paramParcel);
    this.T3 = o0.A0(paramParcel);
  }
  
  protected TrackSelectionParameters(b paramb)
  {
    this.f = b.a(paramb);
    this.q = b.b(paramb);
    this.x = b.m(paramb);
    this.y = b.p(paramb);
    this.z = b.q(paramb);
    this.p0 = b.r(paramb);
    this.p1 = b.s(paramb);
    this.p2 = b.t(paramb);
    this.p3 = b.u(paramb);
    this.H3 = b.v(paramb);
    this.I3 = b.c(paramb);
    this.J3 = b.d(paramb);
    this.K3 = b.e(paramb);
    this.L3 = b.f(paramb);
    this.M3 = b.g(paramb);
    this.N3 = b.h(paramb);
    this.O3 = b.i(paramb);
    this.P3 = b.j(paramb);
    this.Q3 = b.k(paramb);
    this.R3 = b.l(paramb);
    this.S3 = b.n(paramb);
    this.T3 = b.o(paramb);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (TrackSelectionParameters)paramObject;
      if ((this.f != ((TrackSelectionParameters)paramObject).f) || (this.q != ((TrackSelectionParameters)paramObject).q) || (this.x != ((TrackSelectionParameters)paramObject).x) || (this.y != ((TrackSelectionParameters)paramObject).y) || (this.z != ((TrackSelectionParameters)paramObject).z) || (this.p0 != ((TrackSelectionParameters)paramObject).p0) || (this.p1 != ((TrackSelectionParameters)paramObject).p1) || (this.p2 != ((TrackSelectionParameters)paramObject).p2) || (this.I3 != ((TrackSelectionParameters)paramObject).I3) || (this.p3 != ((TrackSelectionParameters)paramObject).p3) || (this.H3 != ((TrackSelectionParameters)paramObject).H3) || (!this.J3.equals(((TrackSelectionParameters)paramObject).J3)) || (!this.K3.equals(((TrackSelectionParameters)paramObject).K3)) || (this.L3 != ((TrackSelectionParameters)paramObject).L3) || (this.M3 != ((TrackSelectionParameters)paramObject).M3) || (this.N3 != ((TrackSelectionParameters)paramObject).N3) || (!this.O3.equals(((TrackSelectionParameters)paramObject).O3)) || (!this.P3.equals(((TrackSelectionParameters)paramObject).P3)) || (this.Q3 != ((TrackSelectionParameters)paramObject).Q3) || (this.R3 != ((TrackSelectionParameters)paramObject).R3) || (this.S3 != ((TrackSelectionParameters)paramObject).S3) || (this.T3 != ((TrackSelectionParameters)paramObject).T3)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((((((((((((((((((((this.f + 31) * 31 + this.q) * 31 + this.x) * 31 + this.y) * 31 + this.z) * 31 + this.p0) * 31 + this.p1) * 31 + this.p2) * 31 + this.I3) * 31 + this.p3) * 31 + this.H3) * 31 + this.J3.hashCode()) * 31 + this.K3.hashCode()) * 31 + this.L3) * 31 + this.M3) * 31 + this.N3) * 31 + this.O3.hashCode()) * 31 + this.P3.hashCode()) * 31 + this.Q3) * 31 + this.R3) * 31 + this.S3) * 31 + this.T3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.K3);
    paramParcel.writeInt(this.L3);
    paramParcel.writeList(this.P3);
    paramParcel.writeInt(this.Q3);
    o0.N0(paramParcel, this.R3);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.z);
    paramParcel.writeInt(this.p0);
    paramParcel.writeInt(this.p1);
    paramParcel.writeInt(this.p2);
    paramParcel.writeInt(this.p3);
    paramParcel.writeInt(this.H3);
    o0.N0(paramParcel, this.I3);
    paramParcel.writeList(this.J3);
    paramParcel.writeInt(this.M3);
    paramParcel.writeInt(this.N3);
    paramParcel.writeList(this.O3);
    o0.N0(paramParcel, this.S3);
    o0.N0(paramParcel, this.T3);
  }
  
  class a
    implements Parcelable.Creator<TrackSelectionParameters>
  {
    public TrackSelectionParameters a(Parcel paramParcel)
    {
      return new TrackSelectionParameters(paramParcel);
    }
    
    public TrackSelectionParameters[] b(int paramInt)
    {
      return new TrackSelectionParameters[paramInt];
    }
  }
  
  public static class b
  {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private ImmutableList<String> l;
    private ImmutableList<String> m;
    private int n;
    private int o;
    private int p;
    private ImmutableList<String> q;
    private ImmutableList<String> r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    
    @Deprecated
    public b()
    {
      this.a = Integer.MAX_VALUE;
      this.b = Integer.MAX_VALUE;
      this.c = Integer.MAX_VALUE;
      this.d = Integer.MAX_VALUE;
      this.i = Integer.MAX_VALUE;
      this.j = Integer.MAX_VALUE;
      this.k = true;
      this.l = ImmutableList.of();
      this.m = ImmutableList.of();
      this.n = 0;
      this.o = Integer.MAX_VALUE;
      this.p = Integer.MAX_VALUE;
      this.q = ImmutableList.of();
      this.r = ImmutableList.of();
      this.s = 0;
      this.t = false;
      this.u = false;
      this.v = false;
    }
    
    public b(Context paramContext)
    {
      this();
      x(paramContext);
      A(paramContext, true);
    }
    
    protected b(TrackSelectionParameters paramTrackSelectionParameters)
    {
      this.a = paramTrackSelectionParameters.f;
      this.b = paramTrackSelectionParameters.q;
      this.c = paramTrackSelectionParameters.x;
      this.d = paramTrackSelectionParameters.y;
      this.e = paramTrackSelectionParameters.z;
      this.f = paramTrackSelectionParameters.p0;
      this.g = paramTrackSelectionParameters.p1;
      this.h = paramTrackSelectionParameters.p2;
      this.i = paramTrackSelectionParameters.p3;
      this.j = paramTrackSelectionParameters.H3;
      this.k = paramTrackSelectionParameters.I3;
      this.l = paramTrackSelectionParameters.J3;
      this.m = paramTrackSelectionParameters.K3;
      this.n = paramTrackSelectionParameters.L3;
      this.o = paramTrackSelectionParameters.M3;
      this.p = paramTrackSelectionParameters.N3;
      this.q = paramTrackSelectionParameters.O3;
      this.r = paramTrackSelectionParameters.P3;
      this.s = paramTrackSelectionParameters.Q3;
      this.t = paramTrackSelectionParameters.R3;
      this.u = paramTrackSelectionParameters.S3;
      this.v = paramTrackSelectionParameters.T3;
    }
    
    @RequiresApi(19)
    private void y(Context paramContext)
    {
      if ((o0.a < 23) && (Looper.myLooper() == null)) {
        return;
      }
      paramContext = (CaptioningManager)paramContext.getSystemService("captioning");
      if ((paramContext != null) && (paramContext.isEnabled()))
      {
        this.s = 1088;
        paramContext = paramContext.getLocale();
        if (paramContext != null) {
          this.r = ImmutableList.of(o0.Q(paramContext));
        }
      }
    }
    
    public b A(Context paramContext, boolean paramBoolean)
    {
      paramContext = o0.J(paramContext);
      return z(paramContext.x, paramContext.y, paramBoolean);
    }
    
    public TrackSelectionParameters w()
    {
      return new TrackSelectionParameters(this);
    }
    
    public b x(Context paramContext)
    {
      if (o0.a >= 19) {
        y(paramContext);
      }
      return this;
    }
    
    public b z(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.i = paramInt1;
      this.j = paramInt2;
      this.k = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\TrackSelectionParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */