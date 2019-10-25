package sydney.au.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "activities")
@Entity
public class Activity {

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer acid;
	
	@Column(name = "actitle")
	private String actitle;
	
	@Column(name = "activetime")
	private String activetime;
	
	@Column(name = "activeaddr")
	private String activeaddr;
	
	@Column(name = "information")
	private String information;
	public Integer getAcid() {
		return acid;
	}
	public void setAcid(Integer acid) {
		this.acid = acid;
	}
	
	
	public String getActitle() {
		return actitle;
	}
	public void setActitle(String actitle) {
		this.actitle = actitle;
	}
	public String getActivetime() {
		return activetime;
	}
	public void setActivetime(String activetime) {
		this.activetime = activetime;
	}
	public String getActiveaddr() {
		return activeaddr;
	}
	public void setActiveaddr(String activeaddr) {
		this.activeaddr = activeaddr;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
}
