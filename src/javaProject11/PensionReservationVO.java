package javaProject11;

public class PensionReservationVO {
	private int idx;
	private String id;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String address;
	private String phone;
	
	private String checkInDate;
	private String checkOutDate;
	
	private boolean animalExperience;
	private boolean breakfast;
	private boolean bbq;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
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
	
	@Override
	public String toString() {
		return "PensionReservationVO [idx=" + idx + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", birth=" + birth + ", gender=" + gender + ", address=" + address + ", phone=" + phone
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", animalExperience="
				+ animalExperience + ", breakfast=" + breakfast + ", bbq=" + bbq + "]";
	}
}
