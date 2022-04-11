package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzhp
{
  static String zza(zzhk paramzzhk, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    zza(paramzzhk, localStringBuilder, 0);
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
  
  private static void zza(zzhk paramzzhk, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject3;
    for (localObject3 : paramzzhk.getClass().getDeclaredMethods())
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
      ??? = (String)localIterator.next();
      if (((String)???).startsWith("get")) {
        localObject3 = ((String)???).substring(3);
      } else {
        localObject3 = ???;
      }
      boolean bool1 = ((String)localObject3).endsWith("List");
      boolean bool2 = true;
      Object localObject4;
      if ((bool1) && (!((String)localObject3).endsWith("OrBuilderList")) && (!((String)localObject3).equals("List")))
      {
        localObject1 = String.valueOf(((String)localObject3).substring(0, 1).toLowerCase());
        localObject4 = String.valueOf(((String)localObject3).substring(1, ((String)localObject3).length() - 4));
        if (((String)localObject4).length() != 0) {
          localObject1 = ((String)localObject1).concat((String)localObject4);
        } else {
          localObject1 = new String((String)localObject1);
        }
        localObject4 = (Method)localHashMap1.get(???);
        if ((localObject4 != null) && (((Method)localObject4).getReturnType().equals(List.class)))
        {
          zza(paramStringBuilder, paramInt, zza((String)localObject1), zzga.zza((Method)localObject4, paramzzhk, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject3).endsWith("Map")) && (!((String)localObject3).equals("Map")))
      {
        localObject4 = String.valueOf(((String)localObject3).substring(0, 1).toLowerCase());
        localObject1 = String.valueOf(((String)localObject3).substring(1, ((String)localObject3).length() - 3));
        if (((String)localObject1).length() != 0) {
          localObject1 = ((String)localObject4).concat((String)localObject1);
        } else {
          localObject1 = new String((String)localObject4);
        }
        ??? = (Method)localHashMap1.get(???);
        if ((??? != null) && (((Method)???).getReturnType().equals(Map.class)) && (!((Method)???).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)???).getModifiers())))
        {
          zza(paramStringBuilder, paramInt, zza((String)localObject1), zzga.zza((Method)???, paramzzhk, new Object[0]));
          continue;
        }
      }
      if (((String)localObject3).length() != 0) {
        localObject1 = "set".concat((String)localObject3);
      } else {
        localObject1 = new String("set");
      }
      if ((Method)localHashMap2.get(localObject1) != null) {
        if (((String)localObject3).endsWith("Bytes"))
        {
          localObject1 = String.valueOf(((String)localObject3).substring(0, ((String)localObject3).length() - 5));
          if (((String)localObject1).length() != 0) {
            localObject1 = "get".concat((String)localObject1);
          } else {
            localObject1 = new String("get");
          }
          if (localHashMap1.containsKey(localObject1)) {}
        }
        else
        {
          ??? = String.valueOf(((String)localObject3).substring(0, 1).toLowerCase());
          localObject1 = String.valueOf(((String)localObject3).substring(1));
          if (((String)localObject1).length() != 0) {
            localObject1 = ((String)???).concat((String)localObject1);
          } else {
            localObject1 = new String((String)???);
          }
          if (((String)localObject3).length() != 0) {
            ??? = "get".concat((String)localObject3);
          } else {
            ??? = new String("get");
          }
          ??? = (Method)localHashMap1.get(???);
          if (((String)localObject3).length() != 0) {
            localObject3 = "has".concat((String)localObject3);
          } else {
            localObject3 = new String("has");
          }
          localObject3 = (Method)localHashMap1.get(localObject3);
          if (??? != null)
          {
            ??? = zzga.zza((Method)???, paramzzhk, new Object[0]);
            if (localObject3 == null)
            {
              if ((??? instanceof Boolean)) {
                if (((Boolean)???).booleanValue()) {}
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
                          if (!(??? instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)???).intValue() != 0);
                        break;
                        if (!(??? instanceof Float)) {
                          break label857;
                        }
                      } while (((Float)???).floatValue() != 0.0F);
                      break;
                      if (!(??? instanceof Double)) {
                        break label881;
                      }
                    } while (((Double)???).doubleValue() != 0.0D);
                    break;
                    if ((??? instanceof String))
                    {
                      bool1 = ???.equals("");
                      break label970;
                    }
                    if ((??? instanceof zzew))
                    {
                      bool1 = ???.equals(zzew.zza);
                      break label970;
                    }
                    if (!(??? instanceof zzhk)) {
                      break label948;
                    }
                  } while (??? != ((zzhk)???).zzo());
                  break;
                } while ((!(??? instanceof Enum)) || (((Enum)???).ordinal() != 0));
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
              bool1 = ((Boolean)zzga.zza((Method)localObject3, paramzzhk, new Object[0])).booleanValue();
            }
            if (bool1) {
              zza(paramStringBuilder, paramInt, zza((String)localObject1), ???);
            }
          }
        }
      }
    }
    if ((paramzzhk instanceof zzga.zzc))
    {
      localObject3 = ((zzga.zzc)paramzzhk).zzc.zzd();
      if (((Iterator)localObject3).hasNext())
      {
        paramzzhk = (zzga.zzf)((Map.Entry)((Iterator)localObject3).next()).getKey();
        throw new NoSuchMethodError();
      }
    }
    paramzzhk = ((zzga)paramzzhk).zzb;
    if (paramzzhk != null) {
      paramzzhk.zza(paramStringBuilder, paramInt);
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
      paramStringBuilder.append(zzip.zza(zzew.zza((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzew))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzip.zza((zzew)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzga))
    {
      paramStringBuilder.append(" {");
      zza((zzga)paramObject, paramStringBuilder, paramInt + 2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */