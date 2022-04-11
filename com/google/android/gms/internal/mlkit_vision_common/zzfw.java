package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzfw
{
  static String zza(zzfv paramzzfv, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    zza(paramzzfv, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  private static final String zza(String paramString)
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
  
  private static void zza(zzfv paramzzfv, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject3;
    for (localObject3 : paramzzfv.getClass().getDeclaredMethods())
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
      localObject1 = (String)localIterator.next();
      if (((String)localObject1).startsWith("get")) {
        localObject3 = ((String)localObject1).substring(3);
      } else {
        localObject3 = localObject1;
      }
      boolean bool1 = ((String)localObject3).endsWith("List");
      boolean bool2 = true;
      Object localObject4;
      if ((bool1) && (!((String)localObject3).endsWith("OrBuilderList")) && (!((String)localObject3).equals("List")))
      {
        localObject4 = String.valueOf(((String)localObject3).substring(0, 1).toLowerCase());
        ??? = String.valueOf(((String)localObject3).substring(1, ((String)localObject3).length() - 4));
        if (((String)???).length() != 0) {
          ??? = ((String)localObject4).concat((String)???);
        } else {
          ??? = new String((String)localObject4);
        }
        localObject4 = (Method)localHashMap1.get(localObject1);
        if ((localObject4 != null) && (((Method)localObject4).getReturnType().equals(List.class)))
        {
          zza(paramStringBuilder, paramInt, zza((String)???), zzek.zza((Method)localObject4, paramzzfv, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject3).endsWith("Map")) && (!((String)localObject3).equals("Map")))
      {
        localObject4 = String.valueOf(((String)localObject3).substring(0, 1).toLowerCase());
        ??? = String.valueOf(((String)localObject3).substring(1, ((String)localObject3).length() - 3));
        if (((String)???).length() != 0) {
          ??? = ((String)localObject4).concat((String)???);
        } else {
          ??? = new String((String)localObject4);
        }
        localObject1 = (Method)localHashMap1.get(localObject1);
        if ((localObject1 != null) && (((Method)localObject1).getReturnType().equals(Map.class)) && (!((Method)localObject1).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject1).getModifiers())))
        {
          zza(paramStringBuilder, paramInt, zza((String)???), zzek.zza((Method)localObject1, paramzzfv, new Object[0]));
          continue;
        }
      }
      if (((String)localObject3).length() != 0) {
        ??? = "set".concat((String)localObject3);
      } else {
        ??? = new String("set");
      }
      if ((Method)localHashMap2.get(???) != null) {
        if (((String)localObject3).endsWith("Bytes"))
        {
          ??? = String.valueOf(((String)localObject3).substring(0, ((String)localObject3).length() - 5));
          if (((String)???).length() != 0) {
            ??? = "get".concat((String)???);
          } else {
            ??? = new String("get");
          }
          if (localHashMap1.containsKey(???)) {}
        }
        else
        {
          ??? = String.valueOf(((String)localObject3).substring(0, 1).toLowerCase());
          localObject1 = String.valueOf(((String)localObject3).substring(1));
          if (((String)localObject1).length() != 0) {
            ??? = ((String)???).concat((String)localObject1);
          } else {
            ??? = new String((String)???);
          }
          if (((String)localObject3).length() != 0) {
            localObject1 = "get".concat((String)localObject3);
          } else {
            localObject1 = new String("get");
          }
          localObject1 = (Method)localHashMap1.get(localObject1);
          if (((String)localObject3).length() != 0) {
            localObject3 = "has".concat((String)localObject3);
          } else {
            localObject3 = new String("has");
          }
          localObject3 = (Method)localHashMap1.get(localObject3);
          if (localObject1 != null)
          {
            localObject1 = zzek.zza((Method)localObject1, paramzzfv, new Object[0]);
            if (localObject3 == null)
            {
              if ((localObject1 instanceof Boolean)) {
                if (((Boolean)localObject1).booleanValue()) {}
              }
              for (;;)
              {
                bool1 = true;
                break;
                label857:
                label881:
                label948:
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          bool1 = false;
                          break label970;
                          if (!(localObject1 instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)localObject1).intValue() != 0);
                        break;
                        if (!(localObject1 instanceof Float)) {
                          break label857;
                        }
                      } while (((Float)localObject1).floatValue() != 0.0F);
                      break;
                      if (!(localObject1 instanceof Double)) {
                        break label881;
                      }
                    } while (((Double)localObject1).doubleValue() != 0.0D);
                    break;
                    if ((localObject1 instanceof String))
                    {
                      bool1 = localObject1.equals("");
                      break label970;
                    }
                    if ((localObject1 instanceof zzdj))
                    {
                      bool1 = localObject1.equals(zzdj.zza);
                      break label970;
                    }
                    if (!(localObject1 instanceof zzfv)) {
                      break label948;
                    }
                  } while (localObject1 != ((zzfv)localObject1).zzn());
                  break;
                } while ((!(localObject1 instanceof Enum)) || (((Enum)localObject1).ordinal() != 0));
              }
              label970:
              if (!bool1) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
            else
            {
              bool1 = ((Boolean)zzek.zza((Method)localObject3, paramzzfv, new Object[0])).booleanValue();
            }
            if (bool1) {
              zza(paramStringBuilder, paramInt, zza((String)???), localObject1);
            }
          }
        }
      }
    }
    if ((paramzzfv instanceof zzek.zzc))
    {
      localObject3 = ((zzek.zzc)paramzzfv).zzc.zzd();
      if (((Iterator)localObject3).hasNext())
      {
        paramzzfv = (zzek.zzf)((Map.Entry)((Iterator)localObject3).next()).getKey();
        throw new NoSuchMethodError();
      }
    }
    paramzzfv = ((zzek)paramzzfv).zzb;
    if (paramzzfv != null) {
      paramzzfv.zza(paramStringBuilder, paramInt);
    }
  }
  
  static final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        zza(paramStringBuilder, paramInt, paramString, ((Iterator)paramObject).next());
      }
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)paramObject).hasNext()) {
        zza(paramStringBuilder, paramInt, paramString, (Map.Entry)((Iterator)paramObject).next());
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
      paramStringBuilder.append(zzgw.zza(zzdj.zza((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzdj))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzgw.zza((zzdj)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzek))
    {
      paramStringBuilder.append(" {");
      zza((zzek)paramObject, paramStringBuilder, paramInt + 2);
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
      zza(paramStringBuilder, k, "key", paramString.getKey());
      zza(paramStringBuilder, k, "value", paramString.getValue());
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */