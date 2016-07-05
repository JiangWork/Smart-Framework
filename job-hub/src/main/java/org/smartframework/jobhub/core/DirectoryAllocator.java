package org.smartframework.jobhub.core;

import java.io.File;

/**
 * This class allocate different kinds of directories
 * used by the framework and different default files. 
 * 
 * @author Miller
 * @date Jul 3, 2016 7:12:36 PM
 */
public class DirectoryAllocator {
	public static String WORKING_DIRECTORY;
	public static String UPLOAD_DIRECTORY;
	public static String JOB_DIRECTORY;
	public static String APP_LOCATION;
	
	static {
		WORKING_DIRECTORY = System.getProperty("work.dir", System.getProperty("user.home"));
		UPLOAD_DIRECTORY = WORKING_DIRECTORY + File.separator + "upload";
		JOB_DIRECTORY = WORKING_DIRECTORY + File.separator + "job";
		APP_LOCATION = System.getProperty("app.location");
	}
	
	
	public static String workingDirectory(long jobid) {
		return JOB_DIRECTORY + File.separator + String.valueOf(jobid);
	}
	
	public static String uploadDirectory(long jobid) {
		return UPLOAD_DIRECTORY + File.separator + String.valueOf(jobid);
	}
	
	/**
	 * Get the generated script path for running the job.
	 * @return
	 */
	public static String scriptPath(long jobid) {
		return workingDirectory(jobid) + File.separator + "jvm.sh";
	}
	
	public static String configPath(long jobid) {
		return workingDirectory(jobid) + File.separator + "config.prop";
	}
	
	public static String pidPath(long jobid) {
		return workingDirectory(jobid) + File.separator + "pid";
	}
	
	public static String stdoutPath(long jobid) {
		return workingDirectory(jobid) + File.separator + "stdout";
	}
	
	public static String stderrPath(long jobid) {
		return workingDirectory(jobid) + File.separator + "stderr";
	}
	
	public static String logPath(long jobid) {
		return workingDirectory(jobid) + File.separator + "log";
	}
	
	public static void main(String[] args) {
		System.out.println(DirectoryAllocator.WORKING_DIRECTORY);
		System.out.println(DirectoryAllocator.UPLOAD_DIRECTORY);
		System.out.println(DirectoryAllocator.JOB_DIRECTORY);
	}
	
}
