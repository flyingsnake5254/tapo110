package io.netty.handler.codec.http.multipart;

final class FileUploadUtil
{
  static int compareTo(FileUpload paramFileUpload1, FileUpload paramFileUpload2)
  {
    return paramFileUpload1.getName().compareToIgnoreCase(paramFileUpload2.getName());
  }
  
  static boolean equals(FileUpload paramFileUpload1, FileUpload paramFileUpload2)
  {
    return paramFileUpload1.getName().equalsIgnoreCase(paramFileUpload2.getName());
  }
  
  static int hashCode(FileUpload paramFileUpload)
  {
    return paramFileUpload.getName().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\FileUploadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */