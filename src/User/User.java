package User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usertable")
public class User {
 
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE)
 @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize=50)
 @Column(name = "userid", updatable = false, nullable = false)
 protected int id;
 
 @Column(name="identifiant",unique= true)
 protected String identifiant;
 
 @Column(name="Nom")
 protected String nom;
 
 @Column(name="Prenom")
 protected String prenom;
 
 @Column(name="password",unique= true)
 protected String password;
 
 @Column(name="mail")
 protected String mail;
 
 @Column(name="tel")
 protected String tel;
 
 @Column(name="appartenance")
 protected String appartenance;
 
 @Column(name="admin")
 protected Boolean val = false;
 
 @Column(name="Sync")
 protected Boolean ftoken = false;
 
 
 public User() {
 }
 
 public User(String identifiant,String password,String nom,String prenom,String mail,String tel,String appartenance,Boolean val) {
  super();
  this.identifiant = identifiant;
  this.password = password;
  this.nom = nom;
  this.prenom = prenom;
  this.mail = mail;
  this.tel = tel;
  this.appartenance = appartenance;
  this.val=val;
 }

 public User(int id,String identifiant,String password,String nom,String prenom,String mail,String tel,String appartenance,Boolean val,Boolean ftoken) {
  super();
  this.id = id;
  this.identifiant = identifiant;
  this.password = password;
  this.nom = nom;
  this.prenom = prenom;
  this.mail = mail;
  this.tel = tel;
  this.appartenance = appartenance;
  this.val = val;
  this.ftoken = ftoken;
  }

 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getPassword() {
	return password;
 }

 public void setPassword(String password1) {
	this.password = password1;
 }
 public String getIdentifiant() {
	return identifiant;
}

public void setIdentifiant(String identifiant) {
	this.identifiant = identifiant;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getAppartenance() {
	return appartenance;
}

public void setAppartenance(String appartenance) {
	this.appartenance = appartenance;
}

public Boolean getVal() {
	return val;
}

public void setVal(Boolean val) {
	this.val = val;
}

public Boolean getFtoken() {
	return ftoken;
}

public void setFtoken(Boolean ftoken) {
	this.ftoken = ftoken;
}
 
}