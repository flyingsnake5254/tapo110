package com.google.common.reflect;

import com.google.common.base.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class a
  extends AccessibleObject
  implements Member
{
  private final AccessibleObject c;
  private final Member d;
  
  <M extends AccessibleObject,  extends Member> a(M paramM)
  {
    n.o(paramM);
    this.c = paramM;
    this.d = ((Member)paramM);
  }
  
  public TypeToken<?> a()
  {
    return TypeToken.of(getDeclaringClass());
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof a;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (a)paramObject;
      bool3 = bool2;
      if (a().equals(((a)paramObject).a()))
      {
        bool3 = bool2;
        if (this.d.equals(((a)paramObject).d)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public final <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this.c.getAnnotation(paramClass);
  }
  
  public final Annotation[] getAnnotations()
  {
    return this.c.getAnnotations();
  }
  
  public final Annotation[] getDeclaredAnnotations()
  {
    return this.c.getDeclaredAnnotations();
  }
  
  public Class<?> getDeclaringClass()
  {
    return this.d.getDeclaringClass();
  }
  
  public final int getModifiers()
  {
    return this.d.getModifiers();
  }
  
  public final String getName()
  {
    return this.d.getName();
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  public final boolean isAccessible()
  {
    return this.c.isAccessible();
  }
  
  public final boolean isAnnotationPresent(Class<? extends Annotation> paramClass)
  {
    return this.c.isAnnotationPresent(paramClass);
  }
  
  public final boolean isSynthetic()
  {
    return this.d.isSynthetic();
  }
  
  public final void setAccessible(boolean paramBoolean)
    throws SecurityException
  {
    this.c.setAccessible(paramBoolean);
  }
  
  public String toString()
  {
    return this.d.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */