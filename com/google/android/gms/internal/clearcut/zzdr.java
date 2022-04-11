package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzdr
{
  static String zza(zzdo paramzzdo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    zza(paramzzdo, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  private static void zza(zzdo paramzzdo, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject3;
    for (localObject3 : paramzzdo.getClass().getDeclaredMethods())
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
      localObject3 = "";
      Object localObject4 = ((String)localObject1).replaceFirst("get", "");
      boolean bool1 = ((String)localObject4).endsWith("List");
      boolean bool2 = true;
      Object localObject5;
      if ((bool1) && (!((String)localObject4).endsWith("OrBuilderList")) && (!((String)localObject4).equals("List")))
      {
        ??? = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject5 = String.valueOf(((String)localObject4).substring(1, ((String)localObject4).length() - 4));
        if (((String)localObject5).length() != 0) {
          ??? = ((String)???).concat((String)localObject5);
        } else {
          ??? = new String((String)???);
        }
        localObject5 = (Method)localHashMap1.get(localObject1);
        if ((localObject5 != null) && (((Method)localObject5).getReturnType().equals(List.class)))
        {
          zza(paramStringBuilder, paramInt, zzj((String)???), zzcg.zza((Method)localObject5, paramzzdo, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject4).endsWith("Map")) && (!((String)localObject4).equals("Map")))
      {
        ??? = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject5 = String.valueOf(((String)localObject4).substring(1, ((String)localObject4).length() - 3));
        if (((String)localObject5).length() != 0) {
          ??? = ((String)???).concat((String)localObject5);
        } else {
          ??? = new String((String)???);
        }
        localObject1 = (Method)localHashMap1.get(localObject1);
        if ((localObject1 != null) && (((Method)localObject1).getReturnType().equals(Map.class)) && (!((Method)localObject1).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject1).getModifiers())))
        {
          zza(paramStringBuilder, paramInt, zzj((String)???), zzcg.zza((Method)localObject1, paramzzdo, new Object[0]));
          continue;
        }
      }
      if (((String)localObject4).length() != 0) {
        ??? = "set".concat((String)localObject4);
      } else {
        ??? = new String("set");
      }
      if ((Method)localHashMap2.get(???) != null) {
        if (((String)localObject4).endsWith("Bytes"))
        {
          ??? = String.valueOf(((String)localObject4).substring(0, ((String)localObject4).length() - 5));
          if (((String)???).length() != 0) {
            ??? = "get".concat((String)???);
          } else {
            ??? = new String("get");
          }
          if (localHashMap1.containsKey(???)) {}
        }
        else
        {
          ??? = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
          localObject1 = String.valueOf(((String)localObject4).substring(1));
          if (((String)localObject1).length() != 0) {
            ??? = ((String)???).concat((String)localObject1);
          } else {
            ??? = new String((String)???);
          }
          if (((String)localObject4).length() != 0) {
            localObject1 = "get".concat((String)localObject4);
          } else {
            localObject1 = new String("get");
          }
          localObject5 = (Method)localHashMap1.get(localObject1);
          if (((String)localObject4).length() != 0) {
            localObject1 = "has".concat((String)localObject4);
          } else {
            localObject1 = new String("has");
          }
          localObject1 = (Method)localHashMap1.get(localObject1);
          if (localObject5 != null)
          {
            localObject4 = zzcg.zza((Method)localObject5, paramzzdo, new Object[0]);
            if (localObject1 == null)
            {
              if ((localObject4 instanceof Boolean)) {
                if (((Boolean)localObject4).booleanValue()) {}
              }
              for (;;)
              {
                bool1 = true;
                break;
                label847:
                label871:
                label937:
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
                          break label959;
                          if (!(localObject4 instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)localObject4).intValue() != 0);
                        break;
                        if (!(localObject4 instanceof Float)) {
                          break label847;
                        }
                      } while (((Float)localObject4).floatValue() != 0.0F);
                      break;
                      if (!(localObject4 instanceof Double)) {
                        break label871;
                      }
                    } while (((Double)localObject4).doubleValue() != 0.0D);
                    break;
                    if ((localObject4 instanceof String)) {}
                    for (localObject1 = localObject3;; localObject1 = zzbb.zzfi)
                    {
                      bool1 = localObject4.equals(localObject1);
                      break label959;
                      if (!(localObject4 instanceof zzbb)) {
                        break;
                      }
                    }
                    if (!(localObject4 instanceof zzdo)) {
                      break label937;
                    }
                  } while (localObject4 != ((zzdo)localObject4).zzbe());
                  break;
                } while ((!(localObject4 instanceof Enum)) || (((Enum)localObject4).ordinal() != 0));
              }
              label959:
              if (!bool1) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
            else
            {
              bool1 = ((Boolean)zzcg.zza((Method)localObject1, paramzzdo, new Object[0])).booleanValue();
            }
            if (bool1) {
              zza(paramStringBuilder, paramInt, zzj((String)???), localObject4);
            }
          }
        }
      }
    }
    if ((paramzzdo instanceof zzcg.zzd))
    {
      ??? = ((zzcg.zzd)paramzzdo).zzjv.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)???).next();
        ??? = ((zzcg.zze)((Map.Entry)localObject3).getKey()).number;
        localObject1 = new StringBuilder(13);
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(???);
        ((StringBuilder)localObject1).append("]");
        zza(paramStringBuilder, paramInt, ((StringBuilder)localObject1).toString(), ((Map.Entry)localObject3).getValue());
      }
    }
    paramzzdo = ((zzcg)paramzzdo).zzjp;
    if (paramzzdo != null) {
      paramzzdo.zza(paramStringBuilder, paramInt);
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
      paramStringBuilder.append(zzet.zzc(zzbb.zzf((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzbb))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzet.zzc((zzbb)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzcg))
    {
      paramStringBuilder.append(" {");
      zza((zzcg)paramObject, paramStringBuilder, paramInt + 2);
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
  
  private static final String zzj(String paramString)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */