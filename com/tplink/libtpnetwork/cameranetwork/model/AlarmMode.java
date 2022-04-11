package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public enum AlarmMode
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    SOUND localSOUND = new SOUND("SOUND", 0);
    SOUND = localSOUND;
    LIGHT localLIGHT = new LIGHT("LIGHT", 1);
    LIGHT = localLIGHT;
    $VALUES = new AlarmMode[] { localSOUND, localLIGHT };
  }
  
  private AlarmMode(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final AlarmMode fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public static final List<AlarmMode> fromStringList(List<String> paramList)
  {
    return Companion.fromStringList(paramList);
  }
  
  public final String getRaw()
  {
    return this.raw;
  }
  
  public static final class Companion
  {
    public final AlarmMode fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (AlarmMode localAlarmMode : AlarmMode.values()) {
        if (j.a(localAlarmMode.getRaw(), paramString)) {
          return localAlarmMode;
        }
      }
      paramString = null;
      return paramString;
    }
    
    public final List<AlarmMode> fromStringList(List<String> paramList)
    {
      j.e(paramList, "rawList");
      ArrayList localArrayList = new ArrayList(l.l(paramList, 10));
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        localArrayList.add(AlarmMode.Companion.fromString(paramList));
      }
      return localArrayList;
    }
  }
  
  static final class LIGHT
    extends AlarmMode
  {
    LIGHT(String paramString, int paramInt)
    {
      super(paramInt, "light", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
  
  static final class SOUND
    extends AlarmMode
  {
    SOUND(String paramString, int paramInt)
    {
      super(paramInt, "sound", null);
    }
    
    public String toString()
    {
      return getRaw();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AlarmMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */