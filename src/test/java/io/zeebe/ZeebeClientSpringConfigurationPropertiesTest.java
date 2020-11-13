package io.zeebe;

//@Testcontainers
public class ZeebeClientSpringConfigurationPropertiesTest {

//	@Container private final ZeebeContainer zeebeContainer = new ZeebeContainer();

//	@Test
//	void shouldConnectToZeebe() {
//		// given
//		final ZeebeClient client =
//				ZeebeClient.newClientBuilder()
//				.brokerContactPoint(zeebeContainer.getExternalGatewayAddress())
//				.usePlaintext()
//				.build();
//		final BpmnModelInstance process =
//				Bpmn.createExecutableProcess("deposit-process").startEvent().done();//.endEvent().done();
//
//		// when
//		// do something (e.g. deploy a workflow)
//		final DeploymentEvent deploymentEvent =
//				client.newDeployCommand().addWorkflowModel(process, "deposit-process.bpmn").send().join();
//
//		// then
//		// verify (e.g. we can create an instance of the deployed workflow)
//		final WorkflowInstanceResult workflowInstanceResult =
//				client
//				.newCreateInstanceCommand()
//				.bpmnProcessId("deposit-process")
//				.latestVersion()
//				.withResult()
//				.send()
//				.join();
//		Assertions.assertThat(workflowInstanceResult.getWorkflowKey())
//		.isEqualTo(deploymentEvent.getWorkflows().get(0).getWorkflowKey());
//	}


}
