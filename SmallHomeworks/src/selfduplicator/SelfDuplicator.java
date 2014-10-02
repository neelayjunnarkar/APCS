package selfduplicator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SelfDuplicator {
	static int classname_lineno = 7;
	static String classname = "SelfDuplicator";
	static String nextclassname = classname+"x";
	static int filename_lineno = 12;
	static String filename = "C:/Users/95028672/workspace/APCS/SmallHomeworks/src/selfduplicator/SelfDuplicator";
	static String nextfilename =  filename+"x";
	
	public static void main(String[] args) {
		FileInputStream ifs = null;
		FileOutputStream ofs = null;
		try {
			ifs = new FileInputStream(filename+".java");
			ofs = new FileOutputStream(nextfilename+".java");
			char end = '\n';
			int c, lineno = 0;
			while ((c = ifs.read()) != -1) {
				if (lineno == classname_lineno-1) {
					ofs.write(("public class "+nextclassname+ " {\n").getBytes());
					lineno++;
				} else if (lineno == classname_lineno+2) {
					ofs.write(("static String classname = \""+nextclassname+"\";\n").getBytes());
					lineno++;
				} else if (lineno == filename_lineno) {
					ofs.write(("	static String filename = \""+nextfilename+"\";\n").getBytes());
					lineno++;
				} else {
					if (lineno > filename_lineno+1 || lineno < classname_lineno ||  (lineno < filename_lineno && lineno > classname_lineno)) {
						ofs.write(c);
					}
				}
				if (c == end) lineno++;
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
	         if (ifs != null) {
	             try {
					ifs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	          }
	          if (ofs != null) {
	             try {
					ofs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	          }
	    }
	}
}
