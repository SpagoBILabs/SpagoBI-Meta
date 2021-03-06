package it.eng.spagobi.meta;

import java.io.Serializable;
import javax.persistence.*;


/**
 * This class refers to the position table.
 * 
 */
@Entity
@Table(name="position")
public class Position implements Serializable {

private static final long serialVersionUID = 1L;

public Position() {
}
	
	@Id
	@Column(name="position_id")
private String positionId=null;
	@Column(name="position_title")
private String positionTitle=null;
	@Column(name="pay_type")
private String payType=null;
	@Column(name="management_role")
private String managementRole=null;

public String getPositionId () {
	return this.positionId;
}
public void setPositionId (String positionId) {
	this.positionId = positionId;
}
public String getPositionTitle () {
	return this.positionTitle;
}
public void setPositionTitle (String positionTitle) {
	this.positionTitle = positionTitle;
}
public String getPayType () {
	return this.payType;
}
public void setPayType (String payType) {
	this.payType = payType;
}
public String getManagementRole () {
	return this.managementRole;
}
public void setManagementRole (String managementRole) {
	this.managementRole = managementRole;
}

}