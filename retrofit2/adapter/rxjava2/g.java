package retrofit2.adapter.rxjava2;

import io.reactivex.a;
import io.reactivex.h;
import io.reactivex.m;
import io.reactivex.w;
import io.reactivex.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.c;
import retrofit2.c.a;
import retrofit2.r;

public final class g
  extends c.a
{
  @Nullable
  private final w a;
  private final boolean b;
  
  private g(@Nullable w paramw, boolean paramBoolean)
  {
    this.a = paramw;
    this.b = paramBoolean;
  }
  
  public static g d()
  {
    return new g(null, false);
  }
  
  public static g e()
  {
    return new g(null, true);
  }
  
  @Nullable
  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    paramArrayOfAnnotation = c.a.c(paramType);
    if (paramArrayOfAnnotation == a.class) {
      return new f(Void.class, this.a, this.b, false, true, false, false, false, true);
    }
    boolean bool1;
    if (paramArrayOfAnnotation == h.class) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramArrayOfAnnotation == x.class) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (paramArrayOfAnnotation == m.class) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if ((paramArrayOfAnnotation != io.reactivex.q.class) && (!bool1) && (!bool2) && (!bool3)) {
      return null;
    }
    if (!(paramType instanceof ParameterizedType))
    {
      if (!bool1)
      {
        if (!bool2)
        {
          if (bool3) {
            paramType = "Maybe";
          } else {
            paramType = "Observable";
          }
        }
        else {
          paramType = "Single";
        }
      }
      else {
        paramType = "Flowable";
      }
      paramArrayOfAnnotation = new StringBuilder();
      paramArrayOfAnnotation.append(paramType);
      paramArrayOfAnnotation.append(" return type must be parameterized as ");
      paramArrayOfAnnotation.append(paramType);
      paramArrayOfAnnotation.append("<Foo> or ");
      paramArrayOfAnnotation.append(paramType);
      paramArrayOfAnnotation.append("<? extends Foo>");
      throw new IllegalStateException(paramArrayOfAnnotation.toString());
    }
    paramType = c.a.b(0, (ParameterizedType)paramType);
    paramArrayOfAnnotation = c.a.c(paramType);
    if (paramArrayOfAnnotation == retrofit2.q.class) {
      if ((paramType instanceof ParameterizedType)) {
        paramType = c.a.b(0, (ParameterizedType)paramType);
      }
    }
    for (boolean bool4 = false;; bool4 = true)
    {
      boolean bool5 = false;
      bool6 = bool4;
      bool4 = bool5;
      break label312;
      throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
      if (paramArrayOfAnnotation != d.class) {
        break label306;
      }
      if (!(paramType instanceof ParameterizedType)) {
        break;
      }
      paramType = c.a.b(0, (ParameterizedType)paramType);
    }
    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
    label306:
    boolean bool6 = false;
    bool4 = true;
    label312:
    return new f(paramType, this.a, this.b, bool6, bool4, bool1, bool2, bool3, false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\adapter\rxjava2\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */