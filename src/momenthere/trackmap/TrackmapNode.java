package momenthere.trackmap;
import java.util.Date;

/**
 * @author Xiuming XU (gracexuxiuming@gmail.com)
 */
public class TrackmapNode {
	public TrackmapNode(){
		
	}
	@Override
	public String toString() {
		return "TrackmapNode [username=" + username + "]";
	}

	String username;
	Date trackDate; 
	String location; 
	int postcardNum;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getTrackDate() {
		return trackDate;
	}
	public void setTrackDate(Date trackDate) {
		this.trackDate = trackDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		location = location;
	}
	public int getPostcardNum() {
		return postcardNum;
	}
	public void setPostcardNum(int postcardNum) {
		postcardNum = postcardNum;
	}

	public TrackmapNode(String username,Date trackDate, String location, int postcardNum) {
		this.username = username;
		this.trackDate = trackDate;
		this.location = location;
		this.postcardNum = postcardNum;
	}
}
