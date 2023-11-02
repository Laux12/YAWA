public class enrolledSubject {
	private String subDescrip;
	private String code;
	private String subSched;
	private String subSection;
	private String secCode;
	int units;
	
	enrolledSubject(String secCode,String code,String subDescrip,String subSection,String subSched,int units){
		this.secCode = secCode;
		this.code = code;
		this.subDescrip = subDescrip;
		this.subSection = subSection;
		this.subSched = subSched;
		this.units = units;
	}
	public String getSubCode() {
		return code;
		
	}
	public String getSecCode() {
		return secCode;
		
	}
	public String getSubDescrip() {
		return subDescrip;
	
	}
	public String getSubSched() {
		return subSched;
	
	}
	public String getSubSection() {
		return subSection;
	
	}
	public int getUnits() {
		return units;
	
	}
	
}
