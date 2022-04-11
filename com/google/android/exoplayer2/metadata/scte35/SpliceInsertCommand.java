package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();
  public final int H3;
  public final int I3;
  public final long c;
  public final boolean d;
  public final boolean f;
  public final List<b> p0;
  public final boolean p1;
  public final long p2;
  public final int p3;
  public final boolean q;
  public final boolean x;
  public final long y;
  public final long z;
  
  private SpliceInsertCommand(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong2, long paramLong3, List<b> paramList, boolean paramBoolean5, long paramLong4, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramLong1;
    this.d = paramBoolean1;
    this.f = paramBoolean2;
    this.q = paramBoolean3;
    this.x = paramBoolean4;
    this.y = paramLong2;
    this.z = paramLong3;
    this.p0 = Collections.unmodifiableList(paramList);
    this.p1 = paramBoolean5;
    this.p2 = paramLong4;
    this.p3 = paramInt1;
    this.H3 = paramInt2;
    this.I3 = paramInt3;
  }
  
  private SpliceInsertCommand(Parcel paramParcel)
  {
    this.c = paramParcel.readLong();
    int i = paramParcel.readByte();
    boolean bool1 = false;
    if (i == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.d = bool2;
    if (paramParcel.readByte() == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.f = bool2;
    if (paramParcel.readByte() == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.q = bool2;
    if (paramParcel.readByte() == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.x = bool2;
    this.y = paramParcel.readLong();
    this.z = paramParcel.readLong();
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    for (i = 0; i < j; i++) {
      localArrayList.add(b.a(paramParcel));
    }
    this.p0 = Collections.unmodifiableList(localArrayList);
    boolean bool2 = bool1;
    if (paramParcel.readByte() == 1) {
      bool2 = true;
    }
    this.p1 = bool2;
    this.p2 = paramParcel.readLong();
    this.p3 = paramParcel.readInt();
    this.H3 = paramParcel.readInt();
    this.I3 = paramParcel.readInt();
  }
  
  static SpliceInsertCommand a(d0 paramd0, long paramLong, l0 paraml0)
  {
    long l1 = paramd0.F();
    boolean bool1;
    if ((paramd0.D() & 0x80) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = Collections.emptyList();
    int i;
    boolean bool2;
    boolean bool3;
    int j;
    boolean bool4;
    long l2;
    int k;
    boolean bool5;
    if (!bool1)
    {
      i = paramd0.D();
      if ((i & 0x80) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((i & 0x40) != 0) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if ((i & 0x20) != 0) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i & 0x10) != 0) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      if ((bool3) && (!bool4)) {
        l2 = TimeSignalCommand.b(paramd0, paramLong);
      } else {
        l2 = -9223372036854775807L;
      }
      if (!bool3)
      {
        k = paramd0.D();
        localObject = new ArrayList(k);
        for (i = 0; i < k; i++)
        {
          int m = paramd0.D();
          long l3;
          if (!bool4) {
            l3 = TimeSignalCommand.b(paramd0, paramLong);
          } else {
            l3 = -9223372036854775807L;
          }
          ((List)localObject).add(new b(m, l3, paraml0.b(l3), null));
        }
      }
      if (j != 0)
      {
        paramLong = paramd0.D();
        if ((0x80 & paramLong) != 0L) {
          bool5 = true;
        } else {
          bool5 = false;
        }
        paramLong = ((paramLong & 1L) << 32 | paramd0.F()) * 1000L / 90L;
      }
      else
      {
        bool5 = false;
        paramLong = -9223372036854775807L;
      }
      k = paramd0.J();
      j = paramd0.D();
      i = paramd0.D();
    }
    else
    {
      bool2 = false;
      bool4 = false;
      l2 = -9223372036854775807L;
      bool5 = false;
      paramLong = -9223372036854775807L;
      k = 0;
      j = 0;
      i = 0;
      bool3 = false;
    }
    return new SpliceInsertCommand(l1, bool1, bool2, bool3, bool4, l2, paraml0.b(l2), (List)localObject, bool5, paramLong, k, j, i);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.q);
    paramParcel.writeByte((byte)this.x);
    paramParcel.writeLong(this.y);
    paramParcel.writeLong(this.z);
    int i = this.p0.size();
    paramParcel.writeInt(i);
    for (paramInt = 0; paramInt < i; paramInt++) {
      ((b)this.p0.get(paramInt)).b(paramParcel);
    }
    paramParcel.writeByte((byte)this.p1);
    paramParcel.writeLong(this.p2);
    paramParcel.writeInt(this.p3);
    paramParcel.writeInt(this.H3);
    paramParcel.writeInt(this.I3);
  }
  
  class a
    implements Parcelable.Creator<SpliceInsertCommand>
  {
    public SpliceInsertCommand a(Parcel paramParcel)
    {
      return new SpliceInsertCommand(paramParcel, null);
    }
    
    public SpliceInsertCommand[] b(int paramInt)
    {
      return new SpliceInsertCommand[paramInt];
    }
  }
  
  public static final class b
  {
    public final int a;
    public final long b;
    public final long c;
    
    private b(int paramInt, long paramLong1, long paramLong2)
    {
      this.a = paramInt;
      this.b = paramLong1;
      this.c = paramLong2;
    }
    
    public static b a(Parcel paramParcel)
    {
      return new b(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong());
    }
    
    public void b(Parcel paramParcel)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeLong(this.b);
      paramParcel.writeLong(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\scte35\SpliceInsertCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */