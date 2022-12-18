package com.chary.main.jobs;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.chary.main.service.MainService;
import com.chary.main.service.SyncService;

public class SyncJob implements Job {

	private Logger logger = LoggerFactory.getLogger(SyncJob.class);

	private MainService service = new MainService();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			if (!(service.findHoliday())) {
				try {
					ApplicationContext ctx = getContext(context);
					SyncService SyncService = (SyncService) ctx.getBean(SyncService.class);

					JobDetail jobDetail = context.getJobDetail();
					JobKey jobKey = jobDetail.getKey();
					// System.out.println(jobKey.getName()+"
					// "+((jobKey.getName()).equals("chary")));

//					if ((jobKey.getName()).equals("1")) {
						SyncService.start();
//					}

				} catch (Exception e) {
					logger.error(e.getMessage(), e);
					;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ApplicationContext getContext(JobExecutionContext context) throws Exception {
		ApplicationContext ctx = (ApplicationContext) context.getScheduler().getContext().get("applicationContext");
		if (ctx == null) {
			throw new JobExecutionException("No application context available in scheduler context.");
		}
		return ctx;
	}
}