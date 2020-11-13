package io.zeebe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.DeploymentEvent;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import io.zeebe.spring.client.EnableZeebeClient;
import io.zeebe.spring.client.ZeebeClientLifecycle;

@SpringBootApplication
@ComponentScan(basePackages = "io.zeebe")
@EnableZeebeClient
//@ZeebeDeployment(classPathResources = {"deposit-process.bpmn"})
public class App
{
	@Autowired
	private ZeebeClientLifecycle zeebeClient;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
//		init();
	}
//	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}
	
	
	@Bean
	public void zeebeDeployInstance() {
	 System.out.println("Deploy zeebe client instance");
	 
	 final DeploymentEvent deployment = zeebeClient.newDeployCommand()
				.addResourceFromClasspath("deposit-process.bpmn")
				.send()
				.join();

		final int version = deployment.getWorkflows().get(0).getVersion();
		System.out.println("Workflow deployed. Version: " + version);


		//Create workflow instance

		final WorkflowInstanceEvent wfInstance = zeebeClient.newCreateInstanceCommand()
				.bpmnProcessId("deposit-process")
				.latestVersion()
				.send()
				.join();

		final long workflowInstanceKey = wfInstance.getWorkflowInstanceKey();

		System.out.println("Workflow instance created. Key: " + workflowInstanceKey);


		// waiting for the jobs
		// Don't close, we need to keep polling to get work
		// It will be close after last statement in try-with resources block

	}
	
	public static void init()
	{
		final ZeebeClient client = ZeebeClient.newClientBuilder()
				// change the contact point if needed
				.gatewayAddress("192.168.99.100:26500")
				.usePlaintext()
				.build();

		System.out.println("Connected.");

		// after the client is connected

		final DeploymentEvent deployment = client.newDeployCommand()
				.addResourceFromClasspath("deposit-process.bpmn")
				.send()
				.join();

		final int version = deployment.getWorkflows().get(0).getVersion();
		System.out.println("Workflow deployed. Version: " + version);


		//Create workflow instance

		final WorkflowInstanceEvent wfInstance = client.newCreateInstanceCommand()
				.bpmnProcessId("deposit-process")
				.latestVersion()
				.send()
				.join();

		final long workflowInstanceKey = wfInstance.getWorkflowInstanceKey();

		System.out.println("Workflow instance created. Key: " + workflowInstanceKey);


		// waiting for the jobs
		// Don't close, we need to keep polling to get work
		// It will be close after last statement in try-with resources block




		//		client.close();
		//		System.out.println("Closed.");
	}


}
