package retrofit2.adapter.rxjava2;

import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.q;

public final class d<T>
{
  @Nullable
  private final q<T> a;
  @Nullable
  private final Throwable b;
  
  private d(@Nullable q<T> paramq, @Nullable Throwable paramThrowable)
  {
    this.a = paramq;
    this.b = paramThrowable;
  }
  
  public static <T> d<T> a(Throwable paramThrowable)
  {
    Objects.requireNonNull(paramThrowable, "error == null");
    return new d(null, paramThrowable);
  }
  
  public static <T> d<T> b(q<T> paramq)
  {
    Objects.requireNonNull(paramq, "response == null");
    return new d(paramq, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\adapter\rxjava2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */