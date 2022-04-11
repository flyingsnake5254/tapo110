package retrofit2;

import java.lang.annotation.Annotation;

final class u
  implements t
{
  private static final t a = new u();
  
  static Annotation[] a(Annotation[] paramArrayOfAnnotation)
  {
    if (v.m(paramArrayOfAnnotation, t.class)) {
      return paramArrayOfAnnotation;
    }
    Annotation[] arrayOfAnnotation = new Annotation[paramArrayOfAnnotation.length + 1];
    arrayOfAnnotation[0] = a;
    System.arraycopy(paramArrayOfAnnotation, 0, arrayOfAnnotation, 1, paramArrayOfAnnotation.length);
    return arrayOfAnnotation;
  }
  
  public Class<? extends Annotation> annotationType()
  {
    return t.class;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof t;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(t.class.getName());
    localStringBuilder.append("()");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */