package shatyaki.duttt.sd.FileReader.dto;

public class TechQcFailure {

	private int failures;
	private TechQcReasons techQcReasons;

	public int getFailures() {
		return failures;
	}

	public void setFailures(int failures) {
		this.failures = failures;
	}

	public TechQcReasons getTechQcReasons() {
		return techQcReasons;
	}

	public void setTechQcReasons(TechQcReasons techQcReasons) {
		this.techQcReasons = techQcReasons;
	}

}
