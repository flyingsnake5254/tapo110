package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcg<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
  extends zzas<MessageType, BuilderType>
{
  private static Map<Object, zzcg<?, ?>> zzjr = new ConcurrentHashMap();
  protected zzey zzjp = zzey.zzea();
  private int zzjq = -1;
  
  public static <ContainingType extends zzdo, Type> zzf<ContainingType, Type> zza(ContainingType paramContainingType, Type paramType, zzdo paramzzdo, zzck<?> paramzzck, int paramInt, zzfl paramzzfl, Class paramClass)
  {
    return new zzf(paramContainingType, paramType, paramzzdo, new zze(null, 66321687, paramzzfl, false, false), paramClass);
  }
  
  private static <T extends zzcg<T, ?>> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzco
  {
    paramT = (zzcg)paramT.zza(zzg.zzkg, null, null);
    try
    {
      zzef localzzef = zzea.zzcm().zzp(paramT);
      int i = paramArrayOfByte.length;
      zzay localzzay = new com/google/android/gms/internal/clearcut/zzay;
      localzzay.<init>();
      localzzef.zza(paramT, paramArrayOfByte, 0, i, localzzay);
      zzea.zzcm().zzp(paramT).zzc(paramT);
      if (paramT.zzex == 0) {
        return paramT;
      }
      paramArrayOfByte = new java/lang/RuntimeException;
      paramArrayOfByte.<init>();
      throw paramArrayOfByte;
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      throw zzco.zzbl().zzg(paramT);
    }
    catch (IOException paramArrayOfByte)
    {
      if ((paramArrayOfByte.getCause() instanceof zzco)) {
        throw ((zzco)paramArrayOfByte.getCause());
      }
      throw new zzco(paramArrayOfByte.getMessage()).zzg(paramT);
    }
  }
  
  protected static Object zza(zzdo paramzzdo, String paramString, Object[] paramArrayOfObject)
  {
    return new zzec(paramzzdo, paramString, paramArrayOfObject);
  }
  
  static Object zza(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  protected static <T extends zzcg<?, ?>> void zza(Class<T> paramClass, T paramT)
  {
    zzjr.put(paramClass, paramT);
  }
  
  protected static final <T extends zzcg<T, ?>> boolean zza(T paramT, boolean paramBoolean)
  {
    int i = ((Byte)paramT.zza(zzg.zzkd, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    return zzea.zzcm().zzp(paramT).zzo(paramT);
  }
  
  protected static zzcl zzaz()
  {
    return zzch.zzbk();
  }
  
  protected static <T extends zzcg<T, ?>> T zzb(T paramT, byte[] paramArrayOfByte)
    throws zzco
  {
    paramArrayOfByte = zza(paramT, paramArrayOfByte);
    if (paramArrayOfByte != null)
    {
      int i = ((Byte)paramArrayOfByte.zza(zzg.zzkd, null, null)).byteValue();
      boolean bool = true;
      if (i != 1) {
        if (i == 0)
        {
          bool = false;
        }
        else
        {
          bool = zzea.zzcm().zzp(paramArrayOfByte).zzo(paramArrayOfByte);
          i = zzg.zzke;
          if (bool) {
            paramT = paramArrayOfByte;
          } else {
            paramT = null;
          }
          paramArrayOfByte.zza(i, paramT, null);
        }
      }
      if (!bool) {
        throw new zzco(new zzew(paramArrayOfByte).getMessage()).zzg(paramArrayOfByte);
      }
    }
    return paramArrayOfByte;
  }
  
  protected static zzcm zzba()
  {
    return zzdc.zzbx();
  }
  
  protected static <E> zzcn<E> zzbb()
  {
    return zzeb.zzcn();
  }
  
  static <T extends zzcg<?, ?>> T zzc(Class<T> paramClass)
  {
    zzcg localzzcg1 = (zzcg)zzjr.get(paramClass);
    zzcg localzzcg2 = localzzcg1;
    if (localzzcg1 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localzzcg2 = (zzcg)zzjr.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    if (localzzcg2 == null)
    {
      paramClass = paramClass.getName();
      if (paramClass.length() != 0) {
        paramClass = "Unable to get default instance for: ".concat(paramClass);
      } else {
        paramClass = new String("Unable to get default instance for: ");
      }
      throw new IllegalStateException(paramClass);
    }
    return localzzcg2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!((zzcg)zza(zzg.zzki, null, null)).getClass().isInstance(paramObject)) {
      return false;
    }
    return zzea.zzcm().zzp(this).equals(this, (zzcg)paramObject);
  }
  
  public int hashCode()
  {
    int i = this.zzex;
    if (i != 0) {
      return i;
    }
    i = zzea.zzcm().zzp(this).hashCode(this);
    this.zzex = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    int i = ((Byte)zza(zzg.zzkd, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    boolean bool = zzea.zzcm().zzp(this).zzo(this);
    i = zzg.zzke;
    zzcg localzzcg;
    if (bool) {
      localzzcg = this;
    } else {
      localzzcg = null;
    }
    zza(i, localzzcg, null);
    return bool;
  }
  
  public String toString()
  {
    return zzdr.zza(this, super.toString());
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  public final int zzas()
  {
    if (this.zzjq == -1) {
      this.zzjq = zzea.zzcm().zzp(this).zzm(this);
    }
    return this.zzjq;
  }
  
  public final void zzb(zzbn paramzzbn)
    throws IOException
  {
    zzea.zzcm().zze(getClass()).zza(this, zzbp.zza(paramzzbn));
  }
  
  final void zzf(int paramInt)
  {
    this.zzjq = paramInt;
  }
  
  final int zzs()
  {
    return this.zzjq;
  }
  
  public static class zza<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>>
    extends zzat<MessageType, BuilderType>
  {
    private final MessageType zzjs;
    protected MessageType zzjt;
    protected boolean zzju;
    
    protected zza(MessageType paramMessageType)
    {
      this.zzjs = paramMessageType;
      this.zzjt = ((zzcg)paramMessageType.zza(zzcg.zzg.zzkg, null, null));
      this.zzju = false;
    }
    
    private static void zza(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      zzea.zzcm().zzp(paramMessageType1).zzc(paramMessageType1, paramMessageType2);
    }
    
    public final boolean isInitialized()
    {
      return zzcg.zza(this.zzjt, false);
    }
    
    public final BuilderType zza(MessageType paramMessageType)
    {
      zzbf();
      zza(this.zzjt, paramMessageType);
      return this;
    }
    
    protected void zzbf()
    {
      if (this.zzju)
      {
        zzcg localzzcg = (zzcg)this.zzjt.zza(zzcg.zzg.zzkg, null, null);
        zza(localzzcg, this.zzjt);
        this.zzjt = localzzcg;
        this.zzju = false;
      }
    }
    
    public MessageType zzbg()
    {
      if (this.zzju) {
        return this.zzjt;
      }
      zzcg localzzcg = this.zzjt;
      zzea.zzcm().zzp(localzzcg).zzc(localzzcg);
      this.zzju = true;
      return this.zzjt;
    }
    
    public final MessageType zzbh()
    {
      zzcg localzzcg1 = (zzcg)zzbi();
      int i = ((Byte)localzzcg1.zza(zzcg.zzg.zzkd, null, null)).byteValue();
      boolean bool = true;
      if (i != 1) {
        if (i == 0)
        {
          bool = false;
        }
        else
        {
          bool = zzea.zzcm().zzp(localzzcg1).zzo(localzzcg1);
          i = zzcg.zzg.zzke;
          zzcg localzzcg2;
          if (bool) {
            localzzcg2 = localzzcg1;
          } else {
            localzzcg2 = null;
          }
          localzzcg1.zza(i, localzzcg2, null);
        }
      }
      if (bool) {
        return localzzcg1;
      }
      throw new zzew(localzzcg1);
    }
  }
  
  public static final class zzb<T extends zzcg<T, ?>>
    extends zzau<T>
  {
    private T zzjs;
    
    public zzb(T paramT)
    {
      this.zzjs = paramT;
    }
  }
  
  public static class zzc<MessageType extends zzcg.zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>>
    extends zzcg.zza<MessageType, BuilderType>
    implements zzdq
  {
    protected zzc(MessageType paramMessageType)
    {
      super();
    }
    
    protected final void zzbf()
    {
      if (!this.zzju) {
        return;
      }
      super.zzbf();
      zzcg localzzcg = this.zzjt;
      ((zzcg.zzd)localzzcg).zzjv = ((zzby)((zzcg.zzd)localzzcg).zzjv.clone());
    }
  }
  
  public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzcg.zzc<MessageType, BuilderType>>
    extends zzcg<MessageType, BuilderType>
    implements zzdq
  {
    protected zzby<zzcg.zze> zzjv = zzby.zzar();
  }
  
  static final class zze
    implements zzca<zze>
  {
    final int number = 66321687;
    private final zzck<?> zzjw = null;
    final zzfl zzjx;
    final boolean zzjy;
    final boolean zzjz;
    
    zze(zzck<?> paramzzck, int paramInt, zzfl paramzzfl, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.zzjx = paramzzfl;
      this.zzjy = false;
      this.zzjz = false;
    }
    
    public final zzdp zza(zzdp paramzzdp, zzdo paramzzdo)
    {
      return ((zzcg.zza)paramzzdp).zza((zzcg)paramzzdo);
    }
    
    public final zzdv zza(zzdv paramzzdv1, zzdv paramzzdv2)
    {
      throw new UnsupportedOperationException();
    }
    
    public final zzfl zzau()
    {
      return this.zzjx;
    }
    
    public final zzfq zzav()
    {
      return this.zzjx.zzek();
    }
    
    public final boolean zzaw()
    {
      return false;
    }
    
    public final boolean zzax()
    {
      return false;
    }
    
    public final int zzc()
    {
      return this.number;
    }
  }
  
  public static final class zzf<ContainingType extends zzdo, Type>
    extends zzbr<ContainingType, Type>
  {
    private final Type zzdu;
    private final ContainingType zzka;
    private final zzdo zzkb;
    private final zzcg.zze zzkc;
    
    zzf(ContainingType paramContainingType, Type paramType, zzdo paramzzdo, zzcg.zze paramzze, Class paramClass)
    {
      if (paramContainingType != null)
      {
        if ((paramzze.zzjx == zzfl.zzqm) && (paramzzdo == null)) {
          throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.zzka = paramContainingType;
        this.zzdu = paramType;
        this.zzkb = paramzzdo;
        this.zzkc = paramzze;
        return;
      }
      throw new IllegalArgumentException("Null containingTypeDefaultInstance");
    }
  }
  
  public static enum zzg
  {
    public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0()
    {
      return (int[])zzkk.clone();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */