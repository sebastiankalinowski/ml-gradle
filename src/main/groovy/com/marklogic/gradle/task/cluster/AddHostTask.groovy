package com.marklogic.gradle.task.cluster

import com.marklogic.appdeployer.AppConfig
import com.marklogic.gradle.task.MarkLogicTask
import com.marklogic.mgmt.clusters.ClusterManager
import com.marklogic.mgmt.hosts.HostManager
import org.gradle.api.tasks.TaskAction

class AddHostTask extends MarkLogicTask {

	@TaskAction
	void addHost() {
		String host = project.property("host")
		String group = project.hasProperty("hostGroup") ? project.property("hostGroup") : "Default"
		String zone = project.hasProperty("hostZone") ? project.property("hostZone") : null

		ClusterManager mgr = new ClusterManager(getManageClient())
		mgr.addHost(getAdminManager(), host, group, zone)
	}
}
