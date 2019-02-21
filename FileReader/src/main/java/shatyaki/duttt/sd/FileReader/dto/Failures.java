package shatyaki.duttt.sd.FileReader.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({ "totalCustomers","Passed" })
@JsonInclude(Include.NON_NULL)

public class Failures {

	private int totalCustomers;
	private EligibilityFailure eligibilityFailure;
	private TechQcFailure techQcFailure;
	private int validateFailures;
	@JsonProperty("Passed")
	private int isTechOddTechQc;

	public int getTotalCustomers() {
		return totalCustomers;
	}

	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}

	public EligibilityFailure getEligibilityFailure() {
		return eligibilityFailure;
	}

	public void setEligibilityFailure(EligibilityFailure eligibilityFailure) {
		this.eligibilityFailure = eligibilityFailure;
	}

	public TechQcFailure getTechQcFailure() {
		return techQcFailure;
	}

	public void setTechQcFailure(TechQcFailure techQcFailure) {
		this.techQcFailure = techQcFailure;
	}

	public int getValidateFailures() {
		return validateFailures;
	}

	public void setValidateFailures(int validateFailures) {
		this.validateFailures = validateFailures;
	}

	public int getIsTechOddTechQc() {
		return isTechOddTechQc;
	}

	public void setIsTechOddTechQc(int isTechOddTechQc) {
		this.isTechOddTechQc = isTechOddTechQc;
	}

}
