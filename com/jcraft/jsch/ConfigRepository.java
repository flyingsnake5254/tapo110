package com.jcraft.jsch;

public abstract interface ConfigRepository
{
  public static final Config defaultConfig = new Config()
  {
    public String getHostname()
    {
      return null;
    }
    
    public int getPort()
    {
      return -1;
    }
    
    public String getUser()
    {
      return null;
    }
    
    public String getValue(String paramAnonymousString)
    {
      return null;
    }
    
    public String[] getValues(String paramAnonymousString)
    {
      return null;
    }
  };
  public static final ConfigRepository nullConfig = new ConfigRepository()
  {
    public ConfigRepository.Config getConfig(String paramAnonymousString)
    {
      return ConfigRepository.defaultConfig;
    }
  };
  
  public abstract Config getConfig(String paramString);
  
  public static abstract interface Config
  {
    public abstract String getHostname();
    
    public abstract int getPort();
    
    public abstract String getUser();
    
    public abstract String getValue(String paramString);
    
    public abstract String[] getValues(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ConfigRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */