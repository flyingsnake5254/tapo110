package b.d.d.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.TPMediaAccountInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class c
  implements d.a
{
  private TPMediaAccountInfo a;
  
  public c(TPMediaAccountInfo paramTPMediaAccountInfo)
  {
    this.a = paramTPMediaAccountInfo;
  }
  
  public TPMediaAccountInfo a()
  {
    return this.a;
  }
  
  @NonNull
  public <T extends a> T create(@NonNull Class<T> paramClass)
  {
    try
    {
      a locala = (a)paramClass.getConstructor(new Class[] { c.class }).newInstance(new Object[] { this });
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InstantiationException localInstantiationException) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot create an instance of ");
    localStringBuilder.append(paramClass);
    throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    if (this.a != null)
    {
      c localc = (c)paramObject;
      if (localc.a() != null)
      {
        if (this == paramObject) {
          return true;
        }
        if ((!TextUtils.isEmpty(this.a.getAccountId())) && (!TextUtils.isEmpty(localc.a().getAccountId()))) {
          return this.a.getAccountId().equals(localc.a().getAccountId());
        }
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */