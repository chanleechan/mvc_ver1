package backup;

import java.sql.Date;

public class Work {
	private String emp_code;
	private String emp_name;
	private Date g_date;
	private Date o_date;
	private Date n_date;
	private String status;
	
	
	public Work() {
		super();
	}

	public Work(String emp_code, String emp_name, Date g_date, Date o_date, Date n_date, String status) {
		super();
		this.emp_code = emp_code;
		this.emp_name = emp_name;
		this.g_date = g_date;
		this.o_date = o_date;
		this.n_date = n_date;
		this.status = status;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Date getG_date() {
		return g_date;
	}

	public void setG_date(Date g_date) {
		this.g_date = g_date;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Work [emp_code=" + emp_code + ", emp_name=" + emp_name + ", g_date=" + g_date + ", o_date=" + o_date
				+ ", n_date=" + n_date + ", status=" + status + "]";
	}
	
	
}
