/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importexport.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Ndiogou Samb
 */
@Entity
@Table(name = "user_roles")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
		@NamedQuery(name = "UserRoles.findByUserRoleId", query = "SELECT u FROM UserRoles u WHERE u.userRoleId = :userRoleId"),
		@NamedQuery(name = "UserRoles.findByRole", query = "SELECT u FROM UserRoles u WHERE u.role = :role") })
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_role_id")
	private Integer userRoleId;
	@Basic(optional = false)
	@Column(name = "role")
	private String role;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	@JsonIgnore
	private List<Utilisateur> utilisateurList;

	public UserRoles() {
	}

	public UserRoles(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserRoles(Integer userRoleId, String role) {
		this.userRoleId = userRoleId;
		this.role = role;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@XmlTransient
	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}

	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userRoleId != null ? userRoleId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserRoles)) {
			return false;
		}
		UserRoles other = (UserRoles) object;
		if ((this.userRoleId == null && other.userRoleId != null)
				|| (this.userRoleId != null && !this.userRoleId.equals(other.userRoleId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "importexport.model.UserRoles[ userRoleId=" + userRoleId + " ]";
	}

}
