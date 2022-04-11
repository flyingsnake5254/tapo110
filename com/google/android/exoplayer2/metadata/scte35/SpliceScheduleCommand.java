package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();
  public final List<c> c;
  
  private SpliceScheduleCommand(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add(c.a(paramParcel));
    }
    this.c = Collections.unmodifiableList(localArrayList);
  }
  
  private SpliceScheduleCommand(List<c> paramList)
  {
    this.c = Collections.unmodifiableList(paramList);
  }
  
  static SpliceScheduleCommand a(d0 paramd0)
  {
    int i = paramd0.D();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add(c.b(paramd0));
    }
    return new SpliceScheduleCommand(localArrayList);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.c.size();
    paramParcel.writeInt(i);
    for (paramInt = 0; paramInt < i; paramInt++) {
      c.c((c)this.c.get(paramInt), paramParcel);
    }
  }
  
  class a
    implements Parcelable.Creator<SpliceScheduleCommand>
  {
    public SpliceScheduleCommand a(Parcel paramParcel)
    {
      return new SpliceScheduleCommand(paramParcel, null);
    }
    
    public SpliceScheduleCommand[] b(int paramInt)
    {
      return new SpliceScheduleCommand[paramInt];
    }
  }
  
  public static final class b
  {
    public final int a;
    public final long b;
    
    private b(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }
    
    private static b c(Parcel paramParcel)
    {
      return new b(paramParcel.readInt(), paramParcel.readLong());
    }
    
    private void d(Parcel paramParcel)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeLong(this.b);
    }
  }
  
  public static final class c
  {
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final long e;
    public final List<SpliceScheduleCommand.b> f;
    public final boolean g;
    public final long h;
    public final int i;
    public final int j;
    public final int k;
    
    private c(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<SpliceScheduleCommand.b> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramLong1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      this.f = Collections.unmodifiableList(paramList);
      this.e = paramLong2;
      this.g = paramBoolean4;
      this.h = paramLong3;
      this.i = paramInt1;
      this.j = paramInt2;
      this.k = paramInt3;
    }
    
    private c(Parcel paramParcel)
    {
      this.a = paramParcel.readLong();
      int m = paramParcel.readByte();
      boolean bool1 = false;
      if (m == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.b = bool2;
      if (paramParcel.readByte() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.c = bool2;
      if (paramParcel.readByte() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.d = bool2;
      int n = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(n);
      for (m = 0; m < n; m++) {
        localArrayList.add(SpliceScheduleCommand.b.a(paramParcel));
      }
      this.f = Collections.unmodifiableList(localArrayList);
      this.e = paramParcel.readLong();
      boolean bool2 = bool1;
      if (paramParcel.readByte() == 1) {
        bool2 = true;
      }
      this.g = bool2;
      this.h = paramParcel.readLong();
      this.i = paramParcel.readInt();
      this.j = paramParcel.readInt();
      this.k = paramParcel.readInt();
    }
    
    private static c d(Parcel paramParcel)
    {
      return new c(paramParcel);
    }
    
    private static c e(d0 paramd0)
    {
      long l1 = paramd0.F();
      boolean bool1;
      if ((paramd0.D() & 0x80) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ArrayList localArrayList = new ArrayList();
      int m;
      boolean bool2;
      boolean bool3;
      long l2;
      int n;
      int i1;
      long l3;
      boolean bool5;
      if (!bool1)
      {
        m = paramd0.D();
        if ((m & 0x80) != 0) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if ((m & 0x40) != 0) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        if ((m & 0x20) != 0) {
          m = 1;
        } else {
          m = 0;
        }
        if (bool3) {
          l2 = paramd0.F();
        } else {
          l2 = -9223372036854775807L;
        }
        if (!bool3)
        {
          n = paramd0.D();
          localArrayList = new ArrayList(n);
          for (i1 = 0; i1 < n; i1++) {
            localArrayList.add(new SpliceScheduleCommand.b(paramd0.D(), paramd0.F(), null));
          }
        }
        boolean bool4;
        if (m != 0)
        {
          l3 = paramd0.D();
          if ((0x80 & l3) != 0L) {
            bool4 = true;
          } else {
            bool4 = false;
          }
          l3 = ((l3 & 1L) << 32 | paramd0.F()) * 1000L / 90L;
        }
        else
        {
          bool4 = false;
          l3 = -9223372036854775807L;
        }
        n = paramd0.J();
        i1 = paramd0.D();
        m = paramd0.D();
        paramd0 = localArrayList;
        bool5 = bool2;
        bool2 = bool4;
      }
      else
      {
        paramd0 = localArrayList;
        bool5 = false;
        l2 = -9223372036854775807L;
        bool2 = false;
        l3 = -9223372036854775807L;
        n = 0;
        i1 = 0;
        m = 0;
        bool3 = false;
      }
      return new c(l1, bool1, bool5, bool3, paramd0, l2, bool2, l3, n, i1, m);
    }
    
    private void f(Parcel paramParcel)
    {
      paramParcel.writeLong(this.a);
      paramParcel.writeByte((byte)this.b);
      paramParcel.writeByte((byte)this.c);
      paramParcel.writeByte((byte)this.d);
      int m = this.f.size();
      paramParcel.writeInt(m);
      for (int n = 0; n < m; n++) {
        SpliceScheduleCommand.b.b((SpliceScheduleCommand.b)this.f.get(n), paramParcel);
      }
      paramParcel.writeLong(this.e);
      paramParcel.writeByte((byte)this.g);
      paramParcel.writeLong(this.h);
      paramParcel.writeInt(this.i);
      paramParcel.writeInt(this.j);
      paramParcel.writeInt(this.k);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\scte35\SpliceScheduleCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */