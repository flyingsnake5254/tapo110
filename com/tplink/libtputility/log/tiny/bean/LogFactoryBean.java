package com.tplink.libtputility.log.tiny.bean;

import com.google.gson.Gson;
import com.google.gson.q.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogFactoryBean
{
  @c("block_list")
  private List<a> blockList = new ArrayList();
  @c("compaction_algorithm")
  private String compactionAlgorithm;
  @c("encrypt_type")
  private String encryptType;
  
  public LogFactoryBean() {}
  
  public LogFactoryBean(List<a> paramList)
  {
    this.encryptType = "aes-ecb";
    this.compactionAlgorithm = "zlib";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if ((locala.h() != null) && (locala.g() > 0))
      {
        a locala1 = new a();
        locala1.a(locala.e());
        locala1.b(locala.g());
        this.blockList.add(locala1);
      }
    }
  }
  
  public List<a> getBlockList()
  {
    return this.blockList;
  }
  
  public String getCompactionAlgorithm()
  {
    return this.compactionAlgorithm;
  }
  
  public String getEncryptType()
  {
    return this.encryptType;
  }
  
  public void setBlockList(List<a> paramList)
  {
    this.blockList = paramList;
  }
  
  public void setCompactionAlgorithm(String paramString)
  {
    this.compactionAlgorithm = paramString;
  }
  
  public void setEncryptType(String paramString)
  {
    this.encryptType = paramString;
  }
  
  public byte[] toJsonByte()
  {
    try
    {
      Object localObject = new com/google/gson/Gson;
      ((Gson)localObject).<init>();
      localObject = ((Gson)localObject).u(this).getBytes("UTF-8");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  public static class a
  {
    @c("encrypt_key")
    private String a;
    @c("length")
    private long b;
    
    public void a(String paramString)
    {
      this.a = paramString;
    }
    
    public void b(long paramLong)
    {
      this.b = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\log\tiny\bean\LogFactoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */