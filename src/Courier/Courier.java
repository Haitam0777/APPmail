package Courier;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="courier")
public class Courier {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "courier_generator", sequenceName = "courier_seq", allocationSize=50)
	@Column(name = "Courierid", updatable = false, nullable = false)
	protected int Num;
	@Column(name="Expediteur")
	protected String expedit;
	@Column(name="Destinataire")
	protected String destinat;
	@Column(name="DateEnvoi")
	protected String date_envoi;
	@Column(name="Objet")
	protected String Objet;
	@Column(name="body")
	protected String contenu;
	
	public Courier() {
		
	}
	
	public Courier(String expedit, String destinat, String date_envoi, String objet, String contenu) {
		super();
		this.expedit = expedit;
		this.destinat = destinat;
		this.date_envoi = date_envoi;
		this.Objet = objet;
		this.contenu = contenu;
	}
	
	public Courier(int num, String expedit, String destinat, String date_envoi, String objet, String contenu) {
		super();
		this.Num = num;
		this.expedit = expedit;
		this.destinat = destinat;
		this.date_envoi = date_envoi;
		this.Objet = objet;
		this.contenu = contenu;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getExpedit() {
		return expedit;
	}
	public void setExpedit(String expedit) {
		this.expedit = expedit;
	}
	public String getDestinat() {
		return destinat;
	}
	public void setDestinat(String destinat) {
		this.destinat = destinat;
	}
	public String getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(String date_envoi) {
		this.date_envoi = date_envoi;
	}
	public String getObjet() {
		return Objet;
	}
	public void setObjet(String objet) {
		Objet = objet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	
	
}
