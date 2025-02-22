package in.sandeep.model;

public class Employee {

	@Override
	public String toString() {
		return "eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", depno=" + depno;
	}
	private int eid;
	private String ename;
	private double sal;
	private int depno;
	
	public Employee() {
		
	}
	public Employee(int eid,String ename,double sal,int depno) {
		this.eid=eid;
		this.ename=ename;
		this.sal=sal;
		this.depno=depno;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getDepno() {
		return depno;
	}
	public void setDepno(int depno) {
		this.depno = depno;
	}
	
}
