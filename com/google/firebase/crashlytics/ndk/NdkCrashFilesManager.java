package com.google.firebase.crashlytics.ndk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

class NdkCrashFilesManager
  implements CrashFilesManager
{
  private static final Comparator<? super File> LATEST_SESSION_FIRST = c.c;
  private static final int MAX_SESSIONS = 8;
  private final File rootPath;
  
  NdkCrashFilesManager(File paramFile)
  {
    this.rootPath = paramFile;
  }
  
  @Nullable
  private static File prepareDirectory(File paramFile)
  {
    if ((paramFile != null) && ((paramFile.exists()) || (paramFile.mkdirs()))) {
      return paramFile;
    }
    return null;
  }
  
  private static void recursiveDelete(@NonNull File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        recursiveDelete(arrayOfFile[j]);
      }
    }
    paramFile.delete();
  }
  
  public void cleanOldSessionFileDirectories()
  {
    File[] arrayOfFile = this.rootPath.listFiles(a.c);
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      int j = 8;
      if (i > 8)
      {
        Arrays.sort(arrayOfFile, LATEST_SESSION_FIRST);
        while (j < arrayOfFile.length)
        {
          recursiveDelete(arrayOfFile[j]);
          j++;
        }
      }
    }
  }
  
  public void deleteSessionFileDirectory(String paramString)
  {
    recursiveDelete(new File(this.rootPath, paramString));
  }
  
  public File getSessionFileDirectory(String paramString)
  {
    return prepareDirectory(new File(this.rootPath, paramString));
  }
  
  public boolean hasSessionFileDirectory(String paramString)
  {
    return new File(this.rootPath, paramString).exists();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\NdkCrashFilesManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */