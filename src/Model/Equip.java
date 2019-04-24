package Model;

public class Equip {
	private String EquipID;
	private String Manufacturer;
	
	private String Specification;
	private String Name;
	private String Status;//设备状态（正常，损坏维修）
	private String Type;
	public Equip() {
		// TODO Auto-generated constructor stub
	}
	 public Equip(String equipID, String manufacturer, String status, String specification, String name,String type) {
	       this.EquipID=equipID;
	       this.Manufacturer=manufacturer;
	       this.Status=status;
	       this.Specification=specification;
	       this.Name=name;
	       this.Type=type;
		}
	public String getEquipID() {
		return EquipID;
	}
	public void setEquipID(String equipID) {
		EquipID = equipID;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
}
