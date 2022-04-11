package com.tplink.iot.Utils.z0;

import android.view.View.OnClickListener;
import kotlin.jvm.internal.j;

public final class k
{
  private final int a;
  private final int b;
  private int c;
  private View.OnClickListener d;
  
  public k(int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramOnClickListener;
  }
  
  public final View.OnClickListener a()
  {
    return this.d;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.a;
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final void e(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((this.a == ((k)paramObject).a) && (this.b == ((k)paramObject).b) && (this.c == ((k)paramObject).c) && (j.a(this.d, ((k)paramObject).d))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.a;
    int j = this.b;
    int k = this.c;
    View.OnClickListener localOnClickListener = this.d;
    int m;
    if (localOnClickListener != null) {
      m = localOnClickListener.hashCode();
    } else {
      m = 0;
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ControlComponent(id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", textId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", drawableId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", clickListener=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */