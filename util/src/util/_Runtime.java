package util;

public class _Runtime {

	public static long usedMemory() {
		Runtime rt = Runtime.getRuntime();
		rt.gc();
		return rt.totalMemory() - rt.freeMemory();
	}

	public static String usedMemoryInBytes() {
		Runtime rt = Runtime.getRuntime();
		rt.gc();
		return (rt.totalMemory() - rt.freeMemory()) + " bytes";
	}
	
	public static String usedMemoryInKiloBytes() {
		long rst = usedMemory();
		double kb = rst / 1024;
		return kb + " KB";
	}
	
	public static String usedMemoryInMegaBytes() {
		long rst = usedMemory();
		double kb = rst / 1024;
		double mb = kb / 1024;
		return mb + " MB";
	}

}
