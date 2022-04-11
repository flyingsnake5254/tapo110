package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzgm
{
  static String zza(zzgh paramzzgh, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    zza(paramzzgh, localStringBuilder, 0);
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
  
  private static void zza(zzgh paramzzgh, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject3;
    for (localObject3 : paramzzgh.getClass().getDeclaredMethods())
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
        ??? = ((String)localObject3).substring(3);
      } else {
        ??? = localObject3;
      }
      boolean bool1 = ((String)???).endsWith("List");
      boolean bool2 = true;
      Object localObject4;
      if ((bool1) && (!((String)???).endsWith("OrBuilderList")) && (!((String)???).equals("List")))
      {
        localObject4 = String.valueOf(((String)???).substring(0, 1).toLowerCase());
        localObject1 = String.valueOf(((String)???).substring(1, ((String)???).length() - 4));
        if (((String)localObject1).length() != 0) {
          localObject1 = ((String)localObject4).concat((String)localObject1);
        } else {
          localObject1 = new String((String)localObject4);
        }
        localObject4 = (Method)localHashMap1.get(localObject3);
        if ((localObject4 != null) && (((Method)localObject4).getReturnType().equals(List.class)))
        {
          zza(paramStringBuilder, paramInt, zza((String)localObject1), zzez.zza((Method)localObject4, paramzzgh, new Object[0]));
          continue;
        }
      }
      if ((((String)???).endsWith("Map")) && (!((String)???).equals("Map")))
      {
        localObject4 = String.valueOf(((String)???).substring(0, 1).toLowerCase());
        localObject1 = String.valueOf(((String)???).substring(1, ((String)???).length() - 3));
        if (((String)localObject1).length() != 0) {
          localObject1 = ((String)localObject4).concat((String)localObject1);
        } else {
          localObject1 = new String((String)localObject4);
        }
        localObject3 = (Method)localHashMap1.get(localObject3);
        if ((localObject3 != null) && (((Method)localObject3).getReturnType().equals(Map.class)) && (!((Method)localObject3).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject3).getModifiers())))
        {
          zza(paramStringBuilder, paramInt, zza((String)localObject1), zzez.zza((Method)localObject3, paramzzgh, new Object[0]));
          continue;
        }
      }
      if (((String)???).length() != 0) {
        localObject1 = "set".concat((String)???);
      } else {
        localObject1 = new String("set");
      }
      if ((Method)localHashMap2.get(localObject1) != null) {
        if (((String)???).endsWith("Bytes"))
        {
          localObject1 = String.valueOf(((String)???).substring(0, ((String)???).length() - 5));
          if (((String)localObject1).length() != 0) {
            localObject1 = "get".concat((String)localObject1);
          } else {
            localObject1 = new String("get");
          }
          if (localHashMap1.containsKey(localObject1)) {}
        }
        else
        {
          localObject3 = String.valueOf(((String)???).substring(0, 1).toLowerCase());
          localObject1 = String.valueOf(((String)???).substring(1));
          if (((String)localObject1).length() != 0) {
            localObject1 = ((String)localObject3).concat((String)localObject1);
          } else {
            localObject1 = new String((String)localObject3);
          }
          if (((String)???).length() != 0) {
            localObject3 = "get".concat((String)???);
          } else {
            localObject3 = new String("get");
          }
          localObject3 = (Method)localHashMap1.get(localObject3);
          if (((String)???).length() != 0) {
            ??? = "has".concat((String)???);
          } else {
            ??? = new String("has");
          }
          ??? = (Method)localHashMap1.get(???);
          if (localObject3 != null)
          {
            localObject3 = zzez.zza((Method)localObject3, paramzzgh, new Object[0]);
            if (??? == null)
            {
              if ((localObject3 instanceof Boolean)) {
                if (((Boolean)localObject3).booleanValue()) {}
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
                          if (!(localObject3 instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)localObject3).intValue() != 0);
                        break;
                        if (!(localObject3 instanceof Float)) {
                          break label857;
                        }
                      } while (((Float)localObject3).floatValue() != 0.0F);
                      break;
                      if (!(localObject3 instanceof Double)) {
                        break label881;
                      }
                    } while (((Double)localObject3).doubleValue() != 0.0D);
                    break;
                    if ((localObject3 instanceof String))
                    {
                      bool1 = localObject3.equals("");
                      break label970;
                    }
                    if ((localObject3 instanceof zzdv))
                    {
                      bool1 = localObject3.equals(zzdv.zza);
                      break label970;
                    }
                    if (!(localObject3 instanceof zzgh)) {
                      break label948;
                    }
                  } while (localObject3 != ((zzgh)localObject3).zzi());
                  break;
                } while ((!(localObject3 instanceof Enum)) || (((Enum)localObject3).ordinal() != 0));
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
              bool1 = ((Boolean)zzez.zza((Method)???, paramzzgh, new Object[0])).booleanValue();
            }
            if (bool1) {
              zza(paramStringBuilder, paramInt, zza((String)localObject1), localObject3);
            }
          }
        }
      }
    }
    if ((paramzzgh instanceof zzez.zze))
    {
      ??? = ((zzez.zze)paramzzgh).zzc.zzd();
      if (((Iterator)???).hasNext())
      {
        paramzzgh = (zzez.zzd)((Map.Entry)((Iterator)???).next()).getKey();
        throw new NoSuchMethodError();
      }
    }
    paramzzgh = ((zzez)paramzzgh).zzb;
    if (paramzzgh != null) {
      paramzzgh.zza(paramStringBuilder, paramInt);
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
      paramStringBuilder.append(zzhm.zza(zzdv.zza((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzdv))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzhm.zza((zzdv)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzez))
    {
      paramStringBuilder.append(" {");
      zza((zzez)paramObject, paramStringBuilder, paramInt + 2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */