package com.jcraft.jsch;

public abstract interface HostKeyRepository
{
  public static final int CHANGED = 2;
  public static final int NOT_INCLUDED = 1;
  public static final int OK = 0;
  
  public abstract void add(HostKey paramHostKey, UserInfo paramUserInfo);
  
  public abstract int check(String paramString, byte[] paramArrayOfByte);
  
  public abstract HostKey[] getHostKey();
  
  public abstract HostKey[] getHostKey(String paramString1, String paramString2);
  
  public abstract String getKnownHostsRepositoryID();
  
  public abstract void remove(String paramString1, String paramString2);
  
  public abstract void remove(String paramString1, String paramString2, byte[] paramArrayOfByte);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\HostKeyRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */