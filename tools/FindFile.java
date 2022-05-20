import java.io.File;

public class FindFile {
    public static String run(String filename, File dir)
    {

        File[]files=dir.listFiles();
        for(File file:files)
        {
            if(file.isDirectory())                      //file是目录时，则重新调用function函数;
            {
                run(filename,file.getAbsoluteFile());
            }else if(file.isFile() && filename.equals(file.getName()))  //file时文件且文件名相同时，输出;
            {
                return(file.getAbsolutePath());
            }
        }
        return null;
    }
}
