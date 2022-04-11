package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d0;
import com.google.android.exoplayer2.drm.j0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format
  implements Parcelable
{
  public static final Parcelable.Creator<Format> CREATOR = new a();
  @Nullable
  public final String H3;
  public final int I3;
  public final List<byte[]> J3;
  @Nullable
  public final DrmInitData K3;
  public final long L3;
  public final int M3;
  public final int N3;
  public final float O3;
  public final int P3;
  public final float Q3;
  @Nullable
  public final byte[] R3;
  public final int S3;
  @Nullable
  public final ColorInfo T3;
  public final int U3;
  public final int V3;
  public final int W3;
  public final int X3;
  public final int Y3;
  public final int Z3;
  @Nullable
  public final Class<? extends d0> a4;
  private int b4;
  @Nullable
  public final String c;
  @Nullable
  public final String d;
  @Nullable
  public final String f;
  public final int p0;
  @Nullable
  public final String p1;
  @Nullable
  public final Metadata p2;
  @Nullable
  public final String p3;
  public final int q;
  public final int x;
  public final int y;
  public final int z;
  
  Format(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.f = paramParcel.readString();
    this.q = paramParcel.readInt();
    this.x = paramParcel.readInt();
    int i = paramParcel.readInt();
    this.y = i;
    int j = paramParcel.readInt();
    this.z = j;
    if (j != -1) {
      i = j;
    }
    this.p0 = i;
    this.p1 = paramParcel.readString();
    this.p2 = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
    this.p3 = paramParcel.readString();
    this.H3 = paramParcel.readString();
    this.I3 = paramParcel.readInt();
    j = paramParcel.readInt();
    this.J3 = new ArrayList(j);
    for (i = 0; i < j; i++) {
      this.J3.add((byte[])g.e(paramParcel.createByteArray()));
    }
    DrmInitData localDrmInitData = (DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader());
    this.K3 = localDrmInitData;
    this.L3 = paramParcel.readLong();
    this.M3 = paramParcel.readInt();
    this.N3 = paramParcel.readInt();
    this.O3 = paramParcel.readFloat();
    this.P3 = paramParcel.readInt();
    this.Q3 = paramParcel.readFloat();
    boolean bool = o0.A0(paramParcel);
    Object localObject = null;
    byte[] arrayOfByte;
    if (bool) {
      arrayOfByte = paramParcel.createByteArray();
    } else {
      arrayOfByte = null;
    }
    this.R3 = arrayOfByte;
    this.S3 = paramParcel.readInt();
    this.T3 = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
    this.U3 = paramParcel.readInt();
    this.V3 = paramParcel.readInt();
    this.W3 = paramParcel.readInt();
    this.X3 = paramParcel.readInt();
    this.Y3 = paramParcel.readInt();
    this.Z3 = paramParcel.readInt();
    paramParcel = (Parcel)localObject;
    if (localDrmInitData != null) {
      paramParcel = j0.class;
    }
    this.a4 = paramParcel;
  }
  
  private Format(b paramb)
  {
    this.c = b.a(paramb);
    this.d = b.l(paramb);
    this.f = o0.t0(b.w(paramb));
    this.q = b.y(paramb);
    this.x = b.z(paramb);
    int i = b.A(paramb);
    this.y = i;
    int j = b.B(paramb);
    this.z = j;
    if (j != -1) {
      i = j;
    }
    this.p0 = i;
    this.p1 = b.C(paramb);
    this.p2 = b.D(paramb);
    this.p3 = b.b(paramb);
    this.H3 = b.c(paramb);
    this.I3 = b.d(paramb);
    if (b.e(paramb) == null) {
      localObject = Collections.emptyList();
    } else {
      localObject = b.e(paramb);
    }
    this.J3 = ((List)localObject);
    Object localObject = b.f(paramb);
    this.K3 = ((DrmInitData)localObject);
    this.L3 = b.g(paramb);
    this.M3 = b.h(paramb);
    this.N3 = b.i(paramb);
    this.O3 = b.j(paramb);
    i = b.k(paramb);
    j = 0;
    if (i == -1) {
      i = 0;
    } else {
      i = b.k(paramb);
    }
    this.P3 = i;
    float f1;
    if (b.m(paramb) == -1.0F) {
      f1 = 1.0F;
    } else {
      f1 = b.m(paramb);
    }
    this.Q3 = f1;
    this.R3 = b.n(paramb);
    this.S3 = b.o(paramb);
    this.T3 = b.p(paramb);
    this.U3 = b.q(paramb);
    this.V3 = b.r(paramb);
    this.W3 = b.s(paramb);
    if (b.t(paramb) == -1) {
      i = 0;
    } else {
      i = b.t(paramb);
    }
    this.X3 = i;
    if (b.u(paramb) == -1) {
      i = j;
    } else {
      i = b.u(paramb);
    }
    this.Y3 = i;
    this.Z3 = b.v(paramb);
    if ((b.x(paramb) == null) && (localObject != null)) {
      this.a4 = j0.class;
    } else {
      this.a4 = b.x(paramb);
    }
  }
  
  public b a()
  {
    return new b(this, null);
  }
  
  public Format b(@Nullable Class<? extends d0> paramClass)
  {
    return a().O(paramClass).E();
  }
  
  public int c()
  {
    int i = this.M3;
    int j = -1;
    int k = j;
    if (i != -1)
    {
      k = this.N3;
      if (k == -1) {
        k = j;
      } else {
        k = i * k;
      }
    }
    return k;
  }
  
  public boolean d(Format paramFormat)
  {
    if (this.J3.size() != paramFormat.J3.size()) {
      return false;
    }
    for (int i = 0; i < this.J3.size(); i++) {
      if (!Arrays.equals((byte[])this.J3.get(i), (byte[])paramFormat.J3.get(i))) {
        return false;
      }
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Format e(Format paramFormat)
  {
    if (this == paramFormat) {
      return this;
    }
    int i = y.k(this.H3);
    String str1 = paramFormat.c;
    String str2 = paramFormat.d;
    if (str2 == null) {
      str2 = this.d;
    }
    Object localObject1 = this.f;
    Object localObject2;
    if (i != 3)
    {
      localObject2 = localObject1;
      if (i != 1) {}
    }
    else
    {
      localObject3 = paramFormat.f;
      localObject2 = localObject1;
      if (localObject3 != null) {
        localObject2 = localObject3;
      }
    }
    int j = this.y;
    int k = j;
    if (j == -1) {
      k = paramFormat.y;
    }
    int m = this.z;
    j = m;
    if (m == -1) {
      j = paramFormat.z;
    }
    String str3 = this.p1;
    Object localObject3 = str3;
    if (str3 == null)
    {
      localObject1 = o0.G(paramFormat.p1, i);
      localObject3 = str3;
      if (o0.G0((String)localObject1).length == 1) {
        localObject3 = localObject1;
      }
    }
    localObject1 = this.p2;
    if (localObject1 == null) {
      localObject1 = paramFormat.p2;
    } else {
      localObject1 = ((Metadata)localObject1).b(paramFormat.p2);
    }
    float f1 = this.O3;
    float f2 = f1;
    if (f1 == -1.0F)
    {
      f2 = f1;
      if (i == 2) {
        f2 = paramFormat.O3;
      }
    }
    i = this.q;
    int n = paramFormat.q;
    int i1 = this.x;
    m = paramFormat.x;
    paramFormat = DrmInitData.d(paramFormat.K3, this.K3);
    return a().S(str1).U(str2).V((String)localObject2).g0(i | n).c0(i1 | m).G(k).Z(j).I((String)localObject3).X((Metadata)localObject1).L(paramFormat).P(f2).E();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Format.class == paramObject.getClass()))
    {
      paramObject = (Format)paramObject;
      int i = this.b4;
      if (i != 0)
      {
        int j = ((Format)paramObject).b4;
        if ((j != 0) && (i != j)) {
          return false;
        }
      }
      if ((this.q != ((Format)paramObject).q) || (this.x != ((Format)paramObject).x) || (this.y != ((Format)paramObject).y) || (this.z != ((Format)paramObject).z) || (this.I3 != ((Format)paramObject).I3) || (this.L3 != ((Format)paramObject).L3) || (this.M3 != ((Format)paramObject).M3) || (this.N3 != ((Format)paramObject).N3) || (this.P3 != ((Format)paramObject).P3) || (this.S3 != ((Format)paramObject).S3) || (this.U3 != ((Format)paramObject).U3) || (this.V3 != ((Format)paramObject).V3) || (this.W3 != ((Format)paramObject).W3) || (this.X3 != ((Format)paramObject).X3) || (this.Y3 != ((Format)paramObject).Y3) || (this.Z3 != ((Format)paramObject).Z3) || (Float.compare(this.O3, ((Format)paramObject).O3) != 0) || (Float.compare(this.Q3, ((Format)paramObject).Q3) != 0) || (!o0.b(this.a4, ((Format)paramObject).a4)) || (!o0.b(this.c, ((Format)paramObject).c)) || (!o0.b(this.d, ((Format)paramObject).d)) || (!o0.b(this.p1, ((Format)paramObject).p1)) || (!o0.b(this.p3, ((Format)paramObject).p3)) || (!o0.b(this.H3, ((Format)paramObject).H3)) || (!o0.b(this.f, ((Format)paramObject).f)) || (!Arrays.equals(this.R3, ((Format)paramObject).R3)) || (!o0.b(this.p2, ((Format)paramObject).p2)) || (!o0.b(this.T3, ((Format)paramObject).T3)) || (!o0.b(this.K3, ((Format)paramObject).K3)) || (!d((Format)paramObject))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.b4 == 0)
    {
      Object localObject = this.c;
      int i = 0;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = ((String)localObject).hashCode();
      }
      localObject = this.d;
      int k;
      if (localObject != null) {
        k = ((String)localObject).hashCode();
      } else {
        k = 0;
      }
      localObject = this.f;
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = ((String)localObject).hashCode();
      }
      int n = this.q;
      int i1 = this.x;
      int i2 = this.y;
      int i3 = this.z;
      localObject = this.p1;
      int i4;
      if (localObject == null) {
        i4 = 0;
      } else {
        i4 = ((String)localObject).hashCode();
      }
      localObject = this.p2;
      int i5;
      if (localObject == null) {
        i5 = 0;
      } else {
        i5 = ((Metadata)localObject).hashCode();
      }
      localObject = this.p3;
      int i6;
      if (localObject == null) {
        i6 = 0;
      } else {
        i6 = ((String)localObject).hashCode();
      }
      localObject = this.H3;
      int i7;
      if (localObject == null) {
        i7 = 0;
      } else {
        i7 = ((String)localObject).hashCode();
      }
      int i8 = this.I3;
      int i9 = (int)this.L3;
      int i10 = this.M3;
      int i11 = this.N3;
      int i12 = Float.floatToIntBits(this.O3);
      int i13 = this.P3;
      int i14 = Float.floatToIntBits(this.Q3);
      int i15 = this.S3;
      int i16 = this.U3;
      int i17 = this.V3;
      int i18 = this.W3;
      int i19 = this.X3;
      int i20 = this.Y3;
      int i21 = this.Z3;
      localObject = this.a4;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      this.b4 = ((((((((((((((((((((((((((527 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i);
    }
    return this.b4;
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.d;
    String str3 = this.p3;
    String str4 = this.H3;
    String str5 = this.p1;
    int i = this.p0;
    String str6 = this.f;
    int j = this.M3;
    int k = this.N3;
    float f1 = this.O3;
    int m = this.U3;
    int n = this.V3;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 104 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length());
    localStringBuilder.append("Format(");
    localStringBuilder.append(str1);
    localStringBuilder.append(", ");
    localStringBuilder.append(str2);
    localStringBuilder.append(", ");
    localStringBuilder.append(str3);
    localStringBuilder.append(", ");
    localStringBuilder.append(str4);
    localStringBuilder.append(", ");
    localStringBuilder.append(str5);
    localStringBuilder.append(", ");
    localStringBuilder.append(i);
    localStringBuilder.append(", ");
    localStringBuilder.append(str6);
    localStringBuilder.append(", [");
    localStringBuilder.append(j);
    localStringBuilder.append(", ");
    localStringBuilder.append(k);
    localStringBuilder.append(", ");
    localStringBuilder.append(f1);
    localStringBuilder.append("], [");
    localStringBuilder.append(m);
    localStringBuilder.append(", ");
    localStringBuilder.append(n);
    localStringBuilder.append("])");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.z);
    paramParcel.writeString(this.p1);
    Object localObject = this.p2;
    boolean bool = false;
    paramParcel.writeParcelable((Parcelable)localObject, 0);
    paramParcel.writeString(this.p3);
    paramParcel.writeString(this.H3);
    paramParcel.writeInt(this.I3);
    int i = this.J3.size();
    paramParcel.writeInt(i);
    for (int j = 0; j < i; j++) {
      paramParcel.writeByteArray((byte[])this.J3.get(j));
    }
    paramParcel.writeParcelable(this.K3, 0);
    paramParcel.writeLong(this.L3);
    paramParcel.writeInt(this.M3);
    paramParcel.writeInt(this.N3);
    paramParcel.writeFloat(this.O3);
    paramParcel.writeInt(this.P3);
    paramParcel.writeFloat(this.Q3);
    if (this.R3 != null) {
      bool = true;
    }
    o0.N0(paramParcel, bool);
    localObject = this.R3;
    if (localObject != null) {
      paramParcel.writeByteArray((byte[])localObject);
    }
    paramParcel.writeInt(this.S3);
    paramParcel.writeParcelable(this.T3, paramInt);
    paramParcel.writeInt(this.U3);
    paramParcel.writeInt(this.V3);
    paramParcel.writeInt(this.W3);
    paramParcel.writeInt(this.X3);
    paramParcel.writeInt(this.Y3);
    paramParcel.writeInt(this.Z3);
  }
  
  class a
    implements Parcelable.Creator<Format>
  {
    public Format a(Parcel paramParcel)
    {
      return new Format(paramParcel);
    }
    
    public Format[] b(int paramInt)
    {
      return new Format[paramInt];
    }
  }
  
  public static final class b
  {
    private int A;
    private int B;
    private int C;
    @Nullable
    private Class<? extends d0> D;
    @Nullable
    private String a;
    @Nullable
    private String b;
    @Nullable
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    @Nullable
    private String h;
    @Nullable
    private Metadata i;
    @Nullable
    private String j;
    @Nullable
    private String k;
    private int l;
    @Nullable
    private List<byte[]> m;
    @Nullable
    private DrmInitData n;
    private long o;
    private int p;
    private int q;
    private float r;
    private int s;
    private float t;
    @Nullable
    private byte[] u;
    private int v;
    @Nullable
    private ColorInfo w;
    private int x;
    private int y;
    private int z;
    
    public b()
    {
      this.f = -1;
      this.g = -1;
      this.l = -1;
      this.o = Long.MAX_VALUE;
      this.p = -1;
      this.q = -1;
      this.r = -1.0F;
      this.t = 1.0F;
      this.v = -1;
      this.x = -1;
      this.y = -1;
      this.z = -1;
      this.C = -1;
    }
    
    private b(Format paramFormat)
    {
      this.a = paramFormat.c;
      this.b = paramFormat.d;
      this.c = paramFormat.f;
      this.d = paramFormat.q;
      this.e = paramFormat.x;
      this.f = paramFormat.y;
      this.g = paramFormat.z;
      this.h = paramFormat.p1;
      this.i = paramFormat.p2;
      this.j = paramFormat.p3;
      this.k = paramFormat.H3;
      this.l = paramFormat.I3;
      this.m = paramFormat.J3;
      this.n = paramFormat.K3;
      this.o = paramFormat.L3;
      this.p = paramFormat.M3;
      this.q = paramFormat.N3;
      this.r = paramFormat.O3;
      this.s = paramFormat.P3;
      this.t = paramFormat.Q3;
      this.u = paramFormat.R3;
      this.v = paramFormat.S3;
      this.w = paramFormat.T3;
      this.x = paramFormat.U3;
      this.y = paramFormat.V3;
      this.z = paramFormat.W3;
      this.A = paramFormat.X3;
      this.B = paramFormat.Y3;
      this.C = paramFormat.Z3;
      this.D = paramFormat.a4;
    }
    
    public Format E()
    {
      return new Format(this, null);
    }
    
    public b F(int paramInt)
    {
      this.C = paramInt;
      return this;
    }
    
    public b G(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
    
    public b H(int paramInt)
    {
      this.x = paramInt;
      return this;
    }
    
    public b I(@Nullable String paramString)
    {
      this.h = paramString;
      return this;
    }
    
    public b J(@Nullable ColorInfo paramColorInfo)
    {
      this.w = paramColorInfo;
      return this;
    }
    
    public b K(@Nullable String paramString)
    {
      this.j = paramString;
      return this;
    }
    
    public b L(@Nullable DrmInitData paramDrmInitData)
    {
      this.n = paramDrmInitData;
      return this;
    }
    
    public b M(int paramInt)
    {
      this.A = paramInt;
      return this;
    }
    
    public b N(int paramInt)
    {
      this.B = paramInt;
      return this;
    }
    
    public b O(@Nullable Class<? extends d0> paramClass)
    {
      this.D = paramClass;
      return this;
    }
    
    public b P(float paramFloat)
    {
      this.r = paramFloat;
      return this;
    }
    
    public b Q(int paramInt)
    {
      this.q = paramInt;
      return this;
    }
    
    public b R(int paramInt)
    {
      this.a = Integer.toString(paramInt);
      return this;
    }
    
    public b S(@Nullable String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public b T(@Nullable List<byte[]> paramList)
    {
      this.m = paramList;
      return this;
    }
    
    public b U(@Nullable String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public b V(@Nullable String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public b W(int paramInt)
    {
      this.l = paramInt;
      return this;
    }
    
    public b X(@Nullable Metadata paramMetadata)
    {
      this.i = paramMetadata;
      return this;
    }
    
    public b Y(int paramInt)
    {
      this.z = paramInt;
      return this;
    }
    
    public b Z(int paramInt)
    {
      this.g = paramInt;
      return this;
    }
    
    public b a0(float paramFloat)
    {
      this.t = paramFloat;
      return this;
    }
    
    public b b0(@Nullable byte[] paramArrayOfByte)
    {
      this.u = paramArrayOfByte;
      return this;
    }
    
    public b c0(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    public b d0(int paramInt)
    {
      this.s = paramInt;
      return this;
    }
    
    public b e0(@Nullable String paramString)
    {
      this.k = paramString;
      return this;
    }
    
    public b f0(int paramInt)
    {
      this.y = paramInt;
      return this;
    }
    
    public b g0(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    public b h0(int paramInt)
    {
      this.v = paramInt;
      return this;
    }
    
    public b i0(long paramLong)
    {
      this.o = paramLong;
      return this;
    }
    
    public b j0(int paramInt)
    {
      this.p = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\Format.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */