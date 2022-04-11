package com.google.android.exoplayer2.o2.j0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData.Segment;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.d0;
import com.google.common.base.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class m
{
  private static final r a = r.d(':');
  private static final r b = r.d('*');
  private final List<a> c = new ArrayList();
  private int d = 0;
  private int e;
  
  private void a(k paramk, x paramx)
    throws IOException
  {
    d0 locald0 = new d0(8);
    paramk.readFully(locald0.d(), 0, 8);
    this.e = (locald0.q() + 8);
    if (locald0.n() != 1397048916)
    {
      paramx.a = 0L;
      return;
    }
    paramx.a = (paramk.getPosition() - (this.e - 12));
    this.d = 2;
  }
  
  private static int b(String paramString)
    throws ParserException
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1760745220: 
      if (paramString.equals("Super_SlowMotion_BGM")) {
        j = 4;
      }
      break;
    case -830665521: 
      if (paramString.equals("Super_SlowMotion_Deflickering_On")) {
        j = 3;
      }
      break;
    case -1251387154: 
      if (paramString.equals("Super_SlowMotion_Data")) {
        j = 2;
      }
      break;
    case -1332107749: 
      if (paramString.equals("Super_SlowMotion_Edit_Data")) {
        j = 1;
      }
      break;
    case -1711564334: 
      if (paramString.equals("SlowMotion_Data")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      throw ParserException.createForMalformedContainer("Invalid SEF name", null);
    case 4: 
      return 2817;
    case 3: 
      return 2820;
    case 2: 
      return 2816;
    case 1: 
      return 2819;
    }
    return 2192;
  }
  
  private void d(k paramk, x paramx)
    throws IOException
  {
    long l1 = paramk.a();
    int i = this.e - 12 - 8;
    d0 locald0 = new d0(i);
    paramk.readFully(locald0.d(), 0, i);
    for (int j = 0; j < i / 12; j++)
    {
      locald0.Q(2);
      int k = locald0.s();
      if ((k != 2192) && (k != 2816) && (k != 2817) && (k != 2819) && (k != 2820))
      {
        locald0.Q(8);
      }
      else
      {
        long l2 = this.e;
        long l3 = locald0.q();
        int m = locald0.q();
        this.c.add(new a(k, l1 - l2 - l3, m));
      }
    }
    if (this.c.isEmpty())
    {
      paramx.a = 0L;
      return;
    }
    this.d = 3;
    paramx.a = ((a)this.c.get(0)).b;
  }
  
  private void e(k paramk, List<Metadata.Entry> paramList)
    throws IOException
  {
    long l = paramk.getPosition();
    int i = (int)(paramk.a() - paramk.getPosition() - this.e);
    d0 locald0 = new d0(i);
    byte[] arrayOfByte = locald0.d();
    int j = 0;
    paramk.readFully(arrayOfByte, 0, i);
    while (j < this.c.size())
    {
      paramk = (a)this.c.get(j);
      locald0.P((int)(paramk.b - l));
      locald0.Q(4);
      i = locald0.q();
      int k = b(locald0.A(i));
      int m = paramk.c;
      if (k != 2192)
      {
        if ((k != 2816) && (k != 2817) && (k != 2819) && (k != 2820)) {
          throw new IllegalStateException();
        }
      }
      else {
        paramList.add(f(locald0, m - (i + 8)));
      }
      j++;
    }
  }
  
  private static SlowMotionData f(d0 paramd0, int paramInt)
    throws ParserException
  {
    ArrayList localArrayList = new ArrayList();
    paramd0 = paramd0.A(paramInt);
    paramd0 = b.f(paramd0);
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= paramd0.size()) {
        break label151;
      }
      Object localObject = a.f((CharSequence)paramd0.get(paramInt));
      if (((List)localObject).size() == 3) {
        try
        {
          long l1 = Long.parseLong((String)((List)localObject).get(0));
          long l2 = Long.parseLong((String)((List)localObject).get(1));
          int i = Integer.parseInt((String)((List)localObject).get(2));
          localObject = new com/google/android/exoplayer2/metadata/mp4/SlowMotionData$Segment;
          ((SlowMotionData.Segment)localObject).<init>(l1, l2, 1 << i - 1);
          localArrayList.add(localObject);
          paramInt++;
        }
        catch (NumberFormatException paramd0)
        {
          throw ParserException.createForMalformedContainer(null, paramd0);
        }
      }
    }
    throw ParserException.createForMalformedContainer(null, null);
    label151:
    return new SlowMotionData(localArrayList);
  }
  
  public int c(k paramk, x paramx, List<Metadata.Entry> paramList)
    throws IOException
  {
    int i = this.d;
    long l1 = 0L;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            e(paramk, paramList);
            paramx.a = 0L;
          }
          else
          {
            throw new IllegalStateException();
          }
        }
        else {
          d(paramk, paramx);
        }
      }
      else {
        a(paramk, paramx);
      }
    }
    else
    {
      long l2 = paramk.a();
      long l3 = l1;
      if (l2 != -1L) {
        if (l2 < 8L) {
          l3 = l1;
        } else {
          l3 = l2 - 8L;
        }
      }
      paramx.a = l3;
      this.d = 1;
    }
    return 1;
  }
  
  public void g()
  {
    this.c.clear();
    this.d = 0;
  }
  
  private static final class a
  {
    public final int a;
    public final long b;
    public final int c;
    
    public a(int paramInt1, long paramLong, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramLong;
      this.c = paramInt2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */