package shatyaki.duttt.sd.FileReader.dto;

public class EligibilityFailure {

	private int failures;
	private EligibilityReasons reasons;

	public int getFailures() {
		return failures;
	}

	public void setFailures(int failures) {
		this.failures = failures;
	}

	public EligibilityReasons getReasons() {
		return reasons;
	}

	public void setReasons(EligibilityReasons reasons) {
		this.reasons = reasons;
	}

}
