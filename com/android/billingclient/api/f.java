package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private boolean a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private ArrayList<SkuDetails> g;
  private boolean h;
  
  @NonNull
  public static a e()
  {
    return new a(null);
  }
  
  @Nullable
  public String a()
  {
    return this.c;
  }
  
  @Nullable
  public String b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  @NonNull
  public final ArrayList<SkuDetails> f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.g);
    return localArrayList;
  }
  
  @Nullable
  public final String g()
  {
    return this.b;
  }
  
  final boolean h()
  {
    return (this.h) || (this.b != null) || (this.e != null) || (this.f != 0) || (this.a);
  }
  
  @Nullable
  public final String i()
  {
    return this.e;
  }
  
  public static class a
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private ArrayList<SkuDetails> f;
    private boolean g;
    
    @NonNull
    public f a()
    {
      Object localObject1 = this.f;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = this.f;
        int i = ((List)localObject1).size();
        int j = 0;
        while (j < i) {
          if ((SkuDetails)((List)localObject1).get(j) != null) {
            j++;
          } else {
            throw new IllegalArgumentException("SKU cannot be null.");
          }
        }
        if (this.f.size() > 1)
        {
          SkuDetails localSkuDetails = (SkuDetails)this.f.get(0);
          localObject1 = localSkuDetails.l();
          Object localObject2 = this.f;
          i = ((List)localObject2).size();
          for (j = 0; j < i; j++)
          {
            localObject3 = (SkuDetails)((List)localObject2).get(j);
            if ((!((String)localObject1).equals("play_pass_subs")) && (!((SkuDetails)localObject3).l().equals("play_pass_subs")) && (!((String)localObject1).equals(((SkuDetails)localObject3).l()))) {
              throw new IllegalArgumentException("SKUs should have the same type.");
            }
          }
          localObject2 = localSkuDetails.m();
          Object localObject3 = this.f;
          i = ((List)localObject3).size();
          for (j = 0; j < i; j++)
          {
            localSkuDetails = (SkuDetails)((List)localObject3).get(j);
            if ((!((String)localObject1).equals("play_pass_subs")) && (!localSkuDetails.l().equals("play_pass_subs")) && (!((String)localObject2).equals(localSkuDetails.m()))) {
              throw new IllegalArgumentException("All SKUs must have the same package name.");
            }
          }
        }
        localObject1 = new f(null);
        f.j((f)localObject1, true ^ ((SkuDetails)this.f.get(0)).m().isEmpty());
        f.k((f)localObject1, this.a);
        f.l((f)localObject1, this.d);
        f.m((f)localObject1, this.b);
        f.n((f)localObject1, this.c);
        f.o((f)localObject1, this.e);
        f.p((f)localObject1, this.f);
        f.q((f)localObject1, this.g);
        return (f)localObject1;
      }
      throw new IllegalArgumentException("SkuDetails must be provided.");
    }
    
    @NonNull
    public a b(@NonNull String paramString1, @NonNull String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
      return this;
    }
    
    @NonNull
    public a c(@NonNull SkuDetails paramSkuDetails)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramSkuDetails);
      this.f = localArrayList;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */