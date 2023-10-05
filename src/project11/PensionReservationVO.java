package project11;

import java.sql.Date;

public class PensionReservationVO {
	private int idx;
	private String mId;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String address;
	private String phone;
	
	private String rName;
	private Date checkInDate;
	private Date checkOutDate;
	private boolean animalExperience;
	private boolean breakfast;
	private boolean bbq;
	
	private String rIntro;
	private boolean animalIn;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public boolean isAnimalExperience() {
		return animalExperience;
	}
	public void setAnimalExperience(boolean animalExperience) {
		this.animalExperience = animalExperience;
	}
	public boolean isBreakfast() {
		return breakfast;
	}
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}
	public boolean isBbq() {
		return bbq;
	}
	public void setBbq(boolean bbq) {
		this.bbq = bbq;
	}
	public String getrIntro() {
		return rIntro;
	}
	public void setrIntro(String rIntro) {
		this.rIntro = rIntro;
	}
	public boolean isAnimalIn() {
		return animalIn;
	}
	public void setAnimalIn(boolean animalIn) {
		this.animalIn = animalIn;
	}
	
	@Override
	public String toString() {
		return "PensionReservationVO [idx=" + idx + ", mId=" + mId + ", password=" + password + ", name=" + name
				+ ", birth=" + birth + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", rName="
				+ rName + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", animalExperience="
				+ animalExperience + ", breakfast=" + breakfast + ", bbq=" + bbq + ", rIntro=" + rIntro + ", animalIn="
				+ animalIn + "]";
	}
}