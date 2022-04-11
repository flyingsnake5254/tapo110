package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile
  extends DocumentFile
{
  private File mFile;
  
  RawDocumentFile(@Nullable DocumentFile paramDocumentFile, File paramFile)
  {
    super(paramDocumentFile);
    this.mFile = paramFile;
  }
  
  private static boolean deleteContents(File paramFile)
  {
    paramFile = paramFile.listFiles();
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramFile != null)
    {
      int i = paramFile.length;
      for (int j = 0;; j++)
      {
        bool1 = bool2;
        if (j >= i) {
          break;
        }
        File localFile = paramFile[j];
        bool1 = bool2;
        if (localFile.isDirectory()) {
          bool1 = bool2 & deleteContents(localFile);
        }
        bool2 = bool1;
        if (!localFile.delete())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to delete ");
          localStringBuilder.append(localFile);
          Log.w("DocumentFile", localStringBuilder.toString());
          bool2 = false;
        }
      }
    }
    return bool1;
  }
  
  private static String getTypeForName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i >= 0)
    {
      paramString = paramString.substring(i + 1).toLowerCase();
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return "application/octet-stream";
  }
  
  public boolean canRead()
  {
    return this.mFile.canRead();
  }
  
  public boolean canWrite()
  {
    return this.mFile.canWrite();
  }
  
  @Nullable
  public DocumentFile createDirectory(String paramString)
  {
    paramString = new File(this.mFile, paramString);
    if ((!paramString.isDirectory()) && (!paramString.mkdir())) {
      return null;
    }
    return new RawDocumentFile(this, paramString);
  }
  
  @Nullable
  public DocumentFile createFile(String paramString1, String paramString2)
  {
    String str = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString1);
    paramString1 = paramString2;
    if (str != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(".");
      paramString1.append(str);
      paramString1 = paramString1.toString();
    }
    paramString1 = new File(this.mFile, paramString1);
    try
    {
      paramString1.createNewFile();
      paramString1 = new RawDocumentFile(this, paramString1);
      return paramString1;
    }
    catch (IOException paramString2)
    {
      paramString1 = new StringBuilder();
      paramString1.append("Failed to createFile: ");
      paramString1.append(paramString2);
      Log.w("DocumentFile", paramString1.toString());
    }
    return null;
  }
  
  public boolean delete()
  {
    deleteContents(this.mFile);
    return this.mFile.delete();
  }
  
  public boolean exists()
  {
    return this.mFile.exists();
  }
  
  public String getName()
  {
    return this.mFile.getName();
  }
  
  @Nullable
  public String getType()
  {
    if (this.mFile.isDirectory()) {
      return null;
    }
    return getTypeForName(this.mFile.getName());
  }
  
  public Uri getUri()
  {
    return Uri.fromFile(this.mFile);
  }
  
  public boolean isDirectory()
  {
    return this.mFile.isDirectory();
  }
  
  public boolean isFile()
  {
    return this.mFile.isFile();
  }
  
  public boolean isVirtual()
  {
    return false;
  }
  
  public long lastModified()
  {
    return this.mFile.lastModified();
  }
  
  public long length()
  {
    return this.mFile.length();
  }
  
  public DocumentFile[] listFiles()
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = this.mFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        localArrayList.add(new RawDocumentFile(this, arrayOfFile[j]));
      }
    }
    return (DocumentFile[])localArrayList.toArray(new DocumentFile[localArrayList.size()]);
  }
  
  public boolean renameTo(String paramString)
  {
    paramString = new File(this.mFile.getParentFile(), paramString);
    if (this.mFile.renameTo(paramString))
    {
      this.mFile = paramString;
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\documentfile\provider\RawDocumentFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */