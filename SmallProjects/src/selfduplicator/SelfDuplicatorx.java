package selfduplicator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SelfDuplicatorx {

    static int classname_lineno = 12;
    static String classname = "SelfDuplicatorx";
    static String nextclassname = classname+"x";

    static int filename_lineno = 16;
    static String filename = "C:/Users/Neelay/workspace/APCS/SmallProjects/src/selfduplicator/SelfDuplicatorx";
    static String nextfilename = filename+"x";

    public static void main(String[] args) throws IOException {
        FileOutputStream ofs = new FileOutputStream(nextfilename+".java");

        List<String> lines= Files.readAllLines(Paths.get(filename+".java"), Charset.forName("UTF-8"));
        int lineno = 1;
        for(String line : lines){
            System.out.println(line);
            if (lineno == classname_lineno-3) {
                ofs.write(("public class "+nextclassname+" {\n").getBytes());
            } else if (lineno == classname_lineno) {
                ofs.write(("    static String classname = \""+nextclassname+"\";\n").getBytes());
            } else if (lineno == filename_lineno) {
                ofs.write(("    static String filename = \""+nextfilename+"\";\n").getBytes());
            } else {
                ofs.write((line + "\n").getBytes());
            }
            lineno++;
        }

    }
}
