package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class DefaultSpdySettingsFrame
  implements SpdySettingsFrame
{
  private boolean clear;
  private final Map<Integer, Setting> settingsMap = new TreeMap();
  
  private void appendSettings(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = getSettings().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Setting localSetting = (Setting)localEntry.getValue();
      paramStringBuilder.append("--> ");
      paramStringBuilder.append(localEntry.getKey());
      paramStringBuilder.append(':');
      paramStringBuilder.append(localSetting.getValue());
      paramStringBuilder.append(" (persist value: ");
      paramStringBuilder.append(localSetting.isPersist());
      paramStringBuilder.append("; persisted: ");
      paramStringBuilder.append(localSetting.isPersisted());
      paramStringBuilder.append(')');
      paramStringBuilder.append(StringUtil.NEWLINE);
    }
  }
  
  private Set<Map.Entry<Integer, Setting>> getSettings()
  {
    return this.settingsMap.entrySet();
  }
  
  public boolean clearPreviouslyPersistedSettings()
  {
    return this.clear;
  }
  
  public int getValue(int paramInt)
  {
    Setting localSetting = (Setting)this.settingsMap.get(Integer.valueOf(paramInt));
    if (localSetting != null) {
      paramInt = localSetting.getValue();
    } else {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public Set<Integer> ids()
  {
    return this.settingsMap.keySet();
  }
  
  public boolean isPersistValue(int paramInt)
  {
    Setting localSetting = (Setting)this.settingsMap.get(Integer.valueOf(paramInt));
    boolean bool;
    if ((localSetting != null) && (localSetting.isPersist())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isPersisted(int paramInt)
  {
    Setting localSetting = (Setting)this.settingsMap.get(Integer.valueOf(paramInt));
    boolean bool;
    if ((localSetting != null) && (localSetting.isPersisted())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSet(int paramInt)
  {
    return this.settingsMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public SpdySettingsFrame removeValue(int paramInt)
  {
    this.settingsMap.remove(Integer.valueOf(paramInt));
    return this;
  }
  
  public SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean paramBoolean)
  {
    this.clear = paramBoolean;
    return this;
  }
  
  public SpdySettingsFrame setPersistValue(int paramInt, boolean paramBoolean)
  {
    Setting localSetting = (Setting)this.settingsMap.get(Integer.valueOf(paramInt));
    if (localSetting != null) {
      localSetting.setPersist(paramBoolean);
    }
    return this;
  }
  
  public SpdySettingsFrame setPersisted(int paramInt, boolean paramBoolean)
  {
    Setting localSetting = (Setting)this.settingsMap.get(Integer.valueOf(paramInt));
    if (localSetting != null) {
      localSetting.setPersisted(paramBoolean);
    }
    return this;
  }
  
  public SpdySettingsFrame setValue(int paramInt1, int paramInt2)
  {
    return setValue(paramInt1, paramInt2, false, false);
  }
  
  public SpdySettingsFrame setValue(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= 16777215))
    {
      localObject = Integer.valueOf(paramInt1);
      Setting localSetting = (Setting)this.settingsMap.get(localObject);
      if (localSetting != null)
      {
        localSetting.setValue(paramInt2);
        localSetting.setPersist(paramBoolean1);
        localSetting.setPersisted(paramBoolean2);
      }
      else
      {
        this.settingsMap.put(localObject, new Setting(paramInt2, paramBoolean1, paramBoolean2));
      }
      return this;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Setting ID is not valid: ");
    ((StringBuilder)localObject).append(paramInt1);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    String str = StringUtil.NEWLINE;
    localStringBuilder.append(str);
    appendSettings(localStringBuilder);
    localStringBuilder.setLength(localStringBuilder.length() - str.length());
    return localStringBuilder.toString();
  }
  
  private static final class Setting
  {
    private boolean persist;
    private boolean persisted;
    private int value;
    
    Setting(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.value = paramInt;
      this.persist = paramBoolean1;
      this.persisted = paramBoolean2;
    }
    
    int getValue()
    {
      return this.value;
    }
    
    boolean isPersist()
    {
      return this.persist;
    }
    
    boolean isPersisted()
    {
      return this.persisted;
    }
    
    void setPersist(boolean paramBoolean)
    {
      this.persist = paramBoolean;
    }
    
    void setPersisted(boolean paramBoolean)
    {
      this.persisted = paramBoolean;
    }
    
    void setValue(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdySettingsFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */