package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration
{
  public final int endVersion;
  public final int startVersion;
  
  public Migration(int paramInt1, int paramInt2)
  {
    this.startVersion = paramInt1;
    this.endVersion = paramInt2;
  }
  
  public abstract void migrate(@NonNull SupportSQLiteDatabase paramSupportSQLiteDatabase);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\migration\Migration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */