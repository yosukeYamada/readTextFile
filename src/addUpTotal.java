import java.time.LocalDateTime;

public class addUpTotal {

	private LocalDateTime localDateTime;
	private int under500ms;
	private int under2000ms;
	private int over2001ms;
	private int averageResponceTime;
	
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public int getUnder500ms() {
		return under500ms;
	}
	public void setUnder500ms(int under500ms) {
		this.under500ms = under500ms;
	}
	public int getUnder2000ms() {
		return under2000ms;
	}
	public void setUnder2000ms(int under2000ms) {
		this.under2000ms = under2000ms;
	}
	public int getOver2001ms() {
		return over2001ms;
	}
	public void setOver2001ms(int over2001ms) {
		this.over2001ms = over2001ms;
	}
	public int getAverageResponceTime() {
		return averageResponceTime;
	}
	public void setAverageResponceTime(int averageResponceTime) {
		this.averageResponceTime = averageResponceTime;
	}
	@Override
	public String toString() {
		return "addUpTotal [under500ms=" + under500ms + ", under2000ms=" + under2000ms + ", over2001ms=" + over2001ms
				+ ", averageResponceTime=" + averageResponceTime + "]";
	}
	
	
}
