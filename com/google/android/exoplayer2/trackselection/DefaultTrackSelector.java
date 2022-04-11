package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.a2;
import com.google.common.collect.c0;
import com.google.common.primitives.d;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector
  extends i
{
  private static final int[] d = new int[0];
  private static final a2<Integer> e = a2.a(c.c);
  private static final a2<Integer> f = a2.a(b.c);
  private final g.b g;
  private final AtomicReference<Parameters> h;
  
  @Deprecated
  public DefaultTrackSelector()
  {
    this(Parameters.U3, new d.b());
  }
  
  public DefaultTrackSelector(Context paramContext)
  {
    this(paramContext, new d.b());
  }
  
  public DefaultTrackSelector(Context paramContext, g.b paramb)
  {
    this(Parameters.h(paramContext), paramb);
  }
  
  public DefaultTrackSelector(Parameters paramParameters, g.b paramb)
  {
    this.g = paramb;
    this.h = new AtomicReference(paramParameters);
  }
  
  @Nullable
  protected static String A(@Nullable String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!TextUtils.equals(paramString, "und")) {}
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  private static boolean B(int[][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray, g paramg)
  {
    if (paramg == null) {
      return false;
    }
    int i = paramTrackGroupArray.b(paramg.m());
    for (int j = 0; j < paramg.length(); j++) {
      if (c2.e(paramArrayOfInt[i][paramg.h(j)]) != 32) {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  private static g.a C(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, int paramInt, Parameters paramParameters)
  {
    Object localObject1 = paramParameters;
    int i;
    if (((Parameters)localObject1).Z3) {
      i = 24;
    } else {
      i = 16;
    }
    boolean bool;
    if ((((Parameters)localObject1).Y3) && ((paramInt & i) != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    for (paramInt = 0;; paramInt++)
    {
      localObject1 = paramParameters;
      Object localObject2 = paramTrackGroupArray;
      if (paramInt >= ((TrackGroupArray)localObject2).d) {
        break;
      }
      localObject2 = ((TrackGroupArray)localObject2).a(paramInt);
      localObject1 = p((TrackGroup)localObject2, paramArrayOfInt[paramInt], bool, i, ((TrackSelectionParameters)localObject1).f, ((TrackSelectionParameters)localObject1).q, ((TrackSelectionParameters)localObject1).x, ((TrackSelectionParameters)localObject1).y, ((TrackSelectionParameters)localObject1).z, ((TrackSelectionParameters)localObject1).p0, ((TrackSelectionParameters)localObject1).p1, ((TrackSelectionParameters)localObject1).p2, ((TrackSelectionParameters)localObject1).p3, ((TrackSelectionParameters)localObject1).H3, ((TrackSelectionParameters)localObject1).I3);
      if (localObject1.length > 0) {
        return new g.a((TrackGroup)localObject2, (int[])localObject1);
      }
    }
    return null;
  }
  
  @Nullable
  private static g.a F(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, Parameters paramParameters)
  {
    Object localObject1 = null;
    int i = -1;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    for (int j = 0; j < paramTrackGroupArray.d; j++)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.a(j);
      List localList = t(localTrackGroup, paramParameters.p3, paramParameters.H3, paramParameters.I3);
      int[] arrayOfInt = paramArrayOfInt[j];
      int k = 0;
      while (k < localTrackGroup.c)
      {
        Object localObject4 = localTrackGroup.a(k);
        int m;
        Object localObject5;
        Object localObject6;
        if ((((Format)localObject4).x & 0x4000) != 0)
        {
          m = i;
          localObject5 = localObject2;
          localObject6 = localObject3;
        }
        else
        {
          m = i;
          localObject5 = localObject2;
          localObject6 = localObject3;
          if (u(arrayOfInt[k], paramParameters.e4))
          {
            localObject4 = new f((Format)localObject4, paramParameters, arrayOfInt[k], localList.contains(Integer.valueOf(k)));
            if ((!((f)localObject4).c) && (!paramParameters.X3))
            {
              m = i;
              localObject5 = localObject2;
              localObject6 = localObject3;
            }
            else if (localObject3 != null)
            {
              m = i;
              localObject5 = localObject2;
              localObject6 = localObject3;
              if (((f)localObject4).a((f)localObject3) <= 0) {}
            }
            else
            {
              localObject5 = localTrackGroup;
              m = k;
              localObject6 = localObject4;
            }
          }
        }
        k++;
        i = m;
        localObject2 = localObject5;
        localObject3 = localObject6;
      }
    }
    if (localObject2 == null) {
      paramTrackGroupArray = (TrackGroupArray)localObject1;
    } else {
      paramTrackGroupArray = new g.a((TrackGroup)localObject2, new int[] { i });
    }
    return paramTrackGroupArray;
  }
  
  private static void m(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, List<Integer> paramList)
  {
    for (int i = paramList.size() - 1; i >= 0; i--)
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (!w(paramTrackGroup.a(j), paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9)) {
        paramList.remove(i);
      }
    }
  }
  
  private static int[] n(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Format localFormat = paramTrackGroup.a(paramInt1);
    int[] arrayOfInt = new int[paramTrackGroup.c];
    int i = 0;
    int k;
    for (int j = 0; i < paramTrackGroup.c; j = k)
    {
      if (i != paramInt1)
      {
        k = j;
        if (!v(paramTrackGroup.a(i), paramArrayOfInt[i], localFormat, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3)) {}
      }
      else
      {
        arrayOfInt[j] = i;
        k = j + 1;
      }
      i++;
    }
    return Arrays.copyOf(arrayOfInt, j);
  }
  
  private static int o(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, List<Integer> paramList)
  {
    int i = 0;
    int m;
    for (int j = 0; i < paramList.size(); j = m)
    {
      int k = ((Integer)paramList.get(i)).intValue();
      m = j;
      if (w(paramTrackGroup.a(k), paramString, paramArrayOfInt[k], paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9)) {
        m = j + 1;
      }
      i++;
    }
    return j;
  }
  
  private static int[] p(TrackGroup paramTrackGroup, int[] paramArrayOfInt, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, boolean paramBoolean2)
  {
    if (paramTrackGroup.c < 2) {
      return d;
    }
    List localList = t(paramTrackGroup, paramInt10, paramInt11, paramBoolean2);
    if (localList.size() < 2) {
      return d;
    }
    Object localObject;
    if (!paramBoolean1)
    {
      HashSet localHashSet = new HashSet();
      localObject = null;
      paramInt10 = 0;
      for (paramInt11 = 0; paramInt11 < localList.size(); paramInt11++)
      {
        String str = paramTrackGroup.a(((Integer)localList.get(paramInt11)).intValue()).H3;
        if (localHashSet.add(str))
        {
          int i = o(paramTrackGroup, paramArrayOfInt, paramInt1, str, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, localList);
          if (i > paramInt10)
          {
            paramInt10 = i;
            localObject = str;
          }
        }
      }
    }
    else
    {
      localObject = null;
    }
    m(paramTrackGroup, paramArrayOfInt, paramInt1, (String)localObject, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, localList);
    if (localList.size() < 2) {
      paramTrackGroup = d;
    } else {
      paramTrackGroup = d.j(localList);
    }
    return paramTrackGroup;
  }
  
  protected static int q(Format paramFormat, @Nullable String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramFormat.f))) {
      return 4;
    }
    paramString = A(paramString);
    paramFormat = A(paramFormat.f);
    int i = 0;
    if ((paramFormat != null) && (paramString != null))
    {
      if ((!paramFormat.startsWith(paramString)) && (!paramString.startsWith(paramFormat)))
      {
        if (o0.F0(paramFormat, "-")[0].equals(o0.F0(paramString, "-")[0])) {
          return 2;
        }
        return 0;
      }
      return 3;
    }
    int j = i;
    if (paramBoolean)
    {
      j = i;
      if (paramFormat == null) {
        j = 1;
      }
    }
    return j;
  }
  
  private static Point r(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      i = 1;
      if (paramInt3 > paramInt4) {
        j = 1;
      } else {
        j = 0;
      }
      if (paramInt1 <= paramInt2) {
        i = 0;
      }
      if (j != i) {}
    }
    else
    {
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    int i = paramInt3 * paramInt1;
    int j = paramInt4 * paramInt2;
    if (i >= j) {
      return new Point(paramInt2, o0.k(j, paramInt3));
    }
    return new Point(o0.k(i, paramInt4), paramInt1);
  }
  
  private static List<Integer> t(TrackGroup paramTrackGroup, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramTrackGroup.c);
    int i = 0;
    for (int j = 0; j < paramTrackGroup.c; j++) {
      localArrayList.add(Integer.valueOf(j));
    }
    if ((paramInt1 != Integer.MAX_VALUE) && (paramInt2 != Integer.MAX_VALUE))
    {
      int m;
      for (j = Integer.MAX_VALUE; i < paramTrackGroup.c; j = m)
      {
        Format localFormat = paramTrackGroup.a(i);
        int k = localFormat.M3;
        m = j;
        if (k > 0)
        {
          int n = localFormat.N3;
          m = j;
          if (n > 0)
          {
            Point localPoint = r(paramBoolean, paramInt1, paramInt2, k, n);
            int i1 = localFormat.M3;
            n = localFormat.N3;
            k = i1 * n;
            m = j;
            if (i1 >= (int)(localPoint.x * 0.98F))
            {
              m = j;
              if (n >= (int)(localPoint.y * 0.98F))
              {
                m = j;
                if (k < j) {
                  m = k;
                }
              }
            }
          }
        }
        i++;
      }
      if (j != Integer.MAX_VALUE) {
        for (paramInt1 = localArrayList.size() - 1; paramInt1 >= 0; paramInt1--)
        {
          paramInt2 = paramTrackGroup.a(((Integer)localArrayList.get(paramInt1)).intValue()).c();
          if ((paramInt2 == -1) || (paramInt2 > j)) {
            localArrayList.remove(paramInt1);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected static boolean u(int paramInt, boolean paramBoolean)
  {
    paramInt = c2.d(paramInt);
    if ((paramInt != 4) && ((!paramBoolean) || (paramInt != 3))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static boolean v(Format paramFormat1, int paramInt1, Format paramFormat2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (u(paramInt1, false))
    {
      paramInt1 = paramFormat1.p0;
      bool2 = bool1;
      if (paramInt1 != -1)
      {
        bool2 = bool1;
        if (paramInt1 <= paramInt2) {
          if (!paramBoolean3)
          {
            paramInt1 = paramFormat1.U3;
            bool2 = bool1;
            if (paramInt1 != -1)
            {
              bool2 = bool1;
              if (paramInt1 != paramFormat2.U3) {}
            }
          }
          else if (!paramBoolean1)
          {
            String str = paramFormat1.H3;
            bool2 = bool1;
            if (str != null)
            {
              bool2 = bool1;
              if (!TextUtils.equals(str, paramFormat2.H3)) {}
            }
          }
          else if (!paramBoolean2)
          {
            paramInt1 = paramFormat1.V3;
            bool2 = bool1;
            if (paramInt1 != -1)
            {
              bool2 = bool1;
              if (paramInt1 != paramFormat2.V3) {}
            }
          }
          else
          {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  private static boolean w(Format paramFormat, @Nullable String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    int i = paramFormat.x;
    boolean bool1 = false;
    if ((i & 0x4000) != 0) {
      return false;
    }
    boolean bool2 = bool1;
    if (u(paramInt1, false))
    {
      bool2 = bool1;
      if ((paramInt1 & paramInt2) != 0) {
        if (paramString != null)
        {
          bool2 = bool1;
          if (!o0.b(paramFormat.H3, paramString)) {}
        }
        else
        {
          paramInt1 = paramFormat.M3;
          if (paramInt1 != -1)
          {
            bool2 = bool1;
            if (paramInt7 <= paramInt1)
            {
              bool2 = bool1;
              if (paramInt1 > paramInt3) {}
            }
          }
          else
          {
            paramInt1 = paramFormat.N3;
            if (paramInt1 != -1)
            {
              bool2 = bool1;
              if (paramInt8 <= paramInt1)
              {
                bool2 = bool1;
                if (paramInt1 > paramInt4) {}
              }
            }
            else
            {
              float f1 = paramFormat.O3;
              if (f1 != -1.0F)
              {
                bool2 = bool1;
                if (paramInt9 <= f1)
                {
                  bool2 = bool1;
                  if (f1 > paramInt5) {}
                }
              }
              else
              {
                paramInt1 = paramFormat.p0;
                bool2 = bool1;
                if (paramInt1 != -1)
                {
                  bool2 = bool1;
                  if (paramInt10 <= paramInt1)
                  {
                    bool2 = bool1;
                    if (paramInt1 <= paramInt6) {
                      bool2 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private static void z(i.a parama, int[][][] paramArrayOfInt, e2[] paramArrayOfe2, g[] paramArrayOfg)
  {
    int i = 0;
    int j = 0;
    int k = -1;
    int i2;
    for (int m = -1; j < parama.c(); m = i2)
    {
      int n = parama.d(j);
      g localg = paramArrayOfg[j];
      if (n != 1)
      {
        i1 = k;
        i2 = m;
        if (n != 2) {}
      }
      else
      {
        i1 = k;
        i2 = m;
        if (localg != null)
        {
          i1 = k;
          i2 = m;
          if (B(paramArrayOfInt[j], parama.e(j), localg))
          {
            if (n == 1)
            {
              if (m == -1)
              {
                i2 = j;
                i1 = k;
                break label140;
              }
            }
            else {
              if (k == -1) {
                break label132;
              }
            }
            j = 0;
            break label157;
            label132:
            i1 = j;
            i2 = m;
          }
        }
      }
      label140:
      j++;
      k = i1;
    }
    j = 1;
    label157:
    int i1 = i;
    if (m != -1)
    {
      i1 = i;
      if (k != -1) {
        i1 = 1;
      }
    }
    if ((j & i1) != 0)
    {
      parama = new e2(true);
      paramArrayOfe2[m] = parama;
      paramArrayOfe2[k] = parama;
    }
  }
  
  protected g.a[] D(i.a parama, int[][][] paramArrayOfInt, int[] paramArrayOfInt1, Parameters paramParameters)
    throws ExoPlaybackException
  {
    int i = parama.c();
    g.a[] arrayOfa = new g.a[i];
    int j = 0;
    int k = 0;
    int m = 0;
    int i1;
    int i3;
    for (int n = 0;; n = i3)
    {
      i1 = 1;
      if (m >= i) {
        break;
      }
      i2 = k;
      i3 = n;
      if (2 == parama.d(m))
      {
        i2 = k;
        if (k == 0)
        {
          arrayOfa[m] = I(parama.e(m), paramArrayOfInt[m], paramArrayOfInt1[m], paramParameters, true);
          if (arrayOfa[m] != null) {
            i2 = 1;
          } else {
            i2 = 0;
          }
        }
        if (parama.e(m).d > 0) {
          k = i1;
        } else {
          k = 0;
        }
        i3 = n | k;
      }
      m++;
      k = i2;
    }
    Object localObject1 = null;
    Object localObject2 = localObject1;
    int i2 = -1;
    Object localObject4;
    for (k = 0; k < i; k++) {
      if (1 == parama.d(k))
      {
        boolean bool;
        if ((!paramParameters.g4) && (n != 0)) {
          bool = false;
        } else {
          bool = true;
        }
        TrackGroupArray localTrackGroupArray = parama.e(k);
        Object localObject3 = paramArrayOfInt[k];
        i1 = paramArrayOfInt1[k];
        i3 = i2;
        localObject4 = localObject1;
        m = k;
        localObject3 = E(localTrackGroupArray, (int[][])localObject3, i1, paramParameters, bool);
        if ((localObject3 != null) && ((localObject4 == null) || (((b)((Pair)localObject3).second).a((b)localObject4) > 0)))
        {
          if (i3 != -1) {
            arrayOfa[i3] = null;
          }
          localObject2 = (g.a)((Pair)localObject3).first;
          arrayOfa[m] = localObject2;
          localObject2 = ((g.a)localObject2).a.a(localObject2.b[0]).f;
          localObject1 = (b)((Pair)localObject3).second;
          i2 = m;
        }
      }
    }
    paramArrayOfInt1 = (int[])localObject2;
    localObject1 = null;
    k = -1;
    i2 = j;
    while (i2 < i)
    {
      n = parama.d(i2);
      if (n != 1)
      {
        if (n != 2) {
          if (n != 3)
          {
            arrayOfa[i2] = G(n, parama.e(i2), paramArrayOfInt[i2], paramParameters);
          }
          else
          {
            localObject4 = H(parama.e(i2), paramArrayOfInt[i2], paramParameters, paramArrayOfInt1);
            localObject2 = localObject1;
            n = k;
            if (localObject4 == null) {
              break label543;
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              n = k;
              if (((e)((Pair)localObject4).second).a((e)localObject1) <= 0) {
                break label543;
              }
            }
            if (k != -1) {
              arrayOfa[k] = null;
            }
            arrayOfa[i2] = ((g.a)((Pair)localObject4).first);
            localObject2 = (e)((Pair)localObject4).second;
            n = i2;
            break label543;
          }
        }
        localObject2 = localObject1;
        n = k;
      }
      else
      {
        n = k;
        localObject2 = localObject1;
      }
      label543:
      i2++;
      localObject1 = localObject2;
      k = n;
    }
    return arrayOfa;
  }
  
  @Nullable
  protected Pair<g.a, b> E(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, int paramInt, Parameters paramParameters, boolean paramBoolean)
    throws ExoPlaybackException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    paramInt = 0;
    int i = -1;
    int j = -1;
    while (paramInt < paramTrackGroupArray.d)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.a(paramInt);
      int[] arrayOfInt = paramArrayOfInt[paramInt];
      int k = 0;
      while (k < localTrackGroup.c)
      {
        int m = i;
        int n = j;
        localObject3 = localObject2;
        if (u(arrayOfInt[k], paramParameters.e4))
        {
          b localb = new b(localTrackGroup.a(k), paramParameters, arrayOfInt[k]);
          if ((!localb.c) && (!paramParameters.a4))
          {
            m = i;
            n = j;
            localObject3 = localObject2;
          }
          else if (localObject2 != null)
          {
            m = i;
            n = j;
            localObject3 = localObject2;
            if (localb.a((b)localObject2) <= 0) {}
          }
          else
          {
            m = paramInt;
            n = k;
            localObject3 = localb;
          }
        }
        k++;
        i = m;
        j = n;
        localObject2 = localObject3;
      }
      paramInt++;
    }
    if (i == -1) {
      return null;
    }
    Object localObject3 = paramTrackGroupArray.a(i);
    paramTrackGroupArray = (TrackGroupArray)localObject1;
    if (!paramParameters.T3)
    {
      paramTrackGroupArray = (TrackGroupArray)localObject1;
      if (!paramParameters.S3)
      {
        paramTrackGroupArray = (TrackGroupArray)localObject1;
        if (paramBoolean)
        {
          paramArrayOfInt = n((TrackGroup)localObject3, paramArrayOfInt[i], j, paramParameters.N3, paramParameters.b4, paramParameters.c4, paramParameters.d4);
          paramTrackGroupArray = (TrackGroupArray)localObject1;
          if (paramArrayOfInt.length > 1) {
            paramTrackGroupArray = new g.a((TrackGroup)localObject3, paramArrayOfInt);
          }
        }
      }
    }
    paramArrayOfInt = paramTrackGroupArray;
    if (paramTrackGroupArray == null) {
      paramArrayOfInt = new g.a((TrackGroup)localObject3, new int[] { j });
    }
    return Pair.create(paramArrayOfInt, (b)com.google.android.exoplayer2.util.g.e(localObject2));
  }
  
  @Nullable
  protected g.a G(int paramInt, TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, Parameters paramParameters)
    throws ExoPlaybackException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    int i = 0;
    int j = 0;
    while (i < paramTrackGroupArray.d)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.a(i);
      int[] arrayOfInt = paramArrayOfInt[i];
      paramInt = 0;
      while (paramInt < localTrackGroup.c)
      {
        Object localObject4 = localObject2;
        int k = j;
        Object localObject5 = localObject3;
        if (u(arrayOfInt[paramInt], paramParameters.e4))
        {
          c localc = new c(localTrackGroup.a(paramInt), arrayOfInt[paramInt]);
          if (localObject3 != null)
          {
            localObject4 = localObject2;
            k = j;
            localObject5 = localObject3;
            if (localc.a((c)localObject3) <= 0) {}
          }
          else
          {
            localObject4 = localTrackGroup;
            k = paramInt;
            localObject5 = localc;
          }
        }
        paramInt++;
        localObject2 = localObject4;
        j = k;
        localObject3 = localObject5;
      }
      i++;
    }
    if (localObject2 == null) {
      paramTrackGroupArray = (TrackGroupArray)localObject1;
    } else {
      paramTrackGroupArray = new g.a((TrackGroup)localObject2, new int[] { j });
    }
    return paramTrackGroupArray;
  }
  
  @Nullable
  protected Pair<g.a, e> H(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, Parameters paramParameters, @Nullable String paramString)
    throws ExoPlaybackException
  {
    Object localObject1 = null;
    int i = -1;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    for (int j = 0; j < paramTrackGroupArray.d; j++)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.a(j);
      int[] arrayOfInt = paramArrayOfInt[j];
      int k = 0;
      while (k < localTrackGroup.c)
      {
        int m;
        Object localObject4;
        Object localObject5;
        if (u(arrayOfInt[k], paramParameters.e4))
        {
          e locale = new e(localTrackGroup.a(k), paramParameters, arrayOfInt[k], paramString);
          m = i;
          localObject4 = localObject2;
          localObject5 = localObject3;
          if (locale.c) {
            if (localObject3 != null)
            {
              m = i;
              localObject4 = localObject2;
              localObject5 = localObject3;
              if (locale.a((e)localObject3) <= 0) {}
            }
            else
            {
              localObject4 = localTrackGroup;
              m = k;
              localObject5 = locale;
            }
          }
        }
        else
        {
          localObject5 = localObject3;
          localObject4 = localObject2;
          m = i;
        }
        k++;
        i = m;
        localObject2 = localObject4;
        localObject3 = localObject5;
      }
    }
    if (localObject2 == null) {
      paramTrackGroupArray = (TrackGroupArray)localObject1;
    } else {
      paramTrackGroupArray = Pair.create(new g.a((TrackGroup)localObject2, new int[] { i }), (e)com.google.android.exoplayer2.util.g.e(localObject3));
    }
    return paramTrackGroupArray;
  }
  
  @Nullable
  protected g.a I(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, int paramInt, Parameters paramParameters, boolean paramBoolean)
    throws ExoPlaybackException
  {
    g.a locala1;
    if ((!paramParameters.T3) && (!paramParameters.S3) && (paramBoolean)) {
      locala1 = C(paramTrackGroupArray, paramArrayOfInt, paramInt, paramParameters);
    } else {
      locala1 = null;
    }
    g.a locala2 = locala1;
    if (locala1 == null) {
      locala2 = F(paramTrackGroupArray, paramArrayOfInt, paramParameters);
    }
    return locala2;
  }
  
  public void J(Parameters paramParameters)
  {
    com.google.android.exoplayer2.util.g.e(paramParameters);
    if (!((Parameters)this.h.getAndSet(paramParameters)).equals(paramParameters)) {
      c();
    }
  }
  
  public void K(d paramd)
  {
    J(paramd.O());
  }
  
  protected final Pair<e2[], g[]> j(i.a parama, int[][][] paramArrayOfInt, int[] paramArrayOfInt1, e0.a parama1, j2 paramj2)
    throws ExoPlaybackException
  {
    Parameters localParameters = (Parameters)this.h.get();
    int i = parama.c();
    g.a[] arrayOfa = D(parama, paramArrayOfInt, paramArrayOfInt1, localParameters);
    for (int j = 0;; j++)
    {
      paramArrayOfInt1 = null;
      if (j >= i) {
        break;
      }
      if (localParameters.i(j))
      {
        arrayOfa[j] = null;
      }
      else
      {
        TrackGroupArray localTrackGroupArray = parama.e(j);
        if (localParameters.m(j, localTrackGroupArray))
        {
          SelectionOverride localSelectionOverride = localParameters.l(j, localTrackGroupArray);
          if (localSelectionOverride != null) {
            paramArrayOfInt1 = new g.a(localTrackGroupArray.a(localSelectionOverride.c), localSelectionOverride.d, localSelectionOverride.q);
          }
          arrayOfa[j] = paramArrayOfInt1;
        }
      }
    }
    parama1 = this.g.a(arrayOfa, a(), parama1, paramj2);
    paramj2 = new e2[i];
    for (j = 0; j < i; j++)
    {
      int k;
      if ((!localParameters.i(j)) && ((parama.d(j) == 7) || (parama1[j] != null))) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        paramArrayOfInt1 = e2.a;
      } else {
        paramArrayOfInt1 = null;
      }
      paramj2[j] = paramArrayOfInt1;
    }
    if (localParameters.f4) {
      z(parama, paramArrayOfInt, paramj2, parama1);
    }
    return Pair.create(paramj2, parama1);
  }
  
  public Parameters s()
  {
    return (Parameters)this.h.get();
  }
  
  public static final class Parameters
    extends TrackSelectionParameters
    implements Parcelable
  {
    public static final Parcelable.Creator<Parameters> CREATOR = new a();
    public static final Parameters U3;
    @Deprecated
    public static final Parameters V3;
    public final int W3;
    public final boolean X3;
    public final boolean Y3;
    public final boolean Z3;
    public final boolean a4;
    public final boolean b4;
    public final boolean c4;
    public final boolean d4;
    public final boolean e4;
    public final boolean f4;
    public final boolean g4;
    private final SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> h4;
    private final SparseBooleanArray i4;
    
    static
    {
      Parameters localParameters = new DefaultTrackSelector.d().O();
      U3 = localParameters;
      V3 = localParameters;
    }
    
    Parameters(Parcel paramParcel)
    {
      super();
      this.X3 = o0.A0(paramParcel);
      this.Y3 = o0.A0(paramParcel);
      this.Z3 = o0.A0(paramParcel);
      this.a4 = o0.A0(paramParcel);
      this.b4 = o0.A0(paramParcel);
      this.c4 = o0.A0(paramParcel);
      this.d4 = o0.A0(paramParcel);
      this.W3 = paramParcel.readInt();
      this.e4 = o0.A0(paramParcel);
      this.f4 = o0.A0(paramParcel);
      this.g4 = o0.A0(paramParcel);
      this.h4 = n(paramParcel);
      this.i4 = ((SparseBooleanArray)o0.i(paramParcel.readSparseBooleanArray()));
    }
    
    private Parameters(DefaultTrackSelector.d paramd)
    {
      super();
      this.X3 = DefaultTrackSelector.d.H(paramd);
      this.Y3 = DefaultTrackSelector.d.I(paramd);
      this.Z3 = DefaultTrackSelector.d.J(paramd);
      this.a4 = DefaultTrackSelector.d.K(paramd);
      this.b4 = DefaultTrackSelector.d.L(paramd);
      this.c4 = DefaultTrackSelector.d.M(paramd);
      this.d4 = DefaultTrackSelector.d.N(paramd);
      this.W3 = DefaultTrackSelector.d.B(paramd);
      this.e4 = DefaultTrackSelector.d.C(paramd);
      this.f4 = DefaultTrackSelector.d.D(paramd);
      this.g4 = DefaultTrackSelector.d.E(paramd);
      this.h4 = DefaultTrackSelector.d.F(paramd);
      this.i4 = DefaultTrackSelector.d.G(paramd);
    }
    
    private static boolean c(SparseBooleanArray paramSparseBooleanArray1, SparseBooleanArray paramSparseBooleanArray2)
    {
      int i = paramSparseBooleanArray1.size();
      if (paramSparseBooleanArray2.size() != i) {
        return false;
      }
      for (int j = 0; j < i; j++) {
        if (paramSparseBooleanArray2.indexOfKey(paramSparseBooleanArray1.keyAt(j)) < 0) {
          return false;
        }
      }
      return true;
    }
    
    private static boolean d(SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray1, SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray2)
    {
      int i = paramSparseArray1.size();
      if (paramSparseArray2.size() != i) {
        return false;
      }
      int j = 0;
      while (j < i)
      {
        int k = paramSparseArray2.indexOfKey(paramSparseArray1.keyAt(j));
        if ((k >= 0) && (e((Map)paramSparseArray1.valueAt(j), (Map)paramSparseArray2.valueAt(k)))) {
          j++;
        } else {
          return false;
        }
      }
      return true;
    }
    
    private static boolean e(Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride> paramMap1, Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride> paramMap2)
    {
      int i = paramMap1.size();
      if (paramMap2.size() != i) {
        return false;
      }
      Iterator localIterator = paramMap1.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap1 = (Map.Entry)localIterator.next();
        TrackGroupArray localTrackGroupArray = (TrackGroupArray)paramMap1.getKey();
        if ((!paramMap2.containsKey(localTrackGroupArray)) || (!o0.b(paramMap1.getValue(), paramMap2.get(localTrackGroupArray)))) {
          return false;
        }
      }
      return true;
    }
    
    public static Parameters h(Context paramContext)
    {
      return new DefaultTrackSelector.d(paramContext).O();
    }
    
    private static SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> n(Parcel paramParcel)
    {
      int i = paramParcel.readInt();
      SparseArray localSparseArray = new SparseArray(i);
      for (int j = 0; j < i; j++)
      {
        int k = paramParcel.readInt();
        int m = paramParcel.readInt();
        HashMap localHashMap = new HashMap(m);
        for (int n = 0; n < m; n++) {
          localHashMap.put((TrackGroupArray)com.google.android.exoplayer2.util.g.e((TrackGroupArray)paramParcel.readParcelable(TrackGroupArray.class.getClassLoader())), (DefaultTrackSelector.SelectionOverride)paramParcel.readParcelable(DefaultTrackSelector.SelectionOverride.class.getClassLoader()));
        }
        localSparseArray.put(k, localHashMap);
      }
      return localSparseArray;
    }
    
    private static void o(Parcel paramParcel, SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray)
    {
      int i = paramSparseArray.size();
      paramParcel.writeInt(i);
      for (int j = 0; j < i; j++)
      {
        int k = paramSparseArray.keyAt(j);
        Object localObject = (Map)paramSparseArray.valueAt(j);
        int m = ((Map)localObject).size();
        paramParcel.writeInt(k);
        paramParcel.writeInt(m);
        Iterator localIterator = ((Map)localObject).entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          paramParcel.writeParcelable((Parcelable)((Map.Entry)localObject).getKey(), 0);
          paramParcel.writeParcelable((Parcelable)((Map.Entry)localObject).getValue(), 0);
        }
      }
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
      if ((paramObject != null) && (Parameters.class == paramObject.getClass()))
      {
        paramObject = (Parameters)paramObject;
        if ((!super.equals(paramObject)) || (this.X3 != ((Parameters)paramObject).X3) || (this.Y3 != ((Parameters)paramObject).Y3) || (this.Z3 != ((Parameters)paramObject).Z3) || (this.a4 != ((Parameters)paramObject).a4) || (this.b4 != ((Parameters)paramObject).b4) || (this.c4 != ((Parameters)paramObject).c4) || (this.d4 != ((Parameters)paramObject).d4) || (this.W3 != ((Parameters)paramObject).W3) || (this.e4 != ((Parameters)paramObject).e4) || (this.f4 != ((Parameters)paramObject).f4) || (this.g4 != ((Parameters)paramObject).g4) || (!c(this.i4, ((Parameters)paramObject).i4)) || (!d(this.h4, ((Parameters)paramObject).h4))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public DefaultTrackSelector.d f()
    {
      return new DefaultTrackSelector.d(this, null);
    }
    
    public int hashCode()
    {
      return (((((((((((super.hashCode() + 31) * 31 + this.X3) * 31 + this.Y3) * 31 + this.Z3) * 31 + this.a4) * 31 + this.b4) * 31 + this.c4) * 31 + this.d4) * 31 + this.W3) * 31 + this.e4) * 31 + this.f4) * 31 + this.g4;
    }
    
    public final boolean i(int paramInt)
    {
      return this.i4.get(paramInt);
    }
    
    @Nullable
    public final DefaultTrackSelector.SelectionOverride l(int paramInt, TrackGroupArray paramTrackGroupArray)
    {
      Map localMap = (Map)this.h4.get(paramInt);
      if (localMap != null) {
        paramTrackGroupArray = (DefaultTrackSelector.SelectionOverride)localMap.get(paramTrackGroupArray);
      } else {
        paramTrackGroupArray = null;
      }
      return paramTrackGroupArray;
    }
    
    public final boolean m(int paramInt, TrackGroupArray paramTrackGroupArray)
    {
      Map localMap = (Map)this.h4.get(paramInt);
      boolean bool;
      if ((localMap != null) && (localMap.containsKey(paramTrackGroupArray))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      o0.N0(paramParcel, this.X3);
      o0.N0(paramParcel, this.Y3);
      o0.N0(paramParcel, this.Z3);
      o0.N0(paramParcel, this.a4);
      o0.N0(paramParcel, this.b4);
      o0.N0(paramParcel, this.c4);
      o0.N0(paramParcel, this.d4);
      paramParcel.writeInt(this.W3);
      o0.N0(paramParcel, this.e4);
      o0.N0(paramParcel, this.f4);
      o0.N0(paramParcel, this.g4);
      o(paramParcel, this.h4);
      paramParcel.writeSparseBooleanArray(this.i4);
    }
    
    class a
      implements Parcelable.Creator<DefaultTrackSelector.Parameters>
    {
      public DefaultTrackSelector.Parameters a(Parcel paramParcel)
      {
        return new DefaultTrackSelector.Parameters(paramParcel);
      }
      
      public DefaultTrackSelector.Parameters[] b(int paramInt)
      {
        return new DefaultTrackSelector.Parameters[paramInt];
      }
    }
  }
  
  public static final class SelectionOverride
    implements Parcelable
  {
    public static final Parcelable.Creator<SelectionOverride> CREATOR = new a();
    public final int c;
    public final int[] d;
    public final int f;
    public final int q;
    
    public SelectionOverride(int paramInt, int... paramVarArgs)
    {
      this(paramInt, paramVarArgs, 0);
    }
    
    public SelectionOverride(int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      this.c = paramInt1;
      int[] arrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      this.d = arrayOfInt;
      this.f = paramArrayOfInt.length;
      this.q = paramInt2;
      Arrays.sort(arrayOfInt);
    }
    
    SelectionOverride(Parcel paramParcel)
    {
      this.c = paramParcel.readInt();
      int i = paramParcel.readByte();
      this.f = i;
      int[] arrayOfInt = new int[i];
      this.d = arrayOfInt;
      paramParcel.readIntArray(arrayOfInt);
      this.q = paramParcel.readInt();
    }
    
    public boolean a(int paramInt)
    {
      int[] arrayOfInt = this.d;
      int i = arrayOfInt.length;
      for (int j = 0; j < i; j++) {
        if (arrayOfInt[j] == paramInt) {
          return true;
        }
      }
      return false;
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
      if ((paramObject != null) && (SelectionOverride.class == paramObject.getClass()))
      {
        paramObject = (SelectionOverride)paramObject;
        if ((this.c != ((SelectionOverride)paramObject).c) || (!Arrays.equals(this.d, ((SelectionOverride)paramObject).d)) || (this.q != ((SelectionOverride)paramObject).q)) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return (this.c * 31 + Arrays.hashCode(this.d)) * 31 + this.q;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d.length);
      paramParcel.writeIntArray(this.d);
      paramParcel.writeInt(this.q);
    }
    
    class a
      implements Parcelable.Creator<DefaultTrackSelector.SelectionOverride>
    {
      public DefaultTrackSelector.SelectionOverride a(Parcel paramParcel)
      {
        return new DefaultTrackSelector.SelectionOverride(paramParcel);
      }
      
      public DefaultTrackSelector.SelectionOverride[] b(int paramInt)
      {
        return new DefaultTrackSelector.SelectionOverride[paramInt];
      }
    }
  }
  
  protected static final class b
    implements Comparable<b>
  {
    private final int H3;
    private final int I3;
    private final int J3;
    public final boolean c;
    @Nullable
    private final String d;
    private final DefaultTrackSelector.Parameters f;
    private final int p0;
    private final int p1;
    private final boolean p2;
    private final int p3;
    private final boolean q;
    private final int x;
    private final int y;
    private final int z;
    
    public b(Format paramFormat, DefaultTrackSelector.Parameters paramParameters, int paramInt)
    {
      this.f = paramParameters;
      this.d = DefaultTrackSelector.A(paramFormat.f);
      int i = 0;
      this.q = DefaultTrackSelector.u(paramInt, false);
      int k;
      for (paramInt = 0;; paramInt++)
      {
        j = paramParameters.K3.size();
        k = Integer.MAX_VALUE;
        if (paramInt >= j) {
          break;
        }
        j = DefaultTrackSelector.q(paramFormat, (String)paramParameters.K3.get(paramInt), false);
        if (j > 0) {
          break label93;
        }
      }
      paramInt = Integer.MAX_VALUE;
      int j = 0;
      label93:
      this.y = paramInt;
      this.x = j;
      this.z = Integer.bitCount(paramFormat.x & paramParameters.L3);
      paramInt = paramFormat.q;
      boolean bool1 = true;
      if ((paramInt & 0x1) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.p2 = bool2;
      j = paramFormat.U3;
      this.p3 = j;
      this.H3 = paramFormat.V3;
      paramInt = paramFormat.p0;
      this.I3 = paramInt;
      if ((paramInt == -1) || (paramInt <= paramParameters.N3))
      {
        bool2 = bool1;
        if (j == -1) {
          break label221;
        }
        if (j <= paramParameters.M3)
        {
          bool2 = bool1;
          break label221;
        }
      }
      boolean bool2 = false;
      label221:
      this.c = bool2;
      Object localObject = o0.a0();
      for (paramInt = 0; paramInt < localObject.length; paramInt++)
      {
        int m = DefaultTrackSelector.q(paramFormat, localObject[paramInt], false);
        if (m > 0)
        {
          j = paramInt;
          paramInt = m;
          break label278;
        }
      }
      j = Integer.MAX_VALUE;
      paramInt = 0;
      label278:
      this.p0 = j;
      this.p1 = paramInt;
      for (paramInt = i;; paramInt++)
      {
        j = k;
        if (paramInt >= paramParameters.O3.size()) {
          break;
        }
        localObject = paramFormat.H3;
        if ((localObject != null) && (((String)localObject).equals(paramParameters.O3.get(paramInt))))
        {
          j = paramInt;
          break;
        }
      }
      this.J3 = j;
    }
    
    public int a(b paramb)
    {
      a2 locala2;
      if ((this.c) && (this.q)) {
        locala2 = DefaultTrackSelector.k();
      } else {
        locala2 = DefaultTrackSelector.k().j();
      }
      c0 localc0 = c0.k().h(this.q, paramb.q).g(Integer.valueOf(this.y), Integer.valueOf(paramb.y), a2.g().j()).d(this.x, paramb.x).d(this.z, paramb.z).h(this.c, paramb.c).g(Integer.valueOf(this.J3), Integer.valueOf(paramb.J3), a2.g().j());
      int i = this.I3;
      int j = paramb.I3;
      if (this.f.S3) {
        localObject = DefaultTrackSelector.k().j();
      } else {
        localObject = DefaultTrackSelector.l();
      }
      Object localObject = localc0.g(Integer.valueOf(i), Integer.valueOf(j), (Comparator)localObject).h(this.p2, paramb.p2).g(Integer.valueOf(this.p0), Integer.valueOf(paramb.p0), a2.g().j()).d(this.p1, paramb.p1).g(Integer.valueOf(this.p3), Integer.valueOf(paramb.p3), locala2).g(Integer.valueOf(this.H3), Integer.valueOf(paramb.H3), locala2);
      i = this.I3;
      j = paramb.I3;
      if (!o0.b(this.d, paramb.d)) {
        locala2 = DefaultTrackSelector.l();
      }
      return ((c0)localObject).g(Integer.valueOf(i), Integer.valueOf(j), locala2).j();
    }
  }
  
  protected static final class c
    implements Comparable<c>
  {
    private final boolean c;
    private final boolean d;
    
    public c(Format paramFormat, int paramInt)
    {
      int i = paramFormat.q;
      boolean bool = true;
      if ((i & 0x1) == 0) {
        bool = false;
      }
      this.c = bool;
      this.d = DefaultTrackSelector.u(paramInt, false);
    }
    
    public int a(c paramc)
    {
      return c0.k().h(this.d, paramc.d).h(this.c, paramc.c).j();
    }
  }
  
  public static final class d
    extends TrackSelectionParameters.b
  {
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private final SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> H;
    private final SparseBooleanArray I;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    
    @Deprecated
    public d()
    {
      this.H = new SparseArray();
      this.I = new SparseBooleanArray();
      R();
    }
    
    public d(Context paramContext)
    {
      super();
      this.H = new SparseArray();
      this.I = new SparseBooleanArray();
      R();
    }
    
    private d(DefaultTrackSelector.Parameters paramParameters)
    {
      super();
      this.D = paramParameters.W3;
      this.w = paramParameters.X3;
      this.x = paramParameters.Y3;
      this.y = paramParameters.Z3;
      this.z = paramParameters.a4;
      this.A = paramParameters.b4;
      this.B = paramParameters.c4;
      this.C = paramParameters.d4;
      this.E = paramParameters.e4;
      this.F = paramParameters.f4;
      this.G = paramParameters.g4;
      this.H = Q(DefaultTrackSelector.Parameters.a(paramParameters));
      this.I = DefaultTrackSelector.Parameters.b(paramParameters).clone();
    }
    
    private static SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> Q(SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray)
    {
      SparseArray localSparseArray = new SparseArray();
      for (int i = 0; i < paramSparseArray.size(); i++) {
        localSparseArray.put(paramSparseArray.keyAt(i), new HashMap((Map)paramSparseArray.valueAt(i)));
      }
      return localSparseArray;
    }
    
    private void R()
    {
      this.w = true;
      this.x = false;
      this.y = true;
      this.z = true;
      this.A = false;
      this.B = false;
      this.C = false;
      this.D = 0;
      this.E = true;
      this.F = false;
      this.G = true;
    }
    
    public DefaultTrackSelector.Parameters O()
    {
      return new DefaultTrackSelector.Parameters(this, null);
    }
    
    public final d P(int paramInt)
    {
      Map localMap = (Map)this.H.get(paramInt);
      if ((localMap != null) && (!localMap.isEmpty())) {
        this.H.remove(paramInt);
      }
      return this;
    }
    
    public d S(Context paramContext)
    {
      super.x(paramContext);
      return this;
    }
    
    public final d T(int paramInt, boolean paramBoolean)
    {
      if (this.I.get(paramInt) == paramBoolean) {
        return this;
      }
      if (paramBoolean) {
        this.I.put(paramInt, true);
      } else {
        this.I.delete(paramInt);
      }
      return this;
    }
    
    public final d U(int paramInt, TrackGroupArray paramTrackGroupArray, @Nullable DefaultTrackSelector.SelectionOverride paramSelectionOverride)
    {
      Map localMap = (Map)this.H.get(paramInt);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        this.H.put(paramInt, localObject);
      }
      if ((((Map)localObject).containsKey(paramTrackGroupArray)) && (o0.b(((Map)localObject).get(paramTrackGroupArray), paramSelectionOverride))) {
        return this;
      }
      ((Map)localObject).put(paramTrackGroupArray, paramSelectionOverride);
      return this;
    }
    
    public d V(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super.z(paramInt1, paramInt2, paramBoolean);
      return this;
    }
    
    public d W(Context paramContext, boolean paramBoolean)
    {
      super.A(paramContext, paramBoolean);
      return this;
    }
  }
  
  protected static final class e
    implements Comparable<e>
  {
    public final boolean c;
    private final boolean d;
    private final boolean f;
    private final int p0;
    private final boolean p1;
    private final boolean q;
    private final int x;
    private final int y;
    private final int z;
    
    public e(Format paramFormat, DefaultTrackSelector.Parameters paramParameters, int paramInt, @Nullable String paramString)
    {
      boolean bool1 = false;
      this.d = DefaultTrackSelector.u(paramInt, false);
      paramInt = paramFormat.q & (paramParameters.W3 ^ 0xFFFFFFFF);
      boolean bool2;
      if ((paramInt & 0x1) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.f = bool2;
      if ((paramInt & 0x2) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.q = bool2;
      int i = Integer.MAX_VALUE;
      ImmutableList localImmutableList;
      if (paramParameters.P3.isEmpty()) {
        localImmutableList = ImmutableList.of("");
      } else {
        localImmutableList = paramParameters.P3;
      }
      for (paramInt = 0; paramInt < localImmutableList.size(); paramInt++)
      {
        j = DefaultTrackSelector.q(paramFormat, (String)localImmutableList.get(paramInt), paramParameters.R3);
        if (j > 0)
        {
          i = paramInt;
          paramInt = j;
          break label154;
        }
      }
      paramInt = 0;
      label154:
      this.x = i;
      this.y = paramInt;
      int j = Integer.bitCount(paramFormat.x & paramParameters.Q3);
      this.z = j;
      if ((paramFormat.x & 0x440) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.p1 = bool2;
      if (DefaultTrackSelector.A(paramString) == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      i = DefaultTrackSelector.q(paramFormat, paramString, bool2);
      this.p0 = i;
      if ((paramInt <= 0) && ((!paramParameters.P3.isEmpty()) || (j <= 0)) && (!this.f))
      {
        bool2 = bool1;
        if (this.q)
        {
          bool2 = bool1;
          if (i <= 0) {}
        }
      }
      else
      {
        bool2 = true;
      }
      this.c = bool2;
    }
    
    public int a(e parame)
    {
      c0 localc0 = c0.k().h(this.d, parame.d).g(Integer.valueOf(this.x), Integer.valueOf(parame.x), a2.g().j()).d(this.y, parame.y).d(this.z, parame.z).h(this.f, parame.f);
      boolean bool1 = this.q;
      boolean bool2 = parame.q;
      if (this.y == 0) {
        localObject = a2.g();
      } else {
        localObject = a2.g().j();
      }
      localc0 = localc0.g(Boolean.valueOf(bool1), Boolean.valueOf(bool2), (Comparator)localObject).d(this.p0, parame.p0);
      Object localObject = localc0;
      if (this.z == 0) {
        localObject = localc0.i(this.p1, parame.p1);
      }
      return ((c0)localObject).j();
    }
  }
  
  protected static final class f
    implements Comparable<f>
  {
    public final boolean c;
    private final DefaultTrackSelector.Parameters d;
    private final boolean f;
    private final boolean q;
    private final int x;
    private final int y;
    private final int z;
    
    public f(Format paramFormat, DefaultTrackSelector.Parameters paramParameters, int paramInt, boolean paramBoolean)
    {
      this.d = paramParameters;
      boolean bool1 = true;
      int i = 0;
      float f1;
      if (paramBoolean)
      {
        j = paramFormat.M3;
        if ((j == -1) || (j <= paramParameters.f))
        {
          j = paramFormat.N3;
          if ((j == -1) || (j <= paramParameters.q))
          {
            f1 = paramFormat.O3;
            if ((f1 == -1.0F) || (f1 <= paramParameters.x))
            {
              j = paramFormat.p0;
              if ((j == -1) || (j <= paramParameters.y))
              {
                bool2 = true;
                break label117;
              }
            }
          }
        }
      }
      boolean bool2 = false;
      label117:
      this.c = bool2;
      if (paramBoolean)
      {
        j = paramFormat.M3;
        if ((j == -1) || (j >= paramParameters.z))
        {
          j = paramFormat.N3;
          if ((j == -1) || (j >= paramParameters.p0))
          {
            f1 = paramFormat.O3;
            if ((f1 == -1.0F) || (f1 >= paramParameters.p1))
            {
              j = paramFormat.p0;
              paramBoolean = bool1;
              if (j == -1) {
                break label230;
              }
              if (j >= paramParameters.p2)
              {
                paramBoolean = bool1;
                break label230;
              }
            }
          }
        }
      }
      paramBoolean = false;
      label230:
      this.f = paramBoolean;
      this.q = DefaultTrackSelector.u(paramInt, false);
      this.x = paramFormat.p0;
      this.y = paramFormat.c();
      int j = Integer.MAX_VALUE;
      for (paramInt = i;; paramInt++)
      {
        i = j;
        if (paramInt >= paramParameters.J3.size()) {
          break;
        }
        String str = paramFormat.H3;
        if ((str != null) && (str.equals(paramParameters.J3.get(paramInt))))
        {
          i = paramInt;
          break;
        }
      }
      this.z = i;
    }
    
    public int a(f paramf)
    {
      a2 locala21;
      if ((this.c) && (this.q)) {
        locala21 = DefaultTrackSelector.k();
      } else {
        locala21 = DefaultTrackSelector.k().j();
      }
      c0 localc0 = c0.k().h(this.q, paramf.q).h(this.c, paramf.c).h(this.f, paramf.f).g(Integer.valueOf(this.z), Integer.valueOf(paramf.z), a2.g().j());
      int i = this.x;
      int j = paramf.x;
      a2 locala22;
      if (this.d.S3) {
        locala22 = DefaultTrackSelector.k().j();
      } else {
        locala22 = DefaultTrackSelector.l();
      }
      return localc0.g(Integer.valueOf(i), Integer.valueOf(j), locala22).g(Integer.valueOf(this.y), Integer.valueOf(paramf.y), locala21).g(Integer.valueOf(this.x), Integer.valueOf(paramf.x), locala21).j();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\DefaultTrackSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */