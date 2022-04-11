package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

public final class p
{
  private final SparseBooleanArray a;
  
  private p(SparseBooleanArray paramSparseBooleanArray)
  {
    this.a = paramSparseBooleanArray;
  }
  
  public boolean a(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public boolean b(int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      if (a(paramVarArgs[j])) {
        return true;
      }
    }
    return false;
  }
  
  public int c(int paramInt)
  {
    g.c(paramInt, 0, d());
    return this.a.keyAt(paramInt);
  }
  
  public int d()
  {
    return this.a.size();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof p)) {
      return false;
    }
    paramObject = (p)paramObject;
    return this.a.equals(((p)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public static final class b
  {
    private final SparseBooleanArray a = new SparseBooleanArray();
    private boolean b;
    
    public b a(int paramInt)
    {
      g.g(this.b ^ true);
      this.a.append(paramInt, true);
      return this;
    }
    
    public b b(p paramp)
    {
      for (int i = 0; i < paramp.d(); i++) {
        a(paramp.c(i));
      }
      return this;
    }
    
    public b c(int... paramVarArgs)
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        a(paramVarArgs[j]);
      }
      return this;
    }
    
    public b d(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean) {
        return a(paramInt);
      }
      return this;
    }
    
    public p e()
    {
      g.g(this.b ^ true);
      this.b = true;
      return new p(this.a, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */