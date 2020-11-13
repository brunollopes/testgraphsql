package io.zeebe;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class ZeebeCreateJobsViaREST {

//	private final ZeebeClientLifecycle client;
//
//    public ZeebeCreateJobsViaREST(ZeebeClientLifecycle client) {
//        this.client = client;
//    }
    
//	@EventListener(classes = {ApplicationReadyEvent.class})
//    public void handleMultipleEvents() {
//        log.info("C4P Service Started!");
//        try {
//            DeploymentEvent deploymentEvent = client.newDeployCommand().addResourceFromClasspath("c4p-orchestration.bpmn").send().join();
//            log.info("Deploying Workflow... " + deploymentEvent.getKey());
//            for (Workflow w : deploymentEvent.getWorkflows()) {
//                log.info("> processId: " + w.getBpmnProcessId());
//                log.info("> resourceName: " + w.getResourceName());
//                log.info("> workflowKey: " + w.getWorkflowKey());
//            }
//        }catch(Exception e){
//            log.error("Deploy Workflow Failed, needs retry...");
//        }
//    }

	
//	@GetMapping("/payment")
//	public void createPaymentJob (@PathVariable String jobName) {
//		log.info("Calling the zeebe worker: payment-service");
//
//		final ZeebeClient client = ZeebeClient.newClientBuilder()
//				// change the contact point if needed
//				.gatewayAddress("192.168.99.100:26500")
//				.usePlaintext()
//				.build();
//
//		System.out.println("Connected.");
//		// after the workflow instance is created
//
//		try(final JobWorker jobWorker = client
//				.newWorker()
//				.jobType("payment-service")
//				.handler(new ExampleJobHandler())
//				.timeout(Duration.ofSeconds(10))
//				.open())
//				{
//			
//			
//			System.out.println("Job worker opened and receiving jobs.");
//			System.out.println("GetTABSIN");
//			
//			
//			
//	        // run until System.in receives exit command
//	        //waitUntilSystemInput("exit");
//	        
//				};
//
//	}
//	
//
//	 private static void waitUntilSystemInput(final String exitCode) {
//		    try (final Scanner scanner = new Scanner(System.in)) {
//		      while (scanner.hasNextLine()) {
//		        final String nextLine = scanner.nextLine();
//		        if (nextLine.contains(exitCode)) {
//		          return;
//		        }
//		      }
//		    }
//		  }
//	 
//	private static class ExampleJobHandler implements JobHandler {
//		@Override
//		public void handle(final JobClient client, final ActivatedJob job) {
//			// here: business logic that is executed with every job
//			System.out.println("runnig business logic in the job: \n" + job);
//			
//			client.newCompleteCommand(job.getKey()).send().join();
//		}
//	}
	
//	 @PostMapping(value = "/{id}/decision")
//	    public void decide(@PathVariable("id") String id, @RequestBody ProposalDecision decision) {
//
//	        emitEvent("> Proposal Approved Event ( " + ((decision.isApproved()) ? "Approved" : "Rejected") + ")");
//
//	        var proposalOptional = proposalRepository.findById(id);
//
//	        if (proposalOptional.isPresent()) {
//
//	            var proposal = proposalOptional.get();
//
//	            if(decision.isApproved()) {
//	                proposal.approve();
//	            }else{
//	                proposal.reject();
//	            }
//
//	            proposalRepository.save(proposal);
//
//	            // Notify the workflow that a decision was made
//	            client.newPublishMessageCommand()
//	                    .messageName("DecisionMade").correlationKey(proposal.getId())
//	                    .variables(Collections.singletonMap("proposal", proposal)).send().join();
//	        } else {
//
//	            emitEvent(" Proposal Not Found Event (" + id + ")");
//	        }
//	    }
}
