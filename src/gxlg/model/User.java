package gxlg.model;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private String confirm;
	private String newpassword;
	private String newconfirm;
	private String email;
	private Date birthday;

	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getNewconfirm() {
		return newconfirm;
	}
	public void setNewconfirm(String newconfirm) {
		this.newconfirm = newconfirm;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(String username, String password, String confirm, String email, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.confirm = confirm;
		this.email = email;
		this.birthday = birthday;
	}
	public User(String username, String password, String confirm, String email) {
		super();
		this.username = username;
		this.password = password;
		this.confirm = confirm;
		this.email = email;
	}
	public User() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((confirm == null) ? 0 : confirm.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (confirm == null) {
			if (other.confirm != null)
				return false;
		} else if (!confirm.equals(other.confirm))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", confirm=" + confirm + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	
	
	
	
	

}
