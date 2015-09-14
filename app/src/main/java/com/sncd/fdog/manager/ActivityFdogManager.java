/**
 * 
 */
package com.sncd.fdog.manager;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

public class ActivityFdogManager {

	// 对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList实现了基于动态数组的数据结构，要移动数据。LinkedList基于链表的数据结构,便于增加删除
	private List<Activity> activityList = new LinkedList<Activity>();
	
	
	private List<Activity> activityArray = new LinkedList<Activity>(); 

	private static ActivityFdogManager instance = null;

	private ActivityFdogManager() {

	}

	public static ActivityFdogManager getInstance() {
		// 先检查实例是否存在，如果不存在才进入下面的同步块
		if (instance == null) {
			// 同步块，线程安全的创建实例
			synchronized (ActivityFdogManager.class) {
				// 再次检查实例是否存在，如果不存在才真正的创建实例
				if (instance == null) {
					instance = new ActivityFdogManager();
				}
			}
		}
		return instance;
	}

	public void addActivity(Activity activity) {
		activityList.add(activity);
	}

	public void removeActivity(Activity activity) {
		activityList.remove(activity);
	}

	public void finishAllActicity() {
		for (Activity activity : activityList) {
			activity.finish();
		}
	}
	public void putPActivity(Activity activity) {
		activityArray.add(activity);
	}

	public void delePActivity(Activity activity) {
		activityArray.remove(activity);
	}

	public void finishPActicity() {
		for (Activity activity : activityArray) {
			activity.finish();
		}
	}
}
