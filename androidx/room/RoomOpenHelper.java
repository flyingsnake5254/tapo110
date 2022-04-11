package androidx.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import java.util.Iterator;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper
  extends SupportSQLiteOpenHelper.Callback
{
  @Nullable
  private DatabaseConfiguration mConfiguration;
  @NonNull
  private final Delegate mDelegate;
  @NonNull
  private final String mIdentityHash;
  @NonNull
  private final String mLegacyHash;
  
  public RoomOpenHelper(@NonNull DatabaseConfiguration paramDatabaseConfiguration, @NonNull Delegate paramDelegate, @NonNull String paramString)
  {
    this(paramDatabaseConfiguration, paramDelegate, "", paramString);
  }
  
  public RoomOpenHelper(@NonNull DatabaseConfiguration paramDatabaseConfiguration, @NonNull Delegate paramDelegate, @NonNull String paramString1, @NonNull String paramString2)
  {
    super(paramDelegate.version);
    this.mConfiguration = paramDatabaseConfiguration;
    this.mDelegate = paramDelegate;
    this.mIdentityHash = paramString1;
    this.mLegacyHash = paramString2;
  }
  
  private void checkIdentity(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    if (hasRoomMasterTable(paramSupportSQLiteDatabase))
    {
      localValidationResult = null;
      Cursor localCursor = paramSupportSQLiteDatabase.query(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
      paramSupportSQLiteDatabase = localValidationResult;
      try
      {
        if (localCursor.moveToFirst()) {
          paramSupportSQLiteDatabase = localCursor.getString(0);
        }
        localCursor.close();
        if ((this.mIdentityHash.equals(paramSupportSQLiteDatabase)) || (this.mLegacyHash.equals(paramSupportSQLiteDatabase))) {
          break label123;
        }
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
      }
      finally
      {
        localCursor.close();
      }
    }
    ValidationResult localValidationResult = this.mDelegate.onValidateSchema(paramSupportSQLiteDatabase);
    if (localValidationResult.isValid)
    {
      this.mDelegate.onPostMigrate(paramSupportSQLiteDatabase);
      updateIdentity(paramSupportSQLiteDatabase);
      label123:
      return;
    }
    paramSupportSQLiteDatabase = new StringBuilder();
    paramSupportSQLiteDatabase.append("Pre-packaged database has an invalid schema: ");
    paramSupportSQLiteDatabase.append(localValidationResult.expectedFoundMsg);
    throw new IllegalStateException(paramSupportSQLiteDatabase.toString());
  }
  
  private void createMasterTableIfNotExists(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    paramSupportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
  }
  
  private static boolean hasEmptySchema(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    Cursor localCursor = paramSupportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
    try
    {
      boolean bool1 = localCursor.moveToFirst();
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        int i = localCursor.getInt(0);
        bool3 = bool2;
        if (i == 0) {
          bool3 = true;
        }
      }
      return bool3;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private static boolean hasRoomMasterTable(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    Cursor localCursor = paramSupportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
    try
    {
      boolean bool1 = localCursor.moveToFirst();
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        int i = localCursor.getInt(0);
        bool3 = bool2;
        if (i != 0) {
          bool3 = true;
        }
      }
      return bool3;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private void updateIdentity(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    createMasterTableIfNotExists(paramSupportSQLiteDatabase);
    paramSupportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.mIdentityHash));
  }
  
  public void onConfigure(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    super.onConfigure(paramSupportSQLiteDatabase);
  }
  
  public void onCreate(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    boolean bool = hasEmptySchema(paramSupportSQLiteDatabase);
    this.mDelegate.createAllTables(paramSupportSQLiteDatabase);
    if (!bool)
    {
      ValidationResult localValidationResult = this.mDelegate.onValidateSchema(paramSupportSQLiteDatabase);
      if (!localValidationResult.isValid)
      {
        paramSupportSQLiteDatabase = new StringBuilder();
        paramSupportSQLiteDatabase.append("Pre-packaged database has an invalid schema: ");
        paramSupportSQLiteDatabase.append(localValidationResult.expectedFoundMsg);
        throw new IllegalStateException(paramSupportSQLiteDatabase.toString());
      }
    }
    updateIdentity(paramSupportSQLiteDatabase);
    this.mDelegate.onCreate(paramSupportSQLiteDatabase);
  }
  
  public void onDowngrade(SupportSQLiteDatabase paramSupportSQLiteDatabase, int paramInt1, int paramInt2)
  {
    onUpgrade(paramSupportSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onOpen(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    super.onOpen(paramSupportSQLiteDatabase);
    checkIdentity(paramSupportSQLiteDatabase);
    this.mDelegate.onOpen(paramSupportSQLiteDatabase);
    this.mConfiguration = null;
  }
  
  public void onUpgrade(SupportSQLiteDatabase paramSupportSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Object localObject = this.mConfiguration;
    if (localObject != null)
    {
      localObject = ((DatabaseConfiguration)localObject).migrationContainer.findMigrationPath(paramInt1, paramInt2);
      if (localObject != null)
      {
        this.mDelegate.onPreMigrate(paramSupportSQLiteDatabase);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Migration)((Iterator)localObject).next()).migrate(paramSupportSQLiteDatabase);
        }
        localObject = this.mDelegate.onValidateSchema(paramSupportSQLiteDatabase);
        if (((ValidationResult)localObject).isValid)
        {
          this.mDelegate.onPostMigrate(paramSupportSQLiteDatabase);
          updateIdentity(paramSupportSQLiteDatabase);
          i = 1;
          break label149;
        }
        paramSupportSQLiteDatabase = new StringBuilder();
        paramSupportSQLiteDatabase.append("Migration didn't properly handle: ");
        paramSupportSQLiteDatabase.append(((ValidationResult)localObject).expectedFoundMsg);
        throw new IllegalStateException(paramSupportSQLiteDatabase.toString());
      }
    }
    int i = 0;
    label149:
    if (i == 0)
    {
      localObject = this.mConfiguration;
      if ((localObject != null) && (!((DatabaseConfiguration)localObject).isMigrationRequired(paramInt1, paramInt2)))
      {
        this.mDelegate.dropAllTables(paramSupportSQLiteDatabase);
        this.mDelegate.createAllTables(paramSupportSQLiteDatabase);
      }
      else
      {
        paramSupportSQLiteDatabase = new StringBuilder();
        paramSupportSQLiteDatabase.append("A migration from ");
        paramSupportSQLiteDatabase.append(paramInt1);
        paramSupportSQLiteDatabase.append(" to ");
        paramSupportSQLiteDatabase.append(paramInt2);
        paramSupportSQLiteDatabase.append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        throw new IllegalStateException(paramSupportSQLiteDatabase.toString());
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static abstract class Delegate
  {
    public final int version;
    
    public Delegate(int paramInt)
    {
      this.version = paramInt;
    }
    
    protected abstract void createAllTables(SupportSQLiteDatabase paramSupportSQLiteDatabase);
    
    protected abstract void dropAllTables(SupportSQLiteDatabase paramSupportSQLiteDatabase);
    
    protected abstract void onCreate(SupportSQLiteDatabase paramSupportSQLiteDatabase);
    
    protected abstract void onOpen(SupportSQLiteDatabase paramSupportSQLiteDatabase);
    
    protected void onPostMigrate(SupportSQLiteDatabase paramSupportSQLiteDatabase) {}
    
    protected void onPreMigrate(SupportSQLiteDatabase paramSupportSQLiteDatabase) {}
    
    @NonNull
    protected RoomOpenHelper.ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      validateMigration(paramSupportSQLiteDatabase);
      return new RoomOpenHelper.ValidationResult(true, null);
    }
    
    @Deprecated
    protected void validateMigration(SupportSQLiteDatabase paramSupportSQLiteDatabase)
    {
      throw new UnsupportedOperationException("validateMigration is deprecated");
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static class ValidationResult
  {
    @Nullable
    public final String expectedFoundMsg;
    public final boolean isValid;
    
    public ValidationResult(boolean paramBoolean, @Nullable String paramString)
    {
      this.isValid = paramBoolean;
      this.expectedFoundMsg = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\RoomOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */