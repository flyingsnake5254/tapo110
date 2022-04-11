package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import kotlin.reflect.a;
import kotlin.reflect.b;
import kotlin.reflect.d;
import kotlin.reflect.n;

public abstract class CallableReference
  implements b, Serializable
{
  public static final Object NO_RECEIVER = ;
  private final boolean isTopLevel;
  private final String name;
  private final Class owner;
  protected final Object receiver;
  private transient b reflected;
  private final String signature;
  
  public CallableReference()
  {
    this(NO_RECEIVER);
  }
  
  protected CallableReference(Object paramObject)
  {
    this(paramObject, null, null, null, false);
  }
  
  protected CallableReference(Object paramObject, Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.receiver = paramObject;
    this.owner = paramClass;
    this.name = paramString1;
    this.signature = paramString2;
    this.isTopLevel = paramBoolean;
  }
  
  public Object call(Object... paramVarArgs)
  {
    return getReflected().call(paramVarArgs);
  }
  
  public Object callBy(Map paramMap)
  {
    return getReflected().callBy(paramMap);
  }
  
  public b compute()
  {
    b localb1 = this.reflected;
    b localb2 = localb1;
    if (localb1 == null)
    {
      localb2 = computeReflected();
      this.reflected = localb2;
    }
    return localb2;
  }
  
  protected abstract b computeReflected();
  
  public List<Annotation> getAnnotations()
  {
    return getReflected().getAnnotations();
  }
  
  public Object getBoundReceiver()
  {
    return this.receiver;
  }
  
  public String getName()
  {
    return this.name;
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
  
  public List<?> getParameters()
  {
    return getReflected().getParameters();
  }
  
  protected b getReflected()
  {
    b localb = compute();
    if (localb != this) {
      return localb;
    }
    throw new KotlinReflectionNotSupportedError();
  }
  
  public n getReturnType()
  {
    return getReflected().getReturnType();
  }
  
  public String getSignature()
  {
    return this.signature;
  }
  
  public List<?> getTypeParameters()
  {
    return getReflected().getTypeParameters();
  }
  
  public KVisibility getVisibility()
  {
    return getReflected().getVisibility();
  }
  
  public boolean isAbstract()
  {
    return getReflected().isAbstract();
  }
  
  public boolean isFinal()
  {
    return getReflected().isFinal();
  }
  
  public boolean isOpen()
  {
    return getReflected().isOpen();
  }
  
  public boolean isSuspend()
  {
    return getReflected().isSuspend();
  }
  
  private static class a
    implements Serializable
  {
    private static final a c = new a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\CallableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */