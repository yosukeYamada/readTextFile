import java.time.LocalDateTime;
import java.util.List;

public class Log {

	public Log() {
		super();
		under500ms = 0;
		under2000ms = 0;
		over2001ms = 0;
		averageResponceTime = 0;
		totalResponceTime = 0;
	}

	private LocalDateTime localDateTime;
	private int under500ms;
	private int under2000ms;
	private int over2001ms;
	private int averageResponceTime;
	private int totalResponceTime;

	public int getAverageResponceTime() {
		if ((under500ms + under2000ms + over2001ms) != 0) {
			return totalResponceTime / (under500ms + under2000ms + over2001ms);
		} else {
			return 0;
		}
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

	public void setAverageResponceTime(int averageResponceTime) {
		this.averageResponceTime = averageResponceTime;
	}

	private int responeTime;

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public int getResponeTime() {
		return responeTime;
	}

	public void setResponeTime(int responeTime) {
		this.responeTime = responeTime;
	}

	public int getTotalResponceTime() {
		return totalResponceTime;
	}

	public void setTotalResponceTime(int totalResponceTime) {
		this.totalResponceTime = totalResponceTime;
	}

	@Override
	public String toString() {
		return "Log [localDateTime=" + localDateTime + ", under500ms=" + under500ms + ", under2000ms=" + under2000ms
				+ ", over2001ms=" + over2001ms + ", averageResponceTime=" + averageResponceTime + ", totalResponceTime="
				+ totalResponceTime + ", responeTime=" + responeTime + "]";
	}

}
