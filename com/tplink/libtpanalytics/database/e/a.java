package com.tplink.libtpanalytics.database.e;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public abstract interface a
{
  @Query("DELETE FROM ENCRYPT")
  public abstract void a();
  
  @Insert(onConflict=1)
  public abstract void b(com.tplink.libtpanalytics.database.d.a... paramVarArgs);
  
  @Query("SELECT * FROM ENCRYPT")
  public abstract List<com.tplink.libtpanalytics.database.d.a> c();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */