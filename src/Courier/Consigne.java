package Courier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Consignetable")
public class Consigne {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "consigne_generator", sequenceName = "consigne_seq", allocationSize=50)
	@Column(name = "consigneid", updatable = false, nullable = false)
	protected int Num;
	@Column(name="id_mail")
	protected int idmail;
	@Column(name="Consigne")
	protected String consigne;
	@Column(name="date")
	protected String date;
	@Column(name="datelim")
	protected String datelim;
	
	public Consigne() {
		
	}
	
	public Consigne(int mailid,String Consigne,String date,String datelim) {
		super();
		this.idmail = mailid;
		this.consigne = Consigne;
		this.date = date;
		this.datelim = datelim;
	}
	
	public Consigne(int num,int mailid,String Consigne,String date,String datelim) {
		super();
		this.Num = num;
		this.idmail = mailid;
		this.consigne = Consigne;
		this.date = date;
		this.datelim = datelim;
	}
	
	
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public int getIdmail() {
		return idmail;
	}
	public void setIdmail(int idmail) {
		this.idmail = idmail;
	}
	public String getConsigne() {
		return consigne;
	}
	public void setConsigne(String consigne) {
		this.consigne = consigne;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDatelim() {
		return datelim;
	}
	public void setDatelim(String datelim) {
		this.datelim = datelim;
	}
}
