package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeoutException;

public class _File {

	public static String currentDirStr() {
		return (new File(".")).getAbsolutePath();
	}
	
	public static File currentDir() {
		return new File(".");
	}
	
	public static boolean exist(String pathname) {
		return new File(pathname).exists();
	}

	public static boolean exist(File parent, String cur) {
		return new File(parent, cur).exists();
	}

	public static void mkdir(File parent, String cur) throws IOException {
		File f = new File(parent, cur);
		boolean rst = f.mkdir();
		if (!rst) {
			throw new IOException("Failed to make " + f.toString());
		}
	}
	
	public static void mkdirs(File parent, String rest) {
		if (_File.exist(parent, rest)) {
			return;
		}
		
		try {
			String[] comps = rest.split(File.separator);
			for (String comp : comps) {
				if (!_File.exist(parent, comp)) {
					_File.mkdir(parent, comp);
				}
				parent = new File(parent, comp);
			}
			while (!parent.exists()) {
				Thread.sleep(1);
			}
		} catch (Exception e) {
			throw new Error("Failed to make " + rest);
		}
	}

	public static void mkdirs(String dir) {
	  if (dir.startsWith(File.separator)) {
	    File parent = new File(File.separator);
	    mkdirs(parent, dir.substring(File.separator.length()));       
	  } else {
	    File parent = new File(File.separator);
	    mkdirs(parent, dir);	    
	  }
	}

	public static void remove(File f) {
		if (f.isDirectory()) {
			_File.removeDir(f);
		} else {
			f.delete();
		}
	}

	public static void removeDir(File dir) {
		if (!dir.exists()) {
			return;
		}
		
		assert dir.isDirectory();
		if (_File.isEmptyDir(dir)) {
			dir.delete();
		} else {
			for (File f : dir.listFiles()) {
				_File.remove(f);
			}
			assert _File.isEmptyDir(dir);
			dir.delete();
		}
	}

	public static boolean isEmptyDir(File dir) {
		assert dir.isDirectory();
		return dir.list().length == 0;
	}
	
	public static void wait(File file, int interval, int totalWaitTime)
			throws TimeoutException, InterruptedException {
		for (int total = 0; !file.exists(); total += interval) {
			file.wait(interval);
			if (total > totalWaitTime) {
				throw new TimeoutException();
			}
		}
	}

	public static void copyFile(File sourceFile, File destFile) throws IOException {
	    if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

	    FileChannel source = null;
	    FileChannel destination = null;

	    try {
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        destination.transferFrom(source, 0, source.size());
	    }
	    finally {
	        if(source != null) {
	            source.close();
	        }
	        if(destination != null) {
	            destination.close();
	        }
	    }
	}
	
}
