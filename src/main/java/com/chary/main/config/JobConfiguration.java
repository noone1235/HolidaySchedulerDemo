package com.chary.main.config;

import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.chary.main.jobs.SyncJob;
import com.chary.main.model.ScheduleParam;



@Configuration
public class JobConfiguration {
    

    @Autowired 
    private Scheduler scheduler;
    
    //private Logger LOGGER=LoggerFactory.getLogger(JobConfiguration.class);
    
    public Boolean init(ScheduleParam scheduleData) throws Exception {   	
        
    	String jobName=scheduleData.getUuId()+"";
    	String jobGroup="ScheduleGroup";
    	String jobTrigger=scheduleData.getUuId()+"";
 
    	JobDetail jobDetail=syncData(jobName,jobGroup);
    	scheduler.addJob(jobDetail, true, true);
        

    	String dailyTime=scheduleData.getCronTime();
    	
    	
        //System.out.println(scheduler.getCalendar("holidayTime"));
    	if (!scheduler.checkExists(new TriggerKey(jobTrigger, jobGroup))) {
            scheduler.scheduleJob(triggerSyncData(jobTrigger,jobGroup,jobDetail,dailyTime));
        }
    	else {
    		scheduler.rescheduleJob((new TriggerKey(jobTrigger, jobGroup)), triggerSyncData(jobTrigger,jobGroup,jobDetail,dailyTime));
    	}
    	return true;
    }
    
    private JobDetail syncData(String jobName,String jobGroup) {
        
    	JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setKey(new JobKey(jobName, jobGroup));
        jobDetail.setJobClass(SyncJob.class);
        
        return jobDetail;
    }
    
   
    private Trigger triggerSyncData(String jobTrigger,String jobGroup,JobDetail jobDetail,String dailyTime) {
    	
    	CronScheduleBuilder builder=CronScheduleBuilder.cronSchedule(dailyTime);
//        
//    	HolidayCalendar cal= new HolidayCalendar();
//		cal.addExcludedDate(DateBuilder.dateOf(13, 38, 0, 27, 9, 2022));
//		System.out.println(cal+" "+cal.getDescription()+ " "+cal.getBaseCalendar()+" "+cal.getExcludedDates());
		
		
//        try {
//			scheduler.addCalendar("cal", dayCalendar, true, false);
//		} catch (SchedulerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	return newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobTrigger, jobGroup)
                .withSchedule(builder)
                .build();
    }
}