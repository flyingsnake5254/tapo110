package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d
{
  public static final d a = new d(new String[] { "COMPOSITION" });
  private final List<String> b;
  @Nullable
  private e c;
  
  private d(d paramd)
  {
    this.b = new ArrayList(paramd.b);
    this.c = paramd.c;
  }
  
  public d(String... paramVarArgs)
  {
    this.b = Arrays.asList(paramVarArgs);
  }
  
  private boolean b()
  {
    List localList = this.b;
    return ((String)localList.get(localList.size() - 1)).equals("**");
  }
  
  private boolean f(String paramString)
  {
    return "__container".equals(paramString);
  }
  
  @CheckResult
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public d a(String paramString)
  {
    d locald = new d(this);
    locald.b.add(paramString);
    return locald;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean c(String paramString, int paramInt)
  {
    int i = this.b.size();
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramInt >= i) {
      return false;
    }
    if (paramInt == this.b.size() - 1) {
      i = 1;
    } else {
      i = 0;
    }
    String str = (String)this.b.get(paramInt);
    int j;
    boolean bool3;
    if (!str.equals("**"))
    {
      if ((!str.equals(paramString)) && (!str.equals("*"))) {
        j = 0;
      } else {
        j = 1;
      }
      if (i == 0)
      {
        bool3 = bool2;
        if (paramInt == this.b.size() - 2)
        {
          bool3 = bool2;
          if (!b()) {}
        }
      }
      else
      {
        bool3 = bool2;
        if (j != 0) {
          bool3 = true;
        }
      }
      return bool3;
    }
    if ((i == 0) && (((String)this.b.get(paramInt + 1)).equals(paramString))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      if (paramInt != this.b.size() - 2)
      {
        bool3 = bool1;
        if (paramInt == this.b.size() - 3)
        {
          bool3 = bool1;
          if (!b()) {}
        }
      }
      else
      {
        bool3 = true;
      }
      return bool3;
    }
    if (i != 0) {
      return true;
    }
    paramInt++;
    if (paramInt < this.b.size() - 1) {
      return false;
    }
    return ((String)this.b.get(paramInt)).equals(paramString);
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public e d()
  {
    return this.c;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int e(String paramString, int paramInt)
  {
    if (f(paramString)) {
      return 0;
    }
    if (!((String)this.b.get(paramInt)).equals("**")) {
      return 1;
    }
    if (paramInt == this.b.size() - 1) {
      return 0;
    }
    if (((String)this.b.get(paramInt + 1)).equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public String g()
  {
    return this.b.toString();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean h(String paramString, int paramInt)
  {
    if (f(paramString)) {
      return true;
    }
    if (paramInt >= this.b.size()) {
      return false;
    }
    return (((String)this.b.get(paramInt)).equals(paramString)) || (((String)this.b.get(paramInt)).equals("**")) || (((String)this.b.get(paramInt)).equals("*"));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean i(String paramString, int paramInt)
  {
    boolean bool1 = "__container".equals(paramString);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    bool1 = bool2;
    if (paramInt >= this.b.size() - 1) {
      if (((String)this.b.get(paramInt)).equals("**")) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public d j(e parame)
  {
    d locald = new d(this);
    locald.c = parame;
    return locald;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyPath{keys=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",resolved=");
    boolean bool;
    if (this.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */