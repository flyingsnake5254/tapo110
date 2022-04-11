package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.e;

public class FunctionReference
  extends CallableReference
  implements h, e
{
  private final int arity;
  private final int flags;
  
  public FunctionReference(int paramInt)
  {
    this(paramInt, CallableReference.NO_RECEIVER, null, null, null, 0);
  }
  
  public FunctionReference(int paramInt, Object paramObject)
  {
    this(paramInt, paramObject, null, null, null, 0);
  }
  
  public FunctionReference(int paramInt1, Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt2)
  {
    super(paramObject, paramClass, paramString1, paramString2, bool);
    this.arity = paramInt1;
    this.flags = (paramInt2 >> 1);
  }
  
  protected b computeReflected()
  {
    return m.a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof FunctionReference))
    {
      paramObject = (FunctionReference)paramObject;
      if ((!j.a(getOwner(), ((CallableReference)paramObject).getOwner())) || (!getName().equals(((CallableReference)paramObject).getName())) || (!getSignature().equals(((CallableReference)paramObject).getSignature())) || (this.flags != ((FunctionReference)paramObject).flags) || (this.arity != ((FunctionReference)paramObject).arity) || (!j.a(getBoundReceiver(), ((CallableReference)paramObject).getBoundReceiver()))) {
        bool = false;
      }
      return bool;
    }
    if ((paramObject instanceof e)) {
      return paramObject.equals(compute());
    }
    return false;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  protected e getReflected()
  {
    return (e)super.getReflected();
  }
  
  public int hashCode()
  {
    int i;
    if (getOwner() == null) {
      i = 0;
    } else {
      i = getOwner().hashCode() * 31;
    }
    return (i + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  public boolean isExternal()
  {
    return getReflected().isExternal();
  }
  
  public boolean isInfix()
  {
    return getReflected().isInfix();
  }
  
  public boolean isInline()
  {
    return getReflected().isInline();
  }
  
  public boolean isOperator()
  {
    return getReflected().isOperator();
  }
  
  public boolean isSuspend()
  {
    return getReflected().isSuspend();
  }
  
  public String toString()
  {
    Object localObject = compute();
    if (localObject != this) {
      return localObject.toString();
    }
    if ("<init>".equals(getName()))
    {
      localObject = "constructor (Kotlin reflection is not available)";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("function ");
      ((StringBuilder)localObject).append(getName());
      ((StringBuilder)localObject).append(" (Kotlin reflection is not available)");
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\FunctionReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */