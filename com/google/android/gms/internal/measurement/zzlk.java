package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzlk
{
  static String zza(zzli paramzzli, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    zzc(paramzzli, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  static final void zzb(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        zzb(paramStringBuilder, paramInt, paramString, ((Iterator)paramObject).next());
      }
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)paramObject).hasNext()) {
        zzb(paramStringBuilder, paramInt, paramString, (Map.Entry)((Iterator)paramObject).next());
      }
      return;
    }
    paramStringBuilder.append('\n');
    int i = 0;
    int j = 0;
    for (int k = 0; k < paramInt; k++) {
      paramStringBuilder.append(' ');
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzmf.zza(zzjd.zzk((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzjd))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzmf.zza((zzjd)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzkd))
    {
      paramStringBuilder.append(" {");
      zzc((zzkd)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      for (k = j; k < paramInt; k++) {
        paramStringBuilder.append(' ');
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      paramString = (Map.Entry)paramObject;
      k = paramInt + 2;
      zzb(paramStringBuilder, k, "key", paramString.getKey());
      zzb(paramStringBuilder, k, "value", paramString.getValue());
      paramStringBuilder.append("\n");
      for (k = i; k < paramInt; k++) {
        paramStringBuilder.append(' ');
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
  
  private static void zzc(zzli paramzzli, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject3;
    for (localObject3 : paramzzli.getClass().getDeclaredMethods())
    {
      localHashMap2.put(((Method)localObject3).getName(), localObject3);
      if (((Method)localObject3).getParameterTypes().length == 0)
      {
        localHashMap1.put(((Method)localObject3).getName(), localObject3);
        if (((Method)localObject3).getName().startsWith("get")) {
          ((Set)localObject1).add(((Method)localObject3).getName());
        }
      }
    }
    Iterator localIterator = ((Set)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      if (((String)localObject3).startsWith("get")) {
        localObject1 = ((String)localObject3).substring(3);
      } else {
        localObject1 = localObject3;
      }
      Object localObject4;
      if ((((String)localObject1).endsWith("List")) && (!((String)localObject1).endsWith("OrBuilderList")) && (!((String)localObject1).equals("List")))
      {
        ??? = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
        localObject4 = String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 4));
        if (((String)localObject4).length() != 0) {
          ??? = ((String)???).concat((String)localObject4);
        } else {
          ??? = new String((String)???);
        }
        localObject4 = (Method)localHashMap1.get(localObject3);
        if ((localObject4 != null) && (((Method)localObject4).getReturnType().equals(List.class)))
        {
          zzb(paramStringBuilder, paramInt, zzd((String)???), zzkd.zzbA((Method)localObject4, paramzzli, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject1).endsWith("Map")) && (!((String)localObject1).equals("Map")))
      {
        localObject4 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
        ??? = String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 3));
        if (((String)???).length() != 0) {
          ??? = ((String)localObject4).concat((String)???);
        } else {
          ??? = new String((String)localObject4);
        }
        localObject3 = (Method)localHashMap1.get(localObject3);
        if ((localObject3 != null) && (((Method)localObject3).getReturnType().equals(Map.class)) && (!((Method)localObject3).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject3).getModifiers())))
        {
          zzb(paramStringBuilder, paramInt, zzd((String)???), zzkd.zzbA((Method)localObject3, paramzzli, new Object[0]));
          continue;
        }
      }
      if (((String)localObject1).length() != 0) {
        ??? = "set".concat((String)localObject1);
      } else {
        ??? = new String("set");
      }
      if ((Method)localHashMap2.get(???) != null) {
        if (((String)localObject1).endsWith("Bytes"))
        {
          ??? = String.valueOf(((String)localObject1).substring(0, ((String)localObject1).length() - 5));
          if (((String)???).length() != 0) {
            ??? = "get".concat((String)???);
          } else {
            ??? = new String("get");
          }
          if (localHashMap1.containsKey(???)) {}
        }
        else
        {
          ??? = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
          localObject3 = String.valueOf(((String)localObject1).substring(1));
          if (((String)localObject3).length() != 0) {
            ??? = ((String)???).concat((String)localObject3);
          } else {
            ??? = new String((String)???);
          }
          if (((String)localObject1).length() != 0) {
            localObject3 = "get".concat((String)localObject1);
          } else {
            localObject3 = new String("get");
          }
          localObject3 = (Method)localHashMap1.get(localObject3);
          if (((String)localObject1).length() != 0) {
            localObject1 = "has".concat((String)localObject1);
          } else {
            localObject1 = new String("has");
          }
          localObject1 = (Method)localHashMap1.get(localObject1);
          if (localObject3 != null)
          {
            localObject3 = zzkd.zzbA((Method)localObject3, paramzzli, new Object[0]);
            if (localObject1 == null)
            {
              if ((localObject3 instanceof Boolean))
              {
                if (!((Boolean)localObject3).booleanValue()) {
                  continue;
                }
              }
              else if ((localObject3 instanceof Integer))
              {
                if (((Integer)localObject3).intValue() == 0) {
                  continue;
                }
              }
              else if ((localObject3 instanceof Float))
              {
                if (((Float)localObject3).floatValue() == 0.0F) {
                  continue;
                }
              }
              else if ((localObject3 instanceof Double))
              {
                if (((Double)localObject3).doubleValue() == 0.0D) {
                  continue;
                }
              }
              else
              {
                boolean bool;
                if ((localObject3 instanceof String))
                {
                  bool = localObject3.equals("");
                }
                else
                {
                  if (!(localObject3 instanceof zzjd)) {
                    break label911;
                  }
                  bool = localObject3.equals(zzjd.zzb);
                }
                if (bool) {
                  continue;
                }
                break label978;
                label911:
                if ((localObject3 instanceof zzli)) {
                  if (localObject3 == ((zzli)localObject3).zzbL()) {
                    continue;
                  }
                } else if ((localObject3 instanceof Enum)) {
                  if (((Enum)localObject3).ordinal() == 0) {
                    continue;
                  }
                }
              }
            }
            else {
              if (!((Boolean)zzkd.zzbA((Method)localObject1, paramzzli, new Object[0])).booleanValue()) {
                continue;
              }
            }
            label978:
            zzb(paramStringBuilder, paramInt, zzd((String)???), localObject3);
          }
        }
      }
    }
    if (!(paramzzli instanceof zzka))
    {
      paramzzli = ((zzkd)paramzzli).zzc;
      if (paramzzli != null) {
        paramzzli.zzg(paramStringBuilder, paramInt);
      }
      return;
    }
    paramzzli = (zzka)paramzzli;
    throw null;
  }
  
  private static final String zzd(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString.length(); i++)
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzlk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */