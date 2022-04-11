package com.tplink.libtpanalytics.database.e;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.tplink.libtpanalytics.database.d.b;
import java.util.List;

@Dao
public abstract interface c
{
  @Query("DELETE FROM EVENT")
  public abstract void a();
  
  @Delete
  public abstract void b(List<b> paramList);
  
  @Insert(onConflict=1)
  public abstract void c(b... paramVarArgs);
  
  @Query("SELECT count(*) FROM EVENT")
  public abstract int count();
  
  @Query("SELECT * FROM EVENT WHERE EVENT_ID IN (:ids)")
  public abstract List<b> d(List<String> paramList);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */