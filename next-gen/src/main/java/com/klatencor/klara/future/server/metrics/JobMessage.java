package com.klatencor.klara.future.server.metrics;

import java.util.Date;

import com.klatencor.klara.future.job.JobState;

public class JobMessage {
	
	private long time;
	
	private long jobId;
	
	private String jobName;
	
	private JobState state;
	
	private String msg;
	
	public JobMessage() {
		
	}

	public JobMessage(long time, long jobId, String jobName, JobState state, String msg) {
		this.time = time;
		this.jobId = jobId;
		this.jobName = jobName;
		this.state = state;
		this.msg = msg;
	}
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
		
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String formatMessage() {
		return String.format("%s: %d, %s, %s, %s", new Date(time).toString(),
				jobId, jobName, state, msg);
	}
	
	public String toString() {
		return formatMessage();
	}
	
}
