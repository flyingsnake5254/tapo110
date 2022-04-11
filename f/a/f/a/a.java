package f.a.f.a;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import f.a.h.c;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  boolean a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  String n;
  
  private String a(String paramString)
  {
    if (paramString.startsWith("#")) {
      return paramString;
    }
    a locala = f.d().g(paramString);
    if (locala != null)
    {
      if (locala.b()) {
        return locala.n;
      }
      if (c.a)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" cannot reference ");
        localStringBuilder.append(locala.b);
        c.a("ColorState", localStringBuilder.toString());
      }
    }
    return null;
  }
  
  private ColorStateList d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    boolean bool = TextUtils.isEmpty(this.c);
    int i1 = 0;
    if (!bool) {}
    try
    {
      str1 = a(this.c);
      if (!TextUtils.isEmpty(str1))
      {
        i2 = Color.parseColor(str1);
        localArrayList.add(e.d);
        ((List)localObject1).add(Integer.valueOf(i2));
        i3 = 1;
      }
    }
    catch (Exception localException11)
    {
      String str1;
      for (;;) {}
    }
    i3 = 0;
    i2 = i3;
    if (!TextUtils.isEmpty(this.d)) {
      try
      {
        str1 = a(this.d);
        i2 = i3;
        if (!TextUtils.isEmpty(str1))
        {
          i2 = Color.parseColor(str1);
          localArrayList.add(e.m);
          ((List)localObject1).add(Integer.valueOf(i2));
          i2 = i3 + 1;
        }
      }
      catch (Exception localException2)
      {
        i2 = i3;
      }
    }
    i3 = i2;
    if (!TextUtils.isEmpty(this.e)) {
      try
      {
        String str2 = a(this.e);
        i3 = i2;
        if (!TextUtils.isEmpty(str2))
        {
          i3 = Color.parseColor(str2);
          localArrayList.add(e.e);
          ((List)localObject1).add(Integer.valueOf(i3));
          i3 = i2 + 1;
        }
      }
      catch (Exception localException3)
      {
        i3 = i2;
      }
    }
    i2 = i3;
    if (!TextUtils.isEmpty(this.f)) {
      try
      {
        String str3 = a(this.f);
        i2 = i3;
        if (!TextUtils.isEmpty(str3))
        {
          i2 = Color.parseColor(str3);
          localArrayList.add(e.c);
          ((List)localObject1).add(Integer.valueOf(i2));
          i2 = i3 + 1;
        }
      }
      catch (Exception localException4)
      {
        i2 = i3;
      }
    }
    i3 = i2;
    if (!TextUtils.isEmpty(this.g)) {
      try
      {
        String str4 = a(this.g);
        i3 = i2;
        if (!TextUtils.isEmpty(str4))
        {
          i3 = Color.parseColor(str4);
          localArrayList.add(e.k);
          ((List)localObject1).add(Integer.valueOf(i3));
          i3 = i2 + 1;
        }
      }
      catch (Exception localException5)
      {
        i3 = i2;
      }
    }
    i2 = i3;
    if (!TextUtils.isEmpty(this.h)) {
      try
      {
        String str5 = a(this.h);
        i2 = i3;
        if (!TextUtils.isEmpty(str5))
        {
          i2 = Color.parseColor(str5);
          localArrayList.add(e.l);
          ((List)localObject1).add(Integer.valueOf(i2));
          i2 = i3 + 1;
        }
      }
      catch (Exception localException6)
      {
        i2 = i3;
      }
    }
    i3 = i2;
    if (!TextUtils.isEmpty(this.i)) {
      try
      {
        String str6 = a(this.i);
        i3 = i2;
        if (!TextUtils.isEmpty(str6))
        {
          i3 = Color.parseColor(str6);
          localArrayList.add(e.f);
          ((List)localObject1).add(Integer.valueOf(i3));
          i3 = i2 + 1;
        }
      }
      catch (Exception localException7)
      {
        i3 = i2;
      }
    }
    i2 = i3;
    if (!TextUtils.isEmpty(this.j)) {
      try
      {
        String str7 = a(this.j);
        i2 = i3;
        if (!TextUtils.isEmpty(str7))
        {
          i2 = Color.parseColor(str7);
          localArrayList.add(e.g);
          ((List)localObject1).add(Integer.valueOf(i2));
          i2 = i3 + 1;
        }
      }
      catch (Exception localException8)
      {
        i2 = i3;
      }
    }
    i3 = i2;
    if (!TextUtils.isEmpty(this.k)) {
      try
      {
        String str8 = a(this.k);
        i3 = i2;
        if (!TextUtils.isEmpty(str8))
        {
          i3 = Color.parseColor(str8);
          localArrayList.add(e.h);
          ((List)localObject1).add(Integer.valueOf(i3));
          i3 = i2 + 1;
        }
      }
      catch (Exception localException9)
      {
        i3 = i2;
      }
    }
    i2 = i3;
    if (!TextUtils.isEmpty(this.l)) {
      try
      {
        String str9 = a(this.l);
        i2 = i3;
        if (!TextUtils.isEmpty(str9))
        {
          i2 = Color.parseColor(str9);
          localArrayList.add(e.i);
          ((List)localObject1).add(Integer.valueOf(i2));
          i2 = i3 + 1;
        }
      }
      catch (Exception localException10)
      {
        i2 = i3;
      }
    }
    i3 = i2;
    if (!TextUtils.isEmpty(this.m)) {}
    for (;;)
    {
      try
      {
        localObject2 = a(this.m);
        i3 = i2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i3 = Color.parseColor((String)localObject2);
          localArrayList.add(e.j);
          ((List)localObject1).add(Integer.valueOf(i3));
          i3 = i2 + 1;
        }
      }
      catch (Exception localException12)
      {
        Object localObject2;
        int[][] arrayOfInt;
        i3 = i2;
        continue;
      }
      try
      {
        localObject2 = a(this.n);
        i2 = i3;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i2 = Color.parseColor((String)localObject2);
          localArrayList.add(e.o);
          ((List)localObject1).add(Integer.valueOf(i2));
          i2 = i3 + 1;
        }
        arrayOfInt = new int[i2][];
        localObject2 = new int[i2];
        i3 = i1;
        if (i3 < i2)
        {
          arrayOfInt[i3] = ((int[])localArrayList.get(i3));
          localObject2[i3] = ((Integer)((List)localObject1).get(i3)).intValue();
          i3++;
          continue;
        }
        localObject1 = new ColorStateList(arrayOfInt, (int[])localObject2);
        return (ColorStateList)localObject1;
      }
      catch (Exception localException1)
      {
        if (c.a)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.b);
          localStringBuilder.append(" parse failure.");
          c.a("ColorState", localStringBuilder.toString());
        }
        f.d().m(this.b);
        return null;
      }
    }
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  ColorStateList c()
  {
    if (this.a) {
      return ColorStateList.valueOf(Color.parseColor(this.n));
    }
    return d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */