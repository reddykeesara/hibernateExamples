package net.rag.hib;

import java.util.HashSet;
import java.util.Set;
 
public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
 
    Set<Group> groups = new HashSet<Group>();
 
    public User() {
    	
    }
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
 
    public void addGroup(Group group) {
        this.groups.add(group);
    }



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
 
    // setters and getters
}