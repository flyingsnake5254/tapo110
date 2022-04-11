package com.jcraft.jsch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.Vector;

public class OpenSSHConfig
  implements ConfigRepository
{
  private static final Hashtable keymap;
  private final Hashtable config = new Hashtable();
  private final Vector hosts = new Vector();
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    keymap = localHashtable;
    localHashtable.put("kex", "KexAlgorithms");
    localHashtable.put("server_host_key", "HostKeyAlgorithms");
    localHashtable.put("cipher.c2s", "Ciphers");
    localHashtable.put("cipher.s2c", "Ciphers");
    localHashtable.put("mac.c2s", "Macs");
    localHashtable.put("mac.s2c", "Macs");
    localHashtable.put("compression.s2c", "Compression");
    localHashtable.put("compression.c2s", "Compression");
    localHashtable.put("compression_level", "CompressionLevel");
    localHashtable.put("MaxAuthTries", "NumberOfPasswordPrompts");
  }
  
  OpenSSHConfig(Reader paramReader)
    throws IOException
  {
    _parse(paramReader);
  }
  
  private void _parse(Reader paramReader)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(paramReader);
    Vector localVector = new Vector();
    paramReader = "";
    for (;;)
    {
      Object localObject = localBufferedReader.readLine();
      if (localObject == null) {
        break;
      }
      localObject = ((String)localObject).trim();
      if ((((String)localObject).length() != 0) && (!((String)localObject).startsWith("#")))
      {
        localObject = ((String)localObject).split("[= \t]", 2);
        for (int i = 0; i < localObject.length; i++) {
          localObject[i] = localObject[i].trim();
        }
        if (localObject.length > 1) {
          if (localObject[0].equals("Host"))
          {
            this.config.put(paramReader, localVector);
            this.hosts.addElement(paramReader);
            paramReader = localObject[1];
            localVector = new Vector();
          }
          else
          {
            localVector.addElement(localObject);
          }
        }
      }
    }
    this.config.put(paramReader, localVector);
    this.hosts.addElement(paramReader);
  }
  
  public static OpenSSHConfig parse(String paramString)
    throws IOException
  {
    paramString = new StringReader(paramString);
    try
    {
      OpenSSHConfig localOpenSSHConfig = new OpenSSHConfig(paramString);
      return localOpenSSHConfig;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static OpenSSHConfig parseFile(String paramString)
    throws IOException
  {
    paramString = new FileReader(Util.checkTilde(paramString));
    try
    {
      OpenSSHConfig localOpenSSHConfig = new OpenSSHConfig(paramString);
      return localOpenSSHConfig;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public ConfigRepository.Config getConfig(String paramString)
  {
    return new MyConfig(paramString);
  }
  
  class MyConfig
    implements ConfigRepository.Config
  {
    private Vector _configs;
    private String host;
    
    MyConfig(String paramString)
    {
      Object localObject = new Vector();
      this._configs = ((Vector)localObject);
      this.host = paramString;
      ((Vector)localObject).addElement(OpenSSHConfig.this.config.get(""));
      localObject = Util.str2byte(paramString);
      if (OpenSSHConfig.this.hosts.size() > 1) {
        for (int i = 1; i < OpenSSHConfig.this.hosts.size(); i++)
        {
          String[] arrayOfString = ((String)OpenSSHConfig.this.hosts.elementAt(i)).split("[ \t]");
          for (int j = 0; j < arrayOfString.length; j++)
          {
            paramString = arrayOfString[j].trim();
            int k;
            if (paramString.startsWith("!"))
            {
              paramString = paramString.substring(1).trim();
              k = 1;
            }
            else
            {
              k = 0;
            }
            if (Util.glob(Util.str2byte(paramString), (byte[])localObject))
            {
              if (k == 0) {
                this._configs.addElement(OpenSSHConfig.this.config.get((String)OpenSSHConfig.this.hosts.elementAt(i)));
              }
            }
            else if (k != 0) {
              this._configs.addElement(OpenSSHConfig.this.config.get((String)OpenSSHConfig.this.hosts.elementAt(i)));
            }
          }
        }
      }
    }
    
    private String find(String paramString)
    {
      Object localObject = paramString;
      if (OpenSSHConfig.keymap.get(paramString) != null) {
        localObject = (String)OpenSSHConfig.keymap.get(paramString);
      }
      String str = ((String)localObject).toUpperCase();
      paramString = null;
      int i = 0;
      for (;;)
      {
        localObject = paramString;
        if (i >= this._configs.size()) {
          break;
        }
        Vector localVector = (Vector)this._configs.elementAt(i);
        for (int j = 0;; j++)
        {
          localObject = paramString;
          if (j >= localVector.size()) {
            break;
          }
          localObject = (String[])localVector.elementAt(j);
          if (localObject[0].toUpperCase().equals(str))
          {
            localObject = localObject[1];
            break;
          }
        }
        if (localObject != null) {
          break;
        }
        i++;
        paramString = (String)localObject;
      }
      return (String)localObject;
    }
    
    private String[] multiFind(String paramString)
    {
      Object localObject1 = paramString.toUpperCase();
      paramString = new Vector();
      for (int i = 0; i < this._configs.size(); i++)
      {
        Vector localVector = (Vector)this._configs.elementAt(i);
        for (int j = 0; j < localVector.size(); j++)
        {
          Object localObject2 = (String[])localVector.elementAt(j);
          if (localObject2[0].toUpperCase().equals(localObject1))
          {
            localObject2 = localObject2[1];
            if (localObject2 != null)
            {
              paramString.remove(localObject2);
              paramString.addElement(localObject2);
            }
          }
        }
      }
      localObject1 = new String[paramString.size()];
      paramString.toArray((Object[])localObject1);
      return (String[])localObject1;
    }
    
    public String getHostname()
    {
      return find("Hostname");
    }
    
    public int getPort()
    {
      String str = find("Port");
      int i;
      try
      {
        i = Integer.parseInt(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i = -1;
      }
      return i;
    }
    
    public String getUser()
    {
      return find("User");
    }
    
    public String getValue(String paramString)
    {
      if ((!paramString.equals("compression.s2c")) && (!paramString.equals("compression.c2s"))) {
        return find(paramString);
      }
      paramString = find(paramString);
      if ((paramString != null) && (!paramString.equals("no"))) {
        return "zlib@openssh.com,zlib,none";
      }
      return "none,zlib@openssh.com,zlib";
    }
    
    public String[] getValues(String paramString)
    {
      return multiFind(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\OpenSSHConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */