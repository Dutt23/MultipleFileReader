package shatyaki.duttt.sd.FileReader.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shatyaki.duttt.sd.FileReader.dto.EligibilityFailure;
import shatyaki.duttt.sd.FileReader.dto.EligibilityReasons;
import shatyaki.duttt.sd.FileReader.dto.Failures;
import shatyaki.duttt.sd.FileReader.dto.TechQcFailure;
import shatyaki.duttt.sd.FileReader.dto.TechQcReasons;

@RestController
@RequestMapping("/file/test")
public class Controller {

	int eligibilityFailure;
	int validateFailure;
	int techQcFailure;
	int totalCustomers;
	int RCEL001;
	int RCEL002;
	int RCEL003;
	int RCEL004;
	int RCEL005;
	int RCQC001;
	int RCQC002;
	int RCQC003;
	int RCQC004;
	int RCQC005;
	int RCQC006;
	int RCQC007;
	int RCQC008;
	int RCQC009;
	int RCQC010;
	int RCQC011;
	int RCQC012;
	int RCQC013;
	int RCQC014;
	int RCQC015;
	boolean found;
	String[] customerString;

	private Failures failures;
	private EligibilityFailure eligibilityFailures;
	private EligibilityReasons eligibilityReasons;
	private TechQcFailure techQcFailures;
	private TechQcReasons techQcReasons;
	private int isTechOddTechQc;
	private boolean duplicate = false;

	Set<String> numberOfCustomers;

	@GetMapping("/read")
	private Object readFiles(@RequestParam(value = "dirPath") final String dirPath) throws IOException {

		// try (Stream<Path> paths =
		// Files.walk(Paths.get("C:\\Users\\BD5320\\Desktop\\TechOdd Logs from 27th")))
		// {
		//
		//
		// readLines(paths.forEach(););
		// System.out.println(paths.count());
		//
		// }
		eligibilityFailure = 0;
		validateFailure = 0;
		techQcFailure = 0;
		totalCustomers = 0;
		isTechOddTechQc = 0;

		RCEL001 = 0;
		RCEL002 = 0;
		RCEL003 = 0;
		RCEL004 = 0;
		RCEL005 = 0;

		RCQC001 = 0;
		RCQC002 = 0;
		RCQC003 = 0;
		RCQC004 = 0;
		RCQC005 = 0;
		RCQC006 = 0;
		RCQC007 = 0;
		RCQC008 = 0;
		RCQC009 = 0;
		RCQC010 = 0;
		RCQC011 = 0;
		RCQC012 = 0;
		RCQC013 = 0;
		RCQC014 = 0;
		RCQC015 = 0;

		File dir = new File(dirPath);

		File[] files = dir.listFiles();

		numberOfCustomers = new HashSet<String>();

		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {

			for (File aFile : files) {
				readLines(aFile);
			}
		}

		// return numberOfCustomers.size();
		return setFailureFields();
	}

	public void readLines(File aFile) throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(aFile))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.contains("to the Response queue : KN.KN.ODDRCQ.RESPONSE.DATA.PUT and the message is :")) {
					customerString = line.split("\"techOddEligibility\"")[0].split("\"customerId\":")[1].split(",");

					duplicate = numberOfCustomers.add(customerString[0]);

				}

				if (duplicate) {
					if (line.contains("\"isTechoddtechQC\":true")) {
						isTechOddTechQc++;
					}

					if (line.contains("\"isTechOddEligible\":false")) {

						eligibilityFailure++;

						if (line.contains("RCEL001")) {
							RCEL001++;
						} else if (line.contains("RCEL002")) {
							RCEL002++;
						} else if (line.contains("RCEL003")) {
							RCEL003++;
						} else if (line.contains("RCEL004")) {
							RCEL004++;
						} else if (line.contains("RCEL005")) {
							RCEL005++;
						}
					} else if (line.contains("\"isTechOddvalidate\":false")) {

						validateFailure++;
					} else if (line.contains("\"isTechoddtechQC\":false")) {
						techQcFailure++;
						techQcReaons(line);
					}

				}

				// if (line.contains("to the Response queue : KN.KN.ODDRCQ.RESPONSE.DATA.PUT and
				// the message is :")) {
				// totalCustomers++;
				// }

				// if (line.contains("updatedbyUser=false")) {
				// validateFailure++;
				// }

			}
		}

	}

	public void techQcReaons(String line) {
		if (line.contains("RCQC001")) {
			RCQC001++;
		} else if (line.contains("RCQC002")) {
			RCQC002++;
		} else if (line.contains("RCQC003")) {
			RCQC003++;
		} else if (line.contains("RCQC004")) {
			RCQC004++;
		} else if (line.contains("RCQC005")) {
			RCQC005++;
		} else if (line.contains("RCQC006")) {
			RCQC006++;
		} else if (line.contains("RCQC007")) {
			RCQC007++;
		} else if (line.contains("RCQC008")) {
			RCQC008++;
		} else if (line.contains("RCQC009")) {
			RCQC009++;
		} else if (line.contains("RCQC010")) {
			RCQC010++;
		} else if (line.contains("RCQC011")) {
			RCQC011++;
		} else if (line.contains("RCQC012")) {
			RCQC012++;
		} else if (line.contains("RCQC013")) {
			RCQC013++;
		} else if (line.contains("RCQC014")) {
			RCQC014++;
		} else if (line.contains("RCQC015")) {
			RCQC015++;
		}
	}

	private Failures setFailureFields() {

		failures = new Failures();
		eligibilityFailures = new EligibilityFailure();
		eligibilityReasons = new EligibilityReasons();
		techQcFailures = new TechQcFailure();
		techQcReasons = new TechQcReasons();

		eligibilityReasons.setRCEL001(RCEL001);
		eligibilityReasons.setRCEL002(RCEL002);
		eligibilityReasons.setRCEL003(RCEL003);
		eligibilityReasons.setRCEL004(RCEL004);
		eligibilityReasons.setRCEL005(RCEL005);
		eligibilityFailures.setFailures(eligibilityFailure);
		eligibilityFailures.setReasons(eligibilityReasons);

		techQcReasons.setRCQC001(RCQC001);
		techQcReasons.setRCQC002(RCQC002);
		techQcReasons.setRCQC003(RCQC003);
		techQcReasons.setRCQC004(RCQC004);
		techQcReasons.setRCQC005(RCQC005);
		techQcReasons.setRCQC006(RCQC006);
		techQcReasons.setRCQC007(RCQC007);
		techQcReasons.setRCQC008(RCQC008);
		techQcReasons.setRCQC009(RCQC009);
		techQcReasons.setRCQC010(RCQC010);
		techQcReasons.setRCQC011(RCQC011);
		techQcReasons.setRCQC012(RCQC012);
		techQcReasons.setRCQC013(RCQC013);
		techQcReasons.setRCQC014(RCQC014);
		techQcReasons.setRCQC015(RCQC015);

		techQcFailures.setFailures(techQcFailure);
		techQcFailures.setTechQcReasons(techQcReasons);

		failures.setTotalCustomers(numberOfCustomers.size());
		failures.setEligibilityFailure(eligibilityFailures);
		failures.setTechQcFailure(techQcFailures);
		failures.setValidateFailures(validateFailure);
		failures.setIsTechOddTechQc(isTechOddTechQc);

		return failures;
	}

}
