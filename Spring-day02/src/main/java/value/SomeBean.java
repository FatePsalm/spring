package value;

public class SomeBean {
	private String name;
	private String interest;
	private double score;
	private String pageSize;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "SomeBean [name=" + name + ", interest=" + interest + ", score=" + score + ", pageSize=" + pageSize
				+ "]";
	}
	
}
