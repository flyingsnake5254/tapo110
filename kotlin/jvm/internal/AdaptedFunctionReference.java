package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.d;

public class AdaptedFunctionReference
  implements h, Serializable
{
  private final int arity;
  private final int flags;
  private final boolean isTopLevel;
  private final String name;
  private final Class owner;
  protected final Object receiver;
  private final String signature;
  
  public AdaptedFunctionReference(int paramInt1, Class paramClass, String paramString1, String paramString2, int paramInt2)
  {
    this(paramInt1, CallableReference.NO_RECEIVER, paramClass, paramString1, paramString2, paramInt2);
  }
  
  public AdaptedFunctionReference(int paramInt1, Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt2)
  {
    this.receiver = paramObject;
    this.owner = paramClass;
    this.name = paramString1;
    this.signature = paramString2;
    boolean bool;
    if ((paramInt2 & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.isTopLevel = bool;
    this.arity = paramInt1;
    this.flags = (paramInt2 >> 1);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AdaptedFunctionReference)) {
      return false;
    }
    paramObject = (AdaptedFunctionReference)paramObject;
    if ((this.isTopLevel != ((AdaptedFunctionReference)paramObject).isTopLevel) || (this.arity != ((AdaptedFunctionReference)paramObject).arity) || (this.flags != ((AdaptedFunctionReference)paramObject).flags) || (!j.a(this.receiver, ((AdaptedFunctionReference)paramObject).receiver)) || (!j.a(this.owner, ((AdaptedFunctionReference)paramObject).owner)) || (!this.name.equals(((AdaptedFunctionReference)paramObject).name)) || (!this.signature.equals(((AdaptedFunctionReference)paramObject).signature))) {
      bool = false;
    }
    return bool;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public d getOwner()
  {
    Object localObject = this.owner;
    if (localObject == null) {
      localObject = null;
    } else if (this.isTopLevel) {
      localObject = m.c((Class)localObject);
    } else {
      localObject = m.b((Class)localObject);
    }
    return (d)localObject;
  }
  
  public int hashCode()
  {
    Object localObject = this.receiver;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.owner;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    int k = this.name.hashCode();
    int m = this.signature.hashCode();
    int n;
    if (this.isTopLevel) {
      n = 1231;
    } else {
      n = 1237;
    }
    return (((((j * 31 + i) * 31 + k) * 31 + m) * 31 + n) * 31 + this.arity) * 31 + this.flags;
  }
  
  public String toString()
  {
    return m.j(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\AdaptedFunctionReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */