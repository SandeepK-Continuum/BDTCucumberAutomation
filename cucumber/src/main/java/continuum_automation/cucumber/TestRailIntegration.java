package continuum_automation.cucumber;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;




public class TestRailIntegration {
	private static final Logger logger = Logger.getLogger(TestRailIntegration.class
			.getName());

	private final String username;
	private final String password;
	private final String userID;
	APIClient client;

	/**
	 * Constructor for TestRail API
	 * 
	 * Specify a username and password for the httpClient. We first get a new
	 * HttpClient, set a connection timeout, tell the client that we are using a
	 * username and password, then add the credentials to the httpClient.
	 * 
	 */
	public TestRailIntegration() {
		username = Utilities.getMavenProperties("TestRailUserName"); 
		password = Utilities.getMavenProperties("TestRailPassword");
		userID = Utilities.getMavenProperties("TestRailUserId");
		
	}

	/*
	 * public TestRailAPILib() {
	 * 
	 * }
	 */

	/**
	 * Method used to Save the Test Case Results in TestRail
	 * 
	 * @param testCaseID
	 *            TestRail Test Case ID "TCXXXX"
	 * @param testSetID
	 *            TestRail Test Set ID "TSXXX"
	 * @param build
	 *            Current Product Build
	 * @param notes
	 *            All the notes that you want to add to the Test Case result
	 * @param executionStatus
	 *            The execution result "Blocked", "Error", "Fail",
	 *            "Inconclusive", "Pass"
	 * @param durationMessage
	 *            The duration time that took the test case execution
	 * @param testRailStatus
	 * @param testerUserID
	 *            Th e TestRail Tester User ID
	 * @throws com.continuum.common.TestResults.APIException 
	 * 
	 * 
	 */
	public void saveResult(String testCaseID, String testSetID, String build,
			String notes, String executionStatus, String durationMessage,
			int testRailStatus)  {
		client = new APIClient(Utilities.getMavenProperties("TestRailUrl"));
		client.setUser(username);
		client.setPassword(password);
		testCaseID = testCaseID.split("C")[1];
		testSetID = testSetID.split("S")[1];
		try {
			JSONObject c = (JSONObject) client.sendGet("get_case/"
					+ Integer.parseInt(testCaseID));
			System.out.println(c.toString());
			Map<String, Comparable> data = new HashMap<String, Comparable>();

			data.put("status_id", testRailStatus);
			data.put("comment", notes);
			JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+
					testSetID + "/" + testCaseID, data);
			System.out.println("**************************************");
			System.out.println("    Test Rail Updated Successfull.    ");
			System.out.println("**************************************");
		} catch (NumberFormatException e) {
			logger.error("The Code Execution was Interupted by "
					+ e.getMessage());
			e.printStackTrace();
		} catch (MalformedURLException e) {
			logger.error("The Code Execution was Interupted by "
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("The Code Execution was Interupted by "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("The Code Execution was Interupted by "
					+ e.getMessage());
			e.printStackTrace();
		}

	}
}
