package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.common.base.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class f
{
  private String a = "";
  private String b = "";
  private Set<String> c = Collections.emptySet();
  private String d = "";
  @Nullable
  private String e = null;
  @ColorInt
  private int f;
  private boolean g = false;
  private int h;
  private boolean i = false;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private float o;
  private int p = -1;
  private boolean q = false;
  
  private static int B(int paramInt1, String paramString1, @Nullable String paramString2, int paramInt2)
  {
    if (!paramString1.isEmpty())
    {
      int i1 = -1;
      if (paramInt1 != -1)
      {
        if (paramString1.equals(paramString2)) {
          i1 = paramInt1 + paramInt2;
        }
        return i1;
      }
    }
    return paramInt1;
  }
  
  public f A(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public int a()
  {
    if (this.i) {
      return this.h;
    }
    throw new IllegalStateException("Background color not defined.");
  }
  
  public boolean b()
  {
    return this.q;
  }
  
  public int c()
  {
    if (this.g) {
      return this.f;
    }
    throw new IllegalStateException("Font color not defined");
  }
  
  @Nullable
  public String d()
  {
    return this.e;
  }
  
  public float e()
  {
    return this.o;
  }
  
  public int f()
  {
    return this.n;
  }
  
  public int g()
  {
    return this.p;
  }
  
  public int h(@Nullable String paramString1, @Nullable String paramString2, Set<String> paramSet, @Nullable String paramString3)
  {
    if ((this.a.isEmpty()) && (this.b.isEmpty()) && (this.c.isEmpty()) && (this.d.isEmpty())) {
      return TextUtils.isEmpty(paramString2);
    }
    int i1 = B(B(B(0, this.a, paramString1, 1073741824), this.b, paramString2, 2), this.d, paramString3, 4);
    if ((i1 != -1) && (paramSet.containsAll(this.c))) {
      return i1 + this.c.size() * 4;
    }
    return 0;
  }
  
  public int i()
  {
    int i1 = this.l;
    if ((i1 == -1) && (this.m == -1)) {
      return -1;
    }
    int i2 = 0;
    if (i1 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.m == 1) {
      i2 = 2;
    }
    return i1 | i2;
  }
  
  public boolean j()
  {
    return this.i;
  }
  
  public boolean k()
  {
    return this.g;
  }
  
  public boolean l()
  {
    int i1 = this.j;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean m()
  {
    int i1 = this.k;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    return bool;
  }
  
  public f n(int paramInt)
  {
    this.h = paramInt;
    this.i = true;
    return this;
  }
  
  public f o(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public f p(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public f q(int paramInt)
  {
    this.f = paramInt;
    this.g = true;
    return this;
  }
  
  public f r(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = c.e(paramString);
    }
    this.e = paramString;
    return this;
  }
  
  public f s(float paramFloat)
  {
    this.o = paramFloat;
    return this;
  }
  
  public f t(int paramInt)
  {
    this.n = paramInt;
    return this;
  }
  
  public f u(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public f v(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
  
  public void w(String[] paramArrayOfString)
  {
    this.c = new HashSet(Arrays.asList(paramArrayOfString));
  }
  
  public void x(String paramString)
  {
    this.a = paramString;
  }
  
  public void y(String paramString)
  {
    this.b = paramString;
  }
  
  public void z(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */