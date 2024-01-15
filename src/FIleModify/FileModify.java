package FileModify;

import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;


//used in  CreateFileCommand
public class FileModify extends FileOutputStream {


    public FileModify(String fileName) throws IOException {
        super(new FileOutputStream(fileName).toString());
    }



}