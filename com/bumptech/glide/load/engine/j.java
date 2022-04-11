package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class j
{
  public static final j a = new a();
  public static final j b = new b();
  public static final j c = new c();
  public static final j d = new d();
  public static final j e = new e();
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract boolean c(DataSource paramDataSource);
  
  public abstract boolean d(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy);
  
  class a
    extends j
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean b()
    {
      return true;
    }
    
    public boolean c(DataSource paramDataSource)
    {
      boolean bool;
      if (paramDataSource == DataSource.REMOTE) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean d(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy)
    {
      if ((paramDataSource != DataSource.RESOURCE_DISK_CACHE) && (paramDataSource != DataSource.MEMORY_CACHE)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
  }
  
  class b
    extends j
  {
    public boolean a()
    {
      return false;
    }
    
    public boolean b()
    {
      return false;
    }
    
    public boolean c(DataSource paramDataSource)
    {
      return false;
    }
    
    public boolean d(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy)
    {
      return false;
    }
  }
  
  class c
    extends j
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean b()
    {
      return false;
    }
    
    public boolean c(DataSource paramDataSource)
    {
      boolean bool;
      if ((paramDataSource != DataSource.DATA_DISK_CACHE) && (paramDataSource != DataSource.MEMORY_CACHE)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean d(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy)
    {
      return false;
    }
  }
  
  class d
    extends j
  {
    public boolean a()
    {
      return false;
    }
    
    public boolean b()
    {
      return true;
    }
    
    public boolean c(DataSource paramDataSource)
    {
      return false;
    }
    
    public boolean d(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy)
    {
      if ((paramDataSource != DataSource.RESOURCE_DISK_CACHE) && (paramDataSource != DataSource.MEMORY_CACHE)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
  }
  
  class e
    extends j
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean b()
    {
      return true;
    }
    
    public boolean c(DataSource paramDataSource)
    {
      boolean bool;
      if (paramDataSource == DataSource.REMOTE) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean d(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy)
    {
      if (((paramBoolean) && (paramDataSource == DataSource.DATA_DISK_CACHE)) || ((paramDataSource == DataSource.LOCAL) && (paramEncodeStrategy == EncodeStrategy.TRANSFORMED))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */